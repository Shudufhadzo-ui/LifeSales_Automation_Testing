package Test_Helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scroll_To_The_Bottom_Of_The_Page {
    private WebDriver driver;
    public Scroll_To_The_Bottom_Of_The_Page(WebDriver driver)
    {
        this.driver=driver;
    }

    @FindBy(xpath = "/html//input[@id='fixedPremium']")
    private WebElement Bottom_Of_The_Page;

    public void Scroll_to_The_Bottom()
    {
        WebDriverWait scroll=new WebDriverWait(driver,60);
        scroll.until(ExpectedConditions.visibilityOf(Bottom_Of_The_Page));
        Actions action=new Actions(driver);
        action.moveToElement(Bottom_Of_The_Page);
        action.perform();
    }
    public void Scroll_Down()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
    }
    public void Scroll_Up()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(1000,0)");
    }
}
