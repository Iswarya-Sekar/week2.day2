package week2.day2.assignments;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnDropDown {

	public static void main(String[] args) {
		
		//Driver launch and manage
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//1. Select using Index
		WebElement e1 = driver.findElement(By.id("dropdown1"));
		Select dpDn1 = new Select(e1);
		//Choose Selenium
		dpDn1.selectByIndex(1);
		
		
		//2. Select using text
		WebElement e2 = driver.findElement(By.name("dropdown2"));
		Select dpDn2 = new Select(e2);
		//Choose Appium
		dpDn2.selectByVisibleText("Appium");
		
		
		//3. Select using value
		WebElement e3 = driver.findElement(By.id("dropdown3"));
		Select dpDn3 = new Select(e3);
		//Choose UFT/QTP
		dpDn3.selectByValue("3");
		
		
		//4. Find number of options in the drop down
		WebElement e4 = driver.findElement(By.xpath("(//select)[4]"));
		Select dpDn4 = new Select(e4);
		//Find number of options
		e4.click();
		int count = dpDn4.getOptions().size();
		System.out.println("Number of options present in 4th dropdown: " +count);
		
		//4. Use sendKeys to select an option
		WebElement e5 = driver.findElement(By.xpath("(//div[@class='example'])[5]/select"));
		e5.click();
		
		//Using sendKeys
		e5.sendKeys("Loadrunner");
		e5.sendKeys(Keys.ENTER);
		
		
		//5. Last multiple select
		WebElement e6 = driver.findElement(By.xpath("//option[contains(text(), 'programs')]/ancestor::select"));
		Select dpDn5 = new Select(e6);
		dpDn5.selectByIndex(1);
		dpDn5.selectByIndex(4);
		

	}

}
