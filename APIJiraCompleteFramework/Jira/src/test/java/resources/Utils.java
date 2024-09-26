package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	public static	RequestSpecification reqSpec ;
	
	public  String globalData() throws IOException {
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//test//java//resources//globalData.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String baseUri = prop.getProperty("baseUri").toString();
		return baseUri;
		
		
	}
	public static String jiraToken()
	{
		return "Basic cGF2YW5rdW1hcnQ4NTVAZ21haWwuY29tOkFUQVRUM3hGZkdGMHRlcHkwazAzSUVoQkd4WExKQWlLeHV3c1dTZFhMRGNkSTVZUW8zZlZEc016WTAwbk5Sal9MRTV3aWhtQkhwRHUzdVZPQmxHcThXU0NZWk9VYlo0QWdUTGlHa3hxcjQ1ZlR5ZjQxU09LbXpPZzhfMGcybTBLNFFIWHdEODdXX3JyajlNY1ZDRkh4RjRWa05vRFRZTGxzRDVOTndDMHloamF0NFFybExybkUzVT1EQzc3RkRDNQ==";
	}
	
	
	
	public String JsonPath(Response response, String KeyValue)
	{
		
		String resp = response.asString();
		JsonPath js= new JsonPath(resp);
		return js.get(KeyValue).toString();
		
	}
	
	public  RequestSpecification CreateRequestSpecificationBuilder() throws IOException {
		if (reqSpec==null)
		{
			
		
		PrintStream log= new PrintStream(new FileOutputStream("logging.txt"));
		reqSpec= new RequestSpecBuilder().setBaseUri(globalData()).setContentType(ContentType.JSON)
		.addHeader("Authorization",jiraToken()).addFilter(RequestLoggingFilter.logRequestTo(log))
		.addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
		return reqSpec;
		}
		return reqSpec;
	}
}
