package ProyekAkhir;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class profilePage {

    private Actions action;

    private By gear = By.xpath("//*[@id=\"ui-id-6\"]");
    private By bags = By.xpath("//*[@id=\"ui-id-25\"]");
    private WebDriver driver;
    public profilePage(WebDriver driver) {
        this.driver = driver;
    }
    public String getURL(){
        return driver.getCurrentUrl();
    }
    public productPage selectNew(){
        Actions action = new Actions(driver);
        WebElement menMenuElement = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(gear));
        action.moveToElement(menMenuElement).perform();
        driver.findElement(bags).click();
        return new productPage(driver);
    }
}
