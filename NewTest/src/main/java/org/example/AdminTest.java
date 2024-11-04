package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.AdminLoginPage;
import org.example.pages.AdminToolbar;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AdminTest {

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
    public void testAdminPlatform() {
        AdminLoginPage loginPage = new AdminLoginPage(driver);
        loginPage.login("chendarev_mikhail", "U9uDBD–<A8)>SkA");
        AdminToolbar adminToolbar = new AdminToolbar(driver);
        adminToolbar.goToForApprove();
        adminToolbar.goToInterviewQuestion();
        adminToolbar.goToPreview();
        adminToolbar.goToInterviews();
        adminToolbar.goToQuestion();
    }
}

