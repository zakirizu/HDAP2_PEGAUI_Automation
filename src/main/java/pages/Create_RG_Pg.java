package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.cucumber.java.Scenario;

public class Create_RG_Pg {
	//Template Start	
		public  WebDriver driver;		
		public Create_RG_Pg(WebDriver driver, Scenario s)
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
	
		/*---SYNTAX TO ADD THE WEBELEMENT------------
			@FindBy(xpath="//tagName")
		private  WebElement ElementName;		
		public WebElement getelementName() {
			return ElementName;
		}
		 */
		
		//---Added Today
		
		//providers
		
		@FindBy(xpath = "//*[text()='Next >>']")
		private WebElement Next_btn;
		
		
		
		
		//Contacts
		
		@FindBy(xpath = "//button[text()='Add Contact']")
		private WebElement AddContact_btn;
		
		@FindBy(xpath = "//select[@id='80e67c33']")
		private WebElement contactType_ddl;
		
		@FindBy(xpath = "template")
		private WebElement template;
        
		@FindBy(xpath = "//option[text()='Primary']")
		private WebElement Primary_ddl;
        
		@FindBy(xpath = "//option[@value='Secondary']")
		private WebElement Secondary_ddl;
        
		@FindBy(xpath = "//select[@id='c1a346d0']")
		private WebElement Department_ddl;
//        
//		@FindBy(xpath = "//option[text()='Medical Records/Release of Information']")
//		private WebElement MedicalRecordsReleaseofInformation_ddl;
//        
//		@FindBy(xpath = "//option[text()='Billing']")
//		private WebElement Billing_ddl;
//		
//		@FindBy(xpath = "//option[text()='Compliance']")
//		private WebElement Compliance_ddl;
//		
//		@FindBy(xpath = "//option[text()='Other']")
//		private WebElement other_ddl;
		
		@FindBy(xpath = "//input[@id='45da4e1f']")
		private WebElement Name_txtbox;
		
		@FindBy(xpath = "//input[@id='6da723dd']")
		private WebElement role_txtbox;
		
		@FindBy(xpath = "//input[@id='5aea26b5']")
		private WebElement Email_txtbox;
		
		@FindBy(xpath = "//input[@id='d0a169f1']")
		private WebElement Phone_txtbox;
		
		@FindBy(xpath = "//input[@id='edf46543']")
		private WebElement Ext_txtbox;
		
		@FindBy(xpath = "//input[@id='95a33135']")
		private WebElement Fax_txtbox;
		
		@FindBy(xpath = "//select[@id='89268613']")
		private WebElement Preferred_method_txtbox;
		
		@FindBy(xpath = "//option[@value='Phone']")
		private WebElement Phone_ddl;
		
		@FindBy(xpath = "//option[@value='Email']")
		private WebElement Email_ddl;
		
		@FindBy(xpath = "//option[@value='Fax']")
		private WebElement Fax_ddl;
		
		@FindBy(xpath = "//select[@id='364c75d1']")
		private WebElement Timezone_ddl;
		
//		@FindBy(xpath = "//option[@value='US/Alaska']")
//		private WebElement USAlaska_ddl;
//		
//		@FindBy(xpath = "//option[@value='US/Central']")
//		private WebElement USCentral_ddl;
//		
//		@FindBy(xpath = "//option[@value='US/Eastern']")
//		private WebElement USEastern_ddl;
//		
//		@FindBy(xpath = "//option[@value='US/Hawaii']")
//		private WebElement USHawaii_ddl;
//		
//		@FindBy(xpath = "//option[@value='US/Mountain']")
//		private WebElement USMountain_ddl;
//		
//		@FindBy(xpath = "//option[@value='US/Pacific']")
//		private WebElement USPacific_ddl;
		
		
		
		//button[text()='Add Contact']
		
		
		//Request Group Settings
		@FindBy(xpath = "//input[@id='e12165d4']")
		private WebElement Request_Group_Name_Txtbox;
		
		@FindBy(xpath = "//select[@id='af741cb3']")
		private WebElement Timezone2_ddl;
		
