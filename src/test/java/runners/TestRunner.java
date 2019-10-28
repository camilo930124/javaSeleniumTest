package runners;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features/"
        , glue = {"com/google/searchTest/steps/"}
        , plugin = {"pretty", "html:target/cucumber-reports", "json:target/cucumberProyectoBase.json","com.cucumber.listener.ExtentCucumberFormatter:"}
        , tags = {"@GoogleSearch"}
)

public class TestRunner {


    @AfterClass
    public static void teardown() {
        Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
    }

}


