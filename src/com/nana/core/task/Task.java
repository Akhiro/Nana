/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 06 mars 2015
 */
package com.nana.core.task;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.core.action.interfaces.IAction;
import com.nana.core.task.interfaces.ITask;
import com.nana.core.trigger.interfaces.ITrigger;

public class Task implements ITask {
	@NonNull private final ITrigger _trigger;
	@NonNull private final IAction _action;

	public Task(@NonNull final ITrigger trigger, @NonNull final IAction action) {
		_trigger = trigger;
		_action = action;

		/** On sp�cifie le parent du paremetre **/
		_trigger.setExecutor(this);
	}

	@Override
	public void execute() {
		_action.execute();
	}
}
