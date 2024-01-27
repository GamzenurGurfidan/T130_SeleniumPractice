package day01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class M03 {
    public static void main(String[] args) throws InterruptedException {

        /*
            1- http://babayigit.net/testdocs/ adresine gidilir
            2- INFO FORM butonuna tıklanır
            3- Form verileri girilir
            4- Save butonuna tıklanır
            5- Sonuç yazdırılır
         */

        System.setProperty("Webdriver.chrome.driver","src/kurulum/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://babayigit.net/testdocs/");

        WebElement infoFrombutonu =
                driver.findElement(By.xpath("//img[@src='img/info.png']"));

        infoFrombutonu.click();

        WebElement firstName =
                driver.findElement(By.id("firstName"));

        firstName.sendKeys("Gamze");

        WebElement lastName =
                driver.findElement(By.id("lastName"));

        lastName.sendKeys("Guclu");

        WebElement email =
                driver.findElement(By.id("email"));

        email.sendKeys("email@mailcom");

        WebElement phone =
                driver.findElement(By.id("phone"));

        phone.sendKeys("1234567");

        WebElement age =
                driver.findElement(By.id("age"));

        age.sendKeys("26");

        WebElement occupation =
                driver.findElement(By.id("occupation"));

        occupation.sendKeys("asdfg");

        WebElement gender =
                driver.findElement(By.id("female"));

        gender.click();

        WebElement city =
                driver.findElement(By.id("city"));

        city.sendKeys("Isparta");

        WebElement country =
                driver.findElement(By.id("country"));

        country.sendKeys("Turkey");

        WebElement button = driver.findElement(By.xpath("//button"));

        button.click();

        System.out.println("Reasult Message: \n" + driver.findElement(By.id("resultMessage")).getText());

        Thread.sleep(5000);
        driver.quit();
    }
}
