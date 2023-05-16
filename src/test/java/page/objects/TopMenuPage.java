package page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class TopMenuPage extends BasePage {

    @FindBy(css = "#SidebarContent > a:nth-child(1)")
    private WebElement fishCategoryLink;

    @FindBy(css = "#MenuContent a[href*='signonForm']")
    private WebElement signOnLink;

    public LoginPage clickOnSignInLink() {
        WaitForElement.waitUntilElementIsVisible(signOnLink);
        signOnLink.click();
        log().info("Clicked on Sign on Link");
        return new LoginPage();
    }
    public FishListPage clickOnFishCategoryLink() {
        WaitForElement.waitUntilElementIsVisible(fishCategoryLink);
        fishCategoryLink.click();
        log().info("Clicked on Fish Category Link");
        return new FishListPage();
    }
}