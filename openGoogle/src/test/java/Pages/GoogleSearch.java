package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearch {
public GoogleSearch(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(name="q")
public WebElement searchbox;

public void sendText(String text) {
	searchbox.sendKeys(text);
}
}