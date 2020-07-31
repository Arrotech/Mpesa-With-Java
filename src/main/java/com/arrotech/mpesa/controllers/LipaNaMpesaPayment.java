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

@WebServlet("/LipaNaMpesaPayment")
public class LipaNaMpesaPayment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LipaNaMpesaPayment() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String PartyB = request.getParameter("PartyB");

		if (PartyB.isEmpty()) {

			response.sendRedirect("lipa_na_mpesa.jsp");
		} else {

			try {

				String token = GenerateToken.access_token().toString();
				String authorization = "Bearer " + token;
				System.out.println(authorization);

				Mpesa mpesa = new Mpesa();

				JSONObject data = new JSONObject();
				try {
					String BusinessShortCode = mpesa.getBusinessShortCode().toString();
					data.put("BusinessShortCode", BusinessShortCode);
					String Password = "MTc0Mzc5YmZiMjc5ZjlhYTliZGJjZjE1OGU5N2RkNzFhNDY3Y2QyZTBjODkzMDU5YjEwZjc4ZTZiNzJhZGExZWQyYzkxOTIwMjAwNzMxMTA0NjMw";
					data.put("Password", Password);
					String Timestamp = mpesa.getTimestamp().toString();
					data.put("Timestamp", Timestamp);
					String TransactionType = mpesa.getTransactionType().toString();
					data.put("TransactionType", TransactionType);
					String Amount = mpesa.getAmount().toString();
					data.put("Amount", Amount);
					String PartyA = "254708374149";
					data.put("PartyA", PartyA);
					data.put("PartyB", PartyB);
					String PhoneNumber = "254708374149";
					data.put("PhoneNumber", PhoneNumber);
					String CallBackURL = mpesa.getCallBackURL().toString();
					data.put("CallBackURL", CallBackURL);
					String AccountReference = "test";
					data.put("AccountReference", AccountReference);
					String TransactionDesc = mpesa.getTransactionDesc().toString();
					data.put("TransactionDesc", TransactionDesc);

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				URL url = new URL("https://sandbox.safaricom.co.ke/mpesa/stkpush/v1/processrequest");
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
