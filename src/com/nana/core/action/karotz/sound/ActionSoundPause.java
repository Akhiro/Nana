/*
* Copyright (c) 2015 - Seb&Lulu
* Author(s) : Lulu
* Date : 15 mars 2015
*/
package com.nana.core.action.karotz.sound;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.api.interfaces.IAPIKarotz;
import com.nana.core.action.karotz.ActionKarotz;

public class ActionSoundPause extends ActionKarotz {

	public ActionSoundPause(@NonNull final IAPIKarotz api) {
		super(api);
	}

	@Override
	public void execute() {
		_api.pauseSoundKarotz();
	}

}
