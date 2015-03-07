/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 06 mars 2015
 */
package com.nana.core.trigger;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.core.trigger.interfaces.ITrigger;
import com.nana.utils.pattern.observer.IObserver;

public abstract class Trigger implements ITrigger {
	private IObserver _parent;

	public Trigger() {
		super();
	}

	/** Set le parent pour faire remonter l'event d'execution **/
	@Override
	public final void register(@NonNull final IObserver parent) {
		_parent = parent;
	}

	/** On remonte l'information au parent (Un Trigger Parent ou la Task) **/
	@Override
	public final void notifyObservers() {
		_parent.notif();
	}

	/** Si la methode execute est Call, c'est que le trigger vient d'etre appelé.
	 * On remonte donc tous les parents jusqu'a arriver a la Task
	 */
	@Override
	public void notif() {
		notifyObservers();
	}
}
