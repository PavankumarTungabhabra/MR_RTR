package StepDefinition;

import io.cucumber.java.en.Given;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URI;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.ApiResources;
import resources.PayLoad;
import resources.Utils;

public class StepDefinitions extends Utils {
RequestSpecBuilder reqSpec;
Response response;
RequestSpecification reqPart ;
	
	
	@Given("CreateJiraIssue payLoad")
	public void create_jira_issue_pay_load() throws IOException  
	{
	  
		reqPart = given().spec(CreateRequestSpecificationBuilder()).body(PayLoad.JiraCreateIssuePayLoad());
	
	}
	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String APTResource, String Method) {
	 ApiResources APIRes = ApiResources.valueOf(APTResource);
	 System.out.println(APIRes);
	 
	 if (Method.equalsIgnoreCase("POST")) {
		response= reqPart.when().post(APIRes.getResourceAPI()).then().extract().response();
		
	}
	 else if (Method.equalsIgnoreCase("GET")) {
		response= reqPart.when().get(APIRes.getResourceAPI()).then().extract().response();
		
	}
	 }
	@Then("Jira Id should be created")
	public void jira_id_should_be_created() {
	    String JIra_Id = JsonPath(response, "id");
	    
	    System.out.println(JIra_Id);;
	}
	@Then("Status code should be {int}")
	public void status_code_should_be(Integer int1) {
		assertEquals(response.getStatusCode(), 201);
	}
	@Then("verify Id is created")
	public void verify_id_is_created() {
	    
	}

}
