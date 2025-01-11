package com.app.pages;

import com.app.utilities.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//div[@dir='auto'][.='Enter username*']/following-sibling::input")
    public WebElement usernameInput;

    @FindBy(xpath = "//div[@dir='auto'][.='Enter password*']/following-sibling::input")
    public WebElement passwordInput;

    @FindBy(xpath = "//div[@dir='auto'][.='Login']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@dir='auto'][.='Username or Password Invalid!']")
    public WebElement errorMessage;

    public void login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        Utils.clickWithJS(loginButton);
    }



}
