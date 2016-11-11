package edu.sjsu.manager;

public class Players {

	private static int noPlayers = 0;

	public static int getNoPlayers() {
		return noPlayers;
	}

	public static void addPlayers() {
		Players.noPlayers++;
	}

}
