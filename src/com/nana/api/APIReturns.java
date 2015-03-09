/*
* Copyright (c) 2015 - Seb&Lulu
* Author(s) : Lulu
* Date : 8 mars 2015
*/
package com.nana.api;

import com.nana.api.interfaces.IAPIReturns;

public class APIReturns implements IAPIReturns {

	private final ResponseCodeEnum _rCodeEnum;

	public APIReturns(final ResponseCodeEnum rCodeEnum) {
		_rCodeEnum = rCodeEnum;
	}

	@Override
	public ResponseCodeEnum getResponseCode() {
		return _rCodeEnum;
	}

}
