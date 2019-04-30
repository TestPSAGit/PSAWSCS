/*
 * Creation : 17 avr. 2019
 */
package Peugeot;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Methodes.WaitS;

public class TestFunctions {
    static WebDriver driver;
    static Date DeliveryDate;
    static Date currentDate;

    @BeforeSuite
    public void BeforeTest() {

        driver = InitialiseDrivers.InitialiseChromDriver();
        driver.get(
                "http://fr.store.peugeot.inetpsa.com/Recherche-par-critere?lat=48.856614&lng=2.3522219000000177&LocationL=Paris%2C%20France&etd=0&mbd=1PIAS0000030;");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.findElement(By.className("psac_noselect")).click();

    }

    @Test

    public void TheListOfModels() {

        String[] Models = ResultPage.GetTheModelsListElements(driver);
        driver.findElement(By.xpath("//*[@id=\"filter-form\"]/div[1]/div/div/button")).click();
        for (int i = 1; i < Models.length + 1; i++) {

            driver.findElement(By.xpath("//*[@id=\"filter-form\"]/div[1]/div/div/button")).click();
            WaitS.WaitForElementToBeVisible(driver,
                    "/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/ul[1]/li[" + i + "]/a[1]/label[1]");
            ResultPage.SelectaModelFromTheModelsList(driver, i);
            System.out.println(Models[i - 1].toLowerCase());

            WaitS.Wait(3000);
        }
    }

}
// label[contains(text(),'ion, 5 portes')]
// label[contains(text(),'iOn, 5 portes')]
