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

public class HolidaysPage extends Locators {
    Common common = new Common(driver);

    public HolidaysPage(WebDriver driver) {
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

    public void loginWithDirectorsUser(){
        common.logPrint("Step:: Enter username and password");

        if (common.isElementDisplayed(USERNAMEFIELD)) {
            common.waitUntilElementsToBeVisible(By.xpath(USERNAMEFIELD));
            common.type(USERNAMEFIELD,username);

            common.waitUntilElementsToBeVisible(By.xpath(PASSWORDFIELD));
            common.type(PASSWORDFIELD,password);

            common.waitUntilElementsToBeVisible(By.xpath(LOGINBTN));
            common.click(LOGINBTN);
        } else {
            common.logPrint("Login and password field is not displayed");
        }
    }

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

    public void check(String holidayName){

        common.logPrint("Step:: Click on the Holiday's menu");
        common.waitUntilElementToBeVisible(By.xpath(HOLIDAYSMENU));
        common.click(HOLIDAYSMENU);

        common.logPrint("Step:: Search vendor name in the search field");
        common.waitUntilElementToBeVisible(By.xpath(SEARCHFIELDTAB));
        common.type(SEARCHFIELDTAB, holidayName);
        common.pause(2);

        common.logPrint("Step:: Check checkbox first");
        common.waitUntilElementToBeVisible(By.xpath(FIRSTCHECKBOX));
        common.jsClick(FIRSTCHECKBOX);

        common.logPrint("Step:: Click on the edit button");
        common.waitUntilElementToBeVisible(By.xpath(EDITBTN));
        common.click(EDITBTN);

        common.logPrint("Step:: Enter holiday name");
        common.waitUntilElementToBeVisible(HOLIDAYNAMEFIEDL);
        common.type(HOLIDAYNAMEFIEDL,"TestUpdate");

    }

    public void createHolidayUsingAdminCredencials(String HolidayName) throws ParseException {

        common.logPrint("Step:: Search holiday menu");
        common.waitUntilElementToBeVisible(By.xpath(SEARCHFIELDINDASH));
        common.type(SEARCHFIELDINDASH,"holidays");

        common.logPrint("Step:: Click on the Holiday's menu");
        common.waitUntilElementToBeVisible(By.xpath(HOLIDAYSMENU));
        common.click(HOLIDAYSMENU);

        common.logPrint("Step:: Click on the add button");
        common.waitUntilElementToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step:: Enter joining date");
        common.waitUntilElementToBeVisible(By.xpath(DATEINP));
        common.generateRandomNumberString(2);

        String formattedDate= common.generateDate("future", "current", "12/12/2025");

        common.type(DATEINP, formattedDate);
        common.logPrint("Added date is: "+formattedDate);

        common.logPrint("Step:: Click on the holiday checkbox");
        common.waitUntilElementToBeVisible(By.xpath(HOLIDAYCHECKBOX));
        common.click(HOLIDAYCHECKBOX);

        common.logPrint("Step:: Enter holiday name");
        common.waitUntilElementToBeVisible(HOLIDAYNAMEFIEDL);
        common.type(HOLIDAYNAMEFIEDL,HolidayName);

        common.logPrint("Step:: Select State");
        common.waitUntilElementToBeVisible(By.xpath(STATEINP));
        common.type(STATEINP, "GUJARAT");
        common.pause(1);
        common.downKeyAndEnter();

        common.logPrint("Step:: Enter reason");
        String holidayreason = common.generateRandomNumberString(15);
        common.waitUntilElementToBeVisible(REASONTEXTAREA);
        common.type(REASONTEXTAREA,"Test"+holidayreason);

        common.logPrint("Step:: Click on save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.logPrint("Step:: Check validation is displayed");
        common.assertElementDisplayed("");

    }

    public void verifyHolidayInTheMrUser(String HolidayName){

        common.logPrint("Step:: Attempting to logout from the current user");
        if (common.isElementDisplayed(LOGOUTBTN)) {
            common.waitUntilElementsToBeVisible(By.xpath(LOGOUTBTN));
            common.click(LOGOUTBTN);
        } else {
            common.logPrint("Step:: Logout button not found, skipping logout step");
        }

        loginWithMRUser();
        common.logPrint("Step:: Verify Holiday's is showing in the MR user");

        common.logPrint("Step:: Click on the Holiday's menu");
        common.waitUntilElementToBeVisible(By.xpath(HOLIDAYSMENU));
        common.click(HOLIDAYSMENU);

        common.logPrint("Step:: Search vendor name in the search field");
        common.waitUntilElementToBeVisible(By.xpath(SEARCHFIELDTAB));
        common.type(SEARCHFIELDTAB, HolidayName);
        common.pause(2);

        common.logPrint("Verify holiday's is created successfully and showing in the table");
        common.waitUntilElementToBeVisible(CREATEDVALUE);
        String getValue = common.getText(CREATEDVALUE);
        common.assertTwoValuesAreEqual(getValue, HolidayName);

        common.logPrint("Newly created holiday is showing in the MR User");
    }

    public void verifyHolidayInTheASMUser(String HolidayName){

        common.logPrint("Step:: Attempting to logout from the current user");
        if (common.isElementDisplayed(LOGOUTBTN)) {
            common.waitUntilElementsToBeVisible(By.xpath(LOGOUTBTN));
            common.click(LOGOUTBTN);
        } else {
            common.logPrint("Step:: Logout button not found, skipping logout step");
        }

        loginWithASMUser();
        common.logPrint("Step:: Verify Holiday's is showing in the MR user");

        common.logPrint("Step:: Click on the Holiday's menu");
        common.waitUntilElementToBeVisible(By.xpath(HOLIDAYSMENU));
        common.click(HOLIDAYSMENU);

        common.logPrint("Step:: Search vendor name in the search field");
        common.waitUntilElementToBeVisible(By.xpath(SEARCHFIELDTAB));
        common.type(SEARCHFIELDTAB, HolidayName);
        common.pause(2);

        common.logPrint("Verify holiday's is created successfully and showing in the table");
        common.waitUntilElementToBeVisible(CREATEDVALUE);
        String getValue = common.getText(CREATEDVALUE);
        common.assertTwoValuesAreEqual(getValue, HolidayName);

        common.logPrint("Newly created holiday is showing in the ASM User");

    }

    public void verifyHolidayInTheRSMUser(String HolidayName){

        common.logPrint("Step:: Attempting to logout from the current user");
        if (common.isElementDisplayed(LOGOUTBTN)) {
            common.waitUntilElementsToBeVisible(By.xpath(LOGOUTBTN));
            common.click(LOGOUTBTN);
        } else {
            common.logPrint("Step:: Logout button not found, skipping logout step");
        }

        loginWithRSMUser();
        common.logPrint("Step:: Verify Holiday's is showing in the MR user");

        common.logPrint("Step:: Click on the Holiday's menu");
        common.waitUntilElementToBeVisible(By.xpath(HOLIDAYSMENU));
        common.click(HOLIDAYSMENU);

        common.logPrint("Step:: Search vendor name in the search field");
        common.waitUntilElementToBeVisible(By.xpath(SEARCHFIELDTAB));
        common.type(SEARCHFIELDTAB, HolidayName);
        common.pause(2);

        common.logPrint("Verify holiday's is created successfully and showing in the table");
        common.waitUntilElementToBeVisible(CREATEDVALUE);
        String getValue = common.getText(CREATEDVALUE);
        common.assertTwoValuesAreEqual(getValue, HolidayName);

        common.logPrint("Newly created holiday is showing in the RSM User");

    }

    public void verifyUpdatedHolidayName(String holidayName, String updatedHolidayName){

        common.logPrint("Step:: Attempting to logout from the current user");
        if (common.isElementDisplayed(LOGOUTBTN)) {
            common.waitUntilElementsToBeVisible(By.xpath(LOGOUTBTN));
            common.click(LOGOUTBTN);
        } else {
            common.logPrint("Step:: Logout button not found, skipping logout step");
        }

        loginWithDirectorsUser();
        common.logPrint("Step:: Search holiday menu");
        common.waitUntilElementToBeVisible(By.xpath(SEARCHFIELDINDASH));
        common.type(SEARCHFIELDINDASH,"holidays");

        common.logPrint("Step:: Click on the Holiday's menu");
        common.waitUntilElementToBeVisible(By.xpath(HOLIDAYSMENU));
        common.click(HOLIDAYSMENU);

        common.logPrint("Step:: Search vendor name in the search field");
        common.waitUntilElementToBeVisible(By.xpath(SEARCHFIELDTAB));
        common.type(SEARCHFIELDTAB, holidayName);
        common.pause(2);

        common.logPrint("Step:: Check checkbox first");
        common.waitUntilElementToBeVisible(By.xpath(CHECKBOX));
        common.jsClick(CHECKBOX);

        common.logPrint("Step:: Click on the edit button");
        common.waitUntilElementToBeVisible(By.xpath(EDITBTN));
        common.click(EDITBTN);

        common.logPrint("Step:: Enter holiday name");
        common.waitUntilElementToBeVisible(HOLIDAYNAMEFIEDL);
        common.type(HOLIDAYNAMEFIEDL,updatedHolidayName);

        common.logPrint("Step:: Click on save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.logPrint("Step:: Check validation is displayed");
        common.assertElementDisplayed("//*[contains(text(),'Update Successfully')]");

        verifyHolidayInTheMrUser(updatedHolidayName);
        verifyHolidayInTheASMUser(updatedHolidayName);
        verifyHolidayInTheRSMUser(updatedHolidayName);

        common.logPrint("Verified and updated holiday's are update in all the user");
    }

}