/*
 * Creation : 28 mai 2019
 */
package Peugeot;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.InitialiseDrivers;

public class ProductPageTest {
    static WebDriver driver;
    static Date DeliveryDate;
    static Date currentDate;
    static int[] OffersNum;
    static int[] OffersNum1;
    static int Error;

    public void InitialiseUrl(String URL) {

        driver = InitialiseDrivers.InitialiseChromDriver();
        driver.get(URL);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        try {
            driver.findElement(By.className("psac_noselect")).click();
        } catch (NoSuchElementException e) {
            // System.out.println("Impossible to click the pop-up. Reason");
        }

        ProductPage.ClickOnCarDetails(driver);

    }

    @Test(dataProvider = "UrlsProvider", priority = 1)
    public void ThePriceInTheProductPageIsEqualToThePriceInThePopoup(String URL) {
        InitialiseUrl(URL);

        ProductPage.ClickOnPriceDetails(driver);
        int PTTCPP = ProductPage.GetTheTTCPriceFromTheProductPage(driver);
        int PTTCHO = ProductPage.GetTheTTCHOptionPriceFromThePopUp(driver);
        int PTTCPO = ProductPage.GetTheTTCPriceFromThePopUp(driver);

        System.out.println(ProductPage.GetTheTTCPriceFromTheProductPage(driver));
        System.out.println(ProductPage.GetTheTTCHOptionPriceFromThePopUp(driver));
        System.out.println(ProductPage.GetTheTTCPriceFromThePopUp(driver));
        ProductPage.ClosePriceDetailsPopUp(driver);

        assert (PTTCPP == PTTCPO);

    }

    @Test(dataProvider = "UrlsProvider", priority = 2)
    public void ThePriceeforeOptionsIsLowerThanTheTTCPrice(String URL) {

        ProductPage.ClickOnPriceDetails(driver);
        int PTTCPP = ProductPage.GetTheTTCPriceFromTheProductPage(driver);
        int PTTCHO = ProductPage.GetTheTTCHOptionPriceFromThePopUp(driver);
        int PTTCAO = ProductPage.GetTheTTCPriceFromThePopUp(driver);
        System.out.println(ProductPage.GetTheTTCPriceFromTheProductPage(driver));
        System.out.println(ProductPage.GetTheTTCHOptionPriceFromThePopUp(driver));
        System.out.println(ProductPage.GetTheTTCPriceFromThePopUp(driver));

        ProductPage.ClosePriceDetailsPopUp(driver);

        assert (PTTCHO < PTTCAO);

    }

    @Test(dataProvider = "UrlsProvider", priority = 3)
    public void ThePopupPriceDetailsCanBeOpened(String URL) {

        ProductPage.ClickOnPriceDetails(driver);
        assert (ProductPage.GetThePopupPriceDetailsTitle(driver) == true);
        ProductPage.ClosePriceDetailsPopUp(driver);

    }

    @Test(dataProvider = "UrlsProvider", priority = 4)
    public void ThePopupPriceDetailsCanBeClosed(String URL) {

        ProductPage.ClickOnPriceDetails(driver);
        assert (ProductPage.ThePopupPriceDetailsCloseCrossIsClickable(driver) == true);
        ProductPage.ClosePriceDetailsPopUp(driver);

    }

    @Test(dataProvider = "UrlsProvider", priority = 5)
    public void ThePriceEstimationCanBeOpened(String URL) {

        ProductPage.OpenEstimation(driver);
        assert (ProductPage.ThePopupPriceDetailsCloseCrossIsClickable(driver) == true);
        ProductPage.CloseEstimation(driver);

    }

    @Test(dataProvider = "UrlsProvider", priority = 6)
    public void ThePriceEstimationCanBeClosed(String URL) {

        ProductPage.OpenEstimation(driver);
        assert (ProductPage.ThePopupEstimationCloseCrossIsClickable(driver) == true);
        ProductPage.CloseEstimation(driver);

    }

    @DataProvider(name = "UrlsProvider")
    public Object[] UrlsTobeTested1() {

        Object[] URLS = new Object[] {
                "http://fr.store.peugeot.inetpsa.com/Recherche-par-critere?lat=48.856614&lng=2.3522219000000177&LocationL=Paris%2C%20France&etd=0&mbd=1PT9S0000030",
                "http://fr.store.peugeot.inetpsa.com/Recherche-par-critere?lat=48.856614&lng=2.3522219000000177&LocationL=Paris%2C%20France&etd=0&mbd=1PP7S0000146" };
        return URLS;
    }
}
