package com.nana.api.karotz;

import com.nana.api.interfaces.IAPIReturns;
import com.nana.api.interfaces.IAPISendMessage;

public interface IAPIKarotz extends IAPISendMessage {
	public IAPIReturns enableEars();

	public IAPIReturns disableEars();

	public IAPIReturns resetPositionEars();

	public IAPIReturns randomPositionEars();

	public IAPIReturns moveEars(final int leftPosition, final int rightPosition);

	public IAPIReturns shutDownLed();

	public IAPIReturns fixedSavedLed(final String primaryColor);

	public IAPIReturns pulseOneColorSavedLed(final String primaryColor, final int speedPulse);

	public IAPIReturns pulseTwoColorSavedLed(final String primaryColor, final String secondColor, final int speedPulse);

	public IAPIReturns fixedTemporaryLed(final String primaryColor);

	public IAPIReturns pulseOneColorTemporaryLed(final String primaryColor, final int speedPulse);

	public IAPIReturns pulseTwoColorTemporaryLed(final String primaryColor, final String secondColor, final int speedPulse);
}
