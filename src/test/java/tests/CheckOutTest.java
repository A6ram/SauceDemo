package tests;

import org.testng.annotations.Test;


public class CheckOutTest extends BaseTest {

    @Test(description = "checking the functionality of the site and the ability to make a purchase", retryAnalyzer = Retry.class)
    public void checkOutTwoItems() {
        loginPage.registration();
        productsPage.chooseThreeItemAndChangeOnTwo();
        checkOutPages.infoUser("Illia", "Abramovich", "220089");
        checkOutPages.checkTotalSum();
    }


}
