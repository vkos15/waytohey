package com.waytohey.tests;

import com.waytohey.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.waytohey.config.Project.projectConfig;


public class RegistrationTest extends TestBase {

    RegistrationPage regPage = new RegistrationPage();

    @Test
    void mainPageTestText() {
        regPage.openMainPage()
                .checkTextonMainPage();
    }

    @Test
    void mainPageTestLogo() {
        regPage.openMainPage()
                .checkLogoOnMainPage();
    }

    @Test
    void submitEmptyForm() {
        regPage.openMainPage()
                .clickSubmit();
        regPage.checkErrorName("Specify your name")
                .checkErrorEmail("Enter your email");


    }

    @Test
    void regWithExistEmail() {
        regPage.openMainPage()
                .fillName("test")
                .fillEmail(projectConfig.exist_email())
                .clickSubmit();
        regPage.checkErrorEmail("This email is already in use");
        $("#mail_dup_login").shouldHave(text("Sign in to your profile?"));

    }


}
