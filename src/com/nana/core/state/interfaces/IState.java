/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 06 mars 2015
 */
package com.nana.core.state.interfaces;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.core.trigger.interfaces.ITrigger;
import com.nana.utils.pattern.observer.IObservable;

public interface IState<T> extends IObservable<ITrigger> {
	public void setState(@NonNull final T value);
	public boolean isValid(@NonNull final T value);
	public boolean isAssignableFrom(final Class<?> clazz);
}
