package com.nana.test;

import com.nana.api.interfaces.IAPIKarotz;
import com.nana.api.karotz.APIKarotz;

public class ApiNana {

	public static void main(final String[] args) throws Exception {
		//podcast > http://download-audio.rts.ch/couleur3/programmes/point-barre/2015/point-barre_20150307_full_point-barre_14c285ce-8bff-44fb-860a-5031e3c2124f-128k.mp3

		//testEarsKarotz();
		//testLedKarotz();
		//testWakeUpKarotz();
		//testMoodKarotz();
		//testClockKarotz();
		testSoundKarotz();
	}

	public static void testSoundKarotz() throws InterruptedException {
		IAPIKarotz api = new APIKarotz("http://192.168.0.40/cgi-bin/","julie");
		String podcast = "http://download-audio.rts.ch/couleur3/programmes/point-barre/2015/point-barre_20150307_full_point-barre_14c285ce-8bff-44fb-860a-5031e3c2124f-128k.mp3";

		api.specificSoundKarotz("ready");
		Thread.sleep(3000);
		api.specificSoundKarotz("RADISCUIT");
		Thread.sleep(3000);
		api.urlSoundKarotz(podcast);
		Thread.sleep(6000);
		api.pauseSoundKarotz();
		Thread.sleep(6000);
		api.pauseSoundKarotz();
		Thread.sleep(6000);
		api.quitSoundKarotz();
	}

	public static void testClockKarotz() throws InterruptedException {
		IAPIKarotz api = new APIKarotz("http://192.168.0.40/cgi-bin/","julie");
		api.currentHourKarotz();
		Thread.sleep(3000);
		api.chosenHourKarotz(4);
		Thread.sleep(3000);
		api.chosenHourKarotz(95);
	}

	public static void testMoodKarotz() throws InterruptedException {
		IAPIKarotz api = new APIKarotz("http://192.168.0.40/cgi-bin/","julie");
		api.randomMoodKarotz();
		Thread.sleep(3000);
		api.moodKarotz(5);
		Thread.sleep(3000);
		api.moodKarotz(65);
		Thread.sleep(3000);
		api.moodKarotz(0);
	}

	public static void testWakeUpKarotz() throws InterruptedException {
		IAPIKarotz api = new APIKarotz("http://192.168.0.40/cgi-bin/","julie");
		api.sendMessage("Bonne nuit !");
		Thread.sleep(3000);
		api.sleepKarotz();
		Thread.sleep(3000);
		api.wakeSilentKarotz();
		Thread.sleep(3000);
		api.sendMessage("M'avez-vous entendu ?");
		Thread.sleep(3000);
		api.sendMessage("Bonne nuit !");
		Thread.sleep(3000);
		api.sleepKarotz();
		Thread.sleep(3000);
		api.wakeSoundKarotz();
	}

	public static void testEarsKarotz() throws InterruptedException {
		IAPIKarotz api = new APIKarotz("http://192.168.0.40/cgi-bin/","julie");
		api.sendMessage("Initialisation de mes oreilles");
		Thread.sleep(3000);
		api.enableEars();
		Thread.sleep(3000);
		api.sendMessage("Je reset la position de mes oreilles.");
		Thread.sleep(3000);
		api.resetPositionEars();
		Thread.sleep(3000);
		api.sendMessage("Je bouge l'oreille gauche");
		Thread.sleep(3000);
		api.moveEars(11, 0);
		Thread.sleep(3000);
		api.disableEars();
		Thread.sleep(3000);
		api.sendMessage("Mes oreilles sont HS. J'essaie quand même !");
		Thread.sleep(3000);
		api.randomPositionEars();
		Thread.sleep(3000);
		api.sendMessage("J'active mes oreilles");
		Thread.sleep(3000);
		api.enableEars();
		Thread.sleep(3000);
		api.sendMessage("Je bouge précisément les oreilles");
		api.moveEars(5, 35);
	}

	public static void testLedKarotz() throws InterruptedException {
		IAPIKarotz api = new APIKarotz("http://192.168.0.40/cgi-bin/","julie");
		api.sendMessage("On éteint la led.");
		Thread.sleep(3000);
		api.shutDownLed();
		Thread.sleep(3000);
		api.sendMessage("On allume la LED en violet.");
		Thread.sleep(3000);
		api.fixedSavedLed("bf00ff");
		Thread.sleep(3000);
		api.sendMessage("On pulse la LED en bleu.");
		Thread.sleep(3000);
		api.pulseOneColorSavedLed("00C4FF", 300);
		Thread.sleep(3000);
		api.sendMessage("On pulse la LED en bi-colore rose et jaune.");
		Thread.sleep(3000);
		api.pulseTwoColorSavedLed("FF00FF", "FFE100", 900);
		Thread.sleep(3000);
	}
}
