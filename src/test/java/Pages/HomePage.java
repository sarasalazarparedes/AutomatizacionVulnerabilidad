package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import session.Session;

public class HomePage extends BasePage {

    public static By welcomeBanner = By.xpath("(//button[contains(@aria-label,'Close Welcome Banner')])[1]");
    public static By myAccount = By.id("navbarAccount");
    public static By login = By.id("navbarLoginButton");
    public static By logoutButton = By.id("navbarLogoutButton");

    public HomePage(WebDriver webDriver) throws Exception {
        super();
    }


    public HomePage skipBanner() throws Exception {
        Session.getSession().getBrowser().findElement(welcomeBanner).click();
        return this;
    }

    public void navigateToLogin() throws Exception {
        Thread.sleep(2000);
        Session.getSession().getBrowser().findElement(myAccount).click();
        Thread.sleep(2000);
        Session.getSession().getBrowser().findElement(login).click();
    }
    public boolean isLoggedIn() throws Exception {
        Thread.sleep(2000);
        Session.getSession().getBrowser().findElement(this.myAccount).click();
        Thread.sleep(2000);
        return   Session.getSession().getBrowser().findElement(this.logoutButton).isDisplayed();
    }
}
