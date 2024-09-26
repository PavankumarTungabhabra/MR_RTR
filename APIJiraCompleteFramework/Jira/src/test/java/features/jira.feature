Feature: Validate Jira Create Issue

Scenario: Verify Jira Id is being Sucessfully created

Given CreateJiraIssue payLoad 
When user calls "CreateJiraIssue" with "Post" http request
Then Jira Id should be created
And Status code should be 201
