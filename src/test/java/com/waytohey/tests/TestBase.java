package com.waytohey.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.waytohey.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.waytohey.config.Project.projectConfig;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://waytohey.com/";
        Configuration.browser="chrome";
        Configuration.browserVersion="77.0";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("77.0");
        //capabilities.setCapability("browserName", "chrome");
       // capabilities.setCapability("browserVersion", "77.0");


        Configuration.browserCapabilities = capabilities;

        //  String url = System.getProperty("url", "selenoid.autotests.cloud/wd/hub/");
        // String remote =projectConfig.remoteDriverUrl();
        Configuration.remote = projectConfig.remoteDriverUrl();
        //  Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub/";

    }

    @AfterEach

    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.closeWebDriver();
    }


}
