package appium;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;



import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class HandleDropDown {

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

            driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"English\"]")).click();
            driver.findElement(By.xpath("//android.view.View[@content-desc=\"Dismiss menu\"]/android.view.View/android.view.View")).isDisplayed();
            driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Deutsch\"]")).click();

          //  driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Deutsch']")).click();

           /* WebElement language = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View"));
            language.click();


            WebElement element = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Dismiss menu\"]/android.view.View/android.view.View"));
            element.click();

            WebElement deutschOption = driver.findElement(By.xpath("//android.widget.Button[@content-desc='Deutsch']"));
            deutschOption.click();

            WebElement continueBtn = driver.findElement(By.xpath("//android.widget.Button[@text='Continue']"));
            continueBtn.click();

            System.out.println("Language selected and continued.");*/


        }
    }



