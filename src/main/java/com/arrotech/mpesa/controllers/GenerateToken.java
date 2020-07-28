package com.arrotech.mpesa.controllers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Base64;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONObject;

import com.arrotech.mpesa.models.Mpesa;

public class GenerateToken {

	public static String access_token() throws Exception {

		Mpesa mpesa = new Mpesa();

		String app_key = mpesa.getUsername().toString().trim();
		String app_secret = mpesa.getPassowrd().toString().trim();
		String appKeySecret = app_key + ":" + app_secret;
		String token = Base64.getEncoder().encodeToString(appKeySecret.getBytes());

		URL url = new URL("https://sandbox.safaricom.co.ke/oauth/v1/generate?grant_type=client_credentials");
		HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Content-Type", "application/json; utf-8");
		con.setRequestProperty("Accept", "application/json");
		con.setRequestProperty("authorization", "Basic " + token);
		con.setDoOutput(true);

		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
		StringBuilder responseBody = new StringBuilder();
		String responseLine = null;
		while ((responseLine = br.readLine()) != null) {
			responseBody.append(responseLine.trim());
		}
		JSONObject jsonObject = new JSONObject(responseBody.toString());
		final String access_token = jsonObject.getString("access_token").toString();

		return access_token;
	}

}
