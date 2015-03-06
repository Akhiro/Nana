/**
 * Tout droits r�serv�s. Copyright 2015 Seb&Lulu
 * @author Jean-Sebastien
 */
package com.nana.core.state;

import org.eclipse.jdt.annotation.NonNull;

public class BooleanState extends State<Boolean>{
	private Boolean _state;

	public BooleanState(@NonNull final Boolean state) {
		_state = state;
	}

	@Override
	public void setState(@NonNull final Boolean state) {
		if (_state != state) {
			_state = state;

			/** On notifie que l'etat a changé a tous les triggers **/
			stateChanged();
		}
	}

	@Override
	public boolean isValid(@NonNull final Boolean state) {
		return _state == state;
	}
}
