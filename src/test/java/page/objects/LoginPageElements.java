package page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageElements extends BasePage {

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

    public WebElement getUsernameField() {
        return usernameField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getSignOnButton() {
        return signOnButton;
    }

    public WebElement getMessageLabel() {
        return messageLabel;
    }

    public WebElement getBtnFishImage() {
        return btnFishImage;
    }
}