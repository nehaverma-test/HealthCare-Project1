package medical.HealthCare;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchFunctionality {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.medanta.org/");

		WebElement searchBox = driver
				.findElement(By.xpath("//input[@placeholder='Search for Doctors and Specialities']"));

		searchBox.click();
		
		//Verify that Location, Doctor and Speciality dropdowns are displayed or not
		
		WebElement locationOption = 
				driver.findElement(By.xpath("//span[contains(text(),'Location')]"));
		
		System.out.println("Location displayed -> "+locationOption.isDisplayed());
		
		WebElement doctorOption = 
				driver.findElement(By.xpath("//span[contains(text(),'Doctor')]"));
		System.out.println("Doctor displayed -> "+doctorOption.isDisplayed());
		
		WebElement specialityOption = 
				driver.findElement(By.xpath("//span[contains(text(),'Speciality')]"));
		
		System.out.println("Speciality displayed -> "+specialityOption.isDisplayed());
		
		driver.quit();
		
	}

}
