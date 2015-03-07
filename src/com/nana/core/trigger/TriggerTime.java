/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 06 mars 2015
 */
package com.nana.core.trigger;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.core.TriggerRegistererManager;

public class TriggerTime extends Trigger {
	/** @param period Temps(ms) entre deux proc du Trigger **/
	public TriggerTime(final long period) {
		super();

		/** On enregistre le trigger pour qu'il se déclanche toute les X ms **/
		TriggerRegistererManager.getInstance().register(this, period);
	}

	/** @param cron see http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/scheduling/support/CronSequenceGenerator.html **/
	public TriggerTime(@NonNull final String cron) {
		super();

		/** On enregistre le trigger sur le state pour qu'il proc au changement d'état **/
		TriggerRegistererManager.getInstance().register(this, cron);
	}
}
