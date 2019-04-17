/*
 * Creation : 17 avr. 2019
 */
package Peugeot;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Methodes.WaitS;

public class Widget {

    static String[] refineList;
    static String[] ModelsList;

    static String[] GetMdelList(WebDriver driver) {
        WaitS.Wait(4000);
        driver.findElement(By.xpath("//span[@class='ng-tns-c5-1 ng-star-inserted']")).click();
        WaitS.Wait(2000);
        List<WebElement> elementsRoot = driver.findElements(By.xpath("//div[@id='checkboxesModel']"));

        refineList = new String[elementsRoot.size()];
        for (int i = 0; i < elementsRoot.size(); ++i) {
            refineList[i] = elementsRoot.get(i).getText();

        }
        return refineList;
    }

    static String[] GetRefineList(WebDriver driver) {
        WaitS.Wait(4000);
        driver.findElement(By.xpath("//div[@class='stock__selectBox stock__select-picto']//span[@class='stock__icon-arrow-bottom']")).click();
        WaitS.Wait(2000);
        List<WebElement> elementsRoot = driver.findElements(By.xpath("//div[@class='stock__sort__sorting__choices ng-tns-c1-0 ng-star-inserted']"));

        ModelsList = elementsRoot.get(0).getText().split("\\\\r?\\\\n");
        return ModelsList;
    }

    // refineList = elementsRoot.get(0).getText().split(regex);
    // return refineList;
}
