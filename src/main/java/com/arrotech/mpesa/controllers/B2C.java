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

@WebServlet("/B2C")
public class B2C extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public B2C() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String PartyB = request.getParameter("PartyB");

		if (PartyB.isEmpty()) {

			response.sendRedirect("b2c.jsp");
		} else {

			try {
				
				String token = GenerateToken.access_token().toString();
				String authorization = "Bearer " + token;
				System.out.println(authorization);

				Mpesa mpesa = new Mpesa();

				JSONObject data = new JSONObject();
				try {
					String InitiatorName = mpesa.getInitiatorName().toString();
					data.put("InitiatorName", InitiatorName);
					String SecurityCredential = mpesa.getSecurityCredential().toString();
					data.put("SecurityCredential", SecurityCredential);
					String CommandID = mpesa.getCommandID().toString();
					data.put("CommandID", CommandID);
					String Amount = mpesa.getAmount().toString();
					data.put("Amount", Amount);
					String PartyA = mpesa.getPartyA().toString();
					data.put("PartyA", PartyA);
					data.put("PartyB", PartyB);
					String Remarks = mpesa.getRemarks().toString();
					data.put("Remarks", Remarks);
					String QueueTimeOutURL = mpesa.getQueueTimeOutURL().toString();
					data.put("QueueTimeOutURL", QueueTimeOutURL);
					String ResultURL = mpesa.getResultURL().toString();
					data.put("ResultURL", ResultURL);
					String Occasion = mpesa.getOccasion().toString();
					data.put("Occasion", Occasion);

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				URL url = new URL("https://sandbox.safaricom.co.ke/mpesa/b2c/v1/paymentrequest");
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

}
