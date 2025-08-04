package orderPage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import static Config.Setup.test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.aventstack.extentreports.MediaEntityBuilder;
import java.io.IOException;


public class SearchPage {

    @FindBy(xpath = "//input[@type='search' and @id='q']")
    WebElement searchBar;


    public SearchPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void orderCreatePage(WebDriver driver, com.aventstack.extentreports.ExtentTest node) throws InterruptedException, IOException {
        node.info("Clicking on search bar");
        searchBar.click();
        Thread.sleep(2000);
        node.info("Entering search text: Bluetooth headphone");
        searchBar.sendKeys("Bluetooth headphone");
        Thread.sleep(1000);
        node.info("Pressing ENTER to search");
        searchBar.sendKeys(Keys.ENTER);
        Thread.sleep(1000);

        // Take screenshot
                //        TakesScreenshot ts = (TakesScreenshot) driver;
                //        String base64Screenshot = ts.getScreenshotAs(OutputType.BASE64);
                //        node.pass("Search completed",
                //            MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        Screenshot screenshotUtil = new Screenshot();
        screenshotUtil.getScreenShot(driver, node, "Search completed screenshot successfully attached");

    }


}
