package org.example.selenium.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.javacore.Details;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Properties;

import static org.example.javacore.UpdateConfigFile.changeAddProperty;


public class BaseTest/* implements ITestListener */ {

    public static ArrayList passedTestCases;
    public static ArrayList failedTestCases;
    public static ArrayList skippedTestCases;
    protected static Properties properties;
    static String browser;
    static String team;
    static String testCaseType;


    public static WebDriver driver;
    protected static Properties prop;
    String username, password, URL;

    /*  @BeforeSuite
      public void createConfig() throws IOException, InterruptedException {

      }*/
    @BeforeTest()
    public void setUp() throws IOException, InterruptedException, URISyntaxException {
        passedTestCases = new ArrayList();
        failedTestCases = new ArrayList();
        skippedTestCases = new ArrayList();

        String url = "https://admin-dev.smart-tag.net/Account/LoginSMART";
        URI uri = new URI(url);

        changeAddProperty("./src/config/config.properties", "adminPassword", "Chetu@123456");
        changeAddProperty("./src/config/config.properties", "adminURL", uri.toString());
        changeAddProperty("./src/config/config.properties", "adminUsername", "neerajt2@chetu.com");

        changeAddProperty("./src/config/config.properties", "browser", "chrome");
        changeAddProperty("./src/config/config.properties", "team", "Vin");
        changeAddProperty("./src/config/config.properties", "testCaseType", "regression");

        Thread.sleep(2000);
        loadProperties("config");

        browser = prop.getProperty("browser");
        URL = prop.getProperty("adminURL");

        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty(
                    "webdriver.chrome.driver",
                    "src\\drivers\\chromedriver.exe");
            // Instantiate a ChromeDriver class.
            driver = new ChromeDriver();


        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.get(prop.getProperty("adminURL"));

        driver = getDriver();
        LoginPage loginPage = new LoginPage(driver);

        username = prop.getProperty("adminUsername");
        password = prop.getProperty("adminPassword");

        loginPage.selectDistrict("Dev");
        loginPage.enterUsername(username);

        loginPage.enterPassword(password);

        loginPage.clickLoginButton();


    }

    public static Properties loadProperties(String propertiesFile) {
        FileInputStream fis;
        try {
            fis = new FileInputStream("./src/config/" + propertiesFile + ".properties");
        } catch (FileNotFoundException e) {
            System.out.println("\n" + "===== Process terminated due to the following error =====" + "\n\n"
                    + e.getLocalizedMessage());
            throw new RuntimeException(e);
        }
        prop = new Properties();
        try {
            prop.load(fis);
        } catch (IOException e) {
            System.out.println("\n" + "===== Process terminated due to the following error =====" + "\n\n"
                    + e.getLocalizedMessage());
            throw new RuntimeException(e);
        }
        return prop;
    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterTest
    public void afterSuite() {
        getDriver().close();
    }

    @AfterSuite
    public void getRunDetail() {
        Details details = new Details();
        details.sendDetails();
    }
}