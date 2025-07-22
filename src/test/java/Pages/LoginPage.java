package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "login")
    WebElement txtInputLogin;
    @FindBy(id = "password")
    WebElement txtInputPassword;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;


    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void doLoginCCLApps(String username, String password) throws InterruptedException {
        txtInputLogin.sendKeys(username);
        Thread.sleep(500);
        txtInputPassword.sendKeys(password);
        Thread.sleep(500);
        submitButton.click();
        Thread.sleep(500);

    }
}
