package week2.day2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

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
		driver.findElement(By.linkText("Phone")).click();
		
		
		WebElement cc = driver.findElement(By.xpath("//input[@name='phoneCountryCode']"));
		cc.clear();
		cc.sendKeys("100");
		driver.findElement(By.xpath("//input[@name='phoneAreaCode']")).sendKeys("100");
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("100100");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(5000);
		WebElement leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		String ID = leadID.getText();
		
		System.out.println("First ID in the list is:\t"+ID);
		leadID.click();
		
		driver.findElement(By.linkText("Delete")).click();
		
		driver.findElement(By.linkText("Find Leads")).click();
		
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(ID);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(5000);
		boolean errMsg = driver.findElement(By.xpath("//div[text()='No records to display']")).isDisplayed();
		
		if(errMsg) {
			System.out.println("Lead has been deleted successfully");
		}
		
		else
			System.out.println("Error with the code. Please recheck");

		driver.quit();
	}

}
