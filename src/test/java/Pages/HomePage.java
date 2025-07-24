package Pages;

import Config.ReadProperties;
import Utils.Common;
import Utils.Locators;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
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
import java.util.concurrent.TimeUnit;

public class HomePage extends Locators {
    Common common = new Common(driver);

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void loginWithDirectorsUsers(){
        common.logPrint("Step:: Enter username and password");

        if (common.isElementDisplayed(USERNAMEFIELD)) {
            common.waitUntilElementsToBeVisible(By.xpath(USERNAMEFIELD));
            common.type(USERNAMEFIELD,"superadmin@gmail.com");

            common.waitUntilElementsToBeVisible(By.xpath(PASSWORDFIELD));
            common.type(PASSWORDFIELD,"admin@123");

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
            common.type(USERNAMEFIELD,"Ajitmr@yopmail.com");

            common.waitUntilElementsToBeVisible(By.xpath(PASSWORDFIELD));
            common.type(PASSWORDFIELD,"Admin@123");

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
            common.type(USERNAMEFIELD,"Ajitasm@yopmail.com");

            common.waitUntilElementsToBeVisible(By.xpath(PASSWORDFIELD));
            common.type(PASSWORDFIELD,"Admin@123");

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
            common.type(USERNAMEFIELD,"Ajitrsm@yopmail.com");

            common.waitUntilElementsToBeVisible(By.xpath(PASSWORDFIELD));
            common.type(PASSWORDFIELD,"Admin@123");

            common.waitUntilElementsToBeVisible(By.xpath(LOGINBTN));
            common.click(LOGINBTN);
        } else {
            common.logPrint("Login and password field is not displayed");
        }
    }

    public void verifyLoginPageFieldsAndLabels(){

        common.logPrint("Step:: Verify logo is displayed on login page");
        common.waitUntilElementsToBeVisible(By.xpath(LOGINPAGELOGO));
        common.isElementPresent(LOGINPAGELOGO);
        common.logPrint("Logo is displayed on the login page.");

        common.logPrint("Step:: Verify UserName label is displayed");
        common.waitUntilElementToBeVisible(By.xpath(USERNAMELABEL));
        String userNameLbl = common.getText(USERNAMELABEL);
        common.assertTwoValuesAreEqual(userNameLbl,"Username");
        common.logPrint("Username label is displayed: "+ userNameLbl);

        common.logPrint("Step:: Verify Password label is displayed");
        common.waitUntilElementToBeVisible(By.xpath(USERNAMELABEL));
        common.click(PASSWORDFIELD);
        String passNameLbl = common.getText(PASSWORDLABEL);
        common.assertTwoValuesAreEqual(passNameLbl,"Password");
        common.logPrint("Password label is displayed: "+ passNameLbl);

        common.logPrint("Step:: Verify Eye icon is displayed on password field");
        common.waitUntilElementsToBeVisible(By.xpath(EYEICON));
        common.isElementPresent(EYEICON);
        common.logPrint("Eye icon is displayed on the password field.");

        common.logPrint("Step:: Verify Forgot Password link is displayed on login page.");
        common.waitUntilElementToBeVisible(By.xpath(FORGOTPASSLINK));
        String forgotPassLink = common.getText(FORGOTPASSLINK);
        common.assertTwoValuesAreEqual(forgotPassLink,"Forgot Password?");
        common.logPrint("Forgot Password link is displayed: "+ forgotPassLink);

        common.logPrint("Step:: Verify LOGIN button is present on the login page.");
        common.waitUntilElementsToBeVisible(By.xpath(LOGINBTN));
        common.isElementPresent(LOGINBTN);
        common.logPrint("Login button is displayed on the login page.");

    }

    public void verifyDashboardPage(){
        common.logPrint("Step:: Verify the login page buttons and Labels");

        common.logPrint("Step:: Verify logo is displayed on the dashboard page");
        common.waitUntilElementToBeVisible(By.xpath(LOGINPAGELOGO));
        common.isElementVisible(driver, By.xpath(LOGINPAGELOGO));
        common.logPrint("Logo is displayed on the dashboard page");

        common.logPrint("Step:: Verify search field is displayed");
        common.waitUntilElementToBeVisible(By.xpath(SEARCH_FIELD));
        common.isElementVisible(driver, By.xpath(SEARCH_FIELD));
        common.logPrint("Search field is displayed on the dashboard page");

        common.logPrint("Step:: Verify Dashboard menu is displayed on the dashboard");
        common.waitUntilElementToBeVisible(By.xpath(DASHBOARDMENU));
        common.isElementVisible(driver, By.xpath(DASHBOARDMENU));
        common.logPrint("Dashboard menu is displayed on the dashboard page");

        common.logPrint("Step::");
        common.waitUntilElementToBeVisible(By.xpath(SEARCH_FIELD));
        common.isElementVisible(driver, By.xpath(SEARCH_FIELD));
        common.logPrint("Search field is displayed on the dashboard page");

        common.logPrint("Step::");
        common.waitUntilElementToBeVisible(By.xpath(SEARCH_FIELD));
        common.isElementVisible(driver, By.xpath(SEARCH_FIELD));
        common.logPrint("Search field is displayed on the dashboard page");

        common.logPrint("Step::");
        common.waitUntilElementToBeVisible(By.xpath(SEARCH_FIELD));
        common.isElementVisible(driver, By.xpath(SEARCH_FIELD));
        common.logPrint("Search field is displayed on the dashboard page");

        common.logPrint("Step::");
        common.waitUntilElementToBeVisible(By.xpath(SEARCH_FIELD));
        common.isElementVisible(driver, By.xpath(SEARCH_FIELD));
        common.logPrint("Search field is displayed on the dashboard page");

        common.logPrint("Step::");
        common.waitUntilElementToBeVisible(By.xpath(SEARCH_FIELD));
        common.isElementVisible(driver, By.xpath(SEARCH_FIELD));
        common.logPrint("Search field is displayed on the dashboard page");

        common.logPrint("Step::");
        common.waitUntilElementToBeVisible(By.xpath(SEARCH_FIELD));
        common.isElementVisible(driver, By.xpath(SEARCH_FIELD));
        common.logPrint("Search field is displayed on the dashboard page");

        common.logPrint("Step::");common.waitUntilElementToBeVisible(By.xpath(SEARCH_FIELD));
        common.isElementVisible(driver, By.xpath(SEARCH_FIELD));
        common.logPrint("Search field is displayed on the dashboard page");

        common.logPrint("Step::");common.waitUntilElementToBeVisible(By.xpath(SEARCH_FIELD));
        common.isElementVisible(driver, By.xpath(SEARCH_FIELD));
        common.logPrint("Search field is displayed on the dashboard page");
    }

    public void verifyAllTheButtonAndLabelIsPresentOnHeader(){

        common.logPrint("Step:: Verify back button is present");
        common.waitUntilElementToBeVisible(By.xpath(BACKBTN));
        common.logPrint("Back button is present in the page");

        common.logPrint("Step:: Verify Add button is present");
        common.waitUntilElementToBeVisible(By.xpath(ADDBTN));
        common.logPrint("ADD button is present in the page");

        common.logPrint("Step:: Check Delete button is present and disabled");
        common.waitUntilElementToBeVisible(By.xpath(DELETEBTN));
        common.isElementDisabled(DELETEBTN);
        common.logPrint("Step:: Delete button is present and disabled");

        common.logPrint("Step:: Check Edit button is present and disabled");
        common.waitUntilElementToBeVisible(By.xpath(EDITBTN));
        common.isElementDisabled(EDITBTN);
        common.logPrint("Step:: Edit button is present and disabled");

        common.logPrint("Step:: Check View button is present and disabled");
        common.waitUntilElementToBeVisible(By.xpath(VIEWBTN));
        common.isElementDisabled(VIEWBTN);
        common.logPrint("Step:: View button is present and disabled");

        common.logPrint("Step:: Check Print button is present and disabled");
        common.waitUntilElementToBeVisible(By.xpath(PRINTBTN));
        common.isElementDisabled(PRINTBTN);
        common.logPrint("Step:: Print button is present and disabled");

        common.logPrint("Step:: Verify Export PDF button is present");
        common.waitUntilElementToBeVisible(By.xpath(EXPORTPDFBTN));
        common.logPrint("Export PDF button is present in the page");

        common.logPrint("Step:: Verify Export Excel button is present");
        common.waitUntilElementToBeVisible(By.xpath(EXPORTEXCELBTN));
        common.logPrint("Export Excel button is present in the page");

//        common.logPrint("Step:: Verify Bulk Approve button is present");
//        common.waitUntilElementToBeVisible(By.xpath(BULKAPPROVEBTN));
//        common.logPrint("Bulk Approve button is present in the page");

    }

