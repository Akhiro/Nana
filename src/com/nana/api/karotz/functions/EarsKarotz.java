/*
* Copyright (c) 2015 - Seb&Lulu
* Author(s) : Lulu
* Date : 9 mars 2015
*/
package com.nana.api.karotz.functions;

import com.nana.api.karotz.BaseKarotz;

public class EarsKarotz extends BaseKarotz {
	private final String _urlEars;
	private final String _commandSystem = "ears_mode?";
	private final String _commandEars = "ears?";
	private final String _disable = "disable=";
	private final String _reset = "ears_reset";
	private final String _random = "ears_random";
	private final String _left = "left=";
	private final String _right = "right=";

	public EarsKarotz(final String beginUrl) {
		_urlEars=beginUrl;
	}

	public void enableEars() {
		sendUrlKarotz(_urlEars + _commandSystem + _disable + "0&_=1425934323506");
	}

	public void disableEars() {
		sendUrlKarotz(_urlEars + _commandSystem + _disable + "1&_=1425934323506");
	}

	public void resetPositionEars() {
		sendUrlKarotz(_urlEars + _reset);
	}

	public void randomPositionEars() {
		sendUrlKarotz(_urlEars + _random);
	}

	public void moveEars(final int leftPosition, final int rightPosition) {
		String strLeft = Integer.toString(leftPosition % 17);
		String strRight = Integer.toString(rightPosition % 17);

		sendUrlKarotz(_urlEars + _commandEars + _left + strLeft + "&" + _right + strRight);
	}
}
