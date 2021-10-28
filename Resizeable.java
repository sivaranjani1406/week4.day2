package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resizeable {

	public static void main(String[] args) {	
			
	        WebDriverManager.chromedriver().setup();
			
			ChromeDriver driver=new ChromeDriver();
			
			driver.get("https://jqueryui.com/resizable");
			
			driver.manage().window().maximize();
			
			Actions builder=new Actions(driver);
			
			WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
			
			driver.switchTo().frame(0);
			
			WebElement resize = driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
		
            builder.clickAndHold(resize).moveByOffset(100, 10).release(resize).build().perform();
			
	}

}
