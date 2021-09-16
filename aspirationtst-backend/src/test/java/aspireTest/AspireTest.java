package aspireTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AspireTest {
	
	public WebDriver driver; 
	
	
	@BeforeMethod
	public void viewProducts() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\David-Net Engineer\\Downloads\\chromedriver_win32\\chromedriver.exe" );
		
		driver = new ChromeDriver();
		driver.get("https://www.aspiration.com/");
		
		
	}
	
	@Test
	public void spendSave() {
		
		//check if user can view products/prices via spend and save link
		driver.findElement(By.linkText("https://www.aspiration.com/our-products")).click();
		
		//Verify that you see 2 card products - Aspiration and Aspiration Plus
		driver.findElements(By.className("plan-original"));
		driver.findElements(By.className("plan-a-plus"));
		
		//on click modal containing input field for email address appears
		driver.findElement(By.xpath("/button[text()='Get Aspiration']")).click();
		//id of field for modal email field
		driver.findElement(By.id("join-waitlist-input"));  
		
		//click button to pop up modal for monthly and yearly plans
		driver.findElement(By.xpath("/button[text()='Get Aspiration Plus']")).click();
		driver.findElement(By.className("modal-body ng-scope"));
		
		
		
	}
	
	@AfterMethod
	public void cleanUp() {
		driver.quit();
	}
	
	

}
