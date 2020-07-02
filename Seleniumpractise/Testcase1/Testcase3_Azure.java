package Seleniumpractise.Testcase1;

import java.awt.Desktop.Action;
import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Testcase3_Azure {
	public static ChromeDriver driver;

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://azure.microsoft.com/en-in/");
		driver.manage().window().maximize();
		Thread.sleep(2000);

		// click pricing
		driver.findElementByXPath("//a[@id='navigation-pricing']").click();

		// click pricing calculator
		driver.findElementByXPath("//a[@href='/en-in/pricing/calculator/']").click();
		Thread.sleep(3000);

		// click container
		driver.findElementByXPath("//button[@data-event-property='containers']").click();
		Thread.sleep(2000);

		// click container instance
		// driver.findElementByXPath("//button[@data-event-property='container-instances']").click();
		WebElement containerinstance = driver
				.findElementByXPath("//button[@data-event-property='container-instances']");
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", containerinstance);

		// click container instance Added view
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='new-module-loc']")));
		driver.findElementByXPath("//button[@id='new-module-loc']").click();

		// Select Region as "South India"
		Select Region = new Select(driver.findElementByName("region"));
		Region.selectByVisibleText("South India");

		// Set the Duration as 180000 seconds
		WebElement duration = driver.findElementByXPath("//input[@name='seconds']");
		duration.clear();
		duration.sendKeys(Keys.BACK_SPACE);
		duration.sendKeys("180000");

		// Select the Memory as 4GB
		Select Memory = new Select(driver.findElementByName("memory"));
		Memory.selectByVisibleText("4 GB");

		// Enable SHOW DEV/TEST PRICING
		driver.findElementByXPath("//button[@name='devTestSelected']").click();

		// Select Indian Rupee as currency
		WebElement currency = driver.findElementByXPath("//select[@class='select currency-dropdown']");
		new Select(currency).selectByValue("INR");

		// Print the Estimated monthly price
		String EstimatedMontlycost = driver.findElementByXPath("//span[@class='numeric']/span").getText();
		System.out.println("Estimated Montly cost:" + EstimatedMontlycost);

		// Click on Export to download the estimate as excel
		driver.findElementByXPath("//button[@class='calculator-button button-transparent export-button']").click();
		Thread.sleep(2000);

		// Verify the downloded file in the local folder
		checkfiles("ExportedEstimate.xlsx");

		// Navigate to Example Scenarios and Select CI/CD for Containers
		driver.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
		driver.findElementByXPath("//a[text()='Example Scenarios']").click();

		// CI/CD for containers click
		driver.findElementByXPath("//button[@title='CI/CD for Containers']").click();
		Thread.sleep(3000);

		// Click Add to Estimate
		WebElement addtoestimates = driver.findElementByXPath("//button[text()='Add to estimate']");
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click();", addtoestimates);
		Thread.sleep(5000);

		// Change the Currency as Indian Rupee
		WebElement currency1 = driver.findElementByXPath("//select[@class='select currency-dropdown']");
		new Select(currency1).selectByValue("INR");
		Thread.sleep(3000);

		// Enable SHOW DEV/TEST PRICING
		driver.findElementByXPath("//button[@name='devTestSelected']").click();
		Thread.sleep(2000);

		// Export the Estimate
		driver.findElementByXPath("//button[@class='calculator-button button-transparent export-button']").click();
		Thread.sleep(2000);

		// Verify the downloded file in the local folder
		checkfiles("ExportedEstimate.xlsx");
		
		//close the Browser
		driver.close();

	}

	public static void checkfiles(String filename) {
		File f = new File("C:\\Users\\user\\Downloads\\" + filename);

		if (f.exists() == true) {
			System.out.println("File downloaded sucessfully");
		} else {
			System.out.println("File not downloaded");
		}
	}

}
