package Shop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BuyTest {

    private static WebDriver driver;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    ProductPage productPage;
    CheckOutPage checkOutPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\m_fil\\Documents\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        myAccountPage = new MyAccountPage(driver);
        productPage = new ProductPage(driver);
        checkOutPage = new CheckOutPage(driver);

    }

    @Test
    public void buySweater() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        loginPage.logIn("mczknnexplqcpnynrf@nbmbb.com", "12345");
        myAccountPage.searchSweater("Hummingbird Printed Sweater");
        productPage.pickSweater();
        productPage.selectSize("M");
        productPage.selectQuantity(5);
        productPage.addToCard();
        productPage.goToCheckOut();
        productPage.goToCheckOut();
        checkOutPage.confirmAddressAndContinue();
        checkOutPage.takeScreenshot("Order confirmation"+System.currentTimeMillis());

    }

    @After
    public void quitBrowser() {
        driver.quit();
    }
}
