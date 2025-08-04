package TestRunner;

import Config.Setup;
import orderPage.LoginPage;
import orderPage.SearchPage;
import org.testng.annotations.Test;

import java.io.IOException;
import com.aventstack.extentreports.ExtentTest;

public class LoginTestRunner extends Setup {
    @Test(priority = 1,description="Login With Valid Credential")
    public void doLoginWithValidCred() throws InterruptedException, IOException {
        test = extent.createTest("Login Test Suite"); // Parent test
        ExtentTest node = test.createNode("Login With Valid Credential"); // Child node
        LoginPage loginPage=new LoginPage(driver);
        String username=System.getProperty("username");
        String password=System.getProperty("password");

        loginPage.loginEntryPage(username,password,driver, node);
//        loginPage.loginEntryPage(driver, node); //If we define the username and password
        Thread.sleep(1000);
    }
}
