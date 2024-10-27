package org.example.admin.pages;

import org.example.admin.entity.Interview;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.format.DateTimeFormatter;

public class InterviewsPage extends DashboardPage {

    @FindBy(xpath = "//div[@id='example2_length']")
    public WebElement interviewsTable;

    @FindBy(xpath = "//button[text()='+ Добавить']")
    private WebElement addInterviewButton;

    @FindBy(xpath = "//div[@class='modalContent afade']")
    private WebElement interviewsList;

    @FindBy(xpath = "//input[@class='form-control ']")
    private WebElement interviewField;

    @FindBy(xpath = "//button[text()='Create']")
    private WebElement createButton;

    @FindBy(xpath = "//span[text()='interview']")
    private WebElement interview;

    @FindBy(xpath = "//input[@placeholder='Название']")
    private WebElement title;

    @FindBy(xpath = "//div[@class='react-datepicker__input-container']/input[@type='text']")
    private WebElement interviewDate;

    @FindBy(xpath = "//small[text()='Тип']/following-sibling::select[@class='form-control']")
    private WebElement interviewType;

    @FindBy(xpath = "//textarea[@placeholder='Собственная оценка интервью']")
    private WebElement selfAssessment;

    @FindBy(xpath = "//input[@placeholder='Видео ссылка']")
    private WebElement linkOnVideo;


    public InterviewsPage() {
        PageFactory.initElements(driver, this);
    }

    public void addNewInterview(String interviewName) {
        addInterviewButton.click();
        interviewsList.isDisplayed();
        interviewField.sendKeys(interviewName);
        createButton.click();
    }

    public boolean isInterviewDisplayed(String interviewName) {
        return interviewsTable.findElement(By.xpath("//span[text()='" + interviewName + "']")).isDisplayed();
    }

    public void editInterview(Interview i) {
        interview.click();
        title.clear();
        title.sendKeys(i.getTitle());
        interviewDate.clear();
        interviewDate.sendKeys(i.getDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        interviewType.sendKeys(i.getType());
        selfAssessment.clear();
        selfAssessment.sendKeys(i.getSelfAssessment());
        linkOnVideo.sendKeys(i.getLink());

    }

    public void selectType(String typeValue) {
        Select typeSelect = new Select(interviewType);
        switch (typeValue.toLowerCase()) {
            case "tech":
                typeSelect.selectByVisibleText("tech");
                break;
            case "hr":
                typeSelect.selectByVisibleText("HR");
                break;
            case "0":
                typeSelect.selectByVisibleText("");
                break;
            default:
                throw new IllegalArgumentException("Invalid type value: " + typeValue);
        }
    }
}
