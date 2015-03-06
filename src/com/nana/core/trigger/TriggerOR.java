/**
 * Tout droits r�serv�s. Copyright 2015 Seb&Lulu
 * @author Jean-Sebastien
 */
package com.nana.core.trigger;

import java.util.Arrays;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.core.trigger.interfaces.ITrigger;

public final class TriggerOR extends Trigger {
	@NonNull private final ITrigger[] _triggers;

	public TriggerOR(@NonNull final ITrigger ... triggers) {
		_triggers = triggers;

		/** On spécifie que le parent des parametres **/
		Arrays.stream(_triggers).forEach(trigger -> trigger.setExecutor(this));
	}
}
