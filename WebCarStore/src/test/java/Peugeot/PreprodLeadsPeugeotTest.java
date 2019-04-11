/*
 * Creation : 1 avr. 2019
 */
package Peugeot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class PreprodLeadsPeugeotTest {
    static WebDriver driver;

    @BeforeMethod
    public void BeforeTest() {
        driver = InitialiseDrivers.InitialiseChromDriver();
    }

    @Test(priority = 1)
    public void TheLeadHAvebeenSubmittedForPeugeotFrance() {

        driver.get(
                "http://fr.store.peugeot.preprod.inetpsa.com/contactsolv0?lat=48.856614&lng=2.3522219000000177&Cit=Paris%2C%20France&etd=0&mbd=1PIAS0000029;&MinPrice=NaN&MaxPrice=NaN&carNum=R-UP5338&VehListIndex=1%7c1");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.findElement(By.className("psac_noselect")).click();
        Leads.FillContactFormFrance(driver);
        Leads.ClickSubmitButton(driver);
        assert (Leads.GetTheConfirmationMessage(driver) == true);
        driver.close();

    }

    @Test(priority = 2)
    public void TheLeadHAvebeenSubmittedForPeugeotSpain() {

        driver.get(
                "http://es.store.peugeot.preprod.inetpsa.com/contactsolv0?lat=40.4111433&lng=-3.7388727999999674&Cit=Av.%20de%20Portugal%2C%2028011%20Madrid%2C%20Espa%C3%B1a&etd=0&mbd=1PB10SIL0B50;&carNum=R-649243&VehListIndex=1%7c2");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        // driver.findElement(By.className("psac_noselect")).click();
        Leads.FillContactFormSpain(driver);
        Leads.ClickSubmitButton(driver);
        assert (Leads.GetTheConfirmationMessage(driver) == true);
        driver.close();

    }

    @Test(priority = 3)
    public void TheLeadHAvebeenSubmittedForPeugeotItaly() {

        driver.get(
                "http://it.store.peugeot.preprod.inetpsa.com/contactsolv0?lat=46.2564381&lng=10.580823499999951&Cit=Passo%20del%20Tonale%2C%2025056%20Ponte%20di%20legno%20BS%2C%20Italia&etd=0&mbd=1PIAS3P00000;&carNum=R-643377&VehListIndex=1%7c30");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        // driver.findElement(By.className("psac_noselect")).click();
        Leads.FillContactFormItaly(driver);
        Leads.ClickSubmitButton(driver);
        assert (Leads.GetTheConfirmationMessage(driver) == true);
        driver.close();

    }

    @Test(priority = 4)
    public void TheLeadHAvebeenSubmittedForPeugeotBelgiumFR() {

        driver.get(
                "http://be.store.peugeot.preprod.inetpsa.com/fr/contactsolv0?mbd=1PIAS0000048;&Version=1PIAA3DKM5B0A0G1&Options=AJ01RE01WLN8ZH38&Color=0MP00NWP&Trim=0P0D0RFL&VehListIndex=1%7c3");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        // driver.findElement(By.className("psac_noselect")).click();
        Leads.FillContactFormBelgiumFR(driver);
        Leads.ClickSubmitButton(driver);
        assert (Leads.GetTheConfirmationMessage(driver) == true);
        driver.close();

    }

    @Test(priority = 5)
    public void TheLeadHAvebeenSubmittedForPeugeotBelgiumNL() {

        driver.get(
                "http://be.store.peugeot.preprod.inetpsa.com/nl/contactsolv0?mbd=1PT9S0000005;&Version=1PT9C5FCQJB0A0B6&Options=PR01RZ89UB01ZH2D&Color=0MM50NF3&Trim=0P1P0RFX&VehListIndex=1%7c175");
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
                "http://ch.store.peugeot.preprod.inetpsa.com/fr/contactsolv0?lat=46.2043907&lng=6.143157699999961&Cit=Gen%C3%A8ve%2C%20Suisse&etd=0&mbd=1PW2SILSW001;&MinPrice=NaN&MaxPrice=NaN&carNum=R-652606&VehListIndex=1%7c1");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.findElement(By.className("psac_noselect")).click();
        Leads.FillContactFormSwidzerland(driver);
        Leads.ClickSubmitButton(driver);
        assert (Leads.GetTheConfirmationMessage(driver) == true);
        driver.close();

    }

}
