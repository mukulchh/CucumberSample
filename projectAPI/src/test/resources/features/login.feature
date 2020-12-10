Feature: Login Test

Scenario: Login Successful
Given User has the valid API url
When User hit the api with valid credentials
Then user get the status code as "200"
And user get the token in the response
