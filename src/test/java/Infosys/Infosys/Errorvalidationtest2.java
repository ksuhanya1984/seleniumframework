package Infosys.Infosys;

import Infosys.Testcompunts.BaseTest2;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Errorvalidationtest2 extends BaseTest2 {

    @Test
    public  void loginerrorvalidation2(){
        Landingpage2.logininformation("suhanya20@mail.com","Teting15");
        Assert.assertEquals("Incorrect email or password.",Landingpage2.loginnegativevaluepassing());


    }

}


