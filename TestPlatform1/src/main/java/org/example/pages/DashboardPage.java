package org.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BasePage {

    @FindBy(xpath = "//div[@class='row']")
    private WebElement dashboard;

    @FindBy(xpath = "//a[@href='/interviews']")
    private WebElement interviewsLink;

    @FindBy(xpath = "//a[@href='/theme-question']")
    private WebElement questionLink;

    @FindBy(xpath = "//a[@href='/user-stats-new']")
    private WebElement userStatsLink;

    @FindBy(xpath = "//a[@href='/users']")
    private WebElement usersLink;

    @FindBy(xpath = "//a[@href='/quizes']")
    private WebElement quizLink;

    @FindBy(xpath = "//a[@href='/course']")
    private WebElement courseLink;

    @FindBy(xpath = "//a[@href='/course-module']")
    private WebElement courseModuleLink;


    public DashboardPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean isDashboardDisplayed() {
        return dashboard.isDisplayed();
    }

    public void goToInterviews() {
        interviewsLink.click();
    }

    public void goToQuestions() {
        questionLink.click();
    }

    public void goToUserStats() {
        userStatsLink.click();
    }

    public void goToUsers() {
        usersLink.click();
    }

    public void goToQuiz() {
        quizLink.click();
    }

    public void goToCourses() {
        courseLink.click();
    }

    public void goToCourseM() {
        courseModuleLink.click();
    }
}
