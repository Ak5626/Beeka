package pages;

import org.openqa.selenium.By;
import utils.Waitutils;
import utils.utility;


import static utils.DriverFactory.driver;


public class homepage {

    public static String langConfirmation = null;
    public boolean logoVal;
    private static final By acceptCookies = By.xpath("//button[contains(text(),'Cookies accepteren')]");
    private static final By logo = By.xpath("//img[@class='logo-desktop']");
    private static final By eng = By.xpath("//a[@lang='en' and @data-value='en']");
    private static final By dutch = By.xpath("//a[@lang='nl' and @data-value='nl']");
    private static final By rejectPopUp = By.xpath("//button[@type='button' and @class='modal__close | js-modal-close']");
    public static final By engLang = By.xpath("//a[text()='Find a store']");
    public static final By dutchLang = By.xpath("//a[text()='Verkooppunten']");
    private static final By footerLogo = By.xpath("//footer[@class='page-footer']/div/div/div/div/a");
    public static final By headerLangOpt = By.xpath("//li[@class='top-nav__list-item top-nav__localisation']/form");
    public static final By changeOptToDutch = By.xpath("//ul[@id='lang-list']/li/a[@data-value='nl']");
    public static final By changeOptToEng = By.xpath("//ul[@id='lang-list']/li/a[@data-value='en']");
    private static final By rejectPopUp1 = By.xpath("//button[@aria-label='Close dialog']");

    public void validateHomepage() {
        Waitutils.waitCond(driver, driver.findElement(acceptCookies));
        driver.findElement(acceptCookies).click();
        Waitutils.waitCond(driver, driver.findElement(rejectPopUp));
        driver.findElement(rejectPopUp).click();
        Waitutils.waitCond(driver, driver.findElement(rejectPopUp1));
        driver.findElement(rejectPopUp1).click();
        try {
            if (utility.ElePresent(driver.findElement(engLang))) {
                System.out.println("Homepage is loaded with Language \"English\"");
                langConfirmation = "eng";
            }
        } catch (Exception e) {
            try {
                if (utility.ElePresent(driver.findElement(dutchLang))) {
                    System.out.println("Homepage is loaded with Language \"Dutch\"");
                    langConfirmation = "dutch";

                }
            } catch (Exception t) {
                System.out.println("Homepage is loaded with different language");
            }
        }
    }


    public boolean validateLogoHeader() {
        logoVal = utility.ElePresent(driver.findElement(logo));
        return logoVal;
    }

    public boolean validateSwitchLanguage() {

        Waitutils.waitCond(driver, driver.findElement(headerLangOpt));
        driver.findElement(headerLangOpt).click();
        try {
            By changeLang;
            By verifyLang;
            String message;

            if (langConfirmation.equalsIgnoreCase("eng")) {
                changeLang = changeOptToDutch;
                verifyLang = dutchLang;
                message = "Switched to Dutch Language";
            } else if (langConfirmation.equalsIgnoreCase("dutch")) {
                changeLang = changeOptToEng;
                verifyLang = engLang;
                message = "Switched to English Language";

            } else {
                return false;
            }
            driver.findElement(changeLang).click();
            Waitutils.waitCond(driver, driver.findElement(verifyLang));
            boolean lang = utility.ElePresent(driver.findElement(verifyLang));
            System.out.println(message);
            return lang;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean validateLogoFooter() {
        utility.jsExecutorForScroll(driver.findElement(footerLogo));
        logoVal = utility.ElePresent(driver.findElement(footerLogo));
        return logoVal;
    }


}
