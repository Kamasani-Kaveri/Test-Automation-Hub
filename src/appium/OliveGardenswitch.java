package appium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class OliveGardenswitch {


    public static void main(String[] args) throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:deviceName", "emulator-5554");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:app", "/Users/kamasanikaveri/Downloads/OG_MENU (1).apk");
        capabilities.setCapability("appium:autoGrantPermissions", true);

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        System.out.println("App launched successfully!");
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));


        WebElement getStarted = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='GET STARTED']"))
        );
        getStarted.click();

        try {
            Thread.sleep(2000); // wait 2 seconds
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // After clicking GET STARTED
        System.out.println("Clicked GET STARTED, dumping all visible TextViews:");
        List<WebElement> texts = driver.findElements(By.className("android.widget.TextView"));
        for (WebElement t : texts) {
            System.out.println("TextView text: '" + t.getText() + "'");
        }

        List<WebElement> moreButtons = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text='More']"))
        );
        System.out.println("More buttons found: " + moreButtons.size());

        // Coordinate tap on the first visible and enabled More button
        for (WebElement btn : moreButtons) {
            if (btn.isDisplayed() && btn.isEnabled()) {
                // Debug prints for location and size
                System.out.println("More btn location: " + btn.getLocation());
                System.out.println("More btn size: " + btn.getSize());

                int centerX = btn.getLocation().getX() + btn.getSize().getWidth() / 2;
                int centerY = btn.getLocation().getY() + btn.getSize().getHeight() / 2;

                PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
                Sequence tap = new Sequence(finger, 1);
                tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, centerY));
                tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
                tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

                driver.perform(Arrays.asList(tap));
                System.out.println("'More' button tapped at coordinates: (" + centerX + ", " + centerY + ")");

                try {
                    Thread.sleep(2000); // wait 2 seconds for UI to respond
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                break;
            }
        }
    }
}















