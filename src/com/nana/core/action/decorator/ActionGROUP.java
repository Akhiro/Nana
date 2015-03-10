/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 6 mars 2015
 */
package com.nana.core.action.decorator;

import java.util.Arrays;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.core.action.interfaces.IAction;

public class ActionGROUP implements IAction {
	@NonNull private final IAction[] _actions;

	public ActionGROUP(@NonNull final IAction ... actions) {
		_actions = actions;
	}

	@Override
	public void execute() {
		Arrays.stream(_actions).forEach(action -> action.execute());
	}

}
