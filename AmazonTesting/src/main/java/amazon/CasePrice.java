package amazon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CasePrice {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String URL = "https://www.amazon.com/";
		
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		// click hamburger icon
		WebElement hamburgericon = driver.findElement(By.cssSelector("#nav-hamburger-menu"));
		hamburgericon.click();
		Thread.sleep(2000);
		// click see all on sub menu "Shop By Departement"
		WebElement seeall = driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[11]/a[1]/i"));
		seeall.click();
		Thread.sleep(2000);
		// click Baby Link
		WebElement baby = driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/ul[1]/li[3]/a"));
		baby.click();
		Thread.sleep(2000);
		// click Gift
		WebElement gift = driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[10]/li[11]/a"));
		gift.click();
		Thread.sleep(2000);
		// Input Maximum Price is $1
		driver.findElement(By.id("high-price")).clear();
		driver.findElement(By.id("high-price")).sendKeys("1");
		WebElement btngo = driver.findElement(By.xpath("//*[@id=\"a-autoid-1\"]/span"));
		btngo.click();
		Thread.sleep(2000);
		if(driver.getPageSource().contains("Try checking your spelling or use more general terms")) {
			System.out.println("===========================");
			System.out.println("=== Verifikasi Sukses ====");
			System.out.println("==========================="); 
		} else {
			System.out.println("===========================");
			System.out.println("=== Verifikasi Gagal ====");
			System.out.println("==========================="); 
		}
		Thread.sleep(2000);
		
		driver.close();
		// driver.quit();
		
	}

}
