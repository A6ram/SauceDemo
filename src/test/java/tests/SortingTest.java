package tests;

import org.testng.annotations.Test;

public class SortingTest extends BaseTest {
    @Test(description = "Проверка сортировки по имени и цене товара")
    public void sorting() {

        loginPage.registration();
        productsPage.sort();
    }
}
