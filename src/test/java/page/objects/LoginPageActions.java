package page.objects;

import generic.assertions.AssertWebElement;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import waits.WaitForElement;

public class LoginPageActions {

    private LoginPageElements loginPageElements;
    private Logger logger = LogManager.getLogger(LoginPageActions.class);

    public LoginPageActions() {
        loginPageElements = new LoginPageElements();
    }


    public LoginPageActions typeIntoUserNameField(String username) {
        loginPageElements.getUsernameField().sendKeys(username);
        logger.info("Typed into User Name Field {}", username);
        return this;
    }

    public LoginPageActions typeIntoPasswordField(String password) {
        loginPageElements.getPasswordField().sendKeys(password);
        logger.info("Typed into Password Field {}", password);
        return this;
    }

    public void clickOnLoginButton() {
        loginPageElements.getSignOnButton().click();
        logger.info("Clicked on Login Button");
    }

    public String getWarningMessage() {
        String warningText = loginPageElements.getMessageLabel().getText();
        logger.info("Returned warning message was: {}", warningText);
        return warningText;
    }

    @Step("Assert that warning message {warningMessage} is displayed")
    public LoginPageElements assertThatWarningIsDisplayed(String warningMessage) {
        log().info("Checking if warning message {} is displayed", warningMessage);
        WaitForElement.waitUntilElementIsVisible(messageLabel);
        AssertWebElement.assertThat(messageLabel).isDisplayed().hasText(warningMessage);
        return this;
    }

    public FishListPage clickOnFishImageButton() {
        WaitForElement.waitUntilElementIsVisible(btnFishImage);
        btnFishImage.click();
        log().info("Click on fish image");
        return new FishListPage();
    }
}
