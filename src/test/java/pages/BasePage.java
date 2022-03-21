package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    String baseUrl ="https://www.saucedemo.com/";
    public BasePage(WebDriver driver){
        this.driver =driver;
        wait= new WebDriverWait(driver,10);
    }
}
