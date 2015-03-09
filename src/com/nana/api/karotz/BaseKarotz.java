package com.nana.api.karotz;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.nana.utils.tools;

public abstract class BaseKarotz {
	static final Logger logger = LogManager.getLogger(BaseKarotz.class.getName());

	public void sendUrlKarotz(final String urlString)
	{
		URL url=null;
		InputStream resultSendMessage;

		logger.info("J'envoie : " + urlString);

		try {
			url = tools.UTF8URL(urlString);

			resultSendMessage = url.openStream();

			logger.info("On reçoit : " + tools.inputStreamToString(resultSendMessage));
		} catch (IOException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
