/*
 * Creation : 28 mars 2019
 */
package Peugeot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Methodes.WaitS;

public class PreprodHomePagetestFranceTest {
    static WebDriver driver;

    @BeforeMethod
    public void BeforeTest() {
        driver = InitialiseDrivers.InitialiseChromDriver();
        driver.get("http://fr.store.peugeot.preprod.inetpsa.com/peugeot/Accueil");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.findElement(By.className("psac_noselect")).click();
    }

    @Test(priority = 2)
    public void ThePriceChangesWhenModelChange() {

        String[] modelsList = HomePagePE.GetModelsList(driver);
        int[] Range = new int[modelsList.length];
        int error = 0;
        Range[0] = 4000000;
        for (int i = 1; i < modelsList.length; i++) {
            HomePagePE.SelectaModelByIndex(driver, i);
            WaitS.Wait(1000);
            Range[i] = HomePagePE.GetThePriceRange(driver);
            if (Range[i] == Range[i - 1]) {
                System.err.println(modelsList[i]);
                error++;
            }
        }
        assert (error == 0);
        driver.close();
    }

    @Test(priority = 1)
    public void TheNumberOfofferschangeWhenChosingAModelAndLocation() {

        String[] modelsList = HomePagePE.GetModelsList(driver);
        int[] Offers = new int[100];
        int Error = 0;
        Offers[0] = 0;
        HomePagePE.EnterTheLocation(driver, "Paris");
        for (int i = 1; i < modelsList.length; i++) {
            HomePagePE.SelectaModelByIndex(driver, i);
            WaitS.Wait(1000);
            String[] subModelsList = HomePagePE.GetSubModelsList(driver);
            for (int j = 1; j < subModelsList.length; j++) {
                if (subModelsList.length > 2) {
                    HomePagePE.SelectaSubModelByIndex(driver, j);
                    WaitS.Wait(2000);
                }
                Offers[j] = HomePagePE.GetTheOffersNum(driver);
                if (Offers[j] == Offers[j - 1] && Offers[j - 1] != 1) {
                    System.err.println(modelsList[i] + "" + subModelsList[j]);
                    Error++;
                }
            }
        }
        assert (Error == 0);
        driver.close();
    }

}
