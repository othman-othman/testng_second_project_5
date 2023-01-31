package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class UnitedAirlinesBasePage {

    public UnitedAirlinesBasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (css = "a[id*='headerNav']")
    public List<WebElement> headerOptions;

    @FindBy (css = "ul[class*=bookTravel] h2")
    public List<WebElement> bookHeaders;

    @FindBy(css = "label[for*='roundtrip']")
    public List<WebElement> roundTripLabel;

    @FindBy(id = "roundtrip")
    public List<WebElement> roundTripButton;

    @FindBy(css = "label[for*='oneway']")
    public List<WebElement> oneWayLabel;

    @FindBy(id = "oneway")
    public List<WebElement> oneWayButton;

    @FindBy(css = "input[name='AwardTravel']")
    public List<WebElement> bookWithMilesButton;

    @FindBy(css = "label[for='award']")
    public List<WebElement> bookWithMilesLabel;

    @FindBy(id = "flexibleDates")
    public List<WebElement> flexibleDatesButton;

    @FindBy(css = "label[for*='flexibleDates']")
    public List<WebElement> flexibleDatesLabel;

    @FindBy(id = "bookFlightOriginInput")
    public WebElement fromInputBox;

    @FindBy(id = "bookFlightDestinationInput")
    public WebElement toInputBox;

    @FindBy(id = "DepartDate")
    public WebElement datesBox;

    @FindBy(xpath = "//button[@aria-labelledby='stuff']")
    public WebElement travelerButton;

    @FindBy(xpath = "//button[@aria-label='Substract one Adult']")
    public WebElement travelerSelector;

    @FindBy(id = "cabinType")
    public WebElement cabinType;

    @FindBy(css = "li[id*='cabinType_item']")
    public List<WebElement> cabinDropdownOptions;

    @FindBy(xpath = "//button[@aria-label='Find flights']")
    public WebElement findFlightsButton;

    @FindBy(xpath = "//div[@class='app-components-Shopping-ColumnSortResultHeader-styles__headerLeft--3_5-b']")
    public WebElement result;
}