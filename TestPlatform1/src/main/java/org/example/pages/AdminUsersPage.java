package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminUsersPage extends DashboardPage {

    @FindBy(xpath = "//small[text()='Имя']/following-sibling::input")
    private WebElement firstNameField;

    @FindBy(xpath = "//small[text()='Фамилия']/following-sibling::input")
    private WebElement lastNameField;

    @FindBy(xpath = "//small[text()='E-mail']/following-sibling::input")
    private WebElement emailField;

    @FindBy(xpath = "//small[text()='username']/following-sibling::input")
    private WebElement usernameField;

    @FindBy(xpath = "//small[text()='plain_password']/following-sibling::input")
    private WebElement passwordField;

    @FindBy(xpath = "//small[text()='roles']/following-sibling::input")
    private WebElement rolesField;

    @FindBy(xpath = "//input[@class='form-control ib' and @type='checkbox']")
    private WebElement isCVField;

    @FindBy(xpath = "//div[@class='react-datepicker__input-container']/input[@type='text']")
    private WebElement searchOpeningField;

    @FindBy(xpath = "//button[text()='---']")
    private WebElement successButton;

    @FindBy(xpath = "//button[text()='active_search']")
    private WebElement activeSearchButton;

    @FindBy(xpath = "//button[text()='pause_search']")
    private WebElement pauseSearchButton;

    @FindBy(xpath = "//button[text()='on_project']")
    private WebElement onProjectButton;

    @FindBy(xpath = "//button[text()='Create']")
    protected WebElement CreateNewUserButton;

    @FindBy(xpath = "//span[text()='chendarev_mikhail']")
    private WebElement user;

    @FindBy(xpath = "//button[text()='+ Add item']")
    private WebElement addItemButton;

    @FindBy(xpath = "//input[@class='ib']")
    private WebElement courseIdField;

    @FindBy(xpath = "//button[text()='Regenerate User's History']")
    private WebElement regenerateUserHistoryButton;

    public AdminUsersPage() {
        PageFactory.initElements(driver, this);
    }

    public void fillForm(String firstName, String lastName, String email,
                         String username, String password, String roles,
                         boolean isCV, String searchOpening, String searchStatus) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(firstNameField)).sendKeys(firstName);
        wait.until(ExpectedConditions.visibilityOf(lastNameField)).sendKeys(lastName);
        wait.until(ExpectedConditions.visibilityOf(emailField)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOf(usernameField)).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOf(rolesField)).sendKeys(roles);
        if (isCV) {
            if (!isCVField.isSelected()) {
                wait.until(ExpectedConditions.elementToBeClickable(isCVField)).click();
            }
        } else {
            if (isCVField.isSelected()) {
                wait.until(ExpectedConditions.elementToBeClickable(isCVField)).click();
            }
        }
        wait.until(ExpectedConditions.visibilityOf(searchOpeningField)).sendKeys(searchOpening);
        selectSearchStatus(searchStatus);
    }

    private void selectSearchStatus(String searchStatus) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        switch (searchStatus) {
            case "active_search":
                wait.until(ExpectedConditions.elementToBeClickable(activeSearchButton)).click();
                break;
            case "pause_search":
                wait.until(ExpectedConditions.elementToBeClickable(pauseSearchButton)).click();
                break;
            case "on_project":
                wait.until(ExpectedConditions.elementToBeClickable(onProjectButton)).click();
                break;
            default:
                wait.until(ExpectedConditions.elementToBeClickable(successButton)).click();
                break;
        }
    }

    public void selectUser() {
        user.click();
    }

    public void addItem() {
        addItemButton.click();
        courseIdField.sendKeys("1000");
        regenerateUserHistoryButton.click();
    }

}
