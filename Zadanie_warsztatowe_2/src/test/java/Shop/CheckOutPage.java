package Shop;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;


public class CheckOutPage {

    private final WebDriver driver;

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "address-item")
    WebElement addressBoxCheck;

    @FindBy(name = "confirm-addresses")
    WebElement continueBtn;

    @FindBy(css = "label[for='delivery_option_8']")
    WebElement selfPickUpOption;

    @FindBy(name = "confirmDeliveryOption")
    WebElement confirmDeliveryOptionBtn;

    @FindBy(id = "payment-option-1")
    WebElement payByCheckOption;

    @FindBy(className = "condition-label")
    WebElement termsAndConditionsCheck;

    @FindBy(css = "#payment-confirmation button.btn-primary")
    WebElement placeOrderButton;

    public void confirmAddressAndContinue() {
        WebElement checkButton = addressBoxCheck.findElement(By.tagName("input"));
        Assert.assertTrue("Adres nie jest zaznaczony!", checkButton.isSelected());
        continueBtn.click();
        selfPickUpOption.click();
        confirmDeliveryOptionBtn.click();
        payByCheckOption.click();
        termsAndConditionsCheck.click();
        placeOrderButton.click();
    }

    public void takeScreenshot(String filename) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("C:\\Users\\m_fil\\Desktop\\CodersLab\\Zadanie warsztatowe 2\\Zadanie_Warsztatowe_2\\Zadanie_warsztatowe_2\\screenshots\\" + filename + ".jpg");
        try {
            FileHandler.copy(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to save screemshot: " + e.getMessage());
        }
    }

}
