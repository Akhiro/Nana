/*
* Copyright (c) 2015 - Seb&Lulu
* Author(s) : Lulu
* Date : 15 mars 2015
*/
package com.nana.core.action.karotz.hour;

import com.nana.api.interfaces.IAPIKarotz;
import com.nana.core.action.karotz.ActionKarotz;

public class ActionHour extends ActionKarotz {

	private Integer _hour;

	public ActionHour(final IAPIKarotz api) {
		super(api);
	}

	public ActionHour(final IAPIKarotz api, final int hour) {
		super(api);
		_hour = hour;
	}

	@Override
	public void execute() {
		if (_hour != null) {
			_api.chosenHourKarotz(_hour);
		} else {
			_api.currentHourKarotz();
		}
	}


}
