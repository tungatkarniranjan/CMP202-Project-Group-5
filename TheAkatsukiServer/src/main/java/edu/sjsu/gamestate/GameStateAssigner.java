package edu.sjsu.gamestate;

public class GameStateAssigner {

	GameState currentState = null;
	
	GameState noPlayerState;
	GameState newGameState;
	GameState playersConnectedState;
	GameState gameStartedState;
	
	public GameStateAssigner()
	{
		noPlayerState = new NoPlayerState(this);
		newGameState = new NewGameState(this);
		playersConnectedState = new PlayersConnectedState(this);
		gameStartedState = new GameStartedState(this);
		
		currentState = noPlayerState;
	}
	
	public void setState(GameState state)
	{
		currentState = state;
	}
	
	public GameState getNewGameState()
	{
		return newGameState;
	}
	
	public GameState getPlayersConnectedState()
	{
		return playersConnectedState;
	}
	
	public GameState getGameStartedState()
	{
		return gameStartedState;
	}
	
	public void connectPlayer1()
	{
		currentState.connectPlayer1();
	}
	
	public void connectPlayer2()
	{
		currentState.connectPlayer2();
	}
	
	public void startGame()
	{
		currentState.startGame();
	}
	
	public boolean verifyPlayers()
	{
		return currentState.verifyPlayers();
	}
	
	public boolean verifyGameStarted()
	{
		return currentState.verifyGameStarted();
	}
	
}
