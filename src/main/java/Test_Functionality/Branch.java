package Test_Functionality;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Branch {
    private WebDriver driver;
    public Branch(WebDriver driver)
    {
        this.driver = driver;
    }

    @FindBy(xpath = "//select[contains(@id,'BranchOptions')]")
    WebElement Select_Branch;

    public void Select_Branch_From_Dropdown(String _select_Branch) throws InterruptedException {
      /*  WebDriverWait branch = new WebDriverWait(driver,40);
        branch.until(ExpectedConditions.visibilityOf(Select_Branch));*/

        TimeUnit.SECONDS.sleep(8);
        Select Branch = new Select(Select_Branch);
        Branch.selectByVisibleText(_select_Branch);
    }
}
