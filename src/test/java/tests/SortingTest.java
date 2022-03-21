package tests;

import org.testng.annotations.Test;

public class SortingTest extends BaseTest{
    @Test
    public void sorting(){

        loginPage.registration();
        productsPage.sort();
    }
}
