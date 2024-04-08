package Pages;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import utils.Locators;
import utils.Utils;
import utils.WebActions;

import java.util.Arrays;
import java.util.Collections;

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
    public void accessToLogin(){
        Locator  loginIconLocator = page.locator(Locators.loginIcon);
        WebActions.waitUntilElementDisplayed(loginIconLocator, 20);
        loginIconLocator.click();
        System.out.println("test ajoute");


    }
}
