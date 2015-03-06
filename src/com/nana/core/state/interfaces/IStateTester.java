/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 06 mars 2015
 */
package com.nana.core.state.interfaces;

import com.nana.core.trigger.StateChangedTrigger;
import com.nana.core.trigger.interfaces.IRegisterer;

public interface IStateTester extends IRegisterer<StateChangedTrigger>{
	public boolean isValid();
}
