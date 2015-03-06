/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 4 mars 2015
 */
package com.nana.test;

import com.nana.core.action.interfaces.IAction;
import com.nana.core.state.StateBoolean;
import com.nana.core.task.Task;
import com.nana.core.trigger.TriggerState;
import com.nana.core.trigger.TriggerTime;
import com.nana.core.trigger.decorator.TriggerOR;
import com.nana.core.trigger.interfaces.ITrigger;
import com.nana.core.validator.ValidatorBoolean;

public class Nana {
	public static void main(final String[] args) throws InterruptedException {
//		try (AbstractXmlApplicationContext ctx = new FileSystemXmlApplicationContext("conf/triggered-job-configuration.xml")) {
//			Thread.sleep(50000);
//		}

		StateBoolean CeliaIsConnected = new StateBoolean(false);
		StateBoolean SebIsConnected = new StateBoolean(false);
		StateBoolean AJoueLeMessage = new StateBoolean(false);

		new Task(
			new TriggerOR(
				new TriggerState(new ValidatorBoolean(CeliaIsConnected)),
				new TriggerState(new ValidatorBoolean(SebIsConnected))
			),
			new IAction() {
				@Override
				public void execute() {
					System.out.println("Quelqu'un vient de rentrer a la maison !!");
					AJoueLeMessage.setState(true);
				}
			}
		);

		ITrigger test = new TriggerTime();
		new Task(
			test,
			new IAction() {
				@Override
				public void execute() {
					System.out.println("Il est 8h !!");
				}
			}
		);

		CeliaIsConnected.setState(true);
		SebIsConnected.setState(true);
		CeliaIsConnected.setState(false);




	}
}
