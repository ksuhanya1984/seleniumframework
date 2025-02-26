package Infosys2.Stepdefintion;

import Infosys.Testcomponants.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageobjectmodel.Cartpage;
import pageobjectmodel.checkoutpage;
import pageobjectmodel.finalconformationpage;
import pageobjectmodel.prodectcatlog;

import java.io.IOException;
import java.util.List;

public class Stropdefinitionimple extends BaseTest {


    //Given :I landed on Ecommerce webpage
    public pageobjectmodel.Landingpage Landingpage;
    public prodectcatlog prodectcatlog;
    public finalconformationpage finalconformationpage;
    @Given("I landed on Ecommerce Page")
    public void i_landed_on_Ecommerce_Page() throws IOException {

        Landingpage=lanchingapp();

    }
    //Given :Login with username <name>and password<password>
    @Given("^Login with username(.+)and password(.+)")
    public void Login_with_username_and_password(String email,String pasword1){

         prodectcatlog = Landingpage.loginApplication(email,pasword1);

    }
    //When :I add product <productname>to cart
    @When("^I add product(.+) to cart$")
    public void I_add_product_to_cart(String prodectname) throws InterruptedException {
        List<WebElement> prodect = prodectcatlog.getprodrctlist();
        //prodectcatlog.addproducttocart(prodectname);
        prodectcatlog.addproducttoc(prodectname);

    }
    //And :checkout <productname>the sumbit order
    @And("^checkout(.+)the sumbit order$")
    public  void checkout_the_sumbit_order(String prodectname) throws InterruptedException {
        Cartpage Cartpage = prodectcatlog.checkingcartsection();
        boolean ni = Cartpage.checkingproductavilability(prodectname);
        Assert.assertTrue(ni);
        checkoutpage checkoutpage = Cartpage.goToCheckout();
        checkoutpage.countryselection("India");
         finalconformationpage = checkoutpage.placeorder();


    }
    //Then :THANKYOU FOR THE ORDER. message is displayed on the conformation
    @Then("{string}message is displayed on the conformation")
     public void message_is_displayed_on_the_conformation(String string){
        String orderconformationtext = finalconformationpage.orderconform();
        Assert.assertTrue(orderconformationtext.equalsIgnoreCase(string));
        driver.close();


    }
@Then("{string} message is displayed")
        public void message_is_displayed(String string){
    Assert.assertEquals(string,Landingpage.getmetheerrormessage());
    driver.close();

        }


}
