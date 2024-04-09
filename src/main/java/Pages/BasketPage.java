package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utils.Utils;

public class BasketPage {
    private Page page;

    public BasketPage(Page page) {
        this.page = page;
    }

    public void hoversEverTheCategory(String category) {
        Locator giftsCategory = page.locator("//nav//a[@href='/gifts-occasions-category'][text()='Gifts']");
        giftsCategory.hover();
    }

    public void chooseSubCategory(String subcategory) {
        Locator subCategoryBirthdays = page.locator("//a[contains(@href,'/birthday')][text()='Birthdays']");
        subCategoryBirthdays.click();
    }

    public void addProdcutToTheBag() {
        Locator addToBagButton = page.locator("//div[@data-sku='5120245']//button//span[contains(text(),'Add')]");
        addToBagButton.click();
    }

    public void userGoToTheBag() {
        Locator basketButton = page.locator("//button[@id='basket-btn']");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        basketButton.dblclick();
    }

    public void selectNewCountryFromDropDown(String country) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Utils.logger.info("Selecting country: " + country);
        Locator countryOption = page.locator("//div[@class='w-full']//div[@role='listbox']//select");
        countryOption.selectOption(country);
    }

    public void messageOfCantDeliver() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
