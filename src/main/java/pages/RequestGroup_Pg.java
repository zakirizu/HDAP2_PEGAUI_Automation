package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RequestGroup_Pg {
	//Template Start	
		public  WebDriver driver;		
		public RequestGroup_Pg(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
	
		@FindBy(xpath="//span[@class='menu-item-title' and text()='Work']")
		private  WebElement workTab;
		
		@FindBy(xpath="//div[@data-layout-id='202312150041260633']")
		private  WebElement myWorkBasket;
		
		@FindBy(xpath="//iframe[@id='PegaGadget0Ifr']")
		private WebElement iframeHomePage;
		
		

		
		
		
		public  WebElement getWorkTab() {
			return workTab;
		}

		public  WebElement getMyWorkBasket() {
			return myWorkBasket;
		}

		public WebElement getIframeHomePage() {
			return iframeHomePage;
		}
	
		
		
		
		
		
		
		
	
	
	
	
	

}
