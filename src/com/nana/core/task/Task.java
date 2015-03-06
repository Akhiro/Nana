/**
 * Tout droits réservés. Copyright 2015 Seb&Lulu
 * @author Jean-Sebastien
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

		/** On spécifie le parent du paremetre **/
		_trigger.setExecutor(this);
	}

	@Override
	public void execute() {
		_action.execute();
	}
}
