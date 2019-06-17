/*
 * Creation : 28 mai 2019
 */
package Peugeot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.WaitS;

public class ProductPage {

    static void ClickOnCarDetails(WebDriver driver) {
        WebElement WE = driver.findElement(By.xpath("//a[@class='btn btn-primary btn-double detail-link clickDetail']"));
        WaitS.WaitForElementToBeVisible(driver, WE);
        WE.click();
    }

    static void ClickOnPriceDetails(WebDriver driver) {
        WebElement WE = driver.findElement(By.xpath("//div[@id='link-details']"));
        WaitS.WaitForElementToBeVisible(driver, WE);
        WE.click();
    }

    static void ClosePriceDetailsPopUp(WebDriver driver) {
        WebElement WE = driver.findElement(By.xpath("//span[@class='tingle-modal__closeIcon']"));
        WaitS.WaitForElementToBeVisible(driver, WE);
        WE.click();
    }

    static int GetTheTTCHOptionPriceFromThePopUp(WebDriver driver) {
        WebElement WE = driver
                .findElement(By.xpath("//div[@class='tingle-modal-box__content']//div[@class='big-text table-cell amount expendable-highlight']"));
        WaitS.WaitForElementToBeVisible(driver, WE);
        String[] Price;
        Price = WE.getText().split(" ");
        return Integer.parseInt(Price[0] + Price[1]);
    }

    static int GetTheTTCPriceFromThePopUp(WebDriver driver) {
        WebElement WE = driver.findElement(By.xpath(
                "//div[@class='tingle-modal-box__content']//div[@class='table-cell big-text bonus-remise amount expendable-highlight-total']"));
        WaitS.WaitForElementToBeVisible(driver, WE);
        String[] Price;
        Price = WE.getText().split(" ");
        return Integer.parseInt(Price[0] + Price[1]);
    }

    static int GetTheTTCPriceFromTheProductPage(WebDriver driver) {
        WebElement WE = driver.findElement(By.xpath("//div[@class='price-val']"));
        WaitS.WaitForElementToBeVisible(driver, WE);
        String[] Price;
        Price = WE.getText().split(" ");
        return Integer.parseInt(Price[0] + Price[1]);
    }

    static Boolean GetThePopupPriceDetailsTitle(WebDriver driver) {
        WebElement WE = driver.findElement(By.xpath("//div[@class='tingle-modal-box__content']//div[@class='order-bar-infos']"));
        WaitS.WaitForElementToBeVisible(driver, WE);
        return WE.isDisplayed();
    }

    static Boolean ThePopupPriceDetailsCloseCrossIsClickable(WebDriver driver) {
        WebElement WE = driver.findElement(By.xpath("//span[@class='tingle-modal__closeIcon']"));
        WaitS.WaitForElementToBeVisible(driver, WE);
        return WE.isEnabled();
    }

    static Boolean GetTheEstmationPopupTitle(WebDriver driver) {
        WebElement WE = driver.findElement(By.xpath("//button[@id='btnEstimerReprise']"));
        WaitS.WaitForElementToBeVisible(driver, WE);
        WE.click();
        return WE.isDisplayed();
    }

    static Boolean ThePopupEstimationCloseCrossIsClickable(WebDriver driver) {
        WebElement WE = driver.findElement(
                By.xpath("//div[@class='tingle-modal tingle-modal--visible']//span[@class='tingle-modal__closeIcon'][contains(text(),'×')]"));
        WaitS.WaitForElementToBeVisible(driver, WE);
        return WE.isEnabled();
    }

    static void OpenEstimation(WebDriver driver) {
        WebElement WE = driver.findElement(By.xpath("//button[@id='btnEstimerReprise']"));
        WaitS.WaitForElementToBeVisible(driver, WE);
        WE.click();
    }

    static void CloseEstimation(WebDriver driver) {
        WebElement WE = driver.findElement(
                By.xpath("//div[@class='tingle-modal tingle-modal--visible']//span[@class='tingle-modal__closeIcon'][contains(text(),'×')]"));
        WaitS.WaitForElementToBeVisible(driver, WE);
        WE.click();
    }

    static void ClickOnExternalView(WebDriver driver) {
        WebElement WE = driver.findElement(By.xpath("//li[@id='external-view']"));
        WaitS.WaitForElementToBeVisible(driver, WE);
        WE.click();
    }

    static void ClickOnInternalView(WebDriver driver) {
        WebElement WE = driver.findElement(By.xpath("//li[@id='internal-view']"));
        WaitS.WaitForElementToBeVisible(driver, WE);
        WE.click();
    }

    static void ClickOn360View(WebDriver driver) {
        WebElement WE = driver.findElement(By.xpath("//li[@id='internal-view-360']"));
        WaitS.WaitForElementToBeVisible(driver, WE);
        WE.click();
    }

    static boolean TheExternalImageIsVisible(WebDriver driver) {
        WebElement WE = driver
                .findElement(By.xpath("//section[@id='external_view_slider']//div[@class='slick-slide slick-current slick-active']//img"));
        WaitS.WaitForElementToBeVisible(driver, WE);
        return WE.isDisplayed();
    }

    static boolean TheInternalImageIsVisible(WebDriver driver) {
        WebElement WE = driver.findElement(By.xpath("//section[@id='internal_view_slider']//img"));
        WaitS.WaitForElementToBeVisible(driver, WE);
        return WE.isDisplayed();
    }

    static boolean The360viewIsVisible(WebDriver driver) {
        WebElement WE = driver.findElement(By.xpath("//section[@id='internal_view_360_slider']//canvas"));
        WaitS.WaitForElementToBeVisible(driver, WE);
        return WE.isDisplayed();
    }

}
