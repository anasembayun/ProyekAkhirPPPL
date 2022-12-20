import ProyekAkhir.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestProyekAkhir {
    private static WebDriver driver;
    
    @BeforeClass
    public static void setUpClass() {
        WebDriverManager.chromedriver().setup();  
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @Test
    public void newAccount() throws InterruptedException{      
        homePage home_page = new homePage(driver);
        inputNew newUser = home_page.createAccount();
        newUser.setFirstName("Angkasa");
        newUser.setLastName("Manggala");
        newUser.setNewsletter();
        newUser.setEmail("angkasla16@gmail.com");//ini harus diganti tiap testing
        newUser.setPwd("permisiadaorangcakepn1H");
        newUser.setConfirmPwd("permisiadaorangcakepn1H");
        profilePage profile = newUser.createButton();
        String resultUrl = profile.getURL();
        Assert.assertEquals("https://magento.softwaretestingboard.com/customer/account/",resultUrl);
        productPage newProducts = profile.selectNew();
        detailPage infoProduct = newProducts.infoProduct();
        Thread.sleep(2000);
        //product 1
        driver.findElement(new By.ById("option-label-size-143-item-169")).click();
        driver.findElement(new By.ById("option-label-color-93-item-57")).click();
        driver.findElement(new By.ById("product-addtocart-button")).click();
        
        //product2
        driver.findElement(new By.ByClassName("product-item-link")).click();
        Thread.sleep(2000);
        driver.findElement(new By.ById("option-label-size-143-item-172")).click();
        driver.findElement(new By.ById("option-label-color-93-item-50")).click();
        driver.findElement(new By.ById("qty")).clear();
        driver.findElement(new By.ById("qty")).sendKeys("2");
        
        driver.findElement(new By.ById("product-addtocart-button")).click();
        Thread.sleep(5000);
        driver.findElement(new By.ByClassName("minicart-wrapper")).click();
        driver.findElement(new By.ById("top-cart-btn-checkout")).click();
        Thread.sleep(15000);
        
        //User memasukkan Shipping Address dan Shipping Method
        formShipping shipping = new formShipping(driver);
        Thread.sleep(5000);
        shipping.setStreet("Jalan Mawar No.17, RT06/RW02");
        shipping.setStreet2("Bedali");
        shipping.setStreet3("Lawang");
        shipping.setCity("Abron");
        shipping.setState("Alaska");
        shipping.setZipcode("55678");
        shipping.setCountry("United States");
        shipping.setPhone("+800 5678 6777");
        shipping.setShippingMethod("tablerate_bestway");
        
        reviewPaymentPage review = shipping.clickNext();
        review.setCheckbox();
//        String result = review.getShipText();
//        Assert.assertEquals("Angkasa Manggala\n" +
//        "Jalan Mawar No.17, RT06/RW02, Bedali, Lawang\n" +
//        "Abron, Alaska 55678\n" +
//        "United States\n" +
//        "+800 5678 6777" ,result);

        successPurchase ty = review.placeOrderButton();
        ty.clickNumberOrder();
        
        
    }
    
    @Test
    public void login() throws InterruptedException{
        homePage home_page = new homePage(driver);
        formSignIn sign_in = home_page.signIn();
        sign_in.setEmail("angkasla11@gmail.com");
        sign_in.setPassword("permisiadaorangcakepn1H");
        profilePage profile = sign_in.signInBtn();
        
        WebElement firstResult = new WebDriverWait(driver, 10)
        .until(ExpectedConditions.elementToBeClickable(By.id("ui-id-3")));
        productPage newProducts = profile.selectNew();
    }
}
