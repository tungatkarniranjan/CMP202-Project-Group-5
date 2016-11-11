
package edu.sjsu.akatsuki;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import edu.sjsu.manager.Players;
import edu.sjsu.utility.RandomUtility;

public class NewGameResource extends ServerResource {

	private RandomUtility randonUtility;

	@Post
	public Representation createNewGameResource(Representation entity) {

		GameEnvironment gameEnv;
		JSONObject gameEnvObject = new JSONObject();

		try {
			JSONObject gameInput = new JSONObject(entity.getText());
			gameEnv = GameEnvironment.getInstance(Integer.parseInt(gameInput.get("maps").toString()),
					Integer.parseInt(gameInput.get("cities").toString()),
					Integer.parseInt(gameInput.get("ciphers").toString()),
					Integer.parseInt(gameInput.get("enemies").toString()));
		} catch (JSONException | IOException e1) {
			e1.printStackTrace();
		}
		
		Players.addPlayers();
		System.out.println(Players.getNoPlayers());
		try {
			gameEnvObject.put("map", GameEnvironment.getMapSelector());
			gameEnvObject.put("city", GameEnvironment.getCitySelector());
			gameEnvObject.put("cipher", GameEnvironment.getCipherSelector());
			gameEnvObject.put("enemy", GameEnvironment.getEnemySelector());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return new JsonRepresentation(gameEnvObject);
	}
}