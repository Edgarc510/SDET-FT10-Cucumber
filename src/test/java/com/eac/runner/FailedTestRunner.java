package com.eac.runner;


import io.cucumber.junit.*;
import org.junit.runner.*;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/rerun.txt",
        glue = "com.eac.step_definitions"
)
public class FailedTestRunner {
}
