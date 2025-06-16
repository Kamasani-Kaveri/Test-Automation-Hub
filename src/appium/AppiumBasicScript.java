package appium;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.MalformedURLException;
import java.net.URL;


public class AppiumBasicScript {

    public static void main(String[] args) {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:deviceName", "Android Emulator");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:app", "/Users/kamasanikaveri/Downloads/Twocents-15.apk");

        AndroidDriver driver = null;
        try {
            //  Appium 2.x endpoint — NO /wd/hub
            driver = new AndroidDriver(
                    new URL("http://127.0.0.1:4723"), caps
            );
            System.out.println("App launched successfully.");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}


