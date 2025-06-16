package appium;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class SwitchContentFromApptoApp {

    public static void main(String[] args) {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:deviceName", "532bb9fa");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:appPackage", "com.whatsapp");
        caps.setCapability("appium:appActivity", "com.whatsapp.HomeActivity");
        caps.setCapability("appium:noReset", false);
        caps.setCapability("appium:unlockType", "pin");
        caps.setCapability("appium:unlockKey", "939288");

        AndroidDriver driver = null;


        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

//        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"WhatsApp, 1notification(s)\"]")).click();
//        driver.findElement(By.xpath("(//android.widget.LinearLayout[@resource-id=\"com.whatsapp:id/row_content\"])[3]")).click();
//        driver.findElement(By.xpath("driver.activateApp(\"in.amazon.mShop.android.shopping\");\n")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Step 2: Switch to Amazon app explicitly
//        driver.activateApp("in.amazon.mShop.android.shopping"); // Amazon app package

       ////android.widget.TextView[@resource-id=\"com.whatsapp:id/message_text\" and @text=\"odinbirds Pack of 4 Elegant Rabbit & Penguin Soft and Stuffed Dog, Elephant Soft Toys for Baby Boys/Girls (30CM) \n" +
        //                " https://amzn.in/d/iuh2caG\"]
    }
}






