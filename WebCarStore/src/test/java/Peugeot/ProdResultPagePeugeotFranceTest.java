/*
 * Creation : 24 avr. 2019
 */
package Peugeot;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Methodes.DateManagement;
import Methodes.WaitS;

public class ProdResultPagePeugeotFranceTest {
    static WebDriver driver;
    static Date DeliveryDate;
    static Date currentDate;
    static int[] OffersNum;
    static int Error;

    @BeforeSuite
    public void BeforeTest() {

        driver = InitialiseDrivers.InitialiseChromDriver();
        driver.get(
                "http://fr.store.peugeot.inetpsa.com/Recherche-par-critere?lat=48.856614&lng=2.3522219000000177&LocationL=Paris%2C%20France&etd=0");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.findElement(By.className("psac_noselect")).click();

    }

    @Test

    public void CheckThatThedeliveryDateisGreaterThanTodaysDate() {

        String[] Models = ResultPage.GetTheModelsListElements(driver);

        OffersNum = new int[Models.length];
        OffersNum[0] = 0;
        Error = 0;
        driver.findElement(By.xpath("//*[@id=\"filter-form\"]/div[1]/div/div/button")).click();
        currentDate = DateManagement.GetCurrentDate();

        for (int i = 1; i < Models.length; i++) {
            driver.findElement(By.xpath("//*[@id=\"filter-form\"]/div[1]/div/div/button")).click();
            WaitS.WaitForElementToBeVisible(driver,
                    "/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/ul[1]/li[" + i + "]/a[1]/label[1]");
            if (i == 1) {
                ResultPage.SelectaModelFromTheModelsList(driver, i);
            } else {
                ResultPage.SelectaModelFromTheModelsList(driver, i - 1);
                driver.findElement(By.xpath("//*[@id=\"filter-form\"]/div[1]/div/div/button")).click();
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
        assert (Error == 0);

    }

    @Test

    public void TheNumberOfOffersISGreaterWhenAddingAModel() {
        String[] Models = ResultPage.GetTheModelsListElements(driver);

        OffersNum = new int[Models.length];
        OffersNum[0] = 0;
        Error = 0;

        driver.findElement(By.xpath("//*[@id=\"filter-form\"]/div[1]/div/div/button")).click();

        for (int i = 1; i < Models.length; i++) {

            driver.findElement(By.xpath("//*[@id=\"filter-form\"]/div[1]/div/div/button")).click();
            WaitS.WaitForElementToBeVisible(driver,
                    "/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/ul[1]/li[" + i + "]/a[1]/label[1]");
            ResultPage.SelectaModelFromTheModelsList(driver, i);

            OffersNum[i] = ResultPage.GetOffersNumber(driver);

            if (OffersNum[i] <= OffersNum[i - 1]) {

                System.err.println(Models[i - 1].toLowerCase());
                Error++;
            }

            assert (Error == 0);
        }

    }
}
