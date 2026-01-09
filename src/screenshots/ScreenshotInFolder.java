package screenshots;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class ScreenshotInFolder {

    public static void main(String[] args) {

        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            // Open a website
            driver.get("https://demoqa.com/automation-practice-form");

            // Take screenshot
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);

            // Destination folder and file name
            String folderPath = "screenshots";
            String fileName = "screenshot_" + System.currentTimeMillis() + ".png";
            File destination = new File(folderPath + File.separator + fileName);

            // Save the screenshot
            FileHandler.copy(source, destination);

            System.out.println("Screenshot saved : " + destination.getAbsolutePath());

        } catch (IOException e) {
            System.out.println("Error while saving screenshot : " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

