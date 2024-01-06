package testRunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions
(
features="src/main/java/featureFile",
glue="stepDefinitionFile" ,
monochrome=true,
dryRun= false,
tags="@DataAtStepLevel",
plugin= {"pretty","html:cucumberReports/cucumber.html","json:cucumberReports/cucumber.json"}
)
public class RunnerTestNG extends AbstractTestNGCucumberTests {
}
