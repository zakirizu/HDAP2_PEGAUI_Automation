Feature: Request Group Scenarios

Background:
Given 	Launch the application URL

@ZR  @Sanity @regression
 Scenario:  Validate whether user is able to Open a RG
Given    Search for the RG ID "RG-1994"
Then     Swith to the Frame



@All @Smoke @ContactTask
 Scenario:  All Fields
Given 		Click on the My WorkList Header
Then 		Switch to the RG Frame
And     	Click on the First Available RG

@RGTaskZR
 Scenario:  All Fields
Given 		Click on the My WorkList Header
Then 		Switch to the RG Frame
And     	Click on the First Available RG







    
    
    
    
    
    