    public void verifyDoctorCreationFieldAndLabels(){

        common.logPrint("Step:: Click on the admin panel menu");
        common.waitUntilElementToBeVisible(By.xpath(ADMINPANELMENU));
        common.click(ADMINPANELMENU);

        common.logPrint("Step:: Verify all the sub-menu is showing");

        common.logPrint("Step:: Verify chemist menu is present");
        common.waitUntilElementToBeVisible(By.xpath(CHEMISTMENU));
        common.logPrint("Chemist menu is present on the admin panel");

        common.logPrint("Step:: Verify Stockist menu is present");
        common.waitUntilElementToBeVisible(By.xpath(STOCKISTMENU));
        common.logPrint("Stockist menu is present on the admin panel");

        common.logPrint("Step:: Verify Hospital menu is present");
        common.waitUntilElementToBeVisible(By.xpath(HOSPITALMENU));
        common.logPrint("Hospital menu is present on the admin panel");

        common.logPrint("Step:: Verify Product menu is present");
        common.waitUntilElementToBeVisible(By.xpath(PRODUCTMENU));
        common.logPrint("Product menu is present on the admin panel");

        common.logPrint("Step:: Verify Employee menu is present");
        common.waitUntilElementToBeVisible(By.xpath(EMPLOYEEMENU));
        common.logPrint("Employee menu is present on the admin panel");

        common.logPrint("Step:: Click on the Doctor menu");
        common.waitUntilElementToBeVisible(By.xpath(DOCTORMENU));
        common.click(DOCTORMENU);

        common.logPrint("Verify all the header buttons are present");
        verifyAllTheButtonAndLabelIsPresentOnHeader();

        common.logPrint("Step:: Verify Financial year dropdown label is present");
        common.waitUntilElementToBeVisible(By.xpath(FINANCIALYEARLBL));
        common.logPrint("Financial year dropdown label is present on the admin panel");

        common.logPrint("Step:: Verify Financial year dropdown is present");
        common.waitUntilElementToBeVisible(By.xpath(YEARDROPDOWN));
        common.logPrint("Financial year dropdown is present on the admin panel");

        common.logPrint("Step:: Verify sales graph is present in the screen");
        common.waitUntilElementToBeVisible(By.xpath(SALESGRAPHINADDDCR));
        common.logPrint("Sales graph is present on the page");

        common.logPrint("Step:: Verify HQ label is present");
        common.waitUntilElementToBeVisible(By.xpath(HQLABEL));
        common.logPrint("HQ label is present on the page");

        common.logPrint("Step:: Verify HQ dropdown is present");
        common.waitUntilElementToBeVisible(By.xpath(HQDROPDOWN));
        common.logPrint("HQ dropdown present on the page");

        common.logPrint("Step:: Verify search field is present");
        common.waitUntilElementToBeVisible(By.xpath(SEARCHFIELD));
        common.logPrint("Search field is present on the page");

        common.logPrint("Step:: Verify Fields on create doctor screen");

        common.logPrint("Step:: Click on the ADD button");
        common.waitUntilElementToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step:: Verify Doctor Name label is present");
        common.waitUntilElementToBeVisible(By.xpath(DOCTORNAMELBL));
        common.logPrint("Doctor Name label is present");

        common.logPrint("Step:: Verify Doctor Name input field is present");
        common.waitUntilElementToBeVisible(By.xpath(DOCTORNAMEINP));
        common.logPrint("Doctor Name input field is present");

        common.logPrint("Step:: Verify Category label is present");
        common.waitUntilElementToBeVisible(By.xpath(CATEGORYLBL));
        common.logPrint("Category label is present");

        common.logPrint("Step:: Verify Category input field is present");
        common.waitUntilElementToBeVisible(By.xpath(CATEGORYINP));
        common.logPrint("Category input field is present");

        common.logPrint("Step:: Verify Speciality label is present");
        common.waitUntilElementToBeVisible(By.xpath(SPECIALITYLBL));
        common.logPrint("Speciality label is present");

        common.logPrint("Step:: Verify Speciality input field is present");
        common.waitUntilElementToBeVisible(By.xpath(SPECIALITYINP));
        common.logPrint("Speciality input field is present");

        common.logPrint("Step:: Verify Qualifications label is present");
        common.waitUntilElementToBeVisible(By.xpath(QUALIFICATIONSLBL));
        common.logPrint("Qualifications label is present");

        common.logPrint("Step:: Verify Qualifications input field is present");
        common.waitUntilElementToBeVisible(By.xpath(QUALIFICATIONSINP));
        common.logPrint("Qualifications input field is present");

        //For MR user we are not showing employee dropdown
        common.logPrint("Step:: Verify Employee label is not present for MR");
        common.assertElementIsNotDisplayed((EMPLOYEELBL));
        common.logPrint("Employee label is not present when create doctor using MR user");
        common.logPrint("Step:: Verify Employee input field is not present");
        common.assertElementIsNotDisplayed((EMPLOYEEINP));
        common.logPrint("Employee input field is not present when create doctor using MR user");

        common.logPrint("Step:: Verify Product label is present");
        common.waitUntilElementToBeVisible(By.xpath(PRODUCTLBL));
        common.logPrint("Product label is present");

        common.logPrint("Step:: Verify Product input field is present");
        common.waitUntilElementToBeVisible(By.xpath(PRODUCTINP));
        common.logPrint("Product input field is present");

        common.logPrint("Step:: Verify Hospital Name label is present");
        common.waitUntilElementToBeVisible(By.xpath(HOSPITALNAMELBL));
        common.logPrint("Hospital Name label is present");

        common.logPrint("Step:: Verify Hospital Name input field is present");
        common.waitUntilElementToBeVisible(By.xpath(HOSPITALNAMEINP));
        common.logPrint("Hospital Name input field is present");

        common.logPrint("Step:: Verify Email label is present");
        common.waitUntilElementToBeVisible(By.xpath(EMAILLBL));
        common.logPrint("Email label is present");

        common.logPrint("Step:: Verify Email input field is present");
        common.waitUntilElementToBeVisible(By.xpath(EMAILINP));
        common.logPrint("Email input field is present");

        common.logPrint("Step:: Verify Mobile No. label is present");
        common.waitUntilElementToBeVisible(By.xpath(MOBILENOLBL));
        common.logPrint("Mobile No. label is present");

        common.logPrint("Step:: Verify Mobile No. input field is present");
        common.waitUntilElementToBeVisible(By.xpath(MOBILENOINP));
        common.logPrint("Mobile No. input field is present");

        common.logPrint("Step:: Verify Phone No label is present");
        common.waitUntilElementToBeVisible(By.xpath(PHONENOLBL));
        common.logPrint("Phone No label is present");

        common.logPrint("Step:: Verify Phone No input field is present");
        common.waitUntilElementToBeVisible(By.xpath(PHONENOINP));
        common.logPrint("Phone No input field is present");

        common.logPrint("Step:: Verify Website label is present");
        common.waitUntilElementToBeVisible(By.xpath(WEBSITELBL));
        common.logPrint("Website label is present");

        common.logPrint("Step:: Verify Website input field is present");
        common.waitUntilElementToBeVisible(By.xpath(WEBSITEINP));
        common.logPrint("Website input field is present");

        common.logPrint("Step:: Verify DOB label is present");
        common.waitUntilElementToBeVisible(By.xpath(DOBLBL));
        common.logPrint("DOB label is present");

        common.logPrint("Step:: Verify DOB input field is present");
        common.waitUntilElementToBeVisible(By.xpath(DOBINP));
        common.logPrint("DOB input field is present");

        common.logPrint("Step:: Verify DOA label is present");
        common.waitUntilElementToBeVisible(By.xpath(DOALBL));
        common.logPrint("DOA label is present");

        common.logPrint("Step:: Verify DOA input field is present");
        common.waitUntilElementToBeVisible(By.xpath(DOAINP));
        common.logPrint("DOA input field is present");

        common.logPrint("Step:: Verify PanCard Number label is present");
        common.waitUntilElementToBeVisible(By.xpath(PANCARDNOLBL));
        common.logPrint("PanCard Number label is present");

        common.logPrint("Step:: Verify PanCard Number input field is present");
        common.waitUntilElementToBeVisible(By.xpath(PANCARDNOINP));
        common.logPrint("PanCard Number input field is present");

        common.logPrint("Step:: Verify Registration Number label is present");
        common.waitUntilElementToBeVisible(By.xpath(REGISTRATIONNOLBL));
        common.logPrint("Registration Number label is present");

        common.logPrint("Step:: Verify Registration Number input field is present");
        common.waitUntilElementToBeVisible(By.xpath(REGISTRATIONNOINP));
        common.logPrint("Registration Number input field is present");

        common.logPrint("Step:: Verify Software Name label is present");
        common.waitUntilElementToBeVisible(By.xpath(SOFTWARENAMELBL));
        common.logPrint("Software Name label is present");

        common.logPrint("Step:: Verify Software Name input field is present");
        common.waitUntilElementToBeVisible(By.xpath(SOFTWARENAMEINP));
        common.logPrint("Software Name input field is present");

        common.logPrint("Step:: Verify Role in Hospital label is present");
        common.waitUntilElementToBeVisible(By.xpath(ROLEINHOSPITALLBL));
        common.logPrint("Role in Hospital label is present");

        common.logPrint("Step:: Verify Role in Hospital input field is present");
        common.waitUntilElementToBeVisible(By.xpath(ROLEINHOSPITALINP));
        common.logPrint("Role in Hospital input field is present");

        common.logPrint("Step:: Verify Patients Daily label is present");
        common.waitUntilElementToBeVisible(By.xpath(PATIENTSDAILYLBL));
        common.logPrint("Patients Daily label is present");

        common.logPrint("Step:: Verify Patients Daily input field is present");
        common.waitUntilElementToBeVisible(By.xpath(PATIENTSDAILYINP));
        common.logPrint("Patients Daily input field is present");

        common.logPrint("Step:: Verify Patients Weekly label is present");
        common.waitUntilElementToBeVisible(By.xpath(PATIENTSWEEKLYLBL));
        common.logPrint("Patients Weekly label is present");

        common.logPrint("Step:: Verify Patients Weekly input field is present");
        common.waitUntilElementToBeVisible(By.xpath(PATIENTSWEEKLYINP));
        common.logPrint("Patients Weekly input field is present");

        common.logPrint("Step:: Verify Patients Monthly label is present");
        common.waitUntilElementToBeVisible(By.xpath(PATIENTSMONTHLYLBL));
        common.logPrint("Patients Monthly label is present");

        common.logPrint("Step:: Verify Patients Monthly input field is present");
        common.waitUntilElementToBeVisible(By.xpath(PATIENTSMONTHLYINP));
        common.logPrint("Patients Monthly input field is present");

        common.logPrint("Step:: Verify Preferred Call Time label is present");
        common.waitUntilElementToBeVisible(By.xpath(PREFERREDCALLTIMELBL));
        common.logPrint("Preferred Call Time label is present");

        common.logPrint("Step:: Verify Preferred Call Time input field is present");
        common.waitUntilElementToBeVisible(By.xpath(PREFERREDCALLTIMEINP));
        common.logPrint("Preferred Call Time input field is present");

        common.pause(2);
        common.scroll_To_Element(ADDRESSLINE1INP1);

        common.logPrint("Step:: Verify Pan card label is showing");
        common.assertElementDisplayed(PANCARDIMGLBL);
        common.logPrint("Pan card label is showing");

        common.logPrint("Step:: Verify Registration image label is showing");
        common.assertElementDisplayed(REGISTRATIONIMGLBL);
        common.logPrint("Registration image label is showing");

        common.logPrint("Step:: Verify Doctor upload image label is showing");
        common.assertElementDisplayed(DOCTORIMGLBL);
        common.logPrint("Doctor upload image is showing");

        common.logPrint("Step:: Verify Visiting card image label is showing");
        common.assertElementDisplayed(VISITINGCARDIMGLBL);
        common.logPrint("Visiting card image label is showing");

        common.logPrint("Step:: Verify Pan card image upload field is showing");
        common.assertElementDisplayed(PANCARDUPLOADIMG);
        common.logPrint("Pan card image upload field is showing");

        common.logPrint("Step:: Verify Registration image upload field is showing");
        common.assertElementDisplayed(REGISTRATIONUPLOADIMG);
        common.logPrint("Registration image upload field is showing");

        common.logPrint("Step:: Verify Doctor upload field is showing");
        common.assertElementDisplayed(DOCTORUPLOADIMG);
        common.logPrint("Doctor upload field is showing");

        common.logPrint("Step:: Verify Visiting card image upload is showing");
        common.assertElementDisplayed(VISITINGCARDUPLOADIMG);
        common.logPrint("Visiting card image upload field is showing");

        common.logPrint("Step:: Verify Address Line 1 label is present");
        common.waitUntilElementToBeVisible(By.xpath(ADDRESSLINE1LBL1));
        common.logPrint("Address Line 1 label is present");

        common.logPrint("Step:: Verify Address Line 1 input field is present");
        common.waitUntilElementToBeVisible(By.xpath(ADDRESSLINE1INP1));
        common.logPrint("Address Line 1 input field is present");

        common.logPrint("Step:: Verify Area label is present");
        common.waitUntilElementToBeVisible(By.xpath(AREALBL));
        common.logPrint("Area label is present");

        common.logPrint("Step:: Verify Area input field is present");
        common.waitUntilElementToBeVisible(By.xpath(AREAINP));
        common.logPrint("Area input field is present");

        common.logPrint("Step:: Verify City label is present");
        common.waitUntilElementToBeVisible(By.xpath(CITYLBL));
        common.logPrint("City label is present");

        common.logPrint("Step:: Verify City input field is present");
        common.waitUntilElementToBeVisible(By.xpath(CITYINP));
        common.logPrint("City input field is present");

        common.logPrint("Step:: Verify Pincode label is present");
        common.waitUntilElementToBeVisible(By.xpath(PINCODELBL));
        common.logPrint("Pincode label is present");

        common.logPrint("Step:: Verify Pincode input field is present");
        common.waitUntilElementToBeVisible(By.xpath(PINCODEINP));
        common.logPrint("Pincode input field is present");
    }

