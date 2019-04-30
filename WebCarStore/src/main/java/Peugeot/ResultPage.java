/*
 * Creation : 29 mars 2019
 */
package Peugeot;

import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Methodes.DateManagement;
import Methodes.WaitS;

public class ResultPage {

    static String[] Pages;
    static WebDriver driver;

    static String[] modelsList;

    static int GetOffersNumber(WebDriver driver) {

        String[] Offers = driver.findElement(By.className("title")).getText().split(" ");
        return Integer.parseInt(Offers[0]);

    }

    static boolean GetTTheoffersTitleVisibility(WebDriver driver) {

        return driver.findElement(By.className("stock__title")).isDisplayed();

    }

    static String GetTTheoffersTitleText(WebDriver driver) {

        return driver.findElement(By.className("stock__title")).getText();

    }

    static int GetTTheNumberOfOffers(WebDriver driver) {

        String[] Title = driver.findElement(By.className("stock__title")).getText().split(" ");
        return Integer.parseInt(Title[0]);

    }

    static Date GetDeliveryDateByIndex(WebDriver driver, int Index) {

        String[] Date = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[" + Index + "]/div[1]")).getText().split(" ");

        String DileveryDate = Date[4] + " " + Date[5] + " " + Date[6];
        return DateManagement.FormatDateSplited(DileveryDate);

    }

    static boolean IsTheDateVisible(WebDriver driver, int Index) {

        return driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[" + Index + "]/div[1]/p[1]")).isDisplayed();

    }

    static String[] GetTheModelsListElements(WebDriver driver) {
        driver.findElement(By.xpath("//*[@id=\"filter-form\"]/div[1]/div/div/button")).click();
        WaitS.Wait(2000);
        List<WebElement> List = driver.findElements(By.xpath("//div[@class='btn-group open']//ul[@class='multiselect-container dropdown-menu']"));
        String Models = List.get(0).getText();
        String ModelsList[] = Models.split("\n");
        return ModelsList;

    }

    static void SelectaModelFromTheModelsList(WebDriver driver, int i) {
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/ul[1]/li[" + i + "]/a[1]/label[1]")).click();

    }

}
