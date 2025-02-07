package pageobjectmodel;

import Infosys.Abstractcompount.AbstractCompount;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Cartpage extends AbstractCompount {
    public Cartpage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    WebDriver driver;
    @FindBy(css = "div[class='cartSection'] h3")
    List<WebElement> itemcheck;
    @FindBy(xpath = "//div[@class='subtotal cf ng-star-inserted']//button")
    WebElement Checkout;
    @FindBy(css="button[routerlink='/dashboard/myorders']")
    WebElement order;
    public boolean checkingproductavilability(String prodectname) {
        //List<WebElement> itcmcheck=driver.findElements(By.cssSelector("div[class='cartSection'] h3"));

        boolean ni = itemcheck.stream().anyMatch(it -> it.getText().equalsIgnoreCase(prodectname));
        return ni;

    }

    public checkoutpage goToCheckout() {
        //driver.findElement(By.xpath("//div[@class='subtotal cf ng-star-inserted']//button")).click();
        Checkout.click();
        return new checkoutpage(driver);


    }

}
