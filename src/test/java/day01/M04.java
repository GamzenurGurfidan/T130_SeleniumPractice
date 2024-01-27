package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class M04 {
    public static void main(String[] args) {
     /*
        1- www.google.com adresine gidilir
        2- Sayfanın title ve Url değerleri yazdırılır
        3- Yeni bir sekme açılarak www.wisequarter.com adresine gidilir ve
        4- Gidilen sayfanın title ve url değerleri yazdırılır ve
           title'in wisequarter içerip içermediği kontrol edilir ve bilgi verilir
        5- Ilk sekmeye geçilip, burada www.testotomasyonu.com adresine gidilir
        6- Gidilen sayfanın title ve url değerleri yazdırılır ve
           title'in testotomasyonu içerip içermediği kontrol edilir ve bilgi verilir
        7- Açılan pencere kapatılır.
     */

        System.setProperty("Webdriver.chrome.driver","src/kurulum/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // sayfa 10 sn içinde yüklenmezse testi durdurur
        // 10 saniye dolmadan yüklenirse 10 saniyeyi beklemez

        driver.get("https://www.google.com");

        System.out.println("ilk sayfa title: " + driver.getTitle());
        System.out.println("ilk sayfa URL: " + driver.getCurrentUrl());
        String handle1 = driver.getWindowHandle();
        System.out.println("ilk sayfa window handle: " + handle1);


        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://wisequarter.com");

        String actualTitle = driver.getTitle();
        String expectedTitle = "wisequarter";

        System.out.println("ikinci sayfa title: " + actualTitle);
        System.out.println("ikinci sayfa URL: " + driver.getCurrentUrl());
        System.out.println("ikinci sayfa window handle: " + driver.getWindowHandle());

        if (actualTitle.contains(expectedTitle)){
            System.out.println("Title " + expectedTitle + " içeriyor");
        }else System.out.println("Title " + expectedTitle + " içermiyor");

        driver.switchTo().window(handle1);
        driver.navigate().to("https://www.testotomasyonu.com");

        String actualSiteTitle = driver.getTitle();
        String expectedSiteTitle = "testotomasyonu";

        System.out.println("Son site title: " + actualSiteTitle );
        System.out.println("Son site URL: " + driver.getCurrentUrl() );
        System.out.println("Son site window handle: " + driver.getWindowHandle() );

        if (actualSiteTitle.contains(expectedSiteTitle)){
            System.out.println("Son site title " + expectedSiteTitle + " içeriyor");
        } else System.out.println("Son site title " + expectedSiteTitle + " içeiyor");

        driver.quit(); 

    }
}
