package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoursePage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@class='mainCont']")
    WebElement courseTable;

    @FindBy(xpath = "//button[text()='+ Добавить']")
    private WebElement addCourseButton;

    @FindBy(xpath = "//div[@class='modalContent afade']")
    private WebElement courseCreateWindow;

    @FindBy(xpath = "//input[@class='form-control ' and @placeholder='name']")
    private WebElement inputName;

    @FindBy(xpath = "//button[text()='+ Модуль ']")
    private WebElement addModule;

    @FindBy(xpath = "//input[@class='form-control ' and @placeholder='module']")
    private WebElement inputModule;

    @FindBy(xpath = "//button[text()='Create']")
    private WebElement createButton;

    public CoursePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void createCourse(String courseName, String moduleId) {
        addCourseButton.click();
        courseCreateWindow.isDisplayed();
        inputName.sendKeys(courseName);
        addModule.click();
        inputModule.sendKeys(moduleId);
        createButton.click();
    }

    public boolean isCourseDisplayed(String courseName) {
        return courseTable.findElement(By.xpath("//span[text()='" + courseName + "']")).isDisplayed();
    }
}
