package com.app.step_definitions;

import com.app.pages.LoginPage;
import com.app.utilities.ConfigurationReader;
import com.app.utilities.TestDriver;
import com.app.utilities.Utils;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class LoginStepDefs {


    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        TestDriver.get().get(ConfigurationReader.get("url"));
    }
    @When("User enters the valid credentials")
    public void user_enters_the_valid_credentials() {
        String username = ConfigurationReader.get("username");
        String password = Utils.decrypt(ConfigurationReader.get("password"));
        new LoginPage().login(username, password);
    }
    @Then("Dashboard should be displayed")
    public void dashboard_should_be_displayed() {
        Utils.waitFor(1);
        String expectedTitle = "apps";
        String actualTitle = TestDriver.get().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @When("User logs in using {string} and {string}")
    public void user_logs_in_using_and(String username, String password) {
        new LoginPage().login(username, password);
    }
    @Then("User should see error message")
    public void user_should_see_error_message() {
        String expectedMessage = "Username or Password Invalid!";
        String actualMessage = new LoginPage().errorMessage.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

}
