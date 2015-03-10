/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 10 mars 2015
 */
package com.nana.core.action.wrapper;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.core.action.ActionChangeState;
import com.nana.core.state.interfaces.IState;

public class ActionChangeStateInteger extends ActionChangeState<Integer>{
	public ActionChangeStateInteger(@NonNull final IState<Integer> state, @NonNull final Integer value) {
		super(state, value);
	}
}
