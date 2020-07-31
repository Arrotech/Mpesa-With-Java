package com.arrotech.mpesa.models;

import com.google.gson.annotations.SerializedName;

public class Mpesa {

	private String Username = "dMXLnZsfKMmRJd3FpRmc7sGbnCzBBYBK";

	private String Passowrd = "o9bdqa3LBDs0gJgL";

	@SerializedName("InitiatorName")
	private String InitiatorName = "apitest356";

	@SerializedName("SecurityCredential")
	private String SecurityCredential = "VY3aZDy5S6H6B6XQmCCN8Jcxneo2/Nt8GH7PtWqeMJyaQ+3EJa3SyksJMCaB5zkdzw78WwRnXfqyLUadnWauG1s5Wluui7bmo+fad1FrN92z0Dtq4G9/gn5vOx+dUWcajH3gVMu48im1/7GS3zNLjqK227S7W4nCcBIBw+D5Ft9oblt2UOwGblXOxDkbmy7lRGe7xC2Rf7VZnmY/zIeicq70LDAPwjhWTFvY0ra1dWlPDxYIltJGbqDs86YaZbeqrZA1Bwh6eQN0BZCoWbf25dS8GhnZrFDUnJqqJRc5a04qtzz5ZnvppRDwZLmPr1kfrQ/s/196NtYMWeI1JG1qBQ==";

	@SerializedName("CommandID")
	private String CommandID = "SalaryPayment";

	@SerializedName("Amount")
	private String Amount = "10";

	@SerializedName("PartyA")
	private String PartyA = "601356";

	@SerializedName("PartyB")
	private String PartyB = "254708374149";

	@SerializedName("Remarks")
	private String Remarks = "Salary";

	@SerializedName("QueueTimeOutURL")
	private String QueueTimeOutURL = "http://google.com";

	@SerializedName("ResultURL")
	private String ResultURL = "http://uat.evirtualpay.com:8005/transactions/callback";

	@SerializedName("Occasion")
	private String Occasion = "Mpesa B2C";

	@SerializedName("SenderIdentifierType")
	private String SenderIdentifierType = "";

	@SerializedName("RecieverIdentifierType")
	private String RecieverIdentifierType = "";

	@SerializedName("AccountReference")
	private String AccountReference = "";

	@SerializedName("Initiator")
	private String Initiator = "apitest356";

	@SerializedName("BusinessShortCode")
	private String BusinessShortCode = "174379";

	@SerializedName("Timestamp")
	private String Timestamp = "20200731104630";

	@SerializedName("TransactionType")
	private String TransactionType = "CustomerPayBillOnline";

	@SerializedName("PhoneNumber")
	private String PhoneNumber = "254708374149";

	@SerializedName("CallBackURL")
	private String CallBackURL = "http://uat.evirtualpay.com:8005/transactions/callback";

	@SerializedName("TransactionDesc")
	private String TransactionDesc = "test";

	public Mpesa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getBusinessShortCode() {
		return BusinessShortCode;
	}

	public void setBusinessShortCode(String businessShortCode) {
		BusinessShortCode = businessShortCode;
	}

	public String getTimestamp() {
		return Timestamp;
	}

	public void setTimestamp(String timestamp) {
		Timestamp = timestamp;
	}

	public String getTransactionType() {
		return TransactionType;
	}

	public void setTransactionType(String transactionType) {
		TransactionType = transactionType;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getCallBackURL() {
		return CallBackURL;
	}

	public void setCallBackURL(String callBackURL) {
		CallBackURL = callBackURL;
	}

	public String getTransactionDesc() {
		return TransactionDesc;
	}

	public void setTransactionDesc(String transactionDesc) {
		TransactionDesc = transactionDesc;
	}

	public String getSenderIdentifierType() {
		return SenderIdentifierType;
	}

	public void setSenderIdentifierType(String senderIdentifierType) {
		SenderIdentifierType = senderIdentifierType;
	}

	public String getRecieverIdentifierType() {
		return RecieverIdentifierType;
	}

	public void setRecieverIdentifierType(String recieverIdentifierType) {
		RecieverIdentifierType = recieverIdentifierType;
	}

	public String getAccountReference() {
		return AccountReference;
	}

	public void setAccountReference(String accountReference) {
		AccountReference = accountReference;
	}

	public String getInitiator() {
		return Initiator;
	}

	public void setInitiator(String initiator) {
		Initiator = initiator;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassowrd() {
		return Passowrd;
	}

	public void setPassowrd(String passowrd) {
		Passowrd = passowrd;
	}

	public String getInitiatorName() {
		return InitiatorName;
	}

	public void setInitiatorName(String initiatorName) {
		InitiatorName = initiatorName;
	}

	public String getSecurityCredential() {
		return SecurityCredential;
	}

	public void setSecurityCredential(String securityCredential) {
		SecurityCredential = securityCredential;
	}

	public String getCommandID() {
		return CommandID;
	}

	public void setCommandID(String commandID) {
		CommandID = commandID;
	}

	public String getAmount() {
		return Amount;
	}

	public void setAmount(String amount) {
		Amount = amount;
	}

	public String getPartyA() {
		return PartyA;
	}

	public void setPartyA(String partyA) {
		PartyA = partyA;
	}

	public String getPartyB() {
		return PartyB;
	}

	public void setPartyB(String partyB) {
		PartyB = partyB;
	}

	public String getRemarks() {
		return Remarks;
	}

	public void setRemarks(String remarks) {
		Remarks = remarks;
	}

	public String getQueueTimeOutURL() {
		return QueueTimeOutURL;
	}

	public void setQueueTimeOutURL(String queueTimeOutURL) {
		QueueTimeOutURL = queueTimeOutURL;
	}

	public String getResultURL() {
		return ResultURL;
	}

	public void setResultURL(String resultURL) {
		ResultURL = resultURL;
	}

	public String getOccasion() {
		return Occasion;
	}

	public void setOccasion(String occasion) {
		Occasion = occasion;
	}

}
