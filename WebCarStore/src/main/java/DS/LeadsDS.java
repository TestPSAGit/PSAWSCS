/*
 * Creation : 1 avr. 2019
 */
package DS;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeadsDS {

    public static void FillContactFormFrance(WebDriver driver) {
        driver.findElement(By.xpath("//label[2]//span[1]")).click();
        driver.findElement(By.id("txtLastname")).sendKeys("test");
        driver.findElement(By.id("txtFirstname")).sendKeys("test");
        driver.findElement(By.id("txtPostalCode")).sendKeys("92220");
        driver.findElement(By.id("txtCity")).sendKeys("test");
        driver.findElement(By.id("txtEmail")).sendKeys("psaleadstest@gmail.com");
        driver.findElement(By.id("txtPhone")).sendKeys("0666666666");
        driver.findElement(By.id("txtComments")).sendKeys("this is a test for france");
    }

    static void FillContactFormSpain(WebDriver driver) {
        driver.findElement(By.xpath("//label[2]//span[1]")).click();
        driver.findElement(By.id("txtLastname")).sendKeys("test");
        driver.findElement(By.id("txtFirstname")).sendKeys("test");
        driver.findElement(By.id("txtPostalCode")).sendKeys("23443");
        driver.findElement(By.id("txtEmail")).sendKeys("mohammed.filali@ext.mpsa.com");
        driver.findElement(By.id("txtPhone")).sendKeys("0666666666");
        driver.findElement(By.id("txtComments")).sendKeys("this is a test for spain");
        WebElement Loca = driver.findElement(By.name("address"));
        Loca.sendKeys("Madrid");
        Loca.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='icon-chevron']")));
        driver.findElement(By.xpath("//i[@class='icon-chevron']")).click();
        driver.findElement(By.id("0000051858")).click();
        driver.findElement(By.xpath("//span[@class='alt-checkbox']")).click();
    }

    static void FillContactFormItaly(WebDriver driver) {
        driver.findElement(By.xpath("//p[1]//label[2]//span[1]")).click();
        driver.findElement(By.id("txtLastname")).sendKeys("test");
        driver.findElement(By.id("txtFirstname")).sendKeys("test");
        driver.findElement(By.id("txtPostalCode")).sendKeys("23443");
        driver.findElement(By.id("txtCity")).sendKeys("test");
        driver.findElement(By.id("txtEmail")).sendKeys("psaleadstest@gmail.com");
        driver.findElement(By.id("txtPhone")).sendKeys("0666666666");
        driver.findElement(By.id("txtComments")).sendKeys("this is a test for Italy");
        driver.findElement(By.xpath("//p[7]//label[2]//span[1]")).click();
        driver.findElement(By.xpath("//p[@class='form-line control-group radiobutton-list no-bg']//label[3]//span[1]")).click();
    }

    static void FillContactFormBelgiumFR(WebDriver driver) {
        driver.findElement(By.xpath("//*[@id=\"contact-form\"]/div/div/div[1]/p[1]/label[1]/span")).click();
        driver.findElement(By.id("txtLastname")).sendKeys("test");
        driver.findElement(By.id("txtFirstname")).sendKeys("test");
        driver.findElement(By.id("txtCity")).sendKeys("test");
        driver.findElement(By.id("txtEmail")).sendKeys("psaleadstest@gmail.com");
        driver.findElement(By.id("txtPhone")).sendKeys("0666666666");
        driver.findElement(By.id("txtComments")).sendKeys("this is a test for Belgium FR");
        WebElement Loca = driver.findElement(By.name("address"));
        Loca.sendKeys("Bruxelles");
        Loca.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='icon-chevron']")));
        driver.findElement(By.xpath("//i[@class='icon-chevron']")).click();
        driver.findElement(By.id("0000051009")).click();
        driver.findElement(By.xpath("//*[@id=\"contact-form\"]/div/div/div[1]/div[9]/p[1]/label/span")).click();

    }

    static void FillContactFormBelgiumNL(WebDriver driver) {
        driver.findElement(By.xpath("//*[@id=\"contact-form\"]/div/div/div[1]/p[1]/label[1]/span")).click();
        driver.findElement(By.id("txtLastname")).sendKeys("test");
        driver.findElement(By.id("txtFirstname")).sendKeys("test");
        driver.findElement(By.id("txtCity")).sendKeys("test");
        driver.findElement(By.id("txtEmail")).sendKeys("psaleadstest@gmail.com");
        driver.findElement(By.id("txtPhone")).sendKeys("0666666666");
        driver.findElement(By.id("txtComments")).sendKeys("this is a test for Belgium FR");
        WebElement Loca = driver.findElement(By.name("address"));
        Loca.sendKeys("Bruxelles");
        Loca.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='icon-chevron']")));
        driver.findElement(By.xpath("//i[@class='icon-chevron']")).click();
        driver.findElement(By.id("0000051009")).click();
        driver.findElement(By.xpath("//*[@id=\"contact-form\"]/div/div/div[1]/div[9]/p[1]/label/span")).click();

    }

    static void FillContactFormSwidzerland(WebDriver driver) {
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/section[1]/form[1]/div[1]/div[1]/div[1]/p[1]/label[2]/span[1]")).click();
        driver.findElement(By.id("txtLastname")).sendKeys("test");
        driver.findElement(By.id("txtFirstname")).sendKeys("test");
        driver.findElement(By.id("tbContactAddress1")).sendKeys("11 test");
        driver.findElement(By.id("txtPostalCode")).sendKeys("2344");
        driver.findElement(By.id("txtCity")).sendKeys("test");
        driver.findElement(By.id("txtEmail")).sendKeys("psaleadstest@gmail.com");
        driver.findElement(By.id("txtPhone")).sendKeys("0666666666");
        driver.findElement(By.id("txtComments")).sendKeys("this is a test for Swidzerland");
    }

    static void ClickSubmitButton(WebDriver driver) {
        driver.findElement(By.id("lnkBtnValidate")).click();
    }

    static boolean GetTheConfirmationMessage(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='title']")));
        boolean message = driver.findElement(By.xpath("//p[@class='title']")).isDisplayed();
        return message;

    }
}