    public void verifyCreateDoctorCreateFunctionality(){

        common.logPrint("Step:: Click on the admin panel menu");
        common.waitUntilElementToBeVisible(By.xpath(ADMINPANELMENU));
        common.click(ADMINPANELMENU);

        common.logPrint("Step:: Verify all the sub-menu is showing");

        common.logPrint("Step:: Verify chemist menu is present");
        common.waitUntilElementToBeVisible(By.xpath(DOCTORMENU));
        common.click(DOCTORMENU);
        common.logPrint("Chemist menu is present on the admin panel");

        common.logPrint("Step:: Verify chemist menu is present");
        common.waitUntilElementToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.scroll_To_Element(DOCTORNAMEINP);

        common.logPrint("Step:: Create doctor create functionality");
        common.waitUntilElementToBeVisible(By.xpath(DOCTORNAMEINP));
        String doctorName = common.generateRandomChars(8);
        common.type(DOCTORNAMEINP, doctorName);

        common.logPrint("Step:: Create doctor create functionality");
        common.waitUntilElementToBeVisible(By.xpath(CATEGORYINP));
        common.type(CATEGORYINP, "A");
        common.pause(2);
        common.click("//*[@value='A']");
    }

    public void verifyCreateDoctorFunctionality(){

        common.logPrint("Step:: ");
    }

    public void createNewUser(String Name, String Email, String user){

        common.logPrint("Create new " + user);

        common.logPrint("Step:: Click on the admin panel menu");
        common.waitUntilElementToBeVisible(By.xpath(ADMINPANELMENU));
        common.click(ADMINPANELMENU);

        common.logPrint("Step:: Click on the employee menu");
        common.waitUntilElementToBeVisible(By.xpath(EMPLOYEEMENU));
        common.click(EMPLOYEEMENU);

        common.logPrint("Step:: Click on the ADD button");
        common.waitUntilElementToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step:: Enter first name");
        common.waitUntilElementToBeVisible(By.xpath(NAMEINP));
        common.type(NAMEINP, Name);
        common.logPrint("Name: "+Name );

        common.logPrint("Step:: Select division");
        common.waitUntilElementToBeVisible(By.xpath(DIVISIONINP));
        common.type(DIVISIONINP, "test division");
        common.downKeyAndEnter();
        common.logPrint("Division is selected: test division");

        common.logPrint("Step:: Enter phone number");
        common.waitUntilElementToBeVisible(By.xpath(PHONENO));
        String phoneNo = common.generateRandomNumberString(10);
        common.type(PHONENO, phoneNo);
        common.logPrint("Entered phone number is:" +phoneNo);

        common.logPrint("Step:: Enter mobile number");
        common.waitUntilElementToBeVisible(By.xpath(MOBILENO));
        String mobileNo = common.generateRandomNumberString(10);
        common.type(MOBILENO, mobileNo);
        common.logPrint("Entered mobile number is:" +mobileNo);

        common.logPrint("Step:: Enter email id");
        common.waitUntilElementToBeVisible(By.xpath(EMAILINP));
        common.type(EMAILINP, Email);
        common.logPrint("Entered email is:" +Email);

        common.logPrint("Step:: Enter joining date");
        common.waitUntilElementToBeVisible(By.xpath(EMAILINP));
        common.type(JOININGDATE, "12122024");
        common.logPrint(":Selected joining date is: 12/12/2024");

        common.scrollToElement(COMMNUNICATIONCITY);

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

        common.logPrint("Step:: Select communication city");
        common.waitUntilElementToBeVisible(By.xpath(PERMANENTCITY));
        common.type(PERMANENTCITY, "AHMEDABAD");
        common.pause(2);
        common.downKeyAndEnter();

        common.logPrint("Step:: Select communication city");
        common.waitUntilElementToBeVisible(By.xpath(PERMANENTPINCODE));
        common.type(PERMANENTPINCODE, "380058");
        common.pause(2);
        common.downKeyAndEnter();

        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.logPrint(user+" User is added successfully");
    }

