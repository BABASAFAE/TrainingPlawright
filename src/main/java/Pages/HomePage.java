package Pages;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import utils.ConfigReader;
import utils.Locators;
import utils.Utils;
import utils.WebActions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HomePage {
    private Page page;
    public HomePage(Page page) {
        this.page = page;
    }
    public void removeCookiePopup() throws InterruptedException {
        Thread.sleep(2000);
        try {
            page.locator("#usercentrics-root  button[data-testid='uc-accept-all-button']").click();
            Utils.logger.info("'usercentrics-root ' element accept cookie.");
        }
        catch (PlaywrightException e) {
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
    public void accessToLogin() throws InterruptedException {
        Locator loginIcon = page.locator(Locators.loginIcon);
        loginIcon.click();
    }
    public void AttemptsToLogin() {
        List<Map<String, String>> userData = ConfigReader.csvToMap(WebActions.getProperty("csvPath"));
        Locator emailLocator = page.locator(Locators.emailLocator);
        Locator mdpLocator = page.locator(Locators.mdpLocator);
        Locator login = page.locator(Locators.login);
        for (Map<String, String> row : userData) {
            String emailValid = row.get("username");
            String password = row.get("password");
            WebActions.waitUntilElementDisplayed(emailLocator, 10);
            emailLocator.fill(emailValid);
            mdpLocator.fill(password);
            login.click();
        }
    }
    public Locator retrievesuccessfullyLoggedIn() {
        Locator popupSuccessLogin = page.locator(Locators.popupSuccessLogin);
        WebActions.waitUntilElementDisplayed(popupSuccessLogin, 20);
        return popupSuccessLogin;
    }


    // Case 2 "Subscription"
    public void SubscriptionForm() {
        Locator EmailSection = page.locator(Locators.EmailSection);
        WebActions.waitUntilElementDisplayed(EmailSection, 20);
        EmailSection.scrollIntoViewIfNeeded();
    }
    public void InsertEmail() throws InterruptedException {
        List<Map<String, String>> email = ConfigReader.csvToMap(WebActions.getProperty("csvPath"));
        Locator insertEmail = page.locator(Locators.insertEmail);
        for (Map<String, String> row : email) {
            String emailValid = row.get("email");
            WebActions.waitUntilElementDisplayed(insertEmail, 30);
            insertEmail.fill(emailValid);
        }
    }
    public void selectCountry() {
        Locator SelectCountry = page.locator(Locators.SelectCountry);
        SelectCountry.click();
        WebActions.waitUntilElementDisplayed(SelectCountry, 30);
        page.keyboard().type("United Kingdom");
        page.waitForTimeout(1000);
        page.keyboard().press("Enter");
    }
    public void WorldFortnum() {
        Locator selectworldfortnum = page.locator(Locators.selectworldfortnum);
        selectworldfortnum.click();
        WebActions.waitUntilElementDisplayed(selectworldfortnum, 30);
        page.keyboard().type("Tea & Coffee");
        page.waitForTimeout(1000);
        page.keyboard().press("Enter");
    }
    public void fortnumProduct() {
        Locator selectfortnumproduct = page.locator(Locators.selectfortnumproduct );
        selectfortnumproduct.click();
        WebActions.waitUntilElementDisplayed(selectfortnumproduct , 30);
        page.keyboard().type("English Breakfast Tea");
        page.waitForTimeout(1000);
        page.keyboard().press("Enter");
    }
    public void ClickSignUp() {
        Locator SignUp = page.locator(Locators.SignUp);
        SignUp.click();
        WebActions.waitUntilElementDisplayed(SignUp, 20);
    }
    public Map<String,Locator>  retrievesuccessfullySubscribed() {
        Locator popupSuccessSubscribe = page.locator(Locators.popupSuccessSubscribe);
        Locator messageSuccessSubscribe = page.locator(Locators.messageSuccessSubscribe);
        WebActions.waitUntilElementDisplayed(popupSuccessSubscribe, 20);
        WebActions.waitUntilElementDisplayed(messageSuccessSubscribe , 20);
        Map<String,Locator> successElements = new HashMap<>();
        successElements.put("popupSuccessSubscribe",popupSuccessSubscribe) ;
        successElements.put("messageSuccessSubscribe",messageSuccessSubscribe);
        return  successElements;
    }

    // Case 3 "ResetPassword"
    public void forgotpassword() {
        Locator ForgotPassword = page.locator(Locators.ForgotPassword);
        ForgotPassword.click();
        WebActions.waitUntilElementDisplayed(ForgotPassword, 10);
    }
    public void inputemail() {
        List<Map<String, String>> validemail = ConfigReader.csvToMap(WebActions.getProperty("csvPath"));
        Locator insertAnEmail = page.locator(Locators.insertAnEmail);
        for (Map<String, String> row : validemail) {
            String Validemail = row.get("emailvalid");
            WebActions.waitUntilElementDisplayed(insertAnEmail, 10);
            insertAnEmail.fill(Validemail);
        }
    }
    public void resetbutton() {
        Locator ResetPassword = page.locator(Locators.ResetPassword);
        ResetPassword.click();
        WebActions.waitUntilElementDisplayed(ResetPassword, 10);
    }
    public Locator retrievesuccessfullyResetPswd() {
        Locator popupSuccessreset = page.locator(Locators.popupSuccessreset);
        WebActions.waitUntilElementDisplayed(popupSuccessreset, 10);
        return popupSuccessreset;
    }

    public void accessToYopmail() throws InterruptedException {

        page.navigate("https://yopmail.com/fr/");
    }

    public void logIn() throws InterruptedException {
        List<Map<String, String>> emailvalid = ConfigReader.csvToMap(WebActions.getProperty("csvPath"));
        Locator insertEmail = page.locator(Locators.yopEmail);
        Locator btnlogin = page.locator(Locators.btnlogin);
        for (Map<String, String> row : emailvalid) {
            String yopemail = row.get("emailvalid");
            WebActions.waitUntilElementDisplayed(insertEmail, 10);
            insertEmail.fill(yopemail);
        }
        btnlogin.click();

    }

    public void SetNewPassword() throws InterruptedException {
        FrameLocator frame=page.frameLocator(Locators.frame);
        Locator NewPassword = frame.locator(Locators.NewPassword);
        String url=NewPassword.getAttribute("href");
        page.navigate(url);
    }

    public void InsertNewPassword() throws InterruptedException {
        List<Map<String, String>> mdp = ConfigReader.csvToMap(WebActions.getProperty("csvPath"));
        Locator Password = page.locator(Locators.Password);
        Locator RepeatPassword = page.locator(Locators.RepeatPassword);
        Locator Save = page.locator(Locators.Save);
        for (Map<String, String> row : mdp ){
            String Pswrd = row.get("mdpvalid");
            String RepeatPswrd = row.get("mdpvalid");
            WebActions.waitUntilElementDisplayed(Password, 10);
            Password.fill(Pswrd);
            RepeatPassword.fill(RepeatPswrd);
        }
        Save.click();
        Thread.sleep(2000);
    }

    public Locator retrievesuccessfullyChangePswd() {
        Locator popupSuccesschange = page.locator(Locators.popupSuccesschange);
        WebActions.waitUntilElementDisplayed(popupSuccesschange, 10);
        return popupSuccesschange;
    }
}
