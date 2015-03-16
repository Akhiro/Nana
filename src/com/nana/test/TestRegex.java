/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 16 mars 2015
 */
package com.nana.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {
	public static void main(final String[] args) {

		Pattern p = Pattern.compile("([0-9]+)");
		Matcher m = p.matcher("Lille : indice 10");

		if(m.find()) {
			System.out.println(m.group(1));
		}
	}
}
