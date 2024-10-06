Feature: DQA Task Related Scenarios

Background:
Given Launch the Application



@DQATask
 Scenario Outline:  Valdiate Whether User is able to perform DQA Task
 Given 		Search for the User RG ID <RequestGroupID>
 Given 		Add the task <Task>
 Given 		Click on CreateRGButton

Examples: 
      | RequestGroupID 						| Task 																														|
      | RET-9642869539    						| Exception Request     													|
      | RET-9642869539    						| DQAQDS															    									|


    
    
    
