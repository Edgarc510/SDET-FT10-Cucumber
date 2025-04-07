package com.eac.step_definitions;

import com.eac.utilities.BrowserUtils;
import com.eac.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Hooks {

    @Before
    public void setUp() {
        System.out.println("Before hook: Set up environment");
        // Initialize any necessary resources, such as setting up a database connection
        // or loading test data
        // Add any necessary setup code here

    }

    @Before(value="@db" )
    public void setUpDB() {
        System.out.println("Before hook: Set up database connection");
        // Establish a database connection for testing
        // Add any necessary setup code here
    }

    @After
    public void tearDown(Scenario scenario) {
        System.out.println("After hook: Tear down environment");
        // Teardown any resources, such as closing the database connection or removing test data
        // Add any necessary teardown code here

        if (scenario.isFailed()) {
            byte[] screenShot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot, "image/png",scenario.getName());
        }
//        BrowserUtils.sleep(3);
        Driver.closeDriver();
    }
}
