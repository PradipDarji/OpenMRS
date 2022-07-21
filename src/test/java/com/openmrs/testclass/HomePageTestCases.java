package com.openmrs.testclass;

import com.openmrs.basetest.BaseTest;
import com.openmrs.commonpo.HomePagePO;
import com.openmrs.commonutilitiesmethods.CommonUtilitiesMethods;
import com.openmrs.extentreport.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTestCases extends BaseTest {

    public int flag = 1;
    public static Logger Log = LogManager.getLogger(LoginPageTestCases.class.getName());
    public static CommonUtilitiesMethods commonMethods = new CommonUtilitiesMethods();
    public static LoginPageTestCases loginTestCases = new LoginPageTestCases(driver,0);

    public HomePageTestCases() {

    }

    public HomePageTestCases(WebDriver driver, int Flag) {
        this.driver = driver;
        flag = Flag;
    }

    @Test
    public void verifyPageTitle() {
        if (flag > 0) {
            ExtentTestManager.getTest().getTest().setName("openMRS_TC09: To verify home page title.");
            ExtentTestManager.getTest().assignCategory("Component: Home");
        }
        ExtentTestManager.getTest().log(LogStatus.INFO, "Execution Start for openMRS_TC09");
        loginTestCases.verifyLoginWithValidUsernameAndPassword();

        Assert.assertEquals(commonMethods.verifyPageTitle("Home"), true, "Home Page title is not correct.");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Verify Home  page title", "Home page title is as expected.");
        Log.info("Page title verification completed.");
    }

    @Test
    public void verifyHomePagesSlabs() {
        if (flag > 0) {
            ExtentTestManager.getTest().getTest().setName("openMRS_TC10: To verify all home page slab url is working.");
            ExtentTestManager.getTest().assignCategory("Component: Home");
        }
        HomePagePO homepage = new HomePagePO(driver);
        ExtentTestManager.getTest().log(LogStatus.INFO, "Execution Start for openMRS_TC10");
        loginTestCases.verifyLoginWithValidUsernameAndPassword();

        Assert.assertEquals(homepage.clickOnHomePageSlabs(), true, "Unable to click on Home page slabs");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Verify all home page slabs url is working.", "Home page slabs are clickable.");
        Log.info("All home page slabs are working fine.");
    }

    @Test
    public void verifyAdminButtonFunctionality() {
        if (flag > 0) {
            ExtentTestManager.getTest().getTest().setName("openMRS_TC11: To verify 'admin' button functionality.");
            ExtentTestManager.getTest().assignCategory("Component: Home");
        }
        ExtentTestManager.getTest().log(LogStatus.INFO, "Execution Start for openMRS_TC11");
        HomePagePO homepage = new HomePagePO(driver);
        loginTestCases.verifyLoginWithValidUsernameAndPassword();

        Assert.assertEquals(homepage.moveToAdmin(), true, "Unable to move on 'Admin' menu");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Verify 'admin' button functionality.", "Admin menu display 'My Account'.");
        Log.info("'My Account' sub-menu populate successfully.");

        Assert.assertEquals(homepage.clickOnMyAccount(), true, "Unable to click on 'My Account'");
        ExtentTestManager.getTest().log(LogStatus.PASS, "User click on 'My Account' option", "User successfully redirected on My Account page.");
        Log.info("My Account page successfully opened.");

        Assert.assertEquals(commonMethods.verifyPageTitle("My Account"), true, "My Account Page title is not correct.");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Verify My Account  page title", "My Account page title is as expected.");
        Log.info("Page title verification completed.");

        Assert.assertEquals(homepage.clickOnChangePasswordSlab(), true, "Unable to click on 'Change Password' slab");
        ExtentTestManager.getTest().log(LogStatus.PASS, "User click on 'Change Password' option", "User successfully clicked on change password slab.");
        Log.info("User successfully clicked on change password slab.");

        Assert.assertEquals(homepage.verifyPageHeaderTitleForChangePassword(), true, "Unable to validate page header title.");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Verify change password page header title.", "Change password page header title is as expected.");
        Log.info("Change password page header title verification completed.");

        Assert.assertEquals(homepage.clickOnCancel(), true, "Unable to click on 'Cancel'");
        ExtentTestManager.getTest().log(LogStatus.PASS, "User click on 'Cancel' button", "User successfully clicked on cancel button.");
        Log.info("User successfully clicked on cancel button.");

        Assert.assertEquals(homepage.clickOnMyLanguages(), true, "Unable to click on 'My Languages' slab");
        ExtentTestManager.getTest().log(LogStatus.PASS, "User click on 'My Languages' option", "User successfully clicked on my languages slab.");
        Log.info("User successfully clicked on my languages slab.");

        Assert.assertEquals(homepage.verifyPageHeaderTitleForMyLanguages(), true, "Unable to validate page header title.");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Verify my languages page header title.", "My Languages page header title is as expected.");
        Log.info("My languages page header title verification completed.");

        Assert.assertEquals(homepage.clickOnCancel(), true, "Unable to click on 'Cancel'");
        ExtentTestManager.getTest().log(LogStatus.PASS, "User click on 'Cancel' button", "User successfully clicked on cancel button.");
        Log.info("User successfully clicked on cancel button.");

        Assert.assertEquals(commonMethods.verifyPageTitle("My Account"), true, "My Account Page title is not correct.");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Verify My Account  page title", "My Account page title is as expected.");
        Log.info("Page title verification completed.");
    }

    @Test
    public void verifyChangeLocationFunctionality() {
        if (flag > 0) {
            ExtentTestManager.getTest().getTest().setName("openMRS_TC12: To verify change location functionality.");
            ExtentTestManager.getTest().assignCategory("Component: Home");
        }
        ExtentTestManager.getTest().log(LogStatus.INFO, "Execution Start for openMRS_TC12");
        HomePagePO homepage = new HomePagePO(driver);
        loginTestCases.verifyLoginWithValidUsernameAndPassword();

        Assert.assertEquals(homepage.clickOnSelectLocation(), true, "Unable to select location.");
        ExtentTestManager.getTest().log(LogStatus.PASS, "User click on 'Location Selection' menu.", "User successfully clicked on 'Location Selection'.");
        Log.info("User successfully clicked on location selection button.");

        Assert.assertEquals(homepage.clickOnSelectLocation(), true, "Unable to select location.");
        ExtentTestManager.getTest().log(LogStatus.PASS, "User click on 'Location Selection' menu.", "User successfully clicked on 'Location Selection'.");
        Log.info("User successfully clicked on location selection button.");

        Assert.assertEquals(homepage.moveToLocationOptions(), true, "Unable to move on 'Outpatient Clinic' menu");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Click on 'Outpatient Clinic'.", "User successfully clicked on 'Outpatient Clinic'.");
        Log.info("User successfully clicked on 'Outpatient Clinic' location option.");

        Assert.assertEquals(homepage.verifySelectedLocation(), true, "Unable to see selected location.");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Verify before selected location and after selected location..", "User selected location is not correct.");
        Log.info("User location verification completed.");
    }

    @Test
    public void verifyAppLogoFunctionality() {
        if (flag > 0) {
            ExtentTestManager.getTest().getTest().setName("openMRS_TC13: To verify 'Open MRS' logo functionality.");
            ExtentTestManager.getTest().assignCategory("Component: Home");
        }
        ExtentTestManager.getTest().log(LogStatus.INFO, "Execution Start for openMRS_TC13");
        HomePagePO homepage = new HomePagePO(driver);
        loginTestCases.verifyLoginWithValidUsernameAndPassword();

        Assert.assertEquals(homepage.moveToAdmin(), true, "Unable to move on 'Admin' menu");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Verify 'admin' button functionality.", "Admin menu display 'My Account'.");
        Log.info("'My Account' sub-menu populate successfully.");

        Assert.assertEquals(homepage.clickOnMyAccount(), true, "Unable to click on 'My Account'");
        ExtentTestManager.getTest().log(LogStatus.PASS, "User click on 'My Account' option", "User successfully redirected on My Account page.");
        Log.info("My Account page successfully opened.");

        Assert.assertEquals(commonMethods.verifyPageTitle("My Account"), true, "My Account Page title is not correct.");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Verify My Account  page title", "My Account page title is as expected.");
        Log.info("Page title verification completed.");

        Assert.assertEquals(homepage.clickOnLogo(), true, "Unable to click on App Logo");
        ExtentTestManager.getTest().log(LogStatus.PASS, "User click on wep app logo", "User successfully redirected on home page.");
        Log.info("User successfully clicked  on web app logo.");

        Assert.assertEquals(commonMethods.verifyPageTitle("Home"), true, "Home Page title is not correct.");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Verify Home  page title", "Home page title is as expected.");
        Log.info("Page title verification completed.");
    }

    @Test
    public void verifyLogOutFunctionality() {
        if (flag > 0) {
            ExtentTestManager.getTest().getTest().setName("openMRS_TC14: To verify logout functionality.");
            ExtentTestManager.getTest().assignCategory("Component: Home");
        }
        ExtentTestManager.getTest().log(LogStatus.INFO, "Execution Start for openMRS_TC14");
        HomePagePO homepage = new HomePagePO(driver);
        loginTestCases.verifyLoginWithValidUsernameAndPassword();

        Assert.assertEquals(commonMethods.verifyPageTitle("Home"), true, "Home Page title is not correct.");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Verify Home  page title", "Home page title is as expected.");
        Log.info("Page title verification completed.");

        Assert.assertEquals(homepage.clickOnLogout(), true, "Unable to click on logout.");
        ExtentTestManager.getTest().log(LogStatus.PASS, "User click on logout button", "User successfully logged out from the web application.");
        Log.info("User successfully logged out from the web app.");

        Assert.assertEquals(commonMethods.verifyPageTitle("Login"), true, "Login Page title is not correct.");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Verify Login  page title", "Login page title is as expected.");
        Log.info("Page title verification completed.");

    }
}
