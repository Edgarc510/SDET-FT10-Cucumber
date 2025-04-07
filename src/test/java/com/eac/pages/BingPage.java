package com.eac.pages;

import com.eac.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BingPage {

    public BingPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//textarea[@name='q']")
    public WebElement bingSearchBar;

    @FindBy(xpath = "//ol[@id='b_results']")
    public WebElement capitalText;
}
