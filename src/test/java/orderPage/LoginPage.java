package orderPage;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static Config.Setup.test;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.aventstack.extentreports.MediaEntityBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.Random;

public class LoginPage {
    @FindBy(xpath = "//a[text()='Login']")
    WebElement loginHeader;

    @FindBy(className = "iweb-input")
    List<WebElement> txtEnterUsername;

    @FindBy(className = "iweb-input")
    List<WebElement> txtEnterPassword;
    @FindBy(className = "iweb-button-mask")
    List<WebElement> loginButton;


    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void loginEntryPage(WebDriver driver, com.aventstack.extentreports.ExtentTest node) throws InterruptedException, IOException {
        node.info("Clicking on Login header");
        loginHeader.click();
        Thread.sleep(1000);
        node.info("Entering username");
        txtEnterUsername.get(0).sendKeys("01787671357");
        Thread.sleep(1000);
        node.info("Entering password");
        txtEnterPassword.get(1).sendKeys("Abc@1234");
        Thread.sleep(1000);
        node.info("Clicking on Login button");
        loginButton.get(0).click();
        Thread.sleep(1000);
        Random randNumber = new Random();
        int generateAutoNumber = randNumber.nextInt(9999) + 1111;

        // Take screenshot without base64
//        TakesScreenshot ts = (TakesScreenshot) driver;
//        String base64Screenshot = ts.getScreenshotAs(OutputType.BASE64);
//        node.pass("Login process completed",
//         MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());

        // Take screenshot without base64


//        File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        Random rand = new Random();
//        int autoNumber = rand.nextInt(99999999) + 10000000;
//        String filePath = "reports/screenshots/"+"screenshot_" + autoNumber + ".png";
//        File destFile = new File(filePath);
//        FileUtils.copyFile(screenShotFile, destFile);
//        String relativePath = "screenshots/" + filePath;




//        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFilePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotDir = "reports/screenshots/";
        new File(screenshotDir).mkdirs(); // Ensure directory exists
        String filename = "screenshot_" + generateAutoNumber + ".png";
        String fullScreenshotPath = screenshotDir + filename;
        File destFile = new File(fullScreenshotPath);
        FileUtils.copyFile(srcFilePath, destFile);
// Use RELATIVE path from HTML file (ExtentReport.html is in /reports/)
        String relativePath = "screenshots/" + filename;
        node.pass("Login process completed",
                MediaEntityBuilder.createScreenCaptureFromPath(relativePath).build());
    }


}
