package resources;

import Pojo.Body;
import Pojo.Issuetype;
import Pojo.Project;
import Pojo.fields;

public class PayLoad {
	
	public static Body JiraCreateIssuePayLoad()
	{
		Body bo= new Body();

		fields field=new fields();
		field.setSummary("DropDown Is Not working as Expected Madhu");
		Issuetype ist=new Issuetype();
		ist.setName("Bug");
		field.setIssuetype(ist);
		Project pj=new Project();
		pj.setKey("SCRUM1");
		field.setProject(pj);
		
		bo.setFields(field);
		return bo;
		
	}
}
