package com.waytohey.tests;

import com.waytohey.pages.RegistrationPage;
import org.junit.jupiter.api.Test;


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
    }


}
