package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegionPage {
    @FindBy(xpath = "//button[@title=\"Home Menu\"]")
    WebElement rootMenu;
    @FindBy(xpath = "//div/a[@data-menu-xmlid=\"sale.sale_menu_root\"]")
    WebElement salesPage;
    @FindBy(xpath = "//button[@data-menu-xmlid=\"sale.menu_sale_config\"]")
    WebElement configurationPage;

    @FindBy(xpath = "//div/a[@data-menu-xmlid=\"sales_config.sales_region_config_menu\"]")
    WebElement regionChildMenu;

    public RegionPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void createRegion() throws InterruptedException {
        rootMenu.click();
        Thread.sleep(1000);
        salesPage.click();
        Thread.sleep(1000);
        configurationPage.click();
        Thread.sleep(1000);
        regionChildMenu.click();
        Thread.sleep(1000);
    }
}
