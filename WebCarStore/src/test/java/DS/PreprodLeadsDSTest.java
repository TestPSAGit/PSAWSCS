/*
 * Creation : 1 avr. 2019
 */
package DS;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import Peugeot.InitialiseDrivers;

public class PreprodLeadsDSTest {
    static WebDriver driver;

    @BeforeMethod
    public void BeforeTest() {
        driver = InitialiseDrivers.InitialiseChromDriver();
    }

    @Test(priority = 1)
    public void TheLeadHAvebeenSubmittedForPeugeotFrance() {

        driver.get(
                "https://E562418:Id133499@fr-store-preprod.dsautomobiles.com/ds4/ds-4-crossback/contactsolv0?lat=48.85661400000001&lng=2.3522219000000177&Cit=Paris&mbd=1ZZZ00000008;1CYA00000005;1ZZZ00000013;&carNum=R-LJ8430&VehListIndex=1%7c1&screenWidth=1903&idFirstDealer=0000051125");

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        try {
            driver.findElement(By.className("psac_noselect")).click();
        } catch (NoSuchElementException e) {
        }
        LeadsDS.FillContactFormFrance(driver);
        LeadsDS.ClickSubmitButton(driver);
        assert (LeadsDS.GetTheConfirmationMessage(driver) == true);
        driver.close();
    }

    @Test(priority = 2)
    public void TheLeadHAvebeenSubmittedForPeugeotSpain() {

        driver.get(
                "http://E562418:Id133499@es.store.ds.preprod.inetpsa.com/ds-3-ds-3-cabrio/3-puertas-coupe/contactsolv0?mbd=1WWW00000019;1CYA00000001;1ZZZ00000015;&Version=1CYAA3PKQ504A047&Options=RS02WLNNZH15&color=0MP00NWP&trim=0P3R0RFW&VehListIndex=1%7c66&screenWidth=1903");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        try {
            driver.findElement(By.className("psac_noselect")).click();
        } catch (NoSuchElementException e) {
        }
        LeadsDS.FillContactFormSpain(driver);
        LeadsDS.ClickSubmitButton(driver);
        assert (LeadsDS.GetTheConfirmationMessage(driver) == true);
        driver.close();

    }

    @Ignore
    public void TheLeadHAvebeenSubmittedForPeugeotItaly() {

        driver.get(
                "https://E562418:Id133499@it-store-preprod.citroen.com/c1/citycar-compatte/contactsolv0?lat=45.4064349&lng=11.876761100000067&Cit=Padova%2C%20PD&mbd=1CB100000006;1CB100000001;1CBO00000002;&carNum=R-818988&VehListIndex=1%7c15&screenWidth=1903&idFirstDealer=264028");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        try {
            driver.findElement(By.className("psac_noselect")).click();
        } catch (NoSuchElementException e) {
        }
        LeadsDS.FillContactFormItaly(driver);
        LeadsDS.ClickSubmitButton(driver);
        assert (LeadsDS.GetTheConfirmationMessage(driver) == true);
        driver.close();

    }

    @Ignore
    public void TheLeadHAvebeenSubmittedForPeugeotBelgiumFR() {

        driver.get(
                "http://be.store.citroen.preprod.inetpsa.com/fr/e-mehari/e-mehari-cabrio/contactsolv0?mbd=1CBOSILHMCAB;1CB1SILAIR5P;1CB1SILHOU3P;&Version=1CBOE2HEA0B0A010&Options=RE01&color=0MM00NEU&trim=0PI50RFC&VehListIndex=1%7c6&screenWidth=1349");
        try {
            driver.findElement(By.className("psac_noselect")).click();
        } catch (NoSuchElementException e) {
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        LeadsDS.FillContactFormBelgiumFR(driver);
        LeadsDS.ClickSubmitButton(driver);
        assert (LeadsDS.GetTheConfirmationMessage(driver) == true);
        driver.close();

    }

    @Ignore
    public void TheLeadHAvebeenSubmittedForPeugeotBelgiumNL() {

        driver.get(
                "http://be.store.citroen.preprod.inetpsa.com/nl/e-mehari/e-mehari-cabrio/contactsolv0?mbd=1CBOSILHMCAB;1CB1SILAIR5P;1CB1SILHOU3P;&Version=1CBOE2HEA0B0A010&Options=RE01&color=0MM00NEU&trim=0PI50RFC&VehListIndex=1%7c6&screenWidth=1349");
        try {
            driver.findElement(By.className("psac_noselect")).click();
        } catch (NoSuchElementException e) {
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        LeadsDS.FillContactFormBelgiumNL(driver);
        LeadsDS.ClickSubmitButton(driver);
        assert (LeadsDS.GetTheConfirmationMessage(driver) == true);
        driver.close();

    }

    @Ignore
    public void TheLeadHAvebeenSubmittedForPeugeotSwidzerland() {

        driver.get(
                "http://ch.store.peugeot.recette.inetpsa.com/fr/contactsolv0?lat=46.2043907&lng=6.143157699999961&Cit=Gen%C3%A8ve%2C%20Suisse&etd=0&mbd=1PW2SILSW001;&MinPrice=NaN&MaxPrice=NaN&carNum=R-652606&VehListIndex=1%7c1");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        try {
            driver.findElement(By.className("psac_noselect")).click();
        } catch (NoSuchElementException e) {
        }
        LeadsDS.FillContactFormSwidzerland(driver);
        LeadsDS.ClickSubmitButton(driver);
        assert (LeadsDS.GetTheConfirmationMessage(driver) == true);
        driver.close();

    }

}
