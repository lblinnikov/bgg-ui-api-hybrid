package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.util.List;

import static common.WebDriverUtils.LOGGER;

public class GamePage extends LoadableComponent<GamePage> {

    private WebDriver driver;
    private String link;

    public GamePage(WebDriver driver, String link) {
        this.driver = driver;
        this.link = link;
        driver.get(link);
        PageFactory.initElements(driver, this);
    }

    // TODO 3. ask Gabriel what's better approach? With annotation, return element, or function of element languageDependency()?


//    @FindBy(xpath = "//span[contains(@ng-bind-html,'languagedependence')]")
//    WebElement languageDependence;


    WebElement languageDependency(){
        return driver.findElement(By.xpath("//span[contains(@ng-bind-html,'languagedependence')]"));
    }

    /**
     * Is language Dependency is displayed or not.
     * @param text text that should be inside of level dependency span
     * @return displayed or not
     */

    public boolean isLanguageDependencyDisplayed(String text){
        return languageDependency().getText().equals(text);
        //return languageDependence.getText().equals(text);
    }

    @Override
    protected void load() {
        LOGGER.info("GamePage.load()...");
    }

    @Override
    protected void isLoaded() throws Error {
        String url = driver.getCurrentUrl();
        Assert.assertTrue("Not on right page: " + url, url.equals(link));
    }
}