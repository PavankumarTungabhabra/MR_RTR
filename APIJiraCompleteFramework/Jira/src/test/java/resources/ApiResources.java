package resources;

public enum ApiResources {

	
	CreateJiraIssue("rest/api/3/issue"),
	GetJiraIssue("rest/api/3/issue/");
//	Attachevidence(""),
//	deleteJiraIddue(""),;

	private String resource;
	
	ApiResources(String resource) {
		
		this.resource=resource;
	}
	
	
	public String getResourceAPI()
	{
		return resource;
	}
	
}
