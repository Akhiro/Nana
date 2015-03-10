/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 4 mars 2015
 */
package com.nana;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import com.nana.core.Application;

public class Nana {
	public static void main(final String[] args) throws InterruptedException, NoSuchAlgorithmException, IOException {
		Application application = new Application();
		application.start();
	}
}
