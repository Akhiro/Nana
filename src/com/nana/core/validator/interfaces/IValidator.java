/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 06 mars 2015
 */
package com.nana.core.validator.interfaces;

import com.nana.core.trigger.TriggerState;
import com.nana.core.trigger.interfaces.IRegisterer;

public interface IValidator extends IRegisterer<TriggerState>{
	public boolean isValid();
}
