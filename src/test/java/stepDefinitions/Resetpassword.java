package stepDefinitions;

import Factory.DriverFactory;
import Pages.HomePage;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Utils;

public class Resetpassword {
    private final Page page = DriverFactory.getPage();

        @When("the user clicks button Forgotten the password")
        public void theUserClicksButtonForgottenThePassword() throws InterruptedException {
            HomePage homePage = new HomePage(page);
            homePage.forgotpassword();
            Utils.logger.info("success step");
        }

        @And("The user inserts an email valid")
            public void theUserInsertsAnEmailValid(){
                HomePage homePage = new HomePage(page);
                homePage.inputemail();
                Utils.logger.info("success step");
        }

        @And("The user clicks button Reset Password")
            public void theUserClicksButtonResetPassword() {
            HomePage homePage = new HomePage(page);
            homePage.resetbutton();
            Utils.logger.info("success step");

        }
       @Then("the user has successfully resert his password")
           public void theUserHasSuccessfullyResetHisPassword(){
           HomePage homePage = new HomePage(page);
           PlaywrightAssertions.assertThat(homePage.retrievesuccessfullyResetPswd()).isVisible();
           Utils.logger.info("success step");

        }

    @And("the user accesses the Yopmail website")
    public void theUserAccessesTheYopmailWebsite() throws InterruptedException {
        HomePage homePage = new HomePage(page);
        homePage.accessToYopmail();
        Utils.logger.info("success step");
    }

    @And("the user logs in with the email used for password reset")
    public void theUserLogsInWithTheEmailUsedForPasswordReset() throws InterruptedException {
        HomePage homePage = new HomePage(page);
        homePage.logIn();
        Utils.logger.info("success step");
    }

    @And("the user retrieves the latest email")
    public void theUserRetrievesTheLatestEmail() throws InterruptedException {
        HomePage homePage = new HomePage(page);
        homePage.SetNewPassword();
        Utils.logger.info("success step");
    }

    @And("the user inserts a new password and confirms it")
    public void theUserInsertsANewPasswordAndConfirmsIt() throws InterruptedException {
        HomePage homePage = new HomePage(page);
        homePage.InsertNewPassword();
        Utils.logger.info("success step");
    }

    @And("the user sees a popup confirming that the password has been successfully changed")
    public void theUserSeesAPopupConfirmingThatThePasswordHasBeenSuccessfullyChanged() {
        HomePage homePage = new HomePage(page);
        PlaywrightAssertions.assertThat(homePage.retrievesuccessfullyChangePswd()).isVisible();
        Utils.logger.info("success step");
    }

    @And("the user logs in with the new password")
    public void theUserLogsInWithTheNewPassword() {
        HomePage homePage = new HomePage(page);
        homePage.logswithnewpsswrd();
        Utils.logger.info("success step");
    }



    @And("the user successfully accesses their account")
    public void theUserSuccessfullyAccessesTheirAccount() throws InterruptedException {
        HomePage homePage = new HomePage(page);
        homePage.AccessToAccount();
        Utils.logger.info("success step");
    }
}
