package stepDefinitionFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.Create_RG_Pg;
import utils.DependencyInjection;
import utils.KeyWords;


public class zz_Template {
	DependencyInjection di;
	public zz_Template(DependencyInjection di)
	{
		this.di = di;
	}
	KeyWords        			 		    keys			 =   new KeyWords(di.driver);
	static Logger 						myLogger 	= LogManager.getLogger(zz_Template.class.getName());
	
	//Create Pages Here where ever your elements are present
   Create_RG_Pg					createRg 		= new Create_RG_Pg(di.driver);
	


}
