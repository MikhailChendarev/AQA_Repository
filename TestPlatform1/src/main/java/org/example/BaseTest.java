package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.AdminLoginPage;
import org.example.pages.BasePage;
import org.example.pages.DashboardPage;
import org.example.pages.UserLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    protected void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--use-fake-ui-for-media-stream");
        options.addArguments("--use-fake-device-for-media-stream");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        BasePage.setDriver(driver);
        AdminLoginPage adminLoginPage = new AdminLoginPage();
        adminLoginPage.login();
        UserLoginPage userLoginPage = new UserLoginPage();
        userLoginPage.login();
    }

    @AfterClass
    protected void driverOff() {
        driver.close();
        driver.quit();
    }

}
