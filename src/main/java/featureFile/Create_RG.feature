Feature: Request Group Scenarios

Background:
Given Launch the Application

@CreateRGZR     @Zakirr
 Scenario Outline:  Create a RG with Single Contact & Fill all Sections under Request Group Settings Tab
 Given Read ExcelData from CreateRGSheet  for  <TestCaseID>
Given 	Click on CreateRGButton
And     	Click on NextButton
Then 		Under Contact section Add a Single Contact
And     Under RG Setting Tab Enter Request Group Name
And     Under RG Setting Tab Enter date under Contact Day Time Preference Section
And     Under RG Setting Tab Enter date for Special Instructions Section
And     Under RG Setting Tab Enter date for Retrieval Method  Section
And     Under RG Setting Tab Enter date for Workflow Settings Section
And     Under RG Setting Tab Enter date for Main address Section
And     Under RG Setting Tab Enter date for Letter Preference Section
And     Under RG Setting Tab Enter date for Payment Preference  Section
And     Under RG Setting Tab Enter date for Return Preference  Section
And     Under RG Setting Tab Enter date for Send Preference  Section
And     Enter Data in the Process For Rules
And     Click on the Submit button
Then   Validate the Success Message on the Create RG Screen
Examples:
|		TestCaseID		|
|		CreateRG_AllSections		|



@CreateRGZR                    @Zakirr
  Scenario Outline:  Create a RG with Single Contact & Fill Only Mandatory Sections under Request Group Settings Tab
 Given Read ExcelData from CreateRGSheet  for  <TestCaseID>
Given 	Click on CreateRGButton
And     	Click on NextButton
Then 		Under Contact section Add a Single Contact
Examples:
|		TestCaseID		|
|		CreateRG_AllSections		|


@CreateRGZR                    @Zakirr
  Scenario Outline:  Create a RG with Multile Contact & Fill All Sections under Request Group Settings Tab
 Given Read ExcelData from CreateRGSheet  for  <TestCaseID>
Given 	Click on CreateRGButton
And     	Click on NextButton
Then 		Under Contact section Add a Single Contact
Examples:
|		TestCaseID		|
|		CreateRG_AllSections		|


@CreateRGZR                    @Zakirr
  Scenario Outline:  Create a RG with Multiple Contact & Fill Only Mandatory Sections under Request Group Settings Tab
 Given Read ExcelData from CreateRGSheet  for  <TestCaseID>
Given 	Click on CreateRGButton
And     	Click on NextButton
Then 		Under Contact section Add a Single Contact
Examples:
|		TestCaseID		|
|		CreateRG_AllSections		|




@CreateRGZR                    @RunNow   
 Scenario Outline:  Valdiate Whether User is able to create an RG with Single Contact
 Given Read ExcelData from CreateRGSheet  for  <TestCaseID>
Given 	Click on CreateRGButton
And     	Click on NextButton
Then 		Under Contact section Add a Single Contact
Then 		Enter Data in the  Request Group Settings section
Then    Enter Data in the Process For Rules
Examples:
|		TestCaseID		|
|		CreateRG_AllSections		|


@CreateRG 	@CreateRG_With_SingleContact_SP_Mail         @RunNow
 Scenario Outline:  Create RG with Single Contact With Only Mandatory RG Settings and SendPreference as Mail
 Given Read ExcelData from CreateRGSheet  for  <TestCaseID>
Given 	Click on CreateRGButton
And     Click on NextButton
Then 		Under Contact section Add a Single Contact
Then 		Enter Data in the  Request Group Settings section with SendPreference of Mail

Examples:
|		TestCaseID	  |
|		SP_Mail  |


@CreateRG 	@CreateRG_With_SingleContact_SP_Upload        @RunNowZR
 Scenario Outline:  Create RG with Single Contact With Only Mandatory RG Settings and SendPreference as Fax
 Given Read ExcelData from CreateRGSheet  for  <TestCaseID>
Given 	Click on CreateRGButton
And     Click on NextButton
Then 		Under Contact section Add a Single Contact
Then 		Enter Data in the  Request Group Settings section with SendPreference of Fax

Examples:
|		TestCaseID		|
|		SP_Fax		|


@CreateRG 	@CreateRG_With_SingleContact_SP_Fax       @RunNow
 Scenario Outline:  Create RG with Single Contact With Only Mandatory RG Settings and SendPreference as Email
 Given Read ExcelData from CreateRGSheet  for  <TestCaseID>
Given 	Click on CreateRGButton
And     Click on NextButton
Then 		Under Contact section Add a Single Contact
Then 		Enter Data in the  Request Group Settings section with SendPreference of Email

Examples:
|		TestCaseID		|
|		SP_Email		|

@CreateRG 	@CreateRG_With_SingleContact_SP_Fax          @RunNow
 Scenario Outline:  Create RG with Single Contact With Only Mandatory RG Settings and SendPreference as Upload
 Given Read ExcelData from CreateRGSheet  for  <TestCaseID>
Given 	Click on CreateRGButton
And     Click on NextButton
Then 		Under Contact section Add a Single Contact
Then 		Enter Data in the  Request Group Settings section with SendPreference of Upload

Examples:
|		TestCaseID		|
|		SP_Upload		|


@CreateRG 	@CreateRG_With_SingleContact_SP_PrimayMail_CheckBox       @RunNow
 Scenario Outline:  Create RG with Single Contact With Only Mandatory RG Settings and SendPreference as CheckBox Mail Adress 
 Given Read ExcelData from CreateRGSheet  for  <TestCaseID>
Given 	Click on CreateRGButton
And     	Click on NextButton
Then 		Under Contact section Add a Single Contact
Then 		Enter Data in the  Request Group Settings section with SendPreference as Use primary contacts Mail address

Examples:
|		TestCaseID		|
|		SP_Mail_CheckBox		|


@CreateRG 					@CreateRG_With_SingleContact_SP_PrimayEmail_CheckBox      @RunNow
  Scenario Outline:  Create RG with Single Contact With Only Mandatory RG Settings and SendPreference as Primary Contacts Email
 Given Read ExcelData from CreateRGSheet  for  <TestCaseID>
Given 	Click on CreateRGButton
And     	Click on NextButton
Then 		Under Contact section Add a Single Contact
Then 		Enter Data in the  Request Group Settings section with SendPreference as Use primary contacts Email address

Examples:
|		TestCaseID		|
|		SP_Email_CheckBox		|


@CreateRG 					@CreateRG_With_SingleContact_SP_PrimayFax_CheckBox     @RunNow
  Scenario Outline:  Create RG with Single Contact With Only Mandatory RG Settings and SendPreference as Primary Contacts Fax
 Given Read ExcelData from CreateRGSheet  for  <TestCaseID>
Given 	Click on CreateRGButton
And     Click on NextButton
Then 		Under Contact section Add a Single Contact
Then 		Enter Data in the  Request Group Settings section with SendPreference as Use primary contacts Fax address

Examples:
|		TestCaseID		|
|		SP_Fax_CheckBox		|





