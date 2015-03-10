package com.nana.api.karotz;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.api.APIResponseCodeEnum;
import com.nana.api.karotz.functions.EarsKarotz;
import com.nana.api.karotz.functions.LedKarotz;
import com.nana.api.karotz.functions.MoodKarotz;
import com.nana.api.karotz.functions.TTSKarotz;
import com.nana.api.karotz.functions.WakeUpKarotz;

public class APIKarotz implements IAPIKarotz {
	private final String _beginUrl;
	private final String _TTSVoice;
	private final TTSKarotz _tts;
	private final EarsKarotz _ears;
	private final LedKarotz _led;
	private final WakeUpKarotz _wake;
	private final MoodKarotz _mood;

	public APIKarotz(final String beginUrl, final String TTSVoice) {
		_beginUrl = beginUrl;
		_TTSVoice = TTSVoice;

		_tts = new TTSKarotz(_beginUrl, _TTSVoice);
		_ears = new EarsKarotz(beginUrl);
		_led = new LedKarotz(beginUrl);
		_wake = new WakeUpKarotz(beginUrl);
		_mood = new MoodKarotz(beginUrl);
	}

	@Override
	public APIResponseCodeEnum sendMessage(@NonNull final String message) {
		return _tts.sendMessageTTSNow(message);
	}

	@Override
	public APIResponseCodeEnum enableEars() {
		_ears.enableEars();
		return null;
	}

	@Override
	public APIResponseCodeEnum disableEars() {
		_ears.disableEars();
		return null;
	}

	@Override
	public APIResponseCodeEnum resetPositionEars() {
		_ears.resetPositionEars();
		return null;
	}

	@Override
	public APIResponseCodeEnum randomPositionEars() {
		_ears.randomPositionEars();
		return null;
	}

	@Override
	public APIResponseCodeEnum moveEars(final int leftPosition, final int rightPosition) {
		_ears.moveEars(leftPosition, rightPosition);
		return null;
	}

	@Override
	public APIResponseCodeEnum shutDownLed() {
		_led.shutDownLed();
		return null;
	}

	@Override
	public APIResponseCodeEnum fixedSavedLed(final String primaryColor) {
		_led.fixedSavedLed(primaryColor);
		return null;
	}

	@Override
	public APIResponseCodeEnum pulseOneColorSavedLed(final String primaryColor, final int speedPulse) {
		_led.pulseOneColorSavedLed(primaryColor, speedPulse);
		return null;
	}

	@Override
	public APIResponseCodeEnum pulseTwoColorSavedLed(final String primaryColor, final String secondColor,
			final int speedPulse) {
		_led.pulseTwoColorSavedLed(primaryColor, secondColor, speedPulse);
		return null;
	}

	@Override
	public APIResponseCodeEnum fixedTemporaryLed(final String primaryColor) {
		_led.fixedTemporaryLed(primaryColor);
		return null;
	}

	@Override
	public APIResponseCodeEnum pulseOneColorTemporaryLed(final String primaryColor, final int speedPulse) {
		_led.pulseOneColorTemporaryLed(primaryColor, speedPulse);
		return null;
	}

	@Override
	public APIResponseCodeEnum pulseTwoColorTemporaryLed(final String primaryColor, final String secondColor, final int speedPulse) {
		_led.pulseTwoColorTemporaryLed(primaryColor, secondColor, speedPulse);
		return null;
	}

	@Override
	public APIResponseCodeEnum wakeSilentKarotz() {
		_wake.wakeSilentKarotz();
		return null;
	}

	@Override
	public APIResponseCodeEnum wakeSoundKarotz() {
		_wake.wakeSoundKarotz();
		return null;
	}

	@Override
	public APIResponseCodeEnum sleepKarotz() {
		_wake.sleepKarotz();
		return null;
	}

	@Override
	public APIResponseCodeEnum randomMoodKarotz() {
		_mood.randomMoodKarotz();
		return null;
	}

	@Override
	public APIResponseCodeEnum moodKarotz(final int mood) {
		_mood.moodKarotz(mood);
		return null;
	}

}
