package flipkart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Order {

    public static void main(String[] args) {
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']")).click();

        WebElement SearchBox = driver.findElement(By.name("q"));
        SearchBox.sendKeys("Watches");
        SearchBox.submit();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement element = driver.findElement(By.xpath("//*[@title='Wrist Watches']"));
        element.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (String handle :
                driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement element1 = driver.findElement(By.xpath("//*[@class=\"WKTcLC BwBZTg\"  and @title=\"Raga VIVA 2 Analog Watch  - For Women NT2606WM02\" ]"));
        element1.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (String handle :
                driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        WebElement element2 = driver.findElement(By.xpath("//*[@class=\"QqFHMw vslbG+ In9uk2\"]"));
        element2.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (String handle :
                driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }


        WebElement element3 = driver.findElement(By.xpath("//button[@class=\"QqFHMw zA2EfJ _7Pd1Fp\"]"));
        element3.click();

        for (String handle :
                driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        driver.findElement(By.xpath("//*[@class=\"r4vIwl Jr-g+f\"]")).sendKeys("9392884409");

        driver.findElement(By.xpath("//*[@class=\"QqFHMw YhpBe+ _7Pd1Fp\"] ")).click();

driver.quit();
    }
}
