/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 06 mars 2015
 */
package com.nana.core.state;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.core.state.interfaces.IState;
import com.nana.core.trigger.StateChangedTrigger;

public abstract class State<T> implements IState<T> {

	private final List<StateChangedTrigger> _triggers = new ArrayList<StateChangedTrigger>();

	public State() {
		super();
	}

	@Override
	public void register(@NonNull final StateChangedTrigger trigger) {
		if (_triggers.contains(trigger)) {
			return;
		}

		_triggers.add(trigger);
	}

	/** Si l'état a changé, on previent tous les triggers qui leurs sont attaché **/
	protected void stateChanged(){
		_triggers.stream().forEach(trigger -> trigger.execute());
	}
}
