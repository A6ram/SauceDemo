package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LocatorsTest extends BaseTest{
    @Test
    public void locators() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("[value=Login]")).submit();
        String linktext = driver.findElement(By.linkText("Sauce Labs Bike Light")).getText();
        assertEquals(linktext, "Sauce Labs Bike Light");
        String partiallinktext = driver.findElement(By.partialLinkText("Light")).getText();
        assertEquals(partiallinktext, "Sauce Labs Bike Light");
        String text = driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']")).getText();
        assertEquals(text, "Sauce Labs Bolt T-Shirt");
        String containsText = driver.findElement(By.xpath("//div[contains(text(),'Red')]")).getText();
        assertEquals(containsText, "Test.allTheThings() T-Shirt (Red)");
        driver.findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']/ancestor::div[@class='inventory_item']/descendant::button")).click();
        driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']/ancestor::div[@class='inventory_item']/descendant::button")).click();
        driver.findElement(By.xpath("//div[text()='Sauce Labs Onesie']/ancestor::div[@class='inventory_item']/descendant::button")).click();
        String valueSauce = driver.findElement(By.className("shopping_cart_badge")).getText();
        assertEquals(valueSauce,"3");
        driver.findElement(By.className("shopping_cart_link")).click();
        driver.findElement(By.name("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("Illia");
        driver.findElement(By.id("last-name")).sendKeys("Abramovich");
        driver.findElement(By.id("postal-code")).sendKeys("220089");
        driver.findElement(By.cssSelector("[value=Continue")).submit();
        String totalPrice = driver.findElement(By.cssSelector(".summary_total_label")).getText();
        assertEquals(totalPrice,"Total: $79.89");
        driver.findElement(By.id("finish")).click();
        String linktext2 = driver.findElement(By.className("complete-header")).getText();
        System.out.println(linktext2);
        assertEquals(linktext2,"THANK YOU FOR YOUR ORDER");
        driver.findElement(By.id("back-to-products")).click();

    }
}
