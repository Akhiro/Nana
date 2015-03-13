/*
* Copyright (c) 2015 - Seb&Lulu
* Author(s) : Lulu
* Date : 12 mars 2015
*/
package com.nana.api.karotz.functions;

import com.nana.api.APIResponseCodeEnum;
import com.nana.api.karotz.FunctionKarotz;

public class SoundKarotz extends FunctionKarotz {
	private final String _urlSound;
	private final String _command = "sound?";
	private final String _control = "sound_control?cmd=";
	private final String _urlMp3 = "url=";

	public SoundKarotz(final String beginUrl) {
		_urlSound = beginUrl;
	}

	public APIResponseCodeEnum specificSoundKarotz(final String sound) {
		return sendUrlKarotz(_urlSound + _command + "id=" + sound);
	}

	public APIResponseCodeEnum urlSoundKarotz(final String urlFile) {
		return sendUrlKarotz(_urlSound + _command + _urlMp3 + urlFile);
	}

	public APIResponseCodeEnum pauseSoundKarotz() {
		return sendUrlKarotz(_urlSound + _control + "pause");
	}

	public APIResponseCodeEnum quitSoundKarotz() {
		return sendUrlKarotz(_urlSound + _control + "quit");
	}
}
