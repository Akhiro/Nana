/*
* Copyright (c) 2015 - Seb&Lulu
* Author(s) : Lulu
* Date : 28 mars 2015
*/
package com.nana.core.generator;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.core.generator.interfaces.IGenerator;
import com.nana.core.state.interfaces.IState;

public class GeneratorTempHigh implements IGenerator {
	@NonNull final IState<Integer> _stateTempHigh;

	public GeneratorTempHigh(@NonNull final IState<Integer> stateTempHigh) {
		_stateTempHigh = stateTempHigh;
	}

	@Override
	public @NonNull String generate() {
		String message;
		int iTempHigh = _stateTempHigh.getState();
		String joke = "";

		String tempHigh = Integer.toString(iTempHigh);
		if (iTempHigh <= 0) {
			joke = "C'est pas comme ça que je vais me réchauffer." ;
		} else if (iTempHigh <= 17) {
			joke = "Quand est-ce que tu m'emmènes aux Maldives ?";
		}  else if (iTempHigh <= 22) {
			joke = "Il fait enfin aussi chaud dehors que dedans.";
		} else {
			joke = "Tu pourrais allumer le ventilateur s'il te plait ?";
		}

		message = "La température maximum sera de " + tempHigh + ". " + joke;

		return message;
	}

}
