/*
 * Creation : 20 mai 2019
 */
package DS;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Utilities.InitialiseDrivers;

public class HPCompESTest {
    static WebDriver driver;
    HomePageComponentsDS hp = new HomePageComponentsDS();
    static ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/TestReport.html");
    ExtentReports extent = new ExtentReports();

    @BeforeSuite
    public void BeforeTest() {

        driver = InitialiseDrivers.InitialiseChromDriver();
        driver.get("http://E562418:Id133499@dsonlinestore.dsautomobiles.es/Home");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        hp.CloseCokies(driver);
        // driver.findElement(By.className("psac_noselect")).click();
        extent.attachReporter(reporter);

    }

    @Test(priority = 1)

    public void ThePageTitleisCorrect() {

        assert (hp.CheckTitlePresent(driver).equals("ONLINE STORE"));
    }

    @Test(priority = 1)

    public void ThePageTitleBrandisCorrect() {

        assert (hp.CheckTitleBrandPresent(driver).equals("DS"));
    }

    @Test(priority = 2)

    public void ThePeugeotLogoIsDisplayed() {
        assert (hp.CheckLogoPresent(driver) == true);
    }

    @Test(priority = 3)

    public void TheTextUnderThePageTitleIsCorrect() {

        assert (hp.CheckTextUnderTitlePresent(driver).equals("Compra de vehículos DS nuevos y seminuevos cerca de usted"));
    }

    @Test(priority = 4)

    public void GotToHomePageWhenClickingOnTheCitënLogo() {
        assert (hp.CheckClickOnHeaderDSLogo(driver).contains("dsonlinestore.dsautomobiles.es/Home"));
    }

    @Test(priority = 6)

    public void TheFacebookIconeIsPresent() {
        assert (hp.CheckTheFacebookIconePresence(driver) == true);
    }

    @Test(priority = 7)

    public void GotFacebookPageWhenClickingTheFacebookIcone() {
        assert (hp.CheckClickOnFacebookIcone(driver).equals("https://www.facebook.com/DSEspagnaOfficiel/?brand_redir=251470375047890"));

    }

    @Test(priority = 8)

    public void TheUserGeneralConditionsTextIsPresent() {
        assert (hp.CheckTheUserGeneralConditionsTextPresence(driver, "//a[contains(text(),'Condiciones generales de uso')]") == true);
    }

    @Test(priority = 9)

    public void TheCookiesTextIsPresent() {
        assert (hp.CheckTheCookiestextPresence(driver) == true);
    }

    @Test(priority = 10)

    public void GotTheUserGeneralConditionsPDF() {
        assert (hp.CheckClickOnUserGeneralConditions(driver, "//a[contains(text(),'Condiciones generales de uso')]"))
                .contains("https://dsonlinestore.dsautomobiles.es/TemplatesHTML/MentionsPages/es-ES/mention_global_fs.htm");

    }

    @Test(priority = 10)

    public void GotTheUserGeneralConditionsPage() {
        assert (hp.CheckClickOnUserGeneralConditionsPageTitle(driver, "//a[contains(text(),'Condiciones generales de uso')]"))
                .contains("Condiciones generales de uso");

    }

    @Test(priority = 11)

    public void GotTheCookiesPopUp() {
        assert (hp.CheckClickOnCookies(driver) == true);

    }

    @Test(priority = 17)

    public void TheTwiterIconeIsPresent() {
        assert (hp.CheckTheTwiterIconePresence(driver) == true);
    }

    @Test(priority = 18)

    public void TheYoutubeIconeIsPresent() {
        assert (hp.CheckTheYoutubeIconePresence(driver) == true);
    }

    @Test(priority = 19)
    public void GotTwiterPageWhenClickingTheTwiterIcone() {
        assert (hp.CheckClickOnTwiterIcone(driver).equals("https://twitter.com/DS_Espana"));
    }

    @Test(priority = 20)
    public void GotYoutubePageWhenClickingTheyoutubeIcone() {
        assert (hp.CheckClickOnYoutubeIcone(driver).equals("https://www.youtube.com/user/DSSpainOfficial"));

    }

    @AfterSuite

    public void AfterTest() {
        HomePageComponentsDS.SwitchToCurrentUrl(driver);
        driver.close();

    }
}
