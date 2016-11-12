package edu.sjsu.gamestate;

public interface GameState {
	
	public void connectPlayer1();
	public void connectPlayer2();
	public void startGame();
	public boolean verifyPlayers();
	public boolean verifyGameStarted();
}
