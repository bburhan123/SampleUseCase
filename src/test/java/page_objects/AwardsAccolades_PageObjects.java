package page_objects;

import org.openqa.selenium.By;

public class AwardsAccolades_PageObjects {
    /******************************************** Image Elements ********************************************************************/
    public static final By img_Awards = By.xpath("//div[@class='row mBot-20']//img");
    public static final By img_EuromoneyWorldFirst = By.xpath("//img[contains(@src,'/2019/euromoney-world-first.jpg')]");
    public static final By txt_EuromoneyWorldFirst = By.xpath("//img[contains(@src,'/2019/euromoney-world-first.jpg')]/ancestor::div[@class='mBot-20 col-md-4']/following-sibling::div[@class='col-md-8']");
    public static final By img_TheBanker = By.xpath("//img[contains(@src,'/2019/award-test.jpg')]");
    public static final By txt_TheBanker = By.xpath("//img[contains(@src,'/2019/award-test.jpg')]/ancestor::div[@class='mBot-20 col-md-4']/following-sibling::div[@class='col-md-8']");
    public static final By img_GlobalBank2018 = By.xpath("//img[contains(@src,'/2019/global-bank-award-2018.jpg')]");
    public static final By txt_GlobalBank2018 = By.xpath("//img[contains(@src,'/2019/global-bank-award-2018.jpg')]/ancestor::div[@class='mBot-20 col-md-4']/following-sibling::div[@class='col-md-8']");
    public static final By img_EuromoneyAFE2020 = By.xpath("//img[contains(@src,'/2020/EM AFE 20.jpg')]");
    public static final By txt_EuromoneyAFE2020 = By.xpath("//img[contains(@src,'/2020/EM AFE 20.jpg')]/ancestor::div[@class='mBot-20 col-md-4']/following-sibling::div[@class='col-md-8']");
    public static final By img_GFWBB2020 = By.xpath("//img[contains(@src,'/2020/GF WBB 20.jpg')]");
    public static final By txt_GFWBB2020 = By.xpath("//img[contains(@src,'/2020/GF WBB 20.jpg')]/ancestor::div[@class='mBot-20 col-md-4']/following-sibling::div[@class='col-md-8']");
    public static final By img_GFIB2020 = By.xpath("//img[contains(@src,'/2020/GF IB 20.jpg')]");
    public static final By txt_GFIB2020 = By.xpath("//img[contains(@src,'/2020/GF IB 20.jpg')]/ancestor::div[@class='mBot-20 col-md-4']/following-sibling::div[@class='col-md-8']");
}
