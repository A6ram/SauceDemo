package tests;

import org.testng.annotations.Test;


public class CheckOutTest extends BaseTest {

    @Test(description = "Проверка работоспособности сайта и возможность совершить покупку", retryAnalyzer = Retry.class)
    public void checkOutTwoItems() {
        loginPage.registration();
        productsPage.chooseThreeItemAndChangeOnTwo();
        checkOutPages.userInfo();
        checkOutPages.checkTotalSum();
    }


}
