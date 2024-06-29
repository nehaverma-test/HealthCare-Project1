package medical.HealthCare;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.medanta.org/");
		driver.manage().window().maximize();

		//Action class to mouse hover Locations dropdown
		Actions action = new Actions(driver);
		WebElement locationDropdown = driver.findElement(By.xpath("//a[contains(text(),'Locations')]"));
        action.moveToElement(locationDropdown).build().perform();
        
        driver.findElement(By.linkText("Medanta Gurugram")).click();
        
        
        //Verify that Gurugram page is opened or not
        
        String currentUrl = "https://www.medanta.org/hospitals-near-me/gurugram-hospital";
        String expectedUrl = driver.getCurrentUrl();
        if(expectedUrl.equals(currentUrl))
        {
        	System.out.println("Gurugram page is opened");
        }
        else
        {
        	System.out.println("Invalid page");
        }
        
        driver.quit();
        
      
	}

}
