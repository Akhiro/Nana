/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 7 mars 2015
 */
package com.nana;

import org.springframework.context.support.AbstractXmlApplicationContext;

public class Application implements Runnable {


	private AbstractXmlApplicationContext _schedulerContext;
	private AbstractXmlApplicationContext _modulesListContext;
	private AbstractXmlApplicationContext _modulesContext;

	public Application() {
	}

	@Override
	public void run() {

	}

}
