package TestRunner;

import Config.LoginDataset;
import Config.Setup;
import Pages.LoginPage;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginCsvData extends Setup {
    @Test(dataProvider = "LoginCSVDATA",dataProviderClass = LoginDataset.class)
    public void doLogin(String username, String password) throws IOException, InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.doLoginCCLApps(username, password, test);

    }
//    @Test(dataProvider = "loginCsvData",dataProviderClass = LoginDataSetNew.class)
//    public void doLogin(String username, String password) throws IOException, InterruptedException {
//        LoginPage loginPage=new LoginPage(driver);
//        loginPage.doLoginCCLApps(username, password, test);
//
//    }
}
