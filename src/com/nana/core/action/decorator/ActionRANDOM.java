/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 6 mars 2015
 */
package com.nana.core.action.decorator;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.core.action.interfaces.IAction;

public class ActionRANDOM implements IAction {
	@NonNull private final IAction[] _actions;

	public ActionRANDOM(@NonNull final IAction ... actions) {
		_actions = actions;
	}

	@Override
	public void execute() {
		_actions[(int)(Math.random() * _actions.length)].execute();
	}

}
