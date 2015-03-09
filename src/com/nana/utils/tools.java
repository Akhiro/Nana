package com.nana.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;

import org.eclipse.jdt.annotation.NonNull;

public class tools {
	public static String inputStreamToString(final InputStream in) throws IOException
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

	public static URL UTF8URL(@NonNull final String stringURL) throws UnsupportedEncodingException, URISyntaxException, MalformedURLException {
		URL url = new URL(stringURL);

		String path = url.getPath();
		if (path != null) {
			path = URLDecoder.decode(path, "UTF-8");
		}
		String query = url.getQuery();
		if (query != null) {
			query = URLDecoder.decode(query, "UTF-8");
		}
		String fragment = url.getRef();
		if (fragment != null) {
			fragment = URLDecoder.decode(fragment, "UTF-8");
		}

		URI uri = new URI(url.getProtocol(), url.getAuthority(), path, query, fragment);

		URL _url = new URL(uri.toString().replace("'", "%27"));

		return _url;
	}
}
