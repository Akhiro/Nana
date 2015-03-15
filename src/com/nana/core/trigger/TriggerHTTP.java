/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 06 mars 2015
 */
package com.nana.core.trigger;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.core.manager.TriggerRegistererManager;

public class TriggerHTTP extends Trigger {
	public TriggerHTTP(@NonNull final String adress) {
		super();

		TriggerRegistererManager.getInstance().register(this, adress);
	}
}
