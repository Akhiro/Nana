/**
 * Tout droits r�serv�s. Copyright 2015 Seb&Lulu
 * @author Jean-Sebastien
 */
package com.nana.core.trigger;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.core.task.interfaces.IExecutor;
import com.nana.core.trigger.interfaces.ITrigger;

public abstract class Trigger implements ITrigger {
	private IExecutor _parent;

	public Trigger() {
		super();
	}

	/** Set le parent pour faire remonter l'event d'execution **/
	@Override
	public final void setExecutor(@NonNull final IExecutor parent) {
		_parent = parent;
	}

	/** Si la methode execute est Call, c'est que le trigger vient d'etre appelé.
	 * On remonte donc tous les parents jusqu'a arriver a la Task
	 */
	@Override
	public void execute() {
		_parent.execute();
	}
}
