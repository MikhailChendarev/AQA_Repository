package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserCoursePage extends MainPage {

    @FindBy(xpath = "//div[text()='test']")
    private WebElement newCourse;

    @FindBy(xpath = "//button[text()='Проверить знания']")
    private WebElement knowledgeTestButton;

    @FindBy(xpath = "//button[text()='Завершить запись']")
    private WebElement stopRecord;

    @FindBy(xpath = "//span[text()='5']")
    private  WebElement rate5;

    public UserCoursePage() {
        PageFactory.initElements(driver, this);
    }

    public void courseIsDisplayed() {
        newCourse.isDisplayed();
    }

    public void clickOnCourse() {
        newCourse.click();
    }

    public void knowledgeTest() {
        knowledgeTestButton.click();
        stopRecord.click();
        rate5.click();
    }
}
