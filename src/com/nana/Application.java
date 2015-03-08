/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 7 mars 2015
 */
package com.nana;

import java.util.HashMap;

import org.springframework.context.support.AbstractXmlApplicationContext;

public class Application implements Runnable {
	private static final String SCHEDULER_CONFIGURATION_FILE_PATH = "conf/application/scheduler.xml";
	private static final String COMMON_CONFIGURATION_FILE_PATH    = "conf/application/common.xml"; //Fichier non chargé par le code, mais doit etre check quand même pour le reboot de l'appli
	private static final String MODULES_CONFIGURATION_FILE_PATH   = "conf/application/modules.xml";

	private AbstractXmlApplicationContext _schedulerContext;
	private AbstractXmlApplicationContext _modulesListContext;
	private AbstractXmlApplicationContext _modulesContext;

	private final HashMap<String, String> _MD5ByFileMap = new HashMap<String, String>();

	public Application() {
	}

	@Override
	public void run() {

	}

}
