/*
* Copyright (c) 2015 - Seb&Lulu
* Author(s) : Lulu
* Date : 28 mars 2015
*/
package com.nana.core.generator;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.core.generator.interfaces.IGenerator;
import com.nana.core.state.interfaces.IState;

public class GeneratorAtmo implements IGenerator {
	@NonNull final IState<Integer> _stateAtmo;

	public GeneratorAtmo(@NonNull final IState<Integer> stateAtmo) {
		_stateAtmo = stateAtmo;
	}

	@Override
	public @NonNull String generate() {
		String message;
		int iAtmo = _stateAtmo.getState();
		String joke = "";

		String atmo = Integer.toString(iAtmo);
		if (iAtmo <= 5) {
			joke = "Je vais pouvoir respirer à plein poumon toute la journée !";
		} else {
			joke = "Oulala, vous n'auriez pas un masque pour moi par hasard ?";
		}

		message = "L'indice atmo du jour est de " + atmo + ". " + joke;

		return message;
	}

}
