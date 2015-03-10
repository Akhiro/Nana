/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 6 mars 2015
 */
package com.nana.core.action.decorator;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.core.action.interfaces.IAction;

public class ActionTHREAD implements IAction {
	@NonNull private final IAction _action;

	public ActionTHREAD(@NonNull final IAction action) {
		_action = action;
	}

	@Override
	public void execute() {
		new Thread(() -> _action.execute(), "NANA-ACTION-THREAD").start();
	}

}
