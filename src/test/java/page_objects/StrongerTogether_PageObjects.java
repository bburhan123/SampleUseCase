package page_objects;

import org.openqa.selenium.By;

public class StrongerTogether_PageObjects {
    /******************************************** Link Elements ********************************************************************/
    public static final By lnk_Singapore = By.xpath("//a[@class='nav-link hasDevice'][contains(text(),'Singapore')]");

    /******************************************** Header Elements ********************************************************************/
    public static final By hdr_Singapore = By.xpath("//h3[contains(text(),'Singapore')]");

    /******************************************** Table Elements ********************************************************************/
    public static final By tbl_FeedTheCity = By.xpath("//table/tbody");
}
