package com.comparator.qa.OpenWeatherApi;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import com.comparator.qa.base.BaseClass;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetTempOWAPI extends BaseClass {
	
	static String CityName = prop.getProperty("City");
	static String unit = prop.getProperty("units");
	static String APIkey = prop.getProperty("appid");
	
	public static void main(String[] args) {
		try {
			new GetTempOWAPI().getTempfromOpenWeather(CityName,unit,APIkey );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public float getTempfromOpenWeather(String city, String unitValue, String key) throws IOException {

		RestAssured.baseURI = prop.getProperty("baseURI");
		Response response = null;
		HashMap<String, Float> tempdetails = new HashMap<String, Float>();
		float currentTemp = 0.00f;

		RequestSpecification request = RestAssured.given();
		try {
			response = request.log().all().queryParam("q", city).queryParam("units", unitValue).queryParam("appid", key)
					.when().get("/weather");
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Response :" + response.asString());
		System.out.println("Status Code :" + response.getStatusCode());

		// Initializing JsonPath object
		JsonPath jsonobj = response.jsonPath();
		tempdetails = jsonobj.get("main");
		for (Entry<String, Float> e : tempdetails.entrySet()) {
			// System.out.println(e.getKey()+" "+e.getValue());
			if (e.getKey().equals("temp")) {
				currentTemp = e.getValue();
			}
		}
		System.out.println("API: " + currentTemp);
		return currentTemp;

	}

}