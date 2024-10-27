package org.example.admin;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseAdminTest {

    protected WebDriver driver;

    @BeforeClass
    protected void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
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
