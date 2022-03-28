package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {


    @DataProvider(name = "Данные для негативных тестов")
    public Object[][] loginData() {
        return new Object[][]{
                {"test", "", "Epic sadface: Password is required"},
                {"", "test", "Epic sadface: Username is required"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},

        };
    }

    @Test(dataProvider = "Данные для негативных тестов")
    public void passwordShouldBeRequired(String user, String password, String error) {

        loginPage.open();
        loginPage.login(user, password);
        assertEquals(loginPage.getError(), error);
    }

    @Test(description = "Проверка на пригодность пароля")
    public void userPasswordIsNotCorrect() {
        loginPage.open();
        loginPage.login("problem_user", "secret_sauce13");
        assertEquals(loginPage.getError(), "Epic sadface: Username and password do not match any user in this service");
    }


    @Test(description = "Пригодность имени пользователя")
    public void userNameShouldBeRequired() {
        loginPage.open();
        loginPage.login("", "test");
        assertEquals(loginPage.getError(), "Epic sadface: Username is required");
    }

    @Test(description = "Блокировка пользователя")
    public void userNameShouldBeLockedOut() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");
        assertEquals(loginPage.getError(), "Epic sadface: Sorry, this user has been locked out.");
    }

}
