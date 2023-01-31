package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DropdownHandler;
import utilities.Waiter;

public class UnitedAirlinesTestCases extends UnitedAirlinesBaseTest{

    @Test(priority = 1)
    public void validateMainMenuItems(){
        String[] headers = {"BOOK", "MY TRIPS", "TRAVEL INFO", "MILEAGEPLUS® PROGRAM", "DEALS", "HELP"};

        for (int i = 0; i < headers.length; i++) {
            Assert.assertTrue(unitedAirlinesBasePage.headerOptions.get(i).isDisplayed());
            Assert.assertEquals(unitedAirlinesBasePage.headerOptions.get(i).getText(), headers[i]);
        }
    }

    @Test(priority = 2)
    public void validateBookTravelMenu(){
        String[] bookOptions = {"Book", "Flight status", "Check-in", "My trips"};

        for (int i = 0; i < bookOptions.length; i++) {
            Assert.assertTrue(unitedAirlinesBasePage.bookHeaders.get(i).isDisplayed());
            Assert.assertEquals(unitedAirlinesBasePage.bookHeaders.get(i).getText(), bookOptions[i]);
        }
    }

    @Test(priority = 3)
    public void validateRadioButtons(){
        for (int i = 0; i < unitedAirlinesBasePage.roundTripButton.size(); i++) {
            Assert.assertTrue(unitedAirlinesBasePage.roundTripLabel.get(i).isDisplayed());
            Assert.assertTrue(unitedAirlinesBasePage.roundTripLabel.get(i).isEnabled());
            Assert.assertTrue(unitedAirlinesBasePage.roundTripButton.get(i).isSelected());
        }

        for (int i = 0; i < unitedAirlinesBasePage.oneWayButton.size(); i++) {
            Assert.assertTrue(unitedAirlinesBasePage.oneWayLabel.get(i).isDisplayed());
            Assert.assertTrue(unitedAirlinesBasePage.oneWayLabel.get(i).isEnabled());
            Assert.assertFalse(unitedAirlinesBasePage.oneWayButton.get(i).isSelected());
        }

        unitedAirlinesBasePage.oneWayLabel.get(0).click();
        Assert.assertFalse(unitedAirlinesBasePage.roundTripButton.get(0).isSelected());
    }

    @Test(priority = 4)
    public void validateCheckBoxButtons(){
        for (int i = 0; i < unitedAirlinesBasePage.bookWithMilesButton.size(); i++) {
            Assert.assertTrue(unitedAirlinesBasePage.bookWithMilesLabel.get(i).isDisplayed());
            Assert.assertTrue(unitedAirlinesBasePage.bookWithMilesLabel.get(i).isEnabled());
            Assert.assertFalse(unitedAirlinesBasePage.bookWithMilesButton.get(i).isSelected());
        }

        for (int i = 0; i < unitedAirlinesBasePage.flexibleDatesButton.size(); i++) {
            Assert.assertTrue(unitedAirlinesBasePage.flexibleDatesLabel.get(i).isDisplayed());
            Assert.assertTrue(unitedAirlinesBasePage.flexibleDatesLabel.get(i).isEnabled());
            Assert.assertFalse(unitedAirlinesBasePage.flexibleDatesButton.get(i).isSelected());
        }

        unitedAirlinesBasePage.bookWithMilesLabel.get(0).click();
        unitedAirlinesBasePage.flexibleDatesLabel.get(0).click();

        Assert.assertTrue(unitedAirlinesBasePage.bookWithMilesButton.get(0).isSelected());
        Assert.assertTrue(unitedAirlinesBasePage.flexibleDatesButton.get(0).isSelected());

        unitedAirlinesBasePage.bookWithMilesLabel.get(0).click();
        unitedAirlinesBasePage.flexibleDatesLabel.get(0).click();

        Assert.assertFalse(unitedAirlinesBasePage.bookWithMilesButton.get(0).isSelected());
        Assert.assertFalse(unitedAirlinesBasePage.flexibleDatesButton.get(0).isSelected());
    }

    /*
    Given user is on "https://www.united.com/en/us"
    When user selects "One-way" ticket radio button
    And user enters "Chicago, IL, US (ORD)" to from input box
    And user enters "Miami, FL, US (MIA)" to to input box
    And user selects "Feb 28" to the dates input box
    And user selects "2 Adults" from travelers selector
    And user selects "Business or First" from cabin dropdown
    And user clicks on "Find Flights" button
    Then validate departure equals to "DEPART ON: February 28"
     */
    @Test(priority = 5)
    public void validateSearchResults(){
        unitedAirlinesBasePage.oneWayLabel.get(0).click();

        unitedAirlinesBasePage.fromInputBox.clear();
        unitedAirlinesBasePage.fromInputBox.sendKeys("Chicago, IL, US (ORD)");

        unitedAirlinesBasePage.toInputBox.clear();
        unitedAirlinesBasePage.toInputBox.sendKeys("Miami, FL, US (MIA)");

        unitedAirlinesBasePage.datesBox.click();
        unitedAirlinesBasePage.datesBox.clear();
        unitedAirlinesBasePage.datesBox.sendKeys("Feb 28");

        unitedAirlinesBasePage.travelerButton.click();
        unitedAirlinesBasePage.travelerSelector.click();

        DropdownHandler.clickOnDropdownOption(unitedAirlinesBasePage.cabinType, unitedAirlinesBasePage.cabinDropdownOptions, "Business or First");

        unitedAirlinesBasePage.findFlightsButton.click();

        Assert.assertEquals(unitedAirlinesBasePage.result.getText(), "DEPART ON: February 28");
    }
}