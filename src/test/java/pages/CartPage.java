package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    public static final By CART_CLICK = By.id("shopping_cart_container");
    public static final By ITEM_NAME = By.className("inventory_item_name");
    public static final By ITEM_PRICE = By.className("inventory_item_price");
    public static final By CART_ITEMS = By.className("cart_item_label");
    public static final By CHECKOUT_BUTTON = By.id("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(baseUrl + "/cart.html");
    }

    public String getItemsName() {
        return driver.findElement(By.className("inventory_item_name")).getText();
    }

    public String getItemsPrice(String product) {
        return driver.findElement(By.className("inventory_item_price")).getText();
    }

    public void removeFromCartPage() {
        driver.findElement(By.className("btn_secondary")).click();
    }

    public void completeTheOrder() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }
}
