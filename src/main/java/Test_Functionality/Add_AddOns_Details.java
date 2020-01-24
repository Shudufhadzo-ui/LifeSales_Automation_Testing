package Test_Functionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Add_AddOns_Details {
    private WebDriver driver;
    public Add_AddOns_Details(WebDriver driver)
    {
        this.driver=driver;
    }

    @FindBy (xpath = "//div[@id='benefitDetailTabs']/ul[@class='nav nav-tabs']/li[6]/a/tab-heading[@class='ng-scope']/span[@class='ng-binding']")
    private WebElement Add_Ons_Tab;
    @FindBy (xpath = "/html//div[@id='benefitDetailTabs']/div/div[6]/form/benefit-category[1]//div[@class='col-xs-5']/input[@type='text']")
    private WebElement Guaranteed_Insurability_Sum_Insured;

    @FindBy(xpath = "//div[@id='benefitDetailTabs']/div/div[6]/form/benefit-category[2]//div[@class='col-xs-2_5']/benefit-feature[@class='ng-isolate-scope']/div/div/div[@class='ui-select-match']/span[@class='btn btn-default form-control ui-select-toggle']//span[@class='ng-binding ng-scope']")
    private WebElement Flexible_Facility_Type;
    @FindBy(xpath = "/html//div[@id='benefitDetailTabs']/div/div[6]/form/benefit-category[2]//div[@class='col-xs-5']/input[@type='text']")
    private WebElement Flexible_Facility_Sum_Insured;

    @FindBy (xpath = "/html//div[@id='benefitDetailTabs']/div/div[6]/form/benefit-category[3]//div[@class='col-xs-2']/benefit-feature[@class='ng-isolate-scope']//input[@type='checkbox']")
    private WebElement Crisis_Waiver_Enable;
    @FindBy(xpath = "//div[@id='benefitDetailTabs']/div/div[6]/form/benefit-category[3]//div[@class='col-xs-2_5']/benefit-feature[@class='ng-isolate-scope']/div/div/div[@class='ui-select-match']/span[@class='btn btn-default form-control ui-select-toggle']//span[@class='ng-binding ng-scope']")
    private WebElement Crisis_Waiver_Type;

    @FindBy (xpath = "/html//div[@id='benefitDetailTabs']/div/div[6]/form/benefit-category[4]//div[@class='col-xs-2']/benefit-feature[@class='ng-isolate-scope']//input[@type='checkbox']")
    private WebElement Cashback_Enable;

    public void Click_Add_Ons_Tab()
    {
        WebDriverWait add_ons=new WebDriverWait(driver,20);
        add_ons.until(ExpectedConditions.visibilityOf(Add_Ons_Tab));
        Add_Ons_Tab.click();
    }

    public void Populate_Guaranteed_Insurability_Details(String _sum)
    {
        WebDriverWait guarantee=new WebDriverWait(driver,20);
        guarantee.until(ExpectedConditions.visibilityOf(Guaranteed_Insurability_Sum_Insured));
        Guaranteed_Insurability_Sum_Insured.sendKeys(_sum);
    }

    public void Populate_Flexible_Facility_Details(String _type,String _sum)
    {
        WebDriverWait flexible=new WebDriverWait(driver,20);
        flexible.until(ExpectedConditions.visibilityOf(Flexible_Facility_Type));
        Flexible_Facility_Type.click();
        driver.findElement(By.linkText(_type)).click();

        Flexible_Facility_Sum_Insured.sendKeys(_sum);
    }
    public void Populate_Crisis_Waiver_Details(boolean _enable,String _type)
    {
        WebDriverWait crisis=new WebDriverWait(driver,20);
        crisis.until(ExpectedConditions.visibilityOf(Crisis_Waiver_Enable));
        if(_enable)
        {
            Crisis_Waiver_Enable.click();
            Crisis_Waiver_Type.click();
            driver.findElement(By.linkText(_type)).click();
        }
    }
    public void Populate_Cashback_Details(String _cashback)
    {
        WebDriverWait cashback=new WebDriverWait(driver,30);
        cashback.until(ExpectedConditions.visibilityOf(Cashback_Enable));
        if(_cashback.equalsIgnoreCase("Yes"))
        {
            Cashback_Enable.click();
        }
    }
    //adding something to new branch
}
