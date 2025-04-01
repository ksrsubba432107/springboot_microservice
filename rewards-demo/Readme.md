save the reward url:  http://localhost:9090/reward/create
input request: {
    "name": "subba1",
    "customerId": "abc12344",
    "cardNumber": "123456789"
}


fetch reward id:  url:  http://localhost:9090/reward/cust/abc123


// 3rd service

post :: http://localhost:9090/reward/pay

{
    "name": "subba1",
    "customerId": "abc12344",
    "cardNumber": "abc12344"
}