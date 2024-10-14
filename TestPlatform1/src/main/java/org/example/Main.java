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
    public void testLogin() {
        driver.get("https://aqa-admin.javacode.ru/login");
        WebElement usernameField = driver.findElement(By.xpath("//*[@id=/username/]"));
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=/password/]"));
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=/root/]/div/div/div/div/div/form/div/div/div[3]/div[2]/div/button"));
        usernameField.sendKeys("chendarev_mikhail");
        passwordField.sendKeys("U9uDBD–<A8)>SkA");
        submitButton.click();
        WebElement dashboard = driver.findElement(By.xpath("//*[@id=/root/]/div/div[2]/div[1]/div/div"));
        Assert.assertTrue(dashboard.isDisplayed(), "Login failed!");
    }

    @Test
    public void addNewInterview() {
        driver.get("https://aqa-admin.javacode.ru/interviews");
        WebElement interviewsTable = driver.findElement(By.xpath("//*[@id=/root/]/div/div[2]/div[2]"));
        Assert.assertTrue(interviewsTable.isDisplayed());
        WebElement addInterviewButton = driver.findElement(By.xpath("//*[@id=/example2_length/]/div[1]/div[4]/div/div/span/button"));
        addInterviewButton.click();
        WebElement interviewsList = driver.findElement(By.xpath("/html/body/div[3]"));
        Assert.assertTrue(interviewsList.isDisplayed());
        WebElement interviewField = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div[1]"));
        interviewField.sendKeys("interview");
        WebElement createButton = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div[3]"));
        createButton.click();
        Assert.assertFalse(interviewsList.isDisplayed());
        WebElement newField = driver.findElement(By.xpath("//*[@id=/example2_length/]/div[4]/div/table/tbody[1]"));
        Assert.assertTrue(newField.isDisplayed());
    }
}