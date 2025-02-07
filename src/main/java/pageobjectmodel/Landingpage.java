package pageobjectmodel;


import Infosys.Abstractcompount.AbstractCompount;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Landingpage extends AbstractCompount {
    WebDriver driver;
    public Landingpage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
   // WebElement userid=driver.findElement(By.id("userEmail"));
    //pagerFactorymodel
    //driver.findElement(By.id("userPassword"))
    //driver.findElement(By.id("login"))
    @FindBy(id="userEmail")
    WebElement userid;
    @FindBy(id="userPassword")
    WebElement password;
    @FindBy(id="login")
    WebElement submit;
    @FindBy(css="[class*='flyInOut']")
    WebElement errormessage;

    public  prodectcatlog loginApplication(String email, String pasword1){
        userid.sendKeys(email);
        password.sendKeys(pasword1);
        submit.click();
        prodectcatlog prodectcatlog=new prodectcatlog(driver);
        return prodectcatlog;

    }
    public String getmetheerrormessage(){
        waitelementtoappear(errormessage);
        return errormessage.getText();

    }
    public void goTo(){
        driver.get("https://rahulshettyacademy.com/client");
    }


    }





