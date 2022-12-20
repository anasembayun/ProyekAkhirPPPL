package ProyekAkhir;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class productPage {
    private By detailProduct = new By.ByXPath("//li[@class=\"product-item\"]");
    private WebDriver driver;
    public productPage(WebDriver driver){this.driver = driver;}
    public detailPage infoProduct(){
        driver.findElements(detailProduct).get(0).click();
        return new detailPage(driver);
    }
}
