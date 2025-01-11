package com.app.step_definitions;

import com.app.pages.AccountPage;
import com.app.pages.EditAccountPage;
import com.app.utilities.Utils;
import io.cucumber.java.en.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class EditAccountStepDefs {

    private String accountName;
    private String newAccountName;

    @When("User opens edit account modal")
    public void user_opens_edit_account_modal() {
        AccountPage accountPage = new AccountPage();
        accountName = accountPage.accountName.getText();
        Utils.clickWithJS(accountPage.editAccountButton);
        Utils.waitFor(2);
    }
    @Then("User should see account name in input field")
    public void user_should_see_account_name_in_input_field() {
        String actualAccountName = new EditAccountPage().accountNameInput.getAttribute("value");
        Assert.assertEquals(accountName, actualAccountName);
    }
    @When("User enters the new account name")
    public void user_enters_the_new_account_name() {
        newAccountName = "Checking"+ RandomStringUtils.randomAlphabetic(8);
        EditAccountPage editAccountPage = new EditAccountPage();
        editAccountPage.accountNameInput.clear();
        editAccountPage.accountNameInput.sendKeys(newAccountName);
    }
    @When("User click update button")
    public void user_click_update_button() {
        Utils.waitFor(2);
        Utils.clickWithJS(new EditAccountPage().updateButton);
        Utils.waitFor(2);
    }
    @Then("User should see new account name under account summary")
    public void user_should_see_new_account_name_under_account_summary() {
        String actualName = new AccountPage().accountName.getText();
        Assert.assertEquals(newAccountName, actualName);
    }

}
