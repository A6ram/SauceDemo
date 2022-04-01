package tests;

import org.testng.annotations.Test;

public class SortingTest extends BaseTest {
    @Test(description = "Варианты сортировки товара")
    public void sorting() {

        loginPage.registration();
        productsPage.sort();
    }
}
