package week2.day2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnHyperLinks1 {

	public static void main(String[] args) {

		// Driver launch and setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// 5. count of links in the page
		int c = 0;
		
		System.out.println("Hyperlinks present in this page are: ");
		System.out.println("");
		
		for (int i = 1; i <=6; i++) {

			WebElement l = driver.findElement(By.xpath("(//a)["+i+"]"));
			String link = l.getAttribute("href");
			boolean res = l.isDisplayed();
			
			
			System.out.println(link);
			
			//System.out.println(res);

			if (res) {
				c++;
			} 
			
			else break;
			
		}
		
		System.out.println("");
		System.out.println("There are '"+c+ "' links in this page.");
		
		driver.quit();
		

	}

}
