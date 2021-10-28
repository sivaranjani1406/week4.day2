package week4.day2;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

		driver.get("https://www.myntra.com/");

		driver.manage().window().maximize();
		
		WebElement Men = driver.findElement(By.xpath("//div[@class='desktop-navLink']/a[1]"));

		Actions builder=new Actions(driver);
		
        builder.moveToElement(Men).perform();
        
        driver.findElement(By.xpath("//a[text()='Jackets']")).click();
        
       String count= driver.findElement(By.xpath("//h1[text()='Jackets for Men']/following::span[1]")).getText();
       
       System.out.println("Total count"+count);
        
//       int foo1 = Integer.parseInt(count);
//       
//       System.out.println(foo1);
       
      String attribute = driver.findElement(By.xpath("(//span[@class='categories-num'])[1]")).getText();
      
      String attribute1 = driver.findElement(By.xpath("(//span[@class='categories-num'])[2]")).getText();
      
      System.out.println("Jackets "+attribute+"Rain Jacket "+attribute1);
//  
//       int i = Integer.parseInt(attribute);
//        int j=Integer.parseInt(attribute1);
//        
//        System.out.println("Jackets "+i+"Rain Jacket "+j);
//        
//       /* int k=foo+j;
//        
//        if(k==foo1)
//        {
//        	System.out.println("Both are same");
//        }
//        else
//        	System.out.println("Both are different"); */
      
      driver.findElement(By.xpath("(//div[@class='common-checkboxIndicator'])[1]")).click();
      
      driver.findElement(By.xpath("(//div[@class='brand-more'])[1]")).click();
      
      Thread.sleep(2000);
      
      driver.findElement(By.xpath("(//div[@class='FilterDirectory-titleBar'])/input")).sendKeys("Duke");
      
      driver.findElement(By.xpath("//label[text()='Duke']/div")).click();
      
      driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();
      
      List<WebElement> duke = driver.findElements(By.xpath("//h3[text()='Duke']"));
      
      for (WebElement webElement : duke) {
		
   	  if(webElement.getText().contains("Duke"))
   	  {
   		  System.out.println("All coats are of brand Duke");
   		  break;
   	  }
	}
      
      WebElement sort = driver.findElement(By.xpath("//span[text()='Recommended']"));
      
      builder.moveToElement(sort).perform();
      
      driver.findElement(By.xpath("//label[text()='Better Discount']")).click();
      
      WebElement price = driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]"));
      
      System.out.println("price is "+price.getText());
      
      price.click();
      
      File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
      
      File dst= new File("./snap/myntra.png");
      
      FileUtils.copyFile(screenshotAs, dst);
      
      Set<String> windowHandles = driver.getWindowHandles();
      
      List<String> lst = new ArrayList<String>(windowHandles);
      
      driver.switchTo().window(lst.get(0));
      
      driver.findElement(By.xpath("//span[@class='myntraweb-sprite desktop-iconWishlist sprites-headerWishlist']")).click();
      
      driver.quit();
      
	}

}
