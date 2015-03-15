/*
* Copyright (c) 2015 - Seb&Lulu
* Author(s) : Lulu
* Date : 15 mars 2015
*/
package com.nana.core.action.karotz;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.api.interfaces.IAPIKarotz;
import com.nana.core.action.interfaces.IAction;

public abstract class ActionKarotz implements IAction {
	@NonNull protected final IAPIKarotz _api;

	public ActionKarotz(@NonNull final IAPIKarotz api) {
		_api = api;
	}
}
