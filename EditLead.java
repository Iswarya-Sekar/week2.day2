package week2.day2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {


		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		

		//Login and Navigation
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		
		
		//Choose first record in the list
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		
		
		//Get title of the page
		String title = driver.getTitle();
		System.out.println("Title of the page\t:\t" +title);
		
		driver.findElement(By.linkText("Edit")).click();
		
		WebElement cmpy = driver.findElement(By.id("updateLeadForm_companyName"));
		
		String val1 = cmpy.getAttribute("value");
		System.out.println("Previous value in Company name\t:\t" +val1);
		String nm1 = "New name1";
		cmpy.clear();
		cmpy.sendKeys(nm1);
		
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		
		String val2 = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		String nVal[] = val2.split("\\(");
		String nm2 = nVal[0].trim();
		
		//String nm2 = val2.replaceAll("[^a-zA-Z\\s]", "");
		System.out.println("Entered Name\t:\t" +nm2);
		System.out.println();
		
		if(nm1.equals(nm2)) {
			System.out.println("Company name has been changed successfully");
		}
		
		else
			System.out.println("Company name is not changed successfully");

		
		Thread.sleep(5000);
		
		driver.quit();
	}

}
