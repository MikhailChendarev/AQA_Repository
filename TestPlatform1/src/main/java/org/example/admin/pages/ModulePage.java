package org.example.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ModulePage extends DashboardPage {

    @FindBy(xpath = "//div[@class='mainCont']")
    public WebElement moduleTable;

    @FindBy(xpath = "//button[text()='+ Добавить']")
    private WebElement addModuleButton;

    @FindBy(xpath = "//div[@class='modalContent afade']")
    private WebElement moduleWindow;

    @FindBy(xpath = "//input[@class='form-control ' and @placeholder='name']")
    private WebElement moduleNameField;

    @FindBy(xpath = "//span[@class='ib' and contains(text(), '1000')]")
    private WebElement questionString;

    @FindBy(xpath = "//input[@class='form-control ' and @placeholder='ID для перемещения']")
    private WebElement idField;

    @FindBy(xpath = "//button[text()='Переместить по Id']")
    private WebElement transferButton;

    @FindBy(xpath = "//button[@class='btn-primary btn ' and text()='Create']")
    private WebElement createButton;

    public ModulePage() {
        PageFactory.initElements(driver, this);
    }

    public void createModule(String moduleName, String questionId) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(addModuleButton)).click();
        wait.until(ExpectedConditions.visibilityOf(moduleWindow));
        moduleNameField.sendKeys(moduleName);
        wait.until(ExpectedConditions.visibilityOf(idField));
        idField.sendKeys(questionId);
        wait.until(ExpectedConditions.visibilityOf(questionString));
        Point leftPoint = questionString.getLocation();
        transferButton.click();
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeToBe(questionString, "location", leftPoint.toString())));
        Point rightPoint = questionString.getLocation();
        if (!leftPoint.equals(rightPoint)) {
            createButton.click();
        }
    }

    public boolean isModuleDisplayed(String moduleName) {
        return moduleTable.findElement(By.xpath("//span[text()='" + moduleName + "']")).isDisplayed();
    }
}
