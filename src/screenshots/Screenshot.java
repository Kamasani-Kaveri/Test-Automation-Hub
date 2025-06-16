package screenshots;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Screenshot {

    public static void main(String args[]) {

        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();

        // First Name
        driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys("k");

        // Last Name
        driver.findElement(By.xpath("//*[@id='lastName']")).sendKeys("king");

        // Invalid Email
        WebElement email = driver.findElement(By.xpath("//*[@id='userEmail']"));
        email.sendKeys("email");



        //Gender
        driver.findElement(By.xpath("//label[text()='Male']")).click();

        // Mobile Number
        driver.findElement(By.xpath("//*[@id='userNumber']")).sendKeys("1234567890");

        // Date of Birth
        WebElement dob = driver.findElement(By.xpath("//*[@id='dateOfBirthInput']"));
        dob.sendKeys(Keys.CONTROL + "a");
        dob.sendKeys("03 March 2002", Keys.ENTER);

        // Subjects
        WebElement subjectInput = driver.findElement(By.xpath("//*[@id='subjectsInput']"));
        subjectInput.sendKeys("Maths");
         new WebDriverWait(driver, Duration.ofSeconds(5)).until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='react-select-2-option-0']"))
        );
        subjectInput.sendKeys(Keys.ENTER);

        // Hobbies - Reading
        driver.findElement(By.xpath("//label[text()='Reading']")).click();

        // Upload Picture
        driver.findElement(By.xpath("//*[@id='uploadPicture']"))
                .sendKeys("/Users/kamasanikaveri/Downloads");

        // Current Address
        driver.findElement(By.xpath("//*[@id='currentAddress']"))
                .sendKeys("123 Main St, Bangalore");



        // State
        WebElement state = driver.findElement(By.xpath("//*[@id='react-select-3-input']"));
        state.sendKeys("NCR");
        state.sendKeys(Keys.ENTER);

        // City
        WebElement city = driver.findElement(By.xpath("//*[@id='react-select-4-input']"));
        city.sendKeys("Delhi");
        city.sendKeys(Keys.ENTER);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        // Submit
        driver.findElement(By.xpath("//*[@id='submit']")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }


        // Screenshot

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(screenshot, new File(" Error screenshot.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(" Error Screenshot captured for invalid email.");

        driver.quit();
    }
}











