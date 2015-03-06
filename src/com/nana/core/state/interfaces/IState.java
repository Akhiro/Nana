/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 06 mars 2015
 */
package com.nana.core.state.interfaces;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.core.trigger.StateChangedTrigger;
import com.nana.core.trigger.interfaces.IRegisterer;

public interface IState<T> extends IRegisterer<StateChangedTrigger> {
	public void setState(@NonNull final T state);
	public boolean isValid(@NonNull final T state);
}
