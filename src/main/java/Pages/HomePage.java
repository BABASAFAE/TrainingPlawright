package Pages;

import com.microsoft.playwright.*;
import utils.ConfigReader;
import utils.Locators;
import utils.Utils;
import utils.WebActions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomePage {
    private Page page;

    public HomePage(Page page) {
        this.page = page;
    }

    public void removeCookiePopup() throws InterruptedException {
        Thread.sleep(3000);
        try {
            page.locator("#usercentrics-root  button[data-testid='uc-accept-all-button']").click();
            Utils.logger.info("'usercentrics-root ' element accept cookie.");
        } catch (PlaywrightException e) {
            Utils.logger.info("Exception occurred: " + e.getMessage());
        }

    }


    public void chooseCountryForShopping(String country) throws InterruptedException {
        Locator arrowIconLoctor = page.locator(Locators.arrowIcon);
        WebActions.waitUntilElementDisplayed(arrowIconLoctor, 20);
        arrowIconLoctor.click();
        Locator shoiceCountryFieldLocator = page.locator(Locators.choiceCountryField);
        shoiceCountryFieldLocator.click();
        Locator optionDropDrown = page.locator(String.format(Locators.moveWishList, country));
        optionDropDrown.click();
        Locator buttonStartShopingLoctor = page.locator(Locators.buttonStartShopping);
        buttonStartShopingLoctor.click();
    }


    public void accessToLogin() {
        List<Map<String, String>> userData = ConfigReader.csvToMap(WebActions.getProperty("csvPath"));
        Locator emailField = page.locator(Locators.mailLoginField);
        Locator passwordField = page.locator(Locators.passwordLoginField);
        Locator locator = page.locator(Locators.buttonLogin);

        for (Map<String, String> row : userData) {
            String emailValid = row.get("username");
            String password = row.get("password");
            Utils.logger.info("-------------------" + emailValid);
            WebActions.waitUntilElementDisplayed(emailField, 10);
            emailField.fill(emailValid);
            passwordField.fill(password);
            locator.click();
        }
    }


    public void accessToLoginForm() {
        Locator loginIconLocator = page.locator(Locators.loginIcon);
        WebActions.waitUntilElementDisplayed(loginIconLocator, 20);
        loginIconLocator.click();
    }


    public Locator popUpOfSuccessfullyLoged() {
        Locator locator = page.locator(Locators.popUpLoggedInSuccessful);
        WebActions.waitUntilElementDisplayed(locator, 10);
        return locator;

    }

    public Locator accessToAccount() {
        Locator loginIconLocator = page.locator(Locators.loginIcon);
        WebActions.waitUntilElementDisplayed(loginIconLocator, 20);
        loginIconLocator.click();
        Locator buttonChangePassword = page.locator(Locators.buttonChangeBasswordInAcount);
        WebActions.waitUntilElementDisplayed(buttonChangePassword, 10);
        return loginIconLocator;
    }

    public void UserHasAccessedTheSignUpBloc() {
        Locator locatorOfBlocSubscribe = page.locator("//div[@id='newsletter']");
        locatorOfBlocSubscribe.scrollIntoViewIfNeeded();
    }

    public void userInsertsAValidEmailAndAttemptsToSubscribe() {
        List<Map<String, String>> userData = ConfigReader.csvToMap(WebActions.getProperty("csvPath"));
        Locator locatorOfFieldEmailOfSubscribe = page.locator(Locators.feildSubscribeEmail);
        for (Map<String, String> row : userData) {
            String emailValid = row.get("username");
            WebActions.waitUntilElementDisplayed(locatorOfFieldEmailOfSubscribe, 10);
            locatorOfFieldEmailOfSubscribe.fill(emailValid);
        }
    }

    public Locator userIsSuccessfullySubscribed() {
        Locator messageOfSuccessfullySubscribed = page.locator(Locators.messageOfSuccessfullySubscribed);
        return messageOfSuccessfullySubscribed;
    }

    public Locator confirmationPopupIsDisplayed() {
        Locator locatorOfPopup = page.locator(Locators.loctorOfPopup);
        return locatorOfPopup;
    }

    public void userAttemptsToResetThePassword() {
        Locator locatorToLinkForResetPassword = page.locator(Locators.LinkToResetPasswordPage);
        locatorToLinkForResetPassword.click();
    }

    public void userInsertsAValidEmailAndClicksTheResetButton() {
        Locator emailField = page.locator(Locators.EmailFieldOfResetPassword);
        List<Map<String, String>> userData = ConfigReader.csvToMap(WebActions.getProperty("csvPath"));
        Locator buttonToRestPassword = page.locator(Locators.ButtonOfResetPassword);
        WebActions.waitUntilElementDisplayed(emailField, 10);

        for (Map<String, String> row : userData) {
            String emailValid = row.get("username");
            WebActions.waitUntilElementDisplayed(emailField, 10);
            emailField.fill(emailValid);
            buttonToRestPassword.click();
        }

    }

    public Map<String, Object> UserSuccessfullyResetsThePassword() {
        List<Map<String, String>> userData = ConfigReader.csvToMap(WebActions.getProperty("csvPath"));
        Locator messageOfChangePassword = page.locator(Locators.MessageAfficheForResetPassword);
        WebActions.waitUntilElementDisplayed(messageOfChangePassword, 10);
        Utils.logger.info("-----------------" + messageOfChangePassword.textContent());
        String messageOfReceivedMailInstructionsForRestingPassword
                = userData.get(0).get("messageOfReceivedMailInstructionsForRestingPassword");
        Map<String, Object> map = new HashMap<>();
        map.put("messageOfReceivedMail", messageOfReceivedMailInstructionsForRestingPassword);
        map.put("locator", messageOfChangePassword);
        return map;
    }

    public void backToHomePage() {
        Locator backToHomePage = page.locator(Locators.ButtonBackToHomeFromResetPasswordPage);
        WebActions.waitUntilElementDisplayed(backToHomePage, 10);
        backToHomePage.click();
    }

    public void userNavigatesRoYopmail() {
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        page.navigate(Locators.WebSiteOfYopMail);
    }

    public void userInsertsTheMailWhoOneAChangePasswordInTheMail() {
        List<Map<String, String>> userData = ConfigReader.csvToMap(WebActions.getProperty("csvPath"));
        Locator locatorInputField = page.locator(Locators.InputFieldOfYopMail);

        for (Map<String, String> row : userData) {
            String emailValid = row.get("username");
            WebActions.waitUntilElementDisplayed(locatorInputField, 10);
            locatorInputField.fill(emailValid);
        }
        Locator locatorButton =
                page.locator(Locators.ButtonGoInsidYopMail);
        locatorButton.click();
    }

    public void userRecupireTheLastMessage() {
        FrameLocator frameLocator = page.frameLocator(Locators.IframeOfYopMailMessage);
        Locator buttonNavigtToCreateNewPassword = frameLocator.locator(Locators.ButtonForGoToPageResetPassword);
        String href = buttonNavigtToCreateNewPassword.getAttribute("href");
        Utils.logger.info("--------------------------" + href);
        page.navigate(href);
    }

    public void userInsertNewPasswordAndConfirmation() {
        List<Map<String, String>> userData = ConfigReader.csvToMap(WebActions.getProperty("csvPath"));

        Locator newPassword = page.locator(Locators.NewPasswordField);
        Locator repeatPassword = page.locator(Locators.RepeatPassword);
        Locator saveNewPassword = page.locator(Locators.ButounSaveNewPassword);


        for (Map<String, String> row : userData) {
            String newPass = row.get("newPassword");
            WebActions.waitUntilElementDisplayed(newPassword, 10);
            newPassword.fill(newPass);
            repeatPassword.fill(newPass);
            saveNewPassword.click();
        }
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Locator popupOfConfirmationThePasswordResetSuccessfuly() {
        Locator locator = page.locator(Locators.messageOfConfirmationThePasswordResetSuccefuly);
        return locator;
    }

    public void userLoginWithNewPassword() {
        List<Map<String, String>> userData = ConfigReader.csvToMap(WebActions.getProperty("csvPath"));
        Locator emailField = page.locator(Locators.mailLoginField);
        Locator passwordField = page.locator(Locators.NewPassword);
        Locator locator = page.locator(Locators.buttonLogin);

        for (Map<String, String> row : userData) {
            String emailValid = row.get("username");
            String password = row.get("newPassword");
            Utils.logger.info("-------------------" + emailValid);
            WebActions.waitUntilElementDisplayed(emailField, 10);
            emailField.fill(emailValid);
            passwordField.fill(password);
            locator.click();
        }
    }

    public void userSelectTheCoubtryWhereLive(String country) {
        Locator locator = page.locator(Locators.selctedCountry);
        locator.selectOption(country);
    }

    public void userSelectTheFortnumTopicFromTheWorldOfFortnums(String fortnumTopic) {
        Locator locator = page.locator(Locators.generalInterest);
        locator.selectOption(fortnumTopic);
    }

    public void userSelectsTheFortnumsProduct(String product) {
        Locator locator = page.locator(Locators.productInterest);
        locator.selectOption(product);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void attemptToSubscribe() {
        Locator locatorOfButtonOfSubscribe = page.locator(Locators.buttonOfSubscribe);
        locatorOfButtonOfSubscribe.click();

    }
}
