package step_definitions;

import com.google.gson.JsonObject;
import framework_utilities.CucumberHooks;
import framework_utilities.GeneralUtilities;
import framework_utilities.TestDataReader;
import framework_utilities.UiUtilities;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page_objects.Home_PageObjects;
import page_objects.StrongerTogether_PageObjects;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class Home_Steps {
    public WebDriver driver;
    public Scenario _scenario;
    public JsonObject TestDataJsonObj;

    TestDataReader testDataReaderObj = new TestDataReader();
    UiUtilities uiUtilitiesObj = new UiUtilities();
    GeneralUtilities generalUtilitiesObj = new GeneralUtilities();

    public Home_Steps() {
        driver = CucumberHooks.driver.get();
        _scenario = CucumberHooks._scenario;
        TestDataJsonObj = CucumberHooks.TestDataJsonObj;
    }

    @Given("I am on DBS home page")
    public void iAmOnDBSHomePage() throws MalformedURLException {
        String url = TestDataJsonObj.get("ApplicationUrl").getAsString();
        final URL appURL = new URL(url);
        driver.get(appURL.toString());
        Assert.assertTrue(uiUtilitiesObj.isElementDisplayed(Home_PageObjects.img_DBSLogo));
        uiUtilitiesObj.embedFullPageScreenshot();
    }

    @When("I navigate to Singapore DBS stronger together fund page")
    public void iNavigateToSingaporeDBSStrongerTogetherFundPage() {
        uiUtilitiesObj.click(Home_PageObjects.btn_LearnMore);
        uiUtilitiesObj.click(StrongerTogether_PageObjects.lnk_Singapore);
        Assert.assertTrue(uiUtilitiesObj.isElementDisplayed(StrongerTogether_PageObjects.hdr_Singapore));
        uiUtilitiesObj.embedScreenShot();
    }

    @When("I navigate to below link")
    public void iNavigateToBelowLink(DataTable table) {
        boolean takeScreenShot = true;
        for (Map<String, String> data : table.asMaps()) {
            if (generalUtilitiesObj.isStrEquals(testDataReaderObj.readData(data.get("<TakeScreenShot>")), "No"))
                takeScreenShot = false;
            navigateToBelowLink(data);
            if (takeScreenShot) {
                uiUtilitiesObj.embedScreenShot();
            }
        }
    }

    public void navigateToBelowLink(Map<String, String> data) {
        String LinkName = testDataReaderObj.readData(data.get("<LinkName>"));
        if (LinkName != null) {
            switch (LinkName) {
                case ("About"):
                    uiUtilitiesObj.click(Home_PageObjects.lnk_About);
                    break;
                case ("Careers"):
                    uiUtilitiesObj.click(Home_PageObjects.lnk_Careers);
                    break;
                case ("WhoWeAre"):
                    uiUtilitiesObj.click(Home_PageObjects.lnk_WhoWeAre);
                    break;
                case ("OurAwardsAccolades"):
                    uiUtilitiesObj.click(Home_PageObjects.lnk_OurAwardsAccolades);
                    break;
            }
        }
    }
}
