package com.eac.step_definitions;

import com.eac.pages.VyTrackDashboardPage;
import com.eac.pages.VyTrackLoginPage;
import com.eac.utilities.BrowserUtils;
import com.eac.utilities.ConfigurationReader;
import com.eac.utilities.Driver;
import com.eac.utilities.ExcelUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class VytrackLoginStepDef {
    VyTrackLoginPage vyTrackLoginPage = new VyTrackLoginPage();
    VyTrackDashboardPage vyTrackDashboardPage = new VyTrackDashboardPage();
    String path = "VyTrackQa2Users.xlsx";
    String firstname;
    String lastname;


    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack.qa2.url"));
    }
    @When("the user login with given credentials from {string} and {int}")
    public void the_user_login_with_given_credentials_from_and(String sheetName, Integer rowNum) {

        //retrieving data from excel
        ExcelUtil excelUtil = new ExcelUtil(path,sheetName);
        String username = excelUtil.getCellData(rowNum,0);
        String password = excelUtil.getCellData(rowNum,1);
        firstname = excelUtil.getCellData(rowNum,2);
        lastname = excelUtil.getCellData(rowNum,3);

        vyTrackLoginPage.login(username,password);
        BrowserUtils.sleep(7);

    }
    @Then("the user should be able to log in and see their name")
    public void the_user_should_be_able_to_log_in_and_see_their_name() {
        String actualFullName = vyTrackDashboardPage.fullName.getText();

        Assert.assertTrue("Error Name Does not Math",actualFullName.contains(firstname) && actualFullName.contains(lastname));
    }

}
