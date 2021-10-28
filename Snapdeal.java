package week4.day2;

import java.io.File;

import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {

	public static void main(String[] args) throws InterruptedException, Exception {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

		driver.get("https://www.snapdeal.com/");

		driver.manage().window().maximize();

		WebElement menfashion = driver
				.findElement(By.xpath("//li[text()='More Categories']/following::li/a[1]/span[1]"));

		Actions builder = new Actions(driver);

		builder.moveToElement(menfashion).perform();

		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();

		System.out.println("Total count of sports shoes: "
				+ driver.findElement(By.xpath("//div[@class='category-name-wrapper clearfix ']/h1/span")).getText());

		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();

		driver.findElement(By.xpath("//span[text()='Sort by:']")).click();

		driver.findElement(By.xpath("//span[text()='Sort by:']/following::li[2]")).click();

		Thread.sleep(4000);

		List<WebElement> price = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));

		System.out.println("Total no. of shoes:" + price.size());

		/*
		 * for (WebElement webElement : price) {
		 * 
		 * System.out.println("Price list "+webElement.getText()); }
		 */

		// System.out.println("Total count
		// "+driver.findElement(By.xpath("//div[@class='category-name-wrapper clearfix
		// ']/h1/span")).getText());

		driver.findElement(By.xpath("//input[@name='fromVal']")).click();

		driver.findElement(By.xpath("//input[@name='fromVal']")).clear();

		driver.findElement(By.xpath("//input[@name='fromVal']")).click();

		driver.findElement(By.xpath("//input[@name='fromVal']")).sendKeys("900");

		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@name='toVal']")).clear();

		driver.findElement(By.xpath("//input[@name='toVal']")).sendKeys("1200");

		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@name='toVal']/following::div[1]")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@class='price-input']/following::div[3]")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath(
				"//div[@class='filter-section ']/following::span/following::div/input/following::label[@for='Color_s-Navy']"))
				.click();

		WebElement trainingshoes = driver.findElement(By.xpath("//div[@class='product-desc-rating ']/a[1]"));

		builder.moveToElement(trainingshoes).perform();

		driver.findElement(By.xpath("//div[@class='clearfix row-disc']/div[1]")).click();

		String price1 = driver.findElement(By.xpath("//div[@class='product-price pdp-e-i-PAY-l clearfix']/span[1]"))
				.getText();

		String price2 = driver.findElement(By.xpath("//div[@class='product-price pdp-e-i-PAY-l clearfix']/span[2]"))
				.getText();

		System.out.println("Price: " + price1 + "Discount: " + price2);

		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);

		File dst = new File("./snap/pic2.png");

		FileUtils.copyFile(screenshotAs, dst);

		driver.findElement(By.xpath("//div[@class='close close1 marR10']/i")).click();

		driver.close();

	}

}
