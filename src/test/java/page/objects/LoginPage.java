package page.objects;

import driver.manager.DriverManager;
import generic.assertions.AssertWebElement;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class LoginPage {

    private Logger logger = LogManager.getLogger(LoginPage.class);

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy (name = "password")
    private WebElement passwordField;

    @FindBy (name = "signon")
    private WebElement signOnButton;

    @FindBy (css = "#Content ul[class='messages'] li")
    private WebElement messageLabel;

    @FindBy (css = "area[alt='Fish']")
    private WebElement btnFishImage;


    public LoginPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public LoginPage typeIntoUserNameField(String username) {
        WaitForElement.waitUntilElementIsVisible(usernameField);
//        usernameField.clear();
        usernameField.sendKeys(username);
        logger.info("Typed into User Name Field {}", username);
        return this;
    }

    public LoginPage typeIntoPasswordField(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        logger.info("Typed into Password Field {}", password);
        return this;
    }

    public FooterPage clickOnLoginButton() {
        signOnButton.click();
        logger.info("Clicked on Login Button");
        return new FooterPage();
    }


    @Step("Assert that warning message {warningMessage} is displayed")
    public LoginPage assertThatWarningIsDisplayed(String warningMessage) {
        logger.info("Checking if warning message {} is displayed", warningMessage);
        WaitForElement.waitUntilElementIsVisible(messageLabel);
        AssertWebElement.assertThat(messageLabel).isDisplayed().hasText(warningMessage);
        return this;
    }

    public FishListPage clickOnFishImageButton() {
        WaitForElement.waitUntilElementIsVisible(btnFishImage);
        btnFishImage.click();
        logger.info("Click on fish image");
        return new FishListPage();
    }
}