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
import com.nana.core.trigger.interfaces.ITrigger;

public abstract class State<T> implements IState<T> {

	private final List<ITrigger> _triggers = new ArrayList<ITrigger>();

	public State() {
		super();
	}

	@Override
	public void register(@NonNull final ITrigger trigger) {
		if (_triggers.contains(trigger)) {
			return;
		}

		_triggers.add(trigger);
	}

	/** Si l'état a changé, on previent tous les triggers qui leurs sont attaché **/
	@Override
	public void notifyObservers() {
		_triggers.stream().forEach(trigger -> trigger.notif());
	}
}
