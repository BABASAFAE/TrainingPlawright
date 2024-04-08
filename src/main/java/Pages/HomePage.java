package Pages;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import utils.ConfigReader;
import utils.Locators;
import utils.Utils;
import utils.WebActions;

import java.sql.Time;
import java.util.List;
import java.util.Map;

import static utils.Locators.*;

public class HomePage {
    private Page page;

    public HomePage(Page page) {
        this.page = page;
    }

    public void removeCookiePopup() throws InterruptedException {
             Thread.sleep(2000);
        try {
            Locator BTNACCEPT = page.locator(btnAcceptAll);

            //WebActions.waitUntilElementDisplayed(BTNACCEPT, 10);
            BTNACCEPT.click();
            Utils.logger.info("'usercentrics-root ' element accept cookie.");
        } catch (PlaywrightException e) {
            Utils.logger.info("Exception occurred: " + e.getMessage());
        }

    }

    public void chooseCountryForShopping(String country) throws InterruptedException {
        Locator  CountryShopping  = page.locator(SelectCountryIcon);
        WebActions.waitUntilElementDisplayed(CountryShopping, 20);
        CountryShopping.click();
        Locator  inputCountryShopping = page.locator(loginSelectCountry);
        inputCountryShopping.click();
        Locator optionDropDown = page.locator(String.format(moveWishList, country));
            optionDropDown.click();

        Locator validateCountryShopping = page.locator(btnStartShoping);
        validateCountryShopping.click();
    }

    public void accessToLogin() throws InterruptedException {
        Locator loginIconLocator = page.locator(loginIcon);

        WebActions.waitUntilElementDisplayed(loginIconLocator, 5);
        loginIconLocator.click();


    }

 /*  public void PageLogin() throws InterruptedException {
        Locator inputemail=page.locator(Locators.EmailField);
        WebActions.waitUntilElementDisplayed(inputemail, 5);
        Locator inputpwd=page.locator(Locators.PwdField);
        List<Map<String, String>> userData = ConfigReader.csvToMap(WebActions.getProperty("csvPath"));
        Locator inputlog=page.locator(Locators.logbutton);
        for (Map<String, String> row : userData) {
            String emailValid = row.get("username");
            String password = row.get("password");
            WebActions.waitUntilElementDisplayed(inputemail, 10);
            inputemail.fill(emailValid);
           inputpwd.fill(password);
            inputlog.click();

        }

*/


     public Locator SuccesLogin() {
        return page.locator(TestSucces);
    }


    public void AccountPage(){
        Locator loginIconLocator = page.locator(loginIcon);
        WebActions.waitUntilElementDisplayed(loginIconLocator, 5);
        loginIconLocator.click();
       // optionDetailsLocator.click();
    }

    public void choosethecaterory(String catergory) throws InterruptedException {
        Locator choosethecategory  = page.locator(SelectCateg);
        WebActions.waitUntilElementDisplayed(choosethecategory, 20);
      //  SelectCateg.hover();

    }

    public void userHoverTheCategory(String arg0) throws InterruptedException {
        Locator locatorCategorie = page.locator(Locators.locatorCategorie);
       // WebActions.waitUntilElementDisplayed(locatorCategorie, 200);

        locatorCategorie.hover();
        Thread.sleep(2000);

    }

    public void userChooseTheSubCategory(String arg0) throws InterruptedException {
        Locator locatorsubgategory= page.locator(Locators.locatorsubgategory);
         locatorsubgategory.click();
        Thread.sleep(2000);
    }

    public String retrieveProductPrice(String arg0) throws InterruptedException {

        //  Locator priceFromPLP= page.locator(Locators.locatorsubgategory);
           Locator retrieveproduct = page.locator(iconretrieveproduct);
           String priceProduct = retrieveproduct.textContent();
           //   Locator  priceFromPLP = page.locator(Locators.iconretrieveproduct);
           //retrieveproduct.hover();
           Thread.sleep(2000);


        return  priceProduct;
    }

    public void addProduct(String arg0) throws InterruptedException {
        Locator addtobag= page.locator(Locators.addtobag);
         addtobag.click();
         Thread.sleep(2000);

    }

       public String checkbag() throws InterruptedException {
          Locator iconcheckbag= page.locator(Locators.iconcheckbag);
          iconcheckbag.click();
           Thread.sleep(2000);
           //locator = price of product to bag
            Locator iconpricebag= page.locator(Locators.iconpricebag);
            String priceProduct = iconpricebag.textContent();
            Utils.logger.info("message validé"+priceProduct);
             return priceProduct;

    }


}