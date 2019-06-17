/*
 * Creation : 4 juin 2019
 */
package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementMethodes {
    static WebDriver driver;

    public static void ClickOnXpath(WebElement WE) {
        WaitS.WaitForElementToBeVisible(driver, WE);
        WE.click();
    }
}
