package Infosys.Testcompunts;

import pageobjectmodel.Landingpage2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest2 {
   public WebDriver driver;
   public Landingpage2 Landingpage2;

    public WebDriver intizalization() throws IOException {
        Properties prop = new Properties();
        //Users/kumarvaduganathan/Documents/WorkspaceSuhanya/seleniumframework/src/main/java/Infosys/resorces2/GlobleData2.properties
        FileInputStream fis1 = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//Infosys//resorces//GlobleData.properties");
        prop.load(fis1);
        String browsername = prop.getProperty("browser");
        if (browsername.equalsIgnoreCase("chrome")) {
             driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
        return driver;

    }
    @BeforeMethod
    public Landingpage2 Lanchingtheapllication() throws IOException {
        driver=intizalization();
        Landingpage2=new Landingpage2(driver);
        Landingpage2.Gotopage();
        return Landingpage2;


    }
    @AfterMethod
    public void teardown(){

        driver.close();
    }
}
