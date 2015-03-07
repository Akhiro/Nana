/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 7 mars 2015
 */
package com.nana.core.action;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.jdt.annotation.NonNull;

import com.nana.core.action.interfaces.IAction;

public class ActionLog implements IAction {
	static final Logger logger = LogManager.getLogger(ActionLog.class.getName());

	@NonNull final String _log;

	public ActionLog(@NonNull final String log) {
		_log = log;
	}

	@Override
	public void execute() {
		logger.info(_log);
	}
}
