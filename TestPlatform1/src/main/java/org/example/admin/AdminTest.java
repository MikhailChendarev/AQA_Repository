package org.example.admin;

import org.example.admin.entity.Interview;
import org.example.admin.entity.User;
import org.example.admin.pages.*;
import org.example.utils.TestDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AdminTest extends BaseAdminTest {

    private DashboardPage dashboardPage;

    @Test(priority = 1)
    public void loginTest() {
        AdminLoginPage adminLoginPage = new AdminLoginPage();
        adminLoginPage.login();
        dashboardPage = new DashboardPage();
        Assert.assertTrue(dashboardPage.isDashboardDisplayed());
    }

    @Test(priority = 2)
    public void addNewInterviewTest() {
        dashboardPage.goToInterviews();
        InterviewsPage interviewsPage = new InterviewsPage();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(interviewsPage.interviewsTable));
        Assert.assertTrue(interviewsPage.interviewsTable.isDisplayed());
        interviewsPage.addNewInterview("interview");
        Assert.assertTrue(interviewsPage.isInterviewDisplayed("interview"));
    }

    @Test(priority = 3)
    public void addNewQuestionTest() {
        dashboardPage.goToQuestions();
        QuestionPage questionPage = new QuestionPage();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(questionPage.questionTable));
        Assert.assertTrue(questionPage.questionTable.isDisplayed());
        questionPage.addNewQuestion("question");
        Assert.assertTrue(questionPage.isQuestionDisplayed("question"));
    }

    @Test(priority = 4)
    public void createQuizTest() {
        dashboardPage.goToQuiz();
        QuizPage quizPage = new QuizPage();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(quizPage.quizTable));
        Assert.assertTrue(quizPage.quizTable.isDisplayed());
        quizPage.createQuiz("quiz");
        Assert.assertTrue(quizPage.isQuizDisplayed("quiz"));
    }

    @Test(priority = 5)
    public void createModuleTest() {
        dashboardPage.goToCourseM();
        ModulePage modulePage = new ModulePage();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(modulePage.moduleTable));
        Assert.assertTrue(modulePage.moduleTable.isDisplayed());
        modulePage.createModule("module", "1000");
        Assert.assertTrue(modulePage.isModuleDisplayed("module"));
    }

    @Test(priority = 6)
    public void createNewCourse() {
        dashboardPage.goToCourses();
        AdminCoursePage adminCoursePage = new AdminCoursePage();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(adminCoursePage.courseTable));
        Assert.assertTrue(adminCoursePage.courseTable.isDisplayed());
        adminCoursePage.createCourse("course", "1001");
        Assert.assertTrue(adminCoursePage.isCourseDisplayed("course"));
    }

    @Test(priority = 7, dataProvider = "generateRegisterUserData", dataProviderClass = TestDataProvider.class)
    public void processUserDataTest(User user) {
        dashboardPage.goToUsers();
        AdminUsersPage usersPage = new AdminUsersPage();
        WebElement addNewUserButton = driver.findElement(By.xpath("//button[text()='+ Добавить']"));
        addNewUserButton.click();
        usersPage.fillForm(user);
        WebElement createNewUserButton = driver.findElement(By.xpath("//button[text()='Create']"));
        createNewUserButton.click();
    }

    @Test(priority = 8, dataProvider = "generateInterviewData", dataProviderClass = TestDataProvider.class)
    public void editingInterviewTest(Interview interview) {
        dashboardPage.goToInterviews();
        InterviewsPage interviewsPage = new InterviewsPage();
        interviewsPage.editInterview(interview);
    }

    @Test(priority = 9)
    public void addNewExamTest() {
        dashboardPage.goToExams();
        ExamPage examPage = new ExamPage();
        examPage.createNewExam();
        Assert.assertTrue(examPage.examIsDisplayed());
    }
}
