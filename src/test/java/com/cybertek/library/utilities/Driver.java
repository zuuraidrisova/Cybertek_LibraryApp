package com.cybertek.library.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {

    //Singleton Design Pattern
    private Driver(){//private constructor so no ona can create an object of the class

    }

    //our driver field is private and static so we can access it thru static methods
    private static WebDriver driver;


    //static getter method to get our driver
    public static WebDriver getDriver(){

        if(driver == null){

            String browser = ConfigurationReader.getProperty("browser");

            switch (browser){

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                case "chrome-remote":
                    try {
                        ChromeOptions chromeOptions = new ChromeOptions();//to run tests on chrome browser remotely
                        URL url = new URL("http://54.87.102.95:4444/wd/hub");
                        //url is ip address of EC2 that is running Selenium Grid
                        driver = new RemoteWebDriver(url, chromeOptions);//we use remote web driver which takes 2 args
                        //first arg is url, second is chromeOptions

                    }catch (MalformedURLException e){//all in try catch because Url constructor throws checked exception

                        e.printStackTrace();
                    }
                    break;


            }
        }

        return driver;
    }


    public static void closeDriver(){

        if(driver != null){//if driver is not null

            driver.close();//close it

            driver = null;//and set the value to null
        }
    }




}
