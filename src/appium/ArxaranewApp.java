package appium;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Scanner;

public class ArxaranewApp {

    public static void main(String[] args) throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:deviceName", "emulator-5554");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:app", "/Users/kamasanikaveri/Downloads/APK FILES/app-release-Arxaranew (1).apk");
        capabilities.setCapability("appium:autoGrantPermissions", false);  //  handle permissions manually

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        System.out.println("App launched successfully!");

        // 1. Click "Continue"
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[@content-desc='Continue']"))).click();
        System.out.println("Clicked Continue");

        // 2. Click "Create Account"
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[@content-desc='Create Account']"))).click();
        System.out.println("Clicked Create Account");

        // 3. Handle Location Permission
        try {
            WebElement allowLocationBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")));
            allowLocationBtn.click();
            System.out.println("Clicked on 'Allow only while using the app'");
        } catch (Exception e1) {
            try {
                // Fallback for older Android versions or different layouts
                WebElement allowWhileUsingBtn = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//android.widget.Button[@text='While using the app']")));
                allowWhileUsingBtn.click();
                System.out.println("Clicked on 'While using the app'");
            } catch (Exception e2) {
                System.out.println("Location permission popup not found or already granted.");
            }
        }

        // 4. Click Checkbox to agree terms
        try {
            WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(
                    MobileBy.className("android.widget.CheckBox")));
            checkbox.click();
            System.out.println("Checked Terms and Conditions");
        } catch (Exception e) {
            System.out.println("Checkbox not found or already selected.");
        }

        // 5. Click "Confirm"
        try {
            WebElement confirmBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    MobileBy.xpath("//android.widget.Button[@content-desc='Confirm']")));
            confirmBtn.click();
            System.out.println("Clicked Confirm");
        } catch (Exception e) {
            System.out.println("Confirm button not found.");
        }

        // 6. Click "Skip"
        try {
            WebElement skipBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    MobileBy.xpath("//android.widget.Button[@content-desc='Skip']")));
            skipBtn.click();
            System.out.println("Clicked Skip");
        } catch (Exception e) {
            System.out.println("Skip button not found.");
        }

        // 7. Enter phone number
        try {
            WebElement usePhoneBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    MobileBy.xpath("//android.widget.Button[@content-desc='Use phone number']")));
            usePhoneBtn.click();
            System.out.println("Clicked 'Use phone number'");

            WebElement phoneField = wait.until(ExpectedConditions.elementToBeClickable(
                    MobileBy.className("android.widget.EditText")));
            phoneField.sendKeys("9392884409");
            System.out.println("Entered phone number");

        } catch (Exception e) {
            System.out.println("Phone number field or button not found: " + e.getMessage());
        }

        driver.findElement(By.xpath("//android.widget.FrameLayout")).click();
        driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Sign Up\"]")).click();

        // Manually handle OTP
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter OTP received on mobile: ");
        String otp = scanner.nextLine();

        //Enter each digit of OTP if each digit is in separate field
        for (int i = 0; i < otp.length(); i++) {
            WebElement otpField = wait.until(ExpectedConditions.elementToBeClickable(
                    MobileBy.xpath("(//android.widget.EditText)[" + (i + 1) + "]")));
            otpField.sendKeys(Character.toString(otp.charAt(i)));
        }

        // Click Continue after OTP
        wait.until(ExpectedConditions.elementToBeClickable(
                MobileBy.xpath("//android.widget.Button[@content-desc='Continue']"))).click();
        System.out.println("OTP entered and Continue clicked");

        System.out.println("Signup flow completed successfully.");
    }
}

