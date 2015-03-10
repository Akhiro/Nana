/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 10 mars 2015
 */
package com.nana.core.validator.wrapper;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.core.state.interfaces.IState;
import com.nana.core.validator.Validator;

public class ValidatorString extends Validator<String> {
	public ValidatorString(@NonNull final IState<String> state, @NonNull final String value) {
		super(state, value);
	}
}
