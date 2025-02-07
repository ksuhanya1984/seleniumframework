package Infosys.Infosys;

import Infosys.Testcomponants.BaseTest;
import Infosys.Testcomponants.Retry;
import pageobjectmodel.Cartpage;
import pageobjectmodel.prodectcatlog;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class Errorvalidation extends BaseTest {
    @Test(groups = {"Errorhandling"},retryAnalyzer= Retry.class)
    public  void loginerrorvalidation () throws IOException {
        Landingpage.loginApplication("suhanya22@mail.com","Tesing15");
        //flyInOut
        //Incorrect email id and password
        //Assert.assertEquals("Incorrect email or password",Landingpage.getmetheerrormessage());
        Assert.assertEquals("Incorrect email  password.",Landingpage.getmetheerrormessage());

    }
    @Test
    public void productcatlogerrorvalidation(){

        String prodectname="IPHONE 13 PRO";
        String prodectname1="Banarsi Saree";
        //Landingpage Landingpage=lanchingapp();
        prodectcatlog prodectcatlog=Landingpage.loginApplication("sugi20@mail.com","Testing15");
        List<WebElement> prodect=prodectcatlog.getprodrctlist();
        prodectcatlog.getingproductbyname(prodectname);
        prodectcatlog.addproducttoc(prodectname);
        Cartpage Cartpage =prodectcatlog.checkingcartsection();
        boolean ni =Cartpage. checkingproductavilability("IPHONE 1 PRO");
        Assert.assertFalse(ni);

    }

}
