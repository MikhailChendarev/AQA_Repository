package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;

import java.time.Duration;

public class MainTest {

    private WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/Google/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(priority = 1)
    public void loginTest() {
        driver.get("https://aqa-admin.javacode.ru/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("chendarev_mikhail", "U9uDBD–<A8)>SkA");
        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.isDashboardDisplayed());
    }

    @Test(priority = 2)
    public void addNewInterviewTest() {
        driver.get("https://aqa-admin.javacode.ru/interviews");
        InterviewsPage interviewsPage = new InterviewsPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(interviewsPage.interviewsTable));
        Assert.assertTrue(interviewsPage.interviewsTable.isDisplayed());
        interviewsPage.addNewInterview("interview");
        Assert.assertTrue(interviewsPage.isInterviewDisplayed("interview"));
    }

    @Test(priority = 3)
    public void addNewQuestionTest() {
        driver.get("https://aqa-admin.javacode.ru/theme-question");
        QuestionPage questionPage = new QuestionPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(questionPage.questionTable));
        Assert.assertTrue(questionPage.questionTable.isDisplayed());
        questionPage.addNewQuestion("question");
        Assert.assertTrue(questionPage.isQuestionDisplayed("question"));
    }

    @Test(priority = 4)
    public void createQuizTest() {
        driver.get("https://aqa-admin.javacode.ru/quizes");
        QuizPage quizPage = new QuizPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(quizPage.quizTable));
        Assert.assertTrue(quizPage.quizTable.isDisplayed());
        quizPage.createQuiz("quiz");
        Assert.assertTrue(quizPage.isQuizDisplayed("quiz"));
    }

    @Test(priority = 5)
    public void createModuleTest() {
        driver.get("https://aqa-admin.javacode.ru/course-module");
        ModulePage modulePage = new ModulePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(modulePage.moduleTable));
        Assert.assertTrue(modulePage.moduleTable.isDisplayed());
        modulePage.createModule("module", "1001");
        Assert.assertTrue(modulePage.isModuleDisplayed("module"));
    }

    @Test(priority = 6)
    public void createNewCourse() {
        driver.get("https://aqa-admin.javacode.ru/course");
        CoursePage coursePage = new CoursePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(coursePage.courseTable));
        Assert.assertTrue(coursePage.courseTable.isDisplayed());
        coursePage.createCourse("course", "1001");
        Assert.assertTrue(coursePage.isCourseDisplayed("course"));
    }
}

