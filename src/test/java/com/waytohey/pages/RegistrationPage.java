package com.waytohey.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    private SelenideElement textInformation = $("#staged_reg_partner");
    private SelenideElement imageLogo=$("#form_logo img");
    private  final static String TEXT_ON_MAIN_PAGE = "Irish social network for connecting people Find new friends and relationship";

    @Step("Открываем главную страницу")
    public RegistrationPage openMainPage() {
       open("/");
        return this;

    }

    @Step("Проверяем текст на главной")
    public RegistrationPage checkTextonMainPage() {
        textInformation.shouldHave(Condition.text(TEXT_ON_MAIN_PAGE));
        return this;

    }

    @Step("Проверяем наличие логотипа ")
    public RegistrationPage checkLogoOnMainPage() {
       imageLogo.shouldBe(Condition.visible).shouldHave(Condition.attributeMatching("src",".*.png"));
        return this;

    }



}
