package org.example.user.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserCoursePage extends MainPage {

    @FindBy(xpath = "//a[@href='/courses/1045']")
    private WebElement newCourse;

    public UserCoursePage() {
        PageFactory.initElements(driver, this);
    }

    public void clickOnCourse() {
        newCourse.click();
    }

    public void knowledgeTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement knowledgeTestButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Проверить знания']")));
        knowledgeTestButton.click();
        WebElement stopRecord = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Завершить запись']")));
        stopRecord.click();
        WebElement rate5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='5']")));
        rate5.click();
    }
}
