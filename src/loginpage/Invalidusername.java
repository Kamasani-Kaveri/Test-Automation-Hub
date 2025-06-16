package loginpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Invalidusername {

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
        password.sendKeys("Password123");
        submit.click();

        // Verify that the error message is displayed
        WebElement errorMsg = driver.findElement(By.id("error"));
        Assert.assertTrue(errorMsg.isDisplayed(), "Error message not displayed for invalid username.");


        //driver.quit();
    }
}
