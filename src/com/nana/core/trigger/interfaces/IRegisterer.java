/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 06 mars 2015
 */
package com.nana.core.trigger.interfaces;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.core.trigger.Trigger;

public interface IRegisterer<T extends Trigger> {
	public void register(@NonNull final T trigger);
}
