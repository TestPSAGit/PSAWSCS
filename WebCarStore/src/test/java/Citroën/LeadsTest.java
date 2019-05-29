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

import Utilities.InitialiseDrivers;
import Utilities.WaitS;

public class LeadsTest {
    static WebDriver driver;

    @BeforeMethod
    public void BeforeTest() {
        driver = InitialiseDrivers.InitialiseChromDriver();
    }

    @Test(priority = 1)
    public void TheLeadHAvebeenSubmittedForCitroënFrance() {

        driver.get(
                "http://E562418:Id133499@fr.store.citroen.inetpsa.com/nouveau-suv-c5-aircross/suv/contactsolv0?lat=48.85661400000001&lng=2.3522219000000177&Cit=Paris&mbd=1CCE00000022;1CMS00000010;&carNum=R-NU5154&VehListIndex=1%7c503&screenWidth=1349&idFirstDealer=0000038241");

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        try {
            driver.findElement(By.className("psac_noselect")).click();
        } catch (NoSuchElementException e) {
        }
        LeadsAC.FillContactFormFrance(driver);
        LeadsAC.ClickSubmitButton(driver);
        WaitS.Wait(3000);
        assert (LeadsAC.GetTheConfirmationMessage(driver) == true);
        driver.close();
    }

    @Test(priority = 2)
    public void TheLeadHAvebeenSubmittedForCitroënSpain() {

        driver.get(
                "https://E562418:Id133499@carstore.citroen.es/c1/berlina-5-p/contactsolv0?lat=40.4167754&lng=-3.7037901999999576&Cit=madrid&mbd=1CBO00000030;1CB100000002;&carNum=R-576167&VehListIndex=1%7c57&screenWidth=1349&idFirstDealer=0000032861");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        try {
            driver.findElement(By.className("psac_noselect")).click();
        } catch (NoSuchElementException e) {
        }
        LeadsAC.FillContactFormSpain(driver);
        LeadsAC.ClickSubmitButton(driver);
        WaitS.Wait(3000);
        assert (LeadsAC.GetTheConfirmationMessage(driver) == true);
        driver.close();

    }

    @Test(priority = 3)
    public void TheLeadHAvebeenSubmittedForCitroënItaly() {

        driver.get(
                "http://E562418:Id133499@it.store.citroen.inetpsa.com/c1/citycar-compatte/contactsolv0?lat=41.90278349999999&lng=12.496365500000024&Cit=Roma%2C%20RM&mbd=1CB100000001;1CB100000006;&carNum=R-956427&VehListIndex=1%7c75&screenWidth=1349&idFirstDealer=266684");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        try {
            driver.findElement(By.className("psac_noselect")).click();
        } catch (NoSuchElementException e) {
        }
        LeadsAC.FillContactFormItaly(driver);
        LeadsAC.ClickSubmitButton(driver);
        WaitS.Wait(4000);
        assert (LeadsAC.GetTheConfirmationMessage(driver) == true);
        driver.close();

    }

    @Test(priority = 4)
    public void TheLeadHAvebeenSubmittedForCitroënBelgiumFR() {

        driver.get(
                "http://E562418:Id133499@be.store.citroen.inetpsa.com/fr/e-mehari/new-e-mehari-cabrio/contactsolv0?mbd=1CBOSILHMCA2;1CB1SILAIR3P;&Version=1CBOE2HEA0B09Z20&Options=RE01&color=0MM00NGK&trim=0PI50RFW&VehListIndex=1%7c3&screenWidth=1349");
        try {
            driver.findElement(By.className("psac_noselect")).click();
        } catch (NoSuchElementException e) {
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        LeadsAC.FillContactFormBelgiumFR(driver);
        LeadsAC.ClickSubmitButton(driver);
        WaitS.Wait(4000);
        assert (LeadsAC.GetTheConfirmationMessage(driver) == true);
        driver.close();

    }

    @Test(priority = 5)
    public void TheLeadHAvebeenSubmittedForCitroënBelgiumNL() {

        driver.get(
                "http://E562418:Id133499@be.store.citroen.inetpsa.com/nl/e-mehari/new-e-mehari-cabrio/contactsolv0?mbd=1CBOSILHMCA2;1CB1SILAIR3P;&Version=1CBOE2HEA0B09Z20&Options=RE01&color=0MM00NGK&trim=0PI50RFW&VehListIndex=1%7c3&screenWidth=1349");
        try {
            driver.findElement(By.className("psac_noselect")).click();
        } catch (NoSuchElementException e) {
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        LeadsAC.FillContactFormBelgiumNL(driver);
        LeadsAC.ClickSubmitButton(driver);
        WaitS.Wait(4000);
        assert (LeadsAC.GetTheConfirmationMessage(driver) == true);
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
        LeadsAC.FillContactFormSwidzerland(driver);
        LeadsAC.ClickSubmitButton(driver);
        WaitS.Wait(3000);
        assert (LeadsAC.GetTheConfirmationMessage(driver) == true);
        driver.close();

    }

}
