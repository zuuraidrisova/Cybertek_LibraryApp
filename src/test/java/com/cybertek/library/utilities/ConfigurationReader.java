package com.cybertek.library.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


  /*
/1- We created properties object.
//2- We got our path and store in String
//3- We need to open the file
//4- We need to load the file
//5- close.file
     */


public class ConfigurationReader {


    //we have to create an object of Properties class from Java
    //we make it private, so it is more secure
    //we make it static because we are gonna use our static variable in static block
    private static Properties properties;

    static {//static block runs once and before anything else in the class
        //we need our config data before anything when we test

        //we get the path of our properties file
        String path = "configuration.properties";

        try{//FileInputStream class throws checked exception which
            // we need to handle right away using try/catch

            properties = new Properties();

            //we need to instantiate FileInputStream object and open the file in java's memory
            FileInputStream file = new FileInputStream(path);

            //we load our file into properties object
            properties.load(file);

            //we close opened file
            file.close();

            //we catch our exception
        }catch (IOException exception){

            System.out.println("Error while reading configuration file path");
            System.out.println("Incorrect file path!");
            exception.printStackTrace();
        }

    }


    //our custom getter method to get the property
    // using getProperty() method coming from Properties class if java
    public static String  getProperty(String keyWord){

        return properties.getProperty(keyWord);

    }



}
