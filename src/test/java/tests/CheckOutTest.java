package tests;

import org.testng.annotations.Test;

public class CheckOutTest extends BaseTest {
    @Test(description = "Проверка функциональности покупки товара", retryAnalyzer = Retry.class)
    public void checkOutItems() {
        loginPage.registration();
        productsPage.chooseThreeItemAndChangeOnTwo();
        checkOutPages.userInfo();
        checkOutPages.checkTotalSum();
    }

}
