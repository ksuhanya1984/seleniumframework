package pageobjectmodel;

import Infosys.Abstractcompount.Abstractcompoun2;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Finalpage extends Abstractcompoun2 {
    WebDriver driver;
    public Finalpage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "input[placeholder='Select Country']")
    WebElement country;
    @FindBy(css=".ta-results")
    WebElement visibiltyofdropdown;
    @FindBy(xpath = "//button[contains(@class,'ta-item')][2]")
    WebElement desirecounty;
    @FindBy(css=".action__submit")
    WebElement sumbit;
    public void countrydropdown(String Countryname){
        Actions dropd = new Actions(driver);
        dropd.sendKeys(country,Countryname).build().perform();
        elementvisibility(visibiltyofdropdown);
        desirecounty.click();
    }
    public Lastpage sumbitorder(){
        WebElement placeOrder =  sumbit;

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click();", placeOrder);
        Lastpage Lastpage =new Lastpage(driver);
        return Lastpage;

    }
}
