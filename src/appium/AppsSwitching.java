package appium;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;
import java.util.List;

public class AppsSwitching {

    public static void main(String[] args) throws Exception {


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:deviceName", "532bb9fa");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
//        capabilities.setCapability("appium:appPackage", "com.nutralis.app");
//        capabilities.setCapability("appium:appActivity", ".MainActivity");
        capabilities.setCapability("appium:noreset",false);
        capabilities.setCapability("appium:autoGrantPermissions", true);
        capabilities.setCapability("appium:app","/Users/kamasanikaveri/Downloads/olivergarden.apk");



        AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723"), capabilities);

        // App 1: com.nutralis.app
        System.out.println("Launched Nutralis app");
        Thread.sleep(5000); // Let the app load

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

        // Switch to App 2: com.darden.mobile.olivegarden
        driver.activateApp("com.darden.mobile.olivegarden");
        System.out.println("Switched to Olive Garden app");
        Thread.sleep(5000); // Let the app load



        // Switch back to App 1: com.nutralis.app
        driver.activateApp("com.nutralis.app");
        System.out.println("Switched back to Nutralis app");
    }
}

