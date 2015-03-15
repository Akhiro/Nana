/*
* Copyright (c) 2015 - Seb&Lulu
* Author(s) : Lulu
* Date : 15 mars 2015
*/
package com.nana.core.action.karotz.ears;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.api.interfaces.IAPIKarotz;
import com.nana.core.action.interfaces.IAction;

public class ActionEarsReset implements IAction {

	@NonNull private final IAPIKarotz _api;

	public ActionEarsReset(@NonNull final IAPIKarotz api) {
		_api = api;
	}

	@Override
	public void execute() {
		_api.resetEarsPosition();
	}

}
