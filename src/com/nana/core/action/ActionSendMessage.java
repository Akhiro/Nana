/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 8 mars 2015
 */
package com.nana.core.action;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.api.interfaces.IAPISendMessage;
import com.nana.core.action.interfaces.IAction;

public class ActionSendMessage implements IAction {
	@NonNull private final String _message;
	@NonNull private final IAPISendMessage _api;

	public ActionSendMessage(@NonNull final String message, @NonNull final IAPISendMessage api) {
		_message = message;
		_api = api;
	}

	@Override
	public void execute() {
		_api.sendMessage(_message);
	}

}
