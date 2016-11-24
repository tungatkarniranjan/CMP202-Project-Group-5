package edu.sjsu.gamestate;

public class GameStateAssigner {

	GameState currentState = null;
	
	GameState noPlayerState;
	GameState newGameState;
	GameState playersConnectedState;
	GameState gameStartedState;
	GameState gameOverState;
	
	public GameStateAssigner()
	{
		noPlayerState = new NoPlayerState(this);
		newGameState = new NewGameState(this);
		playersConnectedState = new PlayersConnectedState(this);
		gameStartedState = new GameStartedState(this);
		gameOverState = new GameOverState(this);
		
		currentState = noPlayerState;
	}
	
	public void setState(GameState state)
	{
		currentState = state;
	}
	
	public GameState getNoPlayerState()
	{
		return noPlayerState;
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
	
	public GameState getGameOverState()
	{
		return gameOverState;
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
	
	public void endGame()
	{
		currentState.endGame();
	}
	
	public boolean verifyPlayers()
	{
		return currentState.verifyPlayers();
	}
	
	public boolean verifyGameStarted()
	{
		return currentState.verifyGameStarted();
	}
	
	public boolean verifyGameOver()
	{
		return currentState.verifyGameOver();
	}
	
	public void resetGame()
	{
		currentState.resetGame();
	}
	
	
}
