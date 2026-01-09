package registerpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BlankHobbies {

    public static void main(String args[]) {

        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Register.html");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Kamasani");
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Kaveri");
        driver.findElement(By.xpath("//textarea[@ng-model='Adress']")).sendKeys("Karnataka");
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("kamasanikaveri@gmail.com");
        driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("1234567890");

        driver.findElement(By.xpath("//input[@value='FeMale']")).click();
        driver.findElement(By.id("checkbox2"));


        driver.findElement(By.id("msdd")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement arabicOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Arabic']")));
        arabicOption.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//label[text()='Languages']")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Select skills = new Select(driver.findElement(By.id("Skills")));
        skills.selectByVisibleText("Java");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("countries")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        driver.findElement(By.xpath("//span[@role='combobox']")).click();
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Australia");
        driver.findElement(By.xpath("//li[contains(text(),'Australia')]")).click();


        driver.findElement(By.id("yearbox")).sendKeys("1990");
        driver.findElement(By.xpath("//select[@placeholder='Month']")).sendKeys("February");
        driver.findElement(By.id("daybox")).sendKeys("10");

        driver.findElement(By.id("firstpassword")).sendKeys("Test@123");
        driver.findElement(By.id("secondpassword")).sendKeys("Test@123");

        driver.findElement(By.id("submitbtn")).click();

    }
}


