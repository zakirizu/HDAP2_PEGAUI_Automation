package stepDefinitionFile;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import factory.ReadDataFromExcel;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.DependencyInjection;
import utils.KeyWords;



public class Create_RG_Sd {
	
    public DependencyInjection obj;
    Scenario s;
	public Create_RG_Sd(DependencyInjection obj)
	{
		this.obj = obj;
	}
	
	static Logger 						myLogger 	= LogManager.getLogger(Create_RG_Sd.class.getName());

//Add this piece of code to read data from Excel Sheet. Change the Sheet Name
	HashMap<String,String> testData;	
	@Then("^Read ExcelData from CreateRGSheet  for  (.+)$")
	public HashMap<String, String> ReadExcelSheetDataFromSheet( String TestCaseID) {		
		testData = ReadDataFromExcel.getExcelData("createRG", TestCaseID);
		return testData;		
	}
		
	@Given("Click on CreateRGButton")
	public void Click_on_CreateRGButton() {	
		obj.keyWords().switchToDefaultContent();		
		obj.keyWords().clickElement(obj.getPageCreateRG().getBtn_createRG());		
		obj.driver.switchTo().frame(obj.getPageCreateRG().getFrame_CreateRG());
		
		//obj.keyWords().switchFrameByWebElement(obj.getPageCreateRG().getFrame_CreateRG());		
	}
	
	@Then("Switch to CreateRG Fame")
	public void switchToCreateRGFrame() {
		obj.keyWords().switchFrameByWebElement(obj.getPageCreateRG().getFrame_CreateRG());
	}
		
	@Then("Click on NextButton")
	public void Click_On_Next_Button() {
		obj.keyWords().clickElement(obj.getPageCreateRG().getBtn_Next());
	}
	
	@Then("Under Contact section Add a Multiple Contact")
	public void AddMultipleContact() throws InterruptedException {
	}
	
	
	
	@Then("Under Contact section Add a Single Contact")
	public void AddaSingleContact() throws InterruptedException {
		obj.keyWords().clickElement(obj.getPageCreateRG().getAddContact_btn());
		obj.keyWords().selectByValue(obj.getPageCreateRG().getContactType_ddl(), testData.get("contactType"));
		obj.keyWords().selectByValue(obj.getPageCreateRG().getDepartment_ddl(), testData.get("department"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getName_txtbox(),testData.get("name"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getRole_txtbox(),testData.get("role"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getEmail_txtbox(),testData.get("email"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getPhone_txtbox(),testData.get("phone"));
		Thread.sleep(2000);
		obj.getPageCreateRG().getPhone_txtbox().sendKeys(Keys.TAB);
		Thread.sleep(2000);
		obj.keyWords().sendKeys(obj.getPageCreateRG().getExt_txtbox(),testData.get("ext"));
		obj.getPageCreateRG().getExt_txtbox().sendKeys(Keys.TAB);
		Thread.sleep(2000);
		obj.keyWords().sendKeys(obj.getPageCreateRG().getFax_txtbox(),testData.get("fax"));		
		obj.getPageCreateRG().getFax_txtbox().sendKeys(Keys.TAB);
		Thread.sleep(2000);
		obj.keyWords().selectByValue(obj.getPageCreateRG().getPreferred_method_txtbox(), testData.get("preferredMethod"));	
		Thread.sleep(2000);
		obj.keyWords().selectByValue(obj.getPageCreateRG().getTimezone_ddl(), testData.get("timeZoneContact"));	
		Thread.sleep(6000);
		obj.keyWords().clickElement(obj.getPageCreateRG().getcustomerAccSummary_btn());
		obj.keyWords().clickElement(obj.getPageCreateRG().getContacts_Nextbtn());
	
		
	}

	
	@Then("Enter Data in the  Request Group Settings section")
	public void EnterDataintheRequestGroupSettingssection() throws InterruptedException {
		
	  //Configuration Request Group Name TxtBox
		obj.keyWords().sendKeys(obj.getPageCreateRG().getRequest_Group_Name_Txtbox(), testData.get("requestGroupName"));
		
	  //ContactDay/Time Preference	
		obj.keyWords().selectByValue(obj.getPageCreateRG().getTimezoneRequestGroupSetting_ddl(), testData.get("timeZoneRG"));	
		
	  //Special Instruction Section	
		obj.keyWords().sendKeys(obj.getPageCreateRG().getInstruction_Txtbox(), testData.get("instructions"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getNext_Review_Txtbox(), Common_Functions_Sd.getNextReviewDate(1));
		Thread.sleep(2000);
		
	  //Retrieval Method Section	
		obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getRetrivalMethod_ddl(), testData.get("retrievalMethods"));	
		obj.keyWords().SendKeys_Into_AutoSuggestiveTextBox(obj.getPageCreateRG().getEMRsystem_Txtbox(),testData.get("EMR System_TxtBox"));
		
	  //WorkFlow Section	
		obj.keyWords().sendKeys(obj.getPageCreateRG().getOwner_Txtbox(), testData.get("wfSettingOwner"));		
		obj.keyWords().clickElement(obj.getPageCreateRG().getOnly_Owner_Checkbox());;
		obj.keyWords().clickElement(obj.getPageCreateRG().getContact_Will_Checkbox());
		obj.keyWords().clickElement(obj.getPageCreateRG().getContact_Will_Confirm_Checkbox());	
	    obj.keyWords().clickElement(obj.getPageCreateRG().getExcluded_Checkbox());
        obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getReasonforExclusion_Txtbox(),testData.get("ReasonExclusion"));
        obj.keyWords().sendKeys(obj.getPageCreateRG().getWebsite_Txtbox(),testData.get("WebSite"));
	
	  //Main Address Section	
		obj.keyWords().sendKeys(obj.getPageCreateRG().getMainAddressAttn_Txtbox(),testData.get("MA_AttnTo"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getMainAddressAddress_Txtbox(),testData.get("MA_Address"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getMainAddressAddress2_Txtbox(),testData.get("MA_Address_Line2"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getMainAddressCity_Txtbox(),testData.get("MA__City"));
	    obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getMainAddressState_ddl(),testData.get("MA_State"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getMainAddressZipcode_Txtbox(),testData.get("MA_Zip_Code"));
	 
	 //letter Preference Section
	   obj.keyWords().selectByValue(obj.getPageCreateRG().getLetterPreference_ddl(), testData.get("LP_SendingLetterCheck"));
       obj.keyWords().clickElement(obj.getPageCreateRG().getUse_facility_checkbox());
	   obj.keyWords().clickElement(obj.getPageCreateRG().getGroup_letter_checkbox());
	   obj.keyWords().sendKeys(obj.getPageCreateRG().getLettersperbatch_sendkeys(),testData.get("Lettersforbatch_Checkbox"));		
	
	 //Include Additional Data All checkboxes  
	   obj.keyWords().clickElement(obj.getPageCreateRG().getClaim_Entity_checkbox());
	   obj.keyWords().clickElement(obj.getPageCreateRG().getFacility_address_checkbox());
	   obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_name_ddl());
	   obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_DOB_checkbox());
	   obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_address_checkbox());
	   obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_age_checkbox());
	   obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_phone_checkbox());
	   obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_Email_checkbox());
	   obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_Name_checkbox());
	   obj.keyWords().clickElement(obj.getPageCreateRG().getProvider_verification_checkbox());
	   obj.keyWords().clickElement(obj.getPageCreateRG().getProject_checkbox());
	   obj.keyWords().clickElement(obj.getPageCreateRG().getDate_of_service_checkbox());
	   obj.keyWords().clickElement(obj.getPageCreateRG().getAdditional_checkbox());
	   
