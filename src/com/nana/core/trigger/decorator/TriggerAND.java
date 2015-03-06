/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 06 mars 2015
 */
package com.nana.core.trigger.decorator;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.core.trigger.Trigger;
import com.nana.core.trigger.interfaces.ITrigger;
import com.nana.core.validator.interfaces.IValidator;

public final class TriggerAND extends Trigger {
	private final ITrigger _trigger;
	private final IValidator _validator;

	public TriggerAND(@NonNull final ITrigger trigger, final IValidator validator) {
		_trigger = trigger;
		_validator = validator;

		/** On spécifie le parent du parametre **/
		_trigger.setExecutor(this);
	}

	@Override
	public void execute() {
		if (!_validator.isValid()) {
			return;
		}

		super.execute();
	}
}
