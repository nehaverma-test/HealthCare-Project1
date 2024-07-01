package medical.HealthCare;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchForSpeicalities {
	static WebDriverWait wait;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.medanta.org/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement searchBox = driver
				.findElement(By.xpath("//input[@placeholder='Search for Doctors and Specialities']"));

		searchBox.sendKeys("Skin");
		driver.findElement(By.className("searchicon")).click();
		List<WebElement> skinSearchResult = driver.findElements(By.cssSelector(".suggested-list table tbody tr a"));

		for (WebElement result : skinSearchResult) {
			if (result.getText().equals("Skin Allergies")) {
				result.click();
				break;
			}
		}

		String skinAllergyText = driver.findElement(By.cssSelector("h1.banner-title ")).getText();

		if (skinAllergyText.equals("Skin Allergies")) {
			System.out.println("Skin Allergy page is opened fine");
		}

		// Find A Doctor
		driver.findElement(By.xpath("//a[contains(text(),'Find A doctor')]")).click();

		// Parent window
		String parentWindow = driver.getWindowHandle();

		Set<String> s = driver.getWindowHandles();

		Iterator<String> I1 = s.iterator();

		while (I1.hasNext()) {
			String childWindow = I1.next();
			if (!parentWindow.equals(childWindow)) {
				driver.switchTo().window(childWindow);
			}
		}

		// Get Current Url and verify Dermatology text is displayed fine or not in the
		// url
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains("speciality=dermatology")) {
			System.out.println("Dermatology page is opened fine");
		}

		driver.switchTo().window(parentWindow);
		
	//Fetch Title of the page and verify the previous window is in focus or not
	String currentTitle = driver.getTitle();
	
	String expectedTitle = "Expert Skin Allergies Treatment Solutions | Compassionate Care at Medanta";
	if(currentTitle.equals(expectedTitle))
	{
		System.out.println("Focus is now on parent window");
	}
	
	driver.quit();
	}

}
