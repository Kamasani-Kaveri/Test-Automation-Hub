package appium;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

public class ArxaranewOperations {
    public static void main(String[] args) throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:deviceName", "emulator-5554");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:app", "/Users/kamasanikaveri/Downloads/APK FILES/app-release-Arxaranew (1).apk");
        capabilities.setCapability("appium:autoGrantPermissions", true);

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        System.out.println("App launched successfully!");

        // 1. Click "Continue"
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[@content-desc='Continue']"))).click();
        System.out.println("Clicked Continue");

        // 2. Click "Continue as Guest"
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[@content-desc='Continue as Guest']"))).click();
        System.out.println("Clicked Continue as Guest");

        // Give the popup some time to appear
       /* try {
            Thread.sleep(3000);  // 3 seconds wait
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Print page source to console
        System.out.println("Page source during permission popup:");
        System.out.println(driver.getPageSource());*/


        // 3. Handle Android permission popup: Allow or Don't Allow
        try {
            // Wait a few seconds for permission popup
            WebElement allowButton = wait.until(ExpectedConditions.elementToBeClickable(
                    MobileBy.id("com.android.packageinstaller:id/permission_allow_button")));
            allowButton.click();
            System.out.println("Clicked Allow on permission popup");
        } catch (Exception e) {
            System.out.println("Permission popup not displayed or already handled.");
        }

        // Perform swipe gestures
        swipeUp(driver);      // Swipe up
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        swipeDown(driver);    // Swipe down
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        swipeLeft(driver);    // Swipe left
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        swipeRight(driver);   // Swipe right



    }

    // Swipe Up
    public static void swipeUp(AndroidDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);
        performSwipe(driver, startX, startY, startX, endY);
        System.out.println("Swiped Up");
    }

    // Swipe Down
    public static void swipeDown(AndroidDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.2);
        int endY = (int) (size.height * 0.8);
        performSwipe(driver, startX, startY, startX, endY);
        System.out.println("Swiped Down");
    }

    // Swipe Left
    public static void swipeLeft(AndroidDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int startY = size.height / 2;
        int startX = (int) (size.width * 0.9);
        int endX = (int) (size.width * 0.1);
        performSwipe(driver, startX, startY, endX, startY);
        System.out.println("Swiped Left");
    }

    // Swipe Right
    public static void swipeRight(AndroidDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int startY = size.height / 2;
        int startX = (int) (size.width * 0.1);
        int endX = (int) (size.width * 0.9);
        performSwipe(driver, startX, startY, endX, startY);
        System.out.println("Swiped Right");
    }

    // Swipe Action
    private static void performSwipe(AndroidDriver driver, int startX, int startY, int endX, int endY) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), endX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));








    }
}
