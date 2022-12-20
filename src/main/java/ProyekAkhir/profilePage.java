package ProyekAkhir;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class profilePage {
    private By newProducts = new By.ById("ui-id-3");
    private WebDriver driver;
    public profilePage(WebDriver driver) {
        this.driver = driver;
    }
    public String getURL(){
        return driver.getCurrentUrl();
    }
    public productPage selectNew(){
        driver.findElement(newProducts).click();
        return new productPage(driver);
    }
}
