package com.openmrs.commonpo;

import com.openmrs.commonutilitiesmethods.CommonUtilitiesMethods;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPagePO {

    public WebDriver driver;
    public WebDriverWait wait;
    public String selectedSlab;
    CommonUtilitiesMethods commonMethods = new CommonUtilitiesMethods();

    public LoginPagePO(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public By cantLogin = By.cssSelector("a[id='cantLogin']");
    public By enterUname = By.cssSelector("input[id='username']");
    public By enterPass = By.cssSelector("input[id='password']");
    public By inpatientWard = By.cssSelector("li[id='Inpatient Ward']");
    public By loginButton = By.cssSelector("input[id='loginButton']");
    public By errorMessage = By.cssSelector("div[id='error-message']");
    public By oKayBtn = By.cssSelector("#cannotLoginPopup button");
    public By locationErrorMessage = By.cssSelector("span[id=sessionLocationError]");
    public By dashboardMessage = By.cssSelector("div[class='col-12 col-sm-12 col-md-12 col-lg-12'] h4");


    public boolean clickOnCantLoginText() {
        try {
            WebElement cantLoginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(cantLogin));
            commonMethods.clickOnButton(driver, cantLoginBtn);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean clickOnOkayButton() {
        try {
            WebElement oKayButton = wait.until(ExpectedConditions.visibilityOfElementLocated(oKayBtn));
            commonMethods.clickOnButton(driver, oKayButton);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean enterUsername(String UserName) {
        try {
            WebElement uName = wait.until(ExpectedConditions.visibilityOfElementLocated(enterUname));
            commonMethods.enterText(uName, UserName);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean enterPassword(String Password) {
        try {
            WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(enterPass));
            commonMethods.enterText(password, Password);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean selectLocation() {
        try {
            WebElement location = wait.until(ExpectedConditions.visibilityOfElementLocated(inpatientWard));
            selectedSlab = location.getText();
            commonMethods.clickOnButton(driver, location);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean clickOnLoginButton() {
        try {
            WebElement loginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
            commonMethods.clickOnButton(driver, loginBtn);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean verifyErrorMessage() {
        try {
            WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
            String actualErrorMessage = errorMsg.getText();
            String expectedErrorMessage = "Invalid username/password. Please try again.";
            if (actualErrorMessage.equals(expectedErrorMessage)) {
                System.out.println("Actual and Expected error message is matched.");
                return true;
            } else {
                System.out.println("Actual error message is:: " + actualErrorMessage + " && " + "Expected error message is:: " + expectedErrorMessage);
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean validateLocationErrorMsg(){
        try {
            WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(locationErrorMessage));
            String actualErrorMessage = errorMsg.getText();
            String expectedErrorMessage = "You must choose a location!";
            if (actualErrorMessage.equals(expectedErrorMessage)) {
                System.out.println("Actual and Expected error message is matched.");
                return true;
            } else {
                System.out.println("Actual error message is:: " + actualErrorMessage + " && " + "Expected error message is:: " + expectedErrorMessage);
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean validateDashboardMsg(){
        try {
            WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardMessage));
            String actualDashboardMessage = msg.getText();
            String expectedDashboardMessage = "Logged in as Super User (admin) at "+selectedSlab+".";
            if (actualDashboardMessage.equals(expectedDashboardMessage)) {
                System.out.println("Actual and Expected error message is matched.");
                return true;
            } else {
                System.out.println("Actual error message is:: " + actualDashboardMessage + " && " + "Expected error message is:: " + expectedDashboardMessage);
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
