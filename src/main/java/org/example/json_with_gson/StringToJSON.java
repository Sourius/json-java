package org.example.json_with_gson;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class StringToJSON {
	private String getJSONString1() {
		return "{\"browsers\":{\"firefox\":{\"name\":\"Firefox\",\"pref_url\":\"about:config\",\"releases\":{\"1\":{\"release_date\":\"2004-11-09\",\"status\":\"retired\",\"engine\":\"Gecko\",\"engine_version\":\"1.7\"}}}}}";
	}

	private String getJSONString2() {
		return "{browsers:{firefox:{name:Firefox,pref_url:'about:config',releases:{1:{release_date:2004-11-09,status:retired,engine:Gecko,engine_version:1.7}}}}}";
	}

	private String getJSONString3() {
		return "{'browsers':{'firefox':{'name':'Firefox','pref_url':'about:config','releases':{'1':{'release_date':'2004-11-09','status':'retired','engine':'Gecko','engine_version':'1.7'}}}}}";
	}

	private JsonElement convertStringToJsonElement(String jsonString) {
		Gson gson = new Gson();
		JsonElement jsonElement = gson.fromJson(jsonString, JsonElement.class);
		return jsonElement;
	}

	private JsonObject convertStringToJsonObject(String jsonString) {
		Gson gson = new Gson();
		JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);
		return jsonObject;
	}

	public void convertStringToJSONObjectTest() {
		JsonObject jsonObject = convertStringToJsonObject(getJSONString1());
		System.out.println("json:" + jsonObject);
		JsonObject browsers = jsonObject.getAsJsonObject("browsers");
		System.out.println("browsers: " + browsers);
		JsonElement firefox = browsers.get("firefox");
		System.out.println("firefox: " + firefox);
		JsonObject releases = firefox.getAsJsonObject().get("releases").getAsJsonObject();
		System.out.println("releases:" + releases);
	}

	public void convertStringToJSONElementTest() {
		// don't forget that when you print an element toString function is executed
		JsonElement jsonElement = convertStringToJsonElement(getJSONString2());
		System.out.println("json:" + jsonElement);
		JsonElement browsers = jsonElement.getAsJsonObject().get("browsers");
		System.out.println("browsers: " + browsers);
		JsonElement firefox = browsers.getAsJsonObject().get("firefox");
		System.out.println("firefox: " + firefox);
		JsonObject releases = firefox.getAsJsonObject().getAsJsonObject("releases");
		System.out.println("releases:" + releases);
	}


}
