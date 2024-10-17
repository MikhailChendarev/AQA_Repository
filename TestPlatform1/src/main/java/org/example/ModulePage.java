package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ModulePage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='mainCont']")
    WebElement moduleTable;

    @FindBy(xpath = "//button[text()='+ Добавить']")
    private WebElement addModuleButton;

    @FindBy(xpath = "//div[@class='modalContent afade']")
    private WebElement moduleWindow;

    @FindBy(xpath = "//input[@class='form-control ' and @placeholder='name']")
    private WebElement moduleNameField;

    @FindBy(xpath = "//div[@class='row sort-item sort-questions rel ' and @data-id='0']")
    private WebElement questionString;

    @FindBy(xpath = "//input[@class='form-control ' and @placeholder='ID для перемещения']")
    private WebElement idField;

    @FindBy(xpath = "//button[@class='btn-primary btn']")
    private WebElement transferButton;

    @FindBy(xpath = "//button[@class='btn-primary btn ' and text()='Create']")
    private WebElement createButton;

    public ModulePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void createModule(String moduleName, String questionId) {
        addModuleButton.click();
        moduleWindow.isDisplayed();
        moduleNameField.sendKeys(moduleName);
        Point leftPoint = questionString.getLocation();
        idField.sendKeys(questionId);
        transferButton.click();
        Point rightPoint = questionString.getLocation();
        if (!leftPoint.equals(rightPoint)) {
            createButton.click();
        }
    }

    public boolean isModuleDisplayed(String moduleName) {
        return moduleTable.findElement(By.xpath("//span[text()='" + moduleName + "']")).isDisplayed();
    }
}
