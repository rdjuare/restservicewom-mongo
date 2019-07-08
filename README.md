# restservicewom-mongo
restservicewom-mongo
Prerequisitos

MongoDB Database
For example

docker run -d -p 27017-27019:27017-27019 --name mongodb mongo:4.0.4

Invocation EXample

POST INVOCATION
http://localhost:8081/restservicewom-mongo/resources/orders
Body Json example

{
  "beanOrigin": "Chile",
  "coffeeType": "Espresso"
}

Get
http://localhost:8081/restservicewom-mongo/resources/orders/2af33203-de3f-4aeb-b2c0-3a1b3c8a6b6c
