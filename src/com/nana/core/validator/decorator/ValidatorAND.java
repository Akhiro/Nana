/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 06 mars 2015
 */
package com.nana.core.validator.decorator;

import java.util.Arrays;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.core.trigger.interfaces.ITrigger;
import com.nana.core.validator.interfaces.IValidator;

public class ValidatorAND implements IValidator {

	@NonNull private final IValidator[] _validators;

	public ValidatorAND(@NonNull final IValidator ... validators) {
		_validators = validators;
	}

	@Override
	public boolean isValid() {
		for (IValidator validator : _validators) {
			if (!validator.isValid()) {
				return false;
			}
		}

		return true;
	}

	@Override
	public void register(@NonNull final ITrigger trigger) {
		Arrays.stream(_validators).forEach(validator -> validator.register(trigger));
	}
}
