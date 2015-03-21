/*
* Copyright (c) 2015 - Seb&Lulu
* Author(s) : Lulu
* Date : 21 mars 2015
*/
package com.nana.core.action.karotz.weather;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.api.interfaces.IAPIKarotz;
import com.nana.api.weather.APIWeather;
import com.nana.core.action.karotz.ActionKarotz;

public class ActionAtmo extends ActionKarotz {

	public ActionAtmo(@NonNull final IAPIKarotz api) {
		super(api);
	}

	@Override
	public void execute() {
		String message;
		APIWeather apiW = new APIWeather();
		int iAtmo = apiW.getAtmo();
		String joke = "";

		String atmo = Integer.toString(iAtmo);
		if (iAtmo <= 5) {
			joke = "Je vais pouvoir respirer à plein poumon toute la journée !";
		} else {
			joke = "Oulala, vous n'auriez pas un masque pour moi par hasard ?";
		}

		message = "L'indice atmo du jour est de " + atmo + ". " + joke;

		_api.sendMessage(message);
	}

}
