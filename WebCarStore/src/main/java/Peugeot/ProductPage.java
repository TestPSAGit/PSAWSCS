/*
 * Creation : 28 mai 2019
 */
package Peugeot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utilities.WaitS;

public class ProductPage {

    static void ClickOnCarDetails(WebDriver driver) {

        WaitS.WaitForElementToBeVisible(driver, "//a[@class='btn btn-primary btn-double detail-link clickDetail']");
        driver.findElement(By.xpath("//a[@class='btn btn-primary btn-double detail-link clickDetail']")).click();

    }

    static void ClickOnPriceDetails(WebDriver driver) {

        WaitS.WaitForElementToBeVisible(driver, "//div[@id='link-details']");
        driver.findElement(By.xpath("//div[@id='link-details']")).click();

    }

    static void ClosePriceDetailsPopUp(WebDriver driver) {

        WaitS.WaitForElementToBeVisible(driver, "//span[@class='tingle-modal__closeIcon']");
        driver.findElement(By.xpath("//span[@class='tingle-modal__closeIcon']")).click();

    }

    static int GetTheTTCHOptionPriceFromThePopUp(WebDriver driver) {

        WaitS.WaitForElementToBeVisible(driver,
                "//div[@class='tingle-modal-box__content']//div[@class='big-text table-cell amount expendable-highlight']");
        String[] Price;

        Price = driver
                .findElement(By.xpath("//div[@class='tingle-modal-box__content']//div[@class='big-text table-cell amount expendable-highlight']"))
                .getText().split(" ");
        return Integer.parseInt(Price[0] + Price[1]);

    }

    static int GetTheTTCPriceFromThePopUp(WebDriver driver) {

        WaitS.WaitForElementToBeVisible(driver,
                "//div[@class='tingle-modal-box__content']//div[@class='table-cell big-text bonus-remise amount expendable-highlight-total']");
        String[] Price;

        Price = driver.findElement(By
                .xpath("//div[@class='tingle-modal-box__content']//div[@class='table-cell big-text bonus-remise amount expendable-highlight-total']"))
                .getText().split(" ");
        return Integer.parseInt(Price[0] + Price[1]);

    }

    static int GetTheTTCPriceFromTheProductPage(WebDriver driver) {

        WaitS.WaitForElementToBeVisible(driver, "//div[@class='price-val']");
        String[] Price;

        Price = driver.findElement(By.xpath("//div[@class='price-val']")).getText().split(" ");
        return Integer.parseInt(Price[0] + Price[1]);

    }

    static Boolean GetThePopupPriceDetailsTitle(WebDriver driver) {
        WaitS.WaitForElementToBeVisible(driver, "//div[@class='tingle-modal-box__content']//div[@class='order-bar-infos']");
        return driver.findElement(By.xpath("//div[@class='tingle-modal-box__content']//div[@class='order-bar-infos']")).isDisplayed();

    }

    static Boolean ThePopupPriceDetailsCloseCrossIsClickable(WebDriver driver) {
        WaitS.WaitForElementToBeVisible(driver, "//span[@class='tingle-modal__closeIcon']");
        return driver.findElement(By.xpath("//span[@class='tingle-modal__closeIcon']")).isEnabled();

    }

    static Boolean GetTheEstmationPopupTitle(WebDriver driver) {
        WaitS.WaitForElementToBeVisible(driver, "//button[@id='btnEstimerReprise']");
        driver.findElement(By.xpath("//button[@id='btnEstimerReprise']")).click();
        return driver.findElement(By.xpath("//div[@class='tingle-modal tingle-modal--visible']//div[@class='EstimationRepriseModal-step1']"))
                .isDisplayed();

    }

    static Boolean ThePopupEstimationCloseCrossIsClickable(WebDriver driver) {
        WaitS.WaitForElementToBeVisible(driver,
                "//div[@class='tingle-modal tingle-modal--visible']//span[@class='tingle-modal__closeIcon'][contains(text(),'×')]");
        return driver
                .findElement(
                        By.xpath("//div[@class='tingle-modal tingle-modal--visible']//span[@class='tingle-modal__closeIcon'][contains(text(),'×')]"))
                .isEnabled();

    }

    static void OpenEstimation(WebDriver driver) {

        WaitS.WaitForElementToBeVisible(driver, "//button[@id='btnEstimerReprise']");
        driver.findElement(By.xpath("//button[@id='btnEstimerReprise']")).click();

    }

    static void CloseEstimation(WebDriver driver) {

        WaitS.WaitForElementToBeVisible(driver,
                "//div[@class='tingle-modal tingle-modal--visible']//span[@class='tingle-modal__closeIcon'][contains(text(),'×')]");
        driver.findElement(
                By.xpath("//div[@class='tingle-modal tingle-modal--visible']//span[@class='tingle-modal__closeIcon'][contains(text(),'×')]")).click();

    }

    static void ClickOnExternalView(WebDriver driver) {

        WaitS.WaitForElementToBeVisible(driver,
                "//div[@class='tingle-modal tingle-modal--visible']//span[@class='tingle-modal__closeIcon'][contains(text(),'×')]");
        driver.findElement(
                By.xpath("//div[@class='tingle-modal tingle-modal--visible']//span[@class='tingle-modal__closeIcon'][contains(text(),'×')]")).click();

    }

    static void ClickOnInternalView(WebDriver driver) {

        WaitS.WaitForElementToBeVisible(driver,
                "//div[@class='tingle-modal tingle-modal--visible']//span[@class='tingle-modal__closeIcon'][contains(text(),'×')]");
        driver.findElement(
                By.xpath("//div[@class='tingle-modal tingle-modal--visible']//span[@class='tingle-modal__closeIcon'][contains(text(),'×')]")).click();

    }

    static void ClickOn360View(WebDriver driver) {

        WaitS.WaitForElementToBeVisible(driver,
                "//div[@class='tingle-modal tingle-modal--visible']//span[@class='tingle-modal__closeIcon'][contains(text(),'×')]");
        driver.findElement(
                By.xpath("//div[@class='tingle-modal tingle-modal--visible']//span[@class='tingle-modal__closeIcon'][contains(text(),'×')]")).click();

    }

}
