/*
* Copyright (c) 2015 - Seb&Lulu
* Author(s) : Lulu
* Date : 28 mars 2015
*/
package com.nana.core.generator;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.core.generator.interfaces.IGenerator;
import com.nana.core.state.interfaces.IState;

public class GeneratorWindSpeed implements IGenerator {
	@NonNull final IState<Integer> _stateWindSpeed;

	public GeneratorWindSpeed(@NonNull final IState<Integer> stateWindSpeed) {
		_stateWindSpeed = stateWindSpeed;
	}

	@Override
	public @NonNull String generate() {
		String message;
		int iWindSpeed = _stateWindSpeed.getState();
		String joke = "";

		String windSpeed = Integer.toString(iWindSpeed);
		if (iWindSpeed <= 4) {
			joke = "Tu sens quelque chose toi ?" ;
		} else if (iWindSpeed <= 10) {
			joke = "Bon je peux encore parler à mes copains avec le feu de camp.";
		}  else if (iWindSpeed <= 15) {
			joke = "Il y a un léger bruit dehors.";
		} else if (iWindSpeed <= 23) {
			joke = "Regarde regarde, les feuilles dansent !";
		} else if (iWindSpeed <= 30) {
			joke = "L'arbre essaie de danser je crois.";
		} else if (iWindSpeed <= 40) {
			joke = "Je crois que je ne mettrai pas de chapeau aujourd'hui.";
		} else if (iWindSpeed <= 50) {
			joke = "Tu crois qu'une branche peut assomer un lapin ?";
		} else if (iWindSpeed <= 60) {
			joke = "Grout. Je m'appelle Grout. Grout comprendre Grout ?";
		} else if (iWindSpeed <= 70) {
			joke = "Oh, les arbres ont des bobos. Allez hop, un pansement !";
		} else if (iWindSpeed <= 80) {
			joke = "Le Père Noël ne trouvera pas la maison si la cheminée s'envole..";
		} else if (iWindSpeed <= 90) {
			joke = "Je crois que les arbres subissent une guerre civile en ce moment.";
		} else if (iWindSpeed <= 115) {
			joke = "Comment quelque chose d'invisible peut faire autant de dégâts ?";
		} else {
			joke = "Je veux rentrer dans mon terrier.";
		}

		message = "Le vent soufflera à " + windSpeed + " kilomètres heure. " + joke;

		return message;
	}

}
