/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 4 mars 2015
 */
package com.nana;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import com.nana.core.TriggerRegistererManager;

public class Nana {
	static final Logger logger = LogManager.getLogger(Nana.class.getName());

	public static void main(final String[] args) throws InterruptedException {
		try (AbstractXmlApplicationContext contextScheduler = new FileSystemXmlApplicationContext("conf/application/scheduler.xml")) {
			ThreadPoolTaskScheduler scheduler = contextScheduler.getBean(ThreadPoolTaskScheduler.class);
			if (scheduler != null) {
				TriggerRegistererManager.getInstance().setTaskScheduler(scheduler);
			} else {
				return;
			}

			try (AbstractXmlApplicationContext contextModules = new FileSystemXmlApplicationContext("conf/application/modules.xml")) {
				@SuppressWarnings("unchecked")
				List<String> modules = (List<String>) contextModules.getBean("modules");


				try (AbstractXmlApplicationContext ctx = new FileSystemXmlApplicationContext(modules.toArray(new String[modules.size()]))) {
					Thread.sleep(10000);
				}
			}
		}


	}
}
