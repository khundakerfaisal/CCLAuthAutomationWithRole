package Config;

import Uttils.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class Setup {

    public static ExtentReports extent;
    public static ExtentTest test;

    public WebDriver driver;
    @BeforeTest(groups = "smoke")
    public void startBrowser(){
        extent= ExtentManager.getInstance();
//        test.pass("Browser Configure Successfully");
        test=extent.createTest("Browser Configuration");

        driver=new ChromeDriver();
        driver.get("http://192.168.3.226:9090/web/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));

    }
    @AfterTest
    public void closeBrowser(){
        driver.quit();
        test.pass("Close the browser configuration");
        extent.flush();



    }
}
