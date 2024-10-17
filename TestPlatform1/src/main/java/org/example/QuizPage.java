package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuizPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='mainCont']")
    WebElement quizTable;

    @FindBy(xpath = "//button[text()='+ Добавить']")
    private WebElement addQuizButton;

    @FindBy(xpath = "//div[@class='modalContent afade']")
    private WebElement quizWindow;

    @FindBy(xpath = "//textarea[@class='w-md-editor-text-input ']")
    private WebElement quizField;

    @FindBy(xpath = "//button[text()='Create']")
    private WebElement createButton;

    public QuizPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void createQuiz(String quiz) {
        addQuizButton.click();
        quizWindow.isDisplayed();
        quizField.sendKeys(quiz);
        createButton.click();
    }

    public boolean isQuizDisplayed(String quiz) {
        return quizTable.findElement(By.xpath("//span[text()='" + quiz + "']")).isDisplayed();
    }
}
