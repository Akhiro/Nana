/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 10 mars 2015
 */
package com.nana.core.action.wrapper;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.api.interfaces.IAPIWeather;
import com.nana.core.action.ActionChangeStateWithApi;
import com.nana.core.state.interfaces.IState;

public class ActionChangeStateWindSpeed extends ActionChangeStateWithApi<Integer, IAPIWeather>{
	public ActionChangeStateWindSpeed(@NonNull final IState<Integer> state, @NonNull final IAPIWeather iApi) {
		super(state, iApi);
	}

	@Override
	protected @NonNull Integer getValue() {
		return _api.getWindSpeed();
	}
}
