package appium;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;

public class IosTesting {

    public static void main(String[] args) throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 16 Pro Max"); // Change as per your real device/simulator
        capabilities.setCapability(MobileCapabilityType.UDID, "YOUR_DEVICE_UDID"); // Replace with real device UDID
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");

        // App 1 - Main app under test
       // capabilities.setCapability(MobileCapabilityType.BUNDLE_ID, "com.yourcompany.nutralis"); // replace with actual bundle ID
       // capabilities.setCapability("app", "/path/to/Nutralis.ipa"); // Optional if app is already installed
        capabilities.setCapability("noReset", true);

        IOSDriver driver = new IOSDriver(new URL("http://localhost:4723"), capabilities);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Example: Wait for and click Login
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//XCUIElementTypeButton[@name='Login']"))).click();

        // Fill email and password (you may use Accessibility ID instead)
        driver.findElement(By.xpath("//XCUIElementTypeTextField[@value='Enter email']")).sendKeys("kamasanikaveri@gmail.com");
        driver.findElement(By.xpath("//XCUIElementTypeSecureTextField[@value='Enter password']")).sendKeys("Kaveri@369");

        // Click Continue
        driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Continue']")).click();

        System.out.println("Logged in to Nutralis iOS app");

        // Switch to App 2 - Olive Garden
        driver.activateApp("com.darden.olivegarden"); // Replace with real iOS bundle ID
        System.out.println("Switched to Olive Garden app");
        Thread.sleep(5000);

        // Switch back to Nutralis
        driver.activateApp("com.yourcompany.nutralis");
        System.out.println("Switched back to Nutralis app");

        driver.quit();
    }
}


