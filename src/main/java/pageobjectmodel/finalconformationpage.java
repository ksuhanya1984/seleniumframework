package pageobjectmodel;

import Infosys.Abstractcompount.AbstractCompount;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class finalconformationpage extends AbstractCompount {
    WebDriver driver;
    public finalconformationpage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);


    }
    @FindBy(css=".hero-primary")
    WebElement orderconformationtext;

    public String orderconform(){
        return orderconformationtext.getText();
        //Assert.assertTrue(text.equalsIgnoreCase("THANKYOU FOR THE ORDER."));


    }
}
