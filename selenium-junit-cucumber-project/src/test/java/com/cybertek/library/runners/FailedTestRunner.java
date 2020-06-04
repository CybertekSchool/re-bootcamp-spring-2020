package com.cybertek.library.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/cybertek/library/step_definitions",
        features = "@target/rerun.txt"
)
public class FailedTestRunner {

}
// this does not report. to report add  "html:target/default-cucumber-reports",
// if you use the same report name as your runner file, it will
// delete that report and create new one only ofr failed tests
// if you write a differnet name, it wil create second report.