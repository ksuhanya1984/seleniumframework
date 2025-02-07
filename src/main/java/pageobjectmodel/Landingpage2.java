package pageobjectmodel;

import Infosys.Abstractcompount.Abstractcompoun2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Landingpage2 extends Abstractcompoun2 {
    WebDriver driver;
    public Landingpage2(WebDriver driver){
        super(driver);

        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    ////driver.findElement(By.id("userPassword")).sendKeys("Testing15");
    // driver.findElement(By.id("login")).click();
    //driver.get("https://rahulshettyacademy.com/client");
    @FindBy(id="userEmail")//simplyfing the code with using pagefactory
    WebElement useremailid;
    @FindBy(id="userPassword")
    WebElement password2;
    @FindBy(id="login")
    WebElement submitbutton;
    //flyInOut
    @FindBy(css="[class*='flyInOut']")
    WebElement loginerror;
    public productcatlog2 logininformation(String emailid, String pass ){
        useremailid.sendKeys(emailid);
        password2.sendKeys(pass);
        submitbutton.click();
        productcatlog2 productcatlog2=new productcatlog2(driver);
        return productcatlog2;
    }
    public String loginnegativevaluepassing(){
        elementvisibility(loginerror);
        return loginerror.getText();

    }
    public void Gotopage(){
        driver.get("https://rahulshettyacademy.com/client");

    }

}
