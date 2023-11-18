package com.qavulnerabilidad.tests;



import Pages.HomePage;
import Pages.LoginPage;
import Pages.NewCustomerPage;
import models.CustomerFormModel;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import session.Session;
import java.util.Random;

public final class  LoginPageTests {
    WebDriver chrome;
    private String email;
    private String password;

    private LoginPageTests()
    {
        super();
    }
    @BeforeMethod
    public void openBrowser() throws Exception {
        Session.getSession().getBrowser().get("http://demo.owasp-juice.shop/");

    }

    @AfterMethod
    public void closeBrowser(){
        Session.getSession().getBrowser().quit();
    }
    @BeforeMethod
    public void setup() throws Exception {
        Thread.sleep(2000);
        new HomePage(chrome).skipBanner().navigateToLogin();
        email = getRandomEmail();
        password="sara2311";
        Thread.sleep(2000);
        CustomerFormModel customerFormModel = new CustomerFormModel.
                CustomerFormBuilder(email,password).
                answer("test").build();

        new NewCustomerPage(chrome).registerNewCustomer(customerFormModel);
    }

    @Test
    public void shouldBeAbleLoginWithValidCredentials() throws Exception {
        Thread.sleep(2000);
        new LoginPage(chrome).withValidCredentials(email,password);
        Thread.sleep(2000);
        Assert.assertEquals(new HomePage(chrome).isLoggedIn(),true);

    }

    private String getRandomEmail(){
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        return "username" + randomInt + "@gmail.com";
    }
}
