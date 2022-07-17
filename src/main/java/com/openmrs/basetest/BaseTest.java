package com.openmrs.basetest;

import com.openmrs.extentreport.ExtentManager;
import com.openmrs.extentreport.ExtentTestManager;
import com.openmrs.extentreportlistner.AnnotationTransformer;
import com.openmrs.extentreportlistner.TestListener;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

@Listeners({AnnotationTransformer.class, TestListener.class})
public class BaseTest {

    public static WebDriver driver;

    public BaseTest() {

    }

    @Parameters({"browserName", "url"})
    @BeforeMethod
    public void beforeSuite(String browserName, @Optional("http://www.google.co.in") String url, Method method) throws Exception {
        getDriver(browserName);
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ExtentTestManager.startTest("" + method.getName());
        ExtentTestManager.getTest().log(LogStatus.INFO, "Open Browser and navigate to " + url, "Browser Name: " + browserName);
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (result.getStatus() == 2) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, result.getThrowable());
            ExtentTestManager.getTest().log(LogStatus.FAIL, "Test Failed");
        } else if (result.getStatus() == 3) {
            ExtentTestManager.getTest().log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
        } else {
            ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
        }

        ExtentManager.getReporter().endTest(ExtentTestManager.getTest());
        ExtentManager.getReporter().flush();
        this.driver.quit();
        ExtentTestManager.getTest().log(LogStatus.INFO, "Browser Closed");
    }

    public WebDriver getDriver(String browserName) throws Exception {
        try {
            if (browserName.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else if (browserName.equalsIgnoreCase("msedgedriver")) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            } else {
                System.out.println("Kindly Provide Proper Browser Name: It's supports only chrome,firefox and IE");
            }
            return driver;
        } catch (Exception e) {
            throw e;
        }
    }


}
