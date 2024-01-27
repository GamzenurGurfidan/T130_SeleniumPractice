package day02;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class M02 {
    /*
        1 ) http://babayigit.net/relativelocators/relative.html adresine gidin
        2 ) Nurse 3 farkli relative locator ile locate edin
        3 ) Relative locator'larin dogru calistigini test edin
    */

    public static void main(String[] args) {
        System.setProperty("WebDriver.chrome.driver","src/kurulum/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://babayigit.net/relativelocators/relative.html");

        WebElement fireman = driver.findElement(By.id("frmn_thumb"));
        WebElement polisten = driver.findElement(By.id("pol_thumb"));
        WebElement doktordan = driver.findElement(By.id("dr_thumb"));

        WebElement nurse1 = driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(fireman));
        WebElement nurse2 = driver.findElement(RelativeLocator.with(By.tagName("img")).below(doktordan));
        WebElement nurse3 = driver.findElement(RelativeLocator.with(By.tagName("img")).toLeftOf(polisten));

        if (nurse1.getAttribute("id").equals("nurs_thumb")){
            System.out.println("ilk locate ile basarıyla bulundu");

        } else System.out.println("ilk locate ile basarıyla bulunmadı");

        if (nurse1.getAttribute("id").equals("nurs_thumb")){
            System.out.println("ikinci locate ile basarıyla bulundu");

        } else System.out.println("ikinci locate ile basarıyla bulunmadı");

        if (nurse1.getAttribute("id").equals("nurs_thumb")){
            System.out.println("ucuncu locate ile basarıyla bulundu");

        } else System.out.println("ucuncu locate ile basarıyla bulunmadı");

        driver.quit();
    }
}
