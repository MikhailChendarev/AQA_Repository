package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuestionPage {

    private WebDriver driver;

    @FindBy(xpath = "//div[@class='mainCont']")
    WebElement questionTable;

    @FindBy(xpath = "//button[text()='+ Добавить']")
    private WebElement addQuestionButton;

    @FindBy(xpath = "//div[@class='modalContent afade']")
    private WebElement addQuestion;

    @FindBy(xpath = "//textarea[@class='w-md-editor-text-input ']")
    private WebElement questionField;

    @FindBy(xpath = "//button[text()='Create']")
    private WebElement createButton;

    public QuestionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addNewQuestion(String question) {
        addQuestionButton.click();
        addQuestion.isDisplayed();
        questionField.sendKeys(question);
        createButton.click();
    }

    public boolean isQuestionDisplayed(String question) {
        return questionTable.findElement(By.xpath("//div[text()='" + question + "']")).isDisplayed();
    }
}
