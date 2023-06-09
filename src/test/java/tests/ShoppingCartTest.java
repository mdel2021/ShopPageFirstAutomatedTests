package tests;

import org.testng.annotations.Test;
import page.objects.LandingPage;
import page.objects.LoginPage;

public class ShoppingCartTest extends TestBase
{
    @Test
    public void asNotLoggedInUserIShallNotProceedToCheckOut() {
        LandingPage landingPage = new LandingPage();
        landingPage.clickOnEnterStoreLink();

        LoginPage loginPage = new LoginPage();
        loginPage.clickOnFishImageButton()
                .clickOnAngelfishLink()
                .clickOnAddToCartSmallAngelfish()
                .clickOnProceedToCheckoutButton();

        loginPage.assertThatWarningIsDisplayed("You must sign on before attempting to check out. " +
                "Please sign on and try checking out again.");
    }
}
