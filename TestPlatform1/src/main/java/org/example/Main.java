package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Main {

    private WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/Google");
        driver = new ChromeDriver();
    }

    @Test
    public void loginTest() {
        driver.get("https://aqa-admin.javacode.ru/login");
        WebElement usernameField = driver.findElement(By.xpath("//*[@id=/username/]"));
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=/password/]"));
        WebElement submitButton = driver.findElement(By.xpath("//button[text()='Sign in']"));
        usernameField.sendKeys("chendarev_mikhail");
        passwordField.sendKeys("U9uDBD–<A8)>SkA");
        submitButton.click();
        WebElement dashboard = driver.findElement(By.className("player "));
        Assert.assertTrue(dashboard.isDisplayed(), "Login failed!");
    }

    @Test
    public void addNewInterviewTest() {
        driver.get("https://aqa-admin.javacode.ru/interviews");
        WebElement interviewsTable = driver.findElement(By.id("example2_length"));
        Assert.assertTrue(interviewsTable.isDisplayed());
        WebElement addInterviewButton = driver.findElement(By.xpath("//button[text()='+ Добавить']"));
        addInterviewButton.click();
        WebElement interviewsList = driver.findElement(By.className("modalContent afade"));
        Assert.assertTrue(interviewsList.isDisplayed());
        WebElement interviewField = driver.findElement(By.className("form-control "));
        interviewField.sendKeys("interview");
        WebElement createButton = driver.findElement(By.xpath("//button[text()='Create']"));
        createButton.click();
        Assert.assertFalse(interviewsList.isDisplayed());
        interviewsTable.findElement(By.xpath("//span[text()='interview']"))
                .isDisplayed();
    }

    @Test
    public void addNewQuestionTest() {
        driver.get("https://aqa-admin.javacode.ru/theme-question");
        WebElement questionTable = driver.findElement(By.className("mainCont"));
        Assert.assertTrue(questionTable.isDisplayed());
        WebElement addQuestionButton = driver.findElement(By.xpath("//button[text()='+ Добавить']"));
        addQuestionButton.click();
        WebElement addQuestion = driver.findElement(By.className("modalContent afade"));
        addQuestion.isDisplayed();
        WebElement questionField = driver.findElement(By.className("w-md-editor-text-input "));
        questionField.sendKeys("question");
        WebElement createButton = driver.findElement(By.xpath("//button[text()='create']"));
        createButton.click();
        Assert.assertFalse(addQuestion.isDisplayed());
        questionTable.findElement(By.xpath("//span[text()='question']"))
                .isDisplayed();
    }

    @Test
    public void createQuizTest() {
        driver.get("https://aqa-admin.javacode.ru/quizes");
        WebElement quizTable = driver.findElement(By.className("mainCont"));
        Assert.assertTrue(quizTable.isDisplayed());
        WebElement addQuizButton = driver.findElement(By.xpath("//button[text()='+ Добавить']"));
        addQuizButton.click();
        WebElement quizWindow = driver.findElement(By.className("modalContent afade"));
        quizWindow.isDisplayed();
        WebElement quizField = driver.findElement(By.className("w-md-editor-text-input "));
        quizField.sendKeys("quiz");
        WebElement createButton = driver.findElement(By.xpath("//button[text()='create']"));
        createButton.click();
        Assert.assertFalse(quizWindow.isDisplayed());
        quizTable.findElement(By.xpath("//span[text()='quiz']"))
                .isDisplayed();
    }

    @Test
    public void createModuleTest() {
        driver.get("https://aqa-admin.javacode.ru/course-module");
        WebElement moduleTable = driver.findElement(By.className("mainCont"));
        Assert.assertTrue(moduleTable.isDisplayed());
        WebElement addModuleButton = driver.findElement(By.xpath("//button[text()='+ Добавить']"));
        addModuleButton.click();
        WebElement moduleWindow = driver.findElement(By.className("modalContent afade"));
        moduleWindow.isDisplayed();
        WebElement moduleNameField = driver.findElement(By.className("form-control"));
        moduleNameField.sendKeys("module");
        //не закончил
    }
}