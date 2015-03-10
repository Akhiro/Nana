/*
* Copyright (c) 2015 - Seb&Lulu
* Author(s) : Lulu
* Date : 10 mars 2015
*/
package com.nana.api.karotz.functions;

import com.nana.api.karotz.BaseKarotz;

public class MoodKarotz extends BaseKarotz {
	private final String _urlTTS;
	private final String _loc = "apps/";
	private final String _command = "moods";

	public MoodKarotz(final String beginUrl) {
		_urlTTS = beginUrl + _loc + _command;
	}

	public void randomMoodKarotz() {
		sendUrlKarotz(_urlTTS);
	}

	public void moodKarotz(final int mood) {
		String strMood = Integer.toString(mood % 21);
		if (mood == 0 % 21) {
			strMood = "11";
		}

		sendUrlKarotz(_urlTTS + "?id=" + strMood);
	}
}
