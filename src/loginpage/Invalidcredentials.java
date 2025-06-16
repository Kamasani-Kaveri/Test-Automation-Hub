package loginpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Invalidcredentials {

    public static void main(String args[]) {


        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.xpath("//*[ @id=\"username\"]"));
        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        WebElement submit = driver.findElement(By.xpath("//*[@id=\"submit\"]"));

        username.sendKeys("studen");
        password.sendKeys("Password12");
        submit.click();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://practicetestautomation.com/practice-test-login/", "Unexpected URL after invalid login");

        // Alternatively, assert the presence of an error message
        WebElement errorMsg = driver.findElement(By.id("error")); // ID used here assumes the error message has ID 'error'
        Assert.assertTrue(errorMsg.isDisplayed(), "Error message not displayed for invalid credentials");



       // driver.quit();

    }
}
