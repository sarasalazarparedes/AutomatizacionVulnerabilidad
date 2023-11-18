package Pages;


import models.CustomerFormModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import session.Session;

public class NewCustomerPage extends BasePage {
    public static By newCustomerLink = By.id("newCustomerLink");
    public static By email = By.id("emailControl");
    public static By password = By.id("passwordControl");
    public static By repeatPassword = By.id("repeatPasswordControl");
    public static By selectOption = By.xpath(".//*[contains(@class,'mat-option-text')]");
    public static By openDropDown = By.className("mat-select-arrow");
    public static By securityAnswer = By.id("securityAnswerControl");
    public static By registerButton = By.id("registerButton");

    public NewCustomerPage(WebDriver webDriver) throws Exception {
        super();
    }

    public void registerNewCustomer(CustomerFormModel customerFormModel) throws Exception {
        Session.getSession().getBrowser().findElement(newCustomerLink).click();
        Session.getSession().getBrowser().findElement(email).sendKeys(customerFormModel.getEmail());
        Session.getSession().getBrowser().findElement(password).sendKeys(customerFormModel.getPassword());
        Session.getSession().getBrowser().findElement(repeatPassword).sendKeys(customerFormModel.getPassword());
        Session.getSession().getBrowser().findElement(openDropDown).click();
        Thread.sleep(2000);
        Session.getSession().getBrowser().findElement(selectOption).click();
        Thread.sleep(2000);
        Session.getSession().getBrowser(). findElement(securityAnswer).sendKeys(customerFormModel.getAnswer());
        Thread.sleep(2000);
        Session.getSession().getBrowser().findElement(registerButton).click();
    }
}
