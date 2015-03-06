/**
 * Tout droits réservés. Copyright 2015 Seb&Lulu
 * @author Jean-Sebastien
 */
package com.nana.core.trigger.interfaces;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.core.task.interfaces.IExecutor;

public interface ITrigger extends IExecutor {
	public void setExecutor(@NonNull final IExecutor parent);
}
