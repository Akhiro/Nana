package com.nana.api.karotz.functions;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.api.APIResponseCodeEnum;
import com.nana.api.karotz.FunctionKarotz;

public class TTSKarotz extends FunctionKarotz {

	@NonNull private final String _urlTTS;
	private final String _command = "tts?";
	private final String _voice = "voice=";
	private final String _text = "&text=";
	private final String _nocache = "&nocache=";
	private final String _mute = "&mute=";
	@NonNull private final String _urlClear;

	public TTSKarotz(final String beginUrl, final String TTSVoice) {
		_urlTTS = beginUrl + _command + _voice + TTSVoice + _text;
		_urlClear = beginUrl + "clear_cache";
	}

	public APIResponseCodeEnum sendMessageTTSNow(final String message){
		return sendUrlKarotz(_urlTTS + message + _nocache + "0" + _mute + "0");
	}

	public APIResponseCodeEnum sendMessageTTS(final String message, final int noCache, final int mute){
		String strCache = Integer.toString(noCache);
		String strMute = Integer.toString(mute);

		return sendUrlKarotz(_urlTTS + message + _nocache + strCache + _mute + strMute);
	}

	public APIResponseCodeEnum clearCacheTTS() {
		return sendUrlKarotz(_urlClear);
	}
}
