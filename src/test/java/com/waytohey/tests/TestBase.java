package com.waytohey.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
        Configuration.baseUrl="https://waytohey.com/";
    }

    @AfterEach
     void beforeEach() {
     closeWebDriver();
    }


}
