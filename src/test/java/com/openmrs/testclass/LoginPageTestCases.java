package com.openmrs.testclass;


import com.openmrs.basetest.BaseTest;
import com.openmrs.commonpo.LoginPagePO;
import com.openmrs.commonutilitiesmethods.CommonUtilitiesMethods;
import com.openmrs.extentreport.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTestCases extends BaseTest {

    public int flag = 1;
    public static Logger Log = LogManager.getLogger(LoginPageTestCases.class.getName());
    public static CommonUtilitiesMethods commonMethods = new CommonUtilitiesMethods();

    public LoginPageTestCases() {

    }

    public LoginPageTestCases(WebDriver driver, int Flag) {
        this.driver = driver;
        flag = Flag;
    }

    @Test
    public void verifyPageTitle() {
        if (flag > 0) {
            ExtentTestManager.getTest().getTest().setName("openMRS_TC01: To verify admin login page title.");
            ExtentTestManager.getTest().assignCategory("Component: Login");
        }
        ExtentTestManager.getTest().log(LogStatus.INFO, "Execution Start for openMRS_TC01");

        Assert.assertEquals(commonMethods.verifyPageTitle("Login"), true, "Login Page title is not correct.");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Verify Login  page title", "Login page title is as expected.");
        Log.info("Page title verification completed.");
    }

    @Test
    public void verifyCantLoginHyperTextFunctionality() {
        if (flag > 0) {
            ExtentTestManager.getTest().getTest().setName("openMRS_TC02: To verify 'Can't log in?' hyperlink text functionality.");
            ExtentTestManager.getTest().assignCategory("Component: Login");
        }
        LoginPagePO loginPO = new LoginPagePO(driver);
        ExtentTestManager.getTest().log(LogStatus.INFO, "Execution Start for openMRS_TC02");

        Assert.assertEquals(loginPO.clickOnCantLoginText(), true, "Unable to click on 'Can't log in?' text.");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Click on 'Can't log in?'", "Alert is displayed with 'Okay' button");
        Log.info("Alert is displayed with 'Okay' button and It has been accepted successfully.");

        Assert.assertEquals(loginPO.clickOnOkayButton(), true, "Unable to click on 'Okay' button.");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Click on 'Okay'", "'Okay' button clicked");
        Log.info("Alert is disappeared.");
    }

    @Test
    public void verifyLoginWithInvalidUsernameAndPassword() {
        if (flag > 0) {
            ExtentTestManager.getTest().getTest().setName("openMRS_TC03: To verify login functionality with invalid username & password.");
            ExtentTestManager.getTest().assignCategory("Component: Login");
        }
        String UserName = "Adminn";
        String Password = "Adminn12132";
        LoginPagePO loginPO = new LoginPagePO(driver);
        ExtentTestManager.getTest().log(LogStatus.INFO, "Execution Start for openMRS_TC03");

        // Step 1: Enter username
        Assert.assertEquals(loginPO.enterUsername(UserName), true, "Unable to enter username.");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Enter username", "Entered username is " + UserName);
        Log.info("Username is " + UserName + " successfully entered.");

        // Step 2: Enter password
        Assert.assertEquals(loginPO.enterPassword(Password), true, "Unable to enter password.");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Enter password", "Entered password is " + Password);
        Log.info("Password is " + Password + " successfully entered.");

        // Step 3: Select location
        Assert.assertEquals(loginPO.selectLocation(), true, "Unable to select location.");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Select location", "Selected location highlight with blue background.");
        Log.info("Location is successfully selected.");

        // Step 4: Click on login button
        Assert.assertEquals(loginPO.clickOnLoginButton(), true, "Unable to click on log in button");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Click on 'Log In' button", "Web application keep user on same page.");
        Log.info("Log In button successfully clicked.");

        // Step 5: Verify error message
        Assert.assertEquals(loginPO.verifyErrorMessage(), true, "Error message doesn't matched.");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Verify error message", "Error message is as expected");
        Log.info("Error message verification completed.");
    }

    @Test
    public void verifyLoginWithInvalidUsernameAndValidPassword() {
        if (flag > 0) {
            ExtentTestManager.getTest().getTest().setName("openMRS_TC04: To verify login functionality with invalid username & valid password.");
            ExtentTestManager.getTest().assignCategory("Component: Login");
        }
        String UserName = "Adminn";
        String Password = "Admin123";
        LoginPagePO loginPO = new LoginPagePO(driver);
        ExtentTestManager.getTest().log(LogStatus.INFO, "Execution Start for openMRS_TC04");

        // Step 1: Enter username
        Assert.assertEquals(loginPO.enterUsername(UserName), true, "Unable to enter username.");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Enter username", "Entered username is " + UserName);
        Log.info("Username is " + UserName + " successfully entered.");

        // Step 2: Enter password
        Assert.assertEquals(loginPO.enterPassword(Password), true, "Unable to enter password.");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Enter password", "Entered password is " + Password);
        Log.info("Password is " + Password + " successfully entered.");

        // Step 3: Select location
        Assert.assertEquals(loginPO.selectLocation(), true, "Unable to select location.");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Select location", "Selected location highlight with blue background.");
        Log.info("Location is successfully selected.");

        // Step 4: Click on login button
        Assert.assertEquals(loginPO.clickOnLoginButton(), true, "Unable to click on log in button");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Click on 'Log In' button", "Web application keep user on same page.");
        Log.info("Log In button successfully clicked.");

        // Step 5: Verify error message
        Assert.assertEquals(loginPO.verifyErrorMessage(), true, "Error message doesn't matched.");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Verify error message", "Error message is as expected");
        Log.info("Error message verification completed.");
    }

    @Test
    public void verifyLoginWithValidUsernameAndInvalidPassword() {
        if (flag > 0) {
            ExtentTestManager.getTest().getTest().setName("openMRS_TC05: To verify login functionality with valid username & invalid password.");
            ExtentTestManager.getTest().assignCategory("Component: Login");
        }
        String UserName = "Admin";
        String Password = "Admin1234";
        LoginPagePO loginPO = new LoginPagePO(driver);
        ExtentTestManager.getTest().log(LogStatus.INFO, "Execution Start for openMRS_TC05");

        // Step 1: Enter username
        Assert.assertEquals(loginPO.enterUsername(UserName), true, "Unable to enter username.");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Enter username", "Entered username is " + UserName);
        Log.info("Username is " + UserName + " successfully entered.");

        // Step 2: Enter password
        Assert.assertEquals(loginPO.enterPassword(Password), true, "Unable to enter password.");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Enter password", "Entered password is " + Password);
        Log.info("Password is " + Password + " successfully entered.");

        // Step 3: Select location
        Assert.assertEquals(loginPO.selectLocation(), true, "Unable to select location.");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Select location", "Selected location highlight with blue background.");
        Log.info("Location is successfully selected.");

        // Step 4: Click on login button
        Assert.assertEquals(loginPO.clickOnLoginButton(), true, "Unable to click on log in button");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Click on 'Log In' button", "Web application keep user on same page.");
        Log.info("Log In button successfully clicked.");

        // Step 5: Verify error message
        Assert.assertEquals(loginPO.verifyErrorMessage(), true, "Error message doesn't matched.");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Verify error message", "Error message is as expected");
        Log.info("Error message verification completed.");
    }

    @Test
    public void verifyLoginWithBlankUsernameAndPassword() {
        if (flag > 0) {
            ExtentTestManager.getTest().getTest().setName("openMRS_TC06: To verify login functionality with null value of username & password.");
            ExtentTestManager.getTest().assignCategory("Component: Login");
        }
        LoginPagePO loginPO = new LoginPagePO(driver);
        ExtentTestManager.getTest().log(LogStatus.INFO, "Execution Start for openMRS_TC06");

        // Step 1: Click on login button
        Assert.assertEquals(loginPO.clickOnLoginButton(), true, "Unable to click on log in button");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Click on 'Log In' button", "Web application keep user on same page.");
        Log.info("Log In button successfully clicked.");

        // Step 2: Verify error message
        Assert.assertEquals(loginPO.validateLocationErrorMsg(), true, "Error message doesn't matched.");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Verify error message", "Error message is as expected");
        Log.info("Error message verification completed.");
    }

    @Test
    public void verifyLoginWithoutLocationSelection() {
        if (flag > 0) {
            ExtentTestManager.getTest().getTest().setName("openMRS_TC07: To verify login functionality without select location slab.");
            ExtentTestManager.getTest().assignCategory("Component: Login");
        }
        String UserName = "Admin";
        String Password = "Admin123";
        LoginPagePO loginPO = new LoginPagePO(driver);
        ExtentTestManager.getTest().log(LogStatus.INFO, "Execution Start for openMRS_TC07");

        // Step 1: Enter username
        Assert.assertEquals(loginPO.enterUsername(UserName), true, "Unable to enter username.");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Enter username", "Entered username is " + UserName);
        Log.info("Username is " + UserName + " successfully entered.");

        // Step 2: Enter password
        Assert.assertEquals(loginPO.enterPassword(Password), true, "Unable to enter password.");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Enter password", "Entered password is " + Password);
        Log.info("Password is " + Password + " successfully entered.");

        // Step 3: Click on login button
        Assert.assertEquals(loginPO.clickOnLoginButton(), true, "Unable to click on log in button");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Click on 'Log In' button", "Web application keep user on same page.");
        Log.info("Log In button successfully clicked.");

        // Step 4: Verify error message
        Assert.assertEquals(loginPO.validateLocationErrorMsg(), true, "Error message doesn't matched.");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Verify error message", "Error message is as expected");
        Log.info("Error message verification completed.");
    }

    @Test
    public void verifyLoginWithValidUsernameAndPassword() {
        if (flag > 0) {
            ExtentTestManager.getTest().getTest().setName("openMRS_TC08: To verify login functionality with valid username & password.");
            ExtentTestManager.getTest().assignCategory("Component: Login");
        }
        String UserName = "Admin";
        String Password = "Admin123";
        LoginPagePO loginPO = new LoginPagePO(driver);
        ExtentTestManager.getTest().log(LogStatus.INFO, "Execution Start for openMRS_TC08");

        // Step 1: Enter username
        Assert.assertEquals(loginPO.enterUsername(UserName), true, "Unable to enter username.");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Enter username", "Entered username is " + UserName);
        Log.info("Username is " + UserName + " successfully entered.");

        // Step 2: Enter password
        Assert.assertEquals(loginPO.enterPassword(Password), true, "Unable to enter password.");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Enter password", "Entered password is " + Password);
        Log.info("Password is " + Password + " successfully entered.");

        // Step 3: Select location
        Assert.assertEquals(loginPO.selectLocation(), true, "Unable to select location.");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Select location", "Selected location highlight with blue background.");
        Log.info("Location is successfully selected.");

        // Step 4: Click on login button
        Assert.assertEquals(loginPO.clickOnLoginButton(), true, "Unable to click on log in button");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Click on 'Log In' button", "Web application keep user on same page.");
        Log.info("Log In button successfully clicked.");

        // Step 5: Verify error message
        Assert.assertEquals(loginPO.validateDashboardMsg(), true, "Dashboard message doesn't matched.");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Verify dashboard message", "Dashboard message is as expected");
        Log.info("Dashboard message verification completed.");
    }

}
