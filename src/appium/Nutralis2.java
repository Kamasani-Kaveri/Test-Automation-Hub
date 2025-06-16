package appium;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Nutralis2 {

    public static void main(String[] args) {


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:deviceName", "emulator-5554");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:app", "/Users/kamasanikaveri/Downloads/nutralis.apk");
        capabilities.setCapability("appium:autoGrantPermissions", true);

        AndroidDriver driver = null;

        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Wait for Login button and click
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text=\"Login\"]"))).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.xpath("//android.widget.EditText[@text=\"Enter email\"]")).sendKeys("kamasanikaveri@gmail.com");
        driver.findElement(By.xpath("//android.widget.EditText[@text=\"Enter password\"]")).sendKeys("Kaveri@369");
        System.out.println("Checkboxes filled");

        driver.findElement(By.xpath("//android.widget.TextView[@text=\"Continue\"]")).click();
        System.out.println("Login Successfully");

        // Wait until home/dashboard screen appears
        try {
            Thread.sleep(5000); // or use WebDriverWait if there's an element to wait for
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Map<String, Object> scrollDown = new HashMap<>();
        scrollDown.put("direction", "down");
        scrollDown.put("percent", 0.8); // scroll length (0.0 to 1.0)
        scrollDown.put("left", 100);
        scrollDown.put("top", 500);
        scrollDown.put("width", 800);
        scrollDown.put("height", 1600);
        driver.executeScript("mobile: scrollGesture", scrollDown);

        Map<String, Object> scrollUp = new HashMap<>();
        scrollUp.put("direction", "up");
        scrollUp.put("percent", 0.8);
        scrollUp.put("left", 100);
        scrollUp.put("top", 500);
        scrollUp.put("width", 800);
        scrollUp.put("height", 1600);
        driver.executeScript("mobile: scrollGesture", scrollUp);



// Scroll down
        System.out.println("Scrolling down...");
        driver.executeScript("mobile: scrollGesture", scrollDown);

// Wait, then scroll up
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Scrolling up...");
        driver.executeScript("mobile: scrollGesture", scrollUp);



       
    }
}
