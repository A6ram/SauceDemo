package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.assertEquals;

public class CheckOutPages extends BasePage {

    public static final By LASTNAME = By.id("last-name");
    public static final By FIRSTNAME = By.id("first-name");
    public static final By ZIPCODE = By.id("postal-code");
    public static final By ERROR_MESSAGE2 = By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]");
    public static final By FINISH_CHECKOUT = By.id("finish");
    public static final By SUCCESSFUL_ORDER = By.className("complete-header");

    public CheckOutPages(WebDriver driver) {
        super(driver);
    }

    public void openUserInfo() {
        driver.get(baseUrl + "checkout-step-one.html");
        wait.until(ExpectedConditions.visibilityOfElementLocated(FIRSTNAME));

    }

    public void infoUser(String firstName, String lastName, String zipCode) {
        driver.findElement(FIRSTNAME).sendKeys(firstName);
        driver.findElement(LASTNAME).sendKeys(lastName);
        driver.findElement(ZIPCODE).sendKeys(zipCode);
        driver.findElement(By.cssSelector("[value=Continue")).click();
    }

    public void userInfo() {
        infoUser("Illia", "Abramovich", "220089");
    }

    public String getError2() {
        return driver.findElement(ERROR_MESSAGE2).getText();
    }

    public void checkTotalSum() {
        String checkTotalSum = driver.findElement(By.cssSelector(".summary_total_label")).getText();
        assertEquals(checkTotalSum, "Total: $43.18");
        driver.findElement(By.id("finish")).click();
        String linktext2 = driver.findElement(By.className("complete-header")).getText();
        System.out.println(linktext2);
        assertEquals(linktext2, "THANK YOU FOR YOUR ORDER");
        driver.findElement(By.id("back-to-products")).click();
    }
    public void finishOrder() {
        driver.findElement(FINISH_CHECKOUT).click();
    }
    public String checkOrderStatus() {
        return driver.findElement(SUCCESSFUL_ORDER).getText();
    }
}
