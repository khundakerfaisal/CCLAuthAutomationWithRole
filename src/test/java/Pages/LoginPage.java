package Pages;

import Uttils.GetScreenShot;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage {
    WebDriver driver;

    @FindBy(id = "login")
    WebElement txtInputLogin;
    @FindBy(id = "password")
    WebElement txtInputPassword;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver=driver;


    }

    public void doLoginCCLApps(String username, String password, ExtentTest node) throws InterruptedException, IOException {

        node.info("Username column found as expected");
        txtInputLogin.sendKeys(username);
        Thread.sleep(500);
        node.info("Password column found as expected");
        txtInputPassword.sendKeys(password);
        Thread.sleep(500);
        node.info("Button found as expected");
        submitButton.click();
        node.pass("User Login successfully");
        GetScreenShot getScreenShot=new GetScreenShot();
        getScreenShot.getScreenCapture(driver,node,"Login Button submit successfully!!!");
        Thread.sleep(500);

    }
}
