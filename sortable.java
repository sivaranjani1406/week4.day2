package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sortable {

	public static void main(String[] args) {
		
WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://jqueryui.com/sortable/");
		
		driver.manage().window().maximize();
		
		Actions builder = new Actions(driver);
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		
		driver.switchTo().frame(frame);
		
		WebElement item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement item2 = driver.findElement(By.xpath("//li[text()='Item 2']"));
		
		Point location = item2.getLocation();
		
		int x = location.getX();
		int y = location.getY();
		
	//	builder.dragAndDropBy(item1, x, y).perform();
		
		builder.clickAndHold(item1).moveByOffset(x, y).release().perform();
		

	}

}
