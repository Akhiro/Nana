/**
 * Tout droits r�serv�s. Copyright 2015 Seb&Lulu
 * @author Jean-Sebastien
 */
package com.nana.core.trigger;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.core.state.interfaces.IStateTester;

public class StateChangedTrigger extends Trigger {

	@NonNull private final IStateTester _stateTester;

	public StateChangedTrigger(@NonNull final IStateTester stateTester) {
		super();

		_stateTester = stateTester;

		/** On enregirstre le trigger sur le state pour qu'il prioc au changement d'état **/
		stateTester.register(this);
	}

	@Override
	public void execute() {
		if (_stateTester.isValid()) {
			super.execute();
		}
	}
}
