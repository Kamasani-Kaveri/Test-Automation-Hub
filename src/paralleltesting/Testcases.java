package paralleltesting;

import net.bytebuddy.build.Plugin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testcases {
    WebDriver driver;

    /*@BeforeTest
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }*/

    @Test
    public void openGoogle() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        System.out.println("Title (Google): " + driver.getTitle());
    }

    @Test
    public void openFlipkart() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com");
        System.out.println("Flipkart Title: " + driver.getTitle());
    }

    @Test
    public void openFacebook() {
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com");
        System.out.println("Facebook Title: " + driver.getTitle());
    }

    @Test
    public void openTwitter() {
        driver = new FirefoxDriver();
        driver.get("https://www.twitter.com");
        System.out.println("Twitter Title: " + driver.getTitle());
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
        }


    }


