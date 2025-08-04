package TestRunner;

import Config.Setup;
import orderPage.AddToCart;
import orderPage.LoginPage;
import orderPage.SearchPage;
import orderPage.SelectItem;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import com.aventstack.extentreports.ExtentTest;

public class orderTestRunner extends Setup {

    @Test(priority = 1,description="Login Successfully Before Order")
    public void doLoginWithValidCred() throws InterruptedException, IOException {
        test = extent.createTest("Order Test Suite"); // Parent test
        ExtentTest node = test.createNode("Login Successfully Before Order"); // Child node
        LoginPage loginPage=new LoginPage(driver);
        String username=System.getProperty("username");
        String password=System.getProperty("password");

        loginPage.loginEntryPage(username,password,driver, node);
//        loginPage.loginEntryPage(driver, node);
        Thread.sleep(1000);

    }

    @Test(priority = 2,description="Search product successfully")
    public void doOrderCreation() throws InterruptedException, IOException {
        ExtentTest node = test.createNode("Search product successfully"); // Child node
        SearchPage orderPage=new SearchPage(driver);
        orderPage.orderCreatePage(driver, node);
        Thread.sleep(1000);
        String TextExpected=driver.findElement(By.xpath("//h1[text()='Bluetooth headphone']")).getText();
        String TextActual="Bluetooth headphone";
        Assert.assertTrue(TextActual.contains(TextExpected));

    }
    @Test(priority = 3,description="product select successfully")
    public void doProductSelect() throws InterruptedException, IOException {
        ExtentTest node = test.createNode("product select successfully"); // Child node
        SelectItem selectItem=new SelectItem(driver);
        selectItem.SelectItemPage(driver, node);
        Thread.sleep(1000);

    }
    @Test(priority = 4,description="Product Add to Cart successfully")
    public void doAddToCartSelect() throws InterruptedException, IOException {
        ExtentTest node = test.createNode("Product Add to Cart successfully"); // Child node
        AddToCart addToCart=new AddToCart(driver);
        addToCart.AddToCartPage(driver, node);
        Thread.sleep(1000);

    }
}
