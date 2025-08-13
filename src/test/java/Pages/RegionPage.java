package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class RegionPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    @FindBy(xpath = "//button[@title=\"Home Menu\"]")
    WebElement rootMenu;
    @FindBy(xpath = "//div/a[@data-menu-xmlid=\"sale.sale_menu_root\"]")
    WebElement salesPage;
    @FindBy(xpath = "//button[@data-menu-xmlid=\"sale.menu_sale_config\"]")
    WebElement configurationPage;

    @FindBy(xpath = "//div/a[@data-menu-xmlid=\"sales_config.sales_region_config_menu\"]")
    WebElement regionChildMenu;

    // Form controls (adjust XPaths if your app differs)
    @FindBy(className = "btn-outline-primary")
    List<WebElement> newButton;

    @FindBy(xpath = "//button[@data-tooltip=\"Save manually\"]")
    WebElement saveButton;

    @FindBy(id = "name_0")
    WebElement regionNameInput;

    @FindBy(xpath = "region_code_0")
    WebElement regionCodeInput;

    // Many2one-style dropdown input for Employee
    @FindBy(xpath = "employee_ids_0")
    WebElement employeeDropdownInput;

    public RegionPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    }

    public void createRegion(int startInclusive, int endInclusive) throws InterruptedException {
        Thread.sleep(1000);
        rootMenu.click();
        Thread.sleep(1000);
        salesPage.click();
        Thread.sleep(1000);
        configurationPage.click();
        Thread.sleep(1000);
        regionChildMenu.click();
        Thread.sleep(1000);
        for (int i = startInclusive; i <= endInclusive; i++) {
            newButton.get(1).click();
            // Open create form
//            wait.until(ExpectedConditions.elementToBeClickable(newButton.get(1))).click();

            // Wait for form inputs
            wait.until(ExpectedConditions.visibilityOf(regionNameInput));

            String regionName = "Region " + i;
            String regionCode = String.format("rg%02d", i);

            regionNameInput.clear();
            regionNameInput.sendKeys(regionName);

            regionCodeInput.clear();
            regionCodeInput.sendKeys(regionCode);

            // Select employee from dropdown suggestions
            String employeeLabel = "Amam Hasan(CCL60296)";
            employeeDropdownInput.clear();
            employeeDropdownInput.click();
            employeeDropdownInput.sendKeys(Keys.ENTER);

            employeeDropdownInput.sendKeys(employeeLabel);

//            String optionXpath = "(//ul[contains(@class,'ui-autocomplete')]//a | //div[contains(@class,'o_m2o_dropdown')]//a | //div[contains(@class,'o_dropdown')]//a)"
//                + "[normalize-space()='" + employeeLabel + "' or contains(normalize-space(),'Amam Hasan')]";
//            By dropdownOption = By.xpath(optionXpath);
//            wait.until(ExpectedConditions.elementToBeClickable(dropdownOption)).click();

            // Save
            wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();

            // Wait for save to complete (Save button may turn into Edit)
            wait.until(ExpectedConditions.or(
                ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@data-tooltip=\"Save manually\"]"))
//                ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Edit']"))
            ));
        }
    }

}
