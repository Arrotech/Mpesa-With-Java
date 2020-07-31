package com.arrotech.mpesa.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.arrotech.mpesa.models.Mpesa;

@WebServlet("/AccountBalance")
public class AccountBalance extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AccountBalance() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String token = GenerateToken.access_token().toString();
			String authorization = "Bearer " + token;
			System.out.println(authorization);

			Mpesa mpesa = new Mpesa();

			JSONObject data = new JSONObject();
			try {
				String Initiator = mpesa.getInitiator().toString();
				data.put("Initiator", Initiator);
				String SecurityCredential = "VY3aZDy5S6H6B6XQmCCN8Jcxneo2/Nt8GH7PtWqeMJyaQ+3EJa3SyksJMCaB5zkdzw78WwRnXfqyLUadnWauG1s5Wluui7bmo+fad1FrN92z0Dtq4G9/gn5vOx+dUWcajH3gVMu48im1/7GS3zNLjqK227S7W4nCcBIBw+D5Ft9oblt2UOwGblXOxDkbmy7lRGe7xC2Rf7VZnmY/zIeicq70LDAPwjhWTFvY0ra1dWlPDxYIltJGbqDs86YaZbeqrZA1Bwh6eQN0BZCoWbf25dS8GhnZrFDUnJqqJRc5a04qtzz5ZnvppRDwZLmPr1kfrQ/s/196NtYMWeI1JG1qBQ==";
				data.put("SecurityCredential", SecurityCredential);
				String CommandID = "AccountBalance";
				data.put("CommandID", CommandID);
				String PartyA = "601356";
				data.put("PartyA", PartyA);
				String IdentifierType = mpesa.getIdentifierType().toString();
				data.put("IdentifierType", IdentifierType);
				String Remarks = mpesa.getRemarks();
				data.put("Remarks", Remarks);
				String QueueTimeOutURL = mpesa.getQueueTimeOutURL().toString();
				data.put("QueueTimeOutURL", QueueTimeOutURL);
				String ResultURL = mpesa.getResultURL().toString();
				data.put("ResultURL", ResultURL);
			

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			URL url = new URL("https://sandbox.safaricom.co.ke/mpesa/accountbalance/v1/query");
			HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("Accept", "application/json");
			con.setRequestProperty("Authorization", authorization);
			con.setDoOutput(true);

			String jsonInputString = data.toString();
			try (OutputStream os = con.getOutputStream()) {
				byte[] input = jsonInputString.getBytes("utf-8");
				os.write(input, 0, input.length);
			}

			System.out.println("jsoninput");

			System.out.println(jsonInputString);

			try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
				StringBuilder responseBody = new StringBuilder();
				String responseLine = null;
				while ((responseLine = br.readLine()) != null) {
					responseBody.append(responseLine.trim());
				}
				System.out.println(responseBody.toString());
				PrintWriter out = response.getWriter();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				out.print(responseBody);
				out.flush();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
