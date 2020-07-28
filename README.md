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

### Contributors

    Safaricom PLC

### Author

    Harun G. Gitundu