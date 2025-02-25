Feature: Test feature
   
   
    @createChaseRequestData
    Scenario Outline: Create Chase Request with Single Matching RG
    Given Read ExcelData from API_Sheet for  <TestCaseID>
    Given Get the Data from the Request Group
    Given Get the Data from the Provider
    Given Create and Push the Chase Request
  
     Examples:
|		TestCaseID		|
|		API9	|
   
   
   
   
   
      @dryTest
    Scenario Outline: Create Chase Request with Single Matching RG
    Given Read ExcelData from API_Sheet for  <TestCaseID>
    Given Create Chase Request with Single Matching RG
  
     Examples:
|		TestCaseID		|
|		API9	|

   
   @SingleMatchingRG
    Scenario Outline: Create Chase Request with Single Matching RG
    Given Read ExcelData from API_Sheet for  <TestCaseID>
    Given Create Chase Request with Single Matching RG
  
     Examples:
|		TestCaseID		|
|		API2	|


   @Allin
    Scenario Outline: Create Chase Request with Single Matching RG
    Given Read ExcelData from API_Sheet for  <TestCaseID>
    Given Create Chase Request with Single Matching RG
  
     Examples:
|		TestCaseID		|
|		API1	|
|		API2	|
|		API3	|
|		API4	|
|		API5	|
|		API6	|
|		API7	|
|		API8	|


   @NoMatchingRG
    Scenario Outline: Create Chase Request with No Matching RG
    Given Read ExcelData from API_Sheet for  <TestCaseID>
    Given Create Chase Request with No Matching RG
  
   Examples:
|		TestCaseID		|
|		API1	|


   @MultipleMatchingRGs
    Scenario Outline: Create Chase Request with Multiple Matching RG
    Given Read ExcelData from API_Sheet for  <TestCaseID>
    Given Create Chase Request with Multiple Matching RG
     Examples:
|		TestCaseID		|
|		API1	|
