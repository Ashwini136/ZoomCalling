package zoom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SheduleMeeting {

	public static void main(String[] args) throws InterruptedException {
				//System.setProperty("webdriver.chrome.driver", "G:\\Automation\\chrome116\\chromedriver-win64\\chromedriver.exe");
				WebDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				
				driver.manage().timeouts().implicitlyWait(Duration.ofMillis(8000));  //8 second implicit wait for all elements 
				
				driver.get("https://zoom.us/");
				
				WebElement SignIn=driver.findElement(By.xpath("//a[@href='https://zoom.us/signin'][1]")); //xpath by index
				SignIn.click();
				
				//Sign in page
				WebElement EmailAddress=driver.findElement(By.xpath("//input[@type='email']"));
				WebElement Password=driver.findElement(By.id("password"));
				
				EmailAddress.sendKeys("ashwinip899013@gmail.com");
				Password.sendKeys("Ashwini@123");
				
				WebElement SignN=driver.findElement(By.xpath("//span[text()=' Sign In ']"));
				SignN.click();
				Thread.sleep(3000);
				
				//after sign in schedule a meeting
				WebElement ScheduleMeeting=driver.findElement(By.xpath("//button[@role='button']"));
				ScheduleMeeting.click();
				
				
				//fill up meeting details 
				WebElement TopicBox=driver.findElement(By.xpath("(//input[@class='zm-input__inner'])[1]"));     //all elements of schedule meeting page // Topic
				TopicBox.sendKeys("Trial Meeting");
				
				WebElement WhenBox=driver.findElement(By.xpath("//input[@aria-label='choose date']"));	 // to select date from calendar we need to click on calendar text box
				WhenBox.click();
				Thread.sleep(1000);
				
				WebElement Date=driver.findElement(By.xpath("//a[@aria-label='September 24 2023 Sunday']")); // Choose-24-09-2023 any upcoming random date i.e. its xpath for meeting schedule
				Date.click();
				
				WebElement TimeDropDown=driver.findElement(By.xpath("(//input[@placeholder='select'])[1]")); //click on Time box
				Thread.sleep(1000);
				TimeDropDown.click();
				
				WebElement Time=driver.findElement(By.xpath("(//dd[@id='select-item-start_time-3'])[1]"));	// select time=1:30
				Time.click();
				
				WebElement AM_PMBox=driver.findElement(By.xpath("(//span[@id='start_time2'])[1]"));
				AM_PMBox.click();
				Thread.sleep(1000);
				
				WebElement AM_PM=driver.findElement(By.xpath("//dd[@aria-label='PM']"));
				AM_PM.click();
				
				WebElement DurationHrBox=driver.findElement(By.xpath("//span[@aria-label='select duration hours,1']"));
				DurationHrBox.click();  
				
				WebElement DurationSelectHr=driver.findElement(By.xpath("(//dd[@id='select-item-start_time-2'])[2]"));
				DurationSelectHr.click();
				
				//Scroll down for next web elements
				WebElement TimeZoneBox=driver.findElement(By.xpath("//input[@aria-owns='timezone-popup-list']"));
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("arguments[0].scrollIntoView(true)",TimeZoneBox);
				js.executeScript("window.scrollBy(0,-100)");   //scroll up due to header is present
				
				TimeZoneBox.click();
				
				WebElement TimeZone=driver.findElement(By.xpath("//dd[@aria-label='(GMT+5:30) Mumbai, Kolkata, New Delhi']"));
				TimeZone.click();
				
				WebElement Attendees=driver.findElement(By.xpath("//input[@placeholder='Enter user names or email addresses']"));
				Attendees.sendKeys("askpatil13@gmail.com");
				Thread.sleep(2000);
				Attendees.sendKeys(Keys.ENTER);  //Enter Key stroke
				
				Thread.sleep(1000);
				
				WebElement SaveButton=driver.findElement(By.xpath("(//button[@class=\"zm-button--primary zm-button--small zm-button\"])[6]"));
				Thread.sleep(1000);
				SaveButton.click();	
				

	}
}
