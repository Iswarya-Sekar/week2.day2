package week2.day2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnHyperLinks {

	public static void main(String[] args) throws InterruptedException {

		// Driver launch and setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// 1. Click on Home page
		WebElement e1 = driver.findElement(By.partialLinkText("Go to Home Page"));
		String url4 = e1.getAttribute("href");
		e1.click();

		String title = driver.getTitle();
		if (title.equalsIgnoreCase("TestLeaf - Selenium Playground")) {
			System.out.println("Redirected successfully to: " + title);
		} else
			System.out.println("Web page is not redirected successfully.");

		driver.findElement(By.linkText("HyperLink")).click();
		System.out.println("");

		// 2. Find the redirection without clicking the hyperlink
		WebElement e2 = driver.findElement(By.partialLinkText("Find where am"));
		String url1 = e2.getAttribute("href");
		System.out.println("Targeted link to redirect: " + url1);

		System.out.println("");

		// 4. Verifying same link

		WebElement e4 = driver.findElement(By.xpath("(//a[text()='Go to Home Page'])[2]"));
		String url3 = e4.getAttribute("href");

		if (url3.equals(url4)) {
			e4.click();
			String title1 = driver.getTitle();
			if (title.equals(title1))
				System.out.println("Both buttons accesses same page: " + title1);

			else
				System.out.println("Buttons does not interact with same page");

		}

		else
			System.out.println("Buttons does not interact with same page");

		driver.findElement(By.linkText("HyperLink")).click();

		System.out.println("");

		
		// 5. count of links in the page
		int c = 0;

		System.out.println("Hyperlinks present in this page are: ");
		System.out.println("");

		for (int i = 1; i <= 6; i++) {

			WebElement l = driver.findElement(By.xpath("(//a)[" + i + "]"));
			String link = l.getAttribute("href");
			boolean res = l.isDisplayed();

			System.out.println(link);

			// System.out.println(res);

			if (res) {
				c++;
			} 

		}

		System.out.println("");
		System.out.println("There are '" + c + "' links in this page.");

		System.out.println("");
		
		
		// 3. Verify broken link
		WebElement e3 = driver.findElement(By.linkText("Verify am I broken?"));
		String url2 = e3.getAttribute("href");
		System.out.println("The url with error message redirection: " + url2);
		e3.click();
		String title2 = driver.getTitle();

		if (title2.contains("404") || title.contains("Not Found")) {
			System.out.println("The link is broken one");
		} else
			System.out.println("The link is not broken");

		driver.quit();

	}

}
