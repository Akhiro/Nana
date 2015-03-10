/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 10 mars 2015
 */
package com.nana.core.action.wrapper;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.core.action.ActionChangeState;
import com.nana.core.state.interfaces.IState;

public class ActionChangeStateString extends ActionChangeState<String>{
	public ActionChangeStateString(@NonNull final IState<String> state, @NonNull final String value) {
		super(state, value);
	}
}
