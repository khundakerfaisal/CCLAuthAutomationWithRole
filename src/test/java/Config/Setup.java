package Config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class Setup {
    public WebDriver driver;
    @BeforeTest
    public void startBrowser(){
        driver=new ChromeDriver();
        driver.get("http://192.168.3.226:9090/web/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));

    }
//    @AfterTest
//    public void closeBrowser(){
//        driver.quit();
//
//    }
}
