package step_definitions;

import framework_utilities.CucumberHooks;
import framework_utilities.GeneralUtilities;
import framework_utilities.TestDataReader;
import framework_utilities.UiUtilities;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import page_objects.AwardsAccolades_PageObjects;

import java.util.Map;

public class AwardsAccolades_Steps {
    public Scenario scenario;

    TestDataReader testDataReaderObj = new TestDataReader();
    UiUtilities uiUtilitiesObj = new UiUtilities();
    GeneralUtilities generalUtilitiesObj = new GeneralUtilities();

    public AwardsAccolades_Steps() {
        scenario = CucumberHooks._scenario;
    }

    @Then("I validate the total number of awards on awards and accolades page")
    public void iValidateTheTotalNumberOfAwardsOnAwardsAndAccoladesPage(DataTable table) {
        boolean takeScreenShot = true;
        for (Map<String, String> data : table.asMaps()) {
            if (generalUtilitiesObj.isStrEquals(testDataReaderObj.readData(data.get("<TakeScreenShot>")), "No"))
                takeScreenShot = false;
            validateTheTotalNumberOfAwardsOnAwardsAndAccoladesPage(data);
            if (takeScreenShot) {
                uiUtilitiesObj.embedFullPageScreenshot();
            }
        }
    }

    public void validateTheTotalNumberOfAwardsOnAwardsAndAccoladesPage(Map<String, String> data) {
        String expNumberOfAwards = testDataReaderObj.readData(data.get("<NumberOfAwards>"));

        if (expNumberOfAwards != null) {
            int actualNumberOfAwards = uiUtilitiesObj.getElementCount(AwardsAccolades_PageObjects.img_Awards);
            Assert.assertEquals(actualNumberOfAwards,Integer.parseInt(expNumberOfAwards));
        }
    }

    @And("I validate the award name and caption of the award mentioned in the below table")
    public void iValidateTheAwardNameAndCaptionOfTheAwardMentionedInTheBelowTable(DataTable table) {
        boolean takeScreenShot = true;
        for (Map<String, String> data : table.asMaps()) {
            if (generalUtilitiesObj.isStrEquals(testDataReaderObj.readData(data.get("<TakeScreenShot>")), "No"))
                takeScreenShot = false;
            validateTheAwardNameAndCaptionOfTheAwardMentionedInTheBelowTable(data);

        }
        if (takeScreenShot) {
            uiUtilitiesObj.embedFullPageScreenshot();
        }
    }

    public void validateTheAwardNameAndCaptionOfTheAwardMentionedInTheBelowTable(Map<String, String> data) {
        String AwardName = testDataReaderObj.readData(data.get("<AwardName>"));
        String CaptionOfTheAward = testDataReaderObj.readData(data.get("<CaptionOfTheAward>"));

        switch (AwardName) {
            case ("A World First"):
                Assert.assertTrue(uiUtilitiesObj.isElementDisplayed(AwardsAccolades_PageObjects.img_EuromoneyWorldFirst));
                Assert.assertTrue(uiUtilitiesObj.verifyPartialTextInElement(AwardsAccolades_PageObjects.txt_EuromoneyWorldFirst,CaptionOfTheAward));
                break;
            case ("The Banker"):
                Assert.assertTrue(uiUtilitiesObj.isElementDisplayed(AwardsAccolades_PageObjects.img_TheBanker));
                Assert.assertTrue(uiUtilitiesObj.verifyPartialTextInElement(AwardsAccolades_PageObjects.txt_TheBanker,CaptionOfTheAward));
                break;
            case ("Global Finance"):
                switch(CaptionOfTheAward) {
                    case ("Best Bank in the World 2018"):
                        Assert.assertTrue(uiUtilitiesObj.isElementDisplayed(AwardsAccolades_PageObjects.img_GlobalBank2018));
                        Assert.assertTrue(uiUtilitiesObj.verifyPartialTextInElement(AwardsAccolades_PageObjects.txt_GlobalBank2018,CaptionOfTheAward));
                        break;
                    case "World's Best Banks":
                        Assert.assertTrue(uiUtilitiesObj.isElementDisplayed(AwardsAccolades_PageObjects.img_GFWBB2020));
                        Assert.assertTrue(uiUtilitiesObj.verifyPartialTextInElement(AwardsAccolades_PageObjects.txt_GFWBB2020,CaptionOfTheAward));
                        break;
                    case "World's Best Investment Banks and Derivatives Providers":
                        Assert.assertTrue(uiUtilitiesObj.isElementDisplayed(AwardsAccolades_PageObjects.img_GFIB2020));
                        Assert.assertTrue(uiUtilitiesObj.verifyPartialTextInElement(AwardsAccolades_PageObjects.txt_GFIB2020,CaptionOfTheAward));
                        break;
                    default:
                        System.out.println("The given award caption is not present in options");
                }
                break;
            case ("Euromoney"):
                Assert.assertTrue(uiUtilitiesObj.isElementDisplayed(AwardsAccolades_PageObjects.img_EuromoneyAFE2020));
                Assert.assertTrue(uiUtilitiesObj.verifyPartialTextInElement(AwardsAccolades_PageObjects.txt_EuromoneyAFE2020,CaptionOfTheAward));
                break;
            default:
                Assert.fail("The given award name is not present in options");
                break;
        }
    }
}
