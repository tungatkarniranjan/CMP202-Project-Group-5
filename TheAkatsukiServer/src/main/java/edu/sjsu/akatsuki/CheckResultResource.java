package edu.sjsu.akatsuki;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import edu.sjsu.gamestate.GameStateAssigner;

public class CheckResultResource extends ServerResource {

GameStateAssigner gameStateAssigner;
	
	@Post
	public Representation checkResult(Representation entity) throws JSONException, IOException {
		
		gameStateAssigner = GameEnvironment.getGameStateAssigner();
		boolean gameOver = gameStateAssigner.verifyGameOver();
		
		JSONObject playerAnswer = new JSONObject(entity.getText());
		JSONObject jsonresponse = new JSONObject();
		
		
		boolean citysaved = (boolean) playerAnswer.get("citysaved");
		
		if(citysaved && !gameOver)
		{
			gameStateAssigner.endGame();
			jsonresponse.put("winstatus", true);
		}
		else
		{
			jsonresponse.put("winstatus", false);
		}
	
		return new JsonRepresentation(jsonresponse);

	}
}
