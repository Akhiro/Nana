package com.nana.api.karotz;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.api.interfaces.IAPIReturns;
import com.nana.api.karotz.functions.EarsKarotz;
import com.nana.api.karotz.functions.LedKarotz;
import com.nana.api.karotz.functions.TTSKarotz;

public class APIKarotz implements IAPIKarotz {
	private final String _beginUrl;
	private final String _TTSVoice;
	private final TTSKarotz _tts;
	private final EarsKarotz _ears;
	private final LedKarotz _led;

	public APIKarotz(final String beginUrl, final String TTSVoice) {
		_beginUrl = beginUrl;
		_TTSVoice = TTSVoice;

		_tts = new TTSKarotz(_beginUrl, _TTSVoice);
		_ears = new EarsKarotz(beginUrl);
		_led = new LedKarotz(beginUrl);
	}

	@Override
	public IAPIReturns sendMessage(@NonNull final String message) {
		_tts.sendMessageTTSNow(message);
		return null;
	}

	@Override
	public IAPIReturns enableEars() {
		_ears.enableEars();
		return null;
	}

	@Override
	public IAPIReturns disableEars() {
		_ears.disableEars();
		return null;
	}

	@Override
	public IAPIReturns resetPositionEars() {
		_ears.resetPositionEars();
		return null;
	}

	@Override
	public IAPIReturns randomPositionEars() {
		_ears.randomPositionEars();
		return null;
	}

	@Override
	public IAPIReturns moveEars(final int leftPosition, final int rightPosition) {
		_ears.moveEars(leftPosition, rightPosition);
		return null;
	}

	@Override
	public IAPIReturns shutDownLed() {
		_led.shutDownLed();
		return null;
	}

	@Override
	public IAPIReturns fixedSavedLed(final String primaryColor) {
		_led.fixedSavedLed(primaryColor);
		return null;
	}

	@Override
	public IAPIReturns pulseOneColorSavedLed(final String primaryColor, final int speedPulse) {
		_led.pulseOneColorSavedLed(primaryColor, speedPulse);
		return null;
	}

	@Override
	public IAPIReturns pulseTwoColorSavedLed(final String primaryColor, final String secondColor,
			final int speedPulse) {
		_led.pulseTwoColorSavedLed(primaryColor, secondColor, speedPulse);
		return null;
	}

	@Override
	public IAPIReturns fixedTemporaryLed(final String primaryColor) {
		_led.fixedTemporaryLed(primaryColor);
		return null;
	}

	@Override
	public IAPIReturns pulseOneColorTemporaryLed(final String primaryColor, final int speedPulse) {
		_led.pulseOneColorTemporaryLed(primaryColor, speedPulse);
		return null;
	}

	@Override
	public IAPIReturns pulseTwoColorTemporaryLed(final String primaryColor,
			final String secondColor, final int speedPulse) {
		_led.pulseTwoColorTemporaryLed(primaryColor, secondColor, speedPulse);
		return null;
	}

}