	  //Payment Preference Section
	    obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getPayment_preference_ddl(),testData.get("PaymentPreference_DDL"));	
	    obj.keyWords().shortWait();
	    obj.keyWords().SendKeys_Into_AutoSuggestiveTextBox(obj.getPageCreateRG().getCardtype_txtbox(),testData.get("Cardtype_ddl"));
   	    obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getPayVia_ddl(),testData.get("PayVia_ddl"));
	   
   	  //Return Preference Section
	    obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getReturn_prefernce_ddl(),testData.get("ReturnPreference_DDL"));
	   
      //Send Preference of type Mail Section
	    obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getSend_preference_ddl(),testData.get("SP_DDL"));
		obj.keyWords().explicitWait_Until_ElementDisplayed(obj.getPageCreateRG().getSPUsemainaddress_checkbox());
		obj.getPageCreateRG().getSend_preference_ddl().sendKeys(Keys.TAB);
		Thread.sleep(2000);
		//obj.getPageCreateRG().getSPUsemainaddress_checkbox().click();
	    //obj.keyWords().clickElement(obj.getPageCreateRG().getSPUsemainaddress_checkbox());
		obj.keyWords().sendKeys(obj.getPageCreateRG().getSPAttnTo_Textbox(),testData.get("SP_AttnTo_textbox"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getSPAddress_Textbox(),testData.get("SP_Address_textbox"));
		obj.keyWords().selectByValue(obj.getPageCreateRG().getSPAddressLines2_Textbox(),testData.get("SP_Addressline2_Textbox"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getSPCity_Textbox(),testData.get("SPCity_Textbox"));
		obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getSPState_ddl(),testData.get("SPState_DDL"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getSPZipCode_textbox(),testData.get("SP_ZipCode_Textbox"));
		
      //This code is for SP_Override Section
		obj.keyWords().clickElement(obj.getPageCreateRG().getADDOverride_BTN());
		obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getSPOverride_ddl(),testData.get("SPOverride_DDL"));
		obj.keyWords().clickElement(obj.getPageCreateRG().getSPOverride_UseRequestGroup__Checkbox());
		obj.keyWords().sendKeys(obj.getPageCreateRG().getAttn_Txtbox(),testData.get("SP_Override_AttnTo_Textbox"));		
		obj.keyWords().sendKeys(obj.getPageCreateRG().getSPOverride_Address_textbox(),testData.get("SP_Override_Address_Textbox"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getSPOverride_AddressLines2_textbox(),testData.get("SP_Override_Address2_Textbox"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getSPOverride_City_textbox(),testData.get("SP_Override_City_Textbox"));
		obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getSPOverride_State_ddl(),testData.get("SP_Override__State_DDL"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getSPOverride_ZipCode_textbox(),testData.get("SP_Override__Zipcode_Textbox"));
		
		obj.keyWords().clickElement(obj.getPageCreateRG().getNext_button());   
		

	}

	@Then("Enter Data in the  Request Group Settings section with SendPreference of Mail")
	 public void EnterDataintheRequestGroupSettingssectionwithSendPreferenceofMail() throws InterruptedException {
		

		//Configuration Request Group Name TxtBox
		obj.keyWords().sendKeys(obj.getPageCreateRG().getRequest_Group_Name_Txtbox(), testData.get("requestGroupName"));
				
		//ContactDay/Time Preference	
		obj.keyWords().selectByValue(obj.getPageCreateRG().getTimezoneRequestGroupSetting_ddl(), testData.get("timeZoneRG"));	
				
		//Special Instruction Section	
		obj.keyWords().sendKeys(obj.getPageCreateRG().getInstruction_Txtbox(), testData.get("instructions"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getNext_Review_Txtbox(), Common_Functions_Sd.getNextReviewDate(1));
		Thread.sleep(2000);
				
		//Retrieval Method Section	
		obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getRetrivalMethod_ddl(), testData.get("retrievalMethods"));	
		obj.keyWords().SendKeys_Into_AutoSuggestiveTextBox(obj.getPageCreateRG().getEMRsystem_Txtbox(),testData.get("EMR System_TxtBox"));
				
    	//WorkFlow Section	
		obj.keyWords().sendKeys(obj.getPageCreateRG().getOwner_Txtbox(), testData.get("wfSettingOwner"));		
		obj.keyWords().clickElement(obj.getPageCreateRG().getOnly_Owner_Checkbox());;
		obj.keyWords().clickElement(obj.getPageCreateRG().getContact_Will_Checkbox());
		obj.keyWords().clickElement(obj.getPageCreateRG().getContact_Will_Confirm_Checkbox());	
	    obj.keyWords().clickElement(obj.getPageCreateRG().getExcluded_Checkbox());
		obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getReasonforExclusion_Txtbox(),testData.get("ReasonExclusion"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getWebsite_Txtbox(),testData.get("WebSite"));
			
		//Main Address Section	
	    obj.keyWords().sendKeys(obj.getPageCreateRG().getMainAddressAttn_Txtbox(),testData.get("MA_AttnTo"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getMainAddressAddress_Txtbox(),testData.get("MA_Address"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getMainAddressAddress2_Txtbox(),testData.get("MA_Address_Line2"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getMainAddressCity_Txtbox(),testData.get("MA__City"));
	    obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getMainAddressState_ddl(),testData.get("MA_State"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getMainAddressZipcode_Txtbox(),testData.get("MA_Zip_Code"));
			 
	    //letter Preference Section
		obj.keyWords().selectByValue(obj.getPageCreateRG().getLetterPreference_ddl(), testData.get("LP_SendingLetterCheck"));
		obj.keyWords().clickElement(obj.getPageCreateRG().getUse_facility_checkbox());
	    obj.keyWords().clickElement(obj.getPageCreateRG().getGroup_letter_checkbox());
	    obj.keyWords().sendKeys(obj.getPageCreateRG().getLettersperbatch_sendkeys(),testData.get("Lettersforbatch_Checkbox"));		
			
	    //Include Additional Data All checkboxes  
	     obj.keyWords().clickElement(obj.getPageCreateRG().getClaim_Entity_checkbox());
	     obj.keyWords().clickElement(obj.getPageCreateRG().getFacility_address_checkbox());
    	 obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_name_ddl());
	     obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_DOB_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_address_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_age_checkbox());
	     obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_phone_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_Email_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_Name_checkbox());
	     obj.keyWords().clickElement(obj.getPageCreateRG().getProvider_verification_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getProject_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getDate_of_service_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getAdditional_checkbox());
			   
		 /*Payment Preference Section
		  obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getPayment_preference_ddl(),testData.get("PaymentPreference_DDL"));	
		  obj.keyWords().shortWait();
		  obj.keyWords().SendKeys_Into_AutoSuggestiveTextBox(obj.getPageCreateRG().getCardtype_txtbox(),testData.get("Cardtype_ddl"));
		  obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getPayVia_ddl(),testData.get("PayVia_ddl")); */
			   
		  //Return Preference Section
		  obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getReturn_prefernce_ddl(),testData.get("ReturnPreference_DDL"));
			   
	      //Send Preferece of type Mail Section
		  obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getSend_preference_ddl(),testData.get("SP_DDL"));
		  obj.keyWords().explicitWait_Until_ElementDisplayed(obj.getPageCreateRG().getSPUsemainaddress_checkbox());
		  obj.getPageCreateRG().getSend_preference_ddl().sendKeys(Keys.TAB);
		  Thread.sleep(2000);
		  //obj.getPageCreateRG().getSPUsemainaddress_checkbox().click();
		  //obj.keyWords().clickElement(obj.getPageCreateRG().getSPUsemainaddress_checkbox());
		  obj.keyWords().sendKeys(obj.getPageCreateRG().getSPAttnTo_Textbox(),testData.get("SP_AttnTo_textbox"));
		  obj.keyWords().sendKeys(obj.getPageCreateRG().getSPAddress_Textbox(),testData.get("SP_Address_textbox"));
		  obj.keyWords().selectByValue(obj.getPageCreateRG().getSPAddressLines2_Textbox(),testData.get("SP_Addressline2_Textbox"));
		  obj.keyWords().sendKeys(obj.getPageCreateRG().getSPCity_Textbox(),testData.get("SPCity_Textbox"));
		  obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getSPState_ddl(),testData.get("SPState_DDL"));
		  obj.keyWords().sendKeys(obj.getPageCreateRG().getSPZipCode_textbox(),testData.get("SP_ZipCode_Textbox"));
			
		  obj.keyWords().clickElement(obj.getPageCreateRG().getNext_button());   
			
		
		}

	
	@Then("Enter Data in the  Request Group Settings section with SendPreference of Fax")
	public void EnterDataintheRequestGroupSettingssectionwithSendPreferenceofFax() throws InterruptedException {

		 //Configuration Request Group Name TxtBox
		obj.keyWords().sendKeys(obj.getPageCreateRG().getRequest_Group_Name_Txtbox(), testData.get("requestGroupName"));
				
		//ContactDay/Time Preference	
		obj.keyWords().selectByValue(obj.getPageCreateRG().getTimezoneRequestGroupSetting_ddl(), testData.get("timeZoneRG"));	
				
		//Special Instruction Section	
		obj.keyWords().sendKeys(obj.getPageCreateRG().getInstruction_Txtbox(), testData.get("instructions"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getNext_Review_Txtbox(), Common_Functions_Sd.getNextReviewDate(1));
		Thread.sleep(2000);
				
		//Retrieval Method Section	
		obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getRetrivalMethod_ddl(), testData.get("retrievalMethods"));	
		obj.keyWords().SendKeys_Into_AutoSuggestiveTextBox(obj.getPageCreateRG().getEMRsystem_Txtbox(),testData.get("EMR System_TxtBox"));
				
    	//WorkFlow Section	
		obj.keyWords().sendKeys(obj.getPageCreateRG().getOwner_Txtbox(), testData.get("wfSettingOwner"));		
		obj.keyWords().clickElement(obj.getPageCreateRG().getOnly_Owner_Checkbox());;
		obj.keyWords().clickElement(obj.getPageCreateRG().getContact_Will_Checkbox());
		obj.keyWords().clickElement(obj.getPageCreateRG().getContact_Will_Confirm_Checkbox());	
	    obj.keyWords().clickElement(obj.getPageCreateRG().getExcluded_Checkbox());
		obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getReasonforExclusion_Txtbox(),testData.get("ReasonExclusion"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getWebsite_Txtbox(),testData.get("WebSite"));
			
		//Main Address Section	
	    obj.keyWords().sendKeys(obj.getPageCreateRG().getMainAddressAttn_Txtbox(),testData.get("MA_AttnTo"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getMainAddressAddress_Txtbox(),testData.get("MA_Address"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getMainAddressAddress2_Txtbox(),testData.get("MA_Address_Line2"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getMainAddressCity_Txtbox(),testData.get("MA__City"));
	    obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getMainAddressState_ddl(),testData.get("MA_State"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getMainAddressZipcode_Txtbox(),testData.get("MA_Zip_Code"));
			 
	    //letter Preference Section
		obj.keyWords().selectByValue(obj.getPageCreateRG().getLetterPreference_ddl(), testData.get("LP_SendingLetterCheck"));
		obj.keyWords().clickElement(obj.getPageCreateRG().getUse_facility_checkbox());
	    obj.keyWords().clickElement(obj.getPageCreateRG().getGroup_letter_checkbox());
	    obj.keyWords().sendKeys(obj.getPageCreateRG().getLettersperbatch_sendkeys(),testData.get("Lettersforbatch_Checkbox"));		
			
	    //Include Additional Data All checkboxes  
	     obj.keyWords().clickElement(obj.getPageCreateRG().getClaim_Entity_checkbox());
	     obj.keyWords().clickElement(obj.getPageCreateRG().getFacility_address_checkbox());
    	 obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_name_ddl());
	     obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_DOB_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_address_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_age_checkbox());
	     obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_phone_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_Email_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_Name_checkbox());
	     obj.keyWords().clickElement(obj.getPageCreateRG().getProvider_verification_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getProject_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getDate_of_service_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getAdditional_checkbox());
			   
		 //Payment Preference Section
		  obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getPayment_preference_ddl(),testData.get("PaymentPreference_DDL"));	
		  obj.keyWords().shortWait();
		  obj.keyWords().SendKeys_Into_AutoSuggestiveTextBox(obj.getPageCreateRG().getCardtype_txtbox(),testData.get("Cardtype_ddl"));
		  obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getPayVia_ddl(),testData.get("PayVia_ddl"));
			   
		  //Return Preference Section
		  obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getReturn_prefernce_ddl(),testData.get("ReturnPreference_DDL"));
			   
	      //Send Preferece of type Mail Section
		  obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getSend_preference_ddl(),testData.get("SP_DDL"));
		  obj.keyWords().sendKeys(obj.getPageCreateRG().getSPFax_textbox(),testData.get("SP_Fax_Number")); 	
		  obj.keyWords().clickElement(obj.getPageCreateRG().getNext_button());   
		
		      				
	}
	
	
	@Then("Enter Data in the  Request Group Settings section with SendPreference of Email")
	public void EnterDataintheRequestGroupSettingssectionwithSendPreferenceofEmail() throws InterruptedException {
	
		 //Configuration Request Group Name TxtBox
		obj.keyWords().sendKeys(obj.getPageCreateRG().getRequest_Group_Name_Txtbox(), testData.get("requestGroupName"));
				
		//ContactDay/Time Preference	
		obj.keyWords().selectByValue(obj.getPageCreateRG().getTimezoneRequestGroupSetting_ddl(), testData.get("timeZoneRG"));	
				
		//Special Instruction Section	
		obj.keyWords().sendKeys(obj.getPageCreateRG().getInstruction_Txtbox(), testData.get("instructions"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getNext_Review_Txtbox(), Common_Functions_Sd.getNextReviewDate(1));
		Thread.sleep(2000);
				
		//Retrieval Method Section	
		obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getRetrivalMethod_ddl(), testData.get("retrievalMethods"));	
		obj.keyWords().SendKeys_Into_AutoSuggestiveTextBox(obj.getPageCreateRG().getEMRsystem_Txtbox(),testData.get("EMR System_TxtBox"));
				
    	//WorkFlow Section	
		obj.keyWords().sendKeys(obj.getPageCreateRG().getOwner_Txtbox(), testData.get("wfSettingOwner"));		
		obj.keyWords().clickElement(obj.getPageCreateRG().getOnly_Owner_Checkbox());;
		obj.keyWords().clickElement(obj.getPageCreateRG().getContact_Will_Checkbox());
		obj.keyWords().clickElement(obj.getPageCreateRG().getContact_Will_Confirm_Checkbox());	
	    obj.keyWords().clickElement(obj.getPageCreateRG().getExcluded_Checkbox());
		obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getReasonforExclusion_Txtbox(),testData.get("ReasonExclusion"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getWebsite_Txtbox(),testData.get("WebSite"));
			
		//Main Address Section	
	    obj.keyWords().sendKeys(obj.getPageCreateRG().getMainAddressAttn_Txtbox(),testData.get("MA_AttnTo"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getMainAddressAddress_Txtbox(),testData.get("MA_Address"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getMainAddressAddress2_Txtbox(),testData.get("MA_Address_Line2"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getMainAddressCity_Txtbox(),testData.get("MA__City"));
	    obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getMainAddressState_ddl(),testData.get("MA_State"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getMainAddressZipcode_Txtbox(),testData.get("MA_Zip_Code"));
			 
	    //letter Preference Section
		obj.keyWords().selectByValue(obj.getPageCreateRG().getLetterPreference_ddl(), testData.get("LP_SendingLetterCheck"));
		obj.keyWords().clickElement(obj.getPageCreateRG().getUse_facility_checkbox());
	    obj.keyWords().clickElement(obj.getPageCreateRG().getGroup_letter_checkbox());
	    obj.keyWords().sendKeys(obj.getPageCreateRG().getLettersperbatch_sendkeys(),testData.get("Lettersforbatch_Checkbox"));		
			
	    //Include Additional Data All checkboxes  
	     obj.keyWords().clickElement(obj.getPageCreateRG().getClaim_Entity_checkbox());
	     obj.keyWords().clickElement(obj.getPageCreateRG().getFacility_address_checkbox());
    	 obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_name_ddl());
	     obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_DOB_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_address_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_age_checkbox());
	     obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_phone_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_Email_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_Name_checkbox());
	     obj.keyWords().clickElement(obj.getPageCreateRG().getProvider_verification_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getProject_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getDate_of_service_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getAdditional_checkbox());
			   
		 //Payment Preference Section
		  obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getPayment_preference_ddl(),testData.get("PaymentPreference_DDL"));	
		  obj.keyWords().shortWait();
		  obj.keyWords().SendKeys_Into_AutoSuggestiveTextBox(obj.getPageCreateRG().getCardtype_txtbox(),testData.get("Cardtype_ddl"));
		  obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getPayVia_ddl(),testData.get("PayVia_ddl"));
			   
		  //Return Preference Section
		  obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getReturn_prefernce_ddl(),testData.get("ReturnPreference_DDL"));
			   
	      //Send Preference of type Mail Section
		  obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getSend_preference_ddl(),testData.get("SP_DDL"));
		  obj.keyWords().sendKeys(obj.getPageCreateRG().getSPEmail_textbox(),testData.get("SP_Email_TxtBox")); 	
		  obj.keyWords().clickElement(obj.getPageCreateRG().getNext_button());   
		
		
	}
	
	@Then("Enter Data in the  Request Group Settings section with SendPreference of Upload")
	public void EnterDataintheRequestGroupSettingssectionwithSendPreferenceofUpload() throws InterruptedException {
	

		 //Configuration Request Group Name TxtBox
		obj.keyWords().sendKeys(obj.getPageCreateRG().getRequest_Group_Name_Txtbox(), testData.get("requestGroupName"));
				
		//ContactDay/Time Preference	
		obj.keyWords().selectByValue(obj.getPageCreateRG().getTimezoneRequestGroupSetting_ddl(), testData.get("timeZoneRG"));	
				
		//Special Instruction Section	
		obj.keyWords().sendKeys(obj.getPageCreateRG().getInstruction_Txtbox(), testData.get("instructions"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getNext_Review_Txtbox(), Common_Functions_Sd.getNextReviewDate(1));
		Thread.sleep(2000);
				
		//Retrieval Method Section	
		obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getRetrivalMethod_ddl(), testData.get("retrievalMethods"));	
		obj.keyWords().SendKeys_Into_AutoSuggestiveTextBox(obj.getPageCreateRG().getEMRsystem_Txtbox(),testData.get("EMR System_TxtBox"));
				
    	//WorkFlow Section	
		obj.keyWords().sendKeys(obj.getPageCreateRG().getOwner_Txtbox(), testData.get("wfSettingOwner"));		
		obj.keyWords().clickElement(obj.getPageCreateRG().getOnly_Owner_Checkbox());;
		obj.keyWords().clickElement(obj.getPageCreateRG().getContact_Will_Checkbox());
		obj.keyWords().clickElement(obj.getPageCreateRG().getContact_Will_Confirm_Checkbox());	
	    obj.keyWords().clickElement(obj.getPageCreateRG().getExcluded_Checkbox());
		obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getReasonforExclusion_Txtbox(),testData.get("ReasonExclusion"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getWebsite_Txtbox(),testData.get("WebSite"));
			
		//Main Address Section	
	    obj.keyWords().sendKeys(obj.getPageCreateRG().getMainAddressAttn_Txtbox(),testData.get("MA_AttnTo"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getMainAddressAddress_Txtbox(),testData.get("MA_Address"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getMainAddressAddress2_Txtbox(),testData.get("MA_Address_Line2"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getMainAddressCity_Txtbox(),testData.get("MA__City"));
	    obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getMainAddressState_ddl(),testData.get("MA_State"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getMainAddressZipcode_Txtbox(),testData.get("MA_Zip_Code"));
			 
	    //letter Preference Section
		obj.keyWords().selectByValue(obj.getPageCreateRG().getLetterPreference_ddl(), testData.get("LP_SendingLetterCheck"));
		obj.keyWords().clickElement(obj.getPageCreateRG().getUse_facility_checkbox());
	    obj.keyWords().clickElement(obj.getPageCreateRG().getGroup_letter_checkbox());
	    obj.keyWords().sendKeys(obj.getPageCreateRG().getLettersperbatch_sendkeys(),testData.get("Lettersforbatch_Checkbox"));		
			
	    //Include Additional Data All checkboxes  
	     obj.keyWords().clickElement(obj.getPageCreateRG().getClaim_Entity_checkbox());
	     obj.keyWords().clickElement(obj.getPageCreateRG().getFacility_address_checkbox());
    	 obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_name_ddl());
	     obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_DOB_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_address_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_age_checkbox());
	     obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_phone_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_Email_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_Name_checkbox());
	     obj.keyWords().clickElement(obj.getPageCreateRG().getProvider_verification_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getProject_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getDate_of_service_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getAdditional_checkbox());
			   
		 //Payment Preference Section
		  obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getPayment_preference_ddl(),testData.get("PaymentPreference_DDL"));	
		  obj.keyWords().shortWait();
		  obj.keyWords().SendKeys_Into_AutoSuggestiveTextBox(obj.getPageCreateRG().getCardtype_txtbox(),testData.get("Cardtype_ddl"));
		  obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getPayVia_ddl(),testData.get("PayVia_ddl"));
			   
		  //Return Preference Section
		  obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getReturn_prefernce_ddl(),testData.get("ReturnPreference_DDL"));
			   
	      //Send Preference of type Mail Section
		  obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getSend_preference_ddl(),testData.get("SP_DDL"));
		  obj.keyWords().sendKeys(obj.getPageCreateRG().getSPUpload_textbox(),testData.get("SP_Upload_URL")); 	
		  obj.keyWords().clickElement(obj.getPageCreateRG().getNext_button());   
			
		
}
	
	
	@Then("Enter Data in the  Request Group Settings section with SendPreference as Use primary contacts Mail address")
	public void RequestGroupUseprimarycontactsMailaddress() throws InterruptedException {

		 //Configuration Request Group Name TxtBox
		obj.keyWords().sendKeys(obj.getPageCreateRG().getRequest_Group_Name_Txtbox(), testData.get("requestGroupName"));
				
		//ContactDay/Time Preference	
		obj.keyWords().selectByValue(obj.getPageCreateRG().getTimezoneRequestGroupSetting_ddl(), testData.get("timeZoneRG"));	
				
		//Special Instruction Section	
		obj.keyWords().sendKeys(obj.getPageCreateRG().getInstruction_Txtbox(), testData.get("instructions"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getNext_Review_Txtbox(), Common_Functions_Sd.getNextReviewDate(1));
		Thread.sleep(2000);
				
		//Retrieval Method Section	
		obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getRetrivalMethod_ddl(), testData.get("retrievalMethods"));	
		obj.keyWords().SendKeys_Into_AutoSuggestiveTextBox(obj.getPageCreateRG().getEMRsystem_Txtbox(),testData.get("EMR System_TxtBox"));
				
    	//WorkFlow Section	
		obj.keyWords().sendKeys(obj.getPageCreateRG().getOwner_Txtbox(), testData.get("wfSettingOwner"));		
		obj.keyWords().clickElement(obj.getPageCreateRG().getOnly_Owner_Checkbox());;
		obj.keyWords().clickElement(obj.getPageCreateRG().getContact_Will_Checkbox());
		obj.keyWords().clickElement(obj.getPageCreateRG().getContact_Will_Confirm_Checkbox());	
	    obj.keyWords().clickElement(obj.getPageCreateRG().getExcluded_Checkbox());
		obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getReasonforExclusion_Txtbox(),testData.get("ReasonExclusion"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getWebsite_Txtbox(),testData.get("WebSite"));
			
		//Main Address Section	
	    obj.keyWords().sendKeys(obj.getPageCreateRG().getMainAddressAttn_Txtbox(),testData.get("MA_AttnTo"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getMainAddressAddress_Txtbox(),testData.get("MA_Address"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getMainAddressAddress2_Txtbox(),testData.get("MA_Address_Line2"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getMainAddressCity_Txtbox(),testData.get("MA__City"));
	    obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getMainAddressState_ddl(),testData.get("MA_State"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getMainAddressZipcode_Txtbox(),testData.get("MA_Zip_Code"));
			 
	    //letter Preference Section
		obj.keyWords().selectByValue(obj.getPageCreateRG().getLetterPreference_ddl(), testData.get("LP_SendingLetterCheck"));
		obj.keyWords().clickElement(obj.getPageCreateRG().getUse_facility_checkbox());
	    obj.keyWords().clickElement(obj.getPageCreateRG().getGroup_letter_checkbox());
	    obj.keyWords().sendKeys(obj.getPageCreateRG().getLettersperbatch_sendkeys(),testData.get("Lettersforbatch_Checkbox"));		
			
	    //Include Additional Data All checkboxes  
	     obj.keyWords().clickElement(obj.getPageCreateRG().getClaim_Entity_checkbox());
	     obj.keyWords().clickElement(obj.getPageCreateRG().getFacility_address_checkbox());
    	 obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_name_ddl());
	     obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_DOB_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_address_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_age_checkbox());
	     obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_phone_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_Email_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_Name_checkbox());
	     obj.keyWords().clickElement(obj.getPageCreateRG().getProvider_verification_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getProject_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getDate_of_service_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getAdditional_checkbox());
			   
		 //Payment Preference Section
		  obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getPayment_preference_ddl(),testData.get("PaymentPreference_DDL"));	
		  obj.keyWords().shortWait();
		  obj.keyWords().SendKeys_Into_AutoSuggestiveTextBox(obj.getPageCreateRG().getCardtype_txtbox(),testData.get("Cardtype_ddl"));
		  obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getPayVia_ddl(),testData.get("PayVia_ddl"));
			   
		  //Return Preference Section
		  obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getReturn_prefernce_ddl(),testData.get("ReturnPreference_DDL"));
			   
	      //Send Preference of type Mail Checkbox Section
		  obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getSend_preference_ddl(),testData.get("SP_DDL"));
		  obj.keyWords().explicitWait_Until_ElementDisplayed(obj.getPageCreateRG().getSPUsemainaddress_checkbox());
		  obj.getPageCreateRG().getSPUsedPrimarycontactMail_Checkbox();
		//obj.keyWords().clickElement(obj.getPageCreateRG().getSPUsedPrimarycontactMail_Checkbox());
		  obj.keyWords().clickElement(obj.getPageCreateRG().getNext_button());   
			 

}

	
	@Then("Enter Data in the  Request Group Settings section with SendPreference as Use primary contacts Fax address")
	public void EnterDataintheRequestGroupSettingssectionwithSendPreferenceasUseprimarycontactsFaxaddress() throws InterruptedException {
				 //Configuration Request Group Name TxtBox
		obj.keyWords().sendKeys(obj.getPageCreateRG().getRequest_Group_Name_Txtbox(), testData.get("requestGroupName"));
				
		//ContactDay/Time Preference	
		obj.keyWords().selectByValue(obj.getPageCreateRG().getTimezoneRequestGroupSetting_ddl(), testData.get("timeZoneRG"));	
				
		//Special Instruction Section	
		obj.keyWords().sendKeys(obj.getPageCreateRG().getInstruction_Txtbox(), testData.get("instructions"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getNext_Review_Txtbox(), Common_Functions_Sd.getNextReviewDate(1));
		Thread.sleep(2000);
				
		//Retrieval Method Section	
		obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getRetrivalMethod_ddl(), testData.get("retrievalMethods"));	
		obj.keyWords().SendKeys_Into_AutoSuggestiveTextBox(obj.getPageCreateRG().getEMRsystem_Txtbox(),testData.get("EMR System_TxtBox"));
				
    	//WorkFlow Section	
		obj.keyWords().sendKeys(obj.getPageCreateRG().getOwner_Txtbox(), testData.get("wfSettingOwner"));		
		obj.keyWords().clickElement(obj.getPageCreateRG().getOnly_Owner_Checkbox());;
		obj.keyWords().clickElement(obj.getPageCreateRG().getContact_Will_Checkbox());
		obj.keyWords().clickElement(obj.getPageCreateRG().getContact_Will_Confirm_Checkbox());	
	    obj.keyWords().clickElement(obj.getPageCreateRG().getExcluded_Checkbox());
		obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getReasonforExclusion_Txtbox(),testData.get("ReasonExclusion"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getWebsite_Txtbox(),testData.get("WebSite"));
			
		//Main Address Section	
	    obj.keyWords().sendKeys(obj.getPageCreateRG().getMainAddressAttn_Txtbox(),testData.get("MA_AttnTo"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getMainAddressAddress_Txtbox(),testData.get("MA_Address"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getMainAddressAddress2_Txtbox(),testData.get("MA_Address_Line2"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getMainAddressCity_Txtbox(),testData.get("MA__City"));
	    obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getMainAddressState_ddl(),testData.get("MA_State"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getMainAddressZipcode_Txtbox(),testData.get("MA_Zip_Code"));
			 
	    //letter Preference Section
		obj.keyWords().selectByValue(obj.getPageCreateRG().getLetterPreference_ddl(), testData.get("LP_SendingLetterCheck"));
		obj.keyWords().clickElement(obj.getPageCreateRG().getUse_facility_checkbox());
	    obj.keyWords().clickElement(obj.getPageCreateRG().getGroup_letter_checkbox());
	    obj.keyWords().sendKeys(obj.getPageCreateRG().getLettersperbatch_sendkeys(),testData.get("Lettersforbatch_Checkbox"));		
			
	    //Include Additional Data All checkboxes  
	     obj.keyWords().clickElement(obj.getPageCreateRG().getClaim_Entity_checkbox());
	     obj.keyWords().clickElement(obj.getPageCreateRG().getFacility_address_checkbox());
    	 obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_name_ddl());
	     obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_DOB_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_address_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_age_checkbox());
	     obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_phone_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_Email_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_Name_checkbox());
	     obj.keyWords().clickElement(obj.getPageCreateRG().getProvider_verification_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getProject_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getDate_of_service_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getAdditional_checkbox());
			   
		 //Payment Preference Section
		  obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getPayment_preference_ddl(),testData.get("PaymentPreference_DDL"));	
		  obj.keyWords().shortWait();
		  obj.keyWords().SendKeys_Into_AutoSuggestiveTextBox(obj.getPageCreateRG().getCardtype_txtbox(),testData.get("Cardtype_ddl"));
		  obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getPayVia_ddl(),testData.get("PayVia_ddl"));
			   
		  //Return Preference Section
		  obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getReturn_prefernce_ddl(),testData.get("ReturnPreference_DDL"));
			   
	      //Send Preference of type Fax Checkbox Section
		  obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getSend_preference_ddl(),testData.get("SP_DDL"));
		  obj.getPageCreateRG().getSPFax_Checkbox();
		  obj.keyWords().clickElement(obj.getPageCreateRG().getNext_button());   
			
		
	}
	
	
	@Then("Enter Data in the  Request Group Settings section with SendPreference as Use primary contacts Email address")
	public void RequestGroupUseprimarycontactsFaxaddress() throws InterruptedException {
		
		 //Configuration Request Group Name TxtBox
		obj.keyWords().sendKeys(obj.getPageCreateRG().getRequest_Group_Name_Txtbox(), testData.get("requestGroupName"));
				
		//ContactDay/Time Preference	
		obj.keyWords().selectByValue(obj.getPageCreateRG().getTimezoneRequestGroupSetting_ddl(), testData.get("timeZoneRG"));	
				
		//Special Instruction Section	
		obj.keyWords().sendKeys(obj.getPageCreateRG().getInstruction_Txtbox(), testData.get("instructions"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getNext_Review_Txtbox(), Common_Functions_Sd.getNextReviewDate(1));
		Thread.sleep(2000);
				
		//Retrieval Method Section	
		obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getRetrivalMethod_ddl(), testData.get("retrievalMethods"));	
		obj.keyWords().SendKeys_Into_AutoSuggestiveTextBox(obj.getPageCreateRG().getEMRsystem_Txtbox(),testData.get("EMR System_TxtBox"));
				
    	//WorkFlow Section	
		obj.keyWords().sendKeys(obj.getPageCreateRG().getOwner_Txtbox(), testData.get("wfSettingOwner"));		
		obj.keyWords().clickElement(obj.getPageCreateRG().getOnly_Owner_Checkbox());;
		obj.keyWords().clickElement(obj.getPageCreateRG().getContact_Will_Checkbox());
		obj.keyWords().clickElement(obj.getPageCreateRG().getContact_Will_Confirm_Checkbox());	
	    obj.keyWords().clickElement(obj.getPageCreateRG().getExcluded_Checkbox());
		obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getReasonforExclusion_Txtbox(),testData.get("ReasonExclusion"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getWebsite_Txtbox(),testData.get("WebSite"));
			
		//Main Address Section	
	    obj.keyWords().sendKeys(obj.getPageCreateRG().getMainAddressAttn_Txtbox(),testData.get("MA_AttnTo"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getMainAddressAddress_Txtbox(),testData.get("MA_Address"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getMainAddressAddress2_Txtbox(),testData.get("MA_Address_Line2"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getMainAddressCity_Txtbox(),testData.get("MA__City"));
	    obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getMainAddressState_ddl(),testData.get("MA_State"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getMainAddressZipcode_Txtbox(),testData.get("MA_Zip_Code"));
			 
	    //letter Preference Section
		obj.keyWords().selectByValue(obj.getPageCreateRG().getLetterPreference_ddl(), testData.get("LP_SendingLetterCheck"));
		obj.keyWords().clickElement(obj.getPageCreateRG().getUse_facility_checkbox());
	    obj.keyWords().clickElement(obj.getPageCreateRG().getGroup_letter_checkbox());
	    obj.keyWords().sendKeys(obj.getPageCreateRG().getLettersperbatch_sendkeys(),testData.get("Lettersforbatch_Checkbox"));		
			
	    //Include Additional Data All checkboxes  
	     obj.keyWords().clickElement(obj.getPageCreateRG().getClaim_Entity_checkbox());
	     obj.keyWords().clickElement(obj.getPageCreateRG().getFacility_address_checkbox());
    	 obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_name_ddl());
	     obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_DOB_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_address_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_age_checkbox());
	     obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_phone_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_Email_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getPatient_Name_checkbox());
	     obj.keyWords().clickElement(obj.getPageCreateRG().getProvider_verification_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getProject_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getDate_of_service_checkbox());
		 obj.keyWords().clickElement(obj.getPageCreateRG().getAdditional_checkbox());
			   
		 //Payment Preference Section
		  obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getPayment_preference_ddl(),testData.get("PaymentPreference_DDL"));	
		  obj.keyWords().shortWait();
		  obj.keyWords().SendKeys_Into_AutoSuggestiveTextBox(obj.getPageCreateRG().getCardtype_txtbox(),testData.get("Cardtype_ddl"));
		  obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getPayVia_ddl(),testData.get("PayVia_ddl"));
			   
		  //Return Preference Section
		  obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getReturn_prefernce_ddl(),testData.get("ReturnPreference_DDL"));
			   
	      //Send Preference of type Email Txtbox Section
		  obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getSend_preference_ddl(),testData.get("SP_DDL"));
		  obj.getPageCreateRG().getSPUsedPrimarycontactEmail_Checkbox();
		  obj.keyWords().clickElement(obj.getPageCreateRG().getNext_button());   
		
		
    }
	
	@Then("Enter Data in the  Request Group Settings section with All Mandatory Fields")
	public void EnterDataintheRequestGroupSettingssectionwithAllMandatoryFields() throws InterruptedException {
	
		
		obj.keyWords().selectByValue(obj.getPageCreateRG().getTimezoneRequestGroupSetting_ddl(), testData.get("timeZoneRG"));	
		obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getRetrivalMethod_ddl(), testData.get("retrievalMethods"));		
		obj.keyWords().SelectByVisibleText(obj.getPageCreateRG().getSend_preference_ddl(),testData.get("SP_DDL"));
	    obj.keyWords().sendKeys(obj.getPageCreateRG().getSPFax_textbox(),testData.get("SP_Fax_Number"));	
	
	}

	
	@Then("Under Contact section Add a Multiple Contacts")
	public void UnderContactsectionAddaMultipleContacts() throws InterruptedException {
		obj.keyWords().clickElement(obj.getPageCreateRG().getAddContact_btn());
		obj.keyWords().selectByValue(obj.getPageCreateRG().getContactType_ddl(), testData.get("contactType"));
		obj.keyWords().selectByValue(obj.getPageCreateRG().getDepartment_ddl(), testData.get("department"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getName_txtbox(),testData.get("name"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getRole_txtbox(),testData.get("role"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getEmail_txtbox(),testData.get("email"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getPhone_txtbox(),testData.get("phone"));
		Thread.sleep(2000);
		obj.getPageCreateRG().getPhone_txtbox().sendKeys(Keys.TAB);
		Thread.sleep(2000);
		obj.keyWords().sendKeys(obj.getPageCreateRG().getExt_txtbox(),testData.get("ext"));
		obj.getPageCreateRG().getExt_txtbox().sendKeys(Keys.TAB);
		Thread.sleep(2000);
		obj.keyWords().sendKeys(obj.getPageCreateRG().getFax_txtbox(),testData.get("fax"));		
		obj.getPageCreateRG().getFax_txtbox().sendKeys(Keys.TAB);
		Thread.sleep(2000);
		obj.keyWords().selectByValue(obj.getPageCreateRG().getPreferred_method_txtbox(), testData.get("preferredMethod"));	
		Thread.sleep(2000);
		obj.keyWords().selectByValue(obj.getPageCreateRG().getTimezone_ddl(), testData.get("timeZoneContact"));	
		Thread.sleep(6000);
		obj.keyWords().clickElement(obj.getPageCreateRG().getcustomerAccSummary_btn());
		obj.keyWords().clickElement(obj.getPageCreateRG().getContacts_Nextbtn());
	
		//Contact 2
		obj.keyWords().clickElement(obj.getPageCreateRG().getAddContact_btn());
		obj.keyWords().selectByValue(obj.getPageCreateRG().getContactType_ddl(), testData.get("contactType"));
		obj.keyWords().selectByValue(obj.getPageCreateRG().getDepartment_ddl(), testData.get("department"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getName_txtbox(),testData.get("name"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getRole_txtbox(),testData.get("role"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getEmail_txtbox(),testData.get("email"));
		obj.keyWords().sendKeys(obj.getPageCreateRG().getPhone_txtbox(),testData.get("phone"));
		Thread.sleep(2000);
		obj.getPageCreateRG().getPhone_txtbox().sendKeys(Keys.TAB);
		Thread.sleep(2000);
		obj.keyWords().sendKeys(obj.getPageCreateRG().getExt_txtbox(),testData.get("ext"));
		obj.getPageCreateRG().getExt_txtbox().sendKeys(Keys.TAB);
		Thread.sleep(2000);
		obj.keyWords().sendKeys(obj.getPageCreateRG().getFax_txtbox(),testData.get("fax"));		
		obj.getPageCreateRG().getFax_txtbox().sendKeys(Keys.TAB);
		Thread.sleep(2000);
		obj.keyWords().selectByValue(obj.getPageCreateRG().getPreferred_method_txtbox(), testData.get("preferredMethod"));	
		Thread.sleep(2000);
		obj.keyWords().selectByValue(obj.getPageCreateRG().getTimezone_ddl(), testData.get("timeZoneContact"));	
		Thread.sleep(6000);
		obj.keyWords().clickElement(obj.getPageCreateRG().getcustomerAccSummary_btn());
		obj.keyWords().clickElement(obj.getPageCreateRG().getContacts_Nextbtn());
			
		
	}
	
	
	
	
	
	
	
}
