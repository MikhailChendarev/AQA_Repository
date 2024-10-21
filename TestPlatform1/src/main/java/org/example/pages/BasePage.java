package org.example.utils;

import org.openqa.selenium.WebDriver;

public class BasePage {

    protected static WebDriver driver;

    public static void setDriver(WebDriver driver) {
        BasePage.driver = driver;
    }
}
