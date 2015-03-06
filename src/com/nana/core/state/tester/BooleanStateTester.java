/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 06 mars 2015
 */
package com.nana.core.state.tester;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.core.state.interfaces.IState;

public class BooleanStateTester extends StateTester<Boolean> {
	public BooleanStateTester(@NonNull final IState<Boolean> state) {
		super(state, true);
	}
}
