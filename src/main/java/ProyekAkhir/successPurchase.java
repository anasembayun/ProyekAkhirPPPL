/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyekAkhir;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author DELL
 */
public class successPurchase {
    private By numberOrder = new By.ByClassName("order-number");
    private WebDriver driver;

    public successPurchase(WebDriver driver) {
        this.driver = driver;
    }
    
    public void clickNumberOrder(){
        try{
            WebElement btn = new WebDriverWait(driver, 10)
            .until(ExpectedConditions.elementToBeClickable(numberOrder));
            btn.click();
            

            WebDriverWait wait2 = new WebDriverWait(driver, 10);
            wait2.until(ExpectedConditions.visibilityOfElementLocated(new By.ByClassName("account")));
            
        } catch (Exception e){}
        
    }
    
}
