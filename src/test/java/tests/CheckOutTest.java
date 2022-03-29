package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckOutTest extends BaseTest {
    @Test(description = "Проверка функциональности покупки товара", retryAnalyzer = Retry.class)

    public void orderCompletion() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.addToCart("Sauce Labs Bike Light");
        cartPage.open();
        cartPage.completeTheOrder();
        checkOutPages.infoUser("test", "test", "222525");
        checkOutPages.finishOrder();
        assertEquals(checkOutPages.checkOrderStatus(), "THANK YOU FOR YOUR ORDER");
    }
}
