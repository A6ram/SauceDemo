package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static org.testng.Assert.assertEquals;

public class ProductsPage extends BasePage {

    public static final By PAGE_TITLE = By.cssSelector(".title");
    String productLocator = "//div[text()='%s']/ancestor::div[@class='inventory_item']//button[text()='Add to cart']";
    String productLocatorDelete = "//div[text()='%s']/ancestor::div[@class='inventory_item']//button[text()='Remove']";
    By sort = By.cssSelector(".product_sort_container");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(baseUrl + "inventory.html");
    }

    public void addToCart(String product) {
        driver.findElement(By.xpath(String.format(productLocator, product))).click();
    }

    public void deleteToCart(String product) {
        driver.findElement(By.xpath(String.format(productLocatorDelete, product))).click();
        String valueSauce = driver.findElement(By.className("shopping_cart_badge")).getText();
        assertEquals(valueSauce, "x");
    }

    public String getTitle() {
        return driver.findElement(PAGE_TITLE).getText();
    }

    public void waitForLoading() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PAGE_TITLE));
    }


    public void chooseThreeItemAndChangeOnTwo() {
        addToCart("Sauce Labs Backpack");
        addToCart("Sauce Labs Bike Light");
        addToCart("Sauce Labs Bolt T-Shirt");
        deleteToCart("Sauce Labs Bolt T-Shirt");
        driver.findElement(By.id("shopping_cart_container")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Your Cart']")));
        String name = driver.findElement(By.id("checkout")).getText();
        assertEquals(name, "CHECKOUT");
        driver.findElement(By.id("checkout")).click();
    }

    public void goToTheCart() {
        driver.findElement(By.id("shopping_cart_container")).click();
    }


    public void sort() {
        WebElement sortingElement = driver.findElement(sort);
        Select select = new Select(driver.findElement(By.cssSelector(".product_sort_container")));
        String fromAtoZ = driver.findElement(By.className("active_option")).getText();
        assertEquals(fromAtoZ, "NAME (A TO Z)");
        driver.findElement(By.xpath("//*[@id='header_container']/div[2]/div[2]/span/select/option[3]")).click();
        String lowToHigh = driver.findElement(By.className("active_option")).getText();
        assertEquals(lowToHigh, "PRICE (LOW TO HIGH)");
        driver.findElement(By.xpath("//*[@id='header_container']/div[2]/div[2]/span/select/option[4]")).click();
        String highToLow = driver.findElement(By.className("active_option")).getText();
        assertEquals(highToLow, "PRICE (HIGH TO LOW)");
    }
    public void removeFromCart() {
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();
    }
}