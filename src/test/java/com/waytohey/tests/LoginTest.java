package com.waytohey.tests;

import com.waytohey.pages.LoginWindow;
import org.junit.jupiter.api.Test;

import static com.waytohey.tests.TestData.userOK;
import static com.waytohey.tests.TestData.userWrongLog;

public class LoginTest extends TestBase {

    LoginWindow loginWindow = new LoginWindow();




    @Test
    void successLogin() {
        loginWindow.openLoginWindow()
                   .typeLogin(userOK.getLogin())
                   .typePassword(userOK.getPass())
                   .submitLoginForm();

        // loginWindow.checkErrorLoginMessage("User with that username doesn't exist");
    }

    @Test
    void wrongLoginTest() {
        loginWindow.openLoginWindow()
                .typeLogin(userWrongLog.getLogin())
                .typePassword(userWrongLog.getPass())
                .submitLoginForm();

        loginWindow.checkErrorLoginMessage("User with that username doesn't exist");
    }

    @Test
    void emptyLoginTest() {
        loginWindow.openLoginWindow()
                .typeLogin("")
                .typePassword(userWrongLog.getPass())
                .submitLoginForm();

        loginWindow.checkErrorLoginMessage("Please enter your login");
    }

    @Test
    void emptyPassTest() {
        loginWindow.openLoginWindow()
                .typeLogin(userWrongLog.getLogin())
                .typePassword(userWrongLog.getPass())
                .submitLoginForm();

        loginWindow.checkErrorLoginMessage("Please enter your login");
    }








}
