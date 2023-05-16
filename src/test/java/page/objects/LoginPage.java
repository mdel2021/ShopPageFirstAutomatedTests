package page.objects;

import generic.assertions.AssertWebElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class LoginPage extends BasePage {

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

    public LoginPage typeIntoUserNameField(String username) {
        WaitForElement.waitUntilElementIsVisible(usernameField);
        usernameField.sendKeys(username);
        log().info("Typed into User Name Field {}", username);
        return this;
    }

    public LoginPage typeIntoPasswordField(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        log().info("Typed into Password Field {}", password);
        return this;
    }

    public FooterPage clickOnLoginButton() {
        signOnButton.click();
        log().info("Clicked on Login Button");
        return new FooterPage();
    }

    @Step("Assert that warning message {warningMessage} is displayed")
    public LoginPage assertThatWarningIsDisplayed(String warningMessage) {
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