/*
 * Creation : 24 avr. 2019
 */
package Peugeot;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.DateManagement;
import Utilities.InitialiseDrivers;
import Utilities.WaitS;

public class ResultPageTest {
    static WebDriver driver;
    static Date DeliveryDate;
    static Date currentDate;
    static int[] OffersNum;
    static int[] OffersNum1;
    static int Error;

    /*
     * @BeforeMethod(dataProvider="UrlsProvider") public void BeforeTest() {
     * 
     * driver = InitialiseDrivers.InitialiseChromDriver(); driver.get(
     * "http://fr.store.peugeot.inetpsa.com/Recherche-par-critere?lat=48.856614&lng=2.3522219000000177&LocationL=Paris%2C%20France&etd=0");
     * driver.manage().deleteAllCookies(); driver.manage().window().maximize(); driver.findElement(By.className("psac_noselect")).click();
     * 
     * }
     */

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

    }

    @Test(dataProvider = "UrlsProvider")
    public void CheckThatThedeliveryDateisGreaterThanTodaysDate(String URL) {
        InitialiseUrl(URL);
        String[] Models = ResultPageAP.GetTheModelsListElements(driver);

        OffersNum = new int[Models.length];
        OffersNum[0] = 0;
        Error = 0;
        // ResultPageAP.OpenTheModelsMenu(driver);
        currentDate = DateManagement.GetCurrentDate();

        for (int i = 1; i <= Models.length; i++) {
            ResultPageAP.OpenTheModelsMenu(driver);
            WaitS.WaitForElementToBeVisible(driver,
                    "/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/ul[1]/li[" + i + "]/a[1]/label[1]");
            if (i == 1) {
                ResultPageAP.SelectaModelFromTheModelsList(driver, i);
            } else {
                ResultPageAP.SelectaModelFromTheModelsList(driver, i - 1);
                ResultPageAP.OpenTheModelsMenu(driver);
                ResultPageAP.SelectaModelFromTheModelsList(driver, i);
            }

            WaitS.Wait(2000);
            int OffersNum = ResultPageAP.GetOffersNumber(driver);
            DeliveryDate = ResultPageAP.GetDeliveryDateByIndex(driver, 3);
            long diff = DeliveryDate.getTime() - currentDate.getTime();
            long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            if (days < 0) {
                Error++;
                System.err.println(Models[i]);
            }

        }

        driver.close();
        assert (Error == 0);

    }

    @Test(dataProvider = "UrlsProvider")
    public void CheckThatTheNumberOfOfferschangesWhenChangingGearBox(String URL) {
        InitialiseUrl(URL);
        String[] GearBoxs = ResultPageAP.GetTheGearBoxListElements(driver);

        // System.out.println(GearBoxs[1]);

        OffersNum = new int[GearBoxs.length];
        OffersNum[0] = 0;
        Error = 0;
        // ResultPageAP.OpenTheModelsMenu(driver); currentDate =
        DateManagement.GetCurrentDate();

        for (int i = 1; i < GearBoxs.length; i++)

        {
            ResultPageAP.OpenTheGearBoxMenu(driver);
            WaitS.WaitForElementToBeVisible(driver, "/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/div[5]/div[1]/div[1]/ul[1]/li[2]/a[1]/label[1]");
            if (i == 1) {
                ResultPageAP.SelectaGearBoxFromTheGearBoxsList(driver, i);
            } else {
                ResultPageAP.SelectaGearBoxFromTheGearBoxsList(driver, i - 1);
                ResultPageAP.OpenTheGearBoxMenu(driver);
                WaitS.WaitForElementToBeVisible(driver,
                        "/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/div[5]/div[1]/div[1]/ul[1]/li[2]/a[1]/label[1]");
                ResultPageAP.SelectaGearBoxFromTheGearBoxsList(driver, i);
            }

            WaitS.Wait(2000);
            OffersNum[i] = ResultPageAP.GetOffersNumber(driver);

            if (OffersNum[i] == OffersNum[i - 1]) {
                Error++;
                System.err.println(GearBoxs[i]);
            }

        }

        driver.close();
        assert (Error == 0);

    }

    @Test(dataProvider = "UrlsProvider")
    public void CheckThatTheNumberOfOfferschangesWhenChangingEngine(String URL) {
        InitialiseUrl(URL);

        String[] Engines = ResultPageAP.GetTheEngineListElements(driver);

        OffersNum = new int[Engines.length];
        OffersNum[0] = 0;
        Error = 0;
        // ResultPageAP.OpenTheModelsMenu(driver); currentDate =
        DateManagement.GetCurrentDate();

        for (int i = 1; i < Engines.length; i++)

        {
            ResultPageAP.OpenTheEngineMenu(driver);
            WaitS.WaitForElementToBeVisible(driver, "/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/div[6]/div[1]/div[1]/ul[1]/li[2]/a[1]/label[5]");
            if (i == 1) {
                ResultPageAP.SelectaEngineFromTheEngineList(driver, i);
            } else {
                ResultPageAP.SelectaEngineFromTheEngineList(driver, i - 1);
                WaitS.Wait(1000);
                ResultPageAP.OpenTheEngineMenu(driver);
                WaitS.Wait(1000);
                ResultPageAP.SelectaEngineFromTheEngineList(driver, i);
            }

            WaitS.Wait(2000);
            OffersNum[i] = ResultPageAP.GetOffersNumber(driver);

            if (OffersNum[i] == OffersNum[i - 1] && OffersNum[i] > 5) {
                Error++;
                System.err.println(URL + " **************************** " + Engines[i - 1]);
            }

        }

        // driver.close();
        assert (Error == 0);

    }

    @Test(dataProvider = "UrlsProvider")
    public void CheckThatTheNumberOfOfferschangesWhenChangingFinition(String URL) {
        InitialiseUrl(URL);

        String[] Test = ResultPageAP.GetTheMenuElements(driver);
        System.out.println(Test[0]);
        String[] Finitions = ResultPageAP.GetTheFinitionListElements(driver);

        OffersNum = new int[Finitions.length];
        OffersNum[0] = 0;
        Error = 0;
        // ResultPageAP.OpenTheModelsMenu(driver); currentDate =
        DateManagement.GetCurrentDate();

        for (int i = 1; i < Finitions.length; i++)

        {
            System.out.println(Finitions[i]);
            ResultPageAP.OpenTheFinitionMenu(driver);
            WaitS.WaitForElementToBeVisible(driver, "/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/div[7]/div[1]/div[1]/ul[1]/li[5]/a[1]/label[5]");
            if (i == 1) {
                ResultPageAP.SelectaFinitionFromTheFinitionList(driver, i);
            } else {
                ResultPageAP.SelectaFinitionFromTheFinitionList(driver, i - 1);
                WaitS.Wait(2000);
                ResultPageAP.OpenTheFinitionMenu(driver);
                WaitS.Wait(1000);
                ResultPageAP.SelectaFinitionFromTheFinitionList(driver, i);
            }

            WaitS.Wait(2000);
            OffersNum[i] = ResultPageAP.GetOffersNumber(driver);

            if (OffersNum[i] == OffersNum[i - 1] && OffersNum[i] > 5) {
                Error++;
                System.err.println(Finitions[i]);
            }

        }

        driver.close();
        assert (Error == 0);

    }

    @Test(dataProvider = "UrlsProvider")
    public void CheckThatTheNumberOfOfferschangesWhenChangingTheColor(String URL) {
        InitialiseUrl(URL);
        String[] Colors = ResultPageAP.GetTheColorListElements(driver);
        System.err.println(Colors[0]);
        OffersNum = new int[Colors.length + 1];
        OffersNum[0] = 0;
        Error = 0;
        // ResultPageAP.OpenTheModelsMenu(driver); currentDate =
        DateManagement.GetCurrentDate();

        for (int i = 1; i <= Colors.length; i++)

        {

            if (i == 1) {
                ResultPageAP.SelectaColorFromTheColorList(driver, i);
            } else {
                ResultPageAP.SelectaColorFromTheColorList(driver, i - 1);
                WaitS.Wait(2000);
                ResultPageAP.SelectaColorFromTheColorList(driver, i);
            }

            WaitS.Wait(2000);
            OffersNum[i] = ResultPageAP.GetOffersNumber(driver);

            if (OffersNum[i] == OffersNum[i - 1]) {
                Error++;
                System.err.println(Colors[i]);
            }

        }

        driver.close();
        assert (Error == 0);

    }

    @Test(dataProvider = "UrlsProvider")
    public void TheNumberOfOffersISGreaterWhenAddingAModel(String URL) {
        InitialiseUrl(URL);
        String[] Models = ResultPageAP.GetTheModelsListElements(driver);

        OffersNum1 = new int[Models.length + 1];
        OffersNum1[0] = 0;
        Error = 0;

        // ResultPageAP.OpenTheModelsMenu(driver);

        for (int i = 1; i <= Models.length; i++) {

            ResultPageAP.OpenTheModelsMenu(driver);

            ResultPageAP.SelectaModelFromTheModelsList(driver, i);
            OffersNum1[i] = ResultPageAP.GetOffersNumber(driver);

            if (OffersNum1[i] <= OffersNum1[i - 1]) {

                System.err.println(Models[i - 1].toLowerCase());
                Error++;
            }

        }
        driver.close();
        assert (Error == 0);
    }

    @Test(dataProvider = "UrlsProvider")
    public void TheNumberOfOffersIsLowerWhenChangingThePriceSlider(String URL) {
        InitialiseUrl(URL);
        ResultPageAP.OpenTheModelsMenu(driver);
        ResultPageAP.SelectaModelFromTheModelsList(driver, 1);
        ResultPageAP.OpenTheModelsMenu(driver);
        ResultPageAP.SelectaModelFromTheModelsList(driver, 2);
        ResultPageAP.OpenTheModelsMenu(driver);
        ResultPageAP.SelectaModelFromTheModelsList(driver, 3);
        WaitS.Wait(2000);
        int Offers1 = ResultPageAP.GetOffersNumber(driver);
        ResultPageAP.MovePriceSliderToLowerValue(driver);
        int Offers2 = ResultPageAP.GetOffersNumber(driver);
        driver.close();
        assert (Offers1 > Offers2);

    }

    @Test(dataProvider = "UrlsProvider")

    public void TheNumberOfOffersIsCorrectWhenChangingTheEnergy(String URL) {
        InitialiseUrl(URL);
        Error = 0;
        String[] Models = ResultPageAP.GetTheModelsListElements(driver);
        for (int i = 0; i < Models.length; i++) {
            ResultPageAP.OpenTheModelsMenu(driver);
            ResultPageAP.SelectaModelFromTheModelsList(driver, i + 1);

            WaitS.WaitForElementToBeVisible(driver, "/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/div[4]/div[1]/label[1]");
            String[] Energies = ResultPageAP.GetTheEnergiesList(driver);
            OffersNum = new int[Energies.length];

            OffersNum[0] = ResultPageAP.GetOffersNumber(driver);
            if (Energies.length == 3) {

                ResultPageAP.ClickOnOneEnergy(driver, 1, 1);
                OffersNum[1] = ResultPageAP.GetOffersNumber(driver);
                if (OffersNum[1] > OffersNum[0]) {
                    Error++;
                    System.err.println(Models[i] + " / " + Energies[1]);
                }
                WaitS.WaitForElementToBeVisible(driver, "/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/div[4]/div[1]/label[1]");
                ResultPageAP.ClickOnOneEnergy(driver, 1, 1);
                WaitS.WaitForElementToBeVisible(driver, "/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/div[4]/div[1]/label[1]");
                ResultPageAP.ClickOnOneEnergy(driver, 2, 1);
                WaitS.WaitForElementToBeVisible(driver, "/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/div[4]/div[1]/label[1]");
                OffersNum[2] = ResultPageAP.GetOffersNumber(driver);
                if (OffersNum[2] != OffersNum[0] - OffersNum[1]) {
                    Error++;
                    System.err.println(Models[i] + " / " + Energies[2] + "/" + OffersNum[2]);
                }
            }

            if (Energies.length == 4) {

                ResultPageAP.ClickOnOneEnergy(driver, 1, 1);
                OffersNum[1] = ResultPageAP.GetOffersNumber(driver);
                if (OffersNum[1] > OffersNum[0]) {

                    Error++;
                    System.err.println(Models[i] + " / " + Energies[1]);
                }
                WaitS.WaitForElementToBeVisible(driver, "/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/div[4]/div[1]/label[1]");
                ResultPageAP.ClickOnOneEnergy(driver, 1, 1);
                WaitS.WaitForElementToBeVisible(driver, "/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/div[4]/div[1]/label[1]");
                ResultPageAP.ClickOnOneEnergy(driver, 2, 1);
                OffersNum[2] = ResultPageAP.GetOffersNumber(driver);

                if (OffersNum[2] > OffersNum[0]) {
                    Error++;
                    System.err.println(Models[i] + " / " + Energies[2]);
                }

                WaitS.WaitForElementToBeVisible(driver, "/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/div[4]/div[1]/label[1]");
                ResultPageAP.ClickOnOneEnergy(driver, 2, 1);
                WaitS.WaitForElementToBeVisible(driver, "/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/div[4]/div[1]/label[1]");
                ResultPageAP.ClickOnOneEnergy(driver, 1, 2);
                OffersNum[3] = ResultPageAP.GetOffersNumber(driver);

                if (OffersNum[3] != OffersNum[0] - OffersNum[1] - OffersNum[2]) {
                    Error++;
                    System.err.println(Models[i] + " / " + Energies[3]);
                }

            }
            ResultPageAP.OpenTheModelsMenu(driver);
            ResultPageAP.SelectaModelFromTheModelsList(driver, i + 1);
        }
        driver.close();
        assert (Error == 0);
    }

    @DataProvider(name = "UrlsProvider1")
    public Object[] UrlsTobeTested() {

        Object[] URLS = new Object[] {
                "http://es.store.peugeot.inetpsa.com/Busqueda-por-criterio?lat=40.4167754&lng=-3.7037901999999576&LocationL=Madrid%2C%20Espa%C3%B1a&etd=0",
                "http://fr.store.peugeot.inetpsa.com/Recherche-par-critere?lat=48.856614&lng=2.3522219000000177&LocationL=Paris%2C%20France&etd=0",
                "http://it.store.peugeot.inetpsa.com/Cerca-per-categorie?lat=45.7805759&lng=12.837399199999936&LocationL=30026%20Portogruaro%20VE%2C%20Italia&etd=0" };
        return URLS;
    }

    @DataProvider(name = "UrlsProvider")
    public Object[] UrlsTobeTested1() {

        Object[] URLS = new Object[] {
                "http://fr.store.peugeot.inetpsa.com/Recherche-par-critere?lat=48.856614&lng=2.3522219000000177&LocationL=Paris%2C%20France&etd=0" };
        return URLS;
    }

    @DataProvider(name = "UrlsProvider2")
    public Object[] UrlsTobeTestd2() {

        Object[] URLS = new Object[] {
                "http://it.store.peugeot.inetpsa.com/Cerca-per-categorie?lat=45.7805759&lng=12.837399199999936&LocationL=30026%20Portogruaro%20VE%2C%20Italia&etd=0" };
        return URLS;
    }

}
