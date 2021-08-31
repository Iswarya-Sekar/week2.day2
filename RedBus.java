package week2.day2.assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * 1.Go to https://www.redbus.in/ in chrome
		 * 2.Type Chennai in From textBox and ENTER
		 * 3.Type Bengaluru in Destination textBox and ENTER 
		 * 4.Choose any date in JULY
		 * 5.Click Search Buses
		 * 6.Close the popup using the X button at the right corner
		 * 7.Print the number of search results
		 * 8.Choose only Sleeper Bus
		 * 9.Print the number of search results
		 * 10.De select the sleeper Bus and select the AC bus alone
		 * 11.Print the number of search results
		 * 12.Choose also Non AC buses
		 * 13.Print the number of search results
		 */
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//From
		WebElement from = driver.findElement(By.id("src"));
		from.click();
		from.sendKeys("chennai");
		Thread.sleep(1000);
		//from.sendKeys(Keys.ARROW_DOWN);
		from.sendKeys(Keys.ENTER);
		
		//To
		WebElement to = driver.findElement(By.id("dest"));
		to.click();
		to.sendKeys("bengaluru");
		Thread.sleep(1000);
		to.sendKeys(Keys.ENTER);
		Thread.sleep(1000);

		//Date
		driver.findElement(By.id("onward_cal")).click();
		Thread.sleep(1000);
		WebElement table1 = driver.findElement(By.xpath("//table[@class='rb-monthTable first last']"));
		WebElement next = table1.findElement(By.xpath("//td[@class='next']"));
		next.click();
		Thread.sleep(5000);
		WebElement table2 = driver.findElement(By.xpath("//table[@class='rb-monthTable first last']"));
		
		List<WebElement> rows = table2.findElements(By.tagName("tr"));
		List<WebElement> firstWeek = rows.get(2).findElements(By.tagName("td"));
		firstWeek.get(4).click();
		
		//Search
		driver.findElement(By.id("search_btn")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//i[@class='icon icon-close c-fs']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//i[@class='icon icon-close']")).click();
		String busCount = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
		System.out.println(busCount +"\t - Total bus count");
		
		WebElement sleeper = driver.findElement(By.xpath("//label[@for='bt_SLEEPER']"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", sleeper);
		
		String sBusCount = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
		System.out.println(sBusCount +"\t - Sleeper bus count");
		
		WebElement ac = driver.findElement(By.xpath("//label[@for='bt_AC']"));
		js.executeScript("arguments[0].click()", sleeper);
		js.executeScript("arguments[0].click()", ac);
		String acBusCount = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
		System.out.println(acBusCount +"\t - AC bus count");
		
		WebElement nac = driver.findElement(By.xpath("//label[@for='bt_NONAC']"));
		js.executeScript("arguments[0].click()", nac);
		String nonAcAcBusCount = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
		System.out.println(nonAcAcBusCount +"\t - Non AC & AC bus count");
		
		driver.quit();
		
	}

}
