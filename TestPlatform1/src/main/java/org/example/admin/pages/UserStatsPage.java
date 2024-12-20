package org.example.admin.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserStatsPage extends DashboardPage {

    @FindBy(xpath = "//input[@id='combo-box-demo']")
    private WebElement inputField;

    @FindBy(xpath = "//span[text()='test']")
    private WebElement record;

    public UserStatsPage() {
        PageFactory.initElements(driver, this);
    }

    public void checkRecord() {
        inputField.sendKeys("chendarev_mikhail #1014");
        record.isDisplayed();
    }
}
