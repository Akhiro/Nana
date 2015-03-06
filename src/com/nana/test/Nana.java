/*
 * Copyright (c) 2015 - Ankama Games
 * Author(s) : jsdidierlaurent
 * Date : 4 mars 2015
 */
package com.nana.test;

import com.nana.core.action.interfaces.IAction;
import com.nana.core.state.BooleanState;
import com.nana.core.state.tester.BooleanStateTester;
import com.nana.core.state.tester.operator.StateTesterNOT;
import com.nana.core.state.tester.operator.StateTesterOR;
import com.nana.core.task.Task;
import com.nana.core.trigger.StateChangedTrigger;
import com.nana.core.trigger.TimedTrigger;
import com.nana.core.trigger.TriggerAND;
import com.nana.core.trigger.interfaces.ITrigger;

public class Nana {
	public static void main(final String[] args) throws InterruptedException {
//		try (AbstractXmlApplicationContext ctx = new FileSystemXmlApplicationContext("conf/triggered-job-configuration.xml")) {
//			Thread.sleep(50000);
//		}


		BooleanState CeliaIsConnected = new BooleanState(false);
		BooleanState SebIsConnected = new BooleanState(false);
		BooleanState AJouerLeMessage = new BooleanState(false);

		new Task(
			new TriggerAND(
				new StateChangedTrigger( new StateTesterOR(
						new BooleanStateTester(CeliaIsConnected),
						new BooleanStateTester(SebIsConnected)
				)),
				new StateTesterNOT(new BooleanStateTester(AJouerLeMessage))
			),
			new IAction() {
				@Override
				public void execute() {
					System.out.println("Quelqu'un vient de rentrer a la maison !!");
					AJouerLeMessage.setState(true);
				}
			}
		);

		ITrigger test = new TimedTrigger();
		new Task(
			test,
			new IAction() {
				@Override
				public void execute() {
					System.out.println("Il est 8h !!");
					AJouerLeMessage.setState(true);
				}
			}
		);

		Thread.sleep(2000);
		CeliaIsConnected.setState(true);
		Thread.sleep(2000);
		CeliaIsConnected.setState(false);
		Thread.sleep(2000);
		CeliaIsConnected.setState(true);
		test.execute();
		AJouerLeMessage.setState(false);
		SebIsConnected.setState(true);



	}
}
