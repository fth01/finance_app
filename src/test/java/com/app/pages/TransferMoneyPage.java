package com.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TransferMoneyPage extends BasePage{

    @FindBy(xpath = "(//div[@dir='auto'][.='Transfer money'])[2]")
    public WebElement transferMoneyHeader;

    @FindBy(xpath = "//div[@dir='auto'][.='Sender account']/following-sibling::div[2]/select")
    public WebElement senderAccountDropdown;

    @FindBy(xpath = "//div[@dir='auto'][.='Receiver account']/following-sibling::div[2]/select")
    public WebElement receiverAccountDropdown;

    @FindBy(xpath = "//div[@dir='auto'][.='Amount']/following-sibling::div[2]/input")
    public WebElement amountInput;

    @FindBy(xpath = "//div[@dir='auto'][.='Send']/..")
    public WebElement sendButton;



}
