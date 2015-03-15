/*
* Copyright (c) 2015 - Seb&Lulu
* Author(s) : Lulu
* Date : 15 mars 2015
*/
package com.nana.core.action.karotz.led;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.api.interfaces.IAPIKarotz;
import com.nana.core.action.karotz.ActionKarotz;

public class ActionLedShutDown extends ActionKarotz {
	public ActionLedShutDown(@NonNull final IAPIKarotz api) {
		super(api);
	}

	@Override
	public void execute() {
		_api.shutDownLed();
	}
}
