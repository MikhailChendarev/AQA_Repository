package org.example.user.pages;

import org.example.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends BasePage {

    public MainPage() {
        PageFactory.initElements(driver, this);
    }

    public static void goToCourses() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement coursesPage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/courses']")));
        coursesPage.click();
    }
}
