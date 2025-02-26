package cucumber;
///Users/kumarvaduganathan/Documents/WorkspaceSuhanya/seleniumframework/target/cucumer.html
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
///Users/kumarvaduganathan/Documents/WorkspaceSuhanya/seleniumframework/src/test/java/cucumber
///Users/kumarvaduganathan/Documents/WorkspaceSuhanya/seleniumframework/src/test/java/Infosys/Stepdefintion
@CucumberOptions(features = "/Users/kumarvaduganathan/Documents/WorkspaceSuhanya/seleniumframework/src/test/java/cucumber",glue= "Infosys2.Stepdefintion",
        monochrome = true,tags = "@Regression",plugin = {"html:target//cucumer.html"})
public class Testngtestrunner extends AbstractTestNGCucumberTests {


}

