package com.app.step_definitions;

import com.app.pages.AccountPage;
import com.app.pages.AddMoneyPage;
import com.app.utilities.ConfigurationReader;
import com.app.utilities.Utils;
import io.cucumber.java.en.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;

import java.util.Map;

public class AddMoneyStepDefs {

    private String originalAmount;
    private String receiver;
    private String cardHolder;

    @When("User opens Add Money modal")
    public void user_opens_add_money_modal() {
        AccountPage accountPage = new AccountPage();
        originalAmount = accountPage.amount.getText();
        receiver = accountPage.accountName.getText();
        Utils.clickWithJS(accountPage.addMoneyButton);
    }
    @When("User enters the card number")
    public void user_enters_the_card_number() {
        new AddMoneyPage().cardNumberInput.sendKeys(ConfigurationReader.get("cardNumber"));
    }
    @When("User enters card holder")
    public void user_enters_card_holder() {
        cardHolder = "Checking"+ RandomStringUtils.randomAlphabetic(8);
        new AddMoneyPage().cardHolderInput.sendKeys(cardHolder);
    }
    @When("User enter expiry date")
    public void user_enter_expiry_date() {
        new AddMoneyPage().expiryDateInput.sendKeys(ConfigurationReader.get("expiryDate"));
    }
    @When("User enters ccv number")
    public void user_enters_ccv_number() {
        new AddMoneyPage().cvvInput.sendKeys(ConfigurationReader.get("cvv"));
    }
    @When("User enters amount {string}")
    public void user_enters_amount(String amount) {
        new AddMoneyPage().amountInput.sendKeys(amount);
    }
    @When("User clicks add button")
    public void user_clicks_add_button() {
        Utils.clickWithJS(new AddMoneyPage().addButton);
        Utils.waitFor(1);
    }
    @Then("User amount should be increased by {string}")
    public void user_amount_should_be_increased_by(String amount) {
        double actualAmount = Double.parseDouble(new AccountPage().amount.getText().replaceAll(",", ""));
        double expectedAmount = Double.parseDouble(originalAmount.replaceAll(",", "")) + Double.parseDouble(amount);
        Assert.assertEquals(expectedAmount, actualAmount, 0.1);
    }
    @Then("Transaction detail {string} should be added the top of the transactions list")
    public void transaction_detail_should_be_added_the_top_of_the_transactions_list(String amount) {
        Map<String, String> firstTransaction = new AccountPage().getTransactions().get(0);
        Assert.assertEquals(cardHolder, firstTransaction.get("Sender"));
        Assert.assertEquals(receiver, firstTransaction.get("Receiver"));
        Assert.assertEquals(Double.parseDouble(amount), Double.parseDouble(firstTransaction.get("Amount").replaceAll(",", "")), 0.1);
    }

}
