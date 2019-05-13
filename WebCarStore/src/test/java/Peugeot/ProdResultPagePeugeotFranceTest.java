/*
 * Creation : 24 avr. 2019
 */
package Peugeot;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import Utilities.DateManagement;
import Utilities.WaitS;

public class ProdResultPagePeugeotFranceTest {
    static WebDriver driver;
    static Date DeliveryDate;
    static Date currentDate;
    static int[] OffersNum;
    static int[] OffersNum1;
    static int Error;

    @BeforeMethod
    public void BeforeTest() {

        driver = InitialiseDrivers.InitialiseChromDriver();
        driver.get(
                "http://fr.store.peugeot.inetpsa.com/Recherche-par-critere?lat=48.856614&lng=2.3522219000000177&LocationL=Paris%2C%20France&etd=0");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.findElement(By.className("psac_noselect")).click();

    }

    @Ignore
    public void CheckThatThedeliveryDateisGreaterThanTodaysDate() {

        String[] Models = ResultPage.GetTheModelsListElements(driver);

        OffersNum = new int[Models.length];
        OffersNum[0] = 0;
        Error = 0;
        ResultPage.OpenTheModelsMenu(driver);
        currentDate = DateManagement.GetCurrentDate();

        for (int i = 1; i <= Models.length; i++) {
            ResultPage.OpenTheModelsMenu(driver);
            WaitS.WaitForElementToBeVisible(driver,
                    "/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/ul[1]/li[" + i + "]/a[1]/label[1]");
            if (i == 1) {
                ResultPage.SelectaModelFromTheModelsList(driver, i);
            } else {
                ResultPage.SelectaModelFromTheModelsList(driver, i - 1);
                ResultPage.OpenTheModelsMenu(driver);
                ResultPage.SelectaModelFromTheModelsList(driver, i);
            }

            WaitS.Wait(2000);
            int OffersNum = ResultPage.GetOffersNumber(driver);
            DeliveryDate = ResultPage.GetDeliveryDateByIndex(driver, 3);
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

    @Ignore

    public void TheNumberOfOffersISGreaterWhenAddingAModel() {

        String[] Models = ResultPage.GetTheModelsListElements(driver);

        OffersNum1 = new int[Models.length + 1];
        OffersNum1[0] = 0;
        Error = 0;

        ResultPage.OpenTheModelsMenu(driver);

        for (int i = 1; i <= Models.length; i++) {

            ResultPage.OpenTheModelsMenu(driver);
            WaitS.WaitForElementToBeVisible(driver,
                    "/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/ul[1]/li[" + i + "]/a[1]/label[1]");
            ResultPage.SelectaModelFromTheModelsList(driver, i);
            OffersNum1[i] = ResultPage.GetOffersNumber(driver);

            if (OffersNum1[i] <= OffersNum1[i - 1]) {

                System.err.println(Models[i - 1].toLowerCase());
                Error++;
            }

        }
        driver.close();
        assert (Error == 0);
    }

    @Ignore

    public void TheNumberOfOffersIsLowerWhenChangingThePriceSlider() {

        ResultPage.OpenTheModelsMenu(driver);
        ResultPage.SelectaModelFromTheModelsList(driver, 1);
        ResultPage.OpenTheModelsMenu(driver);
        ResultPage.SelectaModelFromTheModelsList(driver, 2);
        ResultPage.OpenTheModelsMenu(driver);
        ResultPage.SelectaModelFromTheModelsList(driver, 3);
        WaitS.Wait(2000);
        int Offers1 = ResultPage.GetOffersNumber(driver);
        ResultPage.MovePriceSliderToLowerValue(driver);
        int Offers2 = ResultPage.GetOffersNumber(driver);
        driver.close();
        assert (Offers1 > Offers2);

    }

    @Test

    public void Thedels() {
        Error = 0;
        ResultPage.OpenTheModelsMenu(driver);
        ResultPage.SelectaModelFromTheModelsList(driver, 5);
        WaitS.WaitForElementToBeVisible(driver, "/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/div[4]/div[1]/label[1]/i[1]");
        String[] Energies = ResultPage.GetTheEnergiesList(driver);
        OffersNum = new int[Energies.length];
        OffersNum[0] = ResultPage.GetOffersNumber(driver);
        if (Energies.length == 3) {

            ResultPage.ClickOnOneEnergy(driver, "Essence");
            OffersNum[1] = ResultPage.GetOffersNumber(driver);
            if (OffersNum[1] > OffersNum[0]) {
                Error++;
                System.err.println(Energies[1]);
            }
            WaitS.WaitForElementToBeVisible(driver, "/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/div[4]/div[1]/label[1]/i[1]");
            ResultPage.ClickOnOneEnergy(driver, "Essence");
            WaitS.WaitForElementToBeVisible(driver, "/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/div[4]/div[1]/label[1]/i[1]");
            ResultPage.ClickOnOneEnergy(driver, "Diesel");
            WaitS.WaitForElementToBeVisible(driver, "/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/div[4]/div[1]/label[1]/i[1]");
            OffersNum[2] = ResultPage.GetOffersNumber(driver);
            if (OffersNum[2] != OffersNum[0] - OffersNum[1]) {
                Error++;
                System.err.println(Energies[2]);
            }
        }

        if (Energies.length == 4) {

            ResultPage.ClickOnOneEnergy(driver, "Essence");
            OffersNum[1] = ResultPage.GetOffersNumber(driver);
            if (OffersNum[1] > OffersNum[0]) {

                Error++;
                System.err.println(Energies[1]);
            }
            ResultPage.ClickOnOneEnergy(driver, "Essence");
            ResultPage.ClickOnOneEnergy(driver, "Diesel");
            OffersNum[2] = ResultPage.GetOffersNumber(driver);

            if (OffersNum[2] > OffersNum[0]) {
                Error++;
                System.err.println(Energies[2]);
            }

            ResultPage.ClickOnOneEnergy(driver, "Electrique");
            OffersNum[3] = ResultPage.GetOffersNumber(driver);

            if (OffersNum[3] != OffersNum[0] - OffersNum[1] - OffersNum[2]) {
                Error++;
                System.err.println("Electrique");
            }

        }
        assert (Error == 0);
    }

}