    public void addIntoAccountListRSM(String email, String name){

        common.logPrint("Step:: Click on the admin panel menu");
        common.waitUntilElementToBeVisible(By.xpath(ADMINPANELMENU));
        common.click(ADMINPANELMENU);

        common.logPrint("Step:: Click on the Account list menu");
        common.waitUntilElementToBeVisible(By.xpath(ACCOUNTLISTMENU));
        common.click(ACCOUNTLISTMENU);

        common.logPrint("Step:: Click on the ADD button");
        common.waitUntilElementToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step:: Enter User Name");
        common.waitUntilElementToBeVisible(By.xpath(USERNAME));
        common.type(USERNAME, email);

        common.logPrint("Step:: Select HQ");
        common.waitUntilElementToBeVisible(By.xpath(HQINP));
        common.type(HQINP, "AHMEDABAD");
        common.pause(1);
        common.downKeyAndEnter();

        common.logPrint("Step:: Select Designation");
        common.waitUntilElementToBeVisible(By.xpath(DESIGNATIONINP));
        common.type(DESIGNATIONINP, "RSM");
        common.pause(1);
        common.downKeyAndEnter();

        common.logPrint("Step:: Select Employee");
        common.waitUntilElementToBeVisible(By.xpath(EMPLOYEEINPEMP));
        common.type(EMPLOYEEINPEMP,name);
        common.pause(1);
        common.downKeyAndEnter();

        common.logPrint("Step:: Select Role");
        common.waitUntilElementToBeVisible(By.xpath(ROLEINP));
        common.type(ROLEINP, "RSM");
        common.pause(1);
        common.downKeyAndEnter();

        common.logPrint("Step:: Select Reporting Senior");
        common.waitUntilElementToBeVisible(By.xpath(REPORTINGSENIORINP));
        common.type(REPORTINGSENIORINP, "SUPER ADMIN");
        common.pause(2);
        common.downKeyAndEnter();

        common.logPrint("Step:: Select Zone");
        common.waitUntilElementToBeVisible(By.xpath(ZONEINP));
        common.type(ZONEINP, "WEST");
        common.pause(1);
        common.downKeyAndEnter();

        common.logPrint("Step:: Select State");
        common.waitUntilElementToBeVisible(By.xpath(STATEINP));
        common.type(STATEINP, "GUJARAT");
        common.pause(1);
        common.downKeyAndEnter();

        common.logPrint("Step:: Select Region");
        common.waitUntilElementToBeVisible(By.xpath(REGIONINP));
        common.type(REGIONINP, "GUJARAT");
        common.pause(1);
        common.downKeyAndEnter();

        common.logPrint("Step:: Select District");
        common.waitUntilElementToBeVisible(By.xpath(DISTRICTINP));
        common.type(DISTRICTINP, "AHMEDABAD");
        common.pause(1);
        common.downKeyAndEnter();

        common.logPrint("Step:: Select City");
        common.waitUntilElementToBeVisible(By.xpath(CITYINPEMP));
        common.type(CITYINPEMP, "AHMEDABAD");
        common.pause(1);
        common.downKeyAndEnter();

        common.logPrint("Step:: Click on save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.pause(1);
    }

    public void addIntoAccountListASM(String email, String name, String reportingSenior){

        common.logPrint("Step:: Click on the admin panel menu");
        common.waitUntilElementToBeVisible(By.xpath(ADMINPANELMENU));
        common.click(ADMINPANELMENU);

        common.logPrint("Step:: Click on the Account list menu");
        common.waitUntilElementToBeVisible(By.xpath(ACCOUNTLISTMENU));
        common.click(ACCOUNTLISTMENU);

        common.logPrint("Step:: Click on the ADD button");
        common.waitUntilElementToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step:: Enter User Name");
        common.waitUntilElementToBeVisible(By.xpath(USERNAME));
        common.type(USERNAME, email);

        common.logPrint("Step:: Select HQ");
        common.waitUntilElementToBeVisible(By.xpath(HQINP));
        common.type(HQINP, "AHMEDABAD");
        common.pause(1);
        common.downKeyAndEnter();

        common.logPrint("Step:: Select Designation");
        common.waitUntilElementToBeVisible(By.xpath(DESIGNATIONINP));
        common.type(DESIGNATIONINP, "ASM");
        common.pause(1);
        common.downKeyAndEnter();

        common.logPrint("Step:: Select Employee");
        common.waitUntilElementToBeVisible(By.xpath(EMPLOYEEINPEMP));
        common.type(EMPLOYEEINPEMP,name);
        common.pause(1);
        common.downKeyAndEnter();

        common.logPrint("Step:: Select Role");
        common.waitUntilElementToBeVisible(By.xpath(ROLEINP));
        common.type(ROLEINP, "ASM");
        common.pause(1);
        common.downKeyAndEnter();

        common.logPrint("Step:: Select Reporting Senior");
        common.waitUntilElementToBeVisible(By.xpath(REPORTINGSENIORINP));
        common.type(REPORTINGSENIORINP, reportingSenior);
        common.pause(4);
        common.downKeyAndEnter();

        common.logPrint("Step:: Select Zone");
        common.waitUntilElementToBeVisible(By.xpath(ZONEINP));
        common.type(ZONEINP, "WEST");
        common.pause(1);
        common.downKeyAndEnter();

        common.logPrint("Step:: Select State");
        common.waitUntilElementToBeVisible(By.xpath(STATEINP));
        common.type(STATEINP, "GUJARAT");
        common.pause(1);
        common.downKeyAndEnter();

        common.logPrint("Step:: Select Region");
        common.waitUntilElementToBeVisible(By.xpath(REGIONINP));
        common.type(REGIONINP, "GUJARAT");
        common.pause(1);
        common.downKeyAndEnter();

        common.logPrint("Step:: Select District");
        common.waitUntilElementToBeVisible(By.xpath(DISTRICTINP));
        common.type(DISTRICTINP, "AHMEDABAD");
        common.pause(1);
        common.downKeyAndEnter();

        common.logPrint("Step:: Select City");
        common.waitUntilElementToBeVisible(By.xpath(CITYINPEMP));
        common.type(CITYINPEMP, "AHMEDABAD");
        common.pause(1);
        common.downKeyAndEnter();

        common.logPrint("Step:: Click on save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.pause(1);
    }

    public void addIntoAccountListMR(String email, String name, String reportingSenior){

        common.logPrint("Step:: Click on the admin panel menu");
        common.waitUntilElementToBeVisible(By.xpath(ADMINPANELMENU));
        common.click(ADMINPANELMENU);

        common.logPrint("Step:: Click on the Account list menu");
        common.waitUntilElementToBeVisible(By.xpath(ACCOUNTLISTMENU));
        common.click(ACCOUNTLISTMENU);

        common.logPrint("Step:: Click on the ADD button");
        common.waitUntilElementToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step:: Enter User Name");
        common.waitUntilElementToBeVisible(By.xpath(USERNAME));
        common.type(USERNAME, email);

        common.logPrint("Step:: Select HQ");
        common.waitUntilElementToBeVisible(By.xpath(HQINP));
        common.type(HQINP, "AHMEDABAD");
        common.pause(1);
        common.downKeyAndEnter();

        common.logPrint("Step:: Select Designation");
        common.waitUntilElementToBeVisible(By.xpath(DESIGNATIONINP));
        common.type(DESIGNATIONINP, "MR");
        common.pause(1);
        common.downKeyAndEnter();

        common.logPrint("Step:: Select Employee");
        common.waitUntilElementToBeVisible(By.xpath(EMPLOYEEINPEMP));
        common.type(EMPLOYEEINPEMP,name);
        common.pause(1);
        common.downKeyAndEnter();

        common.logPrint("Step:: Select Role");
        common.waitUntilElementToBeVisible(By.xpath(ROLEINP));
        common.type(ROLEINP, "MR");
        common.pause(1);
        common.downKeyAndEnter();

        common.logPrint("Step:: Select Reporting Senior");
        common.waitUntilElementToBeVisible(By.xpath(REPORTINGSENIORINP));
        common.type(REPORTINGSENIORINP, reportingSenior);
        common.pause(4);
        common.downKeyAndEnter();

        common.logPrint("Step:: Select Zone");
        common.waitUntilElementToBeVisible(By.xpath(ZONEINP));
        common.type(ZONEINP, "WEST");
        common.pause(1);
        common.downKeyAndEnter();

        common.logPrint("Step:: Select State");
        common.waitUntilElementToBeVisible(By.xpath(STATEINP));
        common.type(STATEINP, "GUJARAT");
        common.pause(1);
        common.downKeyAndEnter();

        common.logPrint("Step:: Select Region");
        common.waitUntilElementToBeVisible(By.xpath(REGIONINP));
        common.type(REGIONINP, "GUJARAT");
        common.pause(1);
        common.downKeyAndEnter();

        common.logPrint("Step:: Select District");
        common.waitUntilElementToBeVisible(By.xpath(DISTRICTINP));
        common.type(DISTRICTINP, "AHMEDABAD");
        common.pause(1);
        common.downKeyAndEnter();

        common.logPrint("Step:: Select City");
        common.waitUntilElementToBeVisible(By.xpath(CITYINPEMP));
        common.type(CITYINPEMP, "AHMEDABAD");
        common.pause(1);
        common.downKeyAndEnter();

        common.logPrint("Step:: Click on save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.pause(1);

    }

    public String getPasswordFromYopmailAndLoginToNewUser(String email){

        common.pause(5);
        common.openNewUrl("https://yopmail.com/");

        common.logPrint("Step:: Enter email in the mail field");
        common.waitUntilElementToBeVisible(By.xpath(EMAILINPFIELD)).clear();
        common.type(EMAILINPFIELD,email);

        common.logPrint("Step:: Click on the enter arrow");
        common.waitUntilElementToBeVisible(By.xpath(ENTERICONMAIL));
        common.click(ENTERICONMAIL);

        common.switchToFrameWithId("ifmail");
        common.waitUntilElementToBeVisible(By.xpath(MAILCONTENT));
        String mailContent = common.getText(MAILCONTENT);

        common.logPrint(mailContent);

        //Extract password using split
        String password = "";

        if(mailContent.contains("Password:")){
            password = mailContent.split("Password:")[1].trim();
        }

        common.logPrint("Password is: "+password);
        common.switchToDefaultContent();

        return password;
    }

    public void loginWithNewPass(String email, String password, String webURL){

        common.pause(1);
        common.openNewWindow();
        common.openNewUrl(webURL);

        common.refreshPage();

        common.pause(3);
        common.logPrint("Step:: Attempting to logout from the current user");
        if (common.isElementDisplayed(LOGOUTBTN)) {
            common.waitUntilElementsToBeVisible(By.xpath(LOGOUTBTN));
            common.click(LOGOUTBTN);
        } else {
            common.logPrint("Step:: Logout button not found, skipping logout step");
        }

        common.pause(5);

        common.logPrint("Step:: Enter username and password");
        common.waitUntilElementsToBeVisible(By.xpath("//input[@id='email']"));
        common.type("//input[@id='email']",email);

        common.waitUntilElementsToBeVisible(By.xpath("//input[@type='password']"));
        common.type("//input[@type='password']",password);

        common.pause(5);

        if (common.isElementDisplayed(LOGINBTN)) {
            common.logPrint("Step:: Click on the login button");
            common.waitUntilElementsToBeVisible(By.xpath(LOGINBTN));
            common.click(LOGINBTN);
        } else {
            common.logPrint("Step:: Login button is not found, skipping login step");
        }

        if(common.isElementDisplayed("//h4[contains(text(),'Reset Password')]")){
            common.logPrint("Step:: If reset password link is displayed so refresh the page");
            common.refreshPage();
        } else {
            common.logPrint("Step:: Reset password page is not showing");
        }

        common.pause(5);

        common.logPrint("Step:: Now enter your new password");
        common.waitUntilElementsToBeVisible(By.xpath(NEWPASSWORDFIELD));
        common.type(NEWPASSWORDFIELD, "Admin@123");

        common.logPrint("Step:: Now enter confirm password");
        common.waitUntilElementsToBeVisible(By.xpath(CONFIRMPASSWORD));
        common.type(CONFIRMPASSWORD, "Admin@123");

        common.logPrint("Step:: Click on the submit button");
        common.waitUntilElementsToBeVisible(By.xpath(SUBMITBTN));
        common.click(SUBMITBTN);

        common.logPrint("New User email: "+ email);
        common.logPrint("Newly created password is: Admin@123");
    }

    public void AddRoutForTheUsersUsingAdd(String employeeName){

//        common.waitUntilElementToBeVisible(By.xpath("(//label[.='City *'])[1]/following-sibling::div//button[1]"));
//        common.hoverOverTheElement("(//label[.='City *'])[1]/following-sibling::div//button[1]");
//        common.click("(//label[.='City *'])[1]/following-sibling::div//button[1]");

//        common.waitUntilElementToBeVisible(By.xpath(CLEARBTN));
//        common.hoverOverTheElement(CLEARBTN);
//        common.click(CLEARBTN);
        common.pause(2);
//        WebElement element = driver.findElement(By.xpath(CLEARBTN));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(element).pause(Duration.ofSeconds(2)).click().perform();

        common.hoverAndClickOnElement(CLEARBTN);
        common.pause(2);

        common.logPrint("Step:: Select Employee from the dropdown");
        common.waitUntilElementToBeVisible(By.xpath(EMPLOYEEFIELD));
        common.clickAndClear(EMPLOYEEFIELD);
        common.type(EMPLOYEEFIELD, employeeName);
        common.pause(1);
        common.downKeyAndEnter();
        common.logPrint("Selected employee is: "+ employeeName);

        common.logPrint("Step:: Select Start city from the dropdown");
        common.waitUntilElementToBeVisible(By.xpath(STARTCITYFIELD));
        common.type(STARTCITYFIELD, "AHMEDABAD");
        common.pause(1);
        common.downKeyAndEnter();
        common.logPrint("Selected start city is: AHMEDABAD");

        common.logPrint("Step:: Select end city from the dropdown");
        common.waitUntilElementToBeVisible(By.xpath(ENDCITYFIELD));
        common.type(ENDCITYFIELD, "AHMEDABAD");
        common.pause(1);
        common.downKeyAndEnter();
        common.logPrint("Selected end city is: AHMEDABAD");

        common.logPrint("Step:: Enter kilometers");
        common.waitUntilElementToBeVisible(By.xpath(KMSFIELD));
        String kilometer = common.generateRandomNumberString(2);
        common.type(KMSFIELD, "5");

        common.logPrint("Step:: Click on the ADD button");
        common.waitUntilElementToBeVisible(By.xpath(ADDBUTTON));
        common.click(ADDBUTTON);
        common.pause(1);
    }

    public void AddRoutForTheUsers(String username1, String username2, String username3, String webURL){

        common.pause(2);
        common.openNewWindow();
        common.openNewUrl(webURL);
        common.logPrint("Step:: Attempting to logout from the current user");
        if (common.isElementDisplayed(LOGOUTBTN)) {
            common.waitUntilElementsToBeVisible(By.xpath(LOGOUTBTN));
            common.click(LOGOUTBTN);
        } else {
            common.logPrint("Step:: Logout button not found, skipping logout step");
        }

        loginWithDirectorsUsers();

        common.logPrint("Step:: Click on the Uplaod menu");
        common.waitUntilElementsToBeVisible(By.xpath(UPLAODMENU));
        common.click(UPLAODMENU);

        common.logPrint("Step:: Click on the SRC menu");
        common.waitUntilElementsToBeVisible(By.xpath(SRCMENU));
        common.click(SRCMENU);

        common.logPrint("Step:: Click on the ADD button");
        common.waitUntilElementsToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step:: Select Employee from the dropdown");
        common.waitUntilElementToBeVisible(By.xpath(EMPLOYEEFIELD));
        common.type(EMPLOYEEFIELD, username1);
        common.pause(2);
        common.downKeyAndEnter();
        common.logPrint("Selected employee is: "+ username1);

        common.logPrint("Step:: Select Start city from the dropdown");
        common.waitUntilElementToBeVisible(By.xpath(STARTCITYFIELD));
        common.type(STARTCITYFIELD, "AHMEDABAD");
        common.pause(1);
        common.downKeyAndEnter();
        common.logPrint("Selected start city is: AHMEDABAD");

        common.logPrint("Step:: Select end city from the dropdown");
        common.waitUntilElementToBeVisible(By.xpath(ENDCITYFIELD));
        common.type(ENDCITYFIELD, "AHMEDABAD");
        common.pause(1);
        common.downKeyAndEnter();
        common.logPrint("Selected end city is: AHMEDABAD");

        common.logPrint("Step:: Enter kilometers");
        common.waitUntilElementToBeVisible(By.xpath(KMSFIELD));
        String kilometer = common.generateRandomNumberString(2);
        common.type(KMSFIELD, "5");

        common.logPrint("Step:: Click on the ADD button");
        common.waitUntilElementToBeVisible(By.xpath(ADDBUTTON));
        common.click(ADDBUTTON);

        AddRoutForTheUsersUsingAdd(username2);

        AddRoutForTheUsersUsingAdd(username3);

        common.logPrint("Step:: Click on the Save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.logPrint("Step:: Check validation is displayed");
        common.assertElementDisplayed("//*[contains(text(),'Added Successfull')]");

        common.logPrint("Rout added successfully for all the user.");

    }

    public void AddSFCForUsers(String employeeName,String webURL){

        common.pause(2);
        common.openNewWindow();
        common.openNewUrl(webURL);

        common.logPrint("Step:: Attempting to logout from the current user");
        if (common.isElementDisplayed(LOGOUTBTN)) {
            common.waitUntilElementsToBeVisible(By.xpath(LOGOUTBTN));
            common.click(LOGOUTBTN);
        } else {
            common.logPrint("Step:: Logout button not found, skipping logout step");
        }

        common.logPrint("Step:: Login from the directors");
        loginWithDirectorsUsers();

        common.logPrint("Step:: Click on the SFC menu");
        common.waitUntilElementsToBeVisible(By.xpath(SFCMENU));
        common.click(SFCMENU);

        common.logPrint("Step:: Click on the Configuration menu");
        common.waitUntilElementsToBeVisible(By.xpath(CONFIGURATIONBTN));
        common.click(CONFIGURATIONBTN);

        common.logPrint("Step:: Click on the Daily Allowance menu");
        common.waitUntilElementsToBeVisible(By.xpath(DAILYALLOWANCE));
        common.click(DAILYALLOWANCE);

        common.logPrint("Step:: Click on the ADD button");
        common.waitUntilElementsToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step:: Select Employee from the dropdown");
        common.waitUntilElementToBeVisible(By.xpath(EMPLOYEEFIELDSFC));
        common.type(EMPLOYEEFIELDSFC, employeeName);
        common.pause(1);
        common.downKeyAndEnter();
        common.logPrint("Selected Employee: " + employeeName);

        common.logPrint("Step:: Select HQ Type 'METRO'");
        common.waitUntilElementToBeVisible(By.xpath(HQTYPESFC));
        common.type(HQTYPESFC, "METRO");
        common.pause(1);
        common.downKeyAndEnter();
        common.logPrint("Selected HQ Type: METRO");

        common.logPrint("Step:: Select HQ Calculation Type 'CALCULATED'");
        common.waitUntilElementToBeVisible(By.xpath(HRCALCULATIONSFC));
        common.type(HRCALCULATIONSFC, "CALCULATED");
        common.pause(1);
        common.downKeyAndEnter();
        common.logPrint("Selected HQ Calculation Type: CALCULATED");

        common.logPrint("Step:: Enter HQ value");
        common.waitUntilElementToBeVisible(By.xpath(HQFIELDSFC));
        String hqcalnum = common.generateRandomNumberString(2);
        common.type(HQFIELDSFC, hqcalnum);
        common.logPrint("Entered HQ Value: " + hqcalnum);

        common.logPrint("Step:: Select EX HQ Calculation Type 'CALCULATED'");
        common.waitUntilElementToBeVisible(By.xpath(EXHQCALCULATIONSFC));
        common.type(EXHQCALCULATIONSFC, "CALCULATED");
        common.pause(1);
        common.downKeyAndEnter();
        common.logPrint("Selected EX HQ Calculation Type: CALCULATED");

        common.logPrint("Step:: Enter EX HQ value");
        common.waitUntilElementToBeVisible(By.xpath(EXHQSFC));
        String exhqcalnum = common.generateRandomNumberString(2);
        common.type(EXHQSFC, exhqcalnum);
        common.logPrint("Entered EX HQ Value: " + exhqcalnum);

        common.logPrint("Step:: Select OS Calculation Type 'CALCULATED'");
        common.waitUntilElementToBeVisible(By.xpath(OSCALCULATIONTYPE));
        common.type(OSCALCULATIONTYPE, "CALCULATED");
        common.pause(1);
        common.downKeyAndEnter();
        common.logPrint("Selected OS Calculation Type: CALCULATED");

        common.logPrint("Step:: Enter OS value");
        common.waitUntilElementToBeVisible(By.xpath(OSFIEDL));
        String osNum = common.generateRandomNumberString(2);
        common.type(OSFIEDL, osNum);
        common.logPrint("Entered OS Value: " + osNum);

        common.logPrint("Step:: Click on the save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.logPrint("Step:: Check validation is displayed");
        common.assertElementDisplayed("//*[contains(text(),'Added SuccessFull')]");

        common.logPrint("New Rout is created successfully for the: "+employeeName);

    }

    public void createNewDoctor(String Doctorname, String Category, String AssignUser){

        common.logPrint("Step:: Click on the admin panel menu");
        common.waitUntilElementToBeVisible(By.xpath(ADMINPANELMENU));
        common.click(ADMINPANELMENU);

        common.logPrint("Step:: Click on the Doctor menu");
        common.waitUntilElementToBeVisible(By.xpath(DOCTORMENU));
        common.click(DOCTORMENU);

        common.logPrint("Step:: Click on the ADD button");
        common.waitUntilElementToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.scroll_To_Element(DOCTORNAMEINP);

        common.logPrint("Step:: Create doctor create functionality");
        common.waitUntilElementsToBeVisible(By.xpath(DOCTORNAMEINP));
        common.type(DOCTORNAMEINP, Doctorname);
        common.logPrint("Doctor name is: "+ Doctorname);

        common.logPrint("Step:: Select category");
        common.waitUntilElementToBeVisible(By.xpath(CATEGORYINP));
        common.type(CATEGORYINP, Category);
        common.pause(1);
        common.downKeyAndEnter();
        common.logPrint("Selected category is: "+ Category);

        common.logPrint("Step:: Select Speciality");
        common.waitUntilElementToBeVisible(By.xpath(SPECIALITYINP));
        common.type(SPECIALITYINP, "paediatrician");
        common.pause(1);
        common.downKeyAndEnter();

        common.logPrint("Step:: Select Qualification");
        common.waitUntilElementToBeVisible(By.xpath(QUALIFICATIONSINP));
        common.type(QUALIFICATIONSINP, "D.G.O");
        common.pause(1);
        common.downKeyAndEnter();

//        common.logPrint("Step:: Select Employee");
//        common.waitUntilElementToBeVisible(By.xpath(EMPLOYEEFIELDSFC));
//        common.type(EMPLOYEEFIELDSFC, AssignUser);
//        common.pause(1);
//        common.downKeyAndEnter();

        common.logPrint("Step:: Select Product");
        common.waitUntilElementToBeVisible(By.xpath(PRODUCTINP));
        common.type(PRODUCTINP, "2605 test product");
        common.pause(2);
        common.downKeyAndEnter();

        common.logPrint("Step:: Enter mobile number");
        common.waitUntilElementToBeVisible(By.xpath(MOBILENOINP));
        String mobileNum = common.generateRandomNumberString(10);
        common.type(MOBILENOINP, mobileNum);

        common.logPrint("Step:: Select City");
        common.waitUntilElementToBeVisible(By.xpath(COMMNUNICATIONCITY));
        common.type(COMMNUNICATIONCITY, "AHMEDABAD");
        common.pause(1);
        common.downKeyAndEnter();

//        common.waitUntilElementToBeVisible(By.xpath("(//label[.='City *'])[1]/following-sibling::div//button[1]"));
//        common.hoverOverTheElement("(//label[.='City *'])[1]/following-sibling::div//button[1]");
//        common.click("(//label[.='City *'])[1]/following-sibling::div//button[1]");
//
//        common.pause(10);

        common.logPrint("Step:: Select Pincode");
        common.waitUntilElementToBeVisible(By.xpath(COMMNUCATIONPINCODE));
        common.type(COMMNUCATIONPINCODE, "380058");
        common.pause(1);
        common.downKeyAndEnter();

        common.logPrint("Step:: Select residential City");
        common.waitUntilElementToBeVisible(By.xpath(PERMANENTCITY));
        common.type(PERMANENTCITY, "AHMEDABAD");
        common.pause(1);
        common.downKeyAndEnter();

        common.logPrint("Step:: Select residential Pincode");
        common.waitUntilElementToBeVisible(By.xpath(PERMANENTPINCODE));
        common.type(PERMANENTPINCODE, "380058");
        common.pause(1);
        common.downKeyAndEnter();

        common.logPrint("Step:: Click on the save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.logPrint("Step:: Check validation is displayed");
        common.assertElementDisplayed(AddedSuccessfully);

        common.logPrint("New doctor is created successfully and name is: "+Doctorname);
    }

    public void createNewChemist(String Chemistname, String Category){

        common.logPrint("Step:: Click on the admin panel menu");
        common.waitUntilElementToBeVisible(By.xpath(ADMINPANELMENU));
        common.click(ADMINPANELMENU);

        common.logPrint("Step:: Click on the Chemist menu");
        common.waitUntilElementToBeVisible(By.xpath(CHEMISTMENU));
        common.click(CHEMISTMENU);

        common.logPrint("Step:: Click on the ADD button");
        common.waitUntilElementToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        //common.scroll_To_Element(DOCTORNAMEINP);

        common.logPrint("Step:: Enter chemist name");
        common.waitUntilElementsToBeVisible(By.xpath(CHEMISTNAME));
        common.type(CHEMISTNAME, Chemistname);
        common.logPrint("Doctor name is: "+ Chemistname);

        common.logPrint("Step:: Select category");
        common.waitUntilElementToBeVisible(By.xpath(CATEGORYINP));
        common.type(CATEGORYINP, Category);
        common.pause(1);
        common.downKeyAndEnter();
        common.logPrint("Selected category is: "+ Category);

        common.logPrint("Step:: Select chemist type");
        common.waitUntilElementToBeVisible(By.xpath(CHEMMISTTYPE));
        common.type(CHEMMISTTYPE, "Test");
        common.pause(1);
        common.downKeyAndEnter();

        common.logPrint("Step:: Enter mobile number");
        common.waitUntilElementToBeVisible(By.xpath(MOBILENOINP));
        String mobileNum = common.generateRandomNumberString(10);
        common.type(MOBILENOINP, mobileNum);

        common.logPrint("Step:: Select City");
        common.waitUntilElementToBeVisible(By.xpath(CITYINPUT));
        common.type(CITYINPUT, "AHMEDABAD");
        common.pause(2);
        common.downKeyAndEnter();

        common.logPrint("Step:: Select Pincode");
        common.waitUntilElementToBeVisible(By.xpath(PINCODEINPUT));
        common.type(PINCODEINPUT, "380058");
        common.pause(2);
        common.downKeyAndEnter();

        common.logPrint("Step:: Click on the save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.logPrint("Step:: Check validation is displayed");
        common.assertElementDisplayed(AddedSuccessfully);

        common.logPrint("New chemist is created successfully and name is: "+Chemistname);
    }

    public void createNewStockist(String Stockistname){

        common.logPrint("Step:: Click on the admin panel menu");
        common.waitUntilElementToBeVisible(By.xpath(ADMINPANELMENU));
        common.click(ADMINPANELMENU);

        common.logPrint("Step:: Click on the stockist menu");
        common.waitUntilElementToBeVisible(By.xpath(STOCKISTMENU));
        common.click(STOCKISTMENU);

        common.logPrint("Step:: Click on the ADD button");
        common.waitUntilElementToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.scroll_To_Element(STOCKISTNAME);

        common.logPrint("Step:: Enter Stockist name");
        common.waitUntilElementsToBeVisible(By.xpath(STOCKISTNAME));
        common.type(STOCKISTNAME, Stockistname);
        common.logPrint("Stockiest name is: "+ Stockistname);

        common.logPrint("Step:: Select stockist type");
        common.waitUntilElementToBeVisible(By.xpath(STOCKISTTYPE));
        common.type(STOCKISTTYPE, "Test");
        common.pause(1);
        common.downKeyAndEnter();
        common.logPrint("Selected category is: "+ "STOCKIST");

        common.logPrint("Step:: Enter mobile number");
        common.waitUntilElementToBeVisible(By.xpath(MOBILENO1FIELD));
        String mobileNum = common.generateRandomNumberString(10);
        common.type(MOBILENO1FIELD, mobileNum);

        common.logPrint("Step:: Select City");
        common.waitUntilElementToBeVisible(By.xpath(CITYINPUT));
        common.type(CITYINPUT, "AHMEDABAD");
        common.pause(1);
        common.downKeyAndEnter();

        common.logPrint("Step:: Select Pincode");
        common.waitUntilElementToBeVisible(By.xpath(PINCODEINPUT));
        common.type(PINCODEINPUT, "380058");
        common.pause(1);
        common.downKeyAndEnter();

        common.logPrint("Step:: Click on the save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.logPrint("Step:: Check validation is displayed");
        common.assertElementDisplayed(AddedSuccessfully);

        common.logPrint("New stockist is created successfully and name is: "+ Stockistname);
    }

    public void createNewHospital(String HospitalName){

        common.logPrint("Step:: Click on the admin panel menu");
        common.waitUntilElementToBeVisible(By.xpath(ADMINPANELMENU));
        common.click(ADMINPANELMENU);

        common.logPrint("Step:: Click on the Hospital menu");
        common.waitUntilElementToBeVisible(By.xpath(HOSPITALMENU));
        common.click(HOSPITALMENU);

        common.logPrint("Step:: Click on the ADD button");
        common.waitUntilElementToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.scroll_To_Element(HOSPITALNAMEINP);

        common.logPrint("Step:: Enter Hospital name");
        common.waitUntilElementsToBeVisible(By.xpath(HOSPITALNAMEINP));
        common.type(HOSPITALNAMEINP, HospitalName);
        common.logPrint("Hospital name is: "+ HospitalName);

        common.logPrint("Generate GST number");
        String gstnum = common.generateRandomNumberString(10);

        common.logPrint("Step:: Enter GST number");
        common.waitUntilElementToBeVisible(By.xpath(GSTINP));
        common.type(GSTINP, "AUTOG"+gstnum);

        common.logPrint("Step:: Select City");
        common.waitUntilElementToBeVisible(By.xpath(CITYINPUT));
        common.type(CITYINPUT, "AHMEDABAD");
        common.pause(1);
        common.downKeyAndEnter();

        common.logPrint("Step:: Select Pincode");
        common.waitUntilElementToBeVisible(By.xpath(PINCODEINPUT));
        common.type(PINCODEINPUT, "360058");
        common.pause(1);
        common.downKeyAndEnter();

        common.logPrint("Step:: Click on the save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.logPrint("Step:: Check validation is displayed");
        common.waitForElementWithStaleCheck(By.xpath(AddedSuccessfully), 3, 10);
        common.waitUntilElementToBeVisible(AddedSuccessfully);
        common.assertElementDisplayed(AddedSuccessfully);

        common.logPrint("New stockist is created successfully and name is: "+ HospitalName);
    }

//    public void setPaginationTo100() {
//        By combobox = By.xpath("//div[@role='combobox']");
//        By option100 = By.xpath("//li[.='100']");
//
//        common.waitUntilElementToBeVisible(combobox);
//        common.click(combobox);
//
//        common.waitUntilElementToBeVisible(option100);
//        common.click(option100);
//    }

    public void waitForPageToStabilize() {
        // Wait for toast message or validation to disappear
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".MuiSnackbar-root"))); // Adjust selector
        } catch (Exception e) {
            System.out.println("Validation message did not disappear in time.");
        }
    }

    public void addProductForDoctor(WebElement row) {

        common.logPrint("Step:: Click on the edit button");
        common.waitUntilElementToBeVisible(By.xpath(EDITBTN));
        common.click(EDITBTN);

        common.logPrint("Step:: Select Product");
        common.waitUntilElementToBeVisible(By.xpath(PRODUCTINP));
        common.type(PRODUCTINP, "BISOWIN - 2.5");
        common.pause(2);
        common.downKeyAndEnter();

        common.logPrint("Step:: Click on the save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);


    }

    public void addProductInBlankFieldDoctor() {
        common.logPrint("Step:: Click on the admin panel menu");
        common.waitUntilElementToBeVisible(By.xpath(ADMINPANELMENU));
        common.click(ADMINPANELMENU);

        common.logPrint("Step:: Click on the doctor menu");
        common.waitUntilElementToBeVisible(By.xpath(DOCTORMENU));
        common.click(DOCTORMENU);

        common.logPrint("Step:: Click on the bulk approval button");
        common.waitUntilElementToBeVisible(By.xpath(BULKAPPROVALBTN));
        common.click(BULKAPPROVALBTN);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        boolean hasNextPage = true;

        while (hasNextPage) {
            boolean productMissing;

            do {
                Set<Integer> seenRows = new HashSet<>();
                productMissing = false;

                List<WebElement> rows = driver.findElements(By.cssSelector("div[role='row'][data-rowindex]"));

                for (WebElement row : rows) {
                    int rowIndex;

                    try {
                        rowIndex = Integer.parseInt(row.getAttribute("data-rowindex"));
                    } catch (StaleElementReferenceException e) {
                        continue;
                    }

                    if (seenRows.contains(rowIndex)) continue;
                    seenRows.add(rowIndex);

                    try {
                        WebElement freshRow = driver.findElement(By.cssSelector("div[data-rowindex='" + rowIndex + "']"));
                        WebElement productCell = freshRow.findElement(By.cssSelector("div[data-field='doctorProductBulkLists']"));
                        String productText = productCell.getText().trim();

                        if (productText.isEmpty() || productText.equals("-")) {
                            productMissing = true;

                            WebElement checkbox = freshRow.findElement(By.cssSelector("div[data-field='__check__'] input[type='checkbox']"));
                            if (!checkbox.isSelected()) {
                                checkbox.click();
                                System.out.println("Checked row index: " + rowIndex);
                            }

                            addProductForDoctor(freshRow);
                            common.pause(1);
                        }

                    } catch (StaleElementReferenceException staleEx) {
                        System.out.println("Row became stale, skipping: " + rowIndex);
                    } catch (Exception e) {
                        System.out.println("Error in row " + rowIndex + ": " + e.getMessage());
                    }
                }

                // Scroll to load more rows (if lazy-loading)
                js.executeScript(
                        "var el = document.querySelector('.MuiDataGrid-virtualScroller');" +
                                "if (el) el.scrollBy(0, 500);"
                );
                common.pause(1);

            } while (productMissing); // loop until all "-" records are handled on current page

            // ➤ Try to click Next page button
            try {
                WebElement nextBtn = driver.findElement(By.xpath("//button[contains(@aria-label,'Go to next page')]"));

                if (nextBtn.isEnabled() && nextBtn.getAttribute("aria-disabled") == null) {
                    // Try scroll and click safely
                    js.executeScript("arguments[0].scrollIntoView({block:'center'});", nextBtn);
                    common.pause(1);
                    nextBtn.click();
                    common.pause(3); // Wait for page load
                } else {
                    System.out.println("No more pages. Exiting.");
                    hasNextPage = false;
                }
            } catch (NoSuchElementException e) {
                System.out.println("Next button not found. Assuming last page.");
                hasNextPage = false;
            } catch (ElementClickInterceptedException e) {
                System.out.println("Next button is blocked. Trying JS click.");
                WebElement nextBtn = driver.findElement(By.xpath("//button[contains(@aria-label,'Go to next page')]"));
                js.executeScript("arguments[0].click();", nextBtn);
                common.pause(3);
            }
        }
    }

    public void approveBulkApproveDoctor(){

        //loginWithDirectorsUsers();

            common.logPrint("Step:: Click on the admin panel menu");
            common.waitUntilElementToBeVisible(By.xpath(ADMINPANELMENU));
            common.click(ADMINPANELMENU);

            common.logPrint("Step:: Click on the doctor menu");
            common.waitUntilElementToBeVisible(By.xpath(DOCTORMENU));
            common.click(DOCTORMENU);

            common.logPrint("Step:: Click on the bulk approval button");
            common.waitUntilElementToBeVisible(By.xpath(BULKAPPROVALBTN));
            common.click(BULKAPPROVALBTN);

        for(int i=0; i<271; i++){

            common.logPrint("Step:: Get doctor name");
            common.pause(1);
            String doctorname = common.getText("//div[@data-id='1']//div[@data-colindex='3']");

            common.logPrint("Step:: Click on the checkbox");
            common.waitUntilElementToBeVisible(By.xpath(CHECKBOX));
            common.click(CHECKBOX);

            common.logPrint("Step:: Click on the checkbox");
            common.waitUntilElementToBeVisible(By.xpath(APPROVEBTN));
            common.click(APPROVEBTN);

            common.pause(1);

            common.logPrint("Check validation is showing");
            common.waitUntilElementToBeVisible(By.xpath(SUCCESSMSG));
            common.assertElementDisplayed(SUCCESSMSG);
            common.logPrint("Data is approved successfully");

            common.logPrint("Step:: Click on the close button");
            common.waitUntilElementToBeVisible(By.xpath(CLOSEBTN));
            common.click(CLOSEBTN);

            common.refreshPage();

            common.logPrint("Doctor number: "+doctorname+" is approved");

            common.logPrint("Approved count is: "+i);
        }
    }

    public void approveBulkApproveChemist(){

        common.logPrint("Step:: Click on the admin panel menu");
        common.waitUntilElementToBeVisible(By.xpath(ADMINPANELMENU));
        common.click(ADMINPANELMENU);

        common.logPrint("Step:: Click on the chemist menu");
        common.waitUntilElementToBeVisible(By.xpath(CHEMISTMENU));
        common.click(CHEMISTMENU);

        common.logPrint("Step:: Click on the bulk approval button");
        common.waitUntilElementToBeVisible(By.xpath(BULKAPPROVALBTN));
        common.click(BULKAPPROVALBTN);

        for(int i=0; i<29; i++){

            common.logPrint("Step:: Get chemist name");
            common.pause(1);
            String doctorname = common.getText("//div[@data-id='1']//div[@data-colindex='3']");

            common.logPrint("Step:: Click on the checkbox");
            common.waitUntilElementToBeVisible(By.xpath(CHECKBOX));
            common.click(CHECKBOX);

            common.logPrint("Step:: Click on the approve button");
            common.waitUntilElementToBeVisible(By.xpath(APPROVEBTN));
            common.click(APPROVEBTN);

            common.pause(1);

            common.logPrint("Check validation is showing");
            common.waitUntilElementToBeVisible(SUCCESSMSG);
            common.assertElementDisplayed(SUCCESSMSG);
            common.logPrint("Data is approved successfully");

            common.logPrint("Step:: Click on the close button");
            common.waitUntilElementToBeVisible(By.xpath(CLOSEBTN));
            common.click(CLOSEBTN);

            common.refreshPage();

            common.logPrint("Doctor number: "+doctorname+" is approved");
        }
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

        String formattedDate = common.generateDate("future", "current", "12/12/2025");

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
        common.assertElementDisplayed(AddedSuccessfully);

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

    public void addDoctorSpecialityInAttributes(String specialityName){

//        common.logPrint("Step:: Click on the admin menu");
//        if(common.findElement(ADMINPANELMENU).isDisplayed()){
//            common.click(ADMINPANELMENU);
//        }

        common.logPrint("Step:: Search Attributes menu");
        common.waitUntilElementToBeVisible(By.xpath(SEARCHFIELDINDASH));
        common.findElement(SEARCHFIELDINDASH).clear();
        common.type(SEARCHFIELDINDASH,"attributes");

        common.logPrint("Step:: Click on the Attributes menu");
        common.waitUntilElementToBeVisible(By.xpath(ATTRIBUTESMENU));
        common.click(ATTRIBUTESMENU);

        common.logPrint("Step:: Click on the Doctor menu");
        common.waitUntilElementToBeVisible(By.xpath(DOCTORMENUATT));
        common.click(DOCTORMENUATT);

        common.logPrint("Step:: Click on the Doctor speciality");
        common.waitUntilElementToBeVisible(By.xpath(DOCTORSPECIALITY));
        common.click(DOCTORSPECIALITY);

        common.logPrint("Step:: Click on the add button");
        common.waitUntilElementToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step:: Enter speciality name");
        common.waitUntilElementToBeVisible(By.xpath(SPECIALITYNAME));
        common.type(SPECIALITYNAME,specialityName);

        common.logPrint("Step:: Enter Remarks");
        common.waitUntilElementToBeVisible(By.xpath(REMARKSINP));
        common.type(REMARKSINP,"Test "+specialityName);

        common.logPrint("Step:: Select Qualification");
        common.waitUntilElementToBeVisible(By.xpath(QUALIFICATIONINP));
        common.type(QUALIFICATIONINP, "D.C.H");
        common.pause(1);
        common.downKeyAndEnter();

        common.logPrint("Step:: Click on the save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.logPrint("Step:: Check validation is displayed");
        common.assertElementDisplayed(AddedSuccessfully);

        common.logPrint("Qualification is added for the doctor: "+ specialityName);

        common.refreshPage();
    }

    public void addDoctorCategoryInAttributes(String CategoryName){

        common.logPrint("Step:: Click on the admin menu");
        common.waitUntilElementToBeVisible(By.xpath(ADMINPANELMENU));
        common.click(ADMINPANELMENU);

        common.logPrint("Step:: Search Attributes menu");
        common.waitUntilElementToBeVisible(By.xpath(SEARCHFIELDINDASH));
        common.type(SEARCHFIELDINDASH,"attributes");

        common.logPrint("Step:: Click on the Attributes menu");
        common.waitUntilElementToBeVisible(By.xpath(ATTRIBUTESMENU));
        common.click(ATTRIBUTESMENU);

//        common.logPrint("Step:: Clear search field");
//        common.waitUntilElementToBeVisible(By.xpath(SEARCHFIELDINDASH));
//        driver.findElement(By.xpath(SEARCHFIELDINDASH)).clear();

        common.logPrint("Step:: Click on the Doctor menu");
        common.waitUntilElementToBeVisible(By.xpath(DOCTORMENUATT));
        common.click(DOCTORMENUATT);

        common.logPrint("Step:: Click on the Doctor category");
        common.waitUntilElementToBeVisible(By.xpath(DOCTORCATEGORY));
        common.click(DOCTORCATEGORY);

        common.logPrint("Step:: Click on the add button");
        common.waitUntilElementToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step:: Enter Category name");
        common.waitUntilElementToBeVisible(By.xpath(CATEGORYNAME));
        common.type(CATEGORYNAME,CategoryName);

        common.logPrint("Step:: Enter category order");
        common.waitUntilElementToBeVisible(By.xpath(CATEGORYORDER));
        common.type(CATEGORYORDER,"3");

//        common.logPrint("Step:: Enter category order");
//        common.waitUntilElementToBeVisible(By.xpath(EXPECTEDVISITINP));
//        common.type(EXPECTEDVISITINP,"1");

        common.logPrint("Step:: Click on the save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.logPrint("Step:: Check validation is displayed");
        common.assertElementDisplayed(AddedSuccessfully);

        common.logPrint("Qualification is added for the doctor: "+ CategoryName);

        common.refreshPage();
    }

    public void createEmailFromAdmin(){

        common.logPrint("Step:: Search communication menu");
        common.waitUntilElementToBeVisible(By.xpath(SEARCHFIELDINDASH));
        common.type(SEARCHFIELDINDASH,"communication");

        common.logPrint("Step:: Click on the Attributes menu");
        common.waitUntilElementToBeVisible(By.xpath(ATTRIBUTESMENU));
        common.click(ATTRIBUTESMENU);
    }

}