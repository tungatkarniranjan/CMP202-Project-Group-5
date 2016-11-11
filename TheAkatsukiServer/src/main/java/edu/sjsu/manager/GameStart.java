package edu.sjsu.manager;

public class GameStart {

	private static boolean gameStarted = false;

	public static void startTheGame() {
		GameStart.gameStarted = true;
	}

	public static boolean IsGameStarted() {
		return GameStart.gameStarted;
	}
}
