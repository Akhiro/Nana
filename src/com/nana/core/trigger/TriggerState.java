/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 06 mars 2015
 */
package com.nana.core.trigger;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.core.manager.TriggerRegistererManager;
import com.nana.core.validator.interfaces.IValidator;

public class TriggerState extends Trigger {
	@NonNull private final IValidator _validator;

	public TriggerState(@NonNull final IValidator validator) {
		super();

		_validator = validator;

		/** On enregistre le trigger sur le state pour qu'il proc au changement d'état **/
		TriggerRegistererManager.getInstance().register(this, _validator);
	}

	@Override
	public void notif() {
		if (_validator.isValid()) {
			super.notif();
		}
	}
}
