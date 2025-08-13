package TestRunner;

import Config.Setup;
import Pages.LoginPage;
import Pages.RegionPage;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class regionTestRunner extends Setup {
    @Test(priority = 1,description = "Auth user login successfully")
    public void doLoginWithValidCred() throws InterruptedException, IOException {
        ExtentTest node=test.createNode("Login with valid cred");
        LoginPage loginPage=new LoginPage(driver);
        Thread.sleep(1000);
        loginPage.doLoginCCLApps("Admin","1234",node);
        Thread.sleep(2000);
        String ExpectedText=driver.findElement(By.xpath("//a[text()= 'Discuss']")).getText();
        String ActualText="Discuss";
        Assert.assertEquals(ActualText,ExpectedText);
        Thread.sleep(2000);

    }
    @Test(priority = 2,description = "Region create successfully")
    public void cclRegionCreate() throws InterruptedException {
        RegionPage regionPage=new RegionPage(driver);
        regionPage.createRegion(4,6);
    }
}
