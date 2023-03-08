package org.example;

/**
 * Hello world!
 */
public class Main {
	public static void main(String[] args) {
		// testWithGson();
		testWithJson();
	}

	public static void testWithGson(){
		org.example.json_with_gson.StringToJSON stringToJSON = new org.example.json_with_gson.StringToJSON();
		stringToJSON.convertStringToJSONElementTest();
		System.out.println();
		org.example.json_with_gson.JSONToString jsonToString = new org.example.json_with_gson.JSONToString();
		jsonToString.convertJsonToStringTest();
	}

	public static void testWithJson(){
		org.example.json_with_json.JsonToString jsonToString = new org.example.json_with_json.JsonToString();
		jsonToString.testJsonToString();
	}
}
