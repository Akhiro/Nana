package com.nana.api.karotz;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.api.APIResponseCodeEnum;
import com.nana.api.interfaces.IAPIKarotz;
import com.nana.api.karotz.functions.ClockKarotz;
import com.nana.api.karotz.functions.EarsKarotz;
import com.nana.api.karotz.functions.LedKarotz;
import com.nana.api.karotz.functions.MoodKarotz;
import com.nana.api.karotz.functions.SoundKarotz;
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
	private final ClockKarotz _clock;
	private final SoundKarotz _sound;

	public APIKarotz(final String beginUrl, final String TTSVoice) {
		_beginUrl = beginUrl;
		_TTSVoice = TTSVoice;

		_tts = new TTSKarotz(_beginUrl, _TTSVoice);
		_ears = new EarsKarotz(beginUrl);
		_led = new LedKarotz(beginUrl);
		_wake = new WakeUpKarotz(beginUrl);
		_mood = new MoodKarotz(beginUrl);
		_clock = new ClockKarotz(beginUrl);
		_sound = new SoundKarotz(beginUrl);
	}

	@Override
	public APIResponseCodeEnum sendMessage(@NonNull final String message) {
		return _tts.sendMessageTTSNow(message);
	}

	@Override
	public APIResponseCodeEnum enableEars() {
		return _ears.enableEars();
	}

	@Override
	public APIResponseCodeEnum disableEars() {
		return _ears.disableEars();
	}

	@Override
	public APIResponseCodeEnum resetEarsPosition() {
		return _ears.resetEarsPosition();
	}

	@Override
	public APIResponseCodeEnum randomEarsPosition() {
		return _ears.randomEarsPosition();
	}

	@Override
	public APIResponseCodeEnum moveEars(final int leftPosition, final int rightPosition) {
		return _ears.moveEars(leftPosition, rightPosition);
	}

	@Override
	public APIResponseCodeEnum shutDownLed() {
		return _led.shutDownLed();
	}

	@Override
	public APIResponseCodeEnum fixedSavedLed(final String primaryColor) {
		return _led.fixedSavedLed(primaryColor);
	}

	@Override
	public APIResponseCodeEnum pulseOneColorSavedLed(final String primaryColor, final int speedPulse) {
		return _led.pulseOneColorSavedLed(primaryColor, speedPulse);
	}

	@Override
	public APIResponseCodeEnum pulseTwoColorSavedLed(final String primaryColor, final String secondColor,
			final int speedPulse) {
		return _led.pulseTwoColorSavedLed(primaryColor, secondColor, speedPulse);
	}

	@Override
	public APIResponseCodeEnum fixedTemporaryLed(final String primaryColor) {
		return _led.fixedTemporaryLed(primaryColor);
	}

	@Override
	public APIResponseCodeEnum pulseOneColorTemporaryLed(final String primaryColor, final int speedPulse) {
		return _led.pulseOneColorTemporaryLed(primaryColor, speedPulse);
	}

	@Override
	public APIResponseCodeEnum pulseTwoColorTemporaryLed(final String primaryColor, final String secondColor, final int speedPulse) {
		return _led.pulseTwoColorTemporaryLed(primaryColor, secondColor, speedPulse);
	}

	@Override
	public APIResponseCodeEnum wakeSilentKarotz() {
		return _wake.wakeSilentKarotz();
	}

	@Override
	public APIResponseCodeEnum wakeSoundKarotz() {
		return _wake.wakeSoundKarotz();
	}

	@Override
	public APIResponseCodeEnum sleepKarotz() {
		return _wake.sleepKarotz();
	}

	@Override
	public APIResponseCodeEnum randomMoodKarotz() {
		return _mood.randomMoodKarotz();
	}

	@Override
	public APIResponseCodeEnum moodKarotz(final int mood) {
		return _mood.moodKarotz(mood);
	}

	@Override
	public APIResponseCodeEnum currentHourKarotz() {
		return _clock.currentHourKarotz();
	}

	@Override
	public APIResponseCodeEnum chosenHourKarotz(final int hour) {
		return _clock.chosenHourKarotz(hour);
	}

	@Override
	public APIResponseCodeEnum specificSoundKarotz(final String sound) {
		return _sound.specificSoundKarotz(sound);
	}

	@Override
	public APIResponseCodeEnum urlSoundKarotz(final String urlFile) {
		return _sound.urlSoundKarotz(urlFile);
	}

	@Override
	public APIResponseCodeEnum pauseSoundKarotz() {
		return _sound.pauseSoundKarotz();
	}

	@Override
	public APIResponseCodeEnum quitSoundKarotz() {
		return _sound.quitSoundKarotz();
	}

}
