package LearningTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Logins {
	@Test(priority=3)
	public void GmailLogin() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://accounts.google.com/");
		Thread.sleep(3000);
		driver.findElement(By.id("identifierId")).sendKeys("venkatakrishnaiah003@gmail.com",Keys.ENTER);
		driver.findElement(By.id("password")).sendKeys("8464889435",Keys.ENTER);
		driver.quit();
	}
	@Test(priority=2)
	public void FacebookLogin() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com//");
		Thread.sleep(3000);
		driver.findElement(By.id("email")).sendKeys("8464889435",Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.id("pass")).sendKeys("gvkumark",Keys.ENTER);
		Thread.sleep(3000);
		driver.quit();
	}
	@Test(priority=1)
	public void TeamsViewLogin() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.microsoftonline.com/");
		Thread.sleep(3000);
		driver.findElement(By.id("i0116")).sendKeys("gvenkatakrishnaiah@softpathtech.com",Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.id("i0118")).sendKeys("Krishna@003",Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.id("idBtn_Back")).click();
		driver.quit();


	}


}
