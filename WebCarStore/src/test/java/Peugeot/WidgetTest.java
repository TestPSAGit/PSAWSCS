/*
 * Creation : 17 avr. 2019
 */
package Peugeot;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class WidgetTest {
    static WebDriver driver;
    Widget WD = new Widget();

    @BeforeSuite
    public void BeforeTest() {

        driver = InitialiseDrivers.InitialiseChromDriver();
        driver.get("https://test-widget.stockengine.awsmpsa.com/demo/#/?geodistance=25;38.569441;-8.90169370000001;Palmela&budget=12554;60577");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        // driver.findElement(By.className("psac_noselect")).click();

    }

    @Test(priority = 1)

    public void TheListOfModels() {
        String[] ModelsList = WD.GetModelsList(driver);
        for (int i = 0; i < ModelsList.length; i++) {

            System.out.println(ModelsList[i]);
        }

        assert (1 == 1);
    }

    @Test(priority = 2)

    public void TheListofFilters() {
        String[] RefineList = WD.GetRefineList(driver);
        for (int i = 0; i < RefineList.length; i++) {

            System.out.println(RefineList[i]);
        }

        assert (1 == 1);
    }
}
