package handlingframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Iframes {
    WebDriver driver;
    @BeforeTest
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void framesapplication() {
        driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

       // driver.switchTo().frame(1);
        WebElement element = driver.findElement(By.id("iframeResult"));
        driver.switchTo().frame(element);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.xpath("//button[text()='Try it']")).click();
        driver.switchTo().alert().accept();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.switchTo().defaultContent();

        driver.findElement(By.xpath("//*[@id=\"getwebsitebtn\"]")).click();

        //Working with new tab
        ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.xpath("//*[@id=\"subtopnav\"]/a[2]")).click();

    }
    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}

