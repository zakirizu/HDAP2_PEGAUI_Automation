package testRunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//dryRun if True -> It will only check whether there are associated steps definitions or not

@CucumberOptions
(
features			=	"src/main/java/featureFile",
glue					=	"stepDefinitionFile" ,
monochrome	=	true,
dryRun			= 	false,
tags					=	"@firstTestCase",
plugin				= 	{"pretty","html:cucumberReports/cucumber.html","json:cucumberReports/cucumber.json"}
)
public class RunnerTestNG extends AbstractTestNGCucumberTests {
}
