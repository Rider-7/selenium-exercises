package cucumberoptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features", glue = "stepdefinitions", monochrome = true, tags = "@Banking or @Mortgage", plugin = {
    "pretty", "html:target/cucumber.html", "json:target/cucumber.json" }, dryRun = false)
public class TestNGRunner extends AbstractTestNGCucumberTests {

}
