package User;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Pages.LoginPage;

        
/**
 *
 * @author July
 */
@TestInstance(Lifecycle.PER_CLASS)
public class LoginSuite {
    
    private WebDriver driver;
    private WebDriverWait wait;
    
    @BeforeAll
    private void setup(){
        this.driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    
    @AfterAll
    private void afterAll(){
        driver.quit();
    }
    
    @Test
    void loginTest(){
        LoginPage login = new LoginPage(this.driver);
        
        wait.until(ExpectedConditions.visibilityOf(login.userNameInput));
        login.userNameInput.sendKeys("standard_user");
        login.passwordInput.sendKeys("secret_sauce");
        login.loginButton.click();
        
        String result = driver.getCurrentUrl();
        
        assertEquals("https://www.saucedemo.com/inventory.html",result);   
    }
    
}
