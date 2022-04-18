package tests;

import org.testng.annotations.Test;

public class SortingTest extends BaseTest {
    @Test(description = "Sorting alphabetically / ascending and descending prices")
    public void sorting() {

        loginPage.registration();
        productsPage.sort();

    }
    @Test
    public void sort2(){
        loginPage.registration();
        productsPage.sorting("Name (Z to A)");
    }
    @Test
    public void sort3(){
        loginPage.registration();
        productsPage.sorting("Price (low to high)");
    }
    @Test
    public void sort4(){
        loginPage.registration();
        productsPage.sorting("Price (high to low)");
    }


}
