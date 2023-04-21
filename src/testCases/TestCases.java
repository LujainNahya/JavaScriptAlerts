package testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class TestCases {

	WebDriver driver= new ChromeDriver();
	SoftAssert Assert = new SoftAssert ();
	@BeforeTest
	public void before () { 
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");

	}
	
	@Test(priority=1)
	public void assertFirstAlert () throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button")).click();
		Alert alert= driver.switchTo().alert();
		alert.accept();
		String result=driver.findElement(By.cssSelector("#result")).getText();
			String Expected="You successfully clicked an alert";
			Assert.assertEquals(result, Expected);
			Thread.sleep(4000);
	}
	@Test (priority=2)
	public void assertSecondAlert() throws InterruptedException{
			driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button")).click();
			Alert alert2=driver.switchTo().alert();
			alert2.dismiss();
			String result2= driver.findElement(By.cssSelector("#result")).getText();
			String Expected2= "You clicked: Cancel";
			Assert.assertEquals(result2, Expected2);
			Thread.sleep(4000);
}
	@Test (priority=3)
	public void assertThirdAlert() throws InterruptedException{
			driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click();
			 driver.switchTo().alert().sendKeys("Hey its me");
			 driver.switchTo().alert().accept();
			 String finalResult=driver.findElement(By.cssSelector("#result")).getText();
			 String finalEx="You entered: Hey its me";
			 Assert.assertEquals(finalResult, finalEx);
				Thread.sleep(4000);
}
			
		@AfterTest
		public void After (){	Assert.assertAll();

	}
	
	

}
