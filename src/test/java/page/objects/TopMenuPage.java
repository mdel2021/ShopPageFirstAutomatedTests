package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class TopMenuPage {

    private Logger logger = LogManager.getLogger(TopMenuPage.class);

    @FindBy(css = "#SidebarContent > a:nth-child(1)")
    private WebElement fishCategoryLink;

    @FindBy(css = "#MenuContent a[href*='signonForm']")
    private WebElement signOnLink;

    public TopMenuPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public LoginPage clickOnSignInLink() {
        WaitForElement.waitUntilElementIsVisible(signOnLink);
        signOnLink.click();
        logger.info("Clicked on Sign on Link");
        return new LoginPage();
    }
    public FishListPage clickOnFishCategoryLink() {
        WaitForElement.waitUntilElementIsVisible(fishCategoryLink);
        fishCategoryLink.click();
        logger.info("Clicked on Fish Category Link");
        return new FishListPage();
    }






}