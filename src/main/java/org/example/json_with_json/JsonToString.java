package org.example.json_with_json;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonToString {
	private JSONObject getFruit(String name, String color, int quantity) {
		return new JSONObject().append("name", name).append("color", color).append("quantity", quantity);
	}

	private JSONObject getJsonObject() {
		JSONArray fruits = new JSONArray()
			.put(getFruit("apple", "red", 5))
			.put(getFruit("banana", "yellow", 5))
			.put(getFruit("orange", "orange", 5));

		return new JSONObject().append("fruits", fruits);
	}

	public void testJsonToString(){
		JSONObject jsonObject = getJsonObject();
		// toString
		System.out.println("json to string : "+ jsonObject.toString());
		System.out.println("fruits with get: " + jsonObject.get("fruits").toString());

		// valueToString
		JSONArray fruits = jsonObject.getJSONArray("fruits").getJSONArray(0);
		System.out.println("fruits: " + JSONObject.valueToString(fruits));
		JSONObject firstFruit = fruits.getJSONObject(0);
		System.out.println("first fruit : " + JSONObject.valueToString(firstFruit));

		// get primitive data
		System.out.println("first fruit name: " + firstFruit.getJSONArray("name").getString(0));
		System.out.println("first fruit quantity: "+ firstFruit.getJSONArray("quantity").getNumber(0));
	}
}
