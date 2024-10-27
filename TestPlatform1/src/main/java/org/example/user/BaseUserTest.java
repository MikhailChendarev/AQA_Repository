package org.example.user;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.admin.pages.AdminLoginPage;
import org.example.BasePage;
import org.example.user.pages.UserLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseUserTest {

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
    }

    @AfterClass
    protected void driverOff() {
        driver.close();
        driver.quit();
    }

}
