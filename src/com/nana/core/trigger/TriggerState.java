/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 06 mars 2015
 */
package com.nana.core.trigger;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.core.validator.interfaces.IValidator;

public class TriggerState extends Trigger {

	@NonNull private final IValidator _validator;

	public TriggerState(@NonNull final IValidator validator) {
		super();

		_validator = validator;

		/** On enregirstre le trigger sur le state pour qu'il prioc au changement d'état **/
		_validator.register(this);
	}

	@Override
	public void execute() {
		if (_validator.isValid()) {
			super.execute();
		}
	}
}
