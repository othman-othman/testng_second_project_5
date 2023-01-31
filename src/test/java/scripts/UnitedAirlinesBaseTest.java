package scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.UnitedAirlinesBasePage;
import utilities.ConfigReader;
import utilities.Driver;

public class UnitedAirlinesBaseTest {

    UnitedAirlinesBaseTest unitedAirlinesBaseTest;
    UnitedAirlinesBasePage unitedAirlinesBasePage;
    UnitedAirlinesTestCases unitedAirlinesTestCases;
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        unitedAirlinesBaseTest = new UnitedAirlinesBaseTest();
        unitedAirlinesBasePage = new UnitedAirlinesBasePage();
        driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("appURL"));
    }

    @AfterMethod
    public void tearDown(){
        Driver.quitDriver();
    }
}