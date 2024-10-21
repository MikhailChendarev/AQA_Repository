package org.example;

import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.exceptions.CsvException;
import org.example.pages.*;
import org.example.utils.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
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

    @Test(priority = 7)
    public void processUserDataTest() {
        UsersPage usersPage = new UsersPage(driver);
        WebElement addNewUserButton = driver.findElement(By.xpath("//button[text()='+ Добавить']"));
        try (CSVReaderHeaderAware reader = new CSVReaderHeaderAware(new FileReader(Paths.get("src/main/resources/pairwiseUsers.csv").toFile()))) {
            Map<String, String> record;
            while ((record = reader.readMap()) != null) {
                addNewUserButton.click();
                usersPage.fillForm(
                        record.get("Имя"),
                        record.get("Фамилия"),
                        record.get("email"),
                        record.get("username"),
                        record.get("plain_password"),
                        record.get("roles"),
                        Boolean.parseBoolean(record.get("isCV")),
                        record.get("Открытие поиска"),
                        record.get("Статус поиска")
                );
                WebElement createNewUserButton = driver.findElement(By.xpath("//button[text()='Create']"));
                createNewUserButton.click();
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}
