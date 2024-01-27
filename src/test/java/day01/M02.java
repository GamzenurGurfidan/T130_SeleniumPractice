package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class M02 {
    public static void main(String[] args) throws InterruptedException {
        /*
         /....Exercise-1:...
          Create a new class with main method
          Set Path
          Create a chrome driver
          Maximize window
          Open google home page https://www.google.com
          On the same class, navigate to amazon home page https://www.amazon.com and navigate back to google
          Wait about 4 sn
          Navigate forward to amazon
          Refresh page
          Close/quit the browser
          And Last step print "All is well" on console
        */

        System.setProperty("Webdriver.chrome.driver","src/kurulum/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        driver.navigate().to("https://www.amazon.com");
        driver.navigate().back();
        Thread.sleep(4000);
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.quit();
        System.out.println("All is well");

    }
}
