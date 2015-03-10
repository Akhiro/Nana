/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 7 mars 2015
 */
package com.nana.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class FileUtils {
	public static String getMD5(final Path path) throws IOException, NoSuchAlgorithmException {
		byte[] hash = MessageDigest.getInstance("MD5").digest(Files.readAllBytes(path));
		return DatatypeConverter.printHexBinary(hash);
	}

	public static String getMD5(final File file) throws IOException, NoSuchAlgorithmException {
		return getMD5(Paths.get(file.toURI()));
	}

	public static String getMD5(final String path) throws NoSuchAlgorithmException, IOException {
		return getMD5(Paths.get(path));
	}

	public static boolean compareMD5(final Path path, final String MD5) throws NoSuchAlgorithmException, IOException {
		return getMD5(path).equalsIgnoreCase(MD5);
	}

	public static boolean compareMD5(final File file, final String MD5) throws NoSuchAlgorithmException, IOException {
		return getMD5(file).equalsIgnoreCase(MD5);
	}

	public static boolean compareMD5(final String path, final String MD5) throws NoSuchAlgorithmException, IOException {
		return getMD5(path).equalsIgnoreCase(MD5);
	}
}
