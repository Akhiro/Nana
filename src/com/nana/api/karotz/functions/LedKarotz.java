/*
* Copyright (c) 2015 - Seb&Lulu
* Author(s) : Lulu
* Date : 9 mars 2015
*/
package com.nana.api.karotz.functions;

import com.nana.api.APIResponseCodeEnum;
import com.nana.api.karotz.FunctionKarotz;

public class LedKarotz extends FunctionKarotz {
	private final String _urlLed;
	private final String _command = "leds?";
	private final String _color = "color=";
	private final String _color2 = "color2=";
	private final String _pulse = "pulse=";
	private final String _speed = "speed=";
	private final String _noMemory = "no_memory=";


	public LedKarotz(final String beginUrl) {
		_urlLed = beginUrl + _command;
	}

	public APIResponseCodeEnum shutDownLed() {
		return sendUrlKarotz(_urlLed + _color + "000000");
	}

	public APIResponseCodeEnum fixedSavedLed(final String primaryColor) {
		return sendUrlKarotz(_urlLed + _color + primaryColor  +
										"&" + _noMemory + "0");
	}

	public APIResponseCodeEnum pulseOneColorSavedLed(final String primaryColor, final int speedPulse) {
		return sendUrlKarotz(_urlLed + _color + primaryColor +
										"&" + _pulse + "1" +
										"&" + _speed + formatSpeed(speedPulse) +
										"&" + _noMemory + "0");
	}

	public APIResponseCodeEnum pulseTwoColorSavedLed(final String primaryColor, final String secondColor, final int speedPulse) {
		return sendUrlKarotz(_urlLed + _color + primaryColor + "&" + _color2 + secondColor +
										"&" + _pulse + "1" +
										"&" + _speed + formatSpeed(speedPulse) +
										"&" + _noMemory + "0");
	}

	public APIResponseCodeEnum fixedTemporaryLed(final String primaryColor) {
		return sendUrlKarotz(_urlLed + _color + primaryColor  +
										"&" + _noMemory + "1");
	}

	public APIResponseCodeEnum pulseOneColorTemporaryLed(final String primaryColor, final int speedPulse) {
		return sendUrlKarotz(_urlLed + _color + primaryColor +
										"&" + _pulse + "1" +
										"&" + _speed + formatSpeed(speedPulse) +
										"&" + _noMemory + "1");
	}

	public APIResponseCodeEnum pulseTwoColorTemporaryLed(final String primaryColor, final String secondColor, final int speedPulse) {
		return sendUrlKarotz(_urlLed + _color + primaryColor + "&" + _color2 + secondColor +
										"&" + _pulse + "1" +
										"&" + _speed + formatSpeed(speedPulse) +
										"&" + _noMemory + "1");
	}

	private static String formatSpeed(final int speedPulse) {
		int speed = 0;
		String strSpeed;

		if (speedPulse < 0) {
			speed = 0;
		} else if (speedPulse > 2000) {
			speed = 2000;
		} else {
			speed = speedPulse;
		}

		strSpeed = Integer.toString(speed);

		return strSpeed;
	}
}
