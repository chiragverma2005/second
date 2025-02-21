package Stepdefination;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.GoogleSearch;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchSteps {
	public static WebDriver driver;
	public GoogleSearch g;
		
	@Given("browser is open")
	public void browser_is_open() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		g = new GoogleSearch(driver);
	}

	@And("user is on google search page")
	public void user_is_on_google_search_page() {
		driver.get("https://www.google.com/");
	}

	@When("^user enters a (.*) in search box$")
	public void user_enters_a_text_in_search_box(String text) {
	    
	    g.sendText(text);
	}

	@When("hits enter")
	public void hits_enter() {
		g.searchbox.sendKeys(Keys.ENTER);
	}

	@Then("user is navigated to search results")
    public void user_is_navigated_to_search_results() {
        driver.getPageSource().contains("About 1,25,000 results (0.39 seconds)");
    }

    @After
    public void tearDown() {
    	if(driver!=null) {
        driver.quit();
    	}
    }
}