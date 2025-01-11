package com.app.pages;

import com.app.utilities.TestDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountPage extends BasePage{

    @FindBy(xpath = "//div[@dir='auto'][.='Back']")
    public WebElement backButton;

    @FindBy(xpath = "//div[@dir='auto'][.='Account name']/following-sibling::div")
    public WebElement accountName;

    @FindBy(xpath = "//div[@dir='auto'][.='Account type']/following-sibling::div")
    public WebElement accountType;

    @FindBy(xpath = "//div[@dir='auto'][.='Amount']/following-sibling::div")
    public WebElement amount;

    @FindBy(xpath = "//div[@dir='auto'][.='Transactions']/following-sibling::div[1]/div/div")
    public List<WebElement> transactionsList;

    @FindBy(xpath = "//div[@dir='auto'][.='Transfer money']")
    public WebElement transferMoneyButton;

    @FindBy(xpath = "//div[@dir='auto'][.='Add money']")
    public WebElement addMoneyButton;

    @FindBy(xpath = "//div[@dir='auto'][.='Edit account']")
    public WebElement editAccountButton;


    public List<Map<String, String>> getTransactions() {
        List<Map<String, String>> result = new ArrayList<>();
        for (int i = 1; i < transactionsList.size() + 1; i++) {
            Map<String, String> transaction = new HashMap<>();
            transaction.put("Sender", TestDriver.get().findElement(By.xpath("(//div[@dir='auto'][.='Sender: '])["+i+"]/following-sibling::div")).getText());
            transaction.put("Receiver", TestDriver.get().findElement(By.xpath("(//div[@dir='auto'][.='Receiver: '])["+i+"]/following-sibling::div")).getText());
            transaction.put("Time", TestDriver.get().findElement(By.xpath("(//div[@dir='auto'][.='Time: '])["+i+"]/following-sibling::div")).getText());
            transaction.put("Amount", TestDriver.get().findElement(By.xpath("(//div[@dir='auto'][.='Amount: '])["+i+"]/following-sibling::div")).getText());

            result.add(transaction);
        }

        return result;

    }


}
