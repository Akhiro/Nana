package com.nana.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class ApiNana {

	public static void main(final String[] args) throws Exception {
		InputStream resultObj;

		URL url = new URL("http","192.168.0.40","/cgi-bin/tts?text=Je%20suis%20un%20programme&voice=margaux&nocache=0&mute=0");
		resultObj = url.openStream();

		System.out.println(url.toString());
		System.out.println(fromStream(resultObj));
	}

	public static String fromStream(final InputStream in) throws IOException
	{
	    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	    StringBuilder out = new StringBuilder();
	    String newLine = System.getProperty("line.separator");
	    String line;
	    while ((line = reader.readLine()) != null) {
	        out.append(line);
	        out.append(newLine);
	    }
	    return out.toString();
	}
}
