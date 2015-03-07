package com.nana.test;

import java.io.InputStream;

import com.nana.api.interfaces.IAPISendMessage;
import com.nana.api.karotz.APIKarotz;

public class ApiNana {

	public static void main(final String[] args) throws Exception {
		InputStream resultObj;

//		String begin = "http://192.168.0.40/cgi-bin/tts?voice=alice&nocache=0&text=";
//		String sentence = "e. arrête d'aimer écarter les chèvres avec du maïs";
//
//		System.out.println(begin + sentence);
//		URL url = tools.UTF8URL(begin + sentence);
//
//		resultObj = url.openStream();

		IAPISendMessage api = new APIKarotz("http://192.168.0.40/cgi-bin/","julie");
		api.sendMessage("i. Je suis amoureuse de toi.");

	}
}
