package edu.sjsu.gamestate;

public class NoPlayerState implements GameState{

	GameStateAssigner gameStateAssigner;
	
	public NoPlayerState(GameStateAssigner gameStateAssigner)
	{
		this.gameStateAssigner = gameStateAssigner;
	}
	
	public void connectPlayer1()
	{
		gameStateAssigner.setState(gameStateAssigner.getNewGameState());
	}
	
	public void connectPlayer2()
	{
		System.out.println("I can't handle player 2");
	}
	
	public void startGame()
	{
		System.out.println("Can't begin game without players");
	}
	
	public boolean verifyPlayers()
	{
		return false;
	}
	
	public boolean verifyGameStarted()
	{
		return false;
	}

}
