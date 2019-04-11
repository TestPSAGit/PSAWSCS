/*
 * Creation : 8 avr. 2019
 */
package Peugeot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class PreProdHomePageComponentsPeugeotFranceTest {
    static WebDriver driver;
    HomePagePEComposants hp = new HomePagePEComposants();

    @BeforeSuite
    public void BeforeTest() {

        driver = InitialiseDrivers.InitialiseChromDriver();
        driver.get("https://E562418:Id133499@fr-store-preprod.peugeot.com/Accueil");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.findElement(By.className("psac_noselect")).click();

    }

    // @Test(priority = 1)

    public void ThePageTitleisCorrect() {
        assert (hp.CheckTitlePresent(driver).equals("WEBSTORE"));
    }

    @Test(priority = 2)

    public void ThePeugeotLogoIsDisplayed() {
        assert (hp.CheckLogoPresent(driver) == true);
    }

    @Test(priority = 3)

    public void TheMySaveIconIsDisplayed() {
        assert (hp.CheckLogoMysavePresent(driver) == true);
    }

    @Test(priority = 4)

    public void TheMySaveTextIsDisplayed() {
        assert (hp.CheckTextMysavePresent(driver, "//span[contains(text(),'MES SAUVEGARDES')]").equals("MES SAUVEGARDES"));
    }

    @Test(priority = 5)

    public void TheNeedHelpIconeIsDisplayed() {
        assert (hp.CheckLogoMysavePresent(driver) == true);
    }

    @Test(priority = 6)

    public void TheNeedHelpTextIsDisplayed() {
        assert (hp.CheckTextBesoinDaidePresent(driver).equals("BESOIN D'AIDE"));
    }

    @Test(priority = 7)

    public void TheTextUnderThePageTitleIsCorrect() {
        assert (hp.CheckTextUnderTitlePresent(driver).equals("RECHERCHE ET ACHAT DE VÉHICULES NEUFS PEUGEOT DISPONIBLES IMMÉDIATEMENT"));
    }

    @Test(priority = 8)

    public void GotToHomePageWhenClickingOnThePeugeotLogo() {
        assert (hp.CheckClickOnHeaderPeugeotLogo(driver).contains("fr-store-preprod.peugeot.com/Accueil"));
    }

    @Test(priority = 9)

    public void GotAPopupWhenClickingOnNeedHelpBotton() {
        assert (hp.CheckClickOnNeedHelpLogo(driver) == true);
    }

    @Test(priority = 10)

    public void TheTwiterIconeIsPresent() {
        assert (hp.CheckTheTwiterIconePresence(driver) == true);
    }

    @Test(priority = 11)

    public void TheFacebookIconeIsPresent() {
        assert (hp.CheckTheFacebookIconePresence(driver) == true);
    }

    @Test(priority = 12)

    public void TheYoutubeIconeIsPresent() {
        assert (hp.CheckTheYoutubeIconePresence(driver) == true);
    }

    @Test(priority = 13)
    public void GotTwiterPageWhenClickingTheTwiterIcone() {
        assert (hp.CheckClickOnTwiterIcone(driver).equals("https://twitter.com/PeugeotFR"));
    }

    @Test(priority = 14)

    public void GotFacebookPageWhenClickingTheFacebookIcone() {
        assert (hp.CheckClickOnFacebookIcone(driver).equals("https://www.facebook.com/PeugeotFrance/?fref=ts"));

    }

    @Test(priority = 15)
    public void GotYoutubePageWhenClickingTheyoutubeIcone() {
        assert (hp.CheckClickOnYoutubeIcone(driver).equals("https://www.youtube.com/user/AutoPeugeotFrance"));

    }

    @Test(priority = 16)

    public void TheUserGeneralConditionsTextIsPresent() {
        assert (hp.CheckTheUserGeneralConditionsTextPresence(driver, "//a[contains(text(),\"Conditions générales d'utilisation\")]") == true);
    }

    @Test(priority = 17)

    public void TheSellGeneralConditionsTextIsPresent() {
        assert (hp.CheckThesellGeneralConditionsTextPresence(driver, "//a[contains(text(),'Conditions générales de vente')]") == true);
    }

    @Test(priority = 18)

    public void TheCookiesTextIsPresent() {
        assert (hp.CheckTheCookiestextPresence(driver) == true);
    }

    @Test(priority = 19)

    public void GotTheUserGeneralConditionsPDF() {
        assert (hp.CheckClickOnUserGeneralConditions(driver, "//a[contains(text(),\"Conditions générales d'utilisation\")]"))
                .contains("CGU_PEUGEOT_WEBSTORE.pdf");

    }

    @Test(priority = 20)

    public void GotTheSellGeneralConditionsPDF() {
        assert (hp.CheckClickOnsellGeneralConditions(driver, "//a[contains(text(),'Conditions générales de vente')]")
                .contains("CGV_PEUGEOT_WEBSTORE.pdf"));

    }

    @Test(priority = 21)

    public void GotTheCookiesPopUp() {
        assert (hp.CheckClickOnCookies(driver) == true);
    }

    @AfterSuite

    public void AfterTest() {
        HomePagePEComposants.SwitchToCurrentUrl(driver);
        driver.close();

    }

}
