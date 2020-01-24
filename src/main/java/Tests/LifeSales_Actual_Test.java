package Tests;

import Startup.Setup_Class;
import Test_Functionality.*;
import Test_Helpers.Report_Helper;
import Test_Helpers.Scroll_To_The_Bottom_Of_The_Page;
import com.aventstack.extentreports.Status;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class LifeSales_Actual_Test {


    private WebDriver driver = Setup_Class.startBrowserOfChoice("https://lifesales-sit.azurewebsites.net/", "chrome");
    private static String dir = System.getProperty("user.dir");
    private static final String excel = dir + "/src/main/java/TestData/LifeSalesTestData.xlsx";
    private FileInputStream fis = new FileInputStream(excel);
    private XSSFWorkbook workbook = new XSSFWorkbook(fis);

    private XSSFSheet sheet = workbook.getSheetAt(0);
    private int data_Length = sheet.getLastRowNum();

    public LifeSales_Actual_Test() throws IOException, InterruptedException {
    }
    @Test(description = "This Test Will Calculate Premium For All Users In Excel SpreadSheet")
    public void Log_In_To_LifeSales_Test() throws InterruptedException {
        for (int i = 1; i <= data_Length; i++) {
            String Username = sheet.getRow(i).getCell(0).getStringCellValue();
            String Password = sheet.getRow(i).getCell(1).getStringCellValue();
            String Branch = sheet.getRow(i).getCell(2).getStringCellValue();

            Login_To_LifeSales login = PageFactory.initElements(driver,Login_To_LifeSales.class);
            login.Login_to_LifeSales(Username,Password);
            //name of the class then variable = Pagefactory...
            Branch branch = PageFactory.initElements(driver,Branch.class);
            branch.Select_Branch_From_Dropdown(Branch);
            //Navigate to the side Menu, and Click Quote
            Select_Quote_From_Side_Menu Select_Quote = PageFactory.initElements(driver,Select_Quote_From_Side_Menu.class);
            Select_Quote.SelectQuote_From_SideMenu();

        }
    }
}
