/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 10 mars 2015
 */
package com.nana.core.validator.wrapper;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.core.state.interfaces.IState;
import com.nana.core.validator.Validator;

public class ValidatorBoolean extends Validator<Boolean> {
	public ValidatorBoolean(@NonNull final IState<Boolean> state, @NonNull final Boolean value) {
		super(state, value);
	}
}
