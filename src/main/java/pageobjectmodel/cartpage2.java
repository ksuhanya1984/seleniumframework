package pageobjectmodel;

import Infosys.Abstractcompount.Abstractcompoun2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class cartpage2 extends Abstractcompoun2 {
    WebDriver driver;
    public cartpage2(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }
    @FindBy(css="div[class='cartSection'] h3")
    List<WebElement> productchecking;
    @FindBy(xpath="//div[@class='subtotal cf ng-star-inserted']//button")
    WebElement checkoutproduct;
    public boolean productchecking(String prodectname){

        //List<WebElement> itcmcheck=driver.findElements(By.cssSelector("div[class='cartSection'] h3"));

        boolean ni=productchecking.stream().anyMatch(it->it.getText().equalsIgnoreCase(prodectname));
        return ni;
    }
    public Finalpage checkout(){
        checkoutproduct.click();
        Finalpage Finalpage =new Finalpage(driver);
        return Finalpage;
    }

}


