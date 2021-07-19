package com.galeria.selenide.maven.testng.jr;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class Register {
    SelenideElement meineGaleria = $(byXpath("//*[@id=\"header\"]/div[2]/section[2]/ul/li[1]/div"));
    SelenideElement registerLink = $(byXpath("//a[contains(text(), 'Starten Sie hier.')]"));
    SelenideElement anrede = $(byId("dwfrm_profile_customer_salutation"));
    ElementsCollection optionsAnrede = $$(byXpath("//*[@id='dwfrm_profile_customer_salutation']/option"));

    SelenideElement vorname = $(byId("dwfrm_profile_customer_firstname"));
    SelenideElement name = $(byId("dwfrm_profile_customer_lastname"));
    SelenideElement email = $(byId("dwfrm_profile_customer_email"));
    SelenideElement birthdayDay = $(byId("dwfrm_profile_customer_birthdayDay"));
    SelenideElement birthdayMonth = $(byId("dwfrm_profile_customer_birthdayMonth"));
    SelenideElement birthdayYear = $(byId("dwfrm_profile_customer_birthdayYear"));
    SelenideElement password = $(byId("dwfrm_profile_login_password"));
    SelenideElement passwordConfirm = $(byId("dwfrm_profile_login_passwordconfirm"));
    SelenideElement terms = $(byXpath("//*[@id=\"RegistrationForm\"]/fieldset[2]/div/label"));
    SelenideElement registerSubmit = $(byXpath("//button[@name='dwfrm_profile_confirm']"));

    @BeforeMethod
    void openSite() {
        open("https://www.galeria.de/");
    }

    @Test
    void openRegisterWindow() throws InterruptedException {
        meineGaleria.hover();
        Thread.sleep(1000);
        registerLink.click();
        Thread.sleep(1000);
        anrede.click();
//        anrede.selectOption("Herr");
        for (SelenideElement option : optionsAnrede) {
            System.out.println(option.getText());
            if (option.getText().contains("Herr")) {
                option.click();
                break;
            }
        }
        anrede.click();
        Thread.sleep(1000);
        vorname.sendKeys("Jo");
        name.sendKeys("Rai");
        email.sendKeys("jo@rai.com");
        birthdayDay.sendKeys("23");
        birthdayMonth.sendKeys("04");
        birthdayYear.sendKeys("1974");
        password.sendKeys("12345");
        passwordConfirm.sendKeys("1234");
        terms.click();
        registerSubmit.click();
        Thread.sleep(3000);
    }
}
