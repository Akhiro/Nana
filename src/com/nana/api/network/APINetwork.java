/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 28 mars 2015
 */
package com.nana.api.network;

import java.io.IOException;
import java.net.InetAddress;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.api.APIResponseCodeEnum;
import com.nana.api.interfaces.IAPIPing;

public class APINetwork implements IAPIPing {

	private final int _timeout;

	public APINetwork(final int timeout) {
		_timeout = timeout;
	}

	@Override
	public @NonNull APIResponseCodeEnum ping(@NonNull final String address) {
		APIResponseCodeEnum status = APIResponseCodeEnum.TIMEOUT;
		try {
			if (InetAddress.getByName(address).isReachable(_timeout)) {
				status = APIResponseCodeEnum.SUCCESS;
			}
		} catch (IOException e) {
			status = APIResponseCodeEnum.ERROR;
		}
		return status;
	}
}
