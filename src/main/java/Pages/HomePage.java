package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
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
            WebActions.waitUntilElementDisplayed(BTNACCEPT, 5);
            BTNACCEPT.click();
            Utils.logger.info("'usercentrics-root ' element accept cookie.");
        } catch (PlaywrightException e) {
            Utils.logger.info("Exception occurred: " + e.getMessage());
        }
    }

    public void chooseCountryForShopping(String country) throws InterruptedException {
        Locator CountryShopping = page.locator(SelectCountryIcon);
        WebActions.waitUntilElementDisplayed(CountryShopping, 15);
        Locator inputCountryShopping = page.locator(Locators.loginSelectCountry);
        Locator chooseCountryShopping = page.locator(String.format((Locators.CountryIcon), country));
        Locator validateCountryShopping = page.locator(Locators.btnStartShoping);
        CountryShopping.click();
        inputCountryShopping.fill(country);
        chooseCountryShopping.click();
        validateCountryShopping.click();

    }

    public void accessToLogin() throws InterruptedException {
        Locator loginIconLocator = page.locator(Locators.loginIcon);
        WebActions.waitUntilElementDisplayed(loginIconLocator, 15);
        loginIconLocator.click();

    }

    public void PageLogin() throws InterruptedException {
        Locator inputemail = page.locator(Locators.EmailField);
        WebActions.waitUntilElementDisplayed(inputemail, 15);
        List<Map<String, String>> userData = ConfigReader.csvToMap(WebActions.getProperty("csvPath"));
        Locator inputpwd = page.locator(Locators.PwdField);
        Locator inputlog = page.locator(Locators.logbutton);
        for (Map<String, String> row : userData) {

            String emailValid = row.get("username");

            String password = row.get("password");

            WebActions.waitUntilElementDisplayed(inputemail, 15);

            inputemail.fill(emailValid);

            inputpwd.fill(password);
            inputlog.click();

        }

    }

    public Locator SuccesLogin() {
        return page.locator(Locators.TestSucces);

    }

    public void AccountPage() {
        Locator loginIconLocator = page.locator(Locators.loginIcon);
        WebActions.waitUntilElementDisplayed(loginIconLocator, 15);
        loginIconLocator.click();
    }

    public void DeleteAllProductFromWishList() throws InterruptedException {
        Locator Locator = page.locator(Locators.wishlist);
        WebActions.waitUntilElementDisplayed(Locator, 15);
        Locator.click();
        boolean deletewishlistexist = page.locator(Locators.deletewishlist) != null;
        Utils.logger.info("delete wishlist" + deletewishlistexist);

        if (deletewishlistexist) {
            Locator deletlocator = page.locator(Locators.deletewishlist);
            WebActions.waitUntilElementDisplayed(deletlocator, 15);
            deletlocator.click();
            Locator closelocator = page.locator(Locators.closeicon);
            WebActions.waitUntilElementDisplayed(closelocator, 25);
            closelocator.click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

//        Locator wish = page.locator("//h1[text()='Your Wishlist']");
//        if (wish.textContent().equals("Your Wishlist")) {
//            page.locator("//i[@class='icon-close text-xl']").click();
//            page.locator("//i[@class='icon-close']").click();
//        }
//        Locator locator = page.locator("//h1[text()='Your Wish List is empty']");
//        if (locator.textContent().equals("Your Wish List is empty")) {
//            page.locator("//i[@class='icon-close text-xl']").click();
//            page.locator("//i[@class='icon-close']").click();
//        }


    }

    public void chooseCategoryForShopping(String category) throws InterruptedException {
        Thread.sleep(5000);
        Locator locator = page.locator(Locators.hoverCatgery);
       // WebActions.waitUntilElementDisplayed(locator, 25);
        locator.hover();

    }

    public void chooseSubCategory(String subcategory) throws InterruptedException {
        Locator locator = page.locator(Locators.Subcategory);
        WebActions.waitUntilElementDisplayed(locator, 15);
        locator.click();
    }

    public void addToWishList() throws InterruptedException {
        Locator locator = page.locator(Locators.addtolist);
        WebActions.waitUntilElementDisplayed(locator, 25);
        locator.click();
        Thread.sleep(5000);
    }

    public Locator addSucess() throws InterruptedException {
      Locator locator=  page.locator(Locators.addsucess);
        return locator;


    }


}