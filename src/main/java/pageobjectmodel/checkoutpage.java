package pageobjectmodel;

import Infosys.Abstractcompount.AbstractCompount;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkoutpage extends AbstractCompount {
    WebDriver driver;
    public checkoutpage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }
    @FindBy(css="input[placeholder='Select Country']")
    WebElement country;
    @FindBy(xpath = "//button[contains(@class,'ta-item')][2]")
    WebElement selectingcountry;
    @FindBy(css="div[class='actions'] a")
    WebElement placeorderlocation;

    //By results = By.cssSelector(".ta-results");
    By results = By.cssSelector(".ta-results");



    public  void countryselection(String countryname) {

        Actions dropd = new Actions(driver);
        dropd.sendKeys(country,countryname).build().perform();

        //dropd.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")), "India").build().perform();
        waituntilelementapper(By.cssSelector(".ta-results"));
        selectingcountry.click();


    }
    public finalconformationpage placeorder(){
        driver.findElement(By.cssSelector("div[class='actions'] a"));


        WebElement placeOrder = driver.findElement(By.cssSelector(".action__submit"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click();", placeOrder);
        return new finalconformationpage(driver);




    }


}

