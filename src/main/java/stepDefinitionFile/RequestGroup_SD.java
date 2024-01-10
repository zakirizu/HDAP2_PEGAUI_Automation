package stepDefinitionFile;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import pages.RequestGroup_Pg;
import utils.KeyWords;

public class RequestGroup_SD {
	
	public static WebDriver driver 				= Z_HooksCucumbers.Hookdriver;	
	KeyWords        			 	keys			 			= new KeyWords(driver);
	RequestGroup_Pg 		rgPage 				= new RequestGroup_Pg(driver);
	
	
	
	@Given("Launch the application URL")
	public void LauncApplicationURL() {
		System.out.println("Action lopla Driver: "+driver);
		
	}
	
	@Given("User Clicks on the Create RGButton")
	public void dummycode1() {
		System.out.println("Dummy Code 1");
		
	}
	
	@Given("Create RG Screen is displayed")
	public void dummycode2() {
		System.out.println("Create RG Screen is displayed");
	
	}
	
	
	
	
	
	

}
