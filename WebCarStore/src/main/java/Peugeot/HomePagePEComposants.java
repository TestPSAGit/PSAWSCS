/*
 * Creation : 8 avr. 2019
 */
package Peugeot;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import Methodes.WaitS;

public class HomePagePEComposants {

    static String CheckTitlePresent(WebDriver driver) {

        return driver.findElement(By.xpath("//a[contains(text(),'STORE')]")).getText();

    }

    static boolean CheckLogoPresent(WebDriver driver) {

        return driver.findElement(By.xpath("//img[@class='Peugeot_lion']")).isDisplayed();
    }

    static boolean CheckLogoMysavePresent(WebDriver driver) {

        return driver.findElement(By.xpath("//div[@class='ico-menu-mysave']")).isDisplayed();
    }

    static String CheckTextMysavePresent(WebDriver driver, String xpath) {

        return driver.findElement(By.xpath(xpath)).getText();
    }

    static boolean CheckLogoBesoinDaidePresent(WebDriver driver) {

        return driver.findElement(By.xpath("//div[@class='ico-menu-tel']")).isDisplayed();
    }

    static String CheckTextBesoinDaidePresent(WebDriver driver) {

        return driver.findElement(By.xpath("/html[1]/body[1]/header[1]/nav[1]/ul[1]/li[2]/a[1]/span[1]")).getText();
    }

    static String CheckTextUnderTitlePresent(WebDriver driver) {

        return driver.findElement(By.xpath("/html[1]/body[1]/header[1]/nav[1]/div[3]/div[2]/a[1]")).getText();
    }

    static String CheckClickOnHeaderPeugeotLogo(WebDriver driver) {

        driver.findElement(By.xpath("//img[@class='Peugeot_lion']")).click();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        String CURL = driver.getCurrentUrl();
        driver.navigate().back();
        return CURL;

    }

    static boolean CheckClickOnNeedHelpLogo(WebDriver driver) {

        driver.findElement(By.xpath("//div[@class='ico-menu-tel']")).click();
        WaitS.Wait(3000);
        boolean BO = driver.findElement(By.xpath("//div[@class='tingle-modal-box__content']//div[@class='ico-call-blue']")).isDisplayed();
        driver.findElement(By.xpath("//span[@class='tingle-modal__closeIcon']")).click();
        return BO;

    }

    static boolean CheckTheTwiterIconePresence(WebDriver driver) {

        return driver.findElement(By.xpath("//div[@class='ico-tweeter']")).isDisplayed();
    }

    static boolean CheckTheFacebookIconePresence(WebDriver driver) {

        return driver.findElement(By.xpath("//div[@class='ico-facebook']")).isDisplayed();
    }

    static boolean CheckTheYoutubeIconePresence(WebDriver driver) {

        return driver.findElement(By.xpath("//div[@class='ico-youtube']")).isDisplayed();
    }

    static String CheckClickOnTwiterIcone(WebDriver driver) {

        driver.findElement(By.xpath("//div[@class='ico-tweeter']")).click();
        WaitS.Wait(3000);
        SwitchToCurrentUrl(driver);
        String CurretURL = driver.getCurrentUrl();
        driver.close();
        return CurretURL;

    }

    static String CheckClickOnFacebookIcone(WebDriver driver) {

        SwitchToCurrentUrl(driver);
        driver.findElement(By.xpath("//div[@class='ico-facebook']")).click();
        WaitS.Wait(3000);
        SwitchToCurrentUrl(driver);
        String CurretURL = driver.getCurrentUrl();
        driver.close();
        return CurretURL;
    }

    static String CheckClickOnYoutubeIcone(WebDriver driver) {

        SwitchToCurrentUrl(driver);
        driver.findElement(By.xpath("//div[@class='ico-youtube']")).click();
        WaitS.Wait(3000);
        SwitchToCurrentUrl(driver);
        String CurretURL = driver.getCurrentUrl();
        driver.close();
        return CurretURL;

    }

    static boolean CheckTheUserGeneralConditionsTextPresence(WebDriver driver, String xpath) {
        SwitchToCurrentUrl(driver);
        return driver.findElement(By.xpath(xpath)).isDisplayed();
    }

    static boolean CheckThesellGeneralConditionsTextPresence(WebDriver driver, String xpath) {

        return driver.findElement(By.xpath(xpath)).isDisplayed();
    }

    static boolean CheckTheCookiestextPresence(WebDriver driver) {

        return driver.findElement(By.xpath("//a[@class='_psaihm_app_oppen_params']")).isDisplayed();
    }

    static String CheckClickOnUserGeneralConditions(WebDriver driver, String xpath) {

        SwitchToCurrentUrl(driver);
        driver.findElement(By.xpath(xpath)).click();
        WaitS.Wait(3000);
        SwitchToCurrentUrl(driver);
        String CurretURL = driver.getCurrentUrl();
        driver.close();
        return CurretURL;

    }

    static String CheckClickOnsellGeneralConditions(WebDriver driver, String xpath) {

        SwitchToCurrentUrl(driver);
        driver.findElement(By.xpath(xpath)).click();
        WaitS.Wait(3000);
        SwitchToCurrentUrl(driver);
        String CurretURL = driver.getCurrentUrl();
        driver.close();
        return CurretURL;
    }

    static boolean CheckClickOnCookies(WebDriver driver) {
        SwitchToCurrentUrl(driver);
        driver.findElement(By.xpath("//a[@class='_psaihm_app_oppen_params']")).click();
        WaitS.Wait(3000);
        boolean BO = driver.findElement(By.xpath("//p[@id='_psaihm_title']")).isDisplayed();
        driver.findElement(By.id("_psaihm_button_param_accept")).click();
        return BO;

    }

    static void SwitchToCurrentUrl(WebDriver driver) {

        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

    }

    static void CloseCokies(WebDriver driver) {
        try {
            driver.findElement(By.className("psac_noselect")).click();
        } catch (NoSuchElementException e) {
        }
    }
}