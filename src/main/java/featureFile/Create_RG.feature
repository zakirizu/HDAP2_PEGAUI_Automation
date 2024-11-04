Feature: Request Group Scenarios

Background:
Given Launch the Application

@CreateRGZR
 Scenario Outline:  Valdiate Whether User is able to create an RG with Single Contact
 Given Read ExcelData from CreateRGSheet  for  <TestCaseID>
Given 	Click on CreateRGButton
And     	Click on NextButton
Then 		Under Contact section Add a Single Contact
Then 		Enter Data in the  Request Group Settings section
Examples:
|		TestCaseID		|
|		happyPath		|


@CreateRG 					@CreateRG_With_SingleContact_SP_Email  @RunNow
 Scenario Outline:  Valdiate Whether User is able to create an RG with Single Contact
 Given Read ExcelData from CreateRGSheet  for  <TestCaseID>
Given 	Click on CreateRGButton
And     Click on NextButton
Then 		Under Contact section Add a Single Contact
Then 		Enter Data in the  Request Group Settings section with SendPreference of Email

Examples:
|		TestCaseID	                  |
|		sendPrefereneceEmail  |


@CreateRG 					@CreateRG_With_SingleContact_SP_Upload 
 Scenario Outline:  Valdiate Whether User is able to create an RG with Single Contact
 Given Read ExcelData from CreateRGSheet  for  <TestCaseID>
Given 	Click on CreateRGButton
And     	Click on NextButton
Then 		Under Contact section Add a Single Contact
Then 		Enter Data in the  Request Group Settings section with SendPreference of Email

Examples:
|		TestCaseID		|
|		happyPath		|


@CreateRG 					@CreateRG_With_SingleContact_SP_Fax
 Scenario Outline:  Valdiate Whether User is able to create an RG with Single Contact
 Given Read ExcelData from CreateRGSheet  for  <TestCaseID>
Given 	Click on CreateRGButton
And     	Click on NextButton
Then 		Under Contact section Add a Single Contact
Then 		Enter Data in the  Request Group Settings section with SendPreference of Fax

Examples:
|		TestCaseID		|
|		happyPath		|


@CreateRG 					@CreateRG_With_SingleContact_SP_PrimayMail_CheckBox
 Scenario Outline:  Valdiate Whether User is able to create an RG with Single Contact
 Given Read ExcelData from CreateRGSheet  for  <TestCaseID>
Given 	Click on CreateRGButton
And     	Click on NextButton
Then 		Under Contact section Add a Single Contact
Then 		Enter Data in the  Request Group Settings section with SendPreference as Use primary contacts Mail address

Examples:
|		TestCaseID		|
|		happyPath		|


@CreateRG 					@CreateRG_With_SingleContact_SP_PrimayEmail_CheckBox
 Scenario Outline:  Valdiate Whether User is able to create an RG with Single Contact
 Given Read ExcelData from CreateRGSheet  for  <TestCaseID>
Given 	Click on CreateRGButton
And     	Click on NextButton
Then 		Under Contact section Add a Single Contact
Then 		Enter Data in the  Request Group Settings section with SendPreference as Use primary contacts Email address

Examples:
|		TestCaseID		|
|		happyPath		|


@CreateRG 					@CreateRG_With_SingleContact_SP_PrimayFax_CheckBox
 Scenario Outline:  Valdiate Whether User is able to create an RG with Single Contact
 Given Read ExcelData from CreateRGSheet  for  <TestCaseID>
Given 	Click on CreateRGButton
And     	Click on NextButton
Then 		Under Contact section Add a Single Contact
Then 		Enter Data in the  Request Group Settings section with SendPreference as Use primary contacts Fax address

Examples:
|		TestCaseID		|
|		happyPath		|


@CreateRG 					@CreateRG_With_SingleContact_SP_Upload
 Scenario Outline:  Valdiate Whether User is able to create an RG with Single Contact
 Given Read ExcelData from CreateRGSheet  for  <TestCaseID>
Given 	Click on CreateRGButton
And     	Click on NextButton
Then 		Under Contact section Add a Single Contact
Then 		Enter Data in the  Request Group Settings section with SendPreference of Upload

Examples:
|		TestCaseID		|
|		happyPath		|

@CreateRG       @CreateRG_with_MultipleContacts
 Scenario Outline:  Valdiate Whether User is able to create an RG with Single Contact
 Given Read ExcelData from CreateRGSheet  for  <TestCaseID>
Given 	Click on CreateRGButton
And     	Click on NextButton
Then 		Under Contact section Add a Multiple Contact
Then 		Enter Data in the  Request Group Settings section
Examples:
|		TestCaseID		|
|		happyPath		|
