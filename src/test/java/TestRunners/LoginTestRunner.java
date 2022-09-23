package TestRunners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/AppFeatures/Login.feature"},
        glue = {"StepsDefinitions", "Hooks"},
//        plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
        plugin = {"pretty"},
        publish = true
)
public class LoginTestRunner {
}
