package testRunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//dryRun if True -> It will only check whether there are associated steps definitions or not

@CucumberOptions
	(
		features				=	"src/main/java/featureFile",
		glue						=	"stepDefinitionFile" ,
		monochrome		=	true,
		dryRun					= 	false, //If true only checks if all the Features has corresponding StepDefinitions or Not. If False then runs the actual code in the step Definition
		tags						=	"@CreateRGZR1",
		plugin					= 	{"pretty","html:TestResults_CucumberReports/cucumber.html","json:TestResults_cucumberReports/cucumber.json"}
	)
public class RunnerTestNG extends AbstractTestNGCucumberTests {

}




