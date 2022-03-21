package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CartTest extends BaseTest{
        @Test
        public void productShouldBeAddedIntoCart() {
            loginPage.registration();
            productsPage.addToCart("Sauce Labs Backpack");
            String valueSauce = driver.findElement(By.className("shopping_cart_badge")).getText();
            assertEquals(valueSauce,"1");


        }

}
