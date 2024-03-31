package hooks;

import Factory.DriverFactory;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.LoadState;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import utils.Utils;
import utils.WebActions;

import java.io.IOException;

public class Hooks {
    public static final String BROWSER = "browser";
    public static final String ENV = "env";
    public DriverFactory driverFactory;
    public Page page;



    @Before
    public void launchBrowser() {

        String browserName = WebActions.getProperty(BROWSER);
        driverFactory = new DriverFactory();
        page = driverFactory.initDriver(browserName);
        openEnvUrl(System.getProperty(ENV));
    }


    private void openEnvUrl(String env) {
        String urlEnv;
        if (env == null) env = "";
        switch (env) {
            case "prod":
                urlEnv = "prod";
                break;
            case "prp":
                urlEnv = "preprod";
                break;
            case "itg":
                urlEnv = "integration";
                break;
            case "cons":
                urlEnv = "cons";
                break;
            default:
                urlEnv = "preprod";
        }
        page.navigate(WebActions.getProperty("url." + urlEnv));
    }

    @After
    public void quitBrowser() {
        page.close();
        driverFactory.closeContext();
    }


}

