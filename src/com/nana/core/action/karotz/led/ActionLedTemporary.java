/*
* Copyright (c) 2015 - Seb&Lulu
* Author(s) : Lulu
* Date : 15 mars 2015
*/
package com.nana.core.action.karotz.led;

import com.nana.api.interfaces.IAPIKarotz;
import com.nana.core.action.karotz.ActionKarotz;

public class ActionLedTemporary extends ActionKarotz {

	private String _primaryColor;
	private String _secondColor;
	private Integer _speedPulse;

	public ActionLedTemporary(final IAPIKarotz api) {
		super(api);
	}

	public ActionLedTemporary(final IAPIKarotz api, final String primaryColor) {
		super(api);
		_primaryColor = primaryColor;
	}

	public ActionLedTemporary(final IAPIKarotz api, final String primaryColor, final int speedPulse) {
		super(api);
		_primaryColor = primaryColor;
		_speedPulse = speedPulse;
	}

	public ActionLedTemporary(final IAPIKarotz api, final String primaryColor, final String secondColor, final int speedPulse) {
		super(api);
		_primaryColor = primaryColor;
		_secondColor = secondColor;
		_speedPulse = speedPulse;
	}


	@Override
	public void execute() {
		if (_secondColor != null) {
			_api.pulseTwoColorTemporaryLed(_primaryColor, _secondColor, _speedPulse);
		}
		else if (_speedPulse != null) {
			_api.pulseOneColorTemporaryLed(_primaryColor, _speedPulse);
		}
		else {
			_api.fixedTemporaryLed(_primaryColor);
		}
	}
}
