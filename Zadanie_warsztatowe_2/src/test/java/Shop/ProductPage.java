package Shop;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {

    private final WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "article[data-id-product='2']")
    WebElement sweaterBtn;

    @FindBy(className = "form-control-select")
    WebElement sizeMenu;

    @FindBy(id = "quantity_wanted")
    WebElement quantityField;

    @FindBy(className = "add-to-cart")
    WebElement addToCardBtn;

    @FindBy(xpath = "//a[contains(text(),'Proceed to checkout')]")
    WebElement goToCheckOutBtn;


    public void pickSweater() {
        sweaterBtn.click();
    }

    public void selectSize(String size) {
        Select select = new Select(sizeMenu);
        select.selectByVisibleText(size);
    }

    public void selectQuantity(int quantity) {
        quantityField.click();
        quantityField.clear();
        quantityField.sendKeys(Keys.BACK_SPACE);// czasem clear() nie usuwało 1
        quantityField.sendKeys(String.valueOf(quantity));
    }

    public void addToCard(){
        addToCardBtn.click();
    }

    public void goToCheckOut(){
        goToCheckOutBtn.click();
    }

}
