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









    
    
    
    
    
    
