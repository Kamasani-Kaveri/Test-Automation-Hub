package loginpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Invalidpassword {

    public static void main(String args[]) {


        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.xpath("//*[ @id=\"username\"]"));
        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        WebElement submit = driver.findElement(By.xpath("//*[@id=\"submit\"]"));

        username.sendKeys("student");
        password.sendKeys("Password12");
        submit.click();

        WebElement errorMsg = driver.findElement(By.id("error"));
        Assert.assertTrue(errorMsg.isDisplayed(), "Error message is not displayed for invalid password.");





        //driver.quit();

    }
}
