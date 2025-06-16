import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;
import java.util.Set;

public class ApptoBrowserSwitching {

    public static void main(String[] args) throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:deviceName", "532bb9fa");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:noreset",false);
        capabilities.setCapability("appium:chromedriver_autodownload", true);
        capabilities.setCapability("appium:autoGrantPermissions", true);
        capabilities.setCapability("appium:app","/Users/kamasanikaveri/Downloads/olivergarden.apk");


        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        System.out.println("App launched successfully!");
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));



        WebElement getStarted = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='GET STARTED']"))
        );
        getStarted.click();
        Thread.sleep(5000);
        try {
            Thread.sleep(2000); // wait 2 seconds
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Thread.sleep(2000);
        // 🔘 Step 1: Locate and click the Login button (update this locator as needed)
        WebElement loginBtn = driver.findElement(By.xpath("//android.widget.TextView[@text='Login']"));
        loginBtn.click();

        System.out.println("Login button clicked!");
        Thread.sleep(5000);
        Set<String> contextNames = driver.getContextHandles();
        for (String context : contextNames) {
            System.out.println("Available context: " + context);
        }


        driver.context("WEBVIEW_com.android.chrome"); // Replace with actual context name
        System.out.println("Switched to WEBVIEW");


        Thread.sleep(5000);

        /*WebElement email=driver.findElement(By.xpath("(//android.view.View[@text=\"Log In\"])[2]/android.view.View[1]/android.widget.EditText"));
        email.sendKeys("prashantg+1@geekyants.com");

        WebElement password = driver.findElement(By.xpath("(//android.view.View[@text=\"Log In\"])[2]/android.view.View[2]/android.widget.EditText"));
        password.sendKeys("Test@12345");
        WebElement loginbtn = driver.findElement(By.xpath("//android.widget.Button[@text=\"LOG IN\"]"));
        loginbtn.click();

        driver.context("NATIVE_APP");*/




    }
}

//mCurrentFocus=Window{e3956e8 u0 com.android.chrome/com.google.android.apps.chrome.Main}
//mFocusedApp=ActivityRecord{95769855 u0 com.android.chrome/com.google.android.apps.chrome.Main t18}
