package edu.sjsu.gamestate;

public class PlayersConnectedState implements GameState {

	GameStateAssigner gameStateAssigner;
	
	public PlayersConnectedState(GameStateAssigner gameStateAssigner)
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
		this.gameStateAssigner.setState(this.gameStateAssigner.getGameStartedState());
	}
	
	public boolean verifyPlayers()
	{
		return true;
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
	
	public void resetGame()
	{
		System.out.println("Game can't be reset");
	}
}
