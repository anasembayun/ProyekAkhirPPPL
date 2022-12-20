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
public class reviewPaymentPage {
    private By checkbox = new By.ByName("billing-address-same-as-shipping");
    private By ship = new By.ByClassName("billing-address-details");
    private By placeOrder = new By.ByXPath(String.format("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button"));
    
    private WebDriver driver;

    public reviewPaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setCheckbox() {
        try{
            WebElement cbox = new WebDriverWait(driver, 10)
            .until(ExpectedConditions.elementToBeClickable(checkbox));
            cbox.click();          
        } catch (Exception e){}
    }
        
    public String getShipText(){
        WebElement address =  driver.findElement(ship);
        String detail = address.getText();
        return detail;
    }  
    

    
    public successPurchase placeOrderButton(){
        try{
            WebElement btn = new WebDriverWait(driver, 10)
            .until(ExpectedConditions.elementToBeClickable(placeOrder));
            btn.click();
            

            WebDriverWait wait2 = new WebDriverWait(driver, 10);
            wait2.until(ExpectedConditions.visibilityOfElementLocated(new By.ByClassName("checkout-success")));
            
        } catch (Exception e){}
        return new successPurchase(driver);
    }
    
   
}
