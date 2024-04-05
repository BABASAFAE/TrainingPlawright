package stepDefinitions;

import Factory.DriverFactory;
import Pages.HomePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class ResetPassword {
    private final Page page = DriverFactory.getPage();
    private final HomePage homePage = new HomePage(page);

    @When("the user attempts to reset the password")
    public void theUserAttemptsToResetThePassword() {
        homePage.userAttemptsToResetThePassword();
    }

    @And("the user inserts a valid email and clicks the reset button")
    public void theUserInsertsAValidEmailAndClicksTheResetButton() {
        homePage.userInsertsAValidEmailAndClicksTheResetButton();
    }

    @Then("the user should see a popup message indicating that an email has been sent for resetting the password")
    public void theUserShouldSeeAPopupMessageIndicatingThatAnEmailHasBeenSentForResettingThePassword() {
        Map<String, Object> mapContentLocatorAndMessageOfResetPassword = homePage.UserSuccessfullyResetsThePassword();
        assertThat((Locator) mapContentLocatorAndMessageOfResetPassword.get("locator"))
                .containsText((String) mapContentLocatorAndMessageOfResetPassword.get("messageOfReceivedMail"));
    }

    @And("the user accesses the Login page")
    public void theUserAccessesTheLoginPage() {
        homePage.backToHomePage();
    }

    @And("the user accesses the Yopmail website")
    public void theUserAccessesTheYopmailWebsite() {
        homePage.userNavigatesRoYopmail();
    }

    @And("the user logs in with the email used for password reset")
    public void theUserLogsInWithTheEmailUsedForPasswordReset() {
        homePage.userInsertsTheMailWhoOneAChangePasswordInTheMail();
    }

    @And("the user retrieves the latest email")
    public void heUserRetrievesTheLatestEmail() {
        homePage.userRecupireTheLastMessage();
    }

    @And("the user inserts a new password and confirms it")
    public void theUserInsertsANewPasswordAndConfirmsIt() {
        homePage.userInsertNewPasswordAndConfirmation();
    }


    @And("the user sees a popup confirming that the password has been successfully changed")
    public void theUserSeesAPopupConfirmingThatThePasswordHasBeenSuccessfullyChanged() {
        Locator popUp = homePage.popupOfConfirmationThePasswordResetSuccessfuly();
        assertThat(popUp).isVisible();
    }

    @Then("the user logs in with the new password")
    public void theUserLogsInWithTheNewPassword() {
        homePage.userLoginWithNewPassword();
    }

    @And("the user sees a popup confirming that they have successfully logged in")
    public void theUserSeesAPopupConfirmingThatTheyHaveSuccessfullyLoggedIn() {
        Locator locator = homePage.popUpOfSuccessfullyLoged();
        assertThat(locator).isVisible();
    }

    @And("the user successfully accesses their account")
    public void theUserSuccessfullyAccessesTheirAccount() {
        homePage.accessToAccount();
    }


}
