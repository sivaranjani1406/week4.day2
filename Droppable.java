package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Droppable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			
        WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://jqueryui.com/droppable");
		
		driver.manage().window().maximize();
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		
		driver.switchTo().frame(frame);
		
		WebElement drag = driver.findElement(By.xpath("//p[text()='Drag me to my target']"));
		
       WebElement drop = driver.findElement(By.xpath("//p[text()='Drop here']"));
		
		Actions builder = new Actions(driver);
		
		builder.dragAndDrop(drag, drop).perform();
		
			
	}

}
