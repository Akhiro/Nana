package com.nana.api.karotz.functions;

import com.nana.api.karotz.BaseKarotz;

public class TTSKarotz extends BaseKarotz {

	private final String _urlTTS;
	private final String _command = "tts?";
	private final String _voice = "voice=";
	private final String _text = "&text=";
	private final String _nocache = "&nocache=";
	private final String _mute = "&mute=";

	public TTSKarotz(final String beginUrl, final String TTSVoice) {
		_urlTTS=beginUrl + _command + _voice + TTSVoice + _text;
	}

	public void sendMessageTTSNow(final String message){
		sendUrlKarotz(_urlTTS + message + _nocache + "0" + _mute + "0");
	}
}
