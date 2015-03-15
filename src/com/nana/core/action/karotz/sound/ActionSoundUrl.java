/*
* Copyright (c) 2015 - Seb&Lulu
* Author(s) : Lulu
* Date : 15 mars 2015
*/
package com.nana.core.action.karotz.sound;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.api.interfaces.IAPIKarotz;
import com.nana.core.action.karotz.ActionKarotz;

public class ActionSoundUrl extends ActionKarotz {

	private final String _urlFile;

	public ActionSoundUrl(@NonNull final IAPIKarotz api, final String urlFile) {
		super(api);
		_urlFile = urlFile;
	}

	@Override
	public void execute() {
		_api.urlSoundKarotz(_urlFile);
	}

}
