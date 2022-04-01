package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class InfoUserTest extends BaseTest {


    @DataProvider(name = "Заполнение полей данных пользователя в корзине")
    public Object[][] formData() {
        return new Object[][]{
                {"", "Jones", "220089", "Error: First Name is required"},
                {"Jack", "", "220089", "Error: Last Name is required"},
                {"Jack", "Jones", "", "Error: Postal Code is required"}
        };
    }

    @Test(dataProvider = "Негативные тесты на заполнение данных ")

    public void allFieldShouldBeRequired(String firstName, String lastName, String postCode, String error) {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        checkOutPages.openUserInfo();
        checkOutPages.infoUser(firstName, lastName, postCode);
        assertEquals(checkOutPages.getError2(), error);
    }

    @Test(description = "Без заполнения lastname")
    public void lastNameShouldBeRequired() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        checkOutPages.openUserInfo();
        checkOutPages.infoUser("Jack", "", "220089");
        assertEquals(checkOutPages.getError2(), "Error: Last Name is required");

    }

    @Test(description = "Без заполнения firstname")
    public void firstNameShouldBeRequired() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        checkOutPages.openUserInfo();
        checkOutPages.infoUser("", "Jones", "22089");
        assertEquals(checkOutPages.getError2(), "Error: First Name is required");
    }

    @Test(description = "Без заполнения zipCode")
    public void zipCodeShouldByRequired() {

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        checkOutPages.openUserInfo();
        checkOutPages.infoUser("Jack", "Jones", "");
        assertEquals(checkOutPages.getError2(), "Error: Postal Code is required");

    }
}
