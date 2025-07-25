package orderPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class AddToCart {
    @FindBy(className = "add-to-cart-buy-now-btn")
    List<WebElement> addToCartButton;

    @FindBy(className = "cart-icon-daraz")
    List<WebElement> SelectCartButton;

    @FindBy(className = "next-dialog-body")
    List<WebElement> dialogueBox;

    @FindBy(className = "next-dialog-close")
    List<WebElement> closeButton;

    @FindBy(xpath = "//input[@type='checkbox']")
     WebElement SelectAllButton;

    public AddToCart(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void AddToCartPage(WebDriver driver, com.aventstack.extentreports.ExtentTest node) throws InterruptedException, IOException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        node.info("Scrolling down the page");
        js.executeScript("window.scrollBy(0,400)"); // Scroll down by 600 pixels
        Thread.sleep(500);
        node.info("Clicking Add to Cart button");
        addToCartButton.get(1).click();
        Thread.sleep(1000);


//        List<WebElement> dialogueBox = driver.findElements(By.className("next-dialog-body"));
        node.info("Handling dialog box");
        dialogueBox.get(0).click();
        Thread.sleep(1000);


//        List<WebElement> closeButton = driver.findElements(By.className("next-icon"));
        node.info("Closing dialog");
        closeButton.get(0).click();
        Thread.sleep(1000);


        node.info("Clicking Cart icon");
        SelectCartButton.get(0).click();
        Thread.sleep(1000);

        node.info("Selecting all items in cart");
        SelectAllButton.click();
        Thread.sleep(1000);
        node.pass("Added cart successfully");

        // Take screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        String base64Screenshot = ts.getScreenshotAs(OutputType.BASE64);
        node.pass("Cart page screenshot",
            MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
    }
}