		@FindBy(xpath = "//select[@id='91c190b1']")
		private WebElement Instruction_Txtbox ;
		
		@FindBy(xpath = "//input[@id='a1ed4d32']")
		private WebElement Next_Review_Txtbox ;
		
		@FindBy(xpath = "//select[@id='a4b25490']")
		private WebElement Retrival_Method_ddl ;
		
		@FindBy(xpath = "//input[@id='63add1cc']")
		private WebElement Owner_Txtbox ;
		
		@FindBy(xpath = "//input[@id='eeea0ea9']")
		private WebElement Only_Owner_Checkbox ;
		
		@FindBy(xpath = "//input[@id='71fade16']")
		private WebElement Contact_Will_Checkbox ;
		
		@FindBy(xpath = "//input[@id='2d6f9879']")
		private WebElement Contact_Will_Confirm_Checkbox ;
		
		@FindBy(xpath = "//input[@id='0b196e37']")
		private WebElement Excluded_Checkbox ;
		
		@FindBy(xpath = "//input[@id='e8312b1e']")
		private WebElement Website_Txtbox ;
		
		@FindBy(xpath = "//input[@id='347175fd']")
		private WebElement Attn_Txtbox ;
		
		@FindBy(xpath = "//input[@id='37274597']")
		private WebElement Address_Txtbox ;
		
		@FindBy(xpath = "//input[@id='37274597']")
		private WebElement Address2_Txtbox ;
		
		@FindBy(xpath = "//input[@id='2e457787']")
		private WebElement City_Txtbox ;
		
		@FindBy(xpath = "//select[@id='f1f82eb8']")
		private WebElement State_ddl ;
		
		@FindBy(xpath = "//input[@id='1668d1dc']")
		private WebElement Zipcode_Txtbox ;
		
		//select[@id='91c190b1']
		//Process for rules
		
		
		//
		
		
		
		
		
		
		
		
		
		
		
		
		//----Added Today
		
		
		
		
		
		
		
		
		
		@FindBy(xpath = "//button[text()='Create RG']")
		private WebElement btn_createRG;
		
		@FindBy(xpath = "(//iframe[contains(@title,'RG-')])[1]")
		private WebElement frame_CreateRG;
		
		@FindBy(xpath = "//button[@title='Complete this assignment']")
		private WebElement btn_Next;
		
		@FindBy(xpath = "test")
		private WebElement test;
		
		
		public WebElement getBtn_createRG() {
			return btn_createRG;
		}

		public WebElement getFrame_CreateRG() {
			return frame_CreateRG;
		}

		public WebElement getBtn_Next() {
			return btn_Next;
		}

		public WebElement getTest() {
			return test;
		}

		public WebElement getNext_btn() {
			return Next_btn;
		}

		public WebElement getAddContact_btn() {
			return AddContact_btn;
		}

		public WebElement getContactType_ddl() {
			return contactType_ddl;
		}

		public WebElement getTemplate() {
			return template;
		}

		public WebElement getPrimary_ddl() {
			return Primary_ddl;
		}

		public WebElement getSecondary_ddl() {
			return Secondary_ddl;
		}

		public WebElement getDepartment_ddl() {
			return Department_ddl;
		}

		public WebElement getName_txtbox() {
			return Name_txtbox;
		}

		public WebElement getRole_txtbox() {
			return role_txtbox;
		}

		public WebElement getEmail_txtbox() {
			return Email_txtbox;
		}

		public WebElement getPhone_txtbox() {
			return Phone_txtbox;
		}

		public WebElement getExt_txtbox() {
			return Ext_txtbox;
		}

		public WebElement getFax_txtbox() {
			return Fax_txtbox;
		}

		public WebElement getPreferred_method_txtbox() {
			return Preferred_method_txtbox;
		}

		public WebElement getPhone_ddl() {
			return Phone_ddl;
		}

		public WebElement getEmail_ddl() {
			return Email_ddl;
		}

		public WebElement getFax_ddl() {
			return Fax_ddl;
		}

		public WebElement getTimezone_ddl() {
			return Timezone_ddl;
		}

		

}
