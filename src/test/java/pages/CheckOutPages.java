package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.assertEquals;

public class CheckOutPages extends BasePage {

    public static final By USER_LASTNAME = By.id("last-name");
    public static final By USER_FIRSTNAME = By.id("first-name");
    public static final By USER_ZIPCODE = By.id("postal-code");
    public static final By ERROR_MESSAGE2 = By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]");


    public CheckOutPages(WebDriver driver) {
        super(driver);
    }

    public void fillingUserDataForPayment() {
        driver.get(baseUrl + "checkout-step-one.html");
        wait.until(ExpectedConditions.visibilityOfElementLocated(USER_FIRSTNAME));

    }

    @Step("Fill out the purchase form using {firstName},{lastName} and {zipCode}")
    public void infoUser(String firstName, String lastName, String zipCode) {
        driver.findElement(USER_FIRSTNAME).sendKeys(firstName);
        driver.findElement(USER_LASTNAME).sendKeys(lastName);
        driver.findElement(USER_ZIPCODE).sendKeys(zipCode);
        driver.findElement(By.cssSelector("[value=Continue")).click();
    }


    @Step("Receive an error message when filling out a purchase form ")
    public String getError2() {
        return driver.findElement(ERROR_MESSAGE2).getText();
    }

    @Step("Checksum verification for payment")
    public void checkTotalSum() {
        String checkTotalSum = driver.findElement(By.cssSelector(".summary_total_label")).getText();
        assertEquals(checkTotalSum, "Total: $43.18");
        driver.findElement(By.id("finish")).click();
        String linktext2 = driver.findElement(By.className("complete-header")).getText();
        System.out.println(linktext2);
        assertEquals(linktext2, "THANK YOU FOR YOUR ORDER");
        driver.findElement(By.id("back-to-products")).click();
    }
}