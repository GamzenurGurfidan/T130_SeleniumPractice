package day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class M01 {
    /*
          1-Driver oluşturalim
          2-Java class'imiza chnomedriver.exe i tanitalim
          3-Driver'in tum ekranı kaplamasini saglayalim
          4-"https://www.otto.de” adresine gidelim
          5-Driverla sayfanın yuklenmesini 10.000 milisaniye boyunca beklesini
    söyleyelim. Egen oncesinde sayfa Yüklenirse, beklemeyi bıraksın.
          6-Bu web adresinin sayfa basligini (title) ve adres (url)ini alalim
          7-Title ve url inin "OTTO” kelimesinin içerip icermedigini kontrol edelim
          8-Ardindan "https://wisequarter.com/” adresine gidip
          9-Bu adresin basligini alalim ve "Quarter” kelimesini icenip icermedigini kontrol edelim
          10-Bir onceki web sayfamiza geri donelim
          11-Sayfayı yenileyelim
          12-Daha sonra web sayfamiza tekrar donelim ve oldugumuuz sayfayi kapatalim
          13- En son adim olarak butun sayfalarimizi kapatmis olalim
     */

    public static void main(String[] args) {
        System.setProperty("WebDriver.chrome.driver","src/kurulum/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.otto.de");
        String birinciWHD = driver.getWindowHandle();

        String actualSayfaTitle = driver.getTitle();
        String actualSayfaURL = driver.getCurrentUrl();

        String expectedWord = "OTTO";

        if (actualSayfaTitle.contains(expectedWord)){
            System.out.println("Title testi PASSED");
        } else System.out.println("Title testi Failed");

        if (actualSayfaURL.contains(expectedWord)){
            System.out.println("URL testi PASSED");
        } else System.out.println("URL testi Failed");

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://wisequarter.com/");

        String ikinciWHD = driver.getWindowHandle();

        String actualIkinciTitle = driver.getTitle();
        expectedWord = "Quarter";

        if (actualIkinciTitle.contains(expectedWord)){
            System.out.println("ikinci title testi PASSED");
        } else System.out.println("ikinci title testi Failed");

        driver.switchTo().window(birinciWHD);
        driver.navigate().refresh();

        driver.switchTo().window(ikinciWHD).quit();

        driver.quit();


    }
}
