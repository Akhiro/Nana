/*
* Copyright (c) 2015 - Seb&Lulu
* Author(s) : Lulu
* Date : 28 mars 2015
*/
package com.nana.core.generator;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.core.generator.interfaces.IGenerator;
import com.nana.core.state.interfaces.IState;

public class GeneratorTempLow implements IGenerator {
	@NonNull final IState<Integer> _stateTempLow;

	public GeneratorTempLow(@NonNull final IState<Integer> stateTempLow) {
		_stateTempLow = stateTempLow;
	}

	@Override
	public @NonNull String generate() {
		String message;
		int iTempLow = _stateTempLow.getState();
		String joke = "";

		String tempLow = Integer.toString(iTempLow);
		if (iTempLow <= 0) {
			joke = "Euh, je pourrais porter un bonnet aujourd'hui ?" ;
		} else if (iTempLow <= 12) {
			joke = "Oh regarde, je fais de la fumée avec ma bouche !!";
		} else {
			joke = "Ca sent les fleurs et les carottes !!";
		}

		message = "La température minimum est de " + tempLow + ". " + joke;

		return message;
	}

}
