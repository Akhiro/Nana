/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 7 mars 2015
 */
package com.nana.core.manager;

import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.jdt.annotation.NonNull;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;

import com.nana.core.server.http.HTTPHandler;
import com.nana.core.server.http.HTTPServer;
import com.nana.core.trigger.TriggerHTTP;
import com.nana.core.trigger.TriggerState;
import com.nana.core.trigger.TriggerTime;
import com.nana.core.validator.interfaces.IValidator;

public class TriggerRegistererManager {
	//SINGLETON
	private static class TriggerRegistererManagerHolder {
		public static final TriggerRegistererManager INSTANCE = new TriggerRegistererManager();
	}

	public static TriggerRegistererManager getInstance() {
		return TriggerRegistererManagerHolder.INSTANCE;
	}

	// LOGGER
	static final Logger logger = LogManager.getLogger(TriggerRegistererManager.class.getName());

	private ThreadPoolTaskScheduler _taskScheduler;
	private HTTPServer _HTTPServer;

	private TriggerRegistererManager() {
	}

	/** Ajout des element que le Trigger Manager a besoin pour fonctionner **/
	public void setTaskScheduler(final ThreadPoolTaskScheduler taskScheduler) {
		_taskScheduler = taskScheduler;
	}

	public void setHTTPServer(final HTTPServer HTTPServer) {
		_HTTPServer = HTTPServer;
	}

	/** Trigger State Registering **/
	public void register(@NonNull final TriggerState trigger, @NonNull final IValidator validator) {
		validator.register(trigger);
//		logger.info("Registering : " + trigger.getClass().getSimpleName() + " on " + validator.getClass().getSimpleName());
	}

	/** Trigger Time Registering **/
	public void register(@NonNull final TriggerTime trigger, @NonNull final String cron) {
		if (_taskScheduler != null) {
			_taskScheduler.schedule(() -> trigger.notif(), new CronTrigger(cron));
			logger.info("Registering : " + trigger.getClass().getSimpleName() + " on CRON@(" + cron + ")");
		} else {
			logger.error("/!\\ Pas de Scheduler disponnible pour enregister le " + trigger.getClass().getSimpleName());
		}
	}

	public void register(@NonNull final TriggerTime trigger, final long period) {
		if (_taskScheduler != null) {
			_taskScheduler.scheduleAtFixedRate(() -> trigger.notif(), new Date(System.currentTimeMillis() + 1000), period);
			logger.info("Registering : " + trigger.getClass().getSimpleName() + " on REFRESH@(" + period + "ms)");
		} else {
			logger.error("/!\\ Pas de Scheduler disponnible pour enregister le " + trigger.getClass().getSimpleName());
		}
	}

	/** Trigger HTTP Registering **/
	public void register(@NonNull final TriggerHTTP trigger, @NonNull final String adress) {
		if (_HTTPServer != null) {
			_HTTPServer.addContext(adress, new HTTPHandler(trigger));
			logger.info("Registering : " + trigger.getClass().getSimpleName() + " on ADRESS@(IP" + adress + ")");
		} else {
			logger.error("/!\\ Pas de HTTPServer disponnible pour enregister le " + trigger.getClass().getSimpleName());
		}
	}

}
