package loginpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Blankfields {

    public static void main(String args[]) {


        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.xpath("//*[ @id=\"username\"]"));
        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        WebElement submit = driver.findElement(By.xpath("//*[@id=\"submit\"]"));

        username.clear();
        password.clear();
        submit.click();

        WebElement errorMsg = driver.findElement(By.id("error")); // Adjust the locator based on the actual site

        Assert.assertTrue(errorMsg.isDisplayed(), "Error message not displayed for blank login.");

        String expectedErrorText = "Your username is invalid!"; // Replace with actual expected message if different
        Assert.assertEquals(errorMsg.getText().trim(), expectedErrorText, "Unexpected error message for blank login.");

        //driver.quit();

    }
}

