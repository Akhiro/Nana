/**
 * Tout droits r�serv�s. Copyright 2015 Seb&Lulu
 * @author Jean-Sebastien
 */
package com.nana.core.state.interfaces;

import com.nana.core.trigger.StateChangedTrigger;
import com.nana.core.trigger.interfaces.IRegisterer;

public interface IStateTester extends IRegisterer<StateChangedTrigger>{
	public boolean isValid();
}
