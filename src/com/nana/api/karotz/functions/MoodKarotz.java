/*
* Copyright (c) 2015 - Seb&Lulu
* Author(s) : Lulu
* Date : 10 mars 2015
*/
package com.nana.api.karotz.functions;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.api.APIResponseCodeEnum;
import com.nana.api.karotz.FunctionKarotz;

public class MoodKarotz extends FunctionKarotz {
	@NonNull private final String _urlTTS;
	private final String _loc = "apps/";
	private final String _command = "moods";

	public MoodKarotz(final String beginUrl) {
		_urlTTS = beginUrl + _loc + _command;
	}

	public APIResponseCodeEnum randomMoodKarotz() {
		return sendUrlKarotz(_urlTTS);
	}

	public APIResponseCodeEnum moodKarotz(final int mood) {
		String strMood = Integer.toString(mood % 21);
		if (mood == 0 % 21) {
			strMood = "11";
		}

		return sendUrlKarotz(_urlTTS + "?id=" + strMood);
	}
}
