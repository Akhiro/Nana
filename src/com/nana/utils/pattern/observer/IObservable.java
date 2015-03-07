/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 7 mars 2015
 */
package com.nana.utils.pattern.observer;

import org.eclipse.jdt.annotation.NonNull;

public interface IObservable<T extends IObserver> {
	public void register(@NonNull final T observer);
	public void notifyObservers();
}
