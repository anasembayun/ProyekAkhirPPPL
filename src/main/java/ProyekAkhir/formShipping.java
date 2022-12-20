/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyekAkhir;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author DELL
 */
public class formShipping {
    private By street = new By.ByName("street[0]");
    private By street2 = new By.ByName("street[1]");
    private By street3 = new By.ByName("street[2]");
    private By city = new By.ByName("city");
    private By state = new By.ByName("region_id");
    private By zipcode = new By.ByName("postcode");
    private By country = new By.ByName("country_id");
    private By phone = new By.ByName("telephone");
    private By radio1 = new By.ByXPath("//input[@value='tablerate_bestway']");
    private By radio2 = new By.ByXPath("//input[@value='flatrate_flatrate']");
    private By btn = new By.ByClassName("button");
    private WebDriver driver;

    public formShipping(WebDriver driver) {
        this.driver = driver;
    }

    public void setStreet(String query) {
        driver.findElement(street).sendKeys(query);
    }
    
    public void setStreet2(String query) {
        driver.findElement(street2).sendKeys(query);
    }
    
    public void setStreet3(String query) {
        driver.findElement(street3).sendKeys(query);
    }

    public void setCity(String query) {
        driver.findElement(city).sendKeys(query);
    }

    public void setState(String option) {
        Select dropMenu = new Select(driver.findElement(state));
        dropMenu.selectByVisibleText(option);
    }

    public void setZipcode(String query) {
        driver.findElement(zipcode).sendKeys(query);
    }

    public void setCountry(String option) {
        Select dropMenu = new Select(driver.findElement(country));
        dropMenu.selectByVisibleText(option);
    }

    public void setPhone(String query) {
        driver.findElement(phone).sendKeys(query);
    }

    public void setShippingMethod(String option){
        if(option == "tablerate_bestway"){
            driver.findElement(radio1).click();
        }
        else if(option == "flatrate_flatrate"){
            driver.findElement(radio2).click();
        }
        else{
            System.out.println("no options selected");
        } 
    }
    
    public reviewPaymentPage clickNext(){
        try{
            WebElement next = new WebDriverWait(driver, 10)
            .until(ExpectedConditions.elementToBeClickable(btn));
            next.click();
            
            WebDriverWait wait2 = new WebDriverWait(driver, 10);
            wait2.until(ExpectedConditions.visibilityOfElementLocated(new By.ByClassName("checkout-index-index")));       
        } catch (Exception e){}
        return new reviewPaymentPage(driver);
    }   
}
