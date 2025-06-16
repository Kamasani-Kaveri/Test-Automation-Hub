package flipkart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Watch {
    public static void main (String args[]){

        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']")).click();

        WebElement SearchBox=driver.findElement(By.name("q"));
        SearchBox.sendKeys("Watches");
        SearchBox.submit();

        driver.findElement(By.xpath("//*[@class=\"ewzVkT _3DvUAf\"  and @title=\"Titan\"]")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (String handle :
                driver.getWindowHandles()){
            driver.switchTo().window(handle);
        }




        driver.findElement(By.xpath("//*[@class=\"WKTcLC BwBZTg\"  and  @title=\"Slim Ceramic Fusion Analog Watch  - For Men 90142KD03\" ]")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (String handle :
                driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }




            driver.findElement(By.xpath("//*[@class=\"QqFHMw vslbG+ In9uk2\"]")).click();

        for (String handle :
                driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
            driver.findElement(By.xpath("//*[@class=\"QqFHMw zA2EfJ _7Pd1Fp\"]")).click();

        for (String handle :
                driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        WebElement element = driver.findElement(By.xpath("//*[@ type=\"text\" and  @class=\"r4vIwl Jr-g+f\" ]"));
        element.click();
        element.sendKeys("9392884409");

    }
}
 