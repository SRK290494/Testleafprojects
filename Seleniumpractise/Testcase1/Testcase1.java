package Seleniumpractise.Testcase1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Testcase1 {
	public static ChromeDriver driver;

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElementByXPath("//div[contains(@class,'loginModal')]").click();
		driver.findElementByXPath("//div[@class='chHeaderContainer']//li[@class='menu_Hotels']/a").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//input[@class='hsw_inputField font30 lineHeight36 latoBlack']").sendKeys("GOA",
				Keys.ENTER);
		driver.findElementById("checkin").click();
		driver.findElementByXPath("//div[text()='15']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//div[text()='19']").click();
		driver.findElementById("guest").click();
		driver.findElementByXPath("//li[@data-cy='adults-2']").click();
		driver.findElementByXPath("//li[@data-cy='children-1']").click();
		driver.findElementByXPath("//button[@class='primaryBtn btnApply']").click();
		driver.findElementByXPath("//button[@class='primaryBtn font24 latoBold widgetSearchBtn']").click();
		Thread.sleep(2000);
		driver.close();
		driver = new ChromeDriver();
		Thread.sleep(2000);
		driver.get(
				"https://www.makemytrip.com/hotels/hotel-listing/?checkin=07152020&city=CTGOI&checkout=07192020&roomStayQualifier=2e1e12e&locusId=CTGOI&country=IN&locusType=city&searchText=Goa,%20India&visitorId=c75c5263-ae56-446a-9d9e-9e484b2fe495");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElementByXPath("//div[@class='mmBackdrop wholeBlack']").click();
		driver.findElementByXPath("//label[text()='Baga']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//label[text()='3 & above (Good)']").click();

		driver.findElementByXPath("//span[@class='customSelectTitle blueText latoBold']").click();
		driver.findElementByXPath("//ul[@class='customSelectOptions latoBold']/li[text()='Price - Low to High']")
				.click();
		driver.manage().deleteAllCookies();
		Thread.sleep(3000);
		// driver.findElementByXPath("//img[@src='//r1imghtlak.mmtcdn.com/285725fe2d1c11e4a9335ee5da2daa2a.jfif?&output-quality=75&downsize=583:388&crop=583:388;20,0&output-format=jpg']").click();
		driver.findElementByXPath("//span[@id='htl_id_seo_201902170501047015']").click();
		String currenturl = driver.getCurrentUrl();
		driver.get(currenturl);
		Thread.sleep(4000);
		Set<String> allWindows = driver.getWindowHandles();
		List<String> allhandles = new ArrayList<String>(allWindows);
		driver.switchTo().window(allhandles.get(1));
		String Hotelname = driver.findElementById("detpg_hotel_name").getText();
		System.out.println(Hotelname);
		driver.findElementByXPath("//button[text()='VIEW THIS COMBO']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//span[@class='primaryBtn overlapBtn']").click();
		Thread.sleep(4000);
		// driver.findElementByXPath("//span[@class='close']").click();
		// driver.switchTo().alert().dismiss();
		String Totalpayableamount = driver.findElementByXPath("//span[@id='revpg_total_payable_amt']").getText();
		System.out.println(Totalpayableamount);
		driver.close();
		driver.switchTo().window(allhandles.get(0));
		driver.close();

	}

}
