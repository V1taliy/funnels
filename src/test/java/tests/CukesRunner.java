package tests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;
import org.junit.runner.RunWith;
import tests.Fixture;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty",
                "html:target/report/cucumber-report",
                "json:target/report/jsonReport/cucumber-report.json"},
        features = {"src/test/resources/features"},
//        tags = {"@zulander", "~@oneHundred", "~@maximize", "~@mitluka", "@google", "@autoclick", "@affordable"}
        tags = {"@wonderclickalgotrader"}
)
public class CukesRunner extends Fixture {
}
