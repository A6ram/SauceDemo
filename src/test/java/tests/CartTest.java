package tests;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CartTest extends BaseTest {
    @Test(description = "Checking for adding / removing goods to / from the basket")
    public void productShouldBeAddedIntoCart() {
        loginPage.registration();
        productsPage.chooseThreeItemAndChangeOnTwo();
        String valueSauce = driver.findElement(By.className("shopping_cart_badge")).getText();
        assertEquals(valueSauce, "2");
    }


}
