package com.nana.api.karotz;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.api.interfaces.IAPIReturns;
import com.nana.api.karotz.functions.TTSKarotz;

public class APIKarotz implements IAPIKarotz {
	private final String _beginUrl;
	private final String _TTSVoice;
	private final TTSKarotz _tts;

	public APIKarotz(final String beginUrl, final String TTSVoice) {
		_beginUrl = beginUrl;
		_TTSVoice = TTSVoice;

		_tts = new TTSKarotz(_beginUrl, _TTSVoice);
	}

	@Override
	public IAPIReturns sendMessage(@NonNull final String message) {
		_tts.sendMessageTTSNow(message);
		return null;
	}

}
