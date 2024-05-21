package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfigureRequestGroupTask_Pg {
	//Template Start	
		public  WebDriver driver;		
		public ConfigureRequestGroupTask_Pg(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
	
		/*---SYNTAX TO ADD THE WEBELEMENT------------
		 * 
			@FindBy(xpath="//tagName")
		private  WebElement ElementName;		
		public WebElement getelementName() {
			return ElementName;
		}
		
		 */
		
		
		@FindBy(xpath="//button[text()='Upload MR']")
	private  WebElement UploadMRButton;		
	public WebElement getUploadMRButton() {
		return UploadMRButton;
	}
		
		
		
		
		
		
		@FindBy(xpath = "(//*[text()='Request Group Settings'])[2]")
		private WebElement requestGroupSettingsTab;
		
		@FindBy(xpath="//iframe[@id='PegaGadget0Ifr']")
		private WebElement iframeHomePage;
		
		@FindBy(xpath="//tbody[@id='gridTableBody']//tr[@data-test-id='-R1']//a")
		private  WebElement firstRGfromWB;
		
		@FindBy(xpath="//iframe[@id='PegaGadget0Ifr']")
		private  WebElement RGTabFrame;
		
		@FindBy(xpath="//div[@class='panelOverFlowClass']//span//button[@title='Add Task']")
		private  WebElement addTaskBtn;
		
		@FindBy(xpath="//input[@placeholder='Search for action']")
		private  WebElement searchTaskTxtBox;
		
		@FindBy(xpath="//div[@class='content-item content-field item-1 flex flex-row dataValueWrite']//a[@title='Select  Configure Request Group  ']")
		private  WebElement configureRequestGroupBtn;
		
		
		@FindBy(xpath="(//button[@title='Close'])[2]")
		private  WebElement closeButton;
		



			
		
		public WebDriver getDriver() {
			return driver;
		}
		
		
		
		public WebElement getRequestGroupSettingsTab() {
			return requestGroupSettingsTab;
		}

		public WebElement getFirstRGfromWB() {
			return firstRGfromWB;
		}

		public WebElement getRGTabFrame() {
			return RGTabFrame;
		}

		public WebElement getAddTaskBtn() {
			return addTaskBtn;
		}

		public WebElement getSearchTaskTxtBox() {
			return searchTaskTxtBox;
		}

		public WebElement getConfigureRequestGroupBtn() {
			return configureRequestGroupBtn;
		}

		public WebElement getIframeHomePage() {
			return iframeHomePage;
		}

		
		
		
		
	
	
		
		
		
		
		
		
		
	
	
	
	
	

}
