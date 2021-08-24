package week2.day2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnRadioButton {

	public static void main(String[] args) {


		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/radio.html ");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
		
		//2. Find default selection
		WebElement label1 = driver.findElement(By.xpath("//label[@for='Unchecked']"));
		String lName1 = label1.getText();
		WebElement radio1 = driver.findElement(By.xpath(label1+ "/input"));
		boolean res1 = radio1.isSelected();
		
		WebElement label2 = driver.findElement(By.xpath("//label[@for='Checked']"));
		String lName2 = label2.getText();
		WebElement radio2 = driver.findElement(By.xpath("//label[@for='Checked']/input"));
		boolean res2 = radio2.isSelected();
		
		if(res2) {
			System.out.println(lName2 +" is selected");
		}
		else if(res1) {
			System.out.println(lName1 +" is selected");
		}

		
		

		
		//1. Click on a radio button
		driver.findElement(By.id("yes")).click();
		
		//3. 
	}

}
