package Seleniumpractise.Testcase1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Testcase2_AJIO {
	public static ChromeDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.get("https://www.ajio.com/shop/sale");
		driver.manage().window().maximize();
		Thread.sleep(2000);

		driver.findElementByXPath("//input[@class='react-autosuggest__input react-autosuggest__input--open']")
				.sendKeys("Bags", Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
		driver.findElementByXPath("//div[@class='five-grid']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//div[@class='filter-dropdown']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//div[@class='filter-dropdown']//select/option[4]").click();
		Thread.sleep(4000);
		driver.findElementByXPath("//span[text()='price']").click();
		driver.findElementByXPath("//input[@id='minPrice']").sendKeys("2500");
		driver.findElementByXPath("//input[@id='maxPrice']").sendKeys("5000");
		driver.findElementByXPath("//button[@class='rilrtl-button ic-toparw']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//img[@alt='TOMMY HILFIGER Blue Slings & Satchels Sling Bag with Chain Strap']")
				.click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> allhandles = new ArrayList<String>(windowHandles);
		driver.switchTo().window(allhandles.get(1));
		String discount = driver.findElementByXPath("//div[@class='promo-desc']").getText();
		System.out.println(discount);
		String coupncode1=null;
		if (discount.contains("2890") == true) {
			String couponcode = driver.findElementByXPath("//div[@class='promo-title']").getText();
			coupncode1 = couponcode.substring(9, 13);
			System.out.println(coupncode1);
		}
		driver.findElementByXPath(
				"//span[@class='edd-pincode-msg-details edd-pincode-msg-details-pointer edd-pincode-msg-details-text-color']")
				.click();
		Thread.sleep(2000);
		driver.findElementByXPath("//input[@class='edd-pincode-modal-text']").sendKeys("560043");
		driver.findElementByXPath("//button[@class='edd-pincode-modal-submit-btn']").click();
		Thread.sleep(2000);
		String develivarydate = driver.findElementByXPath("//span[@class='edd-message-success-details-highlighted']")
				.getText();
		System.out.println("Expected delivary date:"+develivarydate);
		driver.findElementByXPath("//div[@class='other-info-toggle']").click();
		String customercaredetails=driver.findElementByXPath("(//span[@class='other-info'])[7]").getText();
		System.out.println(customercaredetails);
		driver.findElementByXPath("//div[@class='btn-gold']").click();
		Thread.sleep(10000);
		driver.findElementByXPath("//span[text()='GO TO BAG']").click();
		String Totalprice1=driver.findElementByXPath("//span[@class='price-value bold-font']").getText().replaceAll("[^0-9]", "");
		int Totalprice=Integer.parseInt(Totalprice1);
		System.out.println("Total Price:"+Totalprice);
		driver.findElementByXPath("//input[@class='coupon-code-input-vhr-not-apld  ']").sendKeys(coupncode1);
		driver.findElementByXPath("//button[@class='rilrtl-button button apply-button ']").click();
		Thread.sleep(10000);
		String discountprice1=driver.findElementByXPath("//span[@class='price-value bold-font']").getText().replaceAll("[^0-9]", "");
		int discountprice=Integer.parseInt(discountprice1);
		System.out.println("Discounted price:"+discountprice);
		if (discountprice<Totalprice) 
		{
			System.out.println("Coupon code applied and Price="+discountprice);
		}
		
	    driver.findElementByXPath("//div[@class='delete-btn']").click();
	    Thread.sleep(2000);
	    driver.findElementByXPath("//div[text()='DELETE']").click();
	    driver.close();
	    driver.switchTo().window(allhandles.get(0));
	    driver.close();
	}

}
