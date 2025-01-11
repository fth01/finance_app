package com.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{

    @FindBy(xpath = "//div[@dir='auto'][.='Logout']")
    public WebElement logoutButton;

    @FindBy(xpath = "//div[@dir='auto'][.='Open Money Transfer']")
    public WebElement openMoneyTransferButton;

}
