package Shop;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    @FindBy(id = "payment-option-1-container")
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
        payByCheckOption.click(); // nie klika się
        termsAndConditionsCheck.click();
        placeOrderButton.click();
    }

}
