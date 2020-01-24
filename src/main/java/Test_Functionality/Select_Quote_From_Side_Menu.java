package Test_Functionality;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Select_Quote_From_Side_Menu {
    private WebDriver driver;
    public Select_Quote_From_Side_Menu(WebDriver driver)
    {
        this.driver = driver;
    }
    @FindBy (xpath = "//button[@ng-show='userAuthenticated'][contains(.,'☰')]")
    WebElement Side_Menu;

    @FindBy (xpath = "//font[contains(@ng-click,'openNew();')]")
    WebElement Quote;

    public void SelectQuote_From_SideMenu() throws InterruptedException {
        WebDriverWait Login = new WebDriverWait(driver,20);
        Login.until(ExpectedConditions.visibilityOf(Side_Menu));
        /*Username.sendKeys(UN);
        Password.sendKeys(PW);*/
        TimeUnit.SECONDS.sleep(5);
        Side_Menu.click();
        TimeUnit.SECONDS.sleep(5);
        Quote.click();
    }
}