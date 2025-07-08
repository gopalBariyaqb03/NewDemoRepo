package Pages;

import Config.ReadProperties;
import Utils.Common;
import Utils.Locators;
import net.openhft.chronicle.core.values.StringValue;
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

    public void redirectsToVendorPage(){

        common.waitUntilElementToBeVisible(By.xpath(VENDORMENU));
        common.scroll_To_Element(VENDORMENU);

        common.logPrint("Step:: Click on the vendor menu");
        common.waitUntilElementToBeVisible(By.xpath(VENDORMENU));
        common.click(VENDORMENU);

    }

    public void createVendorUsingAdminCredencials(String name){

       redirectsToVendorPage();

        common.logPrint("Step:: Click on the add button");
        common.waitUntilElementToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step:: Select vendor service type");
        common.waitUntilElementToBeVisible(By.xpath(VENDORSERTYPE));
        common.click(VENDORSERTYPE);
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
        common.type(AREALMAN, "Automation test area");

        common.logPrint("Step:: Select communication city");
        common.waitUntilElementToBeVisible(By.xpath(COMMNUNICATIONCITY));
        common.type(COMMNUNICATIONCITY, "AHMEDABAD");
        common.pause(2);
        common.downKeyAndEnter();

        common.logPrint("Step:: Select Pincode city");
        common.waitUntilElementToBeVisible(By.xpath(COMMNUCATIONPINCODE));
        common.click(COMMNUCATIONPINCODE);
        common.pause(2);
        common.downKeyAndEnter();

        common.logPrint("Step:: Click on save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.logPrint("Step:: Check validation is displayed");
        common.assertElementDisplayed("//*[contains(text(),'Added Successfull')]");

        common.logPrint("Verify vendor is created successfully and showing in the table");
        common.waitUntilElementToBeVisible(CREATEDVALUE);
        String getValue = common.getText(CREATEDVALUE);
        common.assertTwoValuesAreEqual(getValue, name);

        common.logPrint("Vendor are created successfully and showing in the table");
    }

    public void verifyVendorFromAllTheThreeUsers(String name){

        common.logPrint("Step:: Verify vendor is created and showing in the MR user");
        loginWithMRCredential();
        VerifyVendorIsCreateAndShowingInTheTable(name);

        common.logPrint("Step:: Verify vendor is created and showing in the ASM user");
        loginWithASMCredential();
        VerifyVendorIsCreateAndShowingInTheTable(name);

        common.logPrint("Step:: Verify vendor is created and showing in the RSM user");
        loginWithRSMCredential();
        VerifyVendorIsCreateAndShowingInTheTable(name);
    }

    public void VerifyVendorIsCreateAndShowingInTheTable(String name){

        redirectsToVendorPage();

        common.logPrint("Step:: Search vendor name in the search field");
        common.waitUntilElementToBeVisible(By.xpath(SEARCHFIELDTAB));
        common.type(SEARCHFIELDTAB, name);

        common.logPrint("Verify vendor is created successfully and showing in the table");
        common.waitUntilElementToBeVisible(CREATEDVALUE);
        String getValue = common.getText(CREATEDVALUE);
        common.assertTwoValuesAreEqual(getValue, name);
    }

    public String[] updateVendorScenario(String name){

        redirectsToVendorPage();

        VerifyVendorIsCreateAndShowingInTheTable(name);

        common.pause(2);
        common.selectCheckBox(FIRSTCHECKBOX);

        common.waitUntilElementToBeVisible(By.xpath(EDITBTN));
        common.click(EDITBTN);

        common.logPrint("Step:: Update the vendor name");
        common.waitUntilElementToBeVisible(By.xpath(VENDORNAMEFIELD)).clear();
        String updateName = common.GenerateRandomName();
        common.type(VENDORNAMEFIELD, updateName);
        common.logPrint("Updated name is: "+updateName);

        common.logPrint("Step:: Update the Contact phone number");
        common.waitUntilElementToBeVisible(By.xpath(CONTACTPHONENUM)).clear();
        String ConMobilenum = common.generateRandomNumberString(10);
        common.type(CONTACTPHONENUM,ConMobilenum);

        common.logPrint("Step:: Enter ratings");
        common.waitUntilElementToBeVisible(RATINGFIELD).clear();
        common.type(RATINGFIELD,"4");

        common.logPrint("Step:: Click on save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.logPrint("Step:: Check validation is displayed");
        common.assertElementDisplayed(UpdatedSuccessfully);

        return new String[] {updateName, ConMobilenum, "4"};
    }

    public void verifyUpdatedInformationForVendorForAllTheUser(String name, String mobileNum, String Ratings){

        common.logPrint("Verify updated information from MR user");
        loginWithMRCredential();
        verifyVendorInformationAfterItsUpdated(name, mobileNum, Ratings);

        common.logPrint("Verify updated information from ASM user");
        loginWithASMCredential();
        verifyVendorInformationAfterItsUpdated(name, mobileNum, Ratings);

        common.logPrint("Verify updated information from RSM user");
        loginWithRSMCredential();
        verifyVendorInformationAfterItsUpdated(name, mobileNum, Ratings);
    }

    public void verifyVendorInformationAfterItsUpdated(String name, String mobileNum, String Ratings){

        redirectsToVendorPage();

        common.logPrint("Step:: Search vendor name in the search field");
        common.waitUntilElementToBeVisible(By.xpath(SEARCHFIELDTAB));
        common.type(SEARCHFIELDTAB, name);

        common.pause(1);

        common.logPrint("Verify vendor name is updated successfully and showing in the table");
        common.waitUntilElementToBeVisible(CREATEDVALUE);
        String getValue = common.getText(CREATEDVALUE);
        common.assertTwoValuesAreEqual(getValue, name);

        common.logPrint("Verify vendor contact mobile number is updated successfully and showing in the table");
        common.waitUntilElementToBeVisible(CONTACTNUMBER);
        String getContactNum = common.getText(CONTACTNUMBER);
        common.assertTwoValuesAreEqual(getContactNum, mobileNum);

        common.logPrint("Verify vendor Ratings are updated successfully and showing in the table");
        common.waitUntilElementToBeVisible(RATINGSTABLE);
        String ratings = common.findElement(RATINGSTABLE).getAttribute("aria-label");
        String firstChar = String.valueOf(ratings.charAt(0));
        common.logPrint(firstChar);

        common.assertTwoValuesAreEqual(firstChar.trim(), Ratings);
    }

    public void deleteVendorFromTheList(String name){

        redirectsToVendorPage();

        common.logPrint("Step:: Search vendor name in the search field");
        common.waitUntilElementToBeVisible(By.xpath(SEARCHFIELDTAB));
        common.type(SEARCHFIELDTAB, name);

        common.pause(2);
        common.selectCheckBox(FIRSTCHECKBOX);

        common.logPrint("Step:: Click on the delete button");
        common.waitUntilElementToBeVisible(By.xpath(DELETEBTN));
        common.click(DELETEBTN);

        common.logPrint("Step:: Click on the Delete button");
        common.waitUntilElementToBeVisible(By.xpath(DELETEBTN));
        common.click(DELETEBTN);

        common.logPrint("Step:: Verify delete confirmation pop-up is showing");
        common.waitUntilElementToBeVisible(By.xpath(DeleteConfirmationPopUp));
        common.assertElementPresent(DeleteConfirmationPopUp);

        common.logPrint("Step:: Click on the delete button");
        common.waitUntilElementToBeVisible(By.xpath(DELETEBTNPOP));
        common.click(DELETEBTNPOP);

        common.logPrint("Step:: Verify delete confirmation pop-up is showing");

        common.logPrint("Step:: Check validation is displayed");
        common.assertElementDisplayed(DeletedSuccessfully );
    }

    public void verifyVendorIsRemovedFromAllUser(String name){

        common.logPrint("Verify vendor is removed from the list for MR user");
        loginWithMRCredential();
        VerifyVendorIsDeletedFromTheTable(name);

        common.logPrint("Verify vendor is removed from the list for ASM user");
        loginWithASMCredential();
        VerifyVendorIsDeletedFromTheTable(name);

        common.logPrint("Verify vendor is removed from the list for RSM user");
        loginWithRSMCredential();
        VerifyVendorIsDeletedFromTheTable(name);

    }

    public void VerifyVendorIsDeletedFromTheTable(String name){

        redirectsToVendorPage();

        common.logPrint("Step:: Search vendor name in the search field");
        common.waitUntilElementToBeVisible(By.xpath(SEARCHFIELDTAB));
        common.type(SEARCHFIELDTAB, name);

        common.pause(1);

        common.logPrint("Step:: Check doctor is removed from the list");

        common.logPrint("Step:: Now rows are available");
        common.assertElementDisplayed(NOROWS);
    }

}