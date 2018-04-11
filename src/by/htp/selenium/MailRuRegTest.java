package by.htp.selenium;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MailRuRegTest {
	
	  @Test
	  public void regMail() throws InterruptedException {
		  
		  System.setProperty("webdriver.chrome.driver", "c:\\driver\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  
		  driver.get("https://mail.ru/");
		  Thread.sleep(2000);
		  
		  WebElement elemRegLink = driver.findElement(By.linkText("Регистрация нового ящика"));
		  elemRegLink.click();
		  Thread.sleep(2000);
		  
		  WebElement elemTextName = driver.findElement(By.name("firstname"));
		  elemTextName.sendKeys("Sergei");
		  
		  WebElement elemTextSurname = driver.findElement(By.name("lastname"));
		  elemTextSurname.sendKeys("Ivanov");
		  
		  WebElement elemDays = driver.findElement(By.cssSelector(".b-date__day > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1)"));
		  elemDays.click();
		  WebElement elemDay = driver.findElement(By.cssSelector("a.day5"));
		  elemDay.click();
		  
		  WebElement elemMonths = driver.findElement(By.cssSelector(".b-date__month > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1)"));
		  elemMonths.click();
		  WebElement elemMonth = driver.findElement(By.cssSelector(".b-date__month > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > a:nth-child(1) > span:nth-child(1)"));
		  elemMonth.click();
		  
		  WebElement elemYears = driver.findElement(By.cssSelector(".b-date__year > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > span:nth-child(1)"));
		  elemYears.click();
		  WebElement elemYear = driver.findElement(By.cssSelector(".b-dropdown_expanded > div:nth-child(2) > a:nth-child(4)"));
		  elemYear.click();
		  
		  
		  WebElement elemGender = driver.findElement(By.cssSelector("div.b-radiogroup__item:nth-child(2) > label:nth-child(1) > span:nth-child(1) > div:nth-child(2) > div:nth-child(2)"));
		  elemGender.click();
		  
		  WebElement elemTextLoginEmail = driver.findElement(By.cssSelector(".b-email__name > input:nth-child(1)"));
		  Random random = new Random();
		  String loginName = "sergeiivanov" + (random.nextInt(5000) + 5000);
		  elemTextLoginEmail.sendKeys(loginName);
		  
		  
		  WebElement elemClickEmail = driver.findElement(By.cssSelector(".b-password"));
		  elemClickEmail.click();
		  WebElement elemPassEmail = driver.findElement(By.xpath("//input[@type='password']"));
		  elemPassEmail.sendKeys("si123456789");
		  
		  WebElement elemRePassEmail = driver.findElement(By.cssSelector("#passwordRetry"));
		  elemRePassEmail.sendKeys("si123456789");
		  
		  WebElement elemNoPhone = driver.findElement(By.linkText("У меня нет мобильного телефона"));
		  elemNoPhone.click();
		  Thread.sleep(1000);
		  WebElement elemBtn = driver.findElement(By.cssSelector(".btn"));
		  elemBtn.click();
		  Thread.sleep(10000);
		

		  WebElement elemClosePopup = driver.findElement(By.xpath("//*[@id=\"themeInner\"]/div[8]/div[1]/div/div[1]/div"));
		  elemClosePopup.click();
		  
		  WebElement elemNewMail = driver.findElement(By.linkText("Написать письмо"));
		  elemNewMail.click();
		  
		  Thread.sleep(5000);
		  
		  driver.close();
	  }

}
