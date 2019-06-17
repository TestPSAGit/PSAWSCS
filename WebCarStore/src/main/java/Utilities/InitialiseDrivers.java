/*
 * Creation : 28 mars 2019
 */
package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class InitialiseDrivers {

    static WebDriver driver;

    public static WebDriver InitialiseChromDriver() {

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        System.setProperty("webdriver.chrome.driver",
                "C:\\\\Users\\\\E562418\\\\Desktop\\\\PSA Selenium Project\\\\ChromeDriver\\\\chromedriver.exe");
        driver = new ChromeDriver(capabilities);

        return driver;
    }

    public static WebDriver InitialiseFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\E562418\\Desktop\\PSA Selenium Project\\geckodriver-v0.24.0-win64\\geckodriver.exe");

        driver = new FirefoxDriver();
        return driver;
    }

    public static WebDriver InitialiseIEDriver() {
        System.setProperty("webdriver.ie.driver", "C:\\Users\\E562418\\Desktop\\IEDriverServer_x64_3.14.0 (2)\\IEDriverServer.exe");

        driver = new InternetExplorerDriver();
        return driver;
    }
}
