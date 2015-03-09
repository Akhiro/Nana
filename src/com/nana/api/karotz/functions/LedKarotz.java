/*
* Copyright (c) 2015 - Seb&Lulu
* Author(s) : Lulu
* Date : 9 mars 2015
*/
package com.nana.api.karotz.functions;

import com.nana.api.karotz.BaseKarotz;

public class LedKarotz extends BaseKarotz {
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

	public void shutDownLed() {
		sendUrlKarotz(_urlLed + _color + "000000");
	}

	public void fixedSavedLed(final String primaryColor) {
		sendUrlKarotz(_urlLed + _color + primaryColor  +
										"&" + _noMemory + "0");
	}

	public void pulseOneColorSavedLed(final String primaryColor, final int speedPulse) {
		sendUrlKarotz(_urlLed + _color + primaryColor +
										"&" + _pulse + "1" +
										"&" + _speed + formatSpeed(speedPulse) +
										"&" + _noMemory + "0");
	}

	public void pulseTwoColorSavedLed(final String primaryColor, final String secondColor, final int speedPulse) {
		sendUrlKarotz(_urlLed + _color + primaryColor + "&" + _color2 + secondColor +
										"&" + _pulse + "1" +
										"&" + _speed + formatSpeed(speedPulse) +
										"&" + _noMemory + "0");
	}

	public void fixedTemporaryLed(final String primaryColor) {
		sendUrlKarotz(_urlLed + _color + primaryColor  +
										"&" + _noMemory + "1");
	}

	public void pulseOneColorTemporaryLed(final String primaryColor, final int speedPulse) {
		sendUrlKarotz(_urlLed + _color + primaryColor +
										"&" + _pulse + "1" +
										"&" + _speed + formatSpeed(speedPulse) +
										"&" + _noMemory + "1");
	}

	public void pulseTwoColorTemporaryLed(final String primaryColor, final String secondColor, final int speedPulse) {
		sendUrlKarotz(_urlLed + _color + primaryColor + "&" + _color2 + secondColor +
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
