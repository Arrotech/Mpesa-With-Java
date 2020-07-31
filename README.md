## MPESA API's INTEGRATION

`Consume` MPESA API's with `Java`.
Such  API's include:

1. B2C API
2. B2B API
3. C2B API
4. Account Balance API
5. Transaction Status
6. Reversal
7. Lipa na M-Pesa Online Payment
8. Lipa na M-Pesa Online Query Request

### Generate Authentication Token

To make an API call, you will need to `authenticate your app`. To authorize your API call to the OAuth API, you will need a `Basic Auth` over `HTTPS authorization token`. The Basic Auth string is a `base64 encoded string` of your app’s `client key` and `client secret`.

Send the request to the following url: https://sandbox.safaricom.co.ke/oauth/v1/generate?grant_type=client_credentials

	method is GET
	
### B2C

`Business to Customer` refers to a scenario where a business entity `makes a payment(s)` to it’s `customer(s) via MPESA`. `FutureVH` will handle your organization’s  B2C integration to enable it make payments from it’s `Financial system / ERP directly` to  customers via your M-PESA `paybill account`.

Send the request to the following url: 
	
	
### B2B

`Business to Business` refers to a scenario where one business entity `makes a payment` to another business entity. An organization can make payments to other businesses directly from the `organization’s paybill` number to the `businesses’ paybill number`.

Send the request to the following url: https://sandbox.safaricom.co.ke/mpesa/b2b/v1/paymentrequest

	method is POST
	
### Lipa Na Mpesa Online Payment

`Lipa na M-Pesa Online Payment API` is used to `initiate` a M-Pesa transaction on behalf of a customer using `STK Push`. This is the same technique `mySafaricom App` uses whenever the app is used to make payments.

Send the request to the following url: https://sandbox.safaricom.co.ke/mpesa/stkpush/v1/processrequest

	method is POST
	
### Account Balance

The `Account Balance API` requests for the `account balance` of a `shortcode`.

Send the request to the following url: https://sandbox.safaricom.co.ke/mpesa/accountbalance/v1/query

	method is POST
	
### Transaction Status

`Transaction Status API` checks the `status` of a `B2B, B2C and C2B APIs transactions`.

Send the request to the following url: https://sandbox.safaricom.co.ke/mpesa/transactionstatus/v1/query

	method is POST

### Contributors

    Safaricom PLC

### Author

    Harun G. Gitundu