package com.trendyol.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OrderJourney {

    WebDriver webDriver;


    @Test
    public void trendyolJourney(){
        startUp();
        clickAccount();
        clickSignIn();
        signIn();
        closeDiscountPopup();
        electronicPage();
    }


    public void startUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments();
        options.addArguments("--disable-notifications");

        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        webDriver.get("https://www.trendyol.com/");

        By closePopUpButtonBy = By.className("fancybox-close");

        webDriver.findElement(closePopUpButtonBy).click();
    }


    public void clickAccount(){

            By loginImageBy = By.className("account-user");
            webDriver.findElement(loginImageBy).click();
        }

    public void clickSignIn(){
            By signInBy = By.cssSelector(".q-secondary.q-button-medium.q-button.tab.button.right");
            webDriver.findElement(signInBy).click();
    }

    public void signIn() {
        By sendEmailBy = By.id("register-email");
        By sendPasswordBy = By.id("register-password-input");
        By signInButtonBy = By.cssSelector(".q-primary.q-fluid.q-button-medium.q-button.submit");
        String email = "eqw82094@eoopy.com";
        String password = "Helenoy1";

        webDriver.findElement(sendEmailBy).sendKeys(email);
        webDriver.findElement(sendPasswordBy).sendKeys(password);
        webDriver.findElement(signInButtonBy).click();

    }
    public void closeDiscountPopup(){
        By closeDiscoundPopupBy = By.className("modal-close");

        webDriver.findElement(closeDiscoundPopupBy).click();
    }

    public void electronicPage(){
        By electronicTabBy = By.cssSelector("#navigation-wrapper > nav > ul > li:nth-child(9) > a");

        webDriver.findElement(electronicTabBy).click();
    }


//    public void scroolHomePage(){
//        webdriver.
//    }

    @AfterMethod
    public void quitDriver(){
        webDriver.quit();
    }


    }

