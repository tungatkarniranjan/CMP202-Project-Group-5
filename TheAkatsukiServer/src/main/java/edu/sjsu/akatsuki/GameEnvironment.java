package edu.sjsu.akatsuki;

import edu.sjsu.utility.*;

public class GameEnvironment {

	private static GameEnvironment gameEnv = null;

	private static int mapSelector = 0;
	private static int citySelector = 0;
	private static int cipherSelector = 0;
	private static int enemySelector = 0;

	private GameEnvironment(int mapSelector, int citySelector, int cipherSelector, int enemySelector) {
		GameEnvironment.mapSelector = mapSelector;
		GameEnvironment.citySelector = citySelector;
		GameEnvironment.cipherSelector = cipherSelector;
		GameEnvironment.enemySelector = enemySelector;
	}

	public static GameEnvironment getInstance(int mapRange, int cityRange, int cipherRange, int enemyRange) {
		if (gameEnv == null) {
			RandomUtility randomUtility = new RandomUtility();
			int mapSelector = randomUtility.getRandomNumber(mapRange);
			int citySelector = randomUtility.getRandomNumber(cityRange);
			int cipherSelector = randomUtility.getRandomNumber(cipherRange);
			int enemySelector = randomUtility.getRandomNumber(enemyRange);

			gameEnv = new GameEnvironment(mapSelector, citySelector, cipherSelector, enemySelector);
		}
		return gameEnv;
	}

	public static int getMapSelector() {
		return GameEnvironment.mapSelector;
	}

	public static int getCitySelector() {
		return GameEnvironment.citySelector;
	}

	public static int getCipherSelector() {
		return GameEnvironment.cipherSelector;
	}

	public static int getEnemySelector() {
		return GameEnvironment.enemySelector;
	}
}
