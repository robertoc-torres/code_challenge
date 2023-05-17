This project is a Lambda function that can be called from API Gateway on AWS, in order to deploy it follow these steps:

1. Create a Lambda function using JDK 11 
2. Upload the jar file on this repository
3. Create the API Gateway and add integration with the lambda function using POST HTTP verb
4. Test it on Postman

Expected input:

{
    "string": "asda" <- String to be encoded
}

You can directly test it on my env hitting this URL: https://mq8ea18j48.execute-api.us-east-2.amazonaws.com/myEncodingFunction

