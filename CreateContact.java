package week2.day2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {


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
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		
		
		//Entering values
		driver.findElement(By.id("firstNameField")).sendKeys("Iswarya");
		driver.findElement(By.id("lastNameField")).sendKeys("SEKAR");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Ishu");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Seky");
		
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("dept");
		driver.findElement(By.id("createContactForm_description")).sendKeys("Desciption - desc");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("iswarya.sekar@gmail.com");
		
		WebElement elmt1 = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select dpDn1 = new Select(elmt1);
		dpDn1.selectByVisibleText("New York");
		
		driver.findElement(By.name("submitButton")).click();
		
		
		//Edit
		driver.findElement(By.linkText("Edit")).click();
		
		driver.findElement(By.id("updateContactForm_description")).clear();
		
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("inputting important info - 123456");
		
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		
		String title = driver.getTitle();
		
		System.out.println("Title of the expected page: ");
		
		System.out.println("\t"+title);
	}

}
