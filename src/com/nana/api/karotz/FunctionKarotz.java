package com.nana.api.karotz;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.jdt.annotation.NonNull;

import com.nana.api.APIResponseCodeEnum;
import com.nana.utils.StreamUtils;
import com.nana.utils.UrlUtils;

public abstract class FunctionKarotz {
	static final Logger logger = LogManager.getLogger(FunctionKarotz.class.getName());

	public APIResponseCodeEnum sendUrlKarotz(@NonNull final String urlString)	{
		URL url=null;
		InputStream resultSendMessage;

		logger.info(this.getClass().getSimpleName() + " send : " + urlString);

		try {
			url = UrlUtils.UTF8URL(urlString);
			resultSendMessage = url.openStream();
			logger.info(this.getClass().getSimpleName() + " receive : " + StreamUtils.inputStreamToString(resultSendMessage));

			return APIResponseCodeEnum.SUCCESS;
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
			return APIResponseCodeEnum.ERROR;
		}
	}
}
