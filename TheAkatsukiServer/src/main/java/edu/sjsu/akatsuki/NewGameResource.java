
package edu.sjsu.akatsuki;

import org.restlet.representation.*;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
import java.io.IOException;
import edu.sjsu.utility.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.*;
import org.restlet.ext.json.*;

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