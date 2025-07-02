package Pages;

import Config.ReadProperties;
import Utils.Common;
import Utils.Locators;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class VendorPage extends Locators {
    Common common = new Common(driver);

    public VendorPage(WebDriver driver) {
        super(driver);
    }

    ReadProperties readProperties = new ReadProperties();
    String rsmCredentials[] = readProperties.getRSMCredentials();
    String Rsmusername = rsmCredentials[0];
    String RSMpassword = rsmCredentials[1];

    String ASMCredentials[] = readProperties.getASMCredential();
    String Asmusername = ASMCredentials[0];
    String Asmpassword = ASMCredentials[1];

    String MRCredentials[] = readProperties.getMRCredential();
    String MRusername = MRCredentials[0];
    String MRpassword = MRCredentials[1];

    String adminCredentials[] = readProperties.getDirectorCredentials();
    String username = adminCredentials[0];
    String password = adminCredentials[1];

    public void loginWithMRUser(){
        common.logPrint("Step:: Enter username and password");

        if (common.isElementDisplayed(USERNAMEFIELD)) {
            common.waitUntilElementsToBeVisible(By.xpath(USERNAMEFIELD));
            common.type(USERNAMEFIELD,MRusername);

            common.waitUntilElementsToBeVisible(By.xpath(PASSWORDFIELD));
            common.type(PASSWORDFIELD,MRpassword);

            common.waitUntilElementsToBeVisible(By.xpath(LOGINBTN));
            common.click(LOGINBTN);
        } else {
            common.logPrint("Login and password field is not displayed");
        }
    }

    public void loginWithASMUser(){
        common.logPrint("Step:: Enter username and password");

        if (common.isElementDisplayed(USERNAMEFIELD)) {
            common.waitUntilElementsToBeVisible(By.xpath(USERNAMEFIELD));
            common.type(USERNAMEFIELD,Asmusername);

            common.waitUntilElementsToBeVisible(By.xpath(PASSWORDFIELD));
            common.type(PASSWORDFIELD,Asmpassword);

            common.waitUntilElementsToBeVisible(By.xpath(LOGINBTN));
            common.click(LOGINBTN);
        } else {
            common.logPrint("Login and password field is not displayed");
        }
    }

    public void loginWithRSMUser(){
        common.logPrint("Step:: Enter username and password");

        if (common.isElementDisplayed(USERNAMEFIELD)) {
            common.waitUntilElementsToBeVisible(By.xpath(USERNAMEFIELD));
            common.type(USERNAMEFIELD,Rsmusername);

            common.waitUntilElementsToBeVisible(By.xpath(PASSWORDFIELD));
            common.type(PASSWORDFIELD,RSMpassword);

            common.waitUntilElementsToBeVisible(By.xpath(LOGINBTN));
            common.click(LOGINBTN);
        } else {
            common.logPrint("Login and password field is not displayed");
        }
    }

    public void createVendorUsingAdminCredencials(String name){

        common.logPrint("Step:: Search vendor menu");
        common.waitUntilElementToBeVisible(By.xpath(SEARCHFIELDINDASH));
        common.type(SEARCHFIELDINDASH,"Vendor");

        common.logPrint("Step:: Click on the vendor menu");
        common.waitUntilElementToBeVisible(By.xpath(VENDORMENU));
        common.click(VENDORMENU);

        common.logPrint("Step:: Click on the add button");
        common.waitUntilElementToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step:: Select vendor service type");
        common.waitUntilElementToBeVisible(By.xpath(VENDORSERTYPE));
        common.type(VENDORSERTYPE, "test");
        common.pause(1);
        common.downKeyAndEnter();

        common.waitUntilElementToBeVisible(By.xpath(VENDORNAMEFIELD));
        common.type(VENDORNAMEFIELD, name);
        common.logPrint("Added name is: "+name);

        common.logPrint("Step:: Enter phone number");
        common.waitUntilElementToBeVisible(By.xpath(PHONENUMBER));
        String mobilenum = common.generateRandomNumberString(10);
        common.type(PHONENUMBER,mobilenum);

        common.logPrint("Step:: Enter Contact phone number");
        common.waitUntilElementToBeVisible(By.xpath(CONTACTPHONENUM));
        String ConMobilenum = common.generateRandomNumberString(10);
        common.type(CONTACTPHONENUM,ConMobilenum);

        common.logPrint("Step:: Enter ratings");
        common.waitUntilElementToBeVisible(RATINGFIELD);
        common.type(RATINGFIELD,"5");

        common.logPrint("Step:: Enter reason");
        String remarkText = common.generateRandomChars(15);
        common.waitUntilElementToBeVisible(REMARKFIELD);
        common.type(REMARKFIELD,remarkText);

        common.logPrint("Step:: Enter Address line 1");
        common.waitUntilElementToBeVisible(By.xpath(ADDRESSLINE1MAN));
        common.type(ADDRESSLINE1MAN, "Test address");

        common.logPrint("Step:: Enter Address line 1");
        common.waitUntilElementToBeVisible(By.xpath(AREALMAN));
        common.type(AREALMAN, "Test aerea");

        common.logPrint("Step:: Select communication city");
        common.waitUntilElementToBeVisible(By.xpath(COMMNUNICATIONCITY));
        common.type(COMMNUNICATIONCITY, "AHMEDABAD");
        common.pause(2);
        common.downKeyAndEnter();

        common.logPrint("Step:: Select Pincode city");
        common.waitUntilElementToBeVisible(By.xpath(COMMNUCATIONPINCODE));
        common.type(COMMNUCATIONPINCODE, "380058");
        common.pause(2);
        common.downKeyAndEnter();

        common.logPrint("Step:: Click on save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.logPrint("Step:: Check validation is displayed");
        common.assertElementDisplayed("//*[contains(text(),'Added Successfull')]");

        common.logPrint("Verify vendor is created successfully and shwowing in the table");
        common.waitUntilElementToBeVisible(CREATEDVALUE);
        String getValue = common.getText(CREATEDVALUE);
        common.assertTwoValuesAreEqual(getValue, name);

        common.logPrint("Vendor are created successfully and showing in the table");
    }

    public void VerifyVendorFromMRUser(String name){

        common.logPrint("Step:: Attempting to logout from the current user");
        if (common.isElementDisplayed(LOGOUTBTN)) {
            common.waitUntilElementsToBeVisible(By.xpath(LOGOUTBTN));
            common.click(LOGOUTBTN);
        } else {
            common.logPrint("Step:: Logout button not found, skipping logout step");
        }

        loginWithMRUser();
        common.logPrint("Step:: Verify vendor is showing in the MR user");

        common.logPrint("Step:: Search vendor menu");
        common.waitUntilElementToBeVisible(By.xpath(SEARCHFIELDINDASH));
        common.type(SEARCHFIELDINDASH,"Vendor");

        common.logPrint("Step:: Click on the vendor menu");
        common.waitUntilElementToBeVisible(By.xpath(VENDORMENU));
        common.click(VENDORMENU);

        common.logPrint("Step:: Search vendor name in the search field");
        common.waitUntilElementToBeVisible(By.xpath(SEARCHFIELDTAB));
        common.type(SEARCHFIELDTAB, name);

        common.logPrint("Verify vendor is created successfully and shwowing in the table");
        common.waitUntilElementToBeVisible(CREATEDVALUE);
        String getValue = common.getText(CREATEDVALUE);
        common.assertTwoValuesAreEqual(getValue, name);

    }

    public void VerifyVendorFromASMUser(String name){

        common.logPrint("Step:: Attempting to logout from the current user");
        if (common.isElementDisplayed(LOGOUTBTN)) {
            common.waitUntilElementsToBeVisible(By.xpath(LOGOUTBTN));
            common.click(LOGOUTBTN);
        } else {
            common.logPrint("Step:: Logout button not found, skipping logout step");
        }

        loginWithASMUser();
        common.logPrint("Step:: Verify vendor is showing in the MR user");

        common.logPrint("Step:: Search vendor menu");
        common.waitUntilElementToBeVisible(By.xpath(SEARCHFIELDINDASH));
        common.type(SEARCHFIELDINDASH,"Vendor");

        common.logPrint("Step:: Click on the vendor menu");
        common.waitUntilElementToBeVisible(By.xpath(VENDORMENU));
        common.click(VENDORMENU);

        common.logPrint("Step:: Search vendor name in the search field");
        common.waitUntilElementToBeVisible(By.xpath(SEARCHFIELDTAB));
        common.type(SEARCHFIELDTAB, name);

        common.logPrint("Verify vendor is created successfully and shwowing in the table");
        common.waitUntilElementToBeVisible(CREATEDVALUE);
        String getValue = common.getText(CREATEDVALUE);
        common.assertTwoValuesAreEqual(getValue, name);

    }

    public void VerifyVendorFromRSMUser(String name){

        common.logPrint("Step:: Attempting to logout from the current user");
        if (common.isElementDisplayed(LOGOUTBTN)) {
            common.waitUntilElementsToBeVisible(By.xpath(LOGOUTBTN));
            common.click(LOGOUTBTN);
        } else {
            common.logPrint("Step:: Logout button not found, skipping logout step");
        }

        loginWithRSMUser();
        common.logPrint("Step:: Verify vendor is showing in the MR user");

        common.logPrint("Step:: Search vendor menu");
        common.waitUntilElementToBeVisible(By.xpath(SEARCHFIELDINDASH));
        common.type(SEARCHFIELDINDASH,"Vendor");

        common.logPrint("Step:: Click on the vendor menu");
        common.waitUntilElementToBeVisible(By.xpath(VENDORMENU));
        common.click(VENDORMENU);

        common.logPrint("Step:: Search vendor name in the search field");
        common.waitUntilElementToBeVisible(By.xpath(SEARCHFIELDTAB));
        common.type(SEARCHFIELDTAB, name);

        common.logPrint("Verify vendor is created successfully and shwowing in the table");
        common.waitUntilElementToBeVisible(CREATEDVALUE);
        String getValue = common.getText(CREATEDVALUE);
        common.assertTwoValuesAreEqual(getValue, name);
    }


}