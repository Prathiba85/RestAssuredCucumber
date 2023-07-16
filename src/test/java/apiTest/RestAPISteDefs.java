package apiTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

public class RestAPISteDefs {
	RequestSpecification request;
	Response response;
	public static int id;
	
	@Given("I have the endpoint as {string}")
	public void i_have_the_endpoint_as(String endpointURL) {
		
		request = RestAssured.given().baseUri(endpointURL);	   
	}

	@When("I perform get operation")
	public void i_perform_get_operation() {
		response = request.get(); 
	}

	@Then("I should get response as {int}")
	public void i_should_get_response_as(int expResponse) {
		Assert.assertEquals(expResponse, response.getStatusCode());   
	
	}

	@Given("I have the endpoint as {string} and like to perform post")
	public void i_have_the_endpoint_as_and_like_to_perform_post(String endpointURL) {
		  

		HashMap <String,Object> requestBody = new HashMap <String,Object>();
		
		requestBody.put("firstName","Piya");
		requestBody.put("lastName","Sankar");
		requestBody.put("salary","7000");
		requestBody.put("email","xxx@gmail.com");
		request = RestAssured.given().baseUri(endpointURL);	
		request.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(requestBody);
				
	}
	
	@When("I perform post operation")
	public void i_perform_post_operation() {
		
		response = request.post();
	    
	}
	
	@Then("I should get response for post as {int}")
	public void i_should_get_response_for_post_as(int expResponse) {
		Assert.assertEquals(expResponse, response.getStatusCode());   
	   
	}
	
	@When("I perform post operation with below data")
	public void i_perform_post_operation_with_below_data(Map <String,String> datamap) {
		
		response = request.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(datamap)
		.post();
		System.out.println("The response is "+ response.getBody().asString());
	    
	}
	@Then("Firstname should be {string} in response")
	public void firstname_should_be_in_response(String name) {
	    JsonPath jpath = response.jsonPath();
	    String actual_name = jpath.get("firstName");
	   id= jpath.get("id");
	    Assert.assertEquals(actual_name,name);
	}

	@When("I perform delete operation")
	public void i_perform_delete_operation() {
	    response = request.delete("\""+"/"+id+"\"");
	   // System.out.println(request.toString());
	}
}
