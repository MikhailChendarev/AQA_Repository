package org.example;

import org.example.pages.*;
import org.example.utils.UserDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainTest extends BaseTest {

    @Test(priority = 1)
    public void loginTest() {
        DashboardPage dashboardPage = new DashboardPage();
        Assert.assertTrue(dashboardPage.isDashboardDisplayed());
    }

    @Test(priority = 2)
    @Ignore
    public void addNewInterviewTest() {
        InterviewsPage interviewsPage = new InterviewsPage();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(interviewsPage.interviewsTable));
        Assert.assertTrue(interviewsPage.interviewsTable.isDisplayed());
        interviewsPage.addNewInterview("interview");
        Assert.assertTrue(interviewsPage.isInterviewDisplayed("interview"));
    }

    @Test(priority = 3)
    @Ignore
    public void addNewQuestionTest() {
        QuestionPage questionPage = new QuestionPage();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(questionPage.questionTable));
        Assert.assertTrue(questionPage.questionTable.isDisplayed());
        questionPage.addNewQuestion("question");
        Assert.assertTrue(questionPage.isQuestionDisplayed("question"));
    }

    @Test(priority = 4)
    @Ignore
    public void createQuizTest() {
        QuizPage quizPage = new QuizPage();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(quizPage.quizTable));
        Assert.assertTrue(quizPage.quizTable.isDisplayed());
        quizPage.createQuiz("quiz");
        Assert.assertTrue(quizPage.isQuizDisplayed("quiz"));
    }

    @Test(priority = 5)
    @Ignore
    public void createModuleTest() {
        ModulePage modulePage = new ModulePage();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(modulePage.moduleTable));
        Assert.assertTrue(modulePage.moduleTable.isDisplayed());
        modulePage.createModule("module", "1001");
        Assert.assertTrue(modulePage.isModuleDisplayed("module"));
    }

    @Test(priority = 6)
    @Ignore
    public void createNewCourse() {
        AdminCoursePage adminCoursePage = new AdminCoursePage();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(adminCoursePage.courseTable));
        Assert.assertTrue(adminCoursePage.courseTable.isDisplayed());
        adminCoursePage.createCourse("course", "1001");
        Assert.assertTrue(adminCoursePage.isCourseDisplayed("course"));
    }
    @Ignore
    @Test(priority = 7, dataProvider = "userData", dataProviderClass = UserDataProvider.class, alwaysRun = true)
    public void processUserDataTest(String firstName, String lastName, String email,
                                    String username, String password, String roles,
                                    boolean isCV, String searchOpening, String searchStatus) {
        AdminUsersPage usersPage = new AdminUsersPage();
        WebElement addNewUserButton = driver.findElement(By.xpath("//button[text()='+ Добавить']"));
        addNewUserButton.click();
        usersPage.fillForm(firstName, lastName, email, username, password, roles, isCV, searchOpening, searchStatus);
        WebElement createNewUserButton = driver.findElement(By.xpath("//button[text()='Create']"));
        createNewUserButton.click();
    }

    @Test(priority = 8)
    public void OpenAccessTest() {
        AdminUsersPage usersPage = new AdminUsersPage();
        usersPage.selectUser();
        usersPage.addItem();
        UserCoursePage userCoursePage = new UserCoursePage();
        userCoursePage.courseIsDisplayed();
    }

    @Test(priority = 9)
    public void createVoiceRecordTest() {
        UserCoursePage userCoursePage = new UserCoursePage();
        userCoursePage.clickOnCourse();
        userCoursePage.knowledgeTest();
        UserStatsPage userStatsPage = new UserStatsPage();
        userStatsPage.checkRecord();
    }
}
