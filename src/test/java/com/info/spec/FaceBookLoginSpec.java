package com.info.spec;

import com.info.page.FaceBookLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FaceBookLoginSpec {
    private WebDriver driver;
    FaceBookLoginPage facebookpage;
    @BeforeTest
    public void setupWebDriverBinary() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        facebookpage =new FaceBookLoginPage(driver);
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void validateLogin() {
        driver.get("https://www.facebook.com/");
        driver.findElement(By.id("email")).sendKeys("nidhi3578@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("123");
        driver.findElement(By.id("u_0_b")).submit();
        String ActualErrorMessage = driver.findElement(By.className("_9ay7")).getText();
        String ExpectedErrorMessage = "The password that you've entered is incorrect. Forgotten password?";
        if (ActualErrorMessage.equals(ExpectedErrorMessage)) {
            System.out.println("Test Pass") ;
        } else {
            System.out.println("Test Failed");
        }
    }

    @Test
    public void login(){
        facebookpage.setUserName("nidhi3578@gmail.com");
        facebookpage.setPassword("123");
        facebookpage.clickOnLogin();
        String expectedString;
        expectedString = "The password that you've entered is incorrect. Forgotten password?";
        Assert.assertEquals(facebookpage.validateLogin(),expectedString);
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
