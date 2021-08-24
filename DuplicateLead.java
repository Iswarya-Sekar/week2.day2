package week2.day2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

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
		driver.findElement(By.linkText("Email")).click();
		
		
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("iswarya");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(5000);
		String fName1 = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a")).getText();
		String lName1 = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-lastName']/a")).getText(); 
		String nm1 = fName1 +" "+ lName1;
		System.out.println(nm1);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.linkText("Duplicate Lead")).click();
		String title = driver.getTitle();
		if (title.equalsIgnoreCase("Duplicate Lead | opentaps CRM")) {
			System.out.println("We have landed in correct page: \t" +title);
		}
		
		else
			System.out.println("Incorrect page is loaded");
		
		
		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
		
		String fName2 = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		String lName2 = driver.findElement(By.id("viewLead_lastName_sp")).getText(); 
		String nm2 = fName2 +" "+ lName2;
		
		
		if(nm1.equals(nm2)) {
			System.out.println("\tThe duplicated lead name is same as captured name.");
		}
		
		else
			System.out.println("\tThe duplicated lead name is not same as captured name.");

		
		
		driver.quit();
	}

}
