import ProyekAkhir.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestProyekAkhir {
    private static WebDriver driver;
    public static ArrayList<DataProduct> dataProduct = new ArrayList<>();

    @BeforeClass
    public static void setUpClass() {
        WebDriverManager.chromedriver().setup();  
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @Test
    @Order(1)
    public void newAccount() {
        homePage home_page = new homePage(driver);
        inputNew newUser = home_page.createAccount();
        newUser.setFirstName("Angkasa");
        newUser.setLastName("Manggala");
        newUser.setNewsletter();
        newUser.setEmail("inifixbener1@gmail.com");//ini harus diganti tiap testing
        newUser.setPwd("permisiadaorangcakepn1H");
        newUser.setConfirmPwd("permisiadaorangcakepn1H");
        profilePage profile = newUser.createButton();
        String resultUrl = profile.getURL();
        assertEquals("https://magento.softwaretestingboard.com/customer/account/", resultUrl);
    }
    @Test
    @Order(2)
    public void addProductTest () {
        profilePage profile = new profilePage(driver);
        productPage newProducts = profile.selectNew();
        newProducts.clickProduct(0);
        newProducts.setQty(3);
        newProducts.addToCart("3");
        dataProduct.add(new DataProduct(newProducts.getTitle(), newProducts.getQty()));
        newProducts.clickProduct(1);
        newProducts.setQty(2);
        newProducts.addToCart("5");
        dataProduct.add(new DataProduct(newProducts.getTitle(), newProducts.getQty()));
        newProducts.clickIconCart();
        assertEquals(dataProduct.size(), newProducts.getCart().size());
        for (int i = 0; i < dataProduct.size(); i++) {
            assertEquals(dataProduct.get(i).getName(), newProducts.getCart().get(i).getName());
            assertEquals(dataProduct.get(i).getQty(), newProducts.getCart().get(i).getQty());
        }
        newProducts.clickCheckout();
    }

    @Test
    @Order(3)
    public void shippinTest() throws InterruptedException {
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

        successPurchase ty = review.placeOrderButton();
        ty.clickNumberOrder();
    }
}
