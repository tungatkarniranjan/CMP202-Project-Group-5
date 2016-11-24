package edu.sjsu.gamestate;

public class GameStartedState implements GameState {

	GameStateAssigner gameStateAssigner;
	
	public GameStartedState(GameStateAssigner gameStateAssigner)
	{
		this.gameStateAssigner = gameStateAssigner;
	}
	public void connectPlayer1()
	{
		System.out.println("Player 1 already connected");
	}
	
	public void connectPlayer2()
	{
		System.out.println("Player 2 already connected");
	}
	
	public void startGame()
	{
		System.out.println("Game already Started");
	}
	
	public boolean verifyPlayers()
	{
		return true;
	}
	
	public boolean verifyGameStarted()
	{
		return true;
	}
	
	public void endGame()
	{
		gameStateAssigner.setState(gameStateAssigner.getGameOverState());
	}
	
	public boolean verifyGameOver()
	{
		return false;
	}
	
	public void resetGame()
	{
		System.out.println("Game can't be reset");
	}
}
