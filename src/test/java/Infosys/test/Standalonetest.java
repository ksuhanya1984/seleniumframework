package Infosys.test;

import pageobjectmodel.orderpage;
import Infosys.Testcomponants.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjectmodel.Cartpage;
import pageobjectmodel.checkoutpage;
import pageobjectmodel.finalconformationpage;
import pageobjectmodel.prodectcatlog;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Standalonetest extends BaseTest {
    public String prodectname ="IPHONE 13 PRO";
    //String prodectname1="qwerty";
    ///Users/kumarvaduganathan/Documents/WorkspaceSuhanya/seleniumframework
    //http://localhost:8080/user/admin/


    @Test(dataProvider = "getData",groups = {"purchase"})

    public void StandalonT(HashMap<String,String>input) throws IOException,InterruptedException {
        //String prodectname="IPHONE 13 PRO";
        //Landingpage Landingpage=lanchingapp();
        prodectcatlog prodectcatlog = Landingpage.loginApplication(input.get("email"),input.get("pasword1"));
        List<WebElement> prodect = prodectcatlog.getprodrctlist();
        //prodectcatlog.addproducttocart(prodectname);
        prodectcatlog.addproducttoc(input.get("prodectname"));
        Cartpage Cartpage = prodectcatlog.checkingcartsection();
        boolean ni = Cartpage.checkingproductavilability(input.get("prodectname"));
        Assert.assertTrue(ni);
        checkoutpage checkoutpage = Cartpage.goToCheckout();
        checkoutpage.countryselection("India");
        finalconformationpage finalconformationpage = checkoutpage.placeorder();
        String orderconformationtext = finalconformationpage.orderconform();
        Assert.assertTrue(orderconformationtext.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    }

    @Test(dependsOnMethods = {"StandalonT"})
    public void OrderHistory() {
        prodectcatlog prodectcatlog = Landingpage.loginApplication("suhanya2022@mail.com", "Testing15");
        orderpage orderpage = prodectcatlog.ordersverfing();
        Assert.assertTrue(orderpage.orderverfication(prodectname));
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String,String>>data=jsondatatomap(System.getProperty("user.dir")+"//src//test//java//Infosys//Data//puchaseorder.json");
        return new Object[][]{{data.get(0)},{data.get(1)}};

    }


}



