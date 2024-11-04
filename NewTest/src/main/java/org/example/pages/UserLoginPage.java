package org.example.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserLoginPage extends BasePage {

    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[text()='Вход']")
    private WebElement enterButton;

    public UserLoginPage(WebDriver driver) {
        super(driver);
        driver.get("https://aqa.javacode.ru/login");
    }

    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        enterButton.click();
    }
}
