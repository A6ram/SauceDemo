package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage {


    public static final By User = By.id("user-name");
    public static final By Password = By.id("password");
    public static final By LoginButton = By.id("login-button");
    public static final By ErrorMessage = By.cssSelector("[data-test=error]");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(baseUrl);
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginButton));
    }


    public void login(String user, String password) {
        driver.findElement(User).sendKeys(user);
        driver.findElement(Password).sendKeys(password);
        driver.findElement(LoginButton).submit();
    }

    public void registration() {
        open();
        login("standard_user", "secret_sauce");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    public String getError() {
        return driver.findElement(ErrorMessage).getText();
    }


}
