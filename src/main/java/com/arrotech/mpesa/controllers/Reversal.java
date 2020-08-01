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

@WebServlet("/Reversal")
public class Reversal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Reversal() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String TransactionID = request.getParameter("TransactionID");

		if (TransactionID.isEmpty()) {

			response.sendRedirect("reversal.jsp");
		} else {

			try {

				String token = GenerateToken.access_token().toString();
				String authorization = "Bearer " + token;
				System.out.println(authorization);

				Mpesa mpesa = new Mpesa();

				JSONObject data = new JSONObject();
				try {
					String Initiator = mpesa.getInitiator().toString();
					data.put("Initiator", Initiator);
					String SecurityCredential = mpesa.getSecurityCredential().toString();
					data.put("SecurityCredential", SecurityCredential);
					String CommandID = "TransactionReversal";
					data.put("CommandID", CommandID);
					data.put("TransactionID", TransactionID);
					String Amount = "500";
					data.put("Amount", Amount);
					String ReceiverParty = mpesa.getReceiverParty().toString();
					data.put("ReceiverParty", ReceiverParty);
					String RecieverIdentifierType = "4";
					data.put("RecieverIdentifierType", RecieverIdentifierType);
					String ResultURL = mpesa.getResultURL().toString();
					data.put("ResultURL", ResultURL);
					String QueueTimeOutURL = mpesa.getQueueTimeOutURL().toString();
					data.put("QueueTimeOutURL", QueueTimeOutURL);
					String Remarks = mpesa.getRemarks().toString();
					data.put("Remarks", Remarks);
					String Occasion = mpesa.getOccasion().toString();
					data.put("Occasion", Occasion);

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				URL url = new URL("https://sandbox.safaricom.co.ke/mpesa/reversal/v1/request");
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
