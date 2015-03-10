package com.nana.api.interfaces;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.api.APIResponseCodeEnum;

public interface IAPISendMessage {
	public APIResponseCodeEnum sendMessage(@NonNull final String message);
}
