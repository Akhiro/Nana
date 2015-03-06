/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 06 mars 2015
 */
package com.nana.core.trigger.interfaces;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.core.task.interfaces.IExecutor;

public interface ITrigger extends IExecutor {
	public void setExecutor(@NonNull final IExecutor parent);
}
