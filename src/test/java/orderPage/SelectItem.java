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

public class SelectItem {
    @FindBy(xpath = "//div[@data-qa-locator='product-item'][1]")
    WebElement selectItem;


    public SelectItem(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void SelectItemPage(WebDriver driver, com.aventstack.extentreports.ExtentTest node) throws InterruptedException, IOException {
        node.info("Clicking on first product item");
        selectItem.click();
        Thread.sleep(1500);

        // Take screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        String base64Screenshot = ts.getScreenshotAs(OutputType.BASE64);
        node.pass("Item selected",
            MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
    }
}
