/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 06 mars 2015
 */
package com.nana.core.trigger.interfaces;

import com.nana.utils.pattern.observer.IObservable;
import com.nana.utils.pattern.observer.IObserver;

public interface ITrigger extends IObserver, IObservable<IObserver> {
}
