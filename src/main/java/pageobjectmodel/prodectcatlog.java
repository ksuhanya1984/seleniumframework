package pageobjectmodel;

import Infosys.Abstractcompount.AbstractCompount;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class prodectcatlog extends AbstractCompount {
    WebDriver driver;
    public prodectcatlog(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }
    //List<WebElement> prodect = driver.findElements(By.cssSelector(".mb-3"));
    @FindBy(css=".mb-3")
    List<WebElement>prodect;
    @FindBy(css=".ng-animating")
    WebElement spinner;
    By productsBy=(By.cssSelector(".mb-3"));
    //div[class='card-body'] button:last-of-type

    By addproducttocart= By.cssSelector(".card-body button:last-of-type");
    By toastmessage=By.cssSelector("#toast-container");
    @FindBy(css="h5 b")
    WebElement waitproductapp;

    public List<WebElement>getprodrctlist(){
        waituntilelementapper(productsBy);
        return prodect;

    }
    public WebElement getingproductbyname(String prodectname){
        //waitwenelementtoapper(waitproductapp);
        //try equals or equalsIgnorcase
        WebElement prod=getprodrctlist().stream().filter(pt->pt.findElement(By.cssSelector("h5 b"))
                .getText().equalsIgnoreCase(prodectname)).findFirst().orElse(null);
        System.out.println(prod);
        return prod;


    }
    public void  addproducttoc(String prodectname ) throws InterruptedException {
        WebElement prod= getingproductbyname(prodectname);
        //System.out.println(prod);
       // waituntilelementapper(toastmessage);
        prod.findElement(addproducttocart).click();
        waituntilelementapper(toastmessage);
        waitelementodissappear(spinner);
    }


}
