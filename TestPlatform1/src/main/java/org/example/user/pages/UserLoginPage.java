package org.example.user.pages;

import org.example.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPage extends BasePage {

    @FindBy(xpath = "//input[@id='username']")
    private WebElement login;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//button[text()='Sign in']")
    private WebElement sigInButton;

    public UserLoginPage() {
        driver.get("https://aqa.javacode.ru");
        PageFactory.initElements(driver, this);
    }

    public void login() {
        login.sendKeys("chendarev_mikhail");
        password.sendKeys("U9uDBD–<A8)>SkA");
        sigInButton.click();
    }
}
