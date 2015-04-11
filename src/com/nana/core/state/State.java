/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 06 mars 2015
 */
package com.nana.core.state;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.jdt.annotation.NonNull;

import com.nana.core.state.interfaces.IState;
import com.nana.core.trigger.interfaces.ITrigger;

public class State<T> implements IState<T> {
	static final Logger logger = LogManager.getLogger(State.class.getName());

	@NonNull private T _state;
	private final List<ITrigger> _triggers = new ArrayList<ITrigger>();

	public State(@NonNull final T value) {
		_state = value;
	}

	@Override
	public @NonNull T getState() {
		return _state;
	}

	@Override
	public void setState(@NonNull final T value) {
		if (!_state.equals(value)) {
			_state = value;

			/** On notifie que l'état a changé à tous les triggers **/
			logger.info("Changement du : " + this.getClass().getSimpleName() + " Value : " + value);
			notifyObservers();
		}
	}

	@Override
	public boolean isValid(@NonNull final T value) {
		return _state.equals(value);
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

	@Override
	public boolean isAssignableFrom(final Class<?> clazz) {
		return _state.getClass().isAssignableFrom(clazz);
	}

}
