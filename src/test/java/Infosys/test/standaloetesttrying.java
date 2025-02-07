package Infosys.test;

import Infosys.Testcompunts.BaseTest2;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjectmodel.Finalpage;
import pageobjectmodel.Lastpage;
import pageobjectmodel.cartpage2;
import pageobjectmodel.productcatlog2;

import java.io.IOException;
import java.util.List;

public class standaloetesttrying extends BaseTest2 {
    @Test
    public void standaloetesttry() throws IOException {
        String prodectname="Banarsi Saree";
        Landingpage2.logininformation("suhanya2022@mail.com","Testing15");
        productcatlog2 productcatlog2=new productcatlog2(driver);
        List<WebElement> product=productcatlog2.gettingproducrlist();
        productcatlog2.additemintocart(prodectname);
        cartpage2 cartpage2=productcatlog2.cart();
        boolean ni =cartpage2.productchecking(prodectname);
        Assert.assertTrue(ni);
        Finalpage Finalpage=cartpage2.checkout();
        Finalpage.countrydropdown("India");
        Lastpage Lastpage=Finalpage.sumbitorder();
        String conformtext =Lastpage.sumbittext();
        Assert.assertTrue(conformtext.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
        //driver.close();

    }
}




