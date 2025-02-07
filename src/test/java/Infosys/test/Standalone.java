package Infosys.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageobjectmodel.Landingpage;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Standalone {
    public static void main(String[] args){
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(05,TimeUnit.SECONDS);
        String prodectname="IPHONE 13 PRO";
        String drop="ind";
        driver.get("https://rahulshettyacademy.com/client");
        Landingpage Landingpage=new Landingpage(driver);
        driver.findElement(By.id("userEmail")).sendKeys("suhanya2022@mail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Testing15");
        driver.findElement(By.id("login")).click();
        WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(05));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".mb-3")));
      List<WebElement>prodect = driver.findElements(By.cssSelector(".mb-3"));
        WebElement prod =prodect.stream().filter(product->product.findElement(By.cssSelector("h5"))
                .getText().equals(prodectname)).findFirst().orElse(null);
        prod.findElement(By.cssSelector("div[class='card-body'] button:last-of-type")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(05));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("toast-container")));
        //ng-animating
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElement(By.cssSelector(".ng-animating"))));

        driver.findElement(By.cssSelector("li button[routerlink='/dashboard/cart']")).click();
        List<WebElement> itcmcheck=driver.findElements(By.cssSelector("div[class='cartSection'] h3"));
        boolean ni=itcmcheck.stream().anyMatch(it->it.getText().equalsIgnoreCase(prodectname));
        Assert.assertTrue(true);
        driver.findElement(By.xpath("//div[@class='subtotal cf ng-star-inserted']//button")).click();
        //driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys(drop);
        Actions dropd = new Actions(driver);
        dropd.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")),"India").build().perform();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".ta-results"))));
        driver.findElement(By.xpath("//button[contains(@class,'ta-item')][2]")).click();
        //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("div[class='actions'] a"))));
        //driver.findElement(By.cssSelector("div[class='actions'] a")).click();
        WebElement placeOrder = driver.findElement(By.cssSelector(".action__submit"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click();", placeOrder);
        String text =driver.findElement(By.cssSelector("h1[class='hero-primary']")).getText();
        Assert.assertTrue(text.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

    }
}
