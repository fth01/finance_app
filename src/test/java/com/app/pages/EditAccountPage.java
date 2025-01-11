package com.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditAccountPage extends BasePage{

    @FindBy(xpath = "(//div[@dir='auto'][.='Account name'])[2]/following-sibling::div[2]/input")
    public WebElement accountNameInput;

    @FindBy(xpath = "//div[@dir='auto'][.='UPDATE']")
    public WebElement updateButton;

}
