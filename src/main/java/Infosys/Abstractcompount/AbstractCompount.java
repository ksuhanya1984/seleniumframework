package Infosys.Abstractcompount;

import pageobjectmodel.Cartpage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjectmodel.orderpage;

import java.time.Duration;

public class AbstractCompount {
    WebDriver driver;
    public AbstractCompount(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }
    @FindBy(css="[routerlink*='cart']")
    WebElement cart;
    @FindBy(css=".ng-animating")
    WebElement spinner;
    By toastmessage=By.cssSelector("#toast-container");
    @FindBy(css="section[class='ta-results list-group ng-star-inserted']")
    WebElement visibiltyofdropdown2;
    @FindBy(css="button[routerlink='/dashboard/myorders']")
    WebElement order;




    public void waituntilelementapper(By findBy) {
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(05));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
        //List<WebElement> prodect = driver.findElements(By.cssSelector(".mb-3"));
    }
    public void waitelementodissappear(WebElement ele){
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(05));
        wait.until(ExpectedConditions.invisibilityOf(ele));

    }
    public  void waitelementtoappear(WebElement findby){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(05));
        wait.until(ExpectedConditions.visibilityOf(findby));

    }

    public Cartpage checkingcartsection(){
        //driver.findElement(By.cssSelector("li button[routerlink*='/dashboard/cart']")).click();
        //waituntilelementapper(toastmessage);
        waitelementodissappear(spinner);
        cart.click();
        Cartpage Cartpage=new Cartpage(driver);
        return Cartpage;
    }
    public orderpage ordersverfing(){
        //driver.findElement(By.cssSelector("button[routerlink='/dashboard/myorders']")).click();
        order.click();
        orderpage orderpage=new  orderpage(driver);
        return orderpage;

    }

}
