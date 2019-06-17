/*
 * Creation : 1 avr. 2019
 */
package Peugeot;

import org.openqa.selenium.By;
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
    public void TheLeadHAvebeenSubmittedForPeugeotFrance() {

        driver.get(
                "http://fr.store.peugeot.inetpsa.com/contactsolv0?lat=48.856614&lng=2.3522219000000177&Cit=Paris%2C%20France&etd=0&mbd=1PI4S0000146;&carNum=R-WC7733&VehListIndex=4%7c454");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.findElement(By.className("psac_noselect")).click();
        LeadsAP.FillContactFormFrance(driver);
        LeadsAP.ClickSubmitButton(driver);
        assert (LeadsAP.GetTheConfirmationMessage(driver) == true);
        driver.close();

    }

    @Test(priority = 2)
    public void TheLeadHAvebeenSubmittedForPeugeotSpain() {

        driver.get(
                "http://es.store.peugeot.inetpsa.com/contactsolv0?lat=40.4167754&lng=-3.7037901999999576&Cit=Madrid%2C%20Espa%C3%B1a&etd=0&mbd=1PIA0SIL0A50;&carNum=R-642850&VehListIndex=1%7c153");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        // driver.findElement(By.className("psac_noselect")).click();
        LeadsAP.FillContactFormSpain(driver);
        LeadsAP.ClickSubmitButton(driver);
        assert (LeadsAP.GetTheConfirmationMessage(driver) == true);
        driver.close();

    }

    @Test(priority = 3)
    public void TheLeadHAvebeenSubmittedForPeugeotItaly() {

        driver.get(
                "http://it.store.peugeot.inetpsa.com/contactsolv0?lat=41.9027835&lng=12.496365500000024&Cit=Roma%20RM%2C%20Italia&etd=0&mbd=1PI4SSU00000;&carNum=R-759160&VehListIndex=1%7c561");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        // driver.findElement(By.className("psac_noselect")).click();
        LeadsAP.FillContactFormItaly(driver);
        LeadsAP.ClickSubmitButton(driver);
        assert (LeadsAP.GetTheConfirmationMessage(driver) == true);
        driver.close();

    }

    @Test(priority = 4)
    public void TheLeadHAvebeenSubmittedForPeugeotBelgiumFR() {

        driver.get(
                "http://be.store.peugeot.inetpsa.com/fr/contactsolv0?mbd=1PI4S0000054;&Version=1PI4SYLLEJB0A0G1&Options=RS06WLP4&Color=0MM00NVL&Trim=0P590RFX&VehListIndex=1%7c132");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        // driver.findElement(By.className("psac_noselect")).click();
        LeadsAP.FillContactFormBelgiumFR(driver);
        LeadsAP.ClickSubmitButton(driver);
        assert (LeadsAP.GetTheConfirmationMessage(driver) == true);
        driver.close();

    }

    @Test(priority = 5)
    public void TheLeadHAvebeenSubmittedForPeugeotBelgiumNL() {

        driver.get(
                "http://be.store.peugeot.inetpsa.com/nl/contactsolv0?mbd=1PT9S0000097;&Version=1PT9A5WLUKB0A0D0&Options=AB13QK02UN01WLF6YR07&Color=0MM00NF4&Trim=0P0J0RFJ&VehListIndex=1%7c2");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        // driver.findElement(By.className("psac_noselect")).click();
        LeadsAP.FillContactFormBelgiumNL(driver);
        LeadsAP.ClickSubmitButton(driver);
        assert (LeadsAP.GetTheConfirmationMessage(driver) == true);
        driver.close();

    }

    @Ignore
    public void TheLeadHAvebeenSubmittedForPeugeotSwidzerland() {

        driver.get(
                "http://be.store.peugeot.inetpsa.com/fr/contactsolv0?mbd=1PI4S0000054;&Version=1PI4SYLLEJB0A0G1&Options=RS06WLP4&Color=0MM00NVL&Trim=0P590RFX&VehListIndex=1%7c132");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.findElement(By.className("psac_noselect")).click();
        LeadsAP.FillContactFormSwidzerland(driver);
        LeadsAP.ClickSubmitButton(driver);
        assert (LeadsAP.GetTheConfirmationMessage(driver) == true);
        driver.close();

    }

}
