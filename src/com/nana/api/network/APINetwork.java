/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 28 mars 2015
 */
package com.nana.api.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.api.APIResponseCodeEnum;
import com.nana.api.interfaces.IAPIPing;

public class APINetwork implements IAPIPing {

	public APINetwork() {
	}

	@Override
	public @NonNull APIResponseCodeEnum ping(@NonNull final String address) {
		String cmd = "";
	    try {
			if (System.getProperty("os.name").startsWith("Windows")) {
                // For Windows
                cmd = "ping -n 1 " + address;
	        } else {
                // For Linux and OSX
                cmd = "ping -c 1 " + address;
	        }

	        Process myProcess = Runtime.getRuntime().exec(cmd);

	        try (BufferedReader stdInput = new BufferedReader(new InputStreamReader(myProcess.getInputStream()));
		    BufferedReader stdError = new BufferedReader(new InputStreamReader(myProcess.getErrorStream()))) {
			    String s = null;
	        	String result = "";

	        	while ((s = stdInput.readLine()) != null) {
	        		result += s + "\n";
			    }

			    return (result.contains("TTL")) ? APIResponseCodeEnum.SUCCESS : APIResponseCodeEnum.TIMEOUT;
	        }
		} catch ( Exception e ) {
	        e.printStackTrace();
	        return APIResponseCodeEnum.ERROR;
		}
	}
}

