package Config;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.internal.thread.ThreadExecutionException;

import java.time.Duration;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Setup {
    public WebDriver driver;
    public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeTest
    public void startBrowser() {
        extent = ExtentManager.getInstance();
        test = extent.createTest("Browser Setup");

        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.get("https://www.daraz.com.bd/");
        driver.manage().window().maximize();

        test.pass("Browser launched and navigated to Daraz");
    }

    @AfterTest
    public void closeBrowser() throws InterruptedException {
        driver.quit();
        test.pass("Browser closed");
        extent.flush();
    }
}
