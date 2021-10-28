package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws InterruptedException, Exception {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

		driver.get("https://www.amazon.in/");

		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro", Keys.DOWN.ENTER);

		Thread.sleep(2000);

		String price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();

		System.out.println("Price is " + price);

		String rating = driver
				.findElement(By
						.xpath("(//span[@class='a-size-base'])[1]"))
				.getText();

		System.out.println("Rating is " + rating);
		
		Actions builder=new Actions(driver);

		WebElement star = driver.findElement(By.xpath("(//span[@class='a-icon-alt'])[1]"));
		
		//star.click();
		
		builder.moveToElement(star).click().perform();
		
		/*System.out.println("% of 5 star is " + driver.findElement(By.xpath(
				"//table[@id='histogramTable']//tr/td[@class='a-text-right a-nowrap']/span[@class='a-size-base']/a"))
				.getText());*/
		
		System.out.println("Text is "+driver.findElement(By.xpath("//i[@class='a-icon a-icon-star a-star-4']//following-sibling::span")).getText());

		driver.findElement(By.xpath("//span[text()='OnePlus 9 Pro 5G (Morning Mist, 12GB RAM, 256GB Storage)']"))
				.click();

		Set<String> windowHandles = driver.getWindowHandles();

		List<String> lst = new ArrayList<String>(windowHandles);

		driver.switchTo().window(lst.get(1));

		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);

		File dst = new File("./snap/pic3.png");

		FileUtils.copyFile(screenshotAs, dst);

		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();

		String totalamount = driver.findElement(By.xpath("//b[text()='Cart subtotal']/following::span[1]/span"))
				.getText();

		System.out.println("Total amount "+totalamount);
		
		if (totalamount.contains(price)) {
			System.out.println("Both are same");
		} else
			System.out.println("Both are different");

	}

}
