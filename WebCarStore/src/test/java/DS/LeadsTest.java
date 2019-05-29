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

import Utilities.InitialiseDrivers;

public class LeadsTest {
    static WebDriver driver;

    @BeforeMethod
    public void BeforeTest() {
        driver = InitialiseDrivers.InitialiseChromDriver();
    }

    @Test(priority = 1)
    public void TheLeadHAvebeenSubmittedForDSFrance() {

        driver.get(
                "http://E562418:Id133499@fr.store.ds.inetpsa.com/ds-3-cabrio/cabrio-3p/contactsolv0?lat=48.85661400000001&lng=2.3522219000000177&Cit=Paris&mbd=1WWWzzzzzzzz;1WWW00000006;&carNum=R-NC9035&VehListIndex=1%7c2&screenWidth=1349&idFirstDealer=0000051132");

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
    public void TheLeadHAvebeenSubmittedForDSSpain() {

        driver.get(
                "http://E562418:Id133499@es.store.ds.inetpsa.com/ds-7-crossback/suv/contactsolv0?mbd=1SX800000021;1CYA00000001;&Version=1SX8SULMA1B0A012&Options=GM86HU02KK02RS02ZHFF&color=0MM00N9V&trim=0P550RFX&VehListIndex=1%7c371&screenWidth=1349");
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

    @Test(priority = 3)
    public void TheLeadHAvebeenSubmittedForDSItaly() {

        driver.get(
                "https://E562418:Id133499@dsonlinestore.dsautomobiles.it/ds-3/citycar-compatte/contactsolv0?lat=41.90278349999999&lng=12.496365500000024&Cit=Rome%2C%20RM&mbd=1VVV00000002;1CYA00000001;&carNum=R-002668&VehListIndex=1%7c1&screenWidth=1349&idFirstDealer=0000051417");
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

    @Test(priority = 4)
    public void TheLeadHAvebeenSubmittedForDSBelgiumFR() {

        driver.get(
                "https://E562418:Id133499@dsonlinestore.dsautomobiles.be/fr/ds3/berline-3d/contactsolv0?mbd=1HHHSILHDS3C;1QQQSILHOU3P;&Version=1QQQA3QLGQ04A050&Options=RS02UB02WD31WLL3YR05&color=0MM20NEX&trim=0P3R0RFW&VehListIndex=1%7c9&screenWidth=1349");
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

    @Test(priority = 5)
    public void TheLeadHAvebeenSubmittedForDSBelgiumNL() {

        driver.get(
                "https://E562418:Id133499@dsonlinestore.dsautomobiles.be/nl/ds3/berline-3d/contactsolv0?mbd=1HHHSILHDS3C;1QQQSILHOU3P;&Version=1QQQA3QLGQ04A050&Options=RS02UB02WD31WLL3YR05&color=0MM20NEX&trim=0P3R0RFW&VehListIndex=1%7c9&screenWidth=1349");
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
