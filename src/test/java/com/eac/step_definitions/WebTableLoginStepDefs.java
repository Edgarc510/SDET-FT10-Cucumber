package com.eac.step_definitions;

import com.eac.pages.WebTableLoginPage;
import com.eac.utilities.ConfigurationReader;
import com.eac.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class WebTableLoginStepDefs {
    WebTableLoginPage webTableLoginPage = new WebTableLoginPage();

    @Given("user is on the login page of webtable app")
    public void user_is_on_the_login_page_of_webtable_app() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }
    @When("user enters username Test")
    public void user_enters_username_test() {
        webTableLoginPage.username.sendKeys(ConfigurationReader.getProperty("username"));
    }
    @When("user enters password Tester")
    public void user_enters_password_tester() {
        webTableLoginPage.password.sendKeys(ConfigurationReader.getProperty("password"));
    }
    @When("user clicks to login button")
    public void user_clicks_to_login_button() {
        webTableLoginPage.loginBtn.click();
    }
    @Then("user should see url contains orders")
    public void user_should_see_url_contains_orders() {

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("orders"));

    }

    @When("user enters username incorrect")
    public void userEntersUsernameIncorrect() {
        webTableLoginPage.username.sendKeys("Test");
    }

    @And("user enters password incorrect")
    public void userEntersPasswordIncorrect() {
        webTableLoginPage.password.sendKeys("Test");
    }

    @Then("user should see url contains login")
    public void userShouldSeeUrlContainsLogin() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("login"));
    }

    @When("user enters username {string}")
    public void user_enters_username(String username) {
        webTableLoginPage.username.sendKeys(username);
    }
    @When("user enters password {string}")
    public void user_enters_password(String password) {
        webTableLoginPage.password.sendKeys(password);
    }

    @When("user enters username {string} password {string} and logs in")
    public void user_enters_username_password_and_logs_in(String username, String password) {
        webTableLoginPage.login(username,password);

    }

    @When("user enters below credentials")
    public void user_enters_below_credentials(Map<String, String> credentials) {

        webTableLoginPage.login(credentials.get("username"),credentials.get("password"));
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.


    }


}
