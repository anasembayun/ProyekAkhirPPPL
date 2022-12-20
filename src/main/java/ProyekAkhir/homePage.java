package ProyekAkhir;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePage {
    private WebDriver driver;
    private By formAccount = new By.ByLinkText("Create an Account");
    private By formSignIn = new By.ByLinkText("Sign In");
    
    public homePage(WebDriver driver){this.driver = driver;}
    
    public inputNew createAccount(){
        driver.findElement(formAccount).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new inputNew(driver);
    }
    
    public formSignIn signIn(){
        driver.findElement(formSignIn).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new formSignIn(driver);      
    }
}
