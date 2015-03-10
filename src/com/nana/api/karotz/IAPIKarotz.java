package com.nana.api.karotz;

import com.nana.api.APIResponseCodeEnum;
import com.nana.api.interfaces.IAPISendMessage;

public interface IAPIKarotz extends IAPISendMessage {
	public APIResponseCodeEnum enableEars();

	public APIResponseCodeEnum disableEars();

	public APIResponseCodeEnum resetPositionEars();

	public APIResponseCodeEnum randomPositionEars();

	public APIResponseCodeEnum moveEars(final int leftPosition, final int rightPosition);

	public APIResponseCodeEnum shutDownLed();

	public APIResponseCodeEnum fixedSavedLed(final String primaryColor);

	public APIResponseCodeEnum pulseOneColorSavedLed(final String primaryColor, final int speedPulse);

	public APIResponseCodeEnum pulseTwoColorSavedLed(final String primaryColor, final String secondColor, final int speedPulse);

	public APIResponseCodeEnum fixedTemporaryLed(final String primaryColor);

	public APIResponseCodeEnum pulseOneColorTemporaryLed(final String primaryColor, final int speedPulse);

	public APIResponseCodeEnum pulseTwoColorTemporaryLed(final String primaryColor, final String secondColor, final int speedPulse);

	public APIResponseCodeEnum wakeSilentKarotz();

	public APIResponseCodeEnum wakeSoundKarotz();

	public APIResponseCodeEnum sleepKarotz();

	public APIResponseCodeEnum randomMoodKarotz();

	public APIResponseCodeEnum moodKarotz(final int mood);
}
