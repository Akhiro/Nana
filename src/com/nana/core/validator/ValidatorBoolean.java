/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 06 mars 2015
 */
package com.nana.core.validator;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.core.state.interfaces.IState;

public class ValidatorBoolean extends Validator<Boolean> {
	public ValidatorBoolean(@NonNull final IState<Boolean> state) {
		super(state, true);
	}
}
