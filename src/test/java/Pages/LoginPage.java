package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import session.Session;

public class LoginPage extends BasePage {
    public static By email = By.id("email");
    public static By pass = By.id("password");
    public static By loginButton = By.id("loginButton");
    public static By error = By.className("error");

    public LoginPage(WebDriver webDriver) throws Exception {
        super();
    }

    public void withValidCredentials(String emailId, String password) throws Exception {
        loginWithEmailAndPassword(emailId, password);
    }


    public String withInvalidCredentials(String emailId, String password) throws Exception {
        loginWithEmailAndPassword(emailId, password);
        return   Session.getSession().getBrowser().findElement(error).getText();
    }

    private void loginWithEmailAndPassword(String emailId, String password) throws Exception {
        Thread.sleep(2000);
        Session.getSession().getBrowser().findElement(email).sendKeys(emailId);
        Session.getSession().getBrowser().findElement(pass).sendKeys(password);
        Thread.sleep(2000);
        Session.getSession().getBrowser().findElement(loginButton).click();
    }
}

