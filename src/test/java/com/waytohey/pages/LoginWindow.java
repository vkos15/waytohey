package com.waytohey.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginWindow {

    private SelenideElement login = $("#input_login");
    private SelenideElement password = $("#input_pass");
    private SelenideElement submitLogin = $("#form_login [type='submit'].accept_btn");

    public LoginWindow openLoginWindow() {
        open("/#login");
        return this;

    }

    public LoginWindow typeLogin(String login) {
        this.login.setValue(login);
        return this;
    }

    public LoginWindow typePassword(String password) {
        this.password.setValue(password);
        return this;
    }

    public void submitLoginForm() {
        submitLogin.click();
    }

    public LoginWindow checkErrorLoginMessage(String error) {
        $("#input_login+i.error_message").shouldBe(visible).shouldHave(text(error));
        return this;
    }







}
