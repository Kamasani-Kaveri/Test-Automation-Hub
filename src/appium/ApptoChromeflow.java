package appium;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;
import java.util.Set;

public class ApptoChromeflow {

    public static void main(String[] args) throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:deviceName", "532bb9fa");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:noReset", false);
        capabilities.setCapability("appium:chromedriver_autodownload", true);
        capabilities.setCapability("appium:autoGrantPermissions", true);
        capabilities.setCapability("appium:app", "/Users/kamasanikaveri/Downloads/olivergarden.apk");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        System.out.println("App launched!");

        // Step 1: Click "GET STARTED"
        WebElement getStarted = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.TextView[@text='GET STARTED']")));
        getStarted.click();

        // Step 2: Click "Login"
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.TextView[@text='Login']")));
        loginBtn.click();

        System.out.println("Login clicked, waiting for Chrome to launch...");
        Thread.sleep(8000); // Wait for Chrome to open

        // Step 3: Switch control to Chrome app
        driver.startActivity(new Activity("com.android.chrome", "com.google.android.apps.chrome.Main"));
        System.out.println("Switched to Chrome");

        Thread.sleep(5000); // Let Chrome load the page

        // Step 4: Get available contexts and switch to WebView
        Set<String> contexts = driver.getContextHandles();
        for (String context : contexts) {
            System.out.println("Available context: " + context);
        }

        // Switch to Chrome WebView context
        driver.context("WEBVIEW_com.android.chrome");
        System.out.println("Switched to WEBVIEW_com.android.chrome");

        Thread.sleep(5000);

        WebElement email=driver.findElement(By.xpath("(//android.view.View[@text=\"Log In\"])[2]/android.view.View[1]/android.widget.EditText"));
        email.sendKeys("prashantg+1@geekyants.com");

        WebElement password = driver.findElement(By.xpath("(//android.view.View[@text=\"Log In\"])[2]/android.view.View[2]/android.widget.EditText"));
        password.sendKeys("Test@12345");
        WebElement loginbtn = driver.findElement(By.xpath("//android.widget.Button[@text=\"LOG IN\"]"));
        loginbtn.click();

        driver.context("NATIVE_APP");

    }
}














