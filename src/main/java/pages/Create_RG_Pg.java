package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_RG_Pg {
	//Template Start	
		public  WebDriver driver;		
		public Create_RG_Pg(WebDriver driver)
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

		
		

	
	
		
		
		
		
		
		
		
	
	
	
	
	

}
