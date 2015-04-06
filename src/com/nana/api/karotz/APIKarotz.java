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

	private final Object _mutex;

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

		_mutex = new Object();
	}

	@Override
	public APIResponseCodeEnum sendMessage(@NonNull final String message) {
		synchronized (_mutex) {
			return _tts.sendMessageTTSNow(message);
		}
	}

	@Override
	public APIResponseCodeEnum sendMessageTTS(final String message, final int noCache, final int mute) {
		synchronized (_mutex) {
			return _tts.sendMessageTTS(message, noCache, mute);
		}
	}

	@Override
	public APIResponseCodeEnum clearCacheTTS() {
		synchronized (_mutex) {
			return _tts.clearCacheTTS();
		}
	}

	@Override
	public APIResponseCodeEnum enableEars() {
		synchronized (_mutex) {
			return _ears.enableEars();
		}
	}

	@Override
	public APIResponseCodeEnum disableEars() {
		synchronized (_mutex) {
			return _ears.disableEars();
		}
	}

	@Override
	public APIResponseCodeEnum resetEarsPosition() {
		synchronized (_mutex) {
			return _ears.resetEarsPosition();
		}
	}

	@Override
	public APIResponseCodeEnum randomEarsPosition() {
		synchronized (_mutex) {
			return _ears.randomEarsPosition();
		}
	}

	@Override
	public APIResponseCodeEnum moveEars(final int leftPosition, final int rightPosition) {
		synchronized (_mutex) {
			return _ears.moveEars(leftPosition, rightPosition);
		}
	}

	@Override
	public APIResponseCodeEnum shutDownLed() {
		synchronized (_mutex) {
			return _led.shutDownLed();
		}
	}

	@Override
	public APIResponseCodeEnum fixedSavedLed(final String primaryColor) {
		synchronized (_mutex) {
			return _led.fixedSavedLed(primaryColor);
		}
	}

	@Override
	public APIResponseCodeEnum pulseOneColorSavedLed(final String primaryColor, final int speedPulse) {
		synchronized (_mutex) {
			return _led.pulseOneColorSavedLed(primaryColor, speedPulse);
		}
	}

	@Override
	public APIResponseCodeEnum pulseTwoColorSavedLed(final String primaryColor, final String secondColor, final int speedPulse) {
		synchronized (_mutex) {
			return _led.pulseTwoColorSavedLed(primaryColor, secondColor, speedPulse);
		}
	}

	@Override
	public APIResponseCodeEnum fixedTemporaryLed(final String primaryColor) {
		synchronized (_mutex) {
			return _led.fixedTemporaryLed(primaryColor);
		}
	}

	@Override
	public APIResponseCodeEnum pulseOneColorTemporaryLed(final String primaryColor, final int speedPulse) {
		synchronized (_mutex) {
			return _led.pulseOneColorTemporaryLed(primaryColor, speedPulse);
		}
	}

	@Override
	public APIResponseCodeEnum pulseTwoColorTemporaryLed(final String primaryColor, final String secondColor, final int speedPulse) {
		synchronized (_mutex) {
			return _led.pulseTwoColorTemporaryLed(primaryColor, secondColor, speedPulse);
		}
	}

	@Override
	public APIResponseCodeEnum wakeSilentKarotz() {
		synchronized (_mutex) {
			return _wake.wakeSilentKarotz();
		}
	}

	@Override
	public APIResponseCodeEnum wakeSoundKarotz() {
		synchronized (_mutex) {
			return _wake.wakeSoundKarotz();
		}
	}

	@Override
	public APIResponseCodeEnum sleepKarotz() {
		synchronized (_mutex) {
			return _wake.sleepKarotz();
		}
	}

	@Override
	public APIResponseCodeEnum randomMoodKarotz() {
		synchronized (_mutex) {
			return _mood.randomMoodKarotz();
		}
	}

	@Override
	public APIResponseCodeEnum moodKarotz(final int mood) {
		synchronized (_mutex) {
			return _mood.moodKarotz(mood);
		}
	}

	@Override
	public APIResponseCodeEnum currentHourKarotz() {
		synchronized (_mutex) {
			return _clock.currentHourKarotz();
		}
	}

	@Override
	public APIResponseCodeEnum chosenHourKarotz(final int hour) {
		synchronized (_mutex) {
			return _clock.chosenHourKarotz(hour);
		}
	}

	@Override
	public APIResponseCodeEnum specificSoundKarotz(final String sound) {
		synchronized (_mutex) {
			return _sound.specificSoundKarotz(sound);
		}
	}

	@Override
	public APIResponseCodeEnum urlSoundKarotz(final String urlFile) {
		synchronized (_mutex) {
			return _sound.urlSoundKarotz(urlFile);
		}
	}

	@Override
	public APIResponseCodeEnum pauseSoundKarotz() {
		synchronized (_mutex) {
			return _sound.pauseSoundKarotz();
		}
	}

	@Override
	public APIResponseCodeEnum quitSoundKarotz() {
		synchronized (_mutex) {
			return _sound.quitSoundKarotz();
		}
	}

}
