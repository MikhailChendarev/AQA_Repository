package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InterviewsPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@id='example2_length']")
    WebElement interviewsTable;

    @FindBy(xpath = "//button[text()='+ Добавить']")
    private WebElement addInterviewButton;

    @FindBy(xpath = "//div[@class='modalContent afade']")
    private WebElement interviewsList;

    @FindBy(xpath = "//input[@class='form-control ']")
    private WebElement interviewField;

    @FindBy(xpath = "//button[text()='Create']")
    private WebElement createButton;

    public InterviewsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addNewInterview(String interviewName) {
        addInterviewButton.click();
        interviewsList.isDisplayed();
        interviewField.sendKeys(interviewName);
        createButton.click();
    }

    public boolean isInterviewDisplayed(String interviewName) {
        return interviewsTable.findElement(By.xpath("//span[text()='" + interviewName + "']")).isDisplayed();
    }
}
