package Seleniumpractise.Testcase1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AutomationPractise {

	public static ChromeDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Create Account under Sign In

		driver.findElementByLinkText("Sign in").click();
		driver.findElementByXPath("//input[@class='is_required validate account_input form-control']")
				.sendKeys("sivaramakrishnaappu1994@gmail.com");
		driver.findElementByXPath("//button[@class='btn btn-default button button-medium exclusive']").click();
		driver.findElementByXPath("//input[@id='id_gender1']").click();
		driver.findElementByXPath("//input[@id='customer_firstname']").sendKeys("sivaramakrishnan");
		driver.findElementByXPath("//input[@id='customer_lastname']").sendKeys("sundaresan");
		driver.findElementByXPath("//input[@id='passwd']").sendKeys("Srk290494$");
		WebElement days = driver.findElement(By.xpath("(//select[@class='form-control'])[1]"));
		new Select(days).selectByValue("29");
		WebElement months = driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
		new Select(months).selectByValue("4");
		WebElement years = driver.findElement(By.xpath("(//select[@class='form-control'])[3]"));
		new Select(years).selectByValue("1994");
		driver.findElementByXPath("//input[@id='company']").sendKeys("Unimoni");
		driver.findElementByXPath("//input[@id='address1']").sendKeys("No 10 Bhavaninagar chromepet");
		driver.findElementByXPath("//input[@id='address2']").sendKeys("No 22 Bhavaninagar chromepet");
		driver.findElement(By.name("city")).sendKeys("chennai");
		WebElement idstate = driver.findElement(By.xpath("(//select[@class='form-control'])[4]"));
		new Select(idstate).selectByVisibleText("Indiana");
		driver.findElement(By.name("postcode")).sendKeys("60044");
		WebElement idcountry = driver.findElement(By.xpath("(//select[@class='form-control'])[5]"));
		new Select(idcountry).selectByVisibleText("United States");
		driver.findElement(By.tagName("textarea")).sendKeys("9840389451");
		driver.findElement(By.name("phone_mobile")).sendKeys("9840389451");
		driver.findElement(By.name("alias")).sendKeys("No 10 bhavaninagar");
		driver.findElementByXPath("//button[@name='submitAccount']").click();

		driver.findElementByXPath("(//input[@class='is_required validate account_input form-control'])[2]")
				.sendKeys("sivaramakrishnanappu1994@gmail.com");
		driver.findElementByXPath("//input[@id='passwd']").sendKeys("Srk290494$");
		driver.findElementByXPath("//button[@id='SubmitLogin']").click();

		// On WOMAN section, select any 1 product by clicking on QUICK VIEW and adding 2
		// Qty for the product to cart
		driver.findElementByXPath("//a[text()='Women']").click();
		WebElement product = driver.findElementByXPath("//a[@title='Faded Short Sleeve T-shirts']");
		Actions action = new Actions(driver);
		action.moveToElement(product).build().perform();
		Thread.sleep(2000);
		driver.findElementByXPath("//span[text()='Quick view']").click();

		driver.findElement(By.name("qty")).clear();
		driver.findElement(By.name("qty")).sendKeys("2");

		WebElement button = driver.findElement(By.xpath("//button[@name='submit']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", button);

		

		// . Complete the checkout process by completing the payment flow and in process
		// verifying the total cost of product wherever visible
		driver.findElementByXPath("//a[@title='Proceed to checkout']").click();
		driver.findElementByXPath("//a[@title='Proceed to checkout']").click();
		driver.findElementByXPath("//a[@title='Proceed to checkout']").click();
		driver.findElementByXPath("//a[@title='Proceed to checkout']").click();
		driver.findElementByXPath("//input[@id='cgv']").click();
		driver.findElementByXPath("//a[@title='Proceed to checkout']").click();
		String totalproductprice = driver.findElementByXPath("//table/tfoot/tr[5]/td[2]/span").getText();
		System.out.println("Total Product price:" + totalproductprice);
		driver.findElementByXPath("//a[@title='Pay by bank wire']").click();
		driver.findElementByXPath("//button[@class='button btn btn-default button-medium']").click();

		// After completing the payment process, under Profile page, verify the amount
		// of order under ORDER HISTORY

		driver.findElement(By.xpath("//a[@title='My orders']")).click();
		String TotalPriceinordersummary = driver
				.findElementByXPath("//table[@id='order-list']/tbody[1]/tr[1]/td[3]/span[1]").getText();
		if (TotalPriceinordersummary.equalsIgnoreCase(totalproductprice)) {
			System.out.println("Order price is same in order summary");
		} else {
			System.out.println("Order price not same in order summary");
		}

	}

}
