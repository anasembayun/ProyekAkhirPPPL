/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyekAkhir;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author DELL
 */
public class formSignIn {
    private By email = new By.ById("email");
    private By password = new By.ById("pass");
    private By btn_signin = new By.ById("send2");
    private WebDriver driver;

    public formSignIn(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmail(String query) {
        driver.findElement(email).sendKeys(query);
    }

    public void setPassword(String query) {
        driver.findElement(password).sendKeys(query);
    }

    public profilePage signInBtn() {
        driver.findElement(btn_signin).click();
        return new profilePage(driver);
    }

    
    
    
}
