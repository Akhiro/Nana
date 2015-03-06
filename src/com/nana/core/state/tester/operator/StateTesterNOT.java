/**
 * Tout droits r�serv�s. Copyright 2015 Seb&Lulu
 * @author Jean-Sebastien
 */
package com.nana.core.state.tester.operator;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.core.state.interfaces.IStateTester;
import com.nana.core.trigger.StateChangedTrigger;

public class StateTesterNOT implements IStateTester {

	@NonNull private final IStateTester _stateTester;

	public StateTesterNOT(@NonNull final IStateTester stateTester) {
		_stateTester = stateTester;
	}

	@Override
	public boolean isValid() {
		return !_stateTester.isValid();
	}

	@Override
	public void register(@NonNull final StateChangedTrigger trigger) {
		_stateTester.register(trigger);
	}
}
