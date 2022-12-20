package ProyekAkhir;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class inputNew {
    private By firstName = new By.ById("firstname");
    private By lastName = new By.ById("lastname");
    private By newsletter = new By.ById("is_subscribed");
    private By email = new By.ById("email_address");
    private By pwd = new By.ById("password");
    private By confirmPwd = new By.ById("password-confirmation");
    private By create = new By.ByXPath("//button[@title=\"Create an Account\"]");

    private WebDriver driver;
    public inputNew(WebDriver driver){
        this.driver = driver;
    }

    public void setFirstName(String query){driver.findElement(firstName).sendKeys(query);
    }
    public void setLastName(String query){driver.findElement(lastName).sendKeys(query);
    }
    public void setNewsletter(){
        driver.findElement(newsletter).click();
    }
    public void setEmail(String query){driver.findElement(email).sendKeys(query);
    }
    public void setPwd(String query){driver.findElement(pwd).sendKeys(query);
    }
    public void setConfirmPwd(String query){driver.findElement(confirmPwd).sendKeys(query);
    }
    public profilePage createButton(){
        driver.findElement(create).click();
        return new profilePage(driver);}
}
