Feature: Request Group Scenarios

Background:
Given Launch the Application

@CreateRGZR               @RunNow
 Scenario Outline:  Valdiate Whether User is able to create an RG with Single Contact
 Given Read ExcelData from CreateRGSheet  for  <TestCaseID>
Given 	Click on CreateRGButton
And     	Click on NextButton
Then 		Under Contact section Add a Single Contact
Then 		Enter Data in the  Request Group Settings section
Examples:
|		TestCaseID		|
|		CreateRG_AllSections		|


@CreateRG 	@CreateRG_With_SingleContact_SP_Mail  
 Scenario Outline:  Valdiate Whether User is able to create an RG with Single Contact
 Given Read ExcelData from CreateRGSheet  for  <TestCaseID>
Given 	Click on CreateRGButton
And     Click on NextButton
Then 		Under Contact section Add a Single Contact
Then 		Enter Data in the  Request Group Settings section with SendPreference of Mail

Examples:
|		TestCaseID	                  |
|		SP_Mail  |


@CreateRG 	@CreateRG_With_SingleContact_SP_Upload     
 Scenario Outline:  Valdiate Whether User is able to create an RG with Single Contact
 Given Read ExcelData from CreateRGSheet  for  <TestCaseID>
Given 	Click on CreateRGButton
And     Click on NextButton
Then 		Under Contact section Add a Single Contact
Then 		Enter Data in the  Request Group Settings section with SendPreference of Fax

Examples:
|		TestCaseID		|
|		SP_Fax		|


@CreateRG 	@CreateRG_With_SingleContact_SP_Fax
 Scenario Outline:  Valdiate Whether User is able to create an RG with Single Contact
 Given Read ExcelData from CreateRGSheet  for  <TestCaseID>
Given 	Click on CreateRGButton
And     Click on NextButton
Then 		Under Contact section Add a Single Contact
Then 		Enter Data in the  Request Group Settings section with SendPreference of Email

Examples:
|		TestCaseID		|
|		SP_Email		|

@CreateRG 	@CreateRG_With_SingleContact_SP_Fax         @RunNow
 Scenario Outline:  Valdiate Whether User is able to create an RG with Single Contact
 Given Read ExcelData from CreateRGSheet  for  <TestCaseID>
Given 	Click on CreateRGButton
And     Click on NextButton
Then 		Under Contact section Add a Single Contact
Then 		Enter Data in the  Request Group Settings section with SendPreference of Upload

Examples:
|		TestCaseID		|
|		SP_Upload		|





@CreateRG 	@CreateRG_With_SingleContact_SP_PrimayMail_CheckBox
 Scenario Outline:  Valdiate Whether User is able to create an RG with Single Contact
 Given Read ExcelData from CreateRGSheet  for  <TestCaseID>
Given 	Click on CreateRGButton
And     	Click on NextButton
Then 		Under Contact section Add a Single Contact
Then 		Enter Data in the  Request Group Settings section with SendPreference as Use primary contacts Mail address

Examples:
|		TestCaseID		|
|		SP_Mail_CheckBox		|


@CreateRG 					@CreateRG_With_SingleContact_SP_PrimayEmail_CheckBox
 Scenario Outline:  Valdiate Whether User is able to create an RG with Single Contact
 Given Read ExcelData from CreateRGSheet  for  <TestCaseID>
Given 	Click on CreateRGButton
And     	Click on NextButton
Then 		Under Contact section Add a Single Contact
Then 		Enter Data in the  Request Group Settings section with SendPreference as Use primary contacts Email address

Examples:
|		TestCaseID		|
|		SP_Email_CheckBox		|


@CreateRG 					@CreateRG_With_SingleContact_SP_PrimayFax_CheckBox
 Scenario Outline:  Valdiate Whether User is able to create an RG with Single Contact
 Given Read ExcelData from CreateRGSheet  for  <TestCaseID>
Given 	Click on CreateRGButton
And     Click on NextButton
Then 		Under Contact section Add a Single Contact
Then 		Enter Data in the  Request Group Settings section with SendPreference as Use primary contacts Fax address

Examples:
|		TestCaseID		|
|		SP_Fax_CheckBox		|


@CreateRG 					@CreateRG_With_SingleContact_SP_PrimayFax_CheckBox
 Scenario Outline:  Valdiate Whether User is able to create an RG with Single Contact
 Given Read ExcelData from CreateRGSheet  for  <TestCaseID>
Given 	Click on CreateRGButton
And     Click on NextButton
Then 		Under Contact section Add a Single Contact
Then 		Enter Data in the  Request Group Settings section with All Mandatory Fields

Examples:
|		TestCaseID		|
|		CreateRG_MandatoryFields  |


@CreateRG 					@CreateRG_With_SingleContact_SP_PrimayFax_CheckBox
 Scenario Outline:  Valdiate Whether User is able to create an RG with Single Contact
 Given Read ExcelData from CreateRGSheet  for  <TestCaseID>
Given 	Click on CreateRGButton
And     Click on NextButton
Then 		Under Contact section Add a Multiple Contacts

Examples:
|		TestCaseID		|
|		Multiple_Contacts  |


