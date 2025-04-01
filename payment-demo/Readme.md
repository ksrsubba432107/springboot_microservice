save the payment url:  http://localhost:9091/payment/create
input request: {
    "status":"success",
    "card-number": "abc12344"
}


get:: http://localhost:9091/payment/getStatus/abc12344
