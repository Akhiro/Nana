/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 10 mars 2015
 */
package com.nana.core.validator.wrapper;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.core.state.interfaces.IState;
import com.nana.core.validator.Validator;

public class ValidatorInteger extends Validator<Integer> {
	public ValidatorInteger(@NonNull final IState<Integer> state, @NonNull final Integer value) {
		super(state, value);
	}
}
