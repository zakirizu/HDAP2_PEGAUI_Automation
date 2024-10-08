package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.Scenario;

public class ProjectLaunches_Pg {
	//Template Start	
		public  WebDriver driver;		
		public ProjectLaunches_Pg(WebDriver driver, Scenario s)
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
	//Template End
		@FindBy(xpath="//span[text()='Project Launches']")
		private  WebElement tab_ProjectLaunches;
		
		@FindBy(xpath="//button[text()='Launch All Ready Projects']")
		private  WebElement btn_LaunchAllReadyProjects;
		
		@FindBy(xpath="//iframe[@id='PegaGadget0Ifr']")
		private  WebElement frame_LaunchAllReadyProjects;
		
		public WebElement getTab_ProjectLaunches() {
			return tab_ProjectLaunches;
		}

		public WebElement getBtn_LaunchAllReadyProjects() {
			return btn_LaunchAllReadyProjects;
		}

		public WebElement getFrame_LaunchAllReadyProjects() {
			return frame_LaunchAllReadyProjects;
		}
		
		

		
		
		
		
	
		
		
		
		
		
		
		
	
	
	
	
	

}
