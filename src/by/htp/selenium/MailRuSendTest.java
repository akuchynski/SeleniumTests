package by.htp.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MailRuSendTest {
	
	 @Test
	  public void sendMail() throws InterruptedException {
		  
		  System.setProperty("webdriver.chrome.driver", "c:\\driver\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  
		  driver.get("https://mail.ru/");
		  Thread.sleep(2000);
		  
		  WebElement elemTextLogin = driver.findElement(By.name("login"));
		  elemTextLogin.sendKeys("sergeiivanov8432");
		  
		  WebElement elemTextPass = driver.findElement(By.name("password"));
		  elemTextPass.sendKeys("si123456789");
		  
		  WebElement elemLoginBtn = driver.findElement(By.xpath("//*[@id=\"mailbox:submit\"]/input"));
		  elemLoginBtn.click();
		  Thread.sleep(1000);
		  

		  WebElement elemNewMail = driver.findElement(By.xpath("//*[@id=\"b-toolbar__left\"]/div/div/div[2]/div/a"));
		  elemNewMail.click();
		  Thread.sleep(2000);

		  WebElement elemTextEmailAdr = driver.findElement(By.xpath("//textarea[@data-original-name='To']"));
		  elemTextEmailAdr.sendKeys("akawrk@yandex.ru");
		  
		  WebElement elemTextEmailTitle = driver.findElement(By.xpath("//input[@name='Subject']"));
		  elemTextEmailTitle.sendKeys("Test title");
		  
		  
		  driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@scrolling='auto']")));
		  WebElement elemTextEmailText = driver.findElement(By.xpath("//body[@id='tinymce']"));
		  elemTextEmailText.click();
		  elemTextEmailText.sendKeys(" Test text 123456789");
		  driver.switchTo().defaultContent();
		  
		  WebElement elemMailSend = driver.findElement(By.xpath("//*[@id='b-toolbar__right']/div[3]/div/div[2]/div[1]/div"));
		  elemMailSend.click();

		  Thread.sleep(5000);
		  
		  driver.close();
	  }

}
