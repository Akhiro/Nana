package com.nana.test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class PseudoPing {
	public PseudoPing() {
	}

	boolean ping(final String host) {

		int timeOut = 3000;
		boolean status = false;
		try {
			status = InetAddress.getByName(host).isReachable(timeOut);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return status;
	}

	public static void main(final String args[]) {
		String host = "192.168.0.51";
		PseudoPing p = new PseudoPing();
		if (p.ping(host) == true) {
			System.out.println("Connecté");
		}
	}

}