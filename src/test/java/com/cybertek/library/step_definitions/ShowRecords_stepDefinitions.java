package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.LandingPage;
import com.cybertek.library.pages.LoginPage;
import com.cybertek.library.pages.UsersPage;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ShowRecords_stepDefinitions {

    LoginPage loginPage = new LoginPage();

    LandingPage landingPage = new LandingPage();

    UsersPage usersPage = new UsersPage();

    Select select;

    @Given("User is on landing page")
    public void user_is_on_landing_page() {

        String url = ConfigurationReader.getProperty("qa2_url");

        Driver.getDriver().get(url);

        Driver.getDriver().manage().window().maximize();

        String librarian_username = ConfigurationReader.getProperty("librarian13_username");
        String librarian_password = ConfigurationReader.getProperty("librarian13_password");


        loginPage.usernameInput.sendKeys(librarian_username);

        loginPage.passwordInput.sendKeys(librarian_password);

        loginPage.signInButton.click();

    }

    @When("User clicks {string} link")
    public void userClicksLink(String link) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);

        wait.until(ExpectedConditions.titleIs("Library"));

        switch (link.toLowerCase()){

            case "dashboard":
                landingPage.dashboardLink.click();
                break;

            case "users":
                landingPage.usersLink.click();
                break;

            case "books":
                landingPage.booksLink.click();
                break;

        }

    }


    @Then("Show records default value should be {int}")
    public void show_records_default_value_should_be(Integer dropdownDefaultValue) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);

        wait.until(ExpectedConditions.visibilityOf(usersPage.showRecordsDropdown));

        select = new Select(usersPage.showRecordsDropdown);

        String actualDropdownDefaultValue = select.getFirstSelectedOption().getText();
        String expectedDropdownDefaultValue = String.valueOf(dropdownDefaultValue);

        Assert.assertTrue(actualDropdownDefaultValue.equals(expectedDropdownDefaultValue));

        System.out.println("actualDropdownDefaultValue = " + actualDropdownDefaultValue);

        System.out.println("VERIFICATION PASSED!");

    }

    @Then("Show records should have following options:")
    public void show_records_should_have_following_options(List<String> expectedDropDownOptions) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);

        wait.until(ExpectedConditions.visibilityOf(usersPage.showRecordsDropdown));

        select = new Select(usersPage.showRecordsDropdown);

        List<WebElement> listOfWebElement = select.getOptions();

        List<String> actualDropdownValues = BrowserUtils.getElementsText(listOfWebElement);

        Assert.assertEquals(actualDropdownValues, expectedDropDownOptions);

        System.out.println("actualDropdownValues = " + actualDropdownValues);
        System.out.println("expectedDropDownOptions = " + expectedDropDownOptions);

        System.out.println("Verification passed!");

        Thread.sleep(2000);

    }



}
