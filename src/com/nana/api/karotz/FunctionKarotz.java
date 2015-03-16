package com.nana.api.karotz;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
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
		URL url = null;
		HttpURLConnection httpConnect = null;
		InputStream resultSendMessage;

		logger.info(this.getClass().getSimpleName() + " send : " + urlString);

		try {
			url = UrlUtils.UTF8URL(urlString);

			httpConnect = (HttpURLConnection) url.openConnection();
			httpConnect.setReadTimeout(30000);
			httpConnect.setRequestMethod("GET");

			resultSendMessage = httpConnect.getInputStream();
			logger.info("POUF PATAPOUF");
			logger.info(this.getClass().getSimpleName() + " receive : " + StreamUtils.inputStreamToString(resultSendMessage));

			return APIResponseCodeEnum.SUCCESS;
		} catch (SocketTimeoutException e) {
			logger.error(this.getClass().getSimpleName() + " crash : " + APIResponseCodeEnum.TIMEOUT.name());
			return APIResponseCodeEnum.TIMEOUT;
		} catch (IOException | URISyntaxException e) {
			logger.error(this.getClass().getSimpleName() + " crash : " + APIResponseCodeEnum.ERROR.name());
			return APIResponseCodeEnum.ERROR;
		}
	}
}
