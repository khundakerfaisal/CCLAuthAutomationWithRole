package TestRunner;

import Config.Setup;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.thread.ThreadExecutionException;

public class LoginTestRunner extends Setup {
    @Test
    public void doLoginWithValidCreds() throws InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.doLoginCCLApps(driver);
        String ExpectedText=driver.findElement(By.xpath("//a[text()= 'Discuss']")).getText();
        String ActualText="Discuss";
        Assert.assertEquals(ActualText,ExpectedText);
        Thread.sleep(2000);

    }
}
