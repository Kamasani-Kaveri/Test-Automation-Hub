package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class ScreenshotConsole {

    public static void main(String[] args) {

        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_5szpgfto9i_e&adgrpid=155259813593&hvpone=&hvptwo=&hvadid=748926027055&hvpos=&hvnetw=g&hvrand=537732453816350302&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9062010&hvtargid=kwd-64107830&hydadcr=14452_2417699&gad_source=1");
        driver.manage().window().maximize();
        try {
            Thread.sleep(3000); // Let the page load
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Scroll down vertically using PAGE_DOWN
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


        PrintStream fileOut = null;
        try {
            fileOut = new PrintStream(new FileOutputStream("console_log.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.setOut(fileOut);
        System.setErr(fileOut);

        // Simulate Selenium activity
        System.out.println("This will go the file");
        System.err.println("error: no-such-element-exception.");


    }
}
