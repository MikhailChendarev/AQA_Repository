package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AdminToolbar extends BasePage {

    @FindBy(xpath = "//a[@href='/interviews']")
    private WebElement interviewsLink;

    @FindBy(xpath = "//a[@href='/theme-question']")
    private WebElement questionLink;

    @FindBy(xpath = "//a[@href='/interview-question']")
    private WebElement interviewQuestionLink;

    @FindBy(xpath = "//a[@href='/preview']")
    private WebElement previewLink;

    @FindBy(xpath = "//a[@href='/for-approve']")
    private WebElement forApproveLink;

    public AdminToolbar(WebDriver driver) {
        super(driver);
    }

    public void goToForApprove() {
        forApproveLink.click();
    }

    public void goToInterviewQuestion() {
        interviewQuestionLink.click();
    }

    public void goToPreview() {
        previewLink.click();
    }

    public void goToInterviews() {
        interviewsLink.click();
    }

    public void goToQuestion() {
        questionLink.click();
    }
}
