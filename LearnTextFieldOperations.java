package week2.day2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnTextFieldOperations {

	public static void main(String[] args) {
		
		//Driver setup and launch 
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Edit.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		//1. To enter the email address
		driver.findElement(By.id("email")).sendKeys("iswarya.sekar@gmail.com");
		
		
		//2. To append a text and press keyboard tab
		WebElement text1 = driver.findElement(By.xpath("//input[@value='Append ']"));
		text1.click();
		text1.sendKeys("new word");
		
		
		//3. To get default text entered
		WebElement label1 = driver.findElement(By.xpath("//label[@for='uname']"));
		String str1 = label1.getText();
		System.out.print(str1);
		System.out.print(": ");
		
		WebElement text2 = driver.findElement(By.xpath("//input[@name='username']"));
		String str2 = text2.getAttribute("value");
		System.out.println(str2);
		
		
		//4. To clear the text
		driver.findElement(By.xpath("//input[@value='Clear me!!']")).clear();
		
		
		//5. To confirm that the edit field is disabled
		WebElement text3 = driver.findElement(By.xpath("//label[@for='disabled']/following-sibling::input"));
		boolean res = text3.isEnabled();
		if(res) {
			System.out.println("The textbox is enabled.");
		}
		else
			System.out.println("The textbox is not enabled.");
		
		
		driver.quit();

	}

}
