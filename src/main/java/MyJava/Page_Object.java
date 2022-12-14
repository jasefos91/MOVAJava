package MyJava;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Page_Object {public class MainPage {
    private AppiumDriver driver;

    public MainPage(AppiumDriver driver) {
        this.driver = driver;
    }

    By searchFieldLocator = By.id("search_field");
    By searchButtonLocator = By.id("search_button");

    public void enterSearchText(String searchText) {
        WebElement searchField = driver.findElement(searchFieldLocator);
        searchField.sendKeys(searchText);
    }

    public void clickSearchButton() {
        WebElement searchButton = driver.findElement(searchButtonLocator);
        searchButton.click();
    }
}

}
