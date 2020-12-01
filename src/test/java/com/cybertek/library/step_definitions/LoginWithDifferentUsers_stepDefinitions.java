package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.LandingPage;
import com.cybertek.library.pages.LoginPage;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginWithDifferentUsers_stepDefinitions {

    LoginPage loginPage = new LoginPage();

    LandingPage landingPage = new LandingPage();

    @When("User logs in using {string} and {string}")
    public void user_logs_in_using_and(String email, String password) {

        loginPage.usernameInput.sendKeys(email);

        loginPage.passwordInput.sendKeys(password);

        loginPage.signInButton.click();

    }

    @Then("Account holder name should be {string}")
    public void account_holder_name_should_be(String name) throws InterruptedException{


        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);

        wait.until(ExpectedConditions.visibilityOf(landingPage.accountHolder));

        String actualName = landingPage.accountHolder.getText();

        System.out.println("actual name = " + actualName);
        System.out.println("expected name = " + name);

        Assert.assertTrue(actualName.equals(name));

        Thread.sleep(1000);

        System.out.println("Verification passed!");

    }


}
