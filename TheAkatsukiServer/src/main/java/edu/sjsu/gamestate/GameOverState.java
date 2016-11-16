package edu.sjsu.gamestate;

public class GameOverState implements GameState {

	GameStateAssigner gameStateAssigner;
	
	public GameOverState(GameStateAssigner gameStateAssigner)
	{
		this.gameStateAssigner = gameStateAssigner;
	}
	
	public void connectPlayer1()
	{
		System.out.println("I can't handle player 1");
	}
	
	public void connectPlayer2()
	{
		System.out.println("I can't handle player 2");
	}
	
	public void startGame()
	{
		System.out.println("Game is over ..");
	}
	
	public boolean verifyPlayers()
	{
		return false;
	}
	
	public boolean verifyGameStarted()
	{
		return false;
	}
	
	public void endGame()
	{
		System.out.println("Game already over");
	}
	
	public boolean verifyGameOver()
	{
		return true;
	}
	
}
