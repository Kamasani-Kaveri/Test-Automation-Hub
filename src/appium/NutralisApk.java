package appium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.Instant;

public class NutralisApk {
    public static void main(String[] args) {


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:deviceName", "emulator-5554");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:app", "/Users/kamasanikaveri/Downloads/nutralis.apk");
        capabilities.setCapability("appium:autoGrantPermissions", true);

        AndroidDriver driver = null;

        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Tap on Register button
            driver.findElement(By.xpath("//android.widget.TextView[@text='Register']")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Fill in registration fields
            driver.findElement(By.xpath("//android.widget.EditText[@text='Enter first name']")).sendKeys("Kamasani");
            driver.findElement(By.xpath("//android.widget.EditText[@text='Enter last name']")).sendKeys("Kaveri");
            driver.findElement(By.xpath("//android.widget.EditText[@text='Enter email']")).sendKeys("kamasanikaveri@gmail.com");
            driver.findElement(By.xpath("//android.widget.EditText[@text='Enter mobile number']")).sendKeys("9392884409");
            System.out.println("Textbox filled");

            // Enter the password in the first EditText (Create Password)
            WebElement createPasswordField = driver.findElement(By.xpath("(//android.widget.EditText[@text='Enter password'])[1]"));
            createPasswordField.sendKeys("Kaveri@369");

            // Click on the eye icon to view the entered password
            WebElement viewPasswordIcon = driver.findElement(By.xpath("(//android.view.ViewGroup[@content-desc=''])[1]"));
            viewPasswordIcon.click();
            ((AndroidDriver) driver).findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Enter password\"))"
            ));




            // Enter the Confirm Password in the second EditText
            WebElement confirmPasswordField = driver.findElement(By.xpath(
                    "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]/android.view.ViewGroup[2]/android.widget.EditText"
            ));
            confirmPasswordField.sendKeys("Kaveri@369");
             // Enter language
            driver.findElement(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[7]")).click();
             System.out.println("Dropdown selected");

            // Tap on the checkbox
            WebElement termsCheckbox = driver.findElement(By.xpath("//android.widget.CheckBox[@content-desc='terms&Conditions']/android.view.ViewGroup"));
            termsCheckbox.click();

           System.out.println("checkbox submitted");



            // Tap on Register button
            driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Sign up\"]")).click();

            System.out.println("Registration form submitted successfully.");



            }
        }


