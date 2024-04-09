package utils;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;

public class Locators {
    public static String loginIcon = "//img[@id='account-link']";
    public static String countrySelect="//input[@class='p-inputtext p-component']";
    public static String btnStartShoping="//BUTTON[text()='Start Shopping']";
    public static String loginSelectCountry="//input[@class='p-inputtext p-component']";
    public static String SelectCountryIcon = "(//SPAN[@class='p-dropdown-trigger-icon p-clickable pi pi-chevron-down'])[1]";

    public static String CountryIcon = "//li[@aria-label='%s']";
    public static String TestSucces ="//div[text()='You are logged in!']";
    public static String btnAcceptAll ="#usercentrics-root  button[data-testid='uc-accept-all-button']";
    public static String EmailField = "//INPUT[@class='p-inputtext p-component font-gill']";
    public static String PwdField = "//INPUT[@type='password']";
    public static String logbutton = "//button[@aria-label='Log in to your Account']";

    public static String  Subcategory ="//a[@href='/biscuits/all-biscuits/caramel']";

public static String bntok ="//div[text()='You are logged in!']";
    public static String hoverCatgery="//a[@href='/biscuits-category'][text()='Biscuits']";
    public static String addtolist ="//div[@data-sku='2189412']//i[@class='icon-wishlist']";
    public static String addsucess ="//DIV[@class='message product flex-1 px-[13px] pb-[20px] text-center lg_mt-[-10px]'][text()='Added to Your Wishlist']";
    public static String wishlist ="//img[@src='/main-nav-icons_wishlist-filled-7Ju.svg']";
    public static String deletewishlist = "//i[@class='icon-close text-xl']";
    public static String closeicon = "//i[@class='icon-close']";
}