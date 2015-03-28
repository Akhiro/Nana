/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 6 mars 2015
 */
package com.nana.core.action;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.core.action.interfaces.IAction;
import com.nana.core.state.interfaces.IState;

public class ActionChangeState<T> implements IAction {
	@NonNull private final IState<T> _state;
	@NonNull private final T _value;

	public ActionChangeState(@NonNull final IState<T> state, @NonNull final T value ) {
		if (!state.isAssignableFrom(value.getClass())) {
			throw new ClassCastException("Impossible de créer un validator pour un " + state.getClass().getSimpleName() + " avec une valeur de " + value);
		}

		_state = state;
		_value = value;
	}

	@Override
	public void execute() {
		_state.setState(_value);
	}
}
