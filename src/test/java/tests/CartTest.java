package tests;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CartTest extends BaseTest {
    @Test(description = "Проверка добавления/удаления товаров в/из корзины")
    public void productShouldBeAddedIntoCart() {
        loginPage.registration();
        productsPage.chooseThreeItemAndChangeOnTwo();
        String valueSauce = driver.findElement(By.className("shopping_cart_badge")).getText();
        assertEquals(valueSauce, "2");
    }


    @Step("Введен неверный локатор 'RedTest'")
    @Test
    public void mistakeRedTest() {
        productsPage.specialWrongTestForAllureGrafics();


    }

}
