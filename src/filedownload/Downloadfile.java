package filedownload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Downloadfile {
    public static void main(String[] args) {

        String downloadFilepath = System.getProperty("user.dir");


        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadFilepath);
        prefs.put("download.prompt_for_download", false);
        prefs.put("download.directory_upgrade", true);
        prefs.put("safebrowsing.enabled", true);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("http://omayo.blogspot.com/p/page7.html");
        driver.findElement(By.linkText("ZIP file")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        File file = new File(downloadFilepath + File.separator + "DownloadDemo-master.zip");

        if (file.exists()) {
            System.out.println("File got successfully downloaded");
        } else {
            System.out.println(" File is not downloaded");
        }
    }
}