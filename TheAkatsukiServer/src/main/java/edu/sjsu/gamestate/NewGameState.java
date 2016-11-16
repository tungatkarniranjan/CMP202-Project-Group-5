package edu.sjsu.gamestate;

public class NewGameState implements GameState {

	GameStateAssigner gameStateAssigner;
	
	public NewGameState(GameStateAssigner gameStateAssigner)
	{
		this.gameStateAssigner = gameStateAssigner;
	}
	public void connectPlayer1()
	{
		System.out.println("I can't handle player 1");
	}
	
	public void connectPlayer2()
	{
		gameStateAssigner.setState(gameStateAssigner.getPlayersConnectedState());
	}
	
	public void startGame()
	{
		System.out.println("You can't play alone");
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
		System.out.println("The game has not started yet");
	}
	
	public boolean verifyGameOver()
	{
		return false;
	}
}
