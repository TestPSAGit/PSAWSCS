/*
 * Creation : 29 mars 2019
 */
package Peugeot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultPage {

    static int GetOffersNumber(WebDriver driver) {

        String[] Offers = driver.findElement(By.className("title")).getText().split(" ");
        return Integer.parseInt(Offers[0]);

    }

}
