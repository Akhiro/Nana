/*
* Copyright (c) 2015 - Seb&Lulu
* Author(s) : Lulu
* Date : 15 mars 2015
*/
package com.nana.core.action.karotz.sound;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.api.interfaces.IAPIKarotz;
import com.nana.core.action.karotz.ActionKarotz;

public class ActionSoundSpecific extends ActionKarotz {

	private final String _sound;

	public ActionSoundSpecific(@NonNull final IAPIKarotz api, final String sound) {
		super(api);
		_sound = sound;
	}

	@Override
	public void execute() {
		_api.specificSoundKarotz(_sound);
	}

}
