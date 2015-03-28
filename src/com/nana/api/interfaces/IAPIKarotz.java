package com.nana.api.interfaces;

import com.nana.api.APIResponseCodeEnum;

public interface IAPIKarotz extends IAPI, IAPISendMessage {
	public APIResponseCodeEnum enableEars();

	public APIResponseCodeEnum disableEars();

	public APIResponseCodeEnum resetEarsPosition();

	public APIResponseCodeEnum randomEarsPosition();

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

	public APIResponseCodeEnum currentHourKarotz();

	public APIResponseCodeEnum chosenHourKarotz(final int hour);

	public APIResponseCodeEnum specificSoundKarotz(final String sound);

	public APIResponseCodeEnum urlSoundKarotz(final String urlFile);

	public APIResponseCodeEnum pauseSoundKarotz();

	public APIResponseCodeEnum quitSoundKarotz();

	public APIResponseCodeEnum sendMessageTTS(final String message, final int noCache, final int mute);

	public APIResponseCodeEnum clearCacheTTS();
}
