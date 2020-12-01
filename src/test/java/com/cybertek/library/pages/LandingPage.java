package com.cybertek.library.pages;

import com.cybertek.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends BasePage{

    //in this class we have all web elements from base page class since we inherited them
    public LandingPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "(//h2[@class='font-light m-b-0'])[1]")
    public WebElement usersAmount;

    @FindBy(xpath = "(//h2[@class='font-light m-b-0'])[3]")
    public WebElement borrowedBooksCount;

    @FindBy(xpath = "//a[@class='nav-link dropdown-toggle']//span")
    public WebElement accountHolder;



}
