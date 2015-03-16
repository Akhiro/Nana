/*
* Copyright (c) 2015 - Seb&Lulu
* Author(s) : Lulu
* Date : 15 mars 2015
*/
package com.nana.core.action.karotz.mood;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.api.interfaces.IAPIKarotz;
import com.nana.core.action.karotz.ActionKarotz;

public class ActionMood extends ActionKarotz {

	private Integer _mood;

	public ActionMood(@NonNull final IAPIKarotz api) {
		super(api);
	}

	public ActionMood(@NonNull final IAPIKarotz api, final int mood) {
		super(api);
		_mood = mood;
	}

	@Override
	public void execute() {
		if (_mood != null) {
			_api.moodKarotz(_mood);
		} else {
			_api.randomMoodKarotz();
		}
	}

}
