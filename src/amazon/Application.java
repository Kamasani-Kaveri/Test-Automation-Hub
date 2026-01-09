package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Application {
    public static void main(String args[]){

        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_5szpgfto9i_e&adgrpid=155259813593&hvpone=&hvptwo=&hvadid=674893540034&hvpos=&hvnetw=g&hvrand=6057244998030075051&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9062010&hvtargid=kwd-64107830&hydadcr=14452_2316413&gad_source=1");
        driver.findElement(By.xpath(" //*[@class=\"nav-cart-icon nav-sprite\"]")).click();
        driver.findElement(By.xpath("//*[contains (@class, \"a-size-base-plus\" ) and contains (text(),  \"Sign up now\")]")).click();
        WebElement element = driver.findElement(By.xpath("//*[@name=\"email\"]"));
        element.click();
        element.sendKeys("9392884409");
        element.submit();
        driver.findElement(By.xpath("//*[contains(@class, \"a-link-normal\" )and contains(text(),  \"Forgot password?\")]")).click();
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
        WebElement element1=driver.findElement(By.xpath("//*[@name=\"password\"]"));
        element1.click();
        element1.sendKeys("Kaveri@999");
        element1.submit();





    }
}
