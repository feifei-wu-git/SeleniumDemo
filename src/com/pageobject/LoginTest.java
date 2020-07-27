package pageobject;

import org.openqa.selenium.WebDriver;

public class LoginTest {

    public static void login(WebDriver webDriver,String username,String pwd){
        webDriver.findElement(PageElements.username).sendKeys(username);
        webDriver.findElement(PageElements.pwd).sendKeys(pwd);
        webDriver.findElement(PageElements.loginButton).click();

    }
}
