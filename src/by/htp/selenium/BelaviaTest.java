package by.htp.selenium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BelaviaTest {

	@Test
	public void getTickets() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "c:\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://belavia.by/");

		// Thread.sleep(5000);

		WebElement elemTextOrigLocation = driver.findElement(By.xpath("//input[@name='OriginLocation_Combobox']"));
		elemTextOrigLocation.sendKeys("Минск (MSQ), BY");
		elemTextOrigLocation.sendKeys(Keys.ENTER);

		WebElement elemTextDestLocation = driver.findElement(By.xpath("//input[@name='DestinationLocation_Combobox']"));
		elemTextDestLocation.sendKeys("Гонконг (HKG), HK");
		elemTextDestLocation.sendKeys(Keys.ENTER);

		Thread.sleep(1000);

		WebElement elemSetDepartDate = driver
				.findElement(By.xpath("//*[@id='calendar']/div/div[1]/table/tbody/tr[6]/td[1]/a"));
		elemSetDepartDate.click();

		Thread.sleep(1000);

		WebElement elemSetReturnDate = driver
				.findElement(By.xpath("//*[@id='calendar']/div/div[2]/table/tbody/tr[5]/td[4]/a"));
		elemSetReturnDate.click();

		WebElement elemButtonFind = driver.findElement(By.xpath("//*[@id='step-2']/div[4]/div/button"));
		elemButtonFind.click();

		Thread.sleep(1000);

		WebElement elemLinkCalend = driver.findElement(By.xpath("//*[@id='outbound']/div[1]/div/div[2]/a"));
		elemLinkCalend.click();

		List<Double> listPrices = new ArrayList<>();
		int countWeek = 16;

		for (int i = 0; i < countWeek; i++) {
			List<WebElement> listElements = driver.findElements(By.xpath("//*[@class='price']/*/label"));
			for (WebElement elem : listElements) {
				
				double d = Double.parseDouble(elem.getText().replaceAll("[^0-9,]", "").replace(",", "."));
				listPrices.add(d);
				
			}
			WebElement elemNextWeek = driver.findElement(By.xpath("//div[@class='d-outbound']/div[2]/a"));
			elemNextWeek.click();
			Thread.sleep(500);
		}

		System.out.println("Min price: " + Collections.min(listPrices));
		System.out.println("Max price: " + Collections.max(listPrices));

		System.out.println("Tickets count: " + listPrices.size());

		driver.close();
	}

}
