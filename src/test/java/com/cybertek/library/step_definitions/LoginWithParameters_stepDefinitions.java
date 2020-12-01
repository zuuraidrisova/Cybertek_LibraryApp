package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.LandingPage;
import com.cybertek.library.pages.LoginPage;
import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginWithParameters_stepDefinitions {

    LoginPage loginPage = new LoginPage();
    LandingPage landingPage = new LandingPage();

    @Given("I am on a login page")
    public void i_am_on_a_login_page() {

        String url = ConfigurationReader.getProperty("qa2_url");

        Driver.getDriver().get(url);

        Driver.getDriver().manage().window().maximize();
    }


    @When("User enters {string} into username")
    public void user_enters_into_username(String username) {

        loginPage.usernameInput.sendKeys(username);
    }

    @When("User enters {string} into password")
    public void user_enters_into_password(String password) {

        loginPage.passwordInput.sendKeys(password);
    }
    @When("User clicks to signIn button")
    public void user_clicks_to_sign_in_button() {

        loginPage.signInButton.click();
    }


    @Then("Dashboard should be displayed")
    public void dashboard_should_be_displayed() throws InterruptedException{

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);

        String expectedInUrl = "#dashboard";

        wait.until(ExpectedConditions.urlContains(expectedInUrl));

        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedInUrl));

        System.out.println("actualUrl = " + actualUrl);
        System.out.println("Verification passed!");

        Thread.sleep(2000);


    }


    @Then("there should be {int} users")
    public void there_should_be_users(Integer userAmount) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);

        String expectedUserAmount = String.valueOf(userAmount);

        wait.until(ExpectedConditions.visibilityOf(landingPage.usersAmount));

        String  actualUserAmount = landingPage.usersAmount.getText();

        Assert.assertTrue(actualUserAmount.equals(expectedUserAmount));

        System.out.println("actualUserAmount = " + actualUserAmount);
        System.out.println("Verification passed!");

        Thread.sleep(2000);


    }

    @Then("User should see {int} borrowed books")
    public void userShouldSeeBorrowedBooks(int borrowedBooksCount) throws InterruptedException {


        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);

        String expectedBorrowedBookCount = String.valueOf(borrowedBooksCount);

        wait.until(ExpectedConditions.visibilityOf(landingPage.usersAmount));

        String  actualBorrowedBookCount = landingPage.borrowedBooksCount.getText();

        Assert.assertTrue(actualBorrowedBookCount.equals(expectedBorrowedBookCount));

        System.out.println("actualBorrowedBookCount = " + actualBorrowedBookCount);
        System.out.println("Verification passed!");

        Thread.sleep(2000);


    }


    @When("User enters {string} and {string}")
    public void userEntersAnd(String username, String password) {

        loginPage.usernameInput.sendKeys(username);

        loginPage.passwordInput.sendKeys(password);

        loginPage.signInButton.click();

    }


}
