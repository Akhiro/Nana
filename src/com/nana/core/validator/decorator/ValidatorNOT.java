/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 06 mars 2015
 */
package com.nana.core.validator.decorator;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.core.trigger.interfaces.ITrigger;
import com.nana.core.validator.interfaces.IValidator;

public class ValidatorNOT implements IValidator {

	@NonNull private final IValidator _validator;

	public ValidatorNOT(@NonNull final IValidator validator) {
		_validator = validator;
	}

	@Override
	public boolean isValid() {
		return !_validator.isValid();
	}

	@Override
	public void register(@NonNull final ITrigger trigger) {
		_validator.register(trigger);
	}
}
