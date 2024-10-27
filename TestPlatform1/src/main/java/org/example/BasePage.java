package org.example;

import org.openqa.selenium.WebDriver;

public class BasePage {

    public static WebDriver driver;

    public static void setDriver(WebDriver driver) {
        BasePage.driver = driver;
    }
}
