/*
* Copyright (c) 2015 - Seb&Lulu
* Author(s) : Lulu
* Date : 10 mars 2015
*/
package com.nana.api.karotz.functions;

import com.nana.api.APIResponseCodeEnum;
import com.nana.api.karotz.FunctionKarotz;

public class WakeUpKarotz extends FunctionKarotz {
	private final String _urlEars;
	private final String _wake = "wakeup?";
	private final String _sleep = "sleep";
	private final String _silent = "silent=";

	public WakeUpKarotz(final String beginUrl) {
		_urlEars=beginUrl;
	}

	public APIResponseCodeEnum wakeSilentKarotz() {
		return sendUrlKarotz(_urlEars + _wake + _silent + "1");
	}

	public APIResponseCodeEnum wakeSoundKarotz() {
		return sendUrlKarotz(_urlEars + _wake + _silent + "0");
	}

	public APIResponseCodeEnum sleepKarotz() {
		return sendUrlKarotz(_urlEars + _sleep);
	}
}
