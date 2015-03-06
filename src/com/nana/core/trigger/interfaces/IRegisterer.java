/*
 * Copyright (c) 2006-2014 - Ankama Games
 * Author(s) : jsdidierlaurent
 * Date : 6 mars 2015
 */
package com.nana.core.trigger.interfaces;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.core.trigger.Trigger;

public interface IRegisterer<T extends Trigger> {
	public void register(@NonNull final T trigger);
}
