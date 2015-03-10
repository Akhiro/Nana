/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 10 mars 2015
 */
package com.nana.core.action.wrapper;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.core.action.ActionChangeState;
import com.nana.core.state.interfaces.IState;

public class ActionChangeStateBoolean extends ActionChangeState<Boolean>{
	public ActionChangeStateBoolean(@NonNull final IState<Boolean> state, @NonNull final Boolean value) {
		super(state, value);
	}
}
