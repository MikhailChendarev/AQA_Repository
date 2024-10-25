package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage extends DashboardPage {

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[text()='Sign in']")
    private WebElement submitButton;

    public AdminLoginPage() {
        driver.get("https://aqa-admin.javacode.ru");
        PageFactory.initElements(driver, this);
    }

    public void login() {
        usernameField.sendKeys("chendarev_mikhail");
        passwordField.sendKeys("U9uDBD–<A8)>SkA");
        submitButton.click();
    }
}
