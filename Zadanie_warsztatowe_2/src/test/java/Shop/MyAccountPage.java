package Shop;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    private final WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "ui-autocomplete-input")
    WebElement searchBtn;

    public void searchSweater(String sweater){
        searchBtn.click();
        searchBtn.sendKeys(sweater);
        searchBtn.sendKeys(Keys.ENTER);
    }

}


