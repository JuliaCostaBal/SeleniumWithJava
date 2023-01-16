package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author July
 */
public class LoginPage {
    
    @FindBy(xpath = "//input[@data-test=\"username\"]")
    public WebElement userNameInput;
    
    @FindBy(xpath = "//input[@data-test=\"password\"]")
    public WebElement passwordInput;
    
    @FindBy(xpath = "//input[@data-test=\"login-button\"]")
    public WebElement loginButton;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
