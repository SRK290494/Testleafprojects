package Seleniumpractise.Testcase1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Testcase4_Zalando {
	public static ChromeDriver driver;

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.zalando.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
	
		
		//Get the Alert text and print it
		Alert a= driver.switchTo().alert();
		String alerttext=a.getText();
		System.out.println(alerttext);
		
		//Close the Alert box and click on Zalando.uk
		a.accept();
		driver.findElementByXPath("//a[@class='nav_link nav_link-gb']").click();
		
		//Click Women--> Clothing and click Coats
		WebDriverWait wait= new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@class='uc-btn uc-btn-primary']")));
		driver.findElementByXPath("//button[@class='uc-btn uc-btn-primary']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//span[@class='z-text z-navicat-header_genderText z-text-cta z-text-black']").click();
		driver.findElementByXPath("//span[text()='Clothing']").click();
		driver.findElementByXPath("//ul[@class='cat_child-2XOhh']//a[text()='Coats']").click();
		Thread.sleep(2000);
		
		//Choose Material as cotton (100%) and Length as thigh-length
		driver.findElementByXPath("//button[@aria-label='filter by Material']").click();
		driver.findElementByXPath("//span[text()='cotton (100%)']").click();
		driver.findElementByXPath("//button[text()='Save']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//button[@aria-label='filter by Length']").click();
		driver.findElementByXPath("//span[text()='thigh-length']").click();
		driver.findElementByXPath("//button[text()='Save']").click();
		Thread.sleep(2000);
		
		//Click Color as Black and Size as 'M' Under Manufacture Sizes
		driver.findElementByXPath("//button[@aria-label='filter by Colour']").click();
		driver.findElementByXPath("//span[text()='Black']").click();
		driver.findElementByXPath("//button[text()='Save']").click();
		Thread.sleep(2000);
		
		//Click on JUNAROSE - by VERO MODA
		driver.findElementByXPath("//div[text()='JUNAROSE - by VERO MODA']").click();
		
		
		
		//Add to bag only if Standard Delivery is free
		String Standarddevliary=driver.findElementByXPath("(//span[text()='Free'])[1]").getText();
		if (Standarddevliary.equalsIgnoreCase("Free"))
		{
			driver.findElementByXPath("//button[@aria-label='Add to bag']").click();
		}
		
		//Mouse over on Your Bag and Click on "Go to Bag"
		WebElement bags=driver.findElementByXPath("//span[text()='Your bag']");
		Actions bag=new Actions(driver);
		bag.moveToElement(bags).build().perform();
		driver.findElementByXPath("//div[text()='Go to bag']").click();
		
		//Read the Estimated Deliver Date and print
		String Estimateddevliary=driver.findElementByXPath("//div[@data-id='delivery-estimation']/span[@class='z-2-text z-2-text-body z-2-text-black']").getText();
		System.out.println(Estimateddevliary);
		
		
		//Click on 'Go To Checkout'
		driver.findElementByXPath("//div[text()='Go to checkout']").click();
		Thread.sleep(2000);
		
		//Enter your email
		driver.findElementByXPath("//input[@id='login.email']").sendKeys("sivaramakrishnanappu1994@gmail.com");
		
		//Click on Login button
		driver.findElementByXPath("//button[@data-testid='login_button']").click();
		
		// Print the error message
		String Errormsg=driver.findElementByXPath("//span[@class='C5k6gw gQjacQ gM8atJ VcCaWc O82Ha7 UnzkRv P6b3OO febL1w X3ffeU T23wcN NXRGxc h63b42 SFWSLQ YJjAXl TOkEjs ML2DGG']").getText();
		System.out.println(Errormsg);
		
		driver.close();
		
	}

}
