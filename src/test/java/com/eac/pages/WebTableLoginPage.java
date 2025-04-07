package com.eac.pages;

import com.eac.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTableLoginPage {

    public WebTableLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@name='username']")
    public WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(css = ".btn.btn-primary.login__submit")
    public WebElement loginBtn;

    @FindBy(xpath = "//button[.='Order']")
    public WebElement orderLink;

    public void login(){
        username.sendKeys("Test");
        password.sendKeys("Tester");
        loginBtn.click();
    }
    public void login(String user, String passWord){
        username.sendKeys(user);
        password.sendKeys(passWord);
        loginBtn.click();
    }



}
