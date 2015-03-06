/**
 * Tout droits r�serv�s. Copyright 2015 Seb&Lulu
 * @author Jean-Sebastien
 */
package com.nana.core.state.tester;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.core.state.interfaces.IState;

public class BooleanStateTester extends StateTester<Boolean> {
	public BooleanStateTester(@NonNull final IState<Boolean> state) {
		super(state, true);
	}
}
