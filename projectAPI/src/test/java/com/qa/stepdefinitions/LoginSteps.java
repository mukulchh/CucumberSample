package com.qa.stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;

import CucumberApiSampleProject.projectAPI.TestUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	private TestUtils testutils;
	private CloseableHttpResponse responseEntity;
	public LoginSteps() {
		 testutils = new TestUtils();
	}

	@Given("User has the valid API url")
	public void user_has_the_valid_api_url() {
		// Write code here that turns the phrase above into concrete actions
		
		//Assert.assertTrue(testutils.validurl("https://google.com"));
	}

	@When("User hit the api with valid credentials")
	public void user_hit_the_api_with_valid_credentials() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		responseEntity= (CloseableHttpResponse) TestUtils.sendPOST("https://reqres.in/api/login");
		//responseEntity.getStatusLine().getStatusCode();
		//System.out.println(responseEntity);
		String result = EntityUtils.toString(responseEntity.getEntity());
        System.out.println(result);
		
		
		
	}

	@Then("user get the status code as {string}")
	public void user_get_the_status_code_as(String statusCode) {
		// Write code here that turns the phrase above into concrete actions
		//int actual = responseEntity.getStatusLine().getStatusCode();
		assertEquals(200, responseEntity.getStatusLine().getStatusCode());
	}

	@Then("user get the token in the response")
	public void user_get_the_token_in_the_response() {
		// Write code here that turns the phrase above into concrete actions
	
	

	}
}