package utils;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.logging.Logger;

public class Utils {
    private Page page;
    public static final Logger logger = Logger.getLogger(Utils.class.getName());

    public Utils(Page page) {
        this.page = page;
    }



}
