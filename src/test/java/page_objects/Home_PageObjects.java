package page_objects;

import org.openqa.selenium.By;

public class Home_PageObjects {
    /******************************************** Image Elements ********************************************************************/
    public static final By img_DBSLogo = By.xpath("//div[@class='navbar-inner']/a[@href='https://www.dbs.com.sg/index/default.page']/img[@alt='DBS']");

    /******************************************** Button ********************************************************************/
    public static final By btn_LearnMore = By.xpath("//p[@class='dbs-group']//button[@class='btn btn-primary']");

    /******************************************** Link Elements ********************************************************************/
    public static final By lnk_About = By.xpath("//div[@class='navbar-links-left']//a[@href ='/about-us/default.page']");
    public static final By lnk_Careers = By.xpath("//div[@class='navbar-links-left']//a[@href ='/careers/default.page']");
    public static final By lnk_WhoWeAre = By.xpath("//div[@class='navbar-overflow-content']//a[@href ='/about-us/who-we-are/default.page']");
    public static final By lnk_OurAwardsAccolades = By.xpath("//a[contains(text(),'Our Awards & Accolades')]");
}
