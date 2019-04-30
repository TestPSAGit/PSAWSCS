/*
 * Creation : 1 avr. 2019
 */
package Peugeot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class ProdLeadsPeugeotTest {
    static WebDriver driver;

    @BeforeMethod
    public void BeforeTest() {
        driver = InitialiseDrivers.InitialiseChromDriver();
    }

    @Test(priority = 1)
    public void TheLeadHAvebeenSubmittedForPeugeotFrance() {

        driver.get(
                "http://fr.store.peugeot.inetpsa.com/contactsolv0?lat=48.856614&lng=2.3522219000000177&Cit=Paris%2C%20France&etd=0&mbd=1PB1S0000029;1PB1S0000030;&carNum=R-WB6307&VehListIndex=2%7c241");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.findElement(By.className("psac_noselect")).click();
        Leads.FillContactFormFrance(driver);
        Leads.ClickSubmitButton(driver);
        assert (Leads.GetTheConfirmationMessage(driver) == true);
        driver.close();

    }

    @Ignore
    public void TheLeadHAvebeenSubmittedForPeugeotSpain() {

        driver.get(
                "http://es.store.peugeot.inetpsa.com/contactsolv0?lat=40.4167754&lng=-3.7037901999999576&Cit=Madrid%2C%20Espa%C3%B1a&etd=0&mbd=1PIA0SIL0A50;&carNum=R-642850&VehListIndex=1%7c153");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        // driver.findElement(By.className("psac_noselect")).click();
        Leads.FillContactFormSpain(driver);
        Leads.ClickSubmitButton(driver);
        assert (Leads.GetTheConfirmationMessage(driver) == true);
        driver.close();

    }

    @Ignore
    public void TheLeadHAvebeenSubmittedForPeugeotItaly() {

        driver.get(
                "http://it.store.peugeot.inetpsa.com/contactsolv0?lat=46.2564381&lng=10.580823499999951&Cit=Passo%20del%20Tonale%2C%2025056%20Ponte%20di%20legno%20BS%2C%20Italia&etd=0&mbd=1PIAS3P00000;&carNum=R-643377&VehListIndex=1%7c30");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        // driver.findElement(By.className("psac_noselect")).click();
        Leads.FillContactFormItaly(driver);
        Leads.ClickSubmitButton(driver);
        assert (Leads.GetTheConfirmationMessage(driver) == true);
        driver.close();

    }

    @Ignore
    public void TheLeadHAvebeenSubmittedForPeugeotBelgiumFR() {

        driver.get(
                "http://be.store.peugeot.inetpsa.com/fr/contactsolv0?mbd=1PB1S0000049;&Version=1PB1A5ERD5B0A050&Color=0MP00NP8&Trim=0PII0RFO&VehListIndex=1%7c50");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        // driver.findElement(By.className("psac_noselect")).click();
        Leads.FillContactFormBelgiumFR(driver);
        Leads.ClickSubmitButton(driver);
        assert (Leads.GetTheConfirmationMessage(driver) == true);
        driver.close();

    }

    @Ignore
    public void TheLeadHAvebeenSubmittedForPeugeotBelgiumNL() {

        driver.get(
                "http://be.store.peugeot.inetpsa.com/nl/contactsolv0?mbd=1PT9S0000097;&Version=1PT9A5WLUKB0A0D0&Options=AB13QK02UN01WLF6YR07&Color=0MM00NF4&Trim=0P0J0RFJ&VehListIndex=1%7c2");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        // driver.findElement(By.className("psac_noselect")).click();
        Leads.FillContactFormBelgiumNL(driver);
        Leads.ClickSubmitButton(driver);
        assert (Leads.GetTheConfirmationMessage(driver) == true);
        driver.close();

    }

    @Ignore
    public void TheLeadHAvebeenSubmittedForPeugeotSwidzerland() {

        driver.get(
                "http://be.store.peugeot.inetpsa.com/fr/contactsolv0?mbd=1PB1S0000049;&Version=1PB1A5ERD5B0A050&Color=0MP00NP8&Trim=0PII0RFO&VehListIndex=1%7c50");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.findElement(By.className("psac_noselect")).click();
        Leads.FillContactFormSwidzerland(driver);
        Leads.ClickSubmitButton(driver);
        assert (Leads.GetTheConfirmationMessage(driver) == true);
        driver.close();

    }

}
