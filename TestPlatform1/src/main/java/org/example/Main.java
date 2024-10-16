package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
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
        WebElement dashboard = driver.findElement(By.xpath("//*[@class='player ']"));
        Assert.assertTrue(dashboard.isDisplayed(), "Login failed!");
    }

    @Test
    public void addNewInterviewTest() {
        driver.get("https://aqa-admin.javacode.ru/interviews");
        WebElement interviewsTable = driver.findElement(By.id("example2_length"));
        Assert.assertTrue(interviewsTable.isDisplayed());
        WebElement addInterviewButton = driver.findElement(By.xpath("//button[text()='+ Добавить']"));
        addInterviewButton.click();
        WebElement interviewsList = driver.findElement(By.xpath("//*[@class='modalContent afade']"));
        Assert.assertTrue(interviewsList.isDisplayed());
        WebElement interviewField = driver.findElement(By.xpath("//*[@class='form-control ']"));
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
        WebElement questionTable = driver.findElement(By.xpath("//*[@class='mainCont']"));
        Assert.assertTrue(questionTable.isDisplayed());
        WebElement addQuestionButton = driver.findElement(By.xpath("//button[text()='+ Добавить']"));
        addQuestionButton.click();
        WebElement addQuestion = driver.findElement(By.xpath("//*[@class='modalContent afade']"));
        addQuestion.isDisplayed();
        WebElement questionField = driver.findElement(By.xpath("//*[@class='w-md-editor-text-input ']"));
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
        WebElement quizTable = driver.findElement(By.xpath("//*[@class='mainCont']"));
        Assert.assertTrue(quizTable.isDisplayed());
        WebElement addQuizButton = driver.findElement(By.xpath("//button[text()='+ Добавить']"));
        addQuizButton.click();
        WebElement quizWindow = driver.findElement(By.xpath("//*[@class='modalContent afade']"));
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
        WebElement moduleTable = driver.findElement(By.xpath("//*[@class='mainCont']"));
        Assert.assertTrue(moduleTable.isDisplayed());
        WebElement addModuleButton = driver.findElement(By.xpath("//button[text()='+ Добавить']"));
        addModuleButton.click();
        WebElement moduleWindow = driver.findElement(By.xpath("//*[@class='modalContent afade']"));
        moduleWindow.isDisplayed();
        WebElement moduleNameField = driver.findElement(By.xpath("//input[@class='form-control ' and @placeholder='name']"));
        moduleNameField.sendKeys("module");
        WebElement questionString = driver.findElement(By.xpath("//div[@class='row sort-item sort-questions rel ' and @data-id='0']"));
        Point leftPoint = questionString.getLocation();
        WebElement idField = driver.findElement(By.xpath("//input[@class='form-control ' and @placeholder='ID для перемещения']"));
        idField.sendKeys("1001");
        WebElement transferButton = driver.findElement(By.xpath("//button[@class='btn-primary btn']"));
        transferButton.click();
        Point rightPoint = questionString.getLocation();
        Assert.assertNotEquals(leftPoint, rightPoint);
        WebElement createButton = driver.findElement(By.xpath("//button[@class='btn-primary btn ' and text()='Create']"));
        createButton.click();
        Assert.assertFalse(moduleTable.isDisplayed());
        WebElement newModule = driver.findElement(By.xpath("//span[text()='module']"));
        newModule.isDisplayed();
    }

    @Test
    public void createNewCourse() {
        driver.get("https://aqa-admin.javacode.ru/course");
        WebElement courseTable = driver.findElement(By.xpath("//*[@class='mainCont']"));
        courseTable.isDisplayed();
        WebElement addCourseButton = driver.findElement(By.xpath("//button[text()='+ Добавить']"));
        addCourseButton.click();
        WebElement courseCreateWindow = driver.findElement(By.xpath("//*[@class='modalContent afade']"));
        courseCreateWindow.isDisplayed();
        WebElement inputName = driver.findElement(By.xpath("//input[@class='form-control ' and @placeholder='name']"));
        inputName.sendKeys("course");
        WebElement addModule = driver.findElement(By.xpath("//button[text()='+ Модуль ']"));
        addModule.click();
        WebElement inputModule = driver.findElement(By.xpath("//input[@class='form-control ' and @placeholder='module']"));
        inputModule.sendKeys("1001");
        WebElement createButton = driver.findElement(By.xpath("//button[text()='Create']"));
        createButton.click();
        Assert.assertFalse(courseTable.isDisplayed()); // в тест кейсе этого нет, но наверное должно быть
        WebElement newCourse = driver.findElement(By.xpath("//span[text()='course']"));
        newCourse.isDisplayed();
    }
}