package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;


public class LoginPage extends BasePage {

    public static final By USER_INPUT = By.id("user-name");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login-button");
    public static final By ERROR_MESSAGE = By.cssSelector("[data-test=error]");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открыть страницу логина")
    public void open() {
        driver.get(baseUrl);
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
    }


    @Step("Войти через {user} и {password}")
    public void login(String user, String password) {
        driver.findElement(USER_INPUT).sendKeys(user);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).submit();
    }

    @Step("Войти используя open() и login() ")
    public void registration() {
        open();
        login("performance_glitch_user", "secret_sauce");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @Step("Get Error message")
    public String getError() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }


}
