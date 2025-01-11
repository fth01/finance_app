package com.app.pages;

import com.app.utilities.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class AddMoneyPage extends BasePage{

    @FindBy(xpath = "//div[@dir='auto'][.='Card number']/following-sibling::input")
    public WebElement cardNumberInput;

    @FindBy(xpath = "//div[@dir='auto'][.='Card holder']/following-sibling::input")
    public WebElement cardHolderInput;

    @FindBy(xpath = "//div[@dir='auto'][.='Expiry date']/following-sibling::input")
    public WebElement expiryDateInput;

    @FindBy(xpath = "//div[@dir='auto'][.='CVV']/following-sibling::input")
    public WebElement cvvInput;

    @FindBy(xpath = "//div[@dir='auto'][.='Amount']/following-sibling::input")
    public WebElement amountInput;

    @FindBy(xpath = "//div[@dir='auto'][.='Add']")
    public WebElement addButton;

    public void addMoney(Map<String,String> detail) {
        cardNumberInput.sendKeys(detail.get("Card Number"));
        cardHolderInput.sendKeys(detail.get("Card Holder"));
        expiryDateInput.sendKeys(detail.get("Expiry Date"));
        cvvInput.sendKeys(detail.get("CVV"));
        amountInput.sendKeys(detail.get("Amount"));

        Utils.clickWithJS(addButton);
    }



}
