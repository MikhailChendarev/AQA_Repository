package org.example.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExamPage extends DashboardPage {

    @FindBy(xpath = "//div[@data-url='/exams']")
    private WebElement examsTable;

    @FindBy(xpath = "//button[text()='+ Добавить']")
    private WebElement addExamButton;

    @FindBy(xpath = "//input[@placeholder='Name']")
    private WebElement nameField;

    @FindBy(xpath = "//input[@placeholder='ID для перемещения']")
    private WebElement idField;

    @FindBy(xpath = "//button[text()='Переместить по Id']")
    private WebElement movingButton;

    @FindBy(xpath = "//button[text()='Create']")
    private WebElement createButton;

    public ExamPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean examIsDisplayed() {
        return examsTable.findElement(By.xpath("//span[text()='exam']")).isDisplayed();
    }

    public void createNewExam() {
        addExamButton.click();
        nameField.sendKeys("exam");
        idField.sendKeys("1000");
        movingButton.click();
        createButton.click();
    }
}
