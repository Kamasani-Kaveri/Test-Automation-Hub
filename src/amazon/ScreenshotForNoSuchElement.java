package amazon;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotForNoSuchElement {

    public static void main(String[] args) {

        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();


        try {
            driver.get("https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_5szpgfto9i_e&adgrpid=155259813593&hvpone=&hvptwo=&hvadid=748926027055&hvpos=&hvnetw=g&hvrand=537732453816350302&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9062010&hvtargid=kwd-64107830&hydadcr=14452_2417699&gad_source=1");
            driver.manage().window().maximize();
            Thread.sleep(3000); 


            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }



            WebElement element = driver.findElement(By.xpath("//*[@class=\"a-list-ite\"]"));


        } catch (NoSuchElementException e) {
            System.out.println("Element not found and Taking screenshot...");

            // Take screenshot
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);


            File dest = new File("exceptionscreenshot_" +  ".png");

            try {
                FileHandler.copy(src, dest);
                System.out.println("Screenshot saved: " + dest.getAbsolutePath());
            } catch (IOException ioException) {
                System.out.println("Failed to save screenshot: " + ioException.getMessage());
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
