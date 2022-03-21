package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void passwordShouldBeRequired() {

        loginPage.open();
        loginPage.login("test","");
        assertEquals(loginPage.getError(), "Epic sadface: Password is required");
    }

    @Test
    public void userNameShouldBeRequired() {
        loginPage.open();
        loginPage.login("", "test");
        assertEquals(loginPage.getError(), "Epic sadface: Username is required");
    }

    @Test
    public void userNameShouldBeLockedOut(){
        loginPage.open();
        loginPage.login("locked_out_user","secret_sauce");
        assertEquals(loginPage.getError(),"Epic sadface: Sorry, this user has been locked out.");
    }
    @Test
    public void userPasswordIsNotCorrect(){
        loginPage.open();
        loginPage.login("problem_user","secret_sauce13");
        assertEquals(loginPage.getError(),"Epic sadface: Username and password do not match any user in this service");
    }
}
