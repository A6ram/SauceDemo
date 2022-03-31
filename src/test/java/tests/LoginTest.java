package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {


    @DataProvider(name = "Input data for negative tests")
    public Object[][] loginData() {
        return new Object[][]{
                {"test", "", "Epic sadface: Password is required"},
                {"", "test", "Epic sadface: Username is required"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},

        };
    }

    @Test(dataProvider = "Входные данные для негативных тестов")
    public void inputDataForNegative(String user, String password, String error) {

        loginPage.open();
        loginPage.login(user, password);
        assertEquals(loginPage.getError(), error);
    }

    @Test(description = "Проверка валидации user")
    public void userNameShouldBeRequired() {
        loginPage.open();
        loginPage.login("", "test");
        assertEquals(loginPage.getError(), "Epic sadface: Username is required");
    }

    @Test(description = "Проверка заблокированного пользователя")
    public void userNameShouldBeLockedOut() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");
        assertEquals(loginPage.getError(), "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test(description = "Проверка валидации password")
    public void userPasswordIsNotCorrect() {
        loginPage.open();
        loginPage.login("problem_user", "secret_sauce13");
        assertEquals(loginPage.getError(), "Epic sadface: Username and password do not match any user in this service");
    }
}