# Fetch Demo

This is my solution to the fetch coding challenge as found [here](https://github.com/fetch-rewards/receipt-processor-challenge)

## My Solution
My implementation for this coding challenge is written in Java 17 using SpringBoot 3 and an H2 database.  It is wrapped in a docker container for easy execution.

## Running the app

Note: This assumes you have Docker installed and running.
After cloning the project to your local machine:

 1. Open a terminal and navigate to the base directory for the project.
 2. Run `docker build -t fetch-demo . ` to build the docker image
 3. Once the image has finished building run `docker run -p 8080:8080 fetch-demo` to start the application
 4. Make Http requests against the api

### Curl Commands
These curl commands are examples of processing receipts and then retrieving their calculated points

#### Process a receipt with a value of 28 points

```curl
curl --location 'localhost:8080/receipts/process' \
--header 'Content-Type: application/json' \
--data  '{
"retailer": "Target",
"purchaseDate": "2022-01-01",
"purchaseTime": "13:01",
"items": [
{
"shortDescription": "Mountain Dew 12PK",
"price": "6.49"
},{
"shortDescription": "Emils Cheese Pizza",
"price": "12.25"
},{
"shortDescription": "Knorr Creamy Chicken",
"price": "1.26"
},{
"shortDescription": "Doritos Nacho Cheese",
"price": "3.35"
},{
"shortDescription": " Klarbrunn 12-PK 12 FL OZ ",
"price": "12.00"
}],
"total": "35.35"
}'
```

#### Creating a receipt with a value of 108 points
```curl
curl --location 'localhost:8080/receipts/process' \
--header 'Content-Type: application/json' \
--data  '{
"retailer": "M&M Corner Market",
"purchaseDate": "2022-03-20",
"purchaseTime": "14:33",
"items": [
{
"shortDescription": "Gatorade",
"price": "2.25"
},{
"shortDescription": "Gatorade",
"price": "2.25"
},{
"shortDescription": "Gatorade",
"price": "2.25"
},{
"shortDescription": "Gatorade",
"price": "2.25"
}],
"total": "9.00"
}'
```

#### Getting point values for coupons
The process requests return the id of the processed receipt. Using that id you can retrieve the points for that coupon as a path variable. 
```curl
curl --location 'localhost:8080/receipts/1/points'
```
### Using Postman
At the root level of the project there is the `fetch-demo.postman_collection` file that can be imported into postman to run these requests.
