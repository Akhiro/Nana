/**
 * Tout droits r�serv�s. Copyright 2015 Seb&Lulu
 * @author Jean-Sebastien
 */
package com.nana.core.trigger;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.core.state.interfaces.IStateTester;
import com.nana.core.trigger.interfaces.ITrigger;

public final class TriggerAND extends Trigger {
	private final ITrigger _trigger;
	private final IStateTester _stateTester;

	public TriggerAND(@NonNull final ITrigger trigger, final IStateTester stateTester) {
		_trigger = trigger;
		_stateTester = stateTester;

		/** On spécifie le parent du parametre **/
		_trigger.setExecutor(this);
	}

	@Override
	public void execute() {
		if (!_stateTester.isValid())
			return;

		super.execute();
	}
}
