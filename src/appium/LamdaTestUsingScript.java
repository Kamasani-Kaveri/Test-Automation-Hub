package appium;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class LamdaTestUsingScript {

    public static void main(String[] args) throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Mandatory W3C capability
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("browserName", "google chrome");

        // Wrap everything else inside lt:options
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "kamasani");
        ltOptions.put("accessKey", "LT_QgrW1o8ca4CHqnSwkikI4UPdVlwWpCIAQa1ahCBOcPHZeCk");
        ltOptions.put("app", "lt:/Users/kamasanikaveri/Downloads/airace.apk");  // Replace with your actual App URL from LambdaTest
        ltOptions.put("deviceName", "Galaxy S20");
        ltOptions.put("platformVersion", "11");
        ltOptions.put("isRealMobile", true);
        ltOptions.put("build", "LambdaTest Android Build");
        ltOptions.put("name", "Sample Appium Android Test");
        ltOptions.put("autoGrantPermissions", true);
        ltOptions.put("automationName", "UiAutomator2");

        capabilities.setCapability("lt:options", ltOptions);

        AndroidDriver driver = new AndroidDriver(
                new URL("https://mobile-hub.lambdatest.com/wd/hub"),
                capabilities
        );

        // Your test actions here...
        driver.quit();
    }
}


