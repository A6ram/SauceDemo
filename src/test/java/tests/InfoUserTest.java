package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class InfoUserTest extends BaseTest {


    @DataProvider(name = "Заполнение полей данных пользователя в корзине")
    public Object[][] formData() {
        return new Object[][]{
                {"", "blabla", "12345", "Error: First Name is required"},
                {"blabla", "", "12345", "Error: Last Name is required"},
                {"blabla", "blabla", "", "Error: Postal Code is required"}
        };
    }

    @Test(dataProvider = "Заполнение полей данных пользователя в корзине")

    public void allFieldShouldBeRequired(String firstName, String lastName, String postCode, String error) {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        checkOutPages.openUserInfo();
        checkOutPages.infoUser(firstName, lastName, postCode);
        assertEquals(checkOutPages.getError2(), error);
    }

    @Test
    public void zipCodeShouldByRequired() {

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        checkOutPages.openUserInfo();
        checkOutPages.infoUser("test", "test", "");
        assertEquals(checkOutPages.getError2(), "Error: Postal Code is required");

    }

    @Test
    public void lastNameShouldBeRequired() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        checkOutPages.openUserInfo();
        checkOutPages.infoUser("test", "", "11111");
        assertEquals(checkOutPages.getError2(), "Error: Last Name is required");

    }

    @Test
    public void firstNameShouldBeRequired() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        checkOutPages.openUserInfo();
        checkOutPages.infoUser("", "test", "11111");
        assertEquals(checkOutPages.getError2(), "Error: First Name is required");
    }


}
