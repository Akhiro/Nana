/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 06 mars 2015
 */
package com.nana.core.state;

import org.eclipse.jdt.annotation.NonNull;

public class StateBoolean extends State<Boolean>{
	private Boolean _state;

	public StateBoolean(@NonNull final Boolean state) {
		_state = state;
	}

	@Override
	public void setState(@NonNull final Boolean state) {
		if (_state != state) {
			_state = state;

			/** On notifie que l'etat a changé a tous les triggers **/
			notifyObservers();
		}
	}

	@Override
	public boolean isValid(@NonNull final Boolean state) {
		return _state == state;
	}
}
