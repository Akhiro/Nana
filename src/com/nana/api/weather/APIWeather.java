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

import com.guendouz.yweather.YWeather;
import com.guendouz.yweather.model.Units;
import com.guendouz.yweather.model.WeatherInfo;
import com.nana.api.interfaces.IAPIWeather;

public class APIWeather implements IAPIWeather {

	// Format :
	// Forecast [day=Mon, date=Mon Apr 20 00:00:00 CEST 2015, low=6, high=20, text=Sunny, code=32]
	// Wind [chill=13, direction=40, speed=19.31]
	// Astronomy [sunrise=Thu Jan 01 06:46:00 CET 1970, sunset=Thu Jan 01 20:46:00 CET 1970]

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

	@Override
	public @NonNull Integer getTempLow() {

		YWeather weather = new YWeather();
		Integer tempLow = 0;

		WeatherInfo info = weather.getWeatherForPlace("Tourcoing", Units.TEMP_C);
		tempLow = info.getItem().getForecastOne().getLow();

		return tempLow;

	}

	@Override
	public @NonNull Integer getTempHigh() {

		YWeather weather = new YWeather();
		Integer tempHigh = 0;

		WeatherInfo info = weather.getWeatherForPlace("Tourcoing", Units.TEMP_C);
		tempHigh = info.getItem().getForecastOne().getHigh();

		return tempHigh;

	}

	@Override
	public @NonNull Integer getWindSpeed() {

		YWeather weather = new YWeather();
		Integer speedWind = 0;

		WeatherInfo info = weather.getWeatherForPlace("Tourcoing", Units.TEMP_C);
		speedWind = Math.round(info.getWind().getSpeed());

		return speedWind;

	}

}
