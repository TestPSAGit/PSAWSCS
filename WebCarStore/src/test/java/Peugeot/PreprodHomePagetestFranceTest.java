/*
 * Creation : 28 mars 2019
 */
package Peugeot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Utilities.WaitS;

public class PreprodHomePagetestFranceTest {
    static WebDriver driver;
    public ExtentReports extent;
    public ExtentHtmlReporter htmlReports;
    public ExtentTest test;
    String filename = System.getProperty("C:\\Users\\E562418\\Desktop\\Report.html");

    @BeforeMethod
    public void BeforeTest() {

        htmlReports = new ExtentHtmlReporter(filename);
        extent = new ExtentReports();
        extent.attachReporter(htmlReports);
        htmlReports.config().setReportName("PSA Regression testing");
        htmlReports.config().setTheme(Theme.STANDARD);

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

    @Ignore
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

    @AfterTest

    public void tearDown() {
        extent.flush();
    }

    @AfterMethod

    public void checkResults(ITestResult testResults) {

        if (testResults.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "TestFunctions fails");
            test.log(Status.FAIL, testResults.getThrowable());

        } else if (testResults.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, testResults.getThrowable());
        }

    }

}
