package pageobjectmodel;

import Infosys.Abstractcompount.Abstractcompoun2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class productcatlog2 extends Abstractcompoun2 {
    WebDriver driver;
    public productcatlog2(WebDriver driver){
        super(driver);

        this.driver=driver;
        PageFactory.initElements(driver,this);


    }
    @FindBy(css=".mb-3")
    List<WebElement>product;
    @FindBy(css= "h5 b")
    WebElement text;
    By productlistBy=By.cssSelector(".mb-3");
    By toastermessage1= By.cssSelector("#toast-container");
    //(driver.findElement(By.cssSelector(".ng-animating"))));
    @FindBy(css=".ng-animating")
    WebElement spinner;
    By itemclickbutton=By.cssSelector(".card-body button:last-of-type");
    public List<WebElement>gettingproducrlist(){
        waitingelementtoapper(productlistBy);
        return product;
        //List<WebElement> prodect = driver.findElements(By.cssSelector(".mb-3"));
    }
    public WebElement findingdesirproducts(String prodectname ){
        WebElement prod =gettingproducrlist().stream().filter(product->product.findElement(By.cssSelector("b"))
                .getText().equalsIgnoreCase(prodectname)).findFirst().orElse(null);
        return prod;

    }
    public void additemintocart(String prodectname ){

        WebElement prod= findingdesirproducts( prodectname );
        prod.findElement(itemclickbutton).click();
        waitingelementtoapper(toastermessage1);
        visibilityofelement(spinner);
    }


}
