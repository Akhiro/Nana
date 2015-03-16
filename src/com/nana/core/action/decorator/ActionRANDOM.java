/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 6 mars 2015
 */
package com.nana.core.action.decorator;

import java.util.Random;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.core.action.interfaces.IAction;

public class ActionRANDOM implements IAction {
	@NonNull private final IAction _action;
	private final int _minimumDelay;
	private final int _maximumDelay;

	public ActionRANDOM(@NonNull final IAction action, final int minimumDelay, final int maximumDelay) {
		_action = action;

		_minimumDelay = minimumDelay;
		_maximumDelay = maximumDelay;
	}

	@Override
	public void execute() {
		try {
			Random random = new Random();
			Thread.sleep((_minimumDelay + random.nextInt(_maximumDelay - _minimumDelay)) * 1000);
		} catch (InterruptedException e) {}

		_action.execute();
	}
}
