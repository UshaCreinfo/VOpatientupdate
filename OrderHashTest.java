package sanitytestcase;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrderHashTest {

static WebDriver driver;
	
	
	@BeforeMethod
	public void setUp() throws IOException {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Documents\\Selenium\\chromedriver.exe");
	driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.get("https://54.202.67.191:52/#/login");
	driver.findElement(By.id("details-button")).click();
    driver.findElement(By.id("proceed-link")).click();
    driver.findElement(By.xpath("//input[@name='userMail']")).sendKeys("admin@voptics.com");
    driver.findElement(By.xpath("//input[@name='userPassword']")).sendKeys("VoSolarlink@2020");
    //takescreenshot("Login page");
    driver.findElement(By.xpath("//button[@class='btn btn-primary custom_new_custom']")).click();
    }
	
	@Test
	public void orderhashTest() throws InterruptedException {
	driver.findElement(By.xpath("//div[@class='menu_icon eye']")).click();
	driver.findElement(By.xpath("//a[@href='#/orderlist/orderDetails/298140/']")).click();		
    Thread.sleep(5000);
    JavascriptExecutor js = (JavascriptExecutor)driver;
    js.executeScript("window,scrollBy(0,500)");
    driver.findElement(By.xpath("//a[@class='collapsed'and@ng-click='getShippingDetails()']")).click();	 
    Thread.sleep(5000);
    JavascriptExecutor js1 = (JavascriptExecutor)driver;
    js1.executeScript("window,scrollBy(0,500)");
    Thread.sleep(5000);
    driver.findElement(By.xpath("//a[@class='collapsed'and@ng-click='getOrderBillingdetails();getAccessories()']")).click();;
    Thread.sleep(5000);
    }
	
	@Test
	public void RxTest() {
	driver.findElement(By.xpath("//div[@class='menu_icon eye']")).click();
	boolean b = driver.findElement(By.xpath("//span[text()='Rx']")).isDisplayed();
	} 
	
    @Test
	public void WOTest() throws InterruptedException {
	driver.findElement(By.xpath("//div[@class='menu_icon eye']")).click();
	driver.findElement(By.xpath("//a[@href='#/orderlist/orderDetails/298138/']")).click();
	driver.findElement(By.xpath("//span[@data-original-title='Work Order']")).click();
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window,scrollBy(0,500)");		
	driver.findElement(By.xpath("//button[@class='btn btn-primary primaryBtn printBtn']")).click();
	}
    
    @Test
    public void orderconfirmTest() throws InterruptedException, IOException {
    driver.findElement(By.xpath("//div[@class='menu_icon eye']")).click();	
    driver.findElement(By.xpath("//a[@href='#/orderlist/orderDetails/298178/']")).click();	
    driver.findElement(By.xpath("//i[@class='fa fa-check-square-o']")).click();
    JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window,scrollBy(0,500)");	
	Thread.sleep(5000);
	driver.findElement(By.xpath("//button[@ng-click='printInvoice()']")).click();
	} 
    
    @Test
    public void ShippingQueue() throws InterruptedException  {
    Thread.sleep(3000);
    JavascriptExecutor js = (JavascriptExecutor)driver;
    js.executeScript("window,scrollBy(0,500)");	
    Actions action = new Actions(driver);
   // action.moveToElement(driver.findElement(By.xpath("//img[@ng-src='assets/img/shippingQUE.png']"))).build().perform(); ---- not working
    //driver.findElement(By.xpath("//a[@class='active'and@ui-sref='shippingQueue']")).click();
    } 
    
    
   /* public static void takescreenshot(String fileName) throws IOException {
    File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(file, new File("C:\\Users\\User\\eclipse-workspace\\Selenium\\ScreenShots/"+fileName+".jpg"));
    } */
    
    
    @AfterMethod
	public void logout() {
   // driver.quit();
	}
    }
