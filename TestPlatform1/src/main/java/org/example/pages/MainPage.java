package org.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(xpath = "//div[text()='Курсы']")
    private WebElement coursesPage;

    public void goToCoursesPage() {
        coursesPage.click();
    }

    public void goToCourses() {
        coursesPage.click();
    }

}
