package Infosys.Abstractcompount;

import pageobjectmodel.cartpage2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Abstractcompoun2   {
    WebDriver driver;
    public Abstractcompoun2(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }
    @FindBy(css="[routerlink*='cart']")
    WebElement cartbutton;
    @FindBy(css=".ng-animating")
    WebElement spinner;
    By toastmessage=By.cssSelector("#toast-container");
    @FindBy(css=".ta-results")
    WebElement visibiltyofdropdown;


    public void waitingelementtoapper(By FindBy){
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(05));
        wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
        //List<WebElement> prodect = driver.findElements(By.cssSelector(".mb-3"));

    }
    public void visibilityofelement(WebElement ele){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(05));
        wait.until(ExpectedConditions.visibilityOf(ele));

    }
    public void elementvisibility(WebElement findby){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(05));
        wait.until(ExpectedConditions.visibilityOf(findby));
    }
    public cartpage2 cart(){
        waitingelementtoapper(toastmessage);
        visibilityofelement(spinner);
        cartbutton.click();
        cartpage2 cartpage2=new cartpage2(driver);
        return cartpage2;


    }
}
