package tests;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.CheckOutPages;
import pages.LoginPage;
import pages.ProductsPage;

import java.time.Duration;


@Listeners(TestListener.class)
public class BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CheckOutPages checkOutPages;


    @Parameters({"browser"})
    @BeforeMethod
    public void setup(@Optional("chrome") String browser, ITestContext testContext) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setHeadless(true);
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("EDGE")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("Opera")) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
            driver.manage().window().maximize();
        }
        testContext.setAttribute("driver", driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        checkOutPages = new CheckOutPages(driver);
    }


    @AfterMethod(alwaysRun = true)
    public void close() {
        driver.quit();

    }
}



