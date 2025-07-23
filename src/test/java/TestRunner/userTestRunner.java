package TestRunner;

import Config.Setup;
import Pages.LoginPage;
import SettingPages.UserAuthAndRoleAllow;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class userTestRunner extends Setup {
    @Test(priority = 1,description = "Auth user login successfully",groups = "smoke")
    public void doLoginWithValidCred() throws InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        Thread.sleep(1000);
        loginPage.doLoginCCLApps("Admin","1234");
        Thread.sleep(2000);
        String ExpectedText=driver.findElement(By.xpath("//a[text()= 'Discuss']")).getText();
        String ActualText="Discuss";
        Assert.assertEquals(ActualText,ExpectedText);
        Thread.sleep(2000);

    }
    @Test(priority = 2,description = "User Authentication With Authorized role",groups = "smoke")
    public void doChangeAuthorizedRole() throws InterruptedException {
        UserAuthAndRoleAllow userAuthAndRoleAllow=new UserAuthAndRoleAllow(driver);
        userAuthAndRoleAllow.authUserSetupRole(driver);
        Thread.sleep(2000);


    }
}
