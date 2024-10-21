package org.example;

import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.exceptions.CsvException;
import org.example.pages.*;
import org.example.utils.CsvUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Map;

public class MainTest extends BaseTest {

    @Test(priority = 1)
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("chendarev_mikhail", "U9uDBD–<A8)>SkA");
        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.isDashboardDisplayed());
    }

    @Test(priority = 2)
    @Ignore
    public void addNewInterviewTest() {
        InterviewsPage interviewsPage = new InterviewsPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(interviewsPage.interviewsTable));
        Assert.assertTrue(interviewsPage.interviewsTable.isDisplayed());
        interviewsPage.addNewInterview("interview");
        Assert.assertTrue(interviewsPage.isInterviewDisplayed("interview"));
    }

    @Test(priority = 3)
    @Ignore
    public void addNewQuestionTest() {
        QuestionPage questionPage = new QuestionPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(questionPage.questionTable));
        Assert.assertTrue(questionPage.questionTable.isDisplayed());
        questionPage.addNewQuestion("question");
        Assert.assertTrue(questionPage.isQuestionDisplayed("question"));
    }

    @Test(priority = 4)
    @Ignore
    public void createQuizTest() {
        QuizPage quizPage = new QuizPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(quizPage.quizTable));
        Assert.assertTrue(quizPage.quizTable.isDisplayed());
        quizPage.createQuiz("quiz");
        Assert.assertTrue(quizPage.isQuizDisplayed("quiz"));
    }

    @Test(priority = 5)
    @Ignore
    public void createModuleTest() {
        ModulePage modulePage = new ModulePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(modulePage.moduleTable));
        Assert.assertTrue(modulePage.moduleTable.isDisplayed());
        modulePage.createModule("module", "1001");
        Assert.assertTrue(modulePage.isModuleDisplayed("module"));
    }

    @Test(priority = 6)
    @Ignore
    public void createNewCourse() {
        CoursePage coursePage = new CoursePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(coursePage.courseTable));
        Assert.assertTrue(coursePage.courseTable.isDisplayed());
        coursePage.createCourse("course", "1001");
        Assert.assertTrue(coursePage.isCourseDisplayed("course"));
    }

    @Test(priority = 7, dataProvider = "userData", dataProviderClass = CsvUtils.class)
    public void processUserDataTest(String firstName, String lastName, String email,
                                    String username, String password, String roles,
                                    boolean isCV, String searchOpening, String searchStatus) {
        driver.get("https://aqa-admin.javacode.ru/users");
        WebElement addNewUserButton = driver.findElement(By.xpath("//button[text()='+ Добавить']"));
        addNewUserButton.click();
        UsersPage usersPage = new UsersPage(driver);
        usersPage.fillForm(firstName, lastName, email, username, password, roles, isCV, searchOpening, searchStatus);
        WebElement createNewUserButton = driver.findElement(By.xpath("//button[text()='Create']"));
        createNewUserButton.click();
    }
}
