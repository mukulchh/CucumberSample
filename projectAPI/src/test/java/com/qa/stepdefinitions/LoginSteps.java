package com.qa.stepdefinitions;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.apache.http.client.methods.CloseableHttpResponse;

import CucumberApiSampleProject.projectAPI.TestUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	private TestUtils testutils;
	private CloseableHttpResponse responseEntity;
	private Map<String, String> responseMap;

	public LoginSteps() {
		testutils = new TestUtils();
	}

	@Given("User has the valid API url")
	public void user_has_the_valid_api_url() {
		// Write code here that turns the phrase above into concrete actions

		// Assert.assertTrue(testutils.validurl("https://google.com"));
	}

	@When("User hit the api with valid credentials")
	public void user_hit_the_api_with_valid_credentials() throws Exception {
		responseMap = TestUtils.sendPOST("https://reqres.in/api/login");
		System.out.println(responseMap.get("responseBody"));

	}

	@Then("user get the status code as {string}")
	public void user_get_the_status_code_as(String expectedStatusCode) {
		String actualCode = responseMap.get("statusCode");
		System.out.println(actualCode);
		assertEquals(expectedStatusCode, actualCode);

	}

	@Then("user get the token in the response")
	public void user_get_the_token_in_the_response() {
		// get responseBody from responseMap
		
		// Convert the responseBody using ObjectMapper into map
		
		// map.get("token")
		
		// assertions: token not null, token not empty, token length = <length>
//		assertNotNull(token);
//		assertFalse(token.isEmpty())
//		assertEquals(<expected length value in int>, token.length())

	}
}