package com.openmrs.commonpo;

import com.openmrs.commonutilitiesmethods.CommonUtilitiesMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HomePagePO {

    public WebDriver driver;
    public WebDriverWait wait;
    public String afterSelectLocation;
    public String beforeSelectLocation;

    public HomePagePO(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public By homePageSlabs = By.cssSelector("#apps a");
    public By admin = By.cssSelector("li[class='nav-item identifier'] i:nth-child(1)");
    public By myAccount = By.cssSelector("#user-account-menu a");
    public By changePassword = By.cssSelector("i.icon-lock");
    public By pageHeaderTitle = By.cssSelector("#content h2");
    public By myLanguages = By.cssSelector("i.icon-cog");
    public By cancelBtn = By.cssSelector("#cancel-button");
    public By clickOnLocationMenu = By.cssSelector("[location-uuid='b1a8b05e-3542-4037-bbd3-998ee9c40574']");
    public By selectLocation = By.cssSelector("[locationname='Outpatient Clinic']");
    public By clickOnLogo = By.cssSelector("div.logo");
    public By logoutBtn = By.cssSelector("li.nav-item:nth-child(3) a");

    public boolean clickOnHomePageSlabs() {
        try {
            List<WebElement> homeSlabs = driver.findElements(homePageSlabs);
            for (int i = 0; i < homeSlabs.size(); i++) {
                String clickOnAllSlab = Keys.chord(Keys.CONTROL, Keys.ENTER);
                homeSlabs.get(i).sendKeys(clickOnAllSlab);
            }
            String parentWindow = driver.getWindowHandle();
            Set<String> handles = driver.getWindowHandles();
            Iterator<String> itr = handles.iterator();
            while (itr.hasNext()) {
                String childWindow = itr.next();
                if (!parentWindow.equals(childWindow)) {
                    driver.switchTo().window(childWindow);
                    System.out.println("Title of the new window: " + driver.getTitle());
                }
            }
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean moveToAdmin(){
        try{
            WebElement adminBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(admin));
            Actions actions = new Actions(driver);
            actions.moveToElement(adminBtn).build().perform();
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public boolean clickOnMyAccount(){
        try{
            WebElement myAccountBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(myAccount));
            myAccountBtn.click();
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public boolean clickOnChangePasswordSlab(){
        try{
            WebElement changePasswordSlab = wait.until(ExpectedConditions.visibilityOfElementLocated(changePassword));
            changePasswordSlab.click();
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public boolean clickOnMyLanguages(){
        try{
            WebElement myLanguagesSlab = wait.until(ExpectedConditions.visibilityOfElementLocated(myLanguages));
            myLanguagesSlab.click();
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public boolean clickOnCancel(){
        try{
            WebElement cancelButton = wait.until(ExpectedConditions.visibilityOfElementLocated(cancelBtn));
            cancelButton.click();
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public boolean verifyPageHeaderTitleForChangePassword(){
        try{
            WebElement pageHeaderTitleChangePassword = wait.until(ExpectedConditions.visibilityOfElementLocated(pageHeaderTitle));
            String actualHeaderTitle = "Change Password";
            String expectedHeaderTitle = pageHeaderTitleChangePassword.getText();
            if(actualHeaderTitle.equals(expectedHeaderTitle)){
                System.out.println("Actual and Expected title is matched.");
            }else{
                System.out.println("Actual Title is:: " + actualHeaderTitle + " && " + "Expected Title is:: " + expectedHeaderTitle);
            }
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public boolean verifyPageHeaderTitleForMyLanguages(){
        try{
            WebElement pageHeaderTitleMyLanguages = wait.until(ExpectedConditions.visibilityOfElementLocated(pageHeaderTitle));
            String actualHeaderTitle = "My Languages";
            String expectedHeaderTitle = pageHeaderTitleMyLanguages.getText();
            if(actualHeaderTitle.equals(expectedHeaderTitle)){
                System.out.println("Actual and Expected title is matched.");
            }else{
                System.out.println("Actual Title is:: " + actualHeaderTitle + " && " + "Expected Title is:: " + expectedHeaderTitle);
            }
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public boolean clickOnSelectLocation(){
        try{
            WebElement clickOnLocationMenuBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(clickOnLocationMenu));
            beforeSelectLocation = clickOnLocationMenuBtn.getText();
            clickOnLocationMenuBtn.click();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean moveToLocationOptions(){
        try{
            WebElement locationsOption = wait.until(ExpectedConditions.visibilityOfElementLocated(selectLocation));
            Actions actions = new Actions(driver);
            actions.moveToElement(locationsOption).build().perform();
            afterSelectLocation = locationsOption.getText();
            actions.click();
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public boolean verifySelectedLocation(){
        try{
            if (!afterSelectLocation.equals(beforeSelectLocation)) {
                System.out.println("Before Select Location is:: " + beforeSelectLocation + " && " + "After Select Location is:: " + afterSelectLocation);
                return true;
            } else {
                System.out.println("beforeSelectLocation and afterSelectLocation  is same. So, user selection is not working.");
                return false;
            }
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public boolean clickOnLogo(){
        try{
            WebElement clickOnLogoBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(clickOnLogo));
            clickOnLogoBtn.click();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean clickOnLogout(){
        try{
            WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(logoutBtn));
            logoutButton.click();
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
