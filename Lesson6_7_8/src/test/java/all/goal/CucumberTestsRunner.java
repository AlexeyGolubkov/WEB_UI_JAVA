package all.goal;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources"},
        plugin = {"pretty",
                "html:target/cucumber-reports/report.html",
                "html:target/cucumber-report/smoketest",
                "json:target/cucumber.json"
        },
        publish = true)
public class CucumberTestsRunner {

}
