package pages;

import org.openqa.selenium.WebDriver;

import utils.KeyWords;

public class PageObjectManager {
	public WebDriver driver;
	public Common_Functions_Pg common_Functions_Pg;
	public Create_RG_Pg create_RG_Pg;
	public DQA_Task_Pg   dQA_Task_Pg;
	public KeyWords keys;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}
	

	public Common_Functions_Pg getCommon_Functions_Pg()
	{
		common_Functions_Pg = new Common_Functions_Pg(driver);
		return common_Functions_Pg;
	}
	
	public Create_RG_Pg getDQA_Task_Pg()
	{
		create_RG_Pg = new Create_RG_Pg(driver);
		return create_RG_Pg;
	}
	
	public DQA_Task_Pg getCreate_RG_Pg()
	{
		dQA_Task_Pg = new DQA_Task_Pg(driver);
		return dQA_Task_Pg;
	}
		
	public KeyWords getKeyWords()
	{
		keys = new KeyWords(driver);
		return keys;
	}
	
	

}
