/**
 * Tout droits r�serv�s. Copyright 2015 Seb&Lulu
 * @author Jean-Sebastien
 */
package com.nana.core.state.tester.operator;

import java.util.Arrays;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.core.state.interfaces.IStateTester;
import com.nana.core.trigger.StateChangedTrigger;

public class StateTesterAND implements IStateTester {

	@NonNull private final IStateTester[] _stateTesters;

	public StateTesterAND(@NonNull final IStateTester ... stateTesters) {
		_stateTesters = stateTesters;
	}

	@Override
	public boolean isValid() {
		for (IStateTester stateTester : _stateTesters) {
			if (!stateTester.isValid())
				return false;
		}

		return true;
	}

	@Override
	public void register(@NonNull final StateChangedTrigger trigger) {
		Arrays.stream(_stateTesters).forEach(stateTester -> stateTester.register(trigger));
	}
}
