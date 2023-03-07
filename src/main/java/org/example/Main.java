package org.example;

import org.example.json_with_gson.JSONToString;
import org.example.json_with_gson.StringToJSON;

/**
 * Hello world!
 */
public class Main {
	public static void main(String[] args) {
		StringToJSON stringToJSON = new StringToJSON();
		stringToJSON.convertStringToJSONElementTest();
		System.out.println("\n");
		JSONToString jsonToString = new JSONToString();
		jsonToString.convertJsonToStringTest();
	}
}
