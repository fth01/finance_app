package com.app.step_definitions;

import com.app.pages.AccountPage;
import com.app.pages.TransferMoneyPage;
import com.app.utilities.Utils;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class TransferMoneyStepDefs {

    private String originalAmount;
    private String sender;

    @When("User opens transfer money modal")
    public void user_opens_transfer_money_modal() {
        AccountPage accountPage = new AccountPage();
        originalAmount = accountPage.amount.getText();
        sender = accountPage.accountName.getText();
        Utils.clickWithJS(accountPage.transferMoneyButton);
    }
    @Then("User should see account name as selected in Sender account dropdown")
    public void user_should_see_account_name_as_selected_in_sender_account_dropdown() {
        Select select = new Select(new TransferMoneyPage().senderAccountDropdown);
        String actualName = select.getFirstSelectedOption().getText();
        Assert.assertEquals(sender, actualName);
    }
    @Then("Receiver account should have options")
    public void receiver_account_should_have_options(List<String> recevierAccounts) {
        Select select = new Select(new TransferMoneyPage().receiverAccountDropdown);
        List<String> actualAccounts = Utils.getElementsText(select.getOptions());
        Collections.sort(actualAccounts);
        Assert.assertEquals(recevierAccounts, actualAccounts);
    }
    @Then("Amount input should be empty")
    public void amount_input_should_be_empty() {
        String amountInput = new TransferMoneyPage().amountInput.getAttribute("value");
        Assert.assertEquals("", amountInput);
    }

    @Then("Send button should be disabled")
    public void send_button_should_be_disabled() {
        boolean disable = Boolean.parseBoolean(new TransferMoneyPage().sendButton.getAttribute("aria-disabled"));
        Assert.assertTrue(disable);
    }

    @When("User enters the amount {string}")
    public void user_enters_the_amount(String amount) {
        new TransferMoneyPage().amountInput.sendKeys(amount);
        Utils.waitFor(2);
    }
    @When("User selects receiver as {string}")
    public void user_selects_receiver_as(String receiver) {
        Select select = new Select(new TransferMoneyPage().receiverAccountDropdown);
        select.selectByVisibleText(receiver);
    }
    @When("User clicks the send button")
    public void user_clicks_the_send_button() {
        Utils.clickWithJS(new TransferMoneyPage().sendButton);
        Utils.waitFor(1);
    }
    @Then("User amount should be decreased by {string}")
    public void user_amount_should_be_decreased_by(String amount) {
        double actualAmount = Double.parseDouble(new AccountPage().amount.getText().replaceAll(",", ""));
        double expectedAmount = Double.parseDouble(originalAmount.replaceAll(",", "")) - Double.parseDouble(amount);
        Assert.assertEquals(expectedAmount, actualAmount, 0.1);
    }
    @Then("Transaction detail {string}, {string} should be added the top of the transactions list")
    public void transaction_detail_should_be_added_the_top_of_the_transactions_list(String receiver, String amount) {
        Map<String, String> firstTransaction = new AccountPage().getTransactions().get(0);
        Assert.assertEquals(sender, firstTransaction.get("Sender"));
        Assert.assertEquals(receiver, firstTransaction.get("Receiver"));
        Assert.assertEquals(Double.parseDouble(amount), Double.parseDouble(firstTransaction.get("Amount")), 0.1);
    }
}
