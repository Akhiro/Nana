/*
* Copyright (c) 2015 - Seb&Lulu
* Author(s) : Lulu
* Date : 15 mars 2015
*/
package com.nana.core.action.karotz.ears;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.api.interfaces.IAPIKarotz;
import com.nana.core.action.karotz.ActionKarotz;


public class ActionEarsMove extends ActionKarotz {

	private final int _left;
	private final int _right;

	public ActionEarsMove(@NonNull final IAPIKarotz api, final int left, final int right) {
		super(api);
		_left = left;
		_right = right;
	}

	@Override
	public void execute() {
		_api.moveEars(_left, _right);
	}

}
