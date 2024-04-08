/*package Pages;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import utils.ConfigReader;
import utils.Locators;
import utils.Utils;
import utils.WebActions;

import java.util.List;
import java.util.Map;

import static utils.Locators.*;

public class HomePage {
    private Page page;

    public HomePage(Page page) {
        this.page = page;
    }

    public void removeCookiePopup() throws InterruptedException {

        try {
            Locator BTNACCEPT = page.locator(Locators.btnAcceptAll);
            WebActions.waitUntilElementDisplayed(BTNACCEPT, 20);
            BTNACCEPT.click();
            Utils.logger.info("'usercentrics-root ' element accept cookie.");
        } catch (PlaywrightException e) {
            Utils.logger.info("Exception occurred: " + e.getMessage());
        }

    }


    public void chooseCountryForShopping(String country) throws InterruptedException {
        Locator CountryShopping = page.locator(SelectCountryIcon);
        WebActions.waitUntilElementDisplayed(CountryShopping, 20);

        Locator inputCountryShopping = page.locator(Locators.loginSelectCountry);
        Locator chooseCountryShopping = page.locator(String.format(Locators.CountryIcon, country));
        Locator validateCountryShopping = page.locator(Locators.btnStartShoping);
        CountryShopping.click();
        inputCountryShopping.fill(country);
        chooseCountryShopping.click();
        validateCountryShopping.click();

    }


    public void accessToLogin() throws InterruptedException {
        Locator loginIconLocator = page.locator(Locators.loginIcon);

        WebActions.waitUntilElementDisplayed(loginIconLocator, 20);
        loginIconLocator.click();


    }

    public void pageLogin() throws InterruptedException {


        Locator inputemail = page.locator(Locators.EmailField);
        WebActions.waitUntilElementDisplayed(inputemail, 20);
        List<Map<String, String>> userData = ConfigReader.csvToMap(WebActions.getProperty("csvPath"));
        Locator inputpwd = page.locator(Locators.PwdField);
        Locator inputlog = page.locator(Locators.logbutton);

        for (Map<String, String> row : userData) {

            String emailValid = row.get("email");

            String password = row.get("password");

            WebActions.waitUntilElementDisplayed(inputemail, 10);

            inputemail.fill(emailValid);

            inputpwd.fill(password);


        }
        inputlog.click();

    }

    public Locator SuccesLogin() {
        Locator PopUPTestSuccessfully = page.locator(TestSucces);
        WebActions.waitUntilElementDisplayed(PopUPTestSuccessfully, 20);

        return PopUPTestSuccessfully;
    }

    public void AccountPage() throws InterruptedException {
        Locator loginIconLocator = page.locator(Locators.loginIcon);

        WebActions.waitUntilElementDisplayed(loginIconLocator, 20);
        loginIconLocator.click();

    }
}

//   <div class = tester> test</div>
    //div[text()='You are logged in!']

/*

    public void ResetPassword() throws InterruptedException {
        Locator loginIconLocator = page.locator(Locators.loginIcon);
        WebActions.waitUntilElementDisplayed(loginIconLocator, 20);
        loginIconLocator.click();
        Thread.sleep(60);
        page.locator("//button[@class=\"forgot-password font-nova underline text-xl\"]").click();
        Thread.sleep(5000);
    }*/
