@tag
Feature: Application Login

  #Feature is collection of Scenarios
  ##This example is to write the Plan Gherkin Language
  #This is from Legion
  #This is From Legion Again
  @hcm     												@All
  Scenario: Login to the HDAP Application
    Given 			I want to write a step with precondition
    And 				some other precondition
    When 			I complete action
    And 				some other action
    And 				yet another action
    Then 			I validate the outcomes

  #Direclty passing the values into the Stepdefinition
  @addition @smoke     												@All
  Scenario: Adding of two Integers
    Given 		Here we are sending text as "Addition" and "Subratcion"
    Then 		Add 2 and 3
    Then 		Print the values of sum

  #Parametrizing the variables, In this case we need to pass the variable with syntax: "<variableName>"
  #By this method we can only send the value as String. As we are passing the values in : ""
  #To over come this we will be using the
  @scOutline     												@All
  Scenario Outline: Testing the Scenario outline
    Given 			Launch the url
    Then 			Enter the "<userName>" and "<passWord>"
    Then 			Close the browser

    Examples: 
      | userName | passWord |
      | Zakir    | Rizu     |
      | Zoya     | Amyrah   |
      | Younus   | Ameena   |

  #ScOutline with Regular Expression
  #Regular Expression- By this way we can send anything in the Variable
  #Syntax of Regular Expression: ^   (.+)  (.+)  $   -->In this example we are passing two variables
  #If you could see, by use of the RegExp we can send both String, Integer and Char
  @scOutlineRegEx1     												@All
  Scenario Outline: Testing the Scenario outline
    Given 			Launch the url of the Application
    Then 			Validate the <userName> and <passWord> in the Application
    Then 			Application closure

    Examples: 
      | userName 	| passWord 	|
      | Zakir    				| Rizu     				|
      | Zoya     			| Amyrah   		|																																		
      | Younus  			| Ameena   	|
      |       16 					|       26 					|
      | Z        					| R        					|

  #test
  #Sending the Data directly on to single step
  @DataAtStepLevel 													@All
  Scenario: Testing the APSRTC Application
    Given 				Launch the APSRTC Applicaiton
    Then 				Enter the Student data in the form
      | ZakirShaik    |
      | Kurnool       |
      | AndhraPradesh |
      | India         |
    Then 			Click on the submit button
    
    
    
    
    #If you want to run only specific test cases , Then we can give the tags like Smoke, Sanity and Regression 
    #If you want run smoke and sanity , then include these tags in the test scenario also include the tags by using or in the test runner
    #Run  with or & And 
    # <Or> means this will run the test cases with either of the tags to that test cases
    # <And> meand this will run test cases should have both the test cases for sure
    # <Not> This will skip all the test cases which are having that tag for that test case
    
    
    
    
    
    
    
    
    
    
    
