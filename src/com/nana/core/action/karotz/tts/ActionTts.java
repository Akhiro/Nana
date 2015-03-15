/*
* Copyright (c) 2015 - Seb&Lulu
* Author(s) : Lulu
* Date : 15 mars 2015
*/
package com.nana.core.action.karotz.tts;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.api.interfaces.IAPIKarotz;
import com.nana.core.action.karotz.ActionKarotz;

public class ActionTts extends ActionKarotz {

	private final String _message;
	private final Integer _noCache;
	private final Integer _mute;

	public ActionTts(@NonNull final IAPIKarotz api, final String message, final int noCache, final int mute) {
		super(api);
		_message = message;
		_noCache = noCache;
		_mute = mute;
	}

	@Override
	public void execute() {
		if (_message != null && _noCache != null && _mute != null) {
			_api.sendMessageTTS(_message, _noCache, _mute);
		} else {
			_api.clearCacheTTS();
		}
	}

}
