package com.eac.step_definitions;

import com.eac.pages.BingPage;
import com.eac.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleSearchStepDefs {

    BingPage bingPage = new BingPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    @Given("user is on google home page")
    public void user_is_on_google_home_page() {
        Driver.getDriver().get("https://www.bing.com/");
    }
    @When("user searches for {string} capital")
    public void user_searches_for_capital(String country) {
//        wait.until(ExpectedConditions.visibilityOf(bingPage.bingSearchBar));
        wait.until(ExpectedConditions.elementToBeClickable(bingPage.bingSearchBar));
        bingPage.bingSearchBar.sendKeys("Capital city of " + country + Keys.ENTER);
        bingPage.bingSearchBar.sendKeys(Keys.ENTER);
//        wait.until(ExpectedConditions.visibilityOf(bingPage.searchResults));
//        bingPage.searchResults.click();
    }
    @Then("user should see {string} result")
    public void user_should_see_result(String capital) {
//        wait.until(ExpectedConditions.visibilityOf(bingPage.capitalText));
        wait.until(ExpectedConditions.elementToBeClickable(bingPage.capitalText));
        System.out.println("bingPage.capitalText.getText() = " + bingPage.capitalText.getText());
        Assert.assertTrue(bingPage.capitalText.getText().contains(capital));
    }
}
