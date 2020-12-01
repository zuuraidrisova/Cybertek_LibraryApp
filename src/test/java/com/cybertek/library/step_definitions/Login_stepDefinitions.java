package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.LoginPage;
import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_stepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("User is on login page")
    public void user_is_on_login_page() {

        String url = ConfigurationReader.getProperty("qa2_url");

        Driver.getDriver().get(url);

        Driver.getDriver().manage().window().maximize();

    }

    @When("User enters correct credentials for student")
    public void user_enters_correct_credentials_for_student() {

        String student_username = ConfigurationReader.getProperty("student_username");
        String student_password = ConfigurationReader.getProperty("student_password");

        loginPage.usernameInput.sendKeys(student_username);

        loginPage.passwordInput.sendKeys(student_password);

        loginPage.signInButton.click();

    }

    @Then("User should see books")
    public void user_should_see_books() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        String expectedText = "#books";

        wait.until(ExpectedConditions.urlContains(expectedText));

        String actualText = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualText.contains(expectedText));

        System.out.println("Verification Passed!");

        Thread.sleep(2000);

    }


    @When("User enters correct credentials for librarian")
    public void userEntersCorrectCredentialsForLibrarian() {

        String librarian_username = ConfigurationReader.getProperty("librarian13_username");
        String librarian_password = ConfigurationReader.getProperty("librarian13_password");

        loginPage.usernameInput.sendKeys(librarian_username);

        loginPage.passwordInput.sendKeys(librarian_password);

        loginPage.signInButton.click();
    }

    @Then("User should see dashboard")
    public void userShouldSeeDashboard() throws InterruptedException{

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        String expectedText = "#dashboard";

        wait.until(ExpectedConditions.urlContains(expectedText));

        String actualText = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualText.contains(expectedText));

        System.out.println("Verification Passed!");

        Thread.sleep(2000);

    }



}
