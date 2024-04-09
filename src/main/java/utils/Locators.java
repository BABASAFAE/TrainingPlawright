package utils;

public class Locators {
    public static String loginIcon = "//img[@id='account-link']";
    public static String arrowIcon ="(//SPAN[@class='p-dropdown-trigger-icon p-clickable pi pi-chevron-down'])[1]";
    public static String choiceCountryField ="//INPUT[@class='p-inputtext p-component']";
    public static String buttonStartShopping ="//BUTTON[text()='Start Shopping']";
    public static String mailLoginField ="//INPUT[@class='p-inputtext p-component font-gill']";
    public static String passwordLoginField ="//INPUT[@type='password']";
    //public static String buttonLogin="(//DIV[@class='button-container '])[2]";
    public static String buttonLogin="//button[@aria-label='Log in to your Account']";
    public static String popUpLoggedInSuccessful="//DIV[text()='You are logged in!']";
    public static String moveWishList="//LI[@class='p-dropdown-item'][text()='%s']";
    public static String LinkToResetPasswordPage="//span[contains(@class,'forgot-password font-nova')]";
    public static String EmailFieldOfResetPassword="//input[@class='p-inputtext p-component']";
    public static String ButtonOfResetPassword="//span[text()='Reset Password']";
    public static String MessageAfficheForResetPassword="//div[@class='forgot-password-wrapper']//p[1]";
    public static String ButtonBackToHomeFromResetPasswordPage="//span[text()='Back to login']";
    public static String WebSiteOfYopMail="https://yopmail.com/fr/";
    public static String InputFieldOfYopMail="//input[@id=\"login\"]";
    public static String ButtonGoInsidYopMail="//div[@id='refreshbut']//button";
    public static String IframeOfYopMailMessage="//iframe[@name='ifmail']";
    public static String ButtonForGoToPageResetPassword="//div[@id='mail']//a[text()='Set a New Password']";
    public static String NewPasswordField="//input[@name='password']";
    public static String RepeatPassword="//input[@name='repeatPassword']";
    public static String ButounSaveNewPassword="//button[@aria-label='Save New password']";
    public static String NewPassword="(//label[text()='Email']/following::input)[2]";
    public static String messageOfConfirmationThePasswordResetSuccefuly="//div[text()='Your password has been reset successfully!']";
    public static String refreshButtonOfYopMail="//button[@id='refresh']";
    public static String buttonChangeBasswordInAcount="//button[@aria-label='Change Your Password']";
    public static String feildSubscribeEmail="//input[@id='subscription-email']";
    public static String messageOfSuccessfullySubscribed="//div[text()='Thank you for your subscription.']";
    public static String loctorOfPopup="//div[contains(@class,'message-button-wrapper flex')]";
    public static String selctedCountry="//select[@name='country']";
    public static String generalInterest="//select[@name='general_interest']";
    public static String productInterest="//select[@name='product_interest']";
    public static String buttonOfSubscribe="//span[text()='Sign Up']";
}
