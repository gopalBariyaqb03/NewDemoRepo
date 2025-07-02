package Tests;

import Config.ReadProperties;
import Pages.HomePage;
import Utils.BasePage;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;


public class HomeTest extends BasePage {

    ReadProperties readProperties = new ReadProperties();
    String adminCredentials[] = readProperties.getDirectorCredentials();
    String username = adminCredentials[0];
    String password = adminCredentials[1];

    public void loginWithSuperAdminInPMND(){
        long startTime = common.startTime();
        String urlOpen = readProperties.getWebUrl();
        common.logPrint("Open the browser and enter the URL : "+ urlOpen);
        driver.get(urlOpen);

        common.logPrint("Step:: Enter username and password");
        common.waitUntilElementsToBeVisible(By.xpath("//input[@id='email']"));
        common.type("//input[@id='email']","superadmin@gmail.com");
        common.waitUntilElementsToBeVisible(By.xpath("//input[@type='password']"));
        common.type("//input[@type='password']","admin@123");

        common.waitUntilElementsToBeVisible(By.xpath("//button[.='Login']"));
        common.click("//button[.='Login']");
    }

    @Test
    public void testDemo(){
        //loginWithDirectorCredential();
        String email = "Nedmr@yopmail.com";
        loginWithRSMCredential();
        String mrPass = homePage.getPasswordFromYopmailAndLoginToNewUser(email);
        homePage.loginWithNewPass(email, mrPass, "test");
        //loginWithASMCredential();
        //loginWithMRCredential();
    }

    @Test
    public void verifyLoginPageFieldsAndLabels(){
        String urlToOpen = readProperties.getWebUrl();
        common.logPrint("Open the browser and enter URL : " + urlToOpen);
        driver.get(urlToOpen);
        homePage.verifyLoginPageFieldsAndLabels();
    }

    @Test
    public void verifyDashboardPage(){
        loginWithDirectorCredential();
        homePage.verifyDashboardPage();
    }

    @Test
    public void verifyAdminPanelWithMR(){
        loginWithMRCredential();
        homePage.verifyDoctorCreationFieldAndLabels();
    }

    @Test
    public void verifyCreateDoctorCreateFunctionality(){
        loginWithDirectorCredential();
        homePage.verifyCreateDoctorCreateFunctionality();
    }

    @Test
    public void verifyCreateDoctorFunctionality(){
        loginWithDirectorCredential();
    }

    public void loginWithSuperAdminInHolyMade(){
        long startTime = common.startTime();
        String urlOpen = readProperties.getWebUrl();
        common.logPrint("Open the browser and enter the URL : "+ urlOpen);
        driver.get(urlOpen);

        common.logPrint("Step:: Enter username and password");
        common.waitUntilElementsToBeVisible(By.xpath("//input[@id='email']"));
        common.type("//input[@id='email']","superadmin@gmail.com");
        common.waitUntilElementsToBeVisible(By.xpath("//input[@type='password']"));
        common.type("//input[@type='password']","admin@123");

        common.waitUntilElementsToBeVisible(By.xpath("//button[.='Login']"));
        common.click("//button[.='Login']");
    }

    public void loginWithNewlyCreateUsers(){

        String username = "ChongASM@yopmail.com";
        String password = "Admin@123";

        long startTime = common.startTime();
        String urlOpen = readProperties.getWebUrl();
        common.logPrint("Open the browser and enter the URL : "+ urlOpen);
        driver.get(urlOpen);

        common.logPrint("Step:: Enter username and password");
        common.waitUntilElementsToBeVisible(By.xpath("//input[@id='email']"));
        common.type("//input[@id='email']",username);
        common.waitUntilElementsToBeVisible(By.xpath("//input[@type='password']"));
        common.type("//input[@type='password']",password);

        common.waitUntilElementsToBeVisible(By.xpath("//button[.='Login']"));
        common.click("//button[.='Login']");
    }
}