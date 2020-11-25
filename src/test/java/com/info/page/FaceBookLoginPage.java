package com.info.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FaceBookLoginPage {
    WebDriver driver;
    @FindBy(id = "email")
    WebElement txtEmailId;

    @FindBy(id = "pass")
    WebElement txtPassword;

    @FindBy(id = "u_0_b")
    WebElement btnLogin;

    @FindBy(className = "_9ay7")
    WebElement loginFailedMessage;
    public FaceBookLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setUserName(String userName) {
        txtEmailId.sendKeys(userName);
    }

    public void setPassword(String password) {
        txtPassword.sendKeys(password);
    }

    public void clickOnLogin() {
        btnLogin.click();
    }

    public String validateLogin(){
       return loginFailedMessage.getText();
    }
}
