/**
 * Tout droits r�serv�s. Copyright 2015 Seb&Lulu
 * @author Jean-Sebastien
 */
package com.nana.core.state.tester;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.core.state.interfaces.IState;
import com.nana.core.state.interfaces.IStateTester;
import com.nana.core.trigger.StateChangedTrigger;

public abstract class StateTester<T> implements IStateTester {
	@NonNull private final IState<T> _state;
	@NonNull private final T _value;

	public StateTester(@NonNull final IState<T> state, @NonNull final T value) {
		_state = state;
		_value = value;
	}

	@Override
	public boolean isValid() {
		return _state.isValid(_value);
	}

	public IState<T> getState() {
		return _state;
	}

	@Override
	public void register(@NonNull final StateChangedTrigger trigger) {
		_state.register(trigger);
	}
}
