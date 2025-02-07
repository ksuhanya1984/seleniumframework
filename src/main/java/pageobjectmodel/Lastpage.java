package pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Lastpage {
    WebDriver driver;
    public Lastpage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }
    @FindBy(css="h1[class='hero-primary']")
    WebElement textforsubmitorder;
    public String sumbittext(){
        return textforsubmitorder.getText();

    }
}
