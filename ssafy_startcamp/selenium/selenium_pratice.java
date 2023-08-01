package selenium_pratice;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class selenium_pratice {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.naver.com");
		
		WebElement financeBtn = driver.findElement(By.cssSelector("#shortcutArea > ul > li:nth-child(6) > a"));
		financeBtn.click();
		
		ArrayList<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(1));

		WebElement searchInput = driver.findElement(By.cssSelector("#stock_items"));
		searchInput.sendKeys("»ï¼ºÀüÀÚ");
		searchInput.sendKeys(Keys.ENTER);
		
	}
}
