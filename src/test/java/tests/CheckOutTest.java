package tests;

import org.testng.annotations.Test;

public class CheckOutTest extends BaseTest {
    @Test
    public void checkOutItems() {
        loginPage.registration();
        productsPage.chooseThreeItemAndChangeOnTwo();
        checkOutPages.userInfo();
        checkOutPages.checkTotalSum();
    }
}
