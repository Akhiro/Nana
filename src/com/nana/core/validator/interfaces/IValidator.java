/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 06 mars 2015
 */
package com.nana.core.validator.interfaces;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.core.trigger.interfaces.ITrigger;

public interface IValidator {
	public boolean isValid();
	/** Sert de pont pour relier un Trigger et un State. Un validator n'est pas un Observable pour autant **/
	public void register(@NonNull final ITrigger trigger);
}
