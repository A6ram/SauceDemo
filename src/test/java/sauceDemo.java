import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class sauceDemo extends BaseTest {
    @Test
    public void locators() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name"));
        driver.findElement(By.name("user-name"));
        driver.findElement(By.className("input_error from_input"));
        driver.findElement(By.tagName("div"));
        driver.findElement(By.linkText("Sauce Labs Backpack"));
        driver.findElement(By.partialLinkText("Backpack"));
        driver.findElement(By.xpath("//tag[@attribute='class']"));
        driver.findElement(By.xpath("//tag[text()='Sauce Labs Backpack']"));
        driver.findElement(By.xpath("//tag[contains(text(),'Sauce Labs')]"));
        driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='btn btn_secondary btn_small cart_button']//button[text()='Remove']"));


    }

}
