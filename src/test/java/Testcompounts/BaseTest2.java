package Testcompounts;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobjectmodel.Landingpage2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest2 {
    public WebDriver driver;
    public Landingpage2 Landingpage2;

    public WebDriver intilizedriver() throws IOException {
        //properties class
        // /Users/kumarvaduganathan/Documents/WorkspaceSuhanya/seleniumframework/src/main/java/Infosys/resorces/GlobleData.properties
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//Infosys//resorces//GlobleData.properties");
        prop.load(fis);
        // this condition                      //this first argument           //Second arugument
        String browsername = System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");
        //String browsername = prop.getProperty("browser");
        if (browsername.equalsIgnoreCase("Chrome")) {

            driver = new ChromeDriver();

        } else if (browsername.equalsIgnoreCase("firefox")) {

            driver = new FirefoxDriver();

        }


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
        return driver;


    }

    public List<HashMap<String, String>> jsondatatomap(String FilePath) throws IOException {
        //read json to string
        ///Users/kumarvaduganathan/Documents/WorkspaceSuhanya/seleniumframework/src/test/java/Infosys/Data/puchaseorder.json
        String jsoncontent= FileUtils.readFileToString(new File(FilePath));
        //String to hasmap Jackson Databind
        ObjectMapper mapper=new ObjectMapper();
        List<HashMap<String,String>>data=mapper.readValue(jsoncontent, new TypeReference<List<HashMap<String,String>>>() {
        });
        return data;
    }
    public File takescreenshot(String testcaseName,WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File((System.getProperty("user.dir") + "//reports" + testcaseName + "//.png"));
        FileUtils.copyFile(source, file);
        return file;
    }

    @BeforeMethod(alwaysRun = true)
        public Landingpage2 lanchingapp() throws IOException {
             driver=intilizedriver();
             Landingpage2=new Landingpage2(driver);
            Landingpage2.Gotopage();
            return Landingpage2;


        }
        @AfterMethod(alwaysRun = true)
    public void teardown(){
        driver.close();
        }


    }


