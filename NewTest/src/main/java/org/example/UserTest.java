package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.UserLoginPage;
import org.example.pages.UserToolbar;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class UserTest {

    private WebDriver driver;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterEach
    public void closeConnection() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testUserPlatform() {
        UserLoginPage loginPage = new UserLoginPage(driver);
        loginPage.login("chendarev_mikhail", "U9uDBD–<A8)>SkA");
        UserToolbar userToolbar = new UserToolbar(driver);
        userToolbar.goToCourses();
        userToolbar.goToInterviews();
        userToolbar.goToQuiz();
        userToolbar.goToSuggestion();
        userToolbar.goToVideo();
    }
}

