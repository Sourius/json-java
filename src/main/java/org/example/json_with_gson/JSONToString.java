package org.example.json_with_gson;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class JSONToString {
	private JsonElement getJSONElement() {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("fruit", "apple");
		jsonObject.addProperty("quantity", 5);
		jsonObject.addProperty("color", "red");
		return jsonObject;
	}

	private String convertJSONToString(JsonElement jsonElement) {
		Gson gson = new Gson();
		String jsonConverted = gson.toJson(jsonElement, JsonElement.class);
		return jsonConverted;
	}

	public void convertJsonToStringTest(){
		JsonElement jsonElement = getJSONElement();
		String convertedJson = convertJSONToString(jsonElement);
		System.out.println("to json: " + convertedJson);

		// get value
		String asString = jsonElement.getAsJsonObject().get("fruit").getAsString();
		System.out.println("json as string: "+asString);

		// String fromJson = gson.fromJson(jsonElement, String.class); --> Error --> doesn't work as indicated in api
		// System.out.println("from json: "+ fromJson);
		Gson gson = new Gson();
		String usingAdapter = gson.getAdapter(JsonElement.class).toJson(jsonElement);
		System.out.println("from Adapter: " + usingAdapter);
	}
}
