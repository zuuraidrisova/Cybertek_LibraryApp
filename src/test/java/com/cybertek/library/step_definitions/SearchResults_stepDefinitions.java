package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.UsersPage;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResults_stepDefinitions {

    UsersPage usersPage = new UsersPage();

    @Then("User should see following table columns:")
    public void user_should_see_following_table_columns(List<String> expectedColumnValues) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);

        wait.until(ExpectedConditions.titleIs("Library"));

        System.out.println("expectedColumnValues = " + expectedColumnValues);
        System.out.println("expectedColumnValues.size = " + expectedColumnValues.size());

        wait.until(ExpectedConditions.visibilityOf(usersPage.showRecordsDropdown));

        List<String> actualColumnValues = BrowserUtils.getElementsText(usersPage.tableHeaders);

        System.out.println("actualColumnValues = " + actualColumnValues);
        System.out.println("actualColumnValues.size = " + actualColumnValues.size());

        Assert.assertEquals(actualColumnValues, expectedColumnValues);

        System.out.println("Verification Passed");

        Thread.sleep(2000);


    }



}
