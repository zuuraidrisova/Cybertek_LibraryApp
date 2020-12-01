package com.cybertek.library.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-report.html",   //generates html type of report
                  "json:target/cucumber.json",         //generates json type of report
                  "rerun:target/rerun.txt"},
        features = "src/test/resources/features", //connects our feature files
        glue = "com/cybertek/library/step_definitions",//connects step definitions files
        tags = "@all_accounts"
)
public class CukesRunner {
}
