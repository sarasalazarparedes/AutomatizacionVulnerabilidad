package Pages;




import browser.ChromeProxy;
import org.openqa.selenium.WebDriver;


public class BasePage {



    public static BasePage session = null;
    public static WebDriver webDriver;
    public BasePage(){
        webDriver = new ChromeProxy().create();
    }

    public static BasePage getSession(){
        if (session == null)
            session = new BasePage();

        return session;
    }

    public WebDriver getBrowser() {
        return webDriver;
    }
}
