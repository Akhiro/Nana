/*
* Copyright (c) 2015 - Seb&Lulu
* Author(s) : Lulu
* Date : 16 mars 2015
*/
package com.nana.api.weather;

import it.sauronsoftware.feed4j.FeedIOException;
import it.sauronsoftware.feed4j.FeedParser;
import it.sauronsoftware.feed4j.FeedXMLParseException;
import it.sauronsoftware.feed4j.UnsupportedFeedException;
import it.sauronsoftware.feed4j.bean.Feed;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.api.interfaces.IAPIWeather;

public class APIWeather implements IAPIWeather {

	@Override
	public @NonNull Integer getAtmo() {
		URL url;
		Integer atmo = 0;

		try {
			url = new URL("http://www.atmo-npdc.fr/component/atmo/?view=indice&format=feed");
			Feed feed = FeedParser.parse(url);
			String strAtmo = feed.getItem(0).getTitle();

			Pattern p = Pattern.compile("([0-9]+)");
	        Matcher m = p.matcher(strAtmo);

	        if(m.find()) {
	        	atmo = Integer.parseInt(m.group(1));
	        }

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FeedIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FeedXMLParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedFeedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return atmo;
	}



}
