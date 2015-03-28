/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 6 mars 2015
 */
package com.nana.core.action;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.api.interfaces.IAPI;
import com.nana.core.action.interfaces.IAction;
import com.nana.core.state.interfaces.IState;

public abstract class ActionChangeStateWithApi<T, A extends IAPI> implements IAction {
	@NonNull private final IState<T> _state;
	@NonNull protected final A _api;

	public ActionChangeStateWithApi(@NonNull final IState<T> state, @NonNull final A api ) {

		_state = state;
		_api = api;
	}

	protected abstract @NonNull T getValue();

	@Override
	public void execute() {
		_state.setState(getValue());
	}
}
