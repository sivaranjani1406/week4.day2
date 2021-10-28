package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class nykaa {

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

		driver.get("https://www.nykaa.com/");

		driver.manage().window().maximize();

		WebElement brand = driver.findElement(By.xpath("//a[text()='brands']"));

		Actions builder = new Actions(driver);

		builder.moveToElement(brand).perform();

		WebElement brandname = driver.findElement(By.xpath("//input[@id='brandSearchBox']"));
		brandname.sendKeys("L'Oreal Paris");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.visibilityOf(brandname));

		// driver.findElement(By.xpath("//a[text()='L'Oreal Paris']")).click();

		driver.findElement(By.linkText("L'Oreal Paris")).click();
		System.out.println(driver.getTitle());

		driver.findElement(By.xpath("//span[text()='Sort By : popularity']")).click();

		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[text()='Category']")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[text()='Hair']")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();

		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();

		driver.findElement(By.xpath("//span[text()='Concern']")).click();

		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();

		WebElement filter = driver.findElement(By.xpath("//span[text()='Filters Applied']/following::span[1]"));

		String text = filter.getText();

		if (!text.equals("Shampoo")) {
			System.out.println("Filter does not contains the text shampoo");

		}

		else
			System.out.println("Filter contain the text Shampoo");

		List<WebElement> data1 = driver.findElements(By.xpath("//div[@id='product-list-wrap']/following::div"));
		System.out.println(data1.size());

//	for (WebElement webElement : data1) {
//		
//		System.out.println(webElement.getText());
//		
//	}

		driver.findElement(By.xpath("//div[@id='product-list-wrap']//div[1]/following::a/div[2]/div[1]")).click();

		Set<String> windowHandles = driver.getWindowHandles();

		List<String> set = new ArrayList<String>(windowHandles);

		System.out.println("No of windows " + windowHandles.size());

		driver.switchTo().window(set.get(1));

		Thread.sleep(2000);

		WebElement ml = driver
				.findElement(By.xpath("//div[text()='inclusive of all taxes']/following::select[@title='SIZE']"));
		ml.click();

		Select sel = new Select(ml);
		
		sel.selectByValue("0");

		System.out.println("MRP " + driver.findElement(By.xpath("//span[text()='MRP:']/following::span[1]")).getText());

		driver.findElement(By.xpath("//span[text()='ADD TO BAG']")).click();

		driver.findElement(By.xpath("//span[text()='Account']/following::button[1]")).click();

		driver.switchTo().frame(0);

		String Grandtotal = driver.findElement(By.xpath("//span[text()='Grand Total']/following::div[1]")).getText();

		System.out.println("Grand TOtal " + Grandtotal);

		driver.findElement(By.xpath("//span[text()='Proceed']")).click();

		List<String> set1 = new ArrayList<String>(windowHandles);

		System.out.println("No of windows " + windowHandles.size());

		driver.switchTo().window(set1.get(1));

		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();

		String guest_total = driver.findElement(By.xpath("//div[text()='Grand Total']/following::div[1]")).getText();

		System.out.println("Guest-> Total" + guest_total);

		if (Grandtotal == guest_total) {
			System.out.println("Both values are same");
		}

		else

			System.out.println("Both values are different" + "value1" + Grandtotal + "value2" + guest_total);

		driver.quit();

	}

}
