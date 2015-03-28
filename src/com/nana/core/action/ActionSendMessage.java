/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 8 mars 2015
 */
package com.nana.core.action;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.api.interfaces.IAPISendMessage;
import com.nana.core.action.interfaces.IAction;
import com.nana.core.generator.interfaces.IGenerator;

public class ActionSendMessage implements IAction {

	@NonNull private final IAPISendMessage _api;
	private String _message;
	private IGenerator _generator;

	public ActionSendMessage(@NonNull final IAPISendMessage api, @NonNull final String message) {
		_api = api;
		_message = message;
	}

	public ActionSendMessage(@NonNull final IAPISendMessage api, @NonNull final IGenerator generator) {
		_api = api;
		_generator = generator;
	}

	@Override
	public void execute() {
		if (_message == null) {
			_api.sendMessage(_generator.generate());
		} else {
			_api.sendMessage(_message);
		}
	}

}
