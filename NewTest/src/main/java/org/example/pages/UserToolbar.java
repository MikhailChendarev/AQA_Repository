package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserToolbar extends BasePage {

    @FindBy(xpath = "//a[@href='/courses']")
    private WebElement coursesLink;

    @FindBy(xpath = "//a[@href='/interviews']")
    private WebElement interviewsLink;

    @FindBy(xpath = "//a[@href='/quiz']")
    private WebElement quizLink;

    @FindBy(xpath = "//a[@href='/suggestions']")
    private WebElement suggestionLink;

    @FindBy(xpath = "//a[@href='/video']")
    private WebElement videoLink;

    @FindBy(xpath = "//a[@href='/mic']")
    private WebElement micLink;

    @FindBy(xpath = "//a[@href='/profile']")
    private WebElement profileLink;

    public UserToolbar(WebDriver driver) {
        super(driver);
    }

    public void goToCourses() {
        coursesLink.click();
    }

    public void goToInterviews() {
        interviewsLink.click();
    }

    public void goToQuiz() {
        quizLink.click();
    }

    public void goToSuggestion() {
        suggestionLink.click();
    }

    public void goToVideo() {
        videoLink.click();
    }
}
