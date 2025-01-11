package com.app.step_definitions;

import com.app.pages.AccountPage;
import com.app.pages.DashboardPage;
import com.app.utilities.Utils;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class AccountSummaryStepDefs {

    private final Logger logger = LoggerFactory.getLogger(AccountSummaryStepDefs.class);

    @When("User navigates to account page")
    public void user_navigates_to_account_page() {
        Utils.clickWithJS(new DashboardPage().openMoneyTransferButton);
    }
    @Then("User should see account type as {string}")
    public void user_should_see_account_type_as(String string) {
        String actualAccountType = new AccountPage().accountType.getText();
        Assert.assertEquals("CHECKING", actualAccountType);
    }
    @Then("User amount should be greater than zero")
    public void user_amount_should_be_greater_than_zero() {
        double actualAmount = Double.parseDouble(new AccountPage().amount.getText().replaceAll(",", ""));
        Assert.assertTrue(actualAmount > 0);
    }

    @Then("User should see transactions in date descending order if list is not empty")
    public void user_should_see_transactions_in_date_descending_order_if_list_is_not_empty() {
        List<Map<String, String>> transactionList = new AccountPage().getTransactions();

        if (transactionList.isEmpty()) {
            logger.info("There is no transaction!");
        } else {
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
            for(int i = 0; i < transactionList.size() - 1; i++) {
                try {
                    Date date1 = format.parse(transactionList.get(i).get("Time"));
                    Date date2 = format.parse(transactionList.get(i+1).get("Time"));
                    Assert.assertTrue(date1.compareTo(date2) > 0);
                }catch (Exception e) {
                    logger.error(e.getMessage());
                }
            }
        }

    }



}
