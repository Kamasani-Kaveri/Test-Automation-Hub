package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjectmodel.LoginPage;

public class Priority {
    WebDriver driver;
    LoginPage loginPage;
    //DashboardPage dashboardPage;

    @BeforeClass
    public void setup() {
        // Set Chrome driver path
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://example.com/login");  // Replace with your URL

        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    @Test(priority = 1)
    public void validLoginTest() {
        loginPage.enterUsername("testuser");
        loginPage.enterPassword("password123");
        loginPage.clickLogin();

       String welcomeText = dashboardPage.getWelcomeMessage();
        Assert.assertTrue(welcomeText.contains("Welcome"), "Login failed or welcome message not displayed");
    }

    @Test(priority = 2)
    public void invalidLoginTest() {
        loginPage.enterUsername("invalidUser");
        loginPage.enterPassword("wrongPass");
        loginPage.clickLogin();

        String error = loginPage.getErrorMessage();
        Assert.assertEquals(error, "Invalid credentials");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
