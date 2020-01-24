package Test_Functionality;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_To_LifeSales {
    private WebDriver driver;
    public Login_To_LifeSales(WebDriver driver)
    {
        this.driver = driver;
    }
    @FindBy (xpath = "//input[contains(@id,'loginUserName')]")
    WebElement Username;

    @FindBy (xpath = "//input[contains(@id,'loginPassword')]")
    WebElement Password;

    @FindBy (xpath = "//button[contains(@id,'loginButton')]")
    WebElement Login_Btn;

    public void Login_to_LifeSales(String UN,String PW)
    {
        WebDriverWait Login = new WebDriverWait(driver,20);
        Login.until(ExpectedConditions.visibilityOf(Username));
        Username.sendKeys(UN);
        Password.sendKeys(PW);
        Login_Btn.click();
    }
}