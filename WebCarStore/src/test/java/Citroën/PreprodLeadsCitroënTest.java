/*
 * Creation : 1 avr. 2019
 */
package Citroën;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import Peugeot.InitialiseDrivers;
import Utilities.WaitS;

public class PreprodLeadsCitroënTest {
    static WebDriver driver;

    @BeforeMethod
    public void BeforeTest() {
        driver = InitialiseDrivers.InitialiseChromDriver();
    }

    @Test(priority = 1)
    public void TheLeadHAvebeenSubmittedForPeugeotFrance() {

        driver.get(
                "https://E562418:Id133499@fr-store-preprod.citroen.com/c1/berline-4-5p/contactsolv0?lat=48.85661400000001&lng=2.3522219000000177&Cit=Paris&mbd=1CBO00000015;1CB100000010;1CB100000011;&carNum=R-JP7350&VehListIndex=1%7c1&screenWidth=1349&idFirstDealer=0000038520");

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        try {
            driver.findElement(By.className("psac_noselect")).click();
        } catch (NoSuchElementException e) {
        }
        LeadsCI.FillContactFormFrance(driver);
        LeadsCI.ClickSubmitButton(driver);
        WaitS.Wait(3000);
        assert (LeadsCI.GetTheConfirmationMessage(driver) == true);
        driver.close();
    }

    @Test(priority = 2)
    public void TheLeadHAvebeenSubmittedForPeugeotSpain() {

        driver.get(
                "https://E562418:Id133499@es-store-preprod.citroen.com/c-zero/berlina-5-p/contactsolv0?lat=40.1297061&lng=-0.2197764999999663&Cit=12122&mbd=1SX800000021;1CMS00000002;1XXX00000002;&carNum=R-276570&VehListIndex=1%7c12&screenWidth=1349&idFirstDealer=0000033097");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        try {
            driver.findElement(By.className("psac_noselect")).click();
        } catch (NoSuchElementException e) {
        }
        LeadsCI.FillContactFormSpain(driver);
        LeadsCI.ClickSubmitButton(driver);
        WaitS.Wait(3000);
        assert (LeadsCI.GetTheConfirmationMessage(driver) == true);
        driver.close();

    }

    @Test(priority = 3)
    public void TheLeadHAvebeenSubmittedForPeugeotItaly() {

        driver.get(
                "https://E562418:Id133499@it-store-preprod.citroen.com/c1/citycar-compatte/contactsolv0?lat=45.4064349&lng=11.876761100000067&Cit=Padova%2C%20PD&mbd=1CB100000006;1CB100000001;1CBO00000002;&carNum=R-818988&VehListIndex=1%7c15&screenWidth=1903&idFirstDealer=264028");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        try {
            driver.findElement(By.className("psac_noselect")).click();
        } catch (NoSuchElementException e) {
        }
        LeadsCI.FillContactFormItaly(driver);
        LeadsCI.ClickSubmitButton(driver);
        WaitS.Wait(4000);
        assert (LeadsCI.GetTheConfirmationMessage(driver) == true);
        driver.close();

    }

    @Test(priority = 4)
    public void TheLeadHAvebeenSubmittedForPeugeotBelgiumFR() {

        driver.get(
                "http://be.store.citroen.preprod.inetpsa.com/fr/e-mehari/e-mehari-cabrio/contactsolv0?mbd=1CBOSILHMCAB;1CB1SILAIR5P;1CB1SILHOU3P;&Version=1CBOE2HEA0B0A010&Options=RE01&color=0MM00NEU&trim=0PI50RFC&VehListIndex=1%7c6&screenWidth=1349");
        try {
            driver.findElement(By.className("psac_noselect")).click();
        } catch (NoSuchElementException e) {
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        LeadsCI.FillContactFormBelgiumFR(driver);
        LeadsCI.ClickSubmitButton(driver);
        WaitS.Wait(4000);
        assert (LeadsCI.GetTheConfirmationMessage(driver) == true);
        driver.close();

    }

    @Test(priority = 5)
    public void TheLeadHAvebeenSubmittedForPeugeotBelgiumNL() {

        driver.get(
                "http://be.store.citroen.preprod.inetpsa.com/nl/e-mehari/e-mehari-cabrio/contactsolv0?mbd=1CBOSILHMCAB;1CB1SILAIR5P;1CB1SILHOU3P;&Version=1CBOE2HEA0B0A010&Options=RE01&color=0MM00NEU&trim=0PI50RFC&VehListIndex=1%7c6&screenWidth=1349");
        try {
            driver.findElement(By.className("psac_noselect")).click();
        } catch (NoSuchElementException e) {
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        LeadsCI.FillContactFormBelgiumNL(driver);
        LeadsCI.ClickSubmitButton(driver);
        WaitS.Wait(4000);
        assert (LeadsCI.GetTheConfirmationMessage(driver) == true);
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
        LeadsCI.FillContactFormSwidzerland(driver);
        LeadsCI.ClickSubmitButton(driver);
        WaitS.Wait(3000);
        assert (LeadsCI.GetTheConfirmationMessage(driver) == true);
        driver.close();

    }

}
