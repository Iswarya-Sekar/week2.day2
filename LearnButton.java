package week2.day2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnButton {

	public static void main(String[] args) {
		
		// Driver setup and launch
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Button.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		//1. First button
		driver.findElement(By.id("home")).click();
		String title = driver.getTitle();
		if (title.equalsIgnoreCase("TestLeaf - Selenium Playground")) {
			System.out.println("Page has been navigated to Home page: "+title);
		}
		else
			System.out.println("Page has not been navigated successfully");
		
		//Go back to button page
		driver.findElement(By.linkText("Button")).click();
		
		
		//2. Get position of the button
		WebElement btn1 = driver.findElement(By.id("position"));
		Point btnpos = btn1.getLocation();
		System.out.println("Position of the second button: " +btnpos);
		
		//3. Get color of the button
		WebElement btn2 = driver.findElement(By.id("color"));
		String btnclr = btn2.getAttribute("style");
		String[] arrStr = btnclr.split(":");
		String bclr = arrStr[1].replaceAll(";","");
		System.out.println("Color of the third button: " +bclr);

		//4. Get the height and width
		WebElement btn3 = driver.findElement(By.id("size"));
		Dimension btnhw = btn3.getSize();
		System.out.println("Height and width of the button is: " +btnhw);
		
		//Close all windows
		driver.quit();
		
	}

}
