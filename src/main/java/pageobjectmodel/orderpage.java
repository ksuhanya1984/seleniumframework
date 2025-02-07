package pageobjectmodel;

import Infosys.Abstractcompount.AbstractCompount;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class orderpage extends AbstractCompount {
    WebDriver driver;
    public orderpage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath="//tr/td[2]")
    public  List<WebElement>orderlist;
    public boolean orderverfication(String prodectname ){
        //driver.findelement(By.csssselector("//tr/td[2]"))

        boolean orderver=orderlist.stream().anyMatch(prodect->prodect.getText().equals(prodectname));
        return orderver;
    }

}
