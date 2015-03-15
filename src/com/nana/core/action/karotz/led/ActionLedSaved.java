/*
* Copyright (c) 2015 - Seb&Lulu
* Author(s) : Lulu
* Date : 15 mars 2015
*/
package com.nana.core.action.karotz.led;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.api.interfaces.IAPIKarotz;
import com.nana.core.action.karotz.ActionKarotz;

public class ActionLedSaved extends ActionKarotz {
	private String _primaryColor;
	private String _secondColor;
	private Integer _speedPulse;

	public ActionLedSaved(@NonNull final IAPIKarotz api) {
		super(api);
	}

	public ActionLedSaved(@NonNull final IAPIKarotz api, final String primaryColor) {
		super(api);
		_primaryColor = primaryColor;
	}

	public ActionLedSaved(@NonNull final IAPIKarotz api, final String primaryColor, final int speedPulse) {
		super(api);
		_primaryColor = primaryColor;
		_speedPulse = speedPulse;
	}

	public ActionLedSaved(@NonNull final IAPIKarotz api, final String primaryColor, final String secondColor, final int speedPulse) {
		super(api);
		_primaryColor = primaryColor;
		_secondColor = secondColor;
		_speedPulse = speedPulse;
	}


	@Override
	public void execute() {
		if (_secondColor != null) {
			_api.pulseTwoColorSavedLed(_primaryColor, _secondColor, _speedPulse);
		}
		else if (_speedPulse != null) {
			_api.pulseOneColorSavedLed(_primaryColor, _speedPulse);
		}
		else {
			_api.fixedSavedLed(_primaryColor);
		}
	}

}
