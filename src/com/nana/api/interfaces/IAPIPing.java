/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 28 mars 2015
 */
package com.nana.api.interfaces;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.api.APIResponseCodeEnum;

public interface IAPIPing extends IAPI {
	public @NonNull APIResponseCodeEnum ping(@NonNull final String address);
}
