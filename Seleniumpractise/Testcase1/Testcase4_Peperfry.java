package Seleniumpractise.Testcase1;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Testcase4_Peperfry {
	public static ChromeDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.get("https://www.pepperfry.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Mouseover on Furniture and click Office Chairs under Chairs
		Actions a = new Actions(driver);
		WebElement furniture = driver.findElementByXPath("//a[text()='Furniture']");
		a.moveToElement(furniture).build().perform();
		driver.findElementByXPath("//div[@class='hvr-col-listitem']/a[text()='Office Chairs']").click();

		// click Executive Chairs
		driver.findElementByXPath("//div[@class='cat-wrap-ttl']/h5[text()='Executive Chairs']").click();

		// Change the minimum Height as 50 in under Dimensions
		driver.findElementByXPath(
				"//div[@class='clip__filter-dimension-input-holder']/input[@class='clipFilterDimensionHeightValue']")
		.clear();
		driver.findElementByXPath(
				"//div[@class='clip__filter-dimension-input-holder']/input[@class='clipFilterDimensionHeightValue']")
		.sendKeys("50");
		Thread.sleep(4000);

		// closepop
		WebElement iframe = driver
				.findElementByXPath("//iframe[@id='webklipper-publisher-widget-container-notification-frame']");
		driver.switchTo().frame(iframe);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@id='webklipper-publisher-widget-container-notification-close-div']/span[@class='wewidgeticon we_close icon-large']")));
		driver.findElementByXPath(
				"//div[@id='webklipper-publisher-widget-container-notification-close-div']/span[@class='wewidgeticon we_close icon-large']")
		.click();
		driver.switchTo().defaultContent();

		// close registration popup
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='popup-box gb-modal reg_modal']/a[@class='popup-close']")));
		driver.findElementByXPath("//div[@class='popup-box gb-modal reg_modal']/a[@class='popup-close']").click();

		// Add "Poise Executive Chair in Black Colour" chair to Wishlist
		driver.findElementByXPath("//a[@data-productname='Poise Executive Chair in Black Colour']").click();
		Thread.sleep(4000);

		// Mouseover on Furniture and Click Office tables
		Actions b = new Actions(driver);
		WebElement furniture1 = driver.findElementByXPath("//a[text()='Furniture']");
		b.moveToElement(furniture1).build().perform();
		driver.findElementByXPath("//div[@class='hvr-col-listitem']/a[text()='Office Tables']").click();
		Thread.sleep(2000);

		// Select Executive Desks
		driver.findElementByXPath("//div[@class='cat-wrap-ttl']/h5[text()='Executive Desks']").click();
		Thread.sleep(2000);

		// Select Price between 20000 to 40000 rs
		driver.findElementByXPath("//label[@for='price20000-40000']").click();
		Thread.sleep(2000);

		// Add "Executive Office Table in Brown Color" to Wishlist
		driver.findElementByXPath("//a[@data-productname='Executive Office Table in Brown Color']").click();
		Thread.sleep(2000);

		// Verify the number of items in Wishlist
		String Wishlistitems = driver.findElementByXPath("(//span[@class='count_alert'])[2]").getText();
		System.out.println("No of items in wishlist:" + Wishlistitems);

		// Navigate to Wishlist
		driver.findElementByXPath(
				"//div[@class='wishlist_bar']/a[@class='pf-icon pf-icon-heart header_tab wistlist_img pending_alert']")
		.click();

		// Get the offer Price and Coupon Code for Executive Office Table in Brown Color
		String offerprice = driver.findElementByXPath("//p[@class='oprice']/span[@class='txt-green']").getText();
		String couponcode = driver.findElementByXPath(
				"//p[@class='pf-border pf-border-lighter-grey-50 pf-border-style-dashed pf-center pf-padding-tiny font-14 pf-italic-txt pf-text-grey pf-margin-top use-coupon']/strong")
				.getText();
		System.out.println("offer price:" + offerprice);
		System.out.println("Coupon code:" + couponcode);

		// Move Executive Office Table in Brown Color only to Cart from Wishlist
		driver.findElementByXPath("//div[@class='item_cta']//div[@class='action_block']/a[@class='addtocart_icon']")
		.click();

		// Check for the availability for Pincode 600128
		driver.findElementByXPath("//input[@class='srvc_pin_text']").sendKeys("600128");
		driver.findElementByXPath("//a[@class='check_available']").click();
		Thread.sleep(2000);

		// Click on PROCEED TO PAY SECURELY from My Cart
		driver.findElementByXPath("//div[@class='minicart_footer']/a[text()='Proceed to pay securely ']").click();
		Thread.sleep(3000);

		// Enter the Coupon code and click Apply
		driver.findElementByXPath("//div[@class='ck-cpn-input-wrap']/input[@class='inputcoupon']").sendKeys(couponcode);
		driver.findElementByXPath(
				"//div[@class='ck-cpn-input-wrap']/input[@class='pf-text pf-border-0 font-13 pf-padding-10 pf-padding-20-h pf-hover-primary-color pf-text-white pf-bold-txt']")
		.click();

		// Click Proceed to Pay
		driver.findElementByXPath("//span[@class='ck-proceed-btn-wrap']/a[text()='PLACE ORDER']").click();
		driver.findElementByXPath("//div[@class='nCheckout__accrodian-header-right']").click();

		// Capture the screenshot of the item under ORDER SUMMARY
		WebElement ordersummay=driver.findElementByXPath("//li[@id='payment_cart_1409077']");
		File source = ordersummay.getScreenshotAs(OutputType.FILE);
		File target = new File("C:\\Users\\user\\Desktop\\ordersummary.png");
		FileUtils.copyFile(source, target);

		// Close the browser
		driver.close();

	}

}
