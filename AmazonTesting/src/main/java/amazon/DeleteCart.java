package amazon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteCart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromiumdriver().setup();
		WebDriver driver = new ChromeDriver();
		String URL = "https://www.amazon.com/";
		
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		// Search "Keyboard"
		WebElement search = driver.findElement(By.name("field-keywords"));
		search.sendKeys("Keyboard" + Keys.ENTER);
		Thread.sleep(2000);
		// Select Product to Add Cart
		WebElement selectproduct = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div/div/div[1]/h2/a"));
		selectproduct.click();
		Thread.sleep(2000);
		// Add to Cart
		WebElement addcart = driver.findElement(By.name("submit.add-to-cart"));
		addcart.click();
		Thread.sleep(2000);
		// Go to Cart
		WebElement gotocart = driver.findElement(By.id("sw-gtc"));
		gotocart.click();
		Thread.sleep(2000);
		// Delete Product on Cart
		WebElement selectquantity = driver.findElement(By.id("quantity"));
		Select quantity = new Select(selectquantity);
		quantity.selectByIndex(0);
		if(driver.getPageSource().contains("was removed from Shopping Cart")) {
			System.out.println("===========================");
			System.out.println("=== Delete Success ====");
			System.out.println("==========================="); 
		} else {
			System.out.println("===========================");
			System.out.println("=== Delete Gagal ====");
			System.out.println("==========================="); 
		}
		
		Thread.sleep(2000);
		driver.close();
		
	}

}
