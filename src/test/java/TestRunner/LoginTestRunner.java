package TestRunner;
import Config.Setup;
import Pages.LoginPage;
import net.bytebuddy.build.Plugin;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.thread.ThreadExecutionException;

import java.io.IOException;


public class LoginTestRunner extends Setup {
    @Test(priority = 1,description = "Auth user login successfully")
    public void doLoginWithValidCred() throws InterruptedException, IOException {
        test =extent.createTest("Login Suite");
        ExtentTest node=test.createNode("Login with valid cred");
        LoginPage loginPage=new LoginPage(driver);
        loginPage.doLoginCCLApps("Admin","1234",node);
        Thread.sleep(2000);
        String ExpectedText=driver.findElement(By.xpath("//a[text()= 'Discuss']")).getText();
        String ActualText="Discuss";
        Assert.assertEquals(ActualText,ExpectedText);
        Thread.sleep(2000);

    }
}
