Feature: Test feature

   
   #50 runs pre launch
   
   @api
    Scenario Outline: Create Chase Request with Single Matching RG
    Given Read ExcelData from CreateRGSheet   for  <TestCaseID>
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