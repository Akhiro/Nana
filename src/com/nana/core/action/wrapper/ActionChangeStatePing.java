/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 28 mars 2015
 */
package com.nana.core.action.wrapper;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.api.APIResponseCodeEnum;
import com.nana.api.interfaces.IAPIPing;
import com.nana.core.action.ActionChangeStateWithApi;
import com.nana.core.state.interfaces.IState;

public class ActionChangeStatePing extends ActionChangeStateWithApi<Boolean, IAPIPing>{
	@NonNull private final String _adress;

	public ActionChangeStatePing(@NonNull final IState<Boolean> state, @NonNull final IAPIPing api, @NonNull final String adress) {
		super(state, api);

		_adress = adress;
	}

	@Override
	protected @NonNull Boolean getValue() {
		return (_api.ping(_adress) == APIResponseCodeEnum.SUCCESS) ? true : false;
	}
}
