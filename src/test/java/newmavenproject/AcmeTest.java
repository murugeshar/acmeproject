package newmavenproject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AcmeTest {

	@Test
	public void run(){
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		//TO launch Chrome
		ChromeDriver driver=new ChromeDriver();
		//TO maximize the browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//TO launch url
		driver.get("https://acme-test.uipath.com/account/login");
		driver.findElementById("email").sendKeys("kumar.testleaf@gmail.com",Keys.TAB);
		driver.findElementById("password").sendKeys("leaf@12",Keys.ENTER);
		driver.findElementById("buttonLogin").click();
		//driver.findElementByXPath("//*[text()=' Vendors']").click();
		WebElement btn = driver.findElementByXPath("//*[text()=' Vendors']");
		Actions action = new Actions(driver);
		action.moveToElement(btn ).perform();
		driver.findElementByLinkText("Search for Vendor").click();
		driver.findElementById("vendorName").sendKeys("blue lagoon");
		driver.findElementById("buttonSearch").click();
		String country = driver.findElement(By.xpath("//td[text()='France']")).getText();
		System.out.println(country);
		//driver.findElementById("//*[text()='Log Out']").click();
		driver.findElement(By.linkText("Log Out")).click();
		driver.close();

	}
}
