package zoom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zoom_SignIn {

	public static void main(String[] args) throws InterruptedException {
		
		//System.setProperty("webdriver.chrome.driver", "G:\\Automation\\chrome116\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(8000));  //8 second implicit wait for all elements 
		
		driver.get("https://zoom.us/");
		
		WebElement SignIn=driver.findElement(By.xpath("//a[@href='https://zoom.us/signin'][1]")); //xpath by index
		SignIn.click();
		
		WebElement EmailAddress=driver.findElement(By.xpath("//input[@type='email']"));
		WebElement Password=driver.findElement(By.id("password"));
		
		EmailAddress.sendKeys("ashwinip899013@gmail.com");
		Password.sendKeys("Ashwini@123");
		
		WebElement SignN=driver.findElement(By.xpath("//span[text()=' Sign In ']"));
		SignN.click();
		
	}
}
