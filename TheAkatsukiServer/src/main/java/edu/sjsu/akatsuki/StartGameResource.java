package edu.sjsu.akatsuki;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import edu.sjsu.manager.GameStart;

public class StartGameResource extends ServerResource {

	@Get
	public void startTheGame() {

		GameStart.startTheGame();
	}
}
