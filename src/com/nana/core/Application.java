/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 7 mars 2015
 */
package com.nana.core;

import java.io.IOException;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import com.nana.core.manager.TriggerRegistererManager;
import com.nana.utils.FileUtils;

public class Application extends Thread {
	static final Logger logger = LogManager.getLogger(Application.class.getName());

	private static final String SCHEDULER_CONFIGURATION_FILE_PATH = "conf/application/scheduler.xml";
	private static final String COMMON_CONFIGURATION_FILE_PATH    = "conf/application/common.xml"; //Fichier non chargé par le code, mais doit etre check quand même pour le reboot de l'appli
	private static final String MODULES_CONFIGURATION_FILE_PATH   = "conf/application/modules.xml";

	private AbstractXmlApplicationContext _schedulerContext;
	private AbstractXmlApplicationContext _modulesListContext;
	private AbstractXmlApplicationContext _modulesContext;

	private ThreadPoolTaskScheduler _scheduler;

	private final HashMap<String, String> _MD5ByFileMap = new HashMap<String, String>();

	public Application() {
		super("NANA-APPLICATION-THREAD");
	}

	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		boolean run = true;
		boolean isStarted = false;

		try {
			while (run) {
				if (!isStarted || needConfigurationReload()) {
					if (isStarted) {
						cleanConfiguration();
					}

					try {
						/** Chargement du contexte de gestion des Thread **/
						logger.info("Chargement du fichier de configuration du scheduler : " + SCHEDULER_CONFIGURATION_FILE_PATH);
						_schedulerContext = new FileSystemXmlApplicationContext(SCHEDULER_CONFIGURATION_FILE_PATH);
						addConfigurationFileMD5(SCHEDULER_CONFIGURATION_FILE_PATH);

						/** Chargement du contexte contenant la listes des modules **/
						logger.info("Chargement du fichier de configuration des modules : " + MODULES_CONFIGURATION_FILE_PATH);
						_modulesListContext = new FileSystemXmlApplicationContext(MODULES_CONFIGURATION_FILE_PATH);
						addConfigurationFileMD5(MODULES_CONFIGURATION_FILE_PATH);

						/** On passe aux managers les infos qu'ils ont besoin **/
						_scheduler = _schedulerContext.getBean(ThreadPoolTaskScheduler.class);
						TriggerRegistererManager.getInstance().setTaskScheduler(_scheduler);

						/** On charge la list des modules et on les charges a la suite **/
						List<String> modulesReady = new ArrayList<String>();
						for (String module : (List<String>) _modulesListContext.getBean("modules")) {
							logger.info("Chargement du fichier de configuration du module : " + module);
							if (Paths.get(module).toFile().exists()) {
								modulesReady.add(module);
								addConfigurationFileMD5(module);
							} else {
								logger.error(" - Chargement du module impossible, le fichier n'existe pas : " + module);
							}
						}
						_modulesContext = new FileSystemXmlApplicationContext(modulesReady.toArray(new String[modulesReady.size()]));

						addConfigurationFileMD5(COMMON_CONFIGURATION_FILE_PATH);

						isStarted = true;
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				Thread.sleep(5000);

			}
		} catch (InterruptedException | NoSuchAlgorithmException | IOException e) {
			e.printStackTrace();
		}
	}

	/** Check si les 3 fichiers principaux ont changé. Si oui je recharge tout, si non je check si les autres fichiers chargés dynamiquement ont changé. **/
	private boolean needConfigurationReload() throws NoSuchAlgorithmException, IOException {
		for (String key : _MD5ByFileMap.keySet()) {
			if (!FileUtils.compareMD5(key, _MD5ByFileMap.get(key))){
				return true;
			}
		}

		return false;
	}

	private void addConfigurationFileMD5(final String path) throws NoSuchAlgorithmException, IOException {
		_MD5ByFileMap.put(path, FileUtils.getMD5(path));
	}

	private void cleanConfiguration() {
		_schedulerContext.stop();
		_modulesListContext.stop();
		_modulesContext.stop();

		_scheduler.shutdown();
	}

}
