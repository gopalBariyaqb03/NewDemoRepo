package Pages;

import Utils.Common;
import Utils.Locators;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminPage extends Locators {
    Common common = new Common(driver);


    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public void redirectToDoctorPage() {
        common.logPrint("Step:: Click on the admin panel menu");
        common.waitUntilElementToBeVisible(By.xpath(ADMINPANELMENU));
        common.click(ADMINPANELMENU);

        common.logPrint("Step:: Click on the Doctor menu");
        common.waitUntilElementToBeVisible(By.xpath(DOCTORMENU));
        common.click(DOCTORMENU);
    }

    public void redirectsToChemistPage() {
        common.logPrint("Step:: Click on the admin panel menu");
        common.waitUntilElementToBeVisible(By.xpath(ADMINPANELMENU));
        common.click(ADMINPANELMENU);

        common.logPrint("Step:: Click on the Chemist menu");
        common.waitUntilElementToBeVisible(By.xpath(CHEMISTMENU));
        common.click(CHEMISTMENU);
    }

    public void redirectsToStockiestPage() {
        common.logPrint("Step:: Click on the admin panel menu");
        common.waitUntilElementToBeVisible(By.xpath(ADMINPANELMENU));
        common.click(ADMINPANELMENU);

        common.logPrint("Step:: Click on the Stockiest menu");
        common.waitUntilElementToBeVisible(By.xpath(STOCKISTMENU));
        common.click(STOCKISTMENU);
    }

    public void redirectsDeleteDoctorApprovalPage() {
        common.logPrint("Step:: Click on the Approval menu");
        common.waitUntilElementToBeVisible(By.xpath(APPROVALMENU));
        common.click(APPROVALMENU);

        common.logPrint("Step:: Click on the Stockiest menu");
        common.waitUntilElementToBeVisible(By.xpath(DELETEAPPROVALDOCTOR));
        common.click(DELETEAPPROVALDOCTOR);
    }

    public void redirectsDeleteChemistApprovalPage() {
        common.logPrint("Step:: Click on the Approval menu");
        common.waitUntilElementToBeVisible(By.xpath(APPROVALMENU));
        common.click(APPROVALMENU);

        common.logPrint("Step:: Click on the Delete chemist approval menu");
        common.waitUntilElementToBeVisible(By.xpath(DELETEAPPROVALCHEMIST));
        common.click(DELETEAPPROVALCHEMIST);
    }

    public void redirectsDeleteStockiestApprovalPage() {
        common.logPrint("Step:: Click on the Approval menu");
        common.waitUntilElementToBeVisible(By.xpath(APPROVALMENU));
        common.click(APPROVALMENU);

        common.logPrint("Step:: Click on the Delete chemist approval menu");
        common.waitUntilElementToBeVisible(By.xpath(DELETEAPPROVALSTOCKIEST));
        common.click(DELETEAPPROVALSTOCKIEST);
    }

    public void verifyValidationMessageForDoctorCreationWithDirector() {

        common.logPrint("Verify mandatory fields for the doctor creation page");

        common.logPrint("Step:: Click on the admin menu");
        common.waitUntilElementToBeVisible(By.xpath(ADMINPANELMENU));
        common.click(ADMINPANELMENU);

        common.logPrint("Step:: Click on the Doctor menu");
        common.waitUntilElementToBeVisible(By.xpath(DOCTORMENU));
        common.click(DOCTORMENU);

        common.logPrint("Step:: Click on the ADD button");
        common.waitUntilElementToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step:: Click on the save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.logPrint("Step:: Verify all the validation message for mandatory fields");

        common.logPrint("Step:: Verify validation message for Doctor Name");
        common.waitUntilElementToBeVisible(By.xpath(DoctorError));
        String doctorMsg = common.getText(DoctorError);
        common.assertTwoValuesAreEqual(doctorMsg, "Doctor Name is required");
        common.logPrint("Error message is showing for the doctor name: " + doctorMsg);

        common.logPrint("Step:: Verify validation message for Category");
        common.waitUntilElementToBeVisible(By.xpath(CategoryError));
        String categoryMsg = common.getText(CategoryError);
        common.assertTwoValuesAreEqual(categoryMsg, "Category is Required");
        common.logPrint("Error message is showing for the category name: " + categoryMsg);

        common.logPrint("Step:: Verify validation message for Speciality");
        common.waitUntilElementToBeVisible(By.xpath(SpecialityError));
        String specialityMsg = common.getText(SpecialityError);
        common.assertTwoValuesAreEqual(specialityMsg, "Speciality is Required");
        common.logPrint("Error message is showing for the speciality name: " + specialityMsg);

        common.logPrint("Step:: Verify validation message for Qualifications");
        common.waitUntilElementToBeVisible(By.xpath(QualificationsError));
        String qualificationMsg = common.getText(QualificationsError);
        common.assertTwoValuesAreEqual(qualificationMsg, "Qualifications is Required");
        common.logPrint("Error message is showing for the qualification field: " + qualificationMsg);

//        common.logPrint("Step:: Verify validation message for Employee");
//        common.waitUntilElementToBeVisible(By.xpath(EmployeeError));
//        String EmployeeMsg = common.getText(EmployeeError);
//        common.assertTwoValuesAreEqual(EmployeeMsg, "Employee is Required");
//        common.logPrint("Error message is showing for the Employee field: "+ EmployeeMsg);

        common.logPrint("Step:: Verify validation message for Product");
        common.waitUntilElementToBeVisible(By.xpath(ProductError));
        String ProductMsg = common.getText(ProductError);
        common.assertTwoValuesAreEqual(ProductMsg, "Product is Required");
        common.logPrint("Error message is showing for the Product field: " + ProductMsg);

        common.logPrint("Step:: Verify validation message for Mobile No.");
        common.waitUntilElementToBeVisible(By.xpath(MobileNoError));
        String MobileNoMsg = common.getText(MobileNoError);
        common.assertTwoValuesAreEqual(MobileNoMsg, "Mobile No is required");
        common.logPrint("Error message is showing for the Mobile No field: " + MobileNoMsg);

        common.scroll_To_Element(CityError);

        common.logPrint("Step:: Verify validation message for City");
        common.waitUntilElementToBeVisible(By.xpath(CityError));
        String CityMsg = common.getText(CityError);
        common.assertTwoValuesAreEqual(CityMsg, "Hospital City is Required");
        common.logPrint("Error message is showing for the City field: " + CityMsg);

        common.logPrint("Step:: Verify validation message for Pincode");
        common.waitUntilElementToBeVisible(By.xpath(PincodeError));
        String PincodeMsg = common.getText(PincodeError);
        common.assertTwoValuesAreEqual(PincodeMsg, "Hospital Pincode is Required");
        common.logPrint("Error message is showing for the Pincode field: " + PincodeMsg);

        common.logPrint("Step:: Verify validation message for City 2");
        common.waitUntilElementToBeVisible(By.xpath(City2Error));
        String City2Msg = common.getText(City2Error);
        common.assertTwoValuesAreEqual(City2Msg, "Residential City is Required");
        common.logPrint("Error message is showing for the City 2 field: " + City2Msg);

        common.logPrint("Step:: Verify validation message for Pincode 2");
        common.waitUntilElementToBeVisible(By.xpath(Pincode2Error));
        String Pincode2Msg = common.getText(Pincode2Error);
        common.assertTwoValuesAreEqual(Pincode2Msg, "Residential Pincode is Required");
        common.logPrint("Error message is showing for the Pincode 2 field: " + Pincode2Msg);
    }

    public void verifyValidationMessageForChemistCreationWithDirector() {

        common.logPrint("Verify Chemist creation screen fields and labels");
        //common.pause(1);
        if (common.isElementPresent(ADMINPANELMENU)) {
            common.logPrint("Step:: Click on the admin panel menu");
            common.click(ADMINPANELMENU);
        }

        //common.pause(2);
//        if (common.isElementPresent(BACKBTN)) {
//            common.logPrint("Step:: Click on the back button");
//            common.click(BACKBTN);
//        }

        common.logPrint("Verify mandatory fields validation for the chemist creation page");

        common.logPrint("Step:: Click on the admin menu");
        common.waitUntilElementToBeVisible(By.xpath(ADMINPANELMENU));
        common.click(ADMINPANELMENU);

        common.logPrint("Step:: Click on the Chemist menu");
        common.waitUntilElementToBeVisible(By.xpath(CHEMISTMENU));
        common.click(CHEMISTMENU);

        common.logPrint("Step:: Click on the ADD button");
        common.waitUntilElementToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step:: Click on the save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.logPrint("Step:: Verify all the validation message for mandatory fields");

        common.logPrint("Step:: Verify validation message for Chemist Name");
        common.waitUntilElementToBeVisible(By.xpath(DoctorError));
        String chemistMsg = common.getText(DoctorError);
        common.assertTwoValuesAreEqual(chemistMsg, "Chemist Name is required");
        common.logPrint("Error message is showing for the Chemist name: " + chemistMsg);

        common.logPrint("Step:: Verify validation message for Category");
        common.waitUntilElementToBeVisible(By.xpath(CategoryError));
        String categoryMsg = common.getText(CategoryError);
        common.assertTwoValuesAreEqual(categoryMsg, "Category is Required");
        common.logPrint("Error message is showing for the category name: " + categoryMsg);

        common.logPrint("Step:: Verify validation message for Chemist type");
        common.waitUntilElementToBeVisible(By.xpath(SpecialityError));
        String chemistTypeMsg = common.getText(SpecialityError);
        common.assertTwoValuesAreEqual(chemistTypeMsg, "Chemist Type is Required");
        common.logPrint("Error message is showing for the Chemist type: " + chemistTypeMsg);

        common.logPrint("Step:: Verify validation message for Mobile no.");
        common.waitUntilElementToBeVisible(By.xpath(QualificationsError));
        String mobileNoMsg = common.getText(QualificationsError);
        common.assertTwoValuesAreEqual(mobileNoMsg, "Mobile No is required");
        common.logPrint("Error message is showing for the Mobile no. field: " + mobileNoMsg);

        common.scroll_To_Element(CityError);

        common.logPrint("Step:: Verify validation message for City");
        common.waitUntilElementToBeVisible(By.xpath(CityError));
        String CityMsg = common.getText(CityError);
        common.assertTwoValuesAreEqual(CityMsg, "City is Required");
        common.logPrint("Error message is showing for the City field: " + CityMsg);

        common.logPrint("Step:: Verify validation message for Pincode");
        common.waitUntilElementToBeVisible(By.xpath(PincodeError));
        String PincodeMsg = common.getText(PincodeError);
        common.assertTwoValuesAreEqual(PincodeMsg, "Pincode is Required");
        common.logPrint("Error message is showing for the Pincode field: " + PincodeMsg);
    }

    public void verifyValidationMessageForStockistCreationWithDirector() {

        common.logPrint("Verify Stockist creation screen fields and labels");
        common.pause(1);
        if (common.isElementPresent(ADMINPANELMENU)) {
            common.logPrint("Step:: Click on the admin panel menu");
            common.click(ADMINPANELMENU);
        }

        //common.pause(2);
//        if (common.isElementPresent(BACKBTN)) {
//            common.logPrint("Step:: Click on the back button");
//            common.click(BACKBTN);
//        }

        common.logPrint("Verify mandatory fields validation for the chemist creation page");

        common.logPrint("Step:: Click on the admin menu");
        common.waitUntilElementToBeVisible(By.xpath(ADMINPANELMENU));
        common.click(ADMINPANELMENU);

        common.logPrint("Step:: Click on the Stockist menu");
        common.waitUntilElementToBeVisible(By.xpath(STOCKISTMENU));
        common.click(STOCKISTMENU);

        common.logPrint("Step:: Click on the ADD button");
        common.waitUntilElementToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step:: Click on the save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.logPrint("Step:: Verify all the validation message for mandatory fields");

        common.logPrint("Step:: Verify validation message for Stockist Name");
        common.waitUntilElementToBeVisible(By.xpath(DoctorError));
        String stockistMsg = common.getText(DoctorError);
        common.assertTwoValuesAreEqual(stockistMsg, "Stockist Name is required");
        common.logPrint("Error message is showing for the Stockist name: " + stockistMsg);

        common.logPrint("Step:: Verify validation message for Stockist type");
        common.waitUntilElementToBeVisible(By.xpath(CategoryError));
        String stockistTypeMsg = common.getText(CategoryError);
        common.assertTwoValuesAreEqual(stockistTypeMsg, "Stockist Type is Required");
        common.logPrint("Error message is showing for the Stockist type: " + stockistTypeMsg);

        common.logPrint("Step:: Verify validation message for Mobile no.");
        common.waitUntilElementToBeVisible(By.xpath(SpecialityError));
        String mobileNOMsg = common.getText(SpecialityError);
        common.assertTwoValuesAreEqual(mobileNOMsg, "Mobile No 1 is required");
        common.logPrint("Error message is showing for the Mobile no.: " + mobileNOMsg);

        common.scroll_To_Element(CityError);

        common.logPrint("Step:: Verify validation message for City");
        common.waitUntilElementToBeVisible(By.xpath(CityError));
        String CityMsg = common.getText(CityError);
        common.assertTwoValuesAreEqual(CityMsg, "City is Required");
        common.logPrint("Error message is showing for the City field: " + CityMsg);

        common.logPrint("Step:: Verify validation message for Pincode");
        common.waitUntilElementToBeVisible(By.xpath(PincodeError));
        String PincodeMsg = common.getText(PincodeError);
        common.assertTwoValuesAreEqual(PincodeMsg, "Pincode is Required");
        common.logPrint("Error message is showing for the Pincode field: " + PincodeMsg);
    }

    public void verifyValidationMessageForHospitalCreationWithDirector() {

        //common.pause(1);
        if (common.isElementPresent(ADMINPANELMENU)) {
            common.logPrint("Step:: Click on the admin panel menu");
            common.click(ADMINPANELMENU);
        }

        //common.pause(1);
//        if (common.isElementPresent(BACKBTN)) {
//            common.logPrint("Step:: Click on the back button");
//            common.click(BACKBTN);
//        }

        common.logPrint("Verify mandatory fields validation for the Hospital creation page");

        common.logPrint("Step:: Click on the admin menu");
        common.waitUntilElementToBeVisible(By.xpath(ADMINPANELMENU));
        common.click(ADMINPANELMENU);

        common.logPrint("Step:: Click on the Hospital menu");
        common.waitUntilElementToBeVisible(By.xpath(HOSPITALMENU));
        common.click(HOSPITALMENU);

        common.logPrint("Step:: Click on the ADD button");
        common.waitUntilElementToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step:: Click on the save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.logPrint("Step:: Verify all the validation message for mandatory fields");

        common.logPrint("Step:: Verify validation message for Hospital Name");
        common.waitUntilElementToBeVisible(By.xpath(DoctorError));
        String hospitalNameMsg = common.getText(DoctorError);
        common.assertTwoValuesAreEqual(hospitalNameMsg, "Hospital Name is required");
        common.logPrint("Error message is showing for the Hospital name: " + hospitalNameMsg);

        common.logPrint("Step:: Verify validation message for GST No.");
        common.waitUntilElementToBeVisible(By.xpath(CategoryError));
        String stockistTypeMsg = common.getText(CategoryError);
        common.assertTwoValuesAreEqual(stockistTypeMsg, "GST No. is required");
        common.logPrint("Error message is showing for the GST No. " + stockistTypeMsg);

        common.scroll_To_Element(CityError);

        common.logPrint("Step:: Verify validation message for City");
        common.waitUntilElementToBeVisible(By.xpath(CityError));
        String CityMsg = common.getText(CityError);
        common.assertTwoValuesAreEqual(CityMsg, "City is Required");
        common.logPrint("Error message is showing for the City field: " + CityMsg);

        common.logPrint("Step:: Verify validation message for Pincode");
        common.waitUntilElementToBeVisible(By.xpath(PincodeError));
        String PincodeMsg = common.getText(PincodeError);
        common.assertTwoValuesAreEqual(PincodeMsg, "Pincode is Required");
        common.logPrint("Error message is showing for the Pincode field: " + PincodeMsg);
    }

    public void verifyValidationMessageForProductCreationWithDirector() {

        if (common.isElementPresent(ADMINPANELMENU)) {
            common.logPrint("Step:: Click on the admin panel menu");
            common.click(ADMINPANELMENU);
        }

//        if (common.isElementPresent(BACKBTN)) {
//            common.logPrint("Step:: Click on the back button");
//            common.click(BACKBTN);
//        }

        common.logPrint("Verify mandatory fields validation for the Hospital creation page");

        common.logPrint("Step:: Click on the admin menu");
        common.waitUntilElementToBeVisible(By.xpath(ADMINPANELMENU));
        common.click(ADMINPANELMENU);

        common.logPrint("Step:: Click on the Product menu");
        common.waitUntilElementToBeVisible(By.xpath(PRODUCTMENU));
        common.click(PRODUCTMENU);

        common.logPrint("Step:: Click on the ADD button");
        common.waitUntilElementToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step:: Click on the save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.logPrint("Step:: Verify all the validation message for mandatory fields");

        common.logPrint("Step:: Verify validation message for Division dropdown");
        common.waitUntilElementToBeVisible(By.xpath(DoctorError));
        String divisionDrpMsg = common.getText(DoctorError);
        common.assertTwoValuesAreEqual(divisionDrpMsg, "Division is Required");
        common.logPrint("Error message is showing for the Division dropdown: " + divisionDrpMsg);

        common.logPrint("Step:: Verify validation message for Drug Head dropdown");
        common.waitUntilElementToBeVisible(By.xpath(CategoryError));
        String drugTypeMsg = common.getText(CategoryError);
        common.assertTwoValuesAreEqual(drugTypeMsg, "Drug Head is Required");
        common.logPrint("Error message is showing for the Drug Head type: " + drugTypeMsg);

        common.logPrint("Step:: Verify validation message for Product Line dropdown");
        common.waitUntilElementToBeVisible(By.xpath(SpecialityError));
        String productLineMsg = common.getText(SpecialityError);
        common.assertTwoValuesAreEqual(productLineMsg, "Product Line is Required");
        common.logPrint("Error message is showing for the Product Line dropdown: " + productLineMsg);

        common.logPrint("Step:: Verify validation message for Drug Head dropdown");
        common.waitUntilElementToBeVisible(By.xpath(QualificationsError));
        String productGrpupDrp = common.getText(QualificationsError);
        common.assertTwoValuesAreEqual(productGrpupDrp, "Product Group is Required");
        common.logPrint("Error message is showing for the Drug Head type: " + productGrpupDrp);

        common.logPrint("Step:: Verify validation message for Product Class dropdown");
        common.waitUntilElementToBeVisible(By.xpath(EmployeeError));
        String productClassTypeMsg = common.getText(EmployeeError);
        common.assertTwoValuesAreEqual(productClassTypeMsg, "Product Class is Required");
        common.logPrint("Error message is showing for the Product Class type: " + productClassTypeMsg);

        common.logPrint("Step:: Verify validation message for Product type dropdown");
        common.waitUntilElementToBeVisible(By.xpath(ProductError));
        String productTypeMsg = common.getText(ProductError);
        common.assertTwoValuesAreEqual(productTypeMsg, "Product Type is Required");
        common.logPrint("Error message is showing for the Product type dropdown: " + productTypeMsg);

        common.logPrint("Step:: Verify validation message for Short Name field");
        common.waitUntilElementToBeVisible(By.xpath(MobileNoError));
        String shortNameField = common.getText(MobileNoError);
        common.assertTwoValuesAreEqual(shortNameField, "Short Name is required");
        common.logPrint("Error message is showing for the Short Name field: " + shortNameField);

        common.logPrint("Step:: Verify validation message for Name field");
        common.waitUntilElementToBeVisible(By.xpath(nameError));
        String nameFieldMsg = common.getText(nameError);
        common.assertTwoValuesAreEqual(nameFieldMsg, "Name is required");
        common.logPrint("Error message is showing for the Name field: " + nameFieldMsg);

        common.logPrint("Step:: Verify validation message for Packing Type field");
        common.waitUntilElementToBeVisible(By.xpath(packingTypeError));
        String packingTypeMsg = common.getText(packingTypeError);
        common.assertTwoValuesAreEqual(packingTypeMsg, "Packing Type is Required");
        common.logPrint("Error message is showing for the Packing Type field: " + packingTypeMsg);

        common.logPrint("Step:: Verify validation message for HSN Code field");
        common.waitUntilElementToBeVisible(By.xpath(HSNCodeError));
        String hsnCodeMsg = common.getText(HSNCodeError);
        common.assertTwoValuesAreEqual(hsnCodeMsg, "Hsn code is required");
        common.logPrint("Error message is showing for the HSN Code field: " + hsnCodeMsg);

        common.logPrint("Step:: Verify validation message for PTR/PTS field");
        common.waitUntilElementToBeVisible(By.xpath(PTRPTSError));
        String ptrPtsMsg = common.getText(PTRPTSError);
        common.assertTwoValuesAreEqual(ptrPtsMsg, "PTR PTS Setting is Required");
        common.logPrint("Error message is showing for the PTR/PTS field: " + ptrPtsMsg);

        common.logPrint("Step:: Verify validation message for GST field");
        common.waitUntilElementToBeVisible(By.xpath(GSTError));
        String gstMsg = common.getText(GSTError);
        common.assertTwoValuesAreEqual(gstMsg, "GST is required");
        common.logPrint("Error message is showing for the GST field: " + gstMsg);

        common.logPrint("Step:: Verify validation message for MRP field");
        common.waitUntilElementToBeVisible(By.xpath(MRPError));
        String mrpMsg = common.getText(MRPError);
        common.assertTwoValuesAreEqual(mrpMsg, "MRP is required");
        common.logPrint("Error message is showing for the MRP field: " + mrpMsg);

        common.scroll_To_Element(ContentError);

        common.logPrint("Step:: Verify validation message for Content field");
        common.waitUntilElementToBeVisible(By.xpath(ContentError));
        String contentMsg = common.getText(ContentError);
        common.assertTwoValuesAreEqual(contentMsg, "Content is required");
        common.logPrint("Error message is showing for the Content field: " + contentMsg);
    }

    public void verifyValidationMessageForEmployeeCreationWithDirector() {

        if (common.isElementPresent(ADMINPANELMENU)) {
            common.logPrint("Step:: Click on the admin panel menu");
            common.click(ADMINPANELMENU);
        }

//        if (common.isElementPresent(BACKBTN)) {
//            common.logPrint("Step:: Click on the back button");
//            common.click(BACKBTN);
//        }

        common.logPrint("Verify mandatory fields validation for the Employee creation page");

        common.logPrint("Step:: Click on the admin menu");
        common.waitUntilElementToBeVisible(By.xpath(ADMINPANELMENU));
        common.click(ADMINPANELMENU);

        common.logPrint("Step:: Click on the Product menu");
        common.waitUntilElementToBeVisible(By.xpath(EMPLOYEEMENU));
        common.click(EMPLOYEEMENU);

        common.logPrint("Step:: Click on the ADD button");
        common.waitUntilElementToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step:: Click on the save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.logPrint("Step:: Verify all the validation message for mandatory fields");

        common.logPrint("Step:: Verify validation message for Name field");
        common.waitUntilElementToBeVisible(By.xpath(DoctorError));
        String nameMsg = common.getText(DoctorError);
        common.assertTwoValuesAreEqual(nameMsg, "Name is required");
        common.logPrint("Error message is showing for the Name field: " + nameMsg);

        common.logPrint("Step:: Verify validation message for Division dropdown");
        common.waitUntilElementToBeVisible(By.xpath(CategoryError));
        String divisionMsg = common.getText(CategoryError);
        common.assertTwoValuesAreEqual(divisionMsg, "Division is Required");
        common.logPrint("Error message is showing for the Division dropdown: " + divisionMsg);

        common.logPrint("Step:: Verify validation message for Phone Number field");
        common.waitUntilElementToBeVisible(By.xpath(SpecialityError));
        String phoneMsg = common.getText(SpecialityError);
        common.assertTwoValuesAreEqual(phoneMsg, "Phone Number Is Required");
        common.logPrint("Error message is showing for the Phone Number field: " + phoneMsg);

        common.logPrint("Step:: Verify validation message for Mobile No. field");
        common.waitUntilElementToBeVisible(By.xpath(QualificationsError));
        String mobileMsg = common.getText(QualificationsError);
        common.assertTwoValuesAreEqual(mobileMsg, "Mobile No. is required");
        common.logPrint("Error message is showing for the Mobile No. field: " + mobileMsg);

        common.logPrint("Step:: Verify validation message for Email field");
        common.waitUntilElementToBeVisible(By.xpath(EmployeeError));
        String emailMsg = common.getText(EmployeeError);
        common.assertTwoValuesAreEqual(emailMsg, "Email is required");
        common.logPrint("Error message is showing for the Email field: " + emailMsg);

        common.logPrint("Step:: Verify validation message for Joining Date field");
        common.waitUntilElementToBeVisible(By.xpath(ProductError));
        String joiningDateMsg = common.getText(ProductError);
        common.assertTwoValuesAreEqual(joiningDateMsg, "Joining Date is required.");
        common.logPrint("Error message is showing for the Joining Date field: " + joiningDateMsg);

        common.scroll_To_Element(CityError);

        common.logPrint("Step:: Verify validation message for City");
        common.waitUntilElementToBeVisible(By.xpath(CityError));
        String CityMsg = common.getText(CityError);
        common.assertTwoValuesAreEqual(CityMsg, "City is Required");
        common.logPrint("Error message is showing for the City field: " + CityMsg);

        common.logPrint("Step:: Verify validation message for Pincode");
        common.waitUntilElementToBeVisible(By.xpath(PincodeError));
        String PincodeMsg = common.getText(PincodeError);
        common.assertTwoValuesAreEqual(PincodeMsg, "Pincode is Required");
        common.logPrint("Error message is showing for the Pincode field: " + PincodeMsg);

        common.logPrint("Step:: Verify validation message for City 2");
        common.waitUntilElementToBeVisible(By.xpath(City2Error));
        String City2Msg = common.getText(City2Error);
        common.assertTwoValuesAreEqual(City2Msg, "City is Required");
        common.logPrint("Error message is showing for the City 2 field: " + City2Msg);

        common.logPrint("Step:: Verify validation message for Pincode 2");
        common.waitUntilElementToBeVisible(By.xpath(Pincode2Error));
        String Pincode2Msg = common.getText(Pincode2Error);
        common.assertTwoValuesAreEqual(Pincode2Msg, "Pincode is Required");
        common.logPrint("Error message is showing for the Pincode 2 field: " + Pincode2Msg);
    }

    public void verifyValidationMessageForAccountListModule() {

        if (common.isElementPresent(ADMINPANELMENU)) {
            common.logPrint("Step:: Click on the admin panel menu");
            common.click(ADMINPANELMENU);
        }
//
//        if (common.isElementPresent(BACKBTN)) {
//            common.logPrint("Step:: Click on the back button");
//            common.click(BACKBTN);
//        }

        common.logPrint("Verify mandatory fields validation for the Account List module");

        common.logPrint("Step:: Click on the admin menu");
        common.waitUntilElementToBeVisible(By.xpath(ADMINPANELMENU));
        common.click(ADMINPANELMENU);

        common.logPrint("Step:: Click on the Account List menu");
        common.waitUntilElementToBeVisible(By.xpath(ACCOUNTLISTMENU));
        common.click(ACCOUNTLISTMENU);

        common.logPrint("Step:: Click on the ADD button");
        common.waitUntilElementToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step:: Click on the save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.logPrint("Step:: Verify all the validation messages for mandatory fields");

        common.logPrint("Step:: Verify validation message for User Name field");
        common.waitUntilElementToBeVisible(By.xpath(DoctorError));
        String userNameMsg = common.getText(DoctorError);
        common.assertTwoValuesAreEqual(userNameMsg, "User name is required");
        common.logPrint("Error message is showing for the User Name field: " + userNameMsg);

        common.logPrint("Step:: Verify validation message for Hq field");
        common.waitUntilElementToBeVisible(By.xpath(CategoryError));
        String hqMsg = common.getText(CategoryError);
        common.assertTwoValuesAreEqual(hqMsg, "Hq is Required");
        common.logPrint("Error message is showing for the Hq field: " + hqMsg);

        common.logPrint("Step:: Verify validation message for Designation field");
        common.waitUntilElementToBeVisible(By.xpath(SpecialityError));
        String designationMsg = common.getText(SpecialityError);
        common.assertTwoValuesAreEqual(designationMsg, "Designation is Required");
        common.logPrint("Error message is showing for the Designation field: " + designationMsg);

        common.logPrint("Step:: Verify validation message for Employee field");
        common.waitUntilElementToBeVisible(By.xpath(QualificationsError));
        String employeeMsg = common.getText(QualificationsError);
        common.assertTwoValuesAreEqual(employeeMsg, "Employee is Required");
        common.logPrint("Error message is showing for the Employee field: " + employeeMsg);

        common.logPrint("Step:: Verify validation message for Role field");
        common.waitUntilElementToBeVisible(By.xpath(EmployeeError));
        String roleMsg = common.getText(EmployeeError);
        common.assertTwoValuesAreEqual(roleMsg, "Role is Required");
        common.logPrint("Error message is showing for the Role field: " + roleMsg);

        common.logPrint("Step:: Verify validation message for Reporting Senior field");
        common.waitUntilElementToBeVisible(By.xpath(ReportingSenior));
        String reportingSeniorMsg = common.getText(ReportingSenior);
        common.assertTwoValuesAreEqual(reportingSeniorMsg, "Reporting Senior is Required");
        common.logPrint("Error message is showing for the Reporting Senior field: " + reportingSeniorMsg);

        common.logPrint("Step:: Verify validation message for Zone field");
        common.waitUntilElementToBeVisible(By.xpath(zoneError));
        String zoneMsg = common.getText(zoneError);
        common.assertTwoValuesAreEqual(zoneMsg, "Zone is Required");
        common.logPrint("Error message is showing for the Zone field: " + zoneMsg);

        common.logPrint("Step:: Verify validation message for State field");
        common.waitUntilElementToBeVisible(By.xpath(stateError));
        String stateMsg = common.getText(stateError);
        common.assertTwoValuesAreEqual(stateMsg, "State is Required");
        common.logPrint("Error message is showing for the State field: " + stateMsg);

        common.logPrint("Step:: Verify validation message for Region field");
        common.waitUntilElementToBeVisible(By.xpath(regionError));
        String regionMsg = common.getText(regionError);
        common.assertTwoValuesAreEqual(regionMsg, "Region is Required");
        common.logPrint("Error message is showing for the Region field: " + regionMsg);

        common.logPrint("Step:: Verify validation message for District field");
        common.waitUntilElementToBeVisible(By.xpath(districtError));
        String districtMsg = common.getText(districtError);
        common.assertTwoValuesAreEqual(districtMsg, "District is Required");
        common.logPrint("Error message is showing for the District field: " + districtMsg);

        common.logPrint("Step:: Verify validation message for City field");
        common.waitUntilElementToBeVisible(By.xpath(cityError));
        String cityMsg = common.getText(cityError);
        common.assertTwoValuesAreEqual(cityMsg, "City is Required");
        common.logPrint("Error message is showing for the City field: " + cityMsg);
    }

    public void verifyValidationMessageForRoleModule() {

        if (common.isElementPresent(ADMINPANELMENU)) {
            common.logPrint("Step:: Click on the admin panel menu");
            common.click(ADMINPANELMENU);
        }

//        if (common.isElementPresent(BACKBTN)) {
//            common.logPrint("Step:: Click on the back button");
//            common.click(BACKBTN);
//        }

        common.logPrint("Verify mandatory fields validation for the Account List module");

        common.logPrint("Step:: Click on the admin menu");
        common.waitUntilElementToBeVisible(By.xpath(ADMINPANELMENU));
        common.click(ADMINPANELMENU);

        common.logPrint("Step:: Click on the Role. menu");
        common.waitUntilElementToBeVisible(By.xpath(ROLEMENU));
        common.click(ROLEMENU);

        common.logPrint("Step:: Click on the ADD button");
        common.waitUntilElementToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step:: Click on the save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.logPrint("Step:: Verify all the validation messages for mandatory fields");

        common.logPrint("Step:: Verify validation message for Role Name field");
        common.waitUntilElementToBeVisible(By.xpath(DoctorError));
        String roleNameMsg = common.getText(DoctorError);
        common.assertTwoValuesAreEqual(roleNameMsg, "Role Name is required");
        common.logPrint("Error message is showing for the Role Name field: " + roleNameMsg);

    }

    public void verifyValidationMessageForDesignationModule() {

        if (common.isElementPresent(ADMINPANELMENU)) {
            common.logPrint("Step:: Click on the admin panel menu");
            common.click(ADMINPANELMENU);
        }

//        if (common.isElementPresent(BACKBTN)) {
//            common.logPrint("Step:: Click on the back button");
//            common.click(BACKBTN);
//        }

        common.logPrint("Verify mandatory fields validation for the Account List module");

        common.logPrint("Step:: Click on the admin menu");
        common.waitUntilElementToBeVisible(By.xpath(ADMINPANELMENU));
        common.click(ADMINPANELMENU);

        common.logPrint("Step:: Click on the Designation menu");
        common.waitUntilElementToBeVisible(By.xpath(DESIGNATIONMENU));
        common.click(DESIGNATIONMENU);

        common.logPrint("Step:: Click on the ADD button");
        common.waitUntilElementToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step:: Click on the save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.logPrint("Step:: Verify all the validation messages for mandatory fields");

        common.logPrint("Step:: Verify validation message for Designation Name field");
        common.waitUntilElementToBeVisible(By.xpath(DoctorError));
        String DesignationNameMsg = common.getText(DoctorError);
        common.assertTwoValuesAreEqual(DesignationNameMsg, "Designation Name is required");
        common.logPrint("Error message is showing for the Designation Name field: " + DesignationNameMsg);

        common.logPrint("Step:: Verify validation message for Parent Designation field");
        common.waitUntilElementToBeVisible(By.xpath(CategoryError));
        String roleNameMsg = common.getText(CategoryError);
        common.assertTwoValuesAreEqual(roleNameMsg, "Parent Designation is Required");
        common.logPrint("Error message is showing for the Parent Designation field: " + roleNameMsg);
    }

    public void verifyAllTheButtonAndLabelIsPresentOnHeader() {

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

    public void verifyDoctorCreationFieldAndLabelsForLeadEntity() {

        common.logPrint("Step:: Click on the admin panel menu");
        common.assertElementDisplayed(ADMINPANELMENU);
        common.click(ADMINPANELMENU);

        common.logPrint("Step:: Verify all the sub-menu is showing");

        common.logPrint("Step:: Verify Doctor menu is present");
        common.assertElementDisplayed(DOCTORMENU);
        common.logPrint("Doctor menu is present on the admin panel");

        common.logPrint("Step:: Verify chemist menu is present");
        common.assertElementDisplayed(CHEMISTMENU);
        common.logPrint("Chemist menu is present on the admin panel");

        common.logPrint("Step:: Verify Stockist menu is present");
        common.assertElementDisplayed(STOCKISTMENU);
        common.logPrint("Stockist menu is present on the admin panel");

        common.logPrint("Step:: Verify Hospital menu is present");
        common.assertElementDisplayed(HOSPITALMENU);
        common.logPrint("Hospital menu is present on the admin panel");

        common.logPrint("Step:: Verify Product menu is present");
        common.assertElementDisplayed(PRODUCTMENU);
        common.logPrint("Product menu is present on the admin panel");

        common.logPrint("Step:: Verify Employee menu is present");
        common.assertElementDisplayed(EMPLOYEEMENU);
        common.logPrint("Employee menu is present on the admin panel");

        common.logPrint("Step:: Click on the Doctor menu");
        common.assertElementDisplayed(DOCTORMENU);
        common.click(DOCTORMENU);

        common.logPrint("Verify all the header buttons are present");
        verifyAllTheButtonAndLabelIsPresentOnHeader();

        common.logPrint("Step:: Verify Financial year dropdown label is present");
        common.assertElementDisplayed(FINANCIALYEARLBL);
        common.logPrint("Financial year dropdown label is present on the admin panel");

        common.logPrint("Step:: Verify Financial year dropdown is present");
        common.assertElementDisplayed(YEARDROPDOWN);
        common.logPrint("Financial year dropdown is present on the admin panel");

        common.logPrint("Step:: Verify sales graph is present in the screen");
        common.assertElementDisplayed(SALESGRAPHINADDDCR);
        common.logPrint("Sales graph is present on the page");

        common.logPrint("Step:: Verify HQ label is present");
        common.assertElementDisplayed(HQLABEL);
        common.logPrint("HQ label is present on the page");

        common.logPrint("Step:: Verify HQ dropdown is present");
        common.assertElementDisplayed(HQDROPDOWN);
        common.logPrint("HQ dropdown present on the page");

        common.logPrint("Step:: Verify search field is present");
        common.assertElementDisplayed(SEARCHFIELD);
        common.logPrint("Search field is present on the page");

        common.logPrint("Step:: Verify Fields on create doctor screen");

        common.logPrint("Step:: Click on the ADD button");
        common.assertElementDisplayed(ADDBTN);
        common.click(ADDBTN);

        common.logPrint("Step:: Verify Doctor Name label is present");
        common.assertElementDisplayed(DOCTORNAMELBL);
        common.logPrint("Doctor Name label is present");

        common.logPrint("Step:: Verify Doctor Name input field is present");
        common.assertElementDisplayed(DOCTORNAMEINP);
        common.logPrint("Doctor Name input field is present");

        common.logPrint("Step:: Verify Category label is present");
        common.assertElementDisplayed(CATEGORYLBL);
        common.logPrint("Category label is present");

        common.logPrint("Step:: Verify Category input field is present");
        common.assertElementDisplayed(CATEGORYINP);
        common.logPrint("Category input field is present");

        common.logPrint("Step:: Verify Speciality label is present");
        common.assertElementDisplayed(SPECIALITYLBL);
        common.logPrint("Speciality label is present");

        common.logPrint("Step:: Verify Speciality input field is present");
        common.assertElementDisplayed(SPECIALITYINP);
        common.logPrint("Speciality input field is present");

        common.logPrint("Step:: Verify Qualifications label is present");
        common.assertElementDisplayed(QUALIFICATIONSLBL);
        common.logPrint("Qualifications label is present");

        common.logPrint("Step:: Verify Qualifications input field is present");
        common.assertElementDisplayed(QUALIFICATIONSINP);
        common.logPrint("Qualifications input field is present");

        common.logPrint("Step:: Verify Employee label is present");
        common.assertElementDisplayed(EMPLOYEELBL);
        common.logPrint("Employee label is present");

        common.logPrint("Step:: Verify Employee input field is present");
        common.assertElementDisplayed(EMPLOYEEINP);
        common.logPrint("Employee input field is present");

        common.logPrint("Step:: Verify Product label is present");
        common.assertElementDisplayed(PRODUCTLBL);
        common.logPrint("Product label is present");

        common.logPrint("Step:: Verify Product input field is present");
        common.assertElementDisplayed(PRODUCTINP);
        common.logPrint("Product input field is present");

        common.logPrint("Step:: Verify Hospital Name label is present");
        common.assertElementDisplayed(HOSPITALNAMELBL);
        common.logPrint("Hospital Name label is present");

        common.logPrint("Step:: Verify Hospital Name input field is present");
        common.assertElementDisplayed(HOSPITALNAMEINP);
        common.logPrint("Hospital Name input field is present");

        common.logPrint("Step:: Verify Email label is present");
        common.assertElementDisplayed(EMAILLBL);
        common.logPrint("Email label is present");

        common.logPrint("Step:: Verify Email input field is present");
        common.assertElementDisplayed(EMAILINP);
        common.logPrint("Email input field is present");

        common.logPrint("Step:: Verify Mobile No. label is present");
        common.assertElementDisplayed(MOBILENOLBL);
        common.logPrint("Mobile No. label is present");

        common.logPrint("Step:: Verify Mobile No. input field is present");
        common.assertElementDisplayed(MOBILENOINP);
        common.logPrint("Mobile No. input field is present");

        common.logPrint("Step:: Verify Phone No label is present");
        common.assertElementDisplayed(PHONENOLBL);
        common.logPrint("Phone No label is present");

        common.logPrint("Step:: Verify Phone No input field is present");
        common.assertElementDisplayed(PHONENOINP);
        common.logPrint("Phone No input field is present");

        common.logPrint("Step:: Verify Website label is present");
        common.assertElementDisplayed(WEBSITELBL);
        common.logPrint("Website label is present");

        common.logPrint("Step:: Verify Website input field is present");
        common.assertElementDisplayed(WEBSITEINP);
        common.logPrint("Website input field is present");

        common.logPrint("Step:: Verify DOB label is present");
        common.assertElementDisplayed(DOBLBL);
        common.logPrint("DOB label is present");

        common.logPrint("Step:: Verify DOB input field is present");
        common.assertElementDisplayed(DOBINP);
        common.logPrint("DOB input field is present");

        common.logPrint("Step:: Verify DOA label is present");
        common.assertElementDisplayed(DOALBL);
        common.logPrint("DOA label is present");

        common.logPrint("Step:: Verify DOA input field is present");
        common.assertElementDisplayed(DOAINP);
        common.logPrint("DOA input field is present");

        common.logPrint("Step:: Verify PanCard Number label is present");
        common.assertElementDisplayed(PANCARDNOLBL);
        common.logPrint("PanCard Number label is present");

        common.logPrint("Step:: Verify PanCard Number input field is present");
        common.assertElementDisplayed(PANCARDNOINP);
        common.logPrint("PanCard Number input field is present");

        common.logPrint("Step:: Verify Registration Number label is present");
        common.assertElementDisplayed(REGISTRATIONNOLBL);
        common.logPrint("Registration Number label is present");

        common.logPrint("Step:: Verify Registration Number input field is present");
        common.assertElementDisplayed(REGISTRATIONNOINP);
        common.logPrint("Registration Number input field is present");

        common.logPrint("Step:: Verify Software Name label is present");
        common.assertElementDisplayed(SOFTWARENAMELBL);
        common.logPrint("Software Name label is present");

        common.logPrint("Step:: Verify Software Name input field is present");
        common.assertElementDisplayed(SOFTWARENAMEINP);
        common.logPrint("Software Name input field is present");

        common.logPrint("Step:: Verify Role in Hospital label is present");
        common.assertElementDisplayed(ROLEINHOSPITALLBL);
        common.logPrint("Role in Hospital label is present");

        common.logPrint("Step:: Verify Role in Hospital input field is present");
        common.assertElementDisplayed(ROLEINHOSPITALINP);
        common.logPrint("Role in Hospital input field is present");

        common.logPrint("Step:: Verify Patients Daily label is present");
        common.assertElementDisplayed(PATIENTSDAILYLBL);
        common.logPrint("Patients Daily label is present");

        common.logPrint("Step:: Verify Patients Daily input field is present");
        common.assertElementDisplayed(PATIENTSDAILYINP);
        common.logPrint("Patients Daily input field is present");

        common.logPrint("Step:: Verify Patients Weekly label is present");
        common.assertElementDisplayed(PATIENTSWEEKLYLBL);
        common.logPrint("Patients Weekly label is present");

        common.logPrint("Step:: Verify Patients Weekly input field is present");
        common.assertElementDisplayed(PATIENTSWEEKLYINP);
        common.logPrint("Patients Weekly input field is present");

        common.logPrint("Step:: Verify Patients Monthly label is present");
        common.assertElementDisplayed(PATIENTSMONTHLYLBL);
        common.logPrint("Patients Monthly label is present");

        common.logPrint("Step:: Verify Patients Monthly input field is present");
        common.assertElementDisplayed(PATIENTSMONTHLYINP);
        common.logPrint("Patients Monthly input field is present");

        common.logPrint("Step:: Verify Preferred Call Time label is present");
        common.assertElementDisplayed(PREFERREDCALLTIMELBL);
        common.logPrint("Preferred Call Time label is present");

        common.logPrint("Step:: Verify Preferred Call Time input field is present");
        common.assertElementDisplayed(PREFERREDCALLTIMEINP);
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
        common.assertElementDisplayed(ADDRESSLINE1LBL1);
        common.logPrint("Address Line 1 label is present");

        common.logPrint("Step:: Verify Address Line 1 input field is present");
        common.assertElementDisplayed(ADDRESSLINE1INP1);
        common.logPrint("Address Line 1 input field is present");

        common.logPrint("Step:: Verify Area label is present");
        common.assertElementDisplayed(AREALBL);
        common.logPrint("Area label is present");

        common.logPrint("Step:: Verify Area input field is present");
        common.assertElementDisplayed(AREAINP);
        common.logPrint("Area input field is present");

        common.logPrint("Step:: Verify City label is present");
        common.assertElementDisplayed(CITYLBL);
        common.logPrint("City label is present");

        common.logPrint("Step:: Verify City input field is present");
        common.assertElementDisplayed(CITYINP);
        common.logPrint("City input field is present");

        common.logPrint("Step:: Verify Pincode label is present");
        common.assertElementDisplayed(PINCODELBL);
        common.logPrint("Pincode label is present");

        common.logPrint("Step:: Verify Pincode input field is present");
        common.assertElementDisplayed(PINCODEINP);
        common.logPrint("Pin code input field is present");

        if (common.findElement(BACKBTN).isDisplayed()) {
            common.click(BACKBTN);
        }
    }

    public void verifyChemistCreationFieldAndLabelsForLeadEntity() {

        common.logPrint("Verify Chemist creation screen fields and labels");
        if (common.isElementPresent(ADMINPANELMENU)) {
            common.logPrint("Step:: Click on the admin panel menu");
            common.click(ADMINPANELMENU);
        }

        common.pause(2);
        if (common.isElementPresent(BACKBTN)) {
            common.logPrint("Step:: Click on the back button");
            common.click(BACKBTN);
        }

        common.logPrint("Step:: Click on the chemist menu");
        common.waitUntilElementToBeVisible(By.xpath(CHEMISTMENU));
        common.click(CHEMISTMENU);

        common.logPrint("Step:: Verify all the buttons and labels are present on header");
        verifyAllTheButtonAndLabelIsPresentOnHeader();

        common.waitUntilElementsToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step:: Verify that chemist name label is present");
        common.waitUntilElementsToBeVisible(By.xpath(CHEMISTNAMELBL));
        common.assertElementDisplayed(CHEMISTNAMELBL);
        common.logPrint("Chemist name is present on the page");

        common.logPrint("Step:: Verify that chemist input field is present");
        common.waitUntilElementsToBeVisible(By.xpath(CHEMISTNAMEINP));
        common.assertElementDisplayed(CHEMISTNAMEINP);
        common.logPrint("chemist input field is present on the page");

        common.logPrint("Step:: Verify that category label is present");
        common.waitUntilElementsToBeVisible(By.xpath(CATEGORYLBL));
        common.assertElementDisplayed(CATEGORYLBL);
        common.logPrint("Category label is present on the page");

        common.logPrint("Step:: Verify that category input field is present");
        common.waitUntilElementsToBeVisible(By.xpath(CATEGORYINP));
        common.assertElementDisplayed(CATEGORYINP);
        common.logPrint("Category input field is present on the page");

        common.logPrint("Step:: Verify that chemist type label is present");
        common.waitUntilElementsToBeVisible(By.xpath(CHEMISTTYPELBL));
        common.assertElementDisplayed(CHEMISTTYPELBL);
        common.logPrint("Chemist type label is present on the page");

        common.logPrint("Step:: Verify that chemist type input field is present");
        common.waitUntilElementsToBeVisible(By.xpath(CHEMISTTYPEINP));
        common.assertElementDisplayed(CHEMISTTYPEINP);
        common.logPrint("Chemist type input field is present on the page");

        common.logPrint("Step:: Verify that mobile number label is present");
        common.waitUntilElementsToBeVisible(By.xpath(MOBILENOLBL));
        common.assertElementDisplayed(MOBILENOLBL);
        common.logPrint("Mobile number label is present on the page");

        common.logPrint("Step:: Verify that mobile number input field is present");
        common.waitUntilElementsToBeVisible(By.xpath(MOBILENOINP));
        common.assertElementDisplayed(MOBILENOINP);
        common.logPrint("Mobile number input field is present on the page");

        common.logPrint("Step:: Verify that phone number label is present");
        common.waitUntilElementsToBeVisible(By.xpath(PHONENOLBL));
        common.assertElementDisplayed(PHONENOLBL);
        common.logPrint("Phone number label is present on the page");

        common.logPrint("Step:: Verify that phone number input field is present");
        common.waitUntilElementsToBeVisible(By.xpath(PHONENOINP));
        common.assertElementDisplayed(PHONENOINP);
        common.logPrint("Phone number input field is present on the page");

        common.logPrint("Step:: Verify that potential business label is present");
        common.waitUntilElementsToBeVisible(By.xpath(POTENTIALBUSINESSLBL));
        common.assertElementDisplayed(POTENTIALBUSINESSLBL);
        common.logPrint("Potential business label is present on the page");

        common.logPrint("Step:: Verify that potential business input field is present");
        common.waitUntilElementsToBeVisible(By.xpath(POTENTIALBUSINESSINP));
        common.assertElementDisplayed(POTENTIALBUSINESSINP);
        common.logPrint("Potential business input field is present on the page");

        common.logPrint("Step:: Verify that DL No1 label is present");
        common.waitUntilElementsToBeVisible(By.xpath(DLNO1LBL));
        common.assertElementDisplayed(DLNO1LBL);
        common.logPrint("DL No1 label is present on the page");

        common.logPrint("Step:: Verify that DL No1 input field is present");
        common.waitUntilElementsToBeVisible(By.xpath(DLNO1INP));
        common.assertElementDisplayed(DLNO1INP);
        common.logPrint("DL No1 input field is present on the page");

        common.logPrint("Step:: Verify that DL No2 label is present");
        common.waitUntilElementsToBeVisible(By.xpath(DLNO2LBL));
        common.assertElementDisplayed(DLNO2LBL);
        common.logPrint("DL No2 label is present on the page");

        common.logPrint("Step:: Verify that DL No2 input field is present");
        common.waitUntilElementsToBeVisible(By.xpath(DLNO2INP));
        common.assertElementDisplayed(DLNO2INP);
        common.logPrint("DL No2 input field is present on the page");

        common.logPrint("Step:: Verify that email label is present");
        common.waitUntilElementsToBeVisible(By.xpath(EMAILLBL));
        common.assertElementDisplayed(EMAILLBL);
        common.logPrint("Email label is present on the page");

        common.logPrint("Step:: Verify that email input field is present");
        common.waitUntilElementsToBeVisible(By.xpath(EMAILINP));
        common.assertElementDisplayed(EMAILINP);
        common.logPrint("Email input field is present on the page");

        common.logPrint("Step:: Verify that stockist label is present");
        common.waitUntilElementsToBeVisible(By.xpath(STOCKISTLBL));
        common.assertElementDisplayed(STOCKISTLBL);
        common.logPrint("Stockist label is present on the page");

        common.logPrint("Step:: Verify that stockist input field is present");
        common.waitUntilElementsToBeVisible(By.xpath(STOCKISTINP));
        common.assertElementDisplayed(STOCKISTINP);
        common.logPrint("Stockist input field is present on the page");

        common.logPrint("Step:: Verify that GST No label is present");
        common.waitUntilElementsToBeVisible(By.xpath(GSTNOLBL));
        common.assertElementDisplayed(GSTNOLBL);
        common.logPrint("GST No label is present on the page");

        common.logPrint("Step:: Verify that GST No input field is present");
        common.waitUntilElementsToBeVisible(By.xpath(GSTNOINP));
        common.assertElementDisplayed(GSTNOINP);
        common.logPrint("GST No input field is present on the page");

        common.logPrint("Step:: Verify that FSSAI label is present");
        common.waitUntilElementsToBeVisible(By.xpath(FSSAILBL));
        common.assertElementDisplayed(FSSAILBL);
        common.logPrint("FSSAI label is present on the page");

        common.logPrint("Step:: Verify that FSSAI input field is present");
        common.waitUntilElementsToBeVisible(By.xpath(FSSAIINP));
        common.assertElementDisplayed(FSSAIINP);
        common.logPrint("FSSAI input field is present on the page");

        common.logPrint("Step:: Verify that NRX label is present");
        common.waitUntilElementsToBeVisible(By.xpath(NRXLBL));
        common.assertElementDisplayed(NRXLBL);
        common.logPrint("NRX label is present on the page");

        common.logPrint("Step:: Verify that NRX input field is present");
        common.waitUntilElementsToBeVisible(By.xpath(NRXINP));
        common.assertElementDisplayed(NRXINP);
        common.logPrint("NRX input field is present on the page");

        common.logPrint("Step:: Verify that employee label is present");
        common.waitUntilElementsToBeVisible(By.xpath(EMPLOYEELBLCHE));
        common.assertElementDisplayed(EMPLOYEELBLCHE);
        common.logPrint("Employee label is present on the page");

        common.logPrint("Step:: Verify that employee input field is present");
        common.waitUntilElementsToBeVisible(By.xpath(EMPLOYEEINPCHE));
        common.assertElementDisplayed(EMPLOYEEINPCHE);
        common.logPrint("Employee input field is present on the page");

        common.logPrint("Step:: Verify that doctor label is present");
        common.waitUntilElementsToBeVisible(By.xpath(DOCTORLBL));
        common.assertElementDisplayed(DOCTORLBL);
        common.logPrint("Doctor label is present on the page");

        common.logPrint("Step:: Verify that doctor input field is present");
        common.waitUntilElementsToBeVisible(By.xpath(DOCTORINP));
        common.assertElementDisplayed(DOCTORINP);
        common.logPrint("Doctor input field is present on the page");

        common.logPrint("Step:: Verify that address line 1 label is present");
        common.waitUntilElementsToBeVisible(By.xpath(ADDRESSLINE1LBL1));
        common.assertElementDisplayed(ADDRESSLINE1LBL1);
        common.logPrint("Address Line 1 label is present on the page");

        common.logPrint("Step:: Verify that address line 1 input field is present");
        common.waitUntilElementsToBeVisible(By.xpath(ADDRESSLINE1INP1));
        common.assertElementDisplayed(ADDRESSLINE1INP1);
        common.logPrint("Address Line 1 input field is present on the page");

        common.logPrint("Step:: Verify that area label is present");
        common.waitUntilElementsToBeVisible(By.xpath(AREALBL));
        common.assertElementDisplayed(AREALBL);
        common.logPrint("Area label is present on the page");

        common.logPrint("Step:: Verify that area input field is present");
        common.waitUntilElementsToBeVisible(By.xpath(AREAINP));
        common.assertElementDisplayed(AREAINP);
        common.logPrint("Area input field is present on the page");

        common.logPrint("Step:: Verify that city label is present");
        common.waitUntilElementsToBeVisible(By.xpath(CITYLBL));
        common.assertElementDisplayed(CITYLBL);
        common.logPrint("City label is present on the page");

        common.logPrint("Step:: Verify that city input field is present");
        common.waitUntilElementsToBeVisible(By.xpath(CITYINP));
        common.assertElementDisplayed(CITYINP);
        common.logPrint("City input field is present on the page");

        common.logPrint("Step:: Verify that pincode label is present");
        common.waitUntilElementsToBeVisible(By.xpath(PINCODELBL));
        common.assertElementDisplayed(PINCODELBL);
        common.logPrint("Pincode label is present on the page");

        common.logPrint("Step:: Verify that pincode input field is present");
        common.waitUntilElementsToBeVisible(By.xpath(PINCODEINP));
        common.assertElementDisplayed(PINCODEINP);
        common.logPrint("Pincode input field is present on the page");
    }

    public void verifyStockistCreationFieldAndLabelsForLeadEntity() {

        common.logPrint("Verify Stockist creation screen fields and labels");
        if (common.isElementPresent(ADMINPANELMENU)) {
            common.logPrint("Step:: Click on the admin panel menu");
            common.click(ADMINPANELMENU);
        }

        common.pause(2);
        if (common.isElementPresent(BACKBTN)) {
            common.logPrint("Step:: Click on the back button");
            common.click(BACKBTN);
        }

        common.logPrint("Step:: Click on the chemist menu");
        common.waitUntilElementToBeVisible(By.xpath(STOCKISTMENU));
        common.click(STOCKISTMENU);

        common.logPrint("Step:: Verify all the buttons and labels are present on header");
        verifyAllTheButtonAndLabelIsPresentOnHeader();

        common.logPrint("Step:: Click on the add button");
        common.waitUntilElementsToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step:: Verify that stockist name label is present");
        common.waitUntilElementsToBeVisible(By.xpath(STOCKISTNAMELBL));
        common.assertElementDisplayed(STOCKISTNAMELBL);
        common.logPrint("Stockist name label is present on the page");

        common.logPrint("Step:: Verify that stockist name input field is present");
        common.waitUntilElementsToBeVisible(By.xpath(STOCKISTNAMEINP));
        common.assertElementDisplayed(STOCKISTNAMEINP);
        common.logPrint("Stockist name input field is present on the page");

        common.logPrint("Step:: Verify that stockist type label is present");
        common.waitUntilElementsToBeVisible(By.xpath(STOCKISTTYPELBL));
        common.assertElementDisplayed(STOCKISTTYPELBL);
        common.logPrint("Stockist type label is present on the page");

        common.logPrint("Step:: Verify that stockist type input field is present");
        common.waitUntilElementsToBeVisible(By.xpath(STOCKISTTYPEINP));
        common.assertElementDisplayed(STOCKISTTYPEINP);
        common.logPrint("Stockist type input field is present on the page");

        common.logPrint("Step:: Verify that mobile no. 1 label is present");
        common.waitUntilElementsToBeVisible(By.xpath(MOBILENO1LBLSTO));
        common.assertElementDisplayed(MOBILENO1LBLSTO);
        common.logPrint("Mobile no. 1 label is present on the page");

        common.logPrint("Step:: Verify that mobile no. 1 input field is present");
        common.waitUntilElementsToBeVisible(By.xpath(MOBILENO1INPSTO));
        common.assertElementDisplayed(MOBILENO1INPSTO);
        common.logPrint("Mobile no. 1 input field is present on the page");

        common.logPrint("Step:: Verify that mobile no. 2 label is present");
        common.waitUntilElementsToBeVisible(By.xpath(MOBILENO2LBL));
        common.assertElementDisplayed(MOBILENO2LBL);
        common.logPrint("Mobile no. 2 label is present on the page");

        common.logPrint("Step:: Verify that mobile no. 2 input field is present");
        common.waitUntilElementsToBeVisible(By.xpath(MOBILENO2INP));
        common.assertElementDisplayed(MOBILENO2INP);
        common.logPrint("Mobile no. 2 input field is present on the page");

        common.logPrint("Step:: Verify that mobile no. 3 label is present");
        common.waitUntilElementsToBeVisible(By.xpath(MOBILENO3LBL));
        common.assertElementDisplayed(MOBILENO3LBL);
        common.logPrint("Mobile no. 3 label is present on the page");

        common.logPrint("Step:: Verify that mobile no. 3 input field is present");
        common.waitUntilElementsToBeVisible(By.xpath(MOBILENO3INP));
        common.assertElementDisplayed(MOBILENO3INP);
        common.logPrint("Mobile no. 3 input field is present on the page");

        common.logPrint("Step:: Verify that phone no. label field is present");
        common.waitUntilElementsToBeVisible(By.xpath(PHONENOLBL));
        common.assertElementDisplayed(PHONENOLBL);
        common.logPrint("Phone no. label is present on the page");

        common.logPrint("Step:: Verify that phone input field is present");
        common.waitUntilElementsToBeVisible(By.xpath(PHONENOINP));
        common.assertElementDisplayed(PHONENOINP);
        common.logPrint("Phone no. input field is present on the page");

        common.logPrint("Step:: Verify that place label is present");
        common.waitUntilElementsToBeVisible(By.xpath(PLACELBL));
        common.assertElementDisplayed(PLACELBL);
        common.logPrint("Place label is present on the page");

        common.logPrint("Step:: Verify that place input field is present");
        common.waitUntilElementsToBeVisible(By.xpath(PLACEINP));
        common.assertElementDisplayed(PLACEINP);
        common.logPrint("Place input field is present on the page");

        common.logPrint("Step:: Verify that CFA location label is present");
        common.waitUntilElementsToBeVisible(By.xpath(CFALOCATIONLBL));
        common.assertElementDisplayed(CFALOCATIONLBL);
        common.logPrint("CFA location label is present on the page");

        common.logPrint("Step:: Verify that CFA location input field is present");
        common.waitUntilElementsToBeVisible(By.xpath(CFALOCATIONINP));
        common.assertElementDisplayed(CFALOCATIONINP);
        common.logPrint("CFA location input field is present on the page");

        common.logPrint("Step:: Verify that contact person label is present");
        common.waitUntilElementsToBeVisible(By.xpath(CONTACTPERSONLBL));
        common.assertElementDisplayed(CONTACTPERSONLBL);
        common.logPrint("Contact person label is present on the page");

        common.logPrint("Step:: Verify that contact person input field is present");
        common.waitUntilElementsToBeVisible(By.xpath(CONTACTPERSONINP));
        common.assertElementDisplayed(CONTACTPERSONINP);
        common.logPrint("Contact person input field is present on the page");

        common.logPrint("Step:: Verify Email label is present");
        common.waitUntilElementToBeVisible(By.xpath(EMAILLBL));
        common.logPrint("Email label is present");

        common.logPrint("Step:: Verify Email input field is present");
        common.waitUntilElementToBeVisible(By.xpath(EMAILINP));
        common.logPrint("Email input field is present");

        common.logPrint("Step:: Verify that DL No1 label is present");
        common.waitUntilElementsToBeVisible(By.xpath(DLNO1LBL));
        common.assertElementDisplayed(DLNO1LBL);
        common.logPrint("DL No1 label is present on the page");

        common.logPrint("Step:: Verify that DL No1 input field is present");
        common.waitUntilElementsToBeVisible(By.xpath(DLNO1INP));
        common.assertElementDisplayed(DLNO1INP);
        common.logPrint("DL No1 input field is present on the page");

        common.logPrint("Step:: Verify that DL No2 label is present");
        common.waitUntilElementsToBeVisible(By.xpath(DLNO2LBL));
        common.assertElementDisplayed(DLNO2LBL);
        common.logPrint("DL No2 label is present on the page");

        common.logPrint("Step:: Verify that DL No2 input field is present");
        common.waitUntilElementsToBeVisible(By.xpath(DLNO2INP));
        common.assertElementDisplayed(DLNO2INP);
        common.logPrint("DL No2 input field is present on the page");

        common.logPrint("Step:: Verify that FSSAI label is present");
        common.waitUntilElementsToBeVisible(By.xpath(FSSAILBL));
        common.assertElementDisplayed(FSSAILBL);
        common.logPrint("FSSAI label is present on the page");

        common.logPrint("Step:: Verify that FSSAI input field is present");
        common.waitUntilElementsToBeVisible(By.xpath(FSSAIINP));
        common.assertElementDisplayed(FSSAIINP);
        common.logPrint("FSSAI input field is present on the page");

        common.logPrint("Step:: Verify that GST No label is present");
        common.waitUntilElementsToBeVisible(By.xpath(GSTNOLBL));
        common.assertElementDisplayed(GSTNOLBL);
        common.logPrint("GST No label is present on the page");

        common.logPrint("Step:: Verify that GST No input field is present");
        common.waitUntilElementsToBeVisible(By.xpath(GSTNOINP));
        common.assertElementDisplayed(GSTNOINP);
        common.logPrint("GST No input field is present on the page");

        common.logPrint("Step:: Verify that employee label is present");
        common.waitUntilElementsToBeVisible(By.xpath(EMPLOYEELBLCHE));
        common.assertElementDisplayed(EMPLOYEELBLCHE);
        common.logPrint("Employee label is present on the page");

        common.logPrint("Step:: Verify that employee input field is present");
        common.waitUntilElementsToBeVisible(By.xpath(EMPLOYEEINPCHE));
        common.assertElementDisplayed(EMPLOYEEINPCHE);
        common.logPrint("Employee input field is present on the page");

        common.logPrint("Step:: Verify that code reference label is present");
        common.waitUntilElementsToBeVisible(By.xpath(CODEREFLBL));
        common.assertElementDisplayed(CODEREFLBL);
        common.logPrint("Code reference label is present on the page");

        common.logPrint("Step:: Verify that code reference input field is present");
        common.waitUntilElementsToBeVisible(By.xpath(CODEREFINP));
        common.assertElementDisplayed(CODEREFINP);
        common.logPrint("Code reference input field is present on the page");

        common.logPrint("Step:: Verify that address line 1 label is present");
        common.waitUntilElementsToBeVisible(By.xpath(ADDRESSLINE1LBL1));
        common.assertElementDisplayed(ADDRESSLINE1LBL1);
        common.logPrint("Address Line 1 label is present on the page");

        common.logPrint("Step:: Verify that address line 1 input field is present");
        common.waitUntilElementsToBeVisible(By.xpath(ADDRESSLINE1INP1));
        common.assertElementDisplayed(ADDRESSLINE1INP1);
        common.logPrint("Address Line 1 input field is present on the page");

        common.logPrint("Step:: Verify that area label is present");
        common.waitUntilElementsToBeVisible(By.xpath(AREALBL));
        common.assertElementDisplayed(AREALBL);
        common.logPrint("Area label is present on the page");

        common.logPrint("Step:: Verify that area input field is present");
        common.waitUntilElementsToBeVisible(By.xpath(AREAINP));
        common.assertElementDisplayed(AREAINP);
        common.logPrint("Area input field is present on the page");

        common.logPrint("Step:: Verify that city label is present");
        common.waitUntilElementsToBeVisible(By.xpath(CITYLBL));
        common.assertElementDisplayed(CITYLBL);
        common.logPrint("City label is present on the page");

        common.logPrint("Step:: Verify that city input field is present");
        common.waitUntilElementsToBeVisible(By.xpath(CITYINP));
        common.assertElementDisplayed(CITYINP);
        common.logPrint("City input field is present on the page");

        common.logPrint("Step:: Verify that pincode label is present");
        common.waitUntilElementsToBeVisible(By.xpath(PINCODELBL));
        common.assertElementDisplayed(PINCODELBL);
        common.logPrint("Pincode label is present on the page");

        common.logPrint("Step:: Verify that pincode input field is present");
        common.waitUntilElementsToBeVisible(By.xpath(PINCODEINP));
        common.assertElementDisplayed(PINCODEINP);
        common.logPrint("Pincode input field is present on the page");
    }

    public void verifyHospitalCreationFieldsAndLabels() {
        common.logPrint("Verify Hospital creation screen fields and labels");

        if (common.isElementPresent(ADMINPANELMENU)) {
            common.logPrint("Step:: Click on the admin panel menu");
            common.click(ADMINPANELMENU);
        }

        common.pause(2);
        if (common.isElementPresent(BACKBTN)) {
            common.logPrint("Step:: Click on the back button");
            common.click(BACKBTN);
        }

        common.logPrint("Step:: Click on the hospital menu");
        common.waitUntilElementToBeVisible(By.xpath(HOSPITALMENU)); // Replace with actual hospital menu XPath
        common.click(HOSPITALMENU);

        common.logPrint("Step:: Click on the add button");
        common.waitUntilElementsToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step:: Verify that Hospital Name label is present");
        common.waitUntilElementsToBeVisible(By.xpath(HOSPITALLABEL));
        common.assertElementDisplayed(HOSPITALLABEL);
        common.logPrint("Hospital Name label is present on the page");

        common.logPrint("Step:: Verify that Hospital Name input field is present");
        common.waitUntilElementsToBeVisible(By.xpath(HOSPITALINP));
        common.assertElementDisplayed(HOSPITALINP);
        common.logPrint("Hospital Name input field is present on the page");

        common.logPrint("Step:: Verify that GST No. label is present");
        common.waitUntilElementsToBeVisible(By.xpath(GSTLABEL));
        common.assertElementDisplayed(GSTLABEL);
        common.logPrint("GST No. label is present on the page");

        common.logPrint("Step:: Verify that GST No. input field is present");
        common.waitUntilElementsToBeVisible(By.xpath(GSTINP));
        common.assertElementDisplayed(GSTINP);
        common.logPrint("GST No. input field is present on the page");

        common.logPrint("Step:: Verify that Address Line 1 label is present");
        common.waitUntilElementsToBeVisible(By.xpath(ADDRESSLINE1));
        common.assertElementDisplayed(ADDRESSLINE1);
        common.logPrint("Address Line 1 label is present on the page");

        common.logPrint("Step:: Verify that Address Line 1 input field is present");
        common.waitUntilElementsToBeVisible(By.xpath(ADDRESSLINEINP));
        common.assertElementDisplayed(ADDRESSLINEINP);
        common.logPrint("Address Line 1 input field is present on the page");

        common.logPrint("Step:: Verify that Area label is present");
        common.waitUntilElementsToBeVisible(By.xpath(AREALLBL));
        common.assertElementDisplayed(AREALLBL);
        common.logPrint("Area label is displayed");

        common.logPrint("Step:: Verify that Area label is present");
        common.waitUntilElementsToBeVisible(By.xpath(AREAINPUT));
        common.assertElementDisplayed(AREAINPUT);
        common.logPrint("Area input field is displayed properly");

        common.logPrint("Step:: Verify that city input field is present");
        common.waitUntilElementsToBeVisible(By.xpath(CITYINP));
        common.assertElementDisplayed(CITYINP);
        common.logPrint("City input field is present on the page");

        common.logPrint("Step:: Verify that pincode label is present");
        common.waitUntilElementsToBeVisible(By.xpath(PINCODELBL));
        common.assertElementDisplayed(PINCODELBL);
        common.logPrint("Pincode label is present on the page");
    }

    public void verifyAccountCreationFieldsAndLabels() {
        common.logPrint("Verify Account creation screen fields and labels");

        // Navigate to the Account creation screen as needed (menu clicks etc.)

        if (common.isElementPresent(ADMINPANELMENU)) {
            common.logPrint("Step:: Click on the admin panel menu");
            common.click(ADMINPANELMENU);
        }

        common.pause(2);
        if (common.isElementPresent(BACKBTN)) {
            common.logPrint("Step:: Click on the back button");
            common.click(BACKBTN);
        }

        common.logPrint("Step:: Click on the hospital menu");
        common.waitUntilElementToBeVisible(By.xpath(ACCOUNTLISTMENU));
        common.click(ACCOUNTLISTMENU);

        common.logPrint("Step:: Click on the add button");
        common.waitUntilElementsToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step:: Verify that User Name label is present");
        common.assertElementDisplayed(USERNAMELABELAC);
        common.logPrint("Step:: Verify that User Name input field is present");
        common.assertElementDisplayed(USERNAME);

        common.logPrint("Step:: Verify that HQ label is present");
        common.assertElementDisplayed(HQLBEL);
        common.logPrint("Step:: Verify that HQ input field is present");
        common.assertElementDisplayed(HQINP);

        common.logPrint("Step:: Verify that Designation label is present");
        common.assertElementDisplayed(DESIGNATIONLBL);
        common.logPrint("Step:: Verify that Designation input field is present");
        common.assertElementDisplayed(DESIGNATIONINP);

        common.logPrint("Step:: Verify that Employee label is present");
        common.assertElementDisplayed(EMPLOYEELBLAC);
        common.logPrint("Step:: Verify that Employee input field is present");
        common.assertElementDisplayed(EMPLOYEEINPEMP);

        common.logPrint("Step:: Verify that Role label is present");
        common.assertElementDisplayed(ROLELABEL);
        common.logPrint("Step:: Verify that Role input field is present");
        common.assertElementDisplayed(ROLEINP);

        common.logPrint("Step:: Verify that Reporting Senior label is present");
        common.assertElementDisplayed(REPORTINGSENIOR);
        common.logPrint("Step:: Verify that Reporting Senior input field is present");
        common.assertElementDisplayed(REPORTINGSENIORINP);

        common.logPrint("Step:: Verify that Zone label is present");
        common.assertElementDisplayed(ZONELABL);
        common.logPrint("Step:: Verify that Zone input field is present");
        common.assertElementDisplayed(ZONEINP);

        common.logPrint("Step:: Verify that State label is present");
        common.assertElementDisplayed(STATELBL);
        common.logPrint("Step:: Verify that State input field is present");
        common.assertElementDisplayed(STATEINP);

        common.logPrint("Step:: Verify that Region label is present");
        common.assertElementDisplayed(REGIONALLBL);
        common.logPrint("Step:: Verify that Region input field is present");
        common.assertElementDisplayed(REGIONINP);

        common.logPrint("Step:: Verify that District label is present");
        common.assertElementDisplayed(DISTRICTLBL);
        common.logPrint("Step:: Verify that District input field is present");
        common.assertElementDisplayed(DISTRICTINP);

        common.logPrint("Step:: Verify that City label is present");
        common.assertElementDisplayed(CITYLABEL);
        common.logPrint("Step:: Verify that City input field is present");
        common.assertElementDisplayed(CITYINPEMP);

        common.logPrint("Account creation field and label verification completed successfully.");
    }

    public void verifyRoleCreationFieldsAndLabels() {

        common.logPrint("Verify Role creation screen fields and labels");

        // Navigate to the Account creation screen as needed (menu clicks etc.)

        if (common.isElementPresent(ADMINPANELMENU)) {
            common.logPrint("Step:: Click on the admin panel menu");
            common.click(ADMINPANELMENU);
        }

        common.pause(2);
        if (common.isElementPresent(BACKBTN)) {
            common.logPrint("Step:: Click on the back button");
            common.click(BACKBTN);
        }

        common.logPrint("Step:: Click on the hospital menu");
        common.waitUntilElementToBeVisible(By.xpath(ROLEMENU));
        common.click(ROLEMENU);

        common.logPrint("Step:: Click on the add button");
        common.waitUntilElementsToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step:: Verify that Role label is present");
        common.assertElementDisplayed(ROLENAMELABEL);

        common.logPrint("Step:: Verify that Role input field is present");
        common.assertElementDisplayed(ROLENAMEINP);
    }

    public void verifyProductCreationFieldsAndLabels() {
        common.logPrint("Verify Product creation screen fields and labels");

        if (common.isElementPresent(ADMINPANELMENU)) {
            common.logPrint("Step:: Click on the admin panel menu");
            common.click(ADMINPANELMENU);
        }

        common.pause(2);
        if (common.isElementPresent(BACKBTN)) {
            common.logPrint("Step:: Click on the back button");
            common.click(BACKBTN);
        }

        common.logPrint("Step:: Click on the hospital menu");
        common.waitUntilElementToBeVisible(By.xpath(PRODUCTMENU));
        common.click(PRODUCTMENU);

        common.logPrint("Step:: Click on the add button");
        common.waitUntilElementsToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step:: Verify that Division label is present");
        common.assertElementDisplayed(DIVISIONLBL);
        common.logPrint("Division label is present on the page");
        common.logPrint("Step:: Verify that Division input is present");
        common.assertElementDisplayed(DIVISIONINPProduct);

        common.logPrint("Step:: Verify that Drug Head label is present");
        common.assertElementDisplayed(DRUGHEADLBL);
        common.logPrint("Drug Head label is present on the page");
        common.logPrint("Step:: Verify that Drug Head input is present");
        common.assertElementDisplayed(DRUGHEADINP);

        common.logPrint("Step:: Verify that Product Line label is present");
        common.assertElementDisplayed(PRODUCTLINELBL);
        common.logPrint("Product Line label is present on the page");
        common.logPrint("Step:: Verify that Product Line input is present");
        common.assertElementDisplayed(PRODUCTLINEINP);

        common.logPrint("Step:: Verify that Product Group label is present");
        common.assertElementDisplayed(PRODUCTGROUPLBL);
        common.logPrint("Product Group label is present on the page");
        common.logPrint("Step:: Verify that Product Group input is present");
        common.assertElementDisplayed(PRODUCTGROUPINP);

        common.logPrint("Step:: Verify that Product Class label is present");
        common.assertElementDisplayed(PRODUCTCLASSLBL);
        common.logPrint("Product Class label is present on the page");
        common.logPrint("Step:: Verify that Product Class input is present");
        common.assertElementDisplayed(PRODUCTCLASSINP);

        common.logPrint("Step:: Verify that Product Type label is present");
        common.assertElementDisplayed(PRODUCTTYPELBL);
        common.logPrint("Product Type label is present on the page");
        common.logPrint("Step:: Verify that Product Type input is present");
        common.assertElementDisplayed(PRODUCTTYPEINP);

        common.logPrint("Step:: Verify that Short Name label is present");
        common.assertElementDisplayed(SHORTNAMELBL);
        common.logPrint("Short Name label is present on the page");
        common.logPrint("Step:: Verify that Short Name input is present");
        common.assertElementDisplayed(SHORTNAMEINP);

        common.logPrint("Step:: Verify that Name label is present");
        common.assertElementDisplayed(NAMELBL);
        common.logPrint("Name label is present on the page");
        common.logPrint("Step:: Verify that Name input is present");
        common.assertElementDisplayed(NAMEINPProduct);

        common.logPrint("Step:: Verify that Packing Type label is present");
        common.assertElementDisplayed(PACKINGTYPELBL);
        common.logPrint("Packing Type label is present on the page");
        common.logPrint("Step:: Verify that Packing Type input is present");
        common.assertElementDisplayed(PACKINGTYPEINP);

        common.logPrint("Step:: Verify that Code Ref 1 label is present");
        common.assertElementDisplayed(CODEREF1LBL);
        common.logPrint("Code Ref 1 label is present on the page");
        common.logPrint("Step:: Verify that Code Ref 1 input is present");
        common.assertElementDisplayed(CODEREF1INP);

        common.logPrint("Step:: Verify that HSN Code label is present");
        common.assertElementDisplayed(HSNCODELBL);
        common.logPrint("HSN Code label is present on the page");
        common.logPrint("Step:: Verify that HSN Code input is present");
        common.assertElementDisplayed(HSNCODEINP);

        common.logPrint("Step:: Verify that PTS AND PTR label is present");
        common.assertElementDisplayed(PTSANDPTRLBL);
        common.logPrint("PTS AND PTR label is present on the page");
        common.logPrint("Step:: Verify that PTS AND PTR input is present");
        common.assertElementDisplayed(PTSANDPTRINP);

//        common.logPrint("Step:: Verify that Margin label is present");
//        common.assertElementDisplayed(MARGINLBL);
//        common.logPrint("Margin label is present on the page");
//        common.logPrint("Step:: Verify that Margin input is present");
//        common.assertElementDisplayed(MARGININP);

        common.logPrint("Step:: Verify that GST % label is present");
        common.assertElementDisplayed(GSTPERCENTLBL);
        common.logPrint("GST % label is present on the page");
        common.logPrint("Step:: Verify that GST % input is present");
        common.assertElementDisplayed(GSTPERCENTINP);

        common.logPrint("Step:: Verify that MRP label is present");
        common.assertElementDisplayed(MRPLBL);
        common.logPrint("MRP label is present on the page");
        common.logPrint("Step:: Verify that MRP input is present");
        common.assertElementDisplayed(MRPINP);

        common.logPrint("Step:: Verify that PTR label is present");
        common.assertElementDisplayed(PTRLBL);
        common.logPrint("PTR label is present on the page");
        common.logPrint("Step:: Verify that PTR input is present");
        common.assertElementDisplayed(PTRINP);

        common.scroll_To_Element(PTSLBL);

        common.logPrint("Step:: Verify that PTS label is present");
        common.assertElementDisplayed(PTSLBL);
        common.logPrint("PTS label is present on the page");
        common.logPrint("Step:: Verify that PTS input is present");
        common.assertElementDisplayed(PTSINP);

        common.logPrint("Step:: Verify that Content label is present");
        common.assertElementDisplayed(CONTENTLBL);
        common.logPrint("Content label is present on the page");
        common.logPrint("Step:: Verify that Content input is present");
        common.assertElementDisplayed(CONTENTINP);
        common.logPrint("Content input field is present on the page");
    }

    public void verifyEmployeeCreationFieldsAndLabels() {
        common.logPrint("Verify Employee creation screen fields and labels");

        if (common.isElementPresent(ADMINPANELMENU)) {
            common.logPrint("Step:: Click on the admin panel menu");
            common.click(ADMINPANELMENU);
        }

        common.pause(2);
        if (common.isElementPresent(BACKBTN)) {
            common.logPrint("Step:: Click on the back button");
            common.click(BACKBTN);
        }

        common.logPrint("Step:: Click on the employee menu");
        common.waitUntilElementToBeVisible(By.xpath(EMPLOYEEMENU));
        common.click(EMPLOYEEMENU);

        common.logPrint("Step:: Click on the add button");
        common.waitUntilElementsToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step:: Verify that Name label is present");
        common.assertElementDisplayed(NAMELBLEMP);
        common.logPrint("Step:: Verify that Name input is present");
        common.assertElementDisplayed(NAMEINPEMP);

        common.logPrint("Step:: Verify that Division label is present");
        common.assertElementDisplayed(DIVISIONLBLEMP);
        common.logPrint("Step:: Verify that Division input is present");
        common.assertElementDisplayed(DIVISIONINPEMP);

        common.logPrint("Step:: Verify that Reference label is present");
        common.assertElementDisplayed(REFERENCELBLEMP);
        common.logPrint("Step:: Verify that Reference input is present");
        common.assertElementDisplayed(REFERENCEINPEMP);

        common.logPrint("Step:: Verify that Phone No label is present");
        common.assertElementDisplayed(PHONENOLBLEMP);
        common.logPrint("Step:: Verify that Phone No input is present");
        common.assertElementDisplayed(PHONENOINPEMP);

        common.logPrint("Step:: Verify that Mobile No. label is present");
        common.assertElementDisplayed(MOBILENOLBLEMP);
        common.logPrint("Step:: Verify that Mobile No. input is present");
        common.assertElementDisplayed(MOBILENOINPEMP);

        common.logPrint("Step:: Verify that Email label is present");
        common.assertElementDisplayed(EMAILLBLEMP);
        common.logPrint("Step:: Verify that Email input is present");
        common.assertElementDisplayed(EMAILINPEMP);

        common.logPrint("Step:: Verify that Previous Experience label is present");
        common.assertElementDisplayed(PREVEXPLBL);
        common.logPrint("Step:: Verify that Previous Experience input is present");
        common.assertElementDisplayed(PREVEXPINP);

        common.logPrint("Step:: Verify that Passport label is present");
        common.assertElementDisplayed(PASSPORTLBL);
        common.logPrint("Step:: Verify that Passport input is present");
        common.assertElementDisplayed(PASSPORTINP);

        common.logPrint("Step:: Verify that Pancard label is present");
        common.assertElementDisplayed(PANCARDLBL);
        common.logPrint("PanCard label is displayed on the page");
        common.logPrint("Step:: Verify that PanCard input field is present");
        common.assertElementDisplayed(PANCARDINP);
        common.logPrint("PanCard input field is present on the page");

        common.logPrint("Step:: Verify that PF No. label is present");
        common.assertElementDisplayed(PFNOLBL);
        common.logPrint("PF No. label is displayed on the page");
        common.logPrint("Step:: Verify that PF No. input field is present");
        common.assertElementDisplayed(PFNOINP);
        common.logPrint("PF No. input field is present on the page");

        common.logPrint("Step:: Verify that UanNo label is present");
        common.assertElementDisplayed(UANNOLBL);
        common.logPrint("UanNo label is displayed on the page");
        common.logPrint("Step:: Verify that UanNo input field is present");
        common.assertElementDisplayed(UANNOINP);
        common.logPrint("UanNo input field is present on the page");

        common.logPrint("Step:: Verify that Blood Group label is present");
        common.assertElementDisplayed(BLOODGROUPLBL);
        common.logPrint("Blood Group label is displayed on the page");
        common.logPrint("Step:: Verify that Blood Group input field is present");
        common.assertElementDisplayed(BLOODGROUPINP);
        common.logPrint("Blood Group input field is present on the page");

        common.logPrint("Step:: Verify that Religion label is present");
        common.assertElementDisplayed(RELIGIONLBL);
        common.logPrint("Religion label is displayed on the page");
        common.logPrint("Step:: Verify that Religion input field is present");
        common.assertElementDisplayed(RELIGIONINP);
        common.logPrint("Religion input field is present on the page");

        common.logPrint("Step:: Verify that Birth Date label is present");
        common.assertElementDisplayed(BIRTHDATELBL);
        common.logPrint("Birth Date label is displayed on the page");
        common.logPrint("Step:: Verify that Birth Date input field is present");
        common.assertElementDisplayed(BIRTHDATEINP);
        common.logPrint("Birth Date input field is present on the page");

        common.logPrint("Step:: Verify that Marital Status label is present");
        common.assertElementDisplayed(MARITALSTATUSLBL);
        common.logPrint("Marital Status label is displayed on the page");
        common.logPrint("Step:: Verify that Marital Status input field is present");
        common.assertElementDisplayed(MARITALSTATUSINP);
        common.logPrint("Marital Status input field is present on the page");

        common.logPrint("Step:: Verify that Gender label is present");
        common.assertElementDisplayed(GENDERLBL);
        common.logPrint("Gender label is displayed on the page");
        common.logPrint("Step:: Verify that Gender input field is present");
        common.assertElementDisplayed(GENDERINP);
        common.logPrint("Gender input field is present on the page");

        common.logPrint("Step:: Verify that Anniversary Date label is present");
        common.assertElementDisplayed(ANNIDATELBL);
        common.logPrint("Anniversary Date label is displayed on the page");
        common.logPrint("Step:: Verify that Anniversary Date input field is present");
        common.assertElementDisplayed(ANNIDATEINP);
        common.logPrint("Anniversary Date input field is present on the page");

        common.logPrint("Step:: Verify that Joining Date label is present");
        common.assertElementDisplayed(JOININGDATELBL);
        common.logPrint("Joining Date label is displayed on the page");
        common.logPrint("Step:: Verify that Joining Date input field is present");
        common.assertElementDisplayed(JOININGDATEINP);
        common.logPrint("Joining Date input field is present on the page");

        common.logPrint("Step:: Verify that Last Working Date label is present");
        common.assertElementDisplayed(LASTWORKINGDATELBL);
        common.logPrint("Last Working Date label is displayed on the page");
        common.logPrint("Step:: Verify that Last Working Date input field is present");
        common.assertElementDisplayed(LASTWORKINGDATEINP);
        common.logPrint("Last Working Date input field is present on the page");

        common.logPrint("Step:: Verify that Bank IFSC code label is present");
        common.assertElementDisplayed(BANKIFSCLBL);
        common.logPrint("Bank IFSC code label is displayed on the page");
        common.logPrint("Step:: Verify that Bank IFSC code input field is present");
        common.assertElementDisplayed(BANKIFSCINP);
        common.logPrint("Bank IFSC code input field is present on the page");

        common.logPrint("Step:: Verify that Salary Bank Name label is present");
        common.assertElementDisplayed(SALARYBANKNAMELBL);
        common.logPrint("Salary Bank Name label is displayed on the page");
        common.logPrint("Step:: Verify that Salary Bank Name input field is present");
        common.assertElementDisplayed(SALARYBANKNAMEINP);
        common.logPrint("Salary Bank Name input field is present on the page");

        common.logPrint("Step:: Verify that Bank Account No. label is present");
        common.assertElementDisplayed(BANKACCOUNTNOLBL);
        common.logPrint("Bank Account No. label is displayed on the page");
        common.logPrint("Step:: Verify that Bank Account No. input field is present");
        common.assertElementDisplayed(BANKACCOUNTNOINP);
        common.logPrint("Bank Account No. input field is present on the page");

        common.logPrint("Step:: Verify that Name As Bank Registered label is present");
        common.assertElementDisplayed(NAMEASBANKLBL);
        common.logPrint("Name As Bank Registered label is displayed on the page");
        common.logPrint("Step:: Verify that Name As Bank Registered input field is present");
        common.assertElementDisplayed(NAMEASBANKINP);
        common.logPrint("Name As Bank Registered input field is present on the page");

        common.logPrint("Step:: Verify that Aadhar Card Number label is present");
        common.assertElementDisplayed(AADHARLBL);
        common.logPrint("Aadhar Card Number label is displayed on the page");
        common.logPrint("Step:: Verify that Aadhar Card Number input field is present");
        common.assertElementDisplayed(AADHARINP);
        common.logPrint("Aadhar Card Number input field is present on the page");

        common.scroll_To_Element(DRIVINGLICENCELBL);

        common.logPrint("Step:: Verify that Driving License No label is present");
        common.assertElementDisplayed(DRIVINGLICENCELBL);
        common.logPrint("Driving License No label is displayed on the page");
        common.logPrint("Step:: Verify that Driving License No input field is present");
        common.assertElementDisplayed(DRIVINGLICENSEINP);
        common.logPrint("Driving License No input field is present on the page");

        common.logPrint("Step:: Verify that Expense Bank Name label is present");
        common.assertElementDisplayed(EXPENSEBANKNAMELBL);
        common.logPrint("Expense Bank Name label is displayed on the page");
        common.logPrint("Step:: Verify that Expense Bank Name input field is present");
        common.assertElementDisplayed(EXPENSEBANKNAMEINP);
        common.logPrint("Expense Bank Name input field is present on the page");

        common.logPrint("Step:: Verify that Expense Bank Account Number label is present");
        common.assertElementDisplayed(EXPENSEBANKACCLBL);
        common.logPrint("Expense Bank Account Number label is displayed on the page");
        common.logPrint("Step:: Verify that Expense Bank Account Number input field is present");
        common.assertElementDisplayed(EXPENSEBANKACCINP);
        common.logPrint("Expense Bank Account Number input field is present on the page");

        //common.scrollPageUsingPixel(250,250);
        common.logPrint("Step:: Verify that Promotion Date label is present");
        common.assertElementDisplayed(PROMOTIONDATELBL);
        common.logPrint("Promotion Date label is displayed on the page");
        common.logPrint("Step:: Verify that Promotion Date input field is present");
        common.assertElementDisplayed(PROMOTIONDATEINP);
        common.logPrint("Promotion Date input field is present on the page");

        common.logPrint("Step:: Verify that Demotion Date label is present");
        common.assertElementDisplayed(DEMOTIONDATELBL);
        common.logPrint("Demotion Date label is displayed on the page");
        common.logPrint("Step:: Verify that Demotion Date input field is present");
        common.assertElementDisplayed(DEMOTIONDATEINP);
        common.logPrint("Demotion Date input field is present on the page");

        common.logPrint("Step:: Verify that Conformation Date label is present");
        common.assertElementDisplayed(CONFORMATIONDATELBL);
        common.logPrint("Conformation Date label is displayed on the page");
        common.logPrint("Step:: Verify that Conformation Date input field is present");
        common.assertElementDisplayed(CONFORMATIONDATEINP);
        common.logPrint("Conformation Date input field is present on the page");

        common.logPrint("Step:: Verify that Metro label is present");
        common.assertElementDisplayed(METROLBL);
        common.logPrint("Metro label is displayed on the page");
        common.logPrint("Step:: Verify that Metro input field is present");
        common.assertElementDisplayed(METROINP);
        common.logPrint("Metro input field is present on the page");

        common.logPrint("Step:: Verify that Appointment Letter label is present");
        common.assertElementDisplayed(APPOINTMENTLETTLBL);
        common.logPrint("Appointment Letter label is displayed on the page");
        common.logPrint("Step:: Verify that Appointment Letter input field is present");
        common.assertElementDisplayed(APPOINTMENTLETTINP);
        common.logPrint("Appointment Letter input field is present on the page");

        common.logPrint("Step:: Verify that Education label is present");
        common.assertElementDisplayed(EDUCATIONLBL);
        common.logPrint("Education label is displayed on the page");
        common.logPrint("Step:: Verify that Education input field is present");
        common.assertElementDisplayed(EDUCATIONINP);
        common.logPrint("Education input field is present on the page");

        //common.scrollToElement(FATHERHUSBNAMELBL);

        common.logPrint("Step:: Verify that Father/Husband Name label is present");
        common.assertElementDisplayed(FATHERHUSBNAMELBL);
        common.logPrint("Father/Husband Name label is displayed on the page");
        common.logPrint("Step:: Verify that Father/Husband Name input field is present");
        common.assertElementDisplayed(FATHERHUSBNAMEINP);
        common.logPrint("Father/Husband Name input field is present on the page");

        common.logPrint("Step:: Verify that Father/Husband Contact Number label is present");
        common.assertElementDisplayed(FATHERHUSBCONTACTLBL);
        common.logPrint("Father/Husband Contact Number label is displayed on the page");
        common.logPrint("Step:: Verify that Father/Husband Contact Number input field is present");
        common.assertElementDisplayed(FATHERHUSBCONTACTINP);
        common.logPrint("Father/Husband Contact Number input field is present on the page");

        common.logPrint("Step:: Verify that Abha Number label is present");
        common.assertElementDisplayed(ABHANOLBL);
        common.logPrint("Abha Number label is displayed on the page");

        common.logPrint("Step:: Verify that Abha Number input field is present");
        common.assertElementDisplayed(ABHANOINP);
        common.logPrint("Abha Number input field is present on the page");

        common.logPrint("Step:: Verify that Aayushman Card Number label is present");
        common.assertElementDisplayed(AAYUSHMANCARDLBL);
        common.logPrint("Aayushman Card Number label is displayed on the page");
        common.logPrint("Step:: Verify that Aayushman Card Number input field is present");
        common.assertElementDisplayed(AAYUSHMANCARDINP);
        common.logPrint("Aayushman Card Number input field is present on the page");

        common.logPrint("Step:: Verify that Spouse Name label is present");
        common.assertElementDisplayed(SPOUSENAMELBL);
        common.logPrint("Spouse Name label is displayed on the page");
        common.logPrint("Step:: Verify that Spouse Name input field is present");
        common.assertElementDisplayed(SPOUSENAMEINP);
        common.logPrint("Spouse Name input field is present on the page");

        common.logPrint("Step:: Verify that Spouse Contact Number label is present");
        common.assertElementDisplayed(SPOUSECONTACTLBL);
        common.logPrint("Spouse Contact Number label is displayed on the page");
        common.logPrint("Step:: Verify that Spouse Contact Number input field is present");
        common.assertElementDisplayed(SPOUSECONTACTINP);
        common.logPrint("Spouse Contact Number input field is present on the page");

        common.logPrint("Step:: Verify that Son Name label is present");
        common.assertElementDisplayed(SONNAMELBL);
        common.logPrint("Son Name label is displayed on the page");
        common.logPrint("Step:: Verify that Son Name input field is present");
        common.assertElementDisplayed(SONNAMEINP);
        common.logPrint("Son Name input field is present on the page");

        common.logPrint("Step:: Verify that Son Contact Number label is present");
        common.assertElementDisplayed(SONCONTACTLBL);
        common.logPrint("Son Contact Number label is displayed on the page");
        common.logPrint("Step:: Verify that Son Contact Number input field is present");
        common.assertElementDisplayed(SONCONTACTINP);
        common.logPrint("Son Contact Number input field is present on the page");

        common.logPrint("Step:: Verify that Daughter Name label is present");
        common.assertElementDisplayed(DAUGHTERNAMELBL);
        common.logPrint("Daughter Name label is displayed on the page");
        common.logPrint("Step:: Verify that Daughter Name input field is present");
        common.assertElementDisplayed(DAUGHTERNAMEINP);
        common.logPrint("Daughter Name input field is present on the page");

        common.logPrint("Step:: Verify that Daughter Contact Number label is present");
        common.assertElementDisplayed(DAUGHTERCONTACTLBL);
        common.logPrint("Daughter Contact Number label is displayed on the page");
        common.logPrint("Step:: Verify that Daughter Contact Number input field is present");
        common.assertElementDisplayed(DAUGHTERCONTACTINP);
        common.logPrint("Daughter Contact Number input field is present on the page");

        common.logPrint("Step:: Verify that Skills label is present");
        common.assertElementDisplayed(SKILLSLBL);
        common.logPrint("Skills label is displayed on the page");
        common.logPrint("Step:: Verify that Skills input field is present");
        common.assertElementDisplayed(SKILLSINP);
        common.logPrint("Skills input field is present on the page");

        common.logPrint("Step:: Verify that Area Of Development label is present");
        common.assertElementDisplayed(AREADEVLBL);
        common.logPrint("Area Of Development label is displayed on the page");
        common.logPrint("Step:: Verify that Area Of Development input field is present");
        common.assertElementDisplayed(AREADEVINP);
        common.logPrint("Area Of Development input field is present on the page");

        common.logPrint("Step:: Verify that Short Term Goal label is present");
        common.assertElementDisplayed(SHORTGOALLBL);
        common.logPrint("Short Term Goal label is displayed on the page");
        common.logPrint("Step:: Verify that Short Term Goal input field is present");
        common.assertElementDisplayed(SHORTGOALINP);
        common.logPrint("Short Term Goal input field is present on the page");

        common.logPrint("Step:: Verify that Long Term Goal label is present");
        common.assertElementDisplayed(LONGGOALLBL);
        common.logPrint("Long Term Goal label is displayed on the page");
        common.logPrint("Step:: Verify that Long Term Goal input field is present");
        common.assertElementDisplayed(LONGGOALINP);
        common.logPrint("Long Term Goal input field is present on the page");

        common.logPrint("Step:: Verify that Investments label is present");
        common.assertElementDisplayed(INVESTMENTSLBL);
        common.logPrint("Investments label is displayed on the page");
        common.logPrint("Step:: Verify that Investments input field is present");
        common.assertElementDisplayed(INVESTMENTSINP);
        common.logPrint("Investments input field is present on the page");

        common.logPrint("Step:: Verify that Liabilities label is present");
        common.assertElementDisplayed(LIABILITIESLBL);
        common.logPrint("Liabilities label is displayed on the page");
        common.logPrint("Step:: Verify that Liabilities input field is present");
        common.assertElementDisplayed(LIABILITIESINP);
        common.logPrint("Liabilities input field is present on the page");

        common.logPrint("Step:: Verify that Reference Name 1 label is present");
        common.assertElementDisplayed(REFNAME1LBL);
        common.logPrint("Reference Name 1 label is displayed on the page");
        common.logPrint("Step:: Verify that Reference Name 1 input field is present");
        common.assertElementDisplayed(REFNAME1INP);
        common.logPrint("Reference Name 1 input field is present on the page");

        common.logPrint("Step:: Verify that Reference Name 1 Contact Number label is present");
        common.assertElementDisplayed(REF1CONTACTLBL);
        common.logPrint("Reference Name 1 Contact Number label is displayed on the page");
        common.logPrint("Step:: Verify that Reference Name 1 Contact Number input field is present");
        common.assertElementDisplayed(REF1CONTACTINP);
        common.logPrint("Reference Name 1 Contact Number input field is present on the page");

        common.logPrint("Step:: Verify that Reference Name 2 label is present");
        common.assertElementDisplayed(REFNAME2LBL);
        common.logPrint("Reference Name 2 label is displayed on the page");
        common.logPrint("Step:: Verify that Reference Name 2 input field is present");
        common.assertElementDisplayed(REFNAME2INP);
        common.logPrint("Reference Name 2 input field is present on the page");

        common.logPrint("Step:: Verify that Reference Name 2 Contact Number label is present");
        common.assertElementDisplayed(REF2CONTACTLBL);
        common.logPrint("Reference Name 2 Contact Number label is displayed on the page");
        common.logPrint("Step:: Verify that Reference Name 2 Contact Number input field is present");
        common.assertElementDisplayed(REF2CONTACTINP);
        common.logPrint("Reference Name 2 Contact Number input field is present on the page");

        common.logPrint("Step:: Verify that Reference Name 3 label is present");
        common.assertElementDisplayed(REFNAME3LBL);
        common.logPrint("Reference Name 3 label is displayed on the page");
        common.logPrint("Step:: Verify that Reference Name 3 input field is present");
        common.assertElementDisplayed(REFNAME3INP);
        common.logPrint("Reference Name 3 input field is present on the page");

        common.logPrint("Step:: Verify that Reference Name 3 Contact Number label is present");
        common.assertElementDisplayed(REF3CONTACTLBL);
        common.logPrint("Reference Name 3 Contact Number label is displayed on the page");
        common.logPrint("Step:: Verify that Reference Name 3 Contact Number input field is present");
        common.assertElementDisplayed(REF3CONTACTINP);
        common.logPrint("Reference Name 3 Contact Number input field is present on the page");

        common.logPrint("Step:: Verify that Experiences label is present");
        common.assertElementDisplayed(EXPERIENCESLBL);
        common.logPrint("Experiences label is displayed on the page");
        common.logPrint("Step:: Verify that Experiences input field is present");
        common.assertElementDisplayed(EXPERIENCESINP);
        common.logPrint("Experiences input field is present on the page");

    }

    public void verifyLabelAndFieldsInTheDesignationPage() {

        common.logPrint("Verify Employee creation screen fields and labels");

        if (common.isElementPresent(ADMINPANELMENU)) {
            common.logPrint("Step:: Click on the admin panel menu");
            common.click(ADMINPANELMENU);
        }

        common.pause(2);
        if (common.isElementPresent(BACKBTN)) {
            common.logPrint("Step:: Click on the back button");
            common.click(BACKBTN);
        }

        common.logPrint("Step:: Click on the employee menu");
        common.waitUntilElementToBeVisible(By.xpath(DESIGNATIONMENU));
        common.click(DESIGNATIONMENU);

        common.logPrint("Step:: Click on the add button");
        common.waitUntilElementsToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step:: Verify that Designation label is present");
        common.assertElementDisplayed(DESIGNATIONLBL1);
        common.logPrint("Designation label is displayed on the page");
        common.logPrint("Step:: Verify that Designation input field is present");
        common.assertElementDisplayed(DESIGNATIONINPUT);
        common.logPrint("Designation input field is present on the page");

        common.logPrint("Step:: Verify that Parent Designation label is present");
        common.assertElementDisplayed(PARENTDESIGNATIONLBL);
        common.logPrint("Parent Designation label is displayed on the page");
        common.logPrint("Step:: Verify that Parent Designation input field is present");
        common.assertElementDisplayed(PARENTDESIGNATIONINP);
        common.logPrint("Parent Designation input field is present on the page");

    }

    public void verifyDoctorCreationFieldAndLabels() {

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

    public String verifyCreateDoctorCreateFunctionality() {

        redirectToDoctorPage();

        common.logPrint("Step:: Click on the ADD button");
        common.waitUntilElementToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.scroll_To_Element(DOCTORNAMEINP);

        String drName = common.fakeName();
        common.logPrint("Step:: Create doctor create functionality");
        common.waitUntilElementsToBeVisible(By.xpath(DOCTORNAMEINP));
        common.type(DOCTORNAMEINP, drName);
        common.logPrint("Doctor name is: " + drName);

        common.logPrint("Step:: Select category");
        common.waitUntilElementToBeVisible(By.xpath(CATEGORYINP));
        common.click(CATEGORYINP);
        common.twoDownKeyAndEnter();

        common.logPrint("Step:: Select Speciality");
        common.waitUntilElementToBeVisible(By.xpath(SPECIALITYINP));
        common.click(SPECIALITYINP);
        common.twoDownKeyAndEnter();

        common.logPrint("Step:: Select Qualification");
        common.waitUntilElementToBeVisible(By.xpath(QUALIFICATIONSINP));
        common.click(QUALIFICATIONSINP);
        common.twoDownKeyAndEnter();

        common.logPrint("Step:: Select Product");
        common.waitUntilElementToBeVisible(By.xpath(PRODUCTINP));
        common.click(PRODUCTINP);
        common.twoDownKeyAndEnter();

        common.logPrint("Step:: Enter mobile number");
        common.waitUntilElementToBeVisible(By.xpath(MOBILENOINP));
        String mobileNum = common.generateRandomNumberString(10);
        common.type(MOBILENOINP, mobileNum);

        common.logPrint("Step:: Select City");
        common.waitUntilElementToBeVisible(By.xpath(COMMNUNICATIONCITY));
        common.type(COMMNUNICATIONCITY, "AHMEDABAD");
        common.pause(1);
        common.downKeyAndEnter();

        common.logPrint("Step:: Select Pincode");
        common.waitUntilElementToBeVisible(By.xpath(COMMNUCATIONPINCODE));
        common.click(COMMNUCATIONPINCODE);
        common.pause(1);
        common.downKeyAndEnter();

        common.logPrint("Step:: Select residential City");
        common.waitUntilElementToBeVisible(By.xpath(PERMANENTCITY));
        common.type(PERMANENTCITY, "AHMEDABAD");
        common.pause(1);
        common.downKeyAndEnter();

        common.logPrint("Step:: Select residential Pincode");
        common.waitUntilElementToBeVisible(By.xpath(PERMANENTPINCODE));
        common.click(PERMANENTPINCODE);
        common.pause(1);
        common.downKeyAndEnter();

        common.logPrint("Step:: Click on the save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.logPrint("Step:: Check validation is displayed");
        common.assertElementDisplayed(AddedSuccessfully);

        common.logPrint("New doctor is created successfully and name");

        return drName;
    }

    public String[] updateTheDoctor(String drName) {

        redirectToDoctorPage();

        common.logPrint("Step:: Search doctor name in the search field");
        common.waitUntilElementToBeVisible(By.xpath(SEARCHFIELD));
        common.type(SEARCHFIELD, drName);

        common.logPrint("Step:: Select first checkbox");
        common.pause(2);
        common.selectCheckBox(FIRSTEMAILCHECKBOX);

        common.logPrint("Step:: Click on the edit button");
        common.waitUntilElementToBeVisible(By.xpath(EDITBTN));
        common.click(EDITBTN);

        String UpdatedrName = common.fakeName();
        common.logPrint("Step:: Update the doctor name");
        common.waitUntilElementsToBeVisible(By.xpath(DOCTORNAMEINP)).clear();
        common.type(DOCTORNAMEINP, UpdatedrName);
        common.logPrint("Updated Doctor name is: " + UpdatedrName);

        common.logPrint("Step:: Update the mobile number");
        common.waitUntilElementToBeVisible(By.xpath(MOBILENOINP)).clear();
        String mobileNum = common.generateRandomNumberString(10);
        common.type(MOBILENOINP, mobileNum);

        common.logPrint("Step:: Click on the save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.logPrint("Step:: Check validation is displayed");
        common.assertElementDisplayed(UpdatedSuccessfully);

        return new String[]{UpdatedrName, mobileNum};
    }

    public void verifyDoctorIsUpdated(String updatedName, String updatedMobileNum) {

        common.pause(1);

        common.logPrint("Step:: Search entity in the table");
        common.waitUntilElementToBeVisible(By.xpath(SEARCHFIELD));
        common.type(SEARCHFIELD, updatedName);

        String xpathName = "//div[@data-colindex='3']";

        common.logPrint("Step:: Verify name is updated");
        common.pause(2);
        common.waitUntilElementToBeVisible(By.xpath(xpathName));
        String getDoctorName = common.getText(xpathName);
        common.assertTwoValuesAreEqual(getDoctorName.toLowerCase(), updatedName.toLowerCase());

        String xpathMobile = "//div[@data-colindex='5']";

        common.logPrint("Step:: Verify mobile number is updated");
        common.pause(2);
        common.waitUntilElementToBeVisible(By.xpath(xpathMobile));
        String getMobileNum = common.getText(xpathMobile);
        String updatedMobileGet = getMobileNum.replaceAll("[|\\-\\s]", "");
        common.assertTwoValuesAreEqual(updatedMobileGet, updatedMobileNum);

        common.logPrint("Both values are updated successfully");

        common.logPrint("test");

    }

    public void verifyStockiestIsUpdated(String updatedName) {

        common.pause(1);

        common.logPrint("Step:: Search doctor in the table");
        common.waitUntilElementToBeVisible(By.xpath(SEARCHFIELD));
        common.type(SEARCHFIELD, updatedName);

        String xpathName = "//div[@data-colindex='3']";

        common.logPrint("Step:: Verify name is updated");
        common.pause(2);
        common.waitUntilElementToBeVisible(By.xpath(xpathName));
        String getDoctorName = common.getText(xpathName);
        common.assertTwoValuesAreEqual(getDoctorName.toLowerCase(), updatedName.toLowerCase());

//        String xpathMobile = "//div[@data-colindex='5']";
//
//        common.logPrint("Step:: Verify mobile number is updated");
//        common.pause(2);
//        common.waitUntilElementToBeVisible(By.xpath(xpathMobile));
//        String getMobileNum = common.getText(xpathMobile);
//        String updatedMobileGet = getMobileNum.replaceAll("[|\\-\\s]", "");
//        common.assertTwoValuesAreEqual(updatedMobileGet, updatedMobileNum);

        common.logPrint("Name value are updated successfully");

    }

    public void verifyEntityIsCreatedIsShowingInTheTableAndItStatusIsPending(String name) {

        common.logPrint("Step:: Search name in the search field");
        common.waitUntilElementToBeVisible(By.xpath(SEARCHFIELD));
        common.type(SEARCHFIELD, name);

        common.pause(1);
        common.logPrint("Step:: Verify the status is showing as pending");
        common.waitUntilElementToBeVisible(By.xpath(PENDINGSTATUS));
        common.assertElementPresent(PENDINGSTATUS);

    }

    public void verifyStockiestIsCreatedIsShowingInTheTableAndItStatusIsPending(String name) {

        common.logPrint("Step:: Search name in the search field");
        common.waitUntilElementToBeVisible(By.xpath(SEARCHFIELD));
        common.type(SEARCHFIELD, name);

        common.pause(1);
        common.logPrint("Step:: Verify the status is showing as pending");
        common.waitUntilElementToBeVisible(By.xpath(PENDINGSTATUS1));
        common.assertElementPresent(PENDINGSTATUS1);

    }

    public void verifyDoctorIsCreatedIsShowingInTheTableAndItStatusIsApproval(String name) {

        common.logPrint("Step:: Search name in the search field");
        common.waitUntilElementToBeVisible(By.xpath(SEARCHFIELD));
        common.type(SEARCHFIELD, name);

        common.pause(1);
        common.logPrint("Step:: Verify the status is showing as Approved");
        common.waitUntilElementToBeVisible(By.xpath(APPROVESTATUS));
        common.assertElementPresent(APPROVESTATUS);

    }

    public void verifyStockiestIsCreatedIsShowingInTheTableAndItStatusIsApproval(String name) {

        common.logPrint("Step:: Search name in the search field");
        common.waitUntilElementToBeVisible(By.xpath(SEARCHFIELD));
        common.type(SEARCHFIELD, name);

        common.pause(1);
        common.logPrint("Step:: Verify the status is showing as Approved");
        common.waitUntilElementToBeVisible(By.xpath(APPROVESTATUS1));
        common.assertElementPresent(APPROVESTATUS1);

    }

    public void verifyDrApprovalForTheAsmUser(String doctor) {

        loginWithASMCredential();

        redirectToDoctorPage();

        verifyEntityIsCreatedIsShowingInTheTableAndItStatusIsPending(doctor);

        common.logPrint("Step:: Click on the checkbox");
        common.pause(1);
        common.selectCheckBox(FIRSTEMAILCHECKBOX);
        //WebElement element = driver.findElement(By.xpath(FIRSTEMAILCHECKBOX));
        //element.click();

        common.logPrint("Step:: Click on the Approval button");
        common.waitUntilElementToBeVisible(By.xpath(APPROVEBTN));
        common.click(APPROVEBTN);

        common.logPrint("Step:: Verified success message is showing after approved");
        common.waitUntilElementToBeVisible(By.xpath(SUCCESSMSG));
        common.assertElementPresent(SUCCESSMSG);

        common.refreshPage();

        common.logPrint("Step:: Verified status is not showing as approved");

        verifyDoctorIsCreatedIsShowingInTheTableAndItStatusIsApproval(doctor);


    }

    public void approvedDeleteRequestFromTheDirectorsUser(String drName) {


        String checkBoxUponName = "//td[contains(.,'" + drName + "')]/parent::tr//td//span";

        common.logPrint("Step:: Select the checkbox according to the Doctor name");
        common.pause(2);
        common.selectCheckBox(checkBoxUponName);

        common.logPrint("Step:: Click on the approve button");
        common.waitUntilElementToBeVisible(By.xpath(APPROVEBTN));
        common.click(APPROVEBTN);

        common.logPrint("Step:: Verify validation is showing for the doctor delete confirmation");
        common.waitUntilElementToBeVisible(By.xpath(DoctorApprovedSuccess));
        common.assertElementPresent(DoctorApprovedSuccess);

    }

    public void deleteDoctorFromTheList(String name) {

        common.logPrint("Step:: Click on the checkbox");
        common.pause(2);
        common.selectCheckBox(FIRSTCHECKBOX);

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
        common.assertElementDisplayed(DeletedSuccessfully);

        // verifyDoctorRemoveFromTheList(name);

    }

    public void verifyDoctorRemoveFromTheList(String drName) {


        common.logPrint("Step:: Search name in the search field");
        common.waitUntilElementToBeVisible(By.xpath(SEARCHFIELD));
        common.type(SEARCHFIELD, drName);

        common.pause(1);

        common.logPrint("Step:: Check doctor is removed from the list");

        common.logPrint("Step:: Now rows are available");
        common.assertElementDisplayed(NOROWS);

        common.logPrint("Doctor is removed from the list");
    }

    public void redirectToTheDoctorAdditionalDetail() {

        common.logPrint("Step:: Click on the admin panel menu");
        common.waitUntilElementToBeVisible(By.xpath(ADMINPANELMENU));
        common.click(ADMINPANELMENU);

        common.logPrint("Step:: Click on the Doctor menu");
        common.waitUntilElementToBeVisible(By.xpath(DOCTORMENU));
        common.click(DOCTORMENU);

        common.logPrint("Step:: Click on the First raw data");
        common.waitUntilElementToBeVisible(By.xpath(FIRSTROWDATADOCTR));
        common.click(FIRSTROWDATADOCTR);

    }

    public String createChemistAndApprove() {

        redirectsToChemistPage();

        common.logPrint("Step:: Click on the ADD button");
        common.waitUntilElementToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        String ChemistName = common.fakeName();

        common.logPrint("Step:: Enter chemist name");
        common.waitUntilElementsToBeVisible(By.xpath(CHEMISTNAME));
        common.type(CHEMISTNAME, ChemistName);
        common.logPrint("Doctor name is: " + ChemistName);

        common.logPrint("Step:: Select category");
        common.waitUntilElementToBeVisible(By.xpath(CATEGORYINP));
        common.click(CATEGORYINP);
        common.twoDownKeyAndEnter();

        common.logPrint("Step:: Select chemist type");
        common.waitUntilElementToBeVisible(By.xpath(CHEMMISTTYPE));
        common.click(CHEMMISTTYPE);
        common.twoDownKeyAndEnter();

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
        common.click(PINCODEINPUT);
        common.pause(2);
        common.downKeyAndEnter();

        common.logPrint("Step:: Click on the save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.logPrint("Step:: Check validation is displayed");
        common.assertElementDisplayed(AddedSuccessfully);

        common.logPrint("New chemist is created successfully and name is: " + ChemistName);

        return ChemistName;
    }

    public String[] updateTheChemist(String chemistName) {

        redirectsToChemistPage();
        common.logPrint("Step:: Search doctor name in the search field");
        common.waitUntilElementToBeVisible(By.xpath(SEARCHFIELD));
        common.type(SEARCHFIELD, chemistName);

        common.logPrint("Step:: Select first checkbox");
        common.pause(2);
        common.selectCheckBox(FIRSTEMAILCHECKBOX);

        common.logPrint("Step:: Click on the edit button");
        common.waitUntilElementToBeVisible(By.xpath(EDITBTN));
        common.click(EDITBTN);

        String updateChemist = common.fakeName();
        common.logPrint("Step:: Enter chemist name");
        common.waitUntilElementsToBeVisible(By.xpath(CHEMISTNAME)).clear();
        common.type(CHEMISTNAME, updateChemist);
        common.logPrint("Doctor name is: " + updateChemist);

        common.logPrint("Step:: Enter mobile number");
        common.waitUntilElementToBeVisible(By.xpath(MOBILENOINP)).clear();
        String updateMobileNum = common.generateRandomNumberString(10);
        common.type(MOBILENOINP, updateMobileNum);

        common.logPrint("Step:: Click on the save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.logPrint("Step:: Check validation is displayed");
        common.assertElementDisplayed(UpdatedSuccessfully);

        return new String[]{updateChemist, updateMobileNum};
    }

    public void verifyChemistApprovedForTheAsmUser(String Chemist) {

        loginWithASMCredential();

        redirectsToChemistPage();

        verifyEntityIsCreatedIsShowingInTheTableAndItStatusIsPending(Chemist);

        common.logPrint("Step:: Click on the checkbox");
        common.pause(1);
        common.selectCheckBox(FIRSTEMAILCHECKBOX);

        common.logPrint("Step:: Click on the Approval button");
        common.waitUntilElementToBeVisible(By.xpath(APPROVEBTN));
        common.click(APPROVEBTN);

        common.logPrint("Step:: Verified success message is showing after approved");
        common.waitUntilElementToBeVisible(By.xpath(SUCCESSMSG));
        common.assertElementPresent(SUCCESSMSG);

        common.refreshPage();

        common.logPrint("Step:: Verified status is not showing as approved");

        verifyDoctorIsCreatedIsShowingInTheTableAndItStatusIsApproval(Chemist);
    }

    public void deleteChemistFromTheDirector() {

        common.logPrint("Step:: Click on the checkbox");
        common.pause(2);
        common.selectCheckBox(FIRSTCHECKBOX);

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
        common.assertElementDisplayed(DeletedSuccessfully);

    }

    public String createStockiestApproval() {

        redirectsToStockiestPage();

        common.logPrint("Step:: Click on the ADD button");
        common.waitUntilElementToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.scroll_To_Element(STOCKISTNAME);

        String StockistName = common.fakeName();

        common.logPrint("Step:: Enter Stockist name");
        common.waitUntilElementsToBeVisible(By.xpath(STOCKISTNAME));
        common.type(STOCKISTNAME, StockistName);
        common.logPrint("Stockiest name is: " + StockistName);

        common.logPrint("Step:: Select stockist type");
        common.waitUntilElementToBeVisible(By.xpath(STOCKISTTYPE));
        common.click(STOCKISTTYPE);
        common.twoDownKeyAndEnter();

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
        common.click(PINCODEINPUT);
        common.pause(1);
        common.downKeyAndEnter();

        common.logPrint("Step:: Click on the save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.logPrint("Step:: Check validation is displayed");
        common.assertElementDisplayed(AddedSuccessfully);

        common.logPrint("New stockist is created successfully and name is: " + StockistName);


        return StockistName;
    }

    public void verifyStockiestApprovedForTheAsmUser(String Stockiest) {

        loginWithASMCredential();

        redirectsToStockiestPage();

        verifyStockiestIsCreatedIsShowingInTheTableAndItStatusIsPending(Stockiest);

        common.logPrint("Step:: Click on the checkbox");
        common.pause(1);
        common.selectCheckBox(FIRSTEMAILCHECKBOX);

        common.logPrint("Step:: Click on the Approval button");
        common.waitUntilElementToBeVisible(By.xpath(APPROVEBTN));
        common.click(APPROVEBTN);

        common.logPrint("Step:: Verified success message is showing after approved");
        common.waitUntilElementToBeVisible(By.xpath(SUCCESSMSG));
        common.assertElementPresent(SUCCESSMSG);

        common.refreshPage();

        common.logPrint("Step:: Verified status is not showing as approved");

        verifyStockiestIsCreatedIsShowingInTheTableAndItStatusIsApproval(Stockiest);
    }

    public String[] updateTheStockiest(String stockiestName) {

        redirectsToStockiestPage();
        common.logPrint("Step:: Search doctor name in the search field");
        common.waitUntilElementToBeVisible(By.xpath(SEARCHFIELD));
        common.type(SEARCHFIELD, stockiestName);

        common.logPrint("Step:: Select first checkbox");
        common.pause(2);
        common.selectCheckBox(FIRSTEMAILCHECKBOX);

        common.logPrint("Step:: Click on the edit button");
        common.waitUntilElementToBeVisible(By.xpath(EDITBTN));
        common.click(EDITBTN);

        String StockistName = common.fakeName();
        common.logPrint("Step:: Enter Stockist name");
        common.waitUntilElementsToBeVisible(By.xpath(STOCKISTNAME)).clear();
        common.type(STOCKISTNAME, StockistName);
        common.logPrint("Stockiest name is: " + StockistName);

        common.logPrint("Step:: Enter mobile number");
        common.waitUntilElementToBeVisible(By.xpath(MOBILENO1FIELD)).clear();
        String updateMobileNum = common.generateRandomNumberString(10);
        common.type(MOBILENO1FIELD, updateMobileNum);

        common.logPrint("Step:: Click on the save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.logPrint("Step:: Check validation is displayed");
        common.assertElementDisplayed(UpdatedSuccessfully);

        return new String[]{StockistName, updateMobileNum};
    }

    public void redirectToParticularAdditionalDetailPage(String additionalDetailXpath) {

        redirectToTheDoctorAdditionalDetail();

        common.logPrint("Step:: Click on the Area of interest menu");
        common.scroll_To_Element(additionalDetailXpath);
        common.waitUntilElementToBeVisible(By.xpath(additionalDetailXpath));
        common.click(additionalDetailXpath);

        if (driver.findElement(By.xpath(ADDBTN)).isEnabled()) {
            common.logPrint("Step:: Add button is enabled");
            common.click(ADDBTN);
        } else {
            common.logPrint("Step:: Add button is not enabled");

            common.logPrint("Step:: Click on Area of interest menu");
            common.waitUntilElementToBeVisible(By.xpath(additionalDetailXpath));
            common.click(additionalDetailXpath);

            common.logPrint("Step:: Add button is enabled");
            common.click(ADDBTN);
        }

    }

    public void searchAndValidateAdditionalDetails(String SearchedTerms)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search']")));
        if  (Search.isDisplayed()) {
            common.searchAndValidate(SearchedTerms.toLowerCase());
            WebElement result = driver.findElement(By.xpath("//div[@title='" + SearchedTerms.toLowerCase() + "']"));
            System.out.println(result);
            if (result.isDisplayed()) {System.out.println("Success: Element with title '" + SearchedTerms.toLowerCase() + "' found.");}}
        else {
            common.click(DEGREEMENU);
            common.searchAndValidate(SearchedTerms.toLowerCase());
            WebElement result = driver.findElement(By.xpath("//div[@title='" + SearchedTerms.toLowerCase() + "']"));
            if (result.isDisplayed()) {System.out.println("Success: Element with title '" + SearchedTerms.toLowerCase() + "' found.");}
            else {System.out.println("Error");}
    }
    }

    public void verifyNewAdiDetailIsShowing(String value){

        common.logPrint("Step:: Search name in the search field");
        common.waitUntilElementToBeVisible(By.xpath(SEARCHFIELD));
        common.type(SEARCHFIELD, value);

        common.pause(1);
        common.logPrint("Step:: Verify the status is showing as pending");
        common.waitUntilElementToBeVisible(By.xpath(GETNAMEFROMFIRST));
        String getValue = driver.findElement(By.xpath(GETNAMEFROMFIRST)).getAttribute("title");
        common.assertTwoValuesAreEqual(getValue.toLowerCase(), value.toLowerCase());

        common.logPrint("The Additional detail is added successfully");

    }

    public void addDegree() {
        try {
//            redirectToTheDoctorAdditionalDetail();
//            common.pause(2);
//            WebElement addButton = driver.findElement(By.xpath(ADDBTN));
//            if (addButton.isEnabled()) {
//                common.logPrint("Step:: Add button is enabled");
//                common.click(ADDBTN);
//            } else {
//                common.logPrint("Step:: Add button is not enabled");
//                common.logPrint("Step:: Click on the Degree menu");
//                common.waitUntilElementToBeVisible(By.xpath(DEGREEMENU));
//                common.click(DEGREEMENU);
//                common.logPrint("Step:: Add button is enabled");
//                common.click(ADDBTN);
//            }
            redirectToParticularAdditionalDetailPage(DEGREEMENU);

            common.logPrint("Step:: Click on the Degree dropdown");
            common.waitUntilElementToBeVisible(By.xpath(DEGREEDROPDOWN));
            common.selectRandomValueFromDropdown(DEGREEDROPDOWN, 5);
            String enteredDegree = driver.findElement(By.xpath(DEGREESELECTED)).getAttribute("value");
            System.out.println(enteredDegree);

            common.logPrint("Step:: Click on the Speciality dropdown");
            common.waitUntilElementToBeVisible(By.xpath(SPECIALITYDRODOWN));
            common.click(SPECIALITYDRODOWN);
            common.downKeyAndEnter();

            String year = common.generateRandomYear("1998", "2001");
            common.logPrint("Step:: Enter Degree admission year");
            common.waitUntilElementToBeVisible(By.xpath(ADDMISSIONYEAR));
            common.type(ADDMISSIONYEAR, year);

            String passoutyear = common.generateRandomYear("2001", "2005");
            common.logPrint("Step:: Enter Degree Passout year");
            common.waitUntilElementToBeVisible(By.xpath(PASSOUTYEAR));
            common.type(PASSOUTYEAR, passoutyear);

            String degreeColllage = common.generateRandomChars(10);
            common.logPrint("Step:: Enter Degree college name");
            common.waitUntilElementToBeVisible(By.xpath(DEGREECOLLAGE));
            common.type(DEGREECOLLAGE, degreeColllage);

            String degreeRegNum = common.generateRandomNumberString(10);
            common.logPrint("Step:: Enter Degree registration number");
            common.waitUntilElementToBeVisible(By.xpath(DEGREEREGNUM));
            common.type(DEGREEREGNUM, degreeRegNum);

            common.logPrint("Step:: Select city from the dropdown");
            common.waitUntilElementToBeVisible(By.xpath(CITYINPUT));
            common.type(CITYINPUT, "AHMEDABAD");
            common.pause(1);
            common.downKeyAndEnter();
            common.logPrint("Selected city is: AHMEDABAD");

            common.scroll_To_Element(PINCODEDROPDOWN);

            common.logPrint("Step:: Select pincode from dropdown");
            common.waitUntilElementToBeVisible(By.xpath(PINCODEDROPDOWN));
            common.click(PINCODEDROPDOWN);
            common.twoDownKeyAndEnter();

            common.logPrint("Step:: Click on the save button");
            common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
            common.click(SAVEBUTTON);

            common.assertElementPresent(AddedSuccessfully);

            verifyNewAdiDetailIsShowing(enteredDegree);

            //searchAndValidateAdditionalDetails(enteredDegree.toUpperCase());

        } catch (NoSuchElementException e) {
            common.logPrint("Error: Element not found - " + e.getMessage());
            throw new RuntimeException("Failed to add degree due to missing element", e);
        } catch (TimeoutException e) {
            common.logPrint("Error: Operation timed out - " + e.getMessage());
            throw new RuntimeException("Failed to add degree due to timeout", e);
        } catch (ElementClickInterceptedException e) {
            common.logPrint("Error: Element click intercepted - " + e.getMessage());
            throw new RuntimeException("Failed to add degree due to click interception", e);
        } catch (StaleElementReferenceException e) {
            common.logPrint("Error: Stale element reference - " + e.getMessage());
            throw new RuntimeException("Failed to add degree due to stale element", e);
        } catch (Exception e) {
            common.logPrint("Unexpected error: " + e.getMessage());
            throw new RuntimeException("Failed to add degree due to unexpected error", e);
        }
    }

    public void addAreaOfInterest() {
        try {
            redirectToParticularAdditionalDetailPage(AREAOFINTEREST);

            common.logPrint("Step:: Select Area Of Interest In Medical Field");
            common.waitUntilElementToBeVisible(By.xpath(AREAOFINTERESTINMEDICAL));
            common.selectRandomValueFromDropdown(AREAOFINTERESTINMEDICAL, 10);
            String enteredAOI = driver.findElement(By.xpath(AREAOFINTERESTINMEDICALS)).getAttribute("value");
            System.out.println(enteredAOI);

            String areaRemark = common.generateRandomChars(20);
            common.logPrint("Step:: Enter interest of area remark");
            common.waitUntilElementToBeVisible(By.xpath(AREAREMARK));
            common.type(AREAREMARK, areaRemark);

            common.logPrint("Step:: Click on the save button");
            common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
            common.click(SAVEBUTTON);

            verifyNewAdiDetailIsShowing(enteredAOI);

            //searchAndValidateAdditionalDetails(enteredAOI);


        } catch (NoSuchElementException e) {
            common.logPrint("Error: Element not found - " + e.getMessage());
            throw new RuntimeException("Failed to add area of interest due to missing element", e);
        } catch (TimeoutException e) {
            common.logPrint("Error: Operation timed out - " + e.getMessage());
            throw new RuntimeException("Failed to add area of interest due to timeout", e);
        } catch (ElementClickInterceptedException e) {
            common.logPrint("Error: Element click intercepted - " + e.getMessage());
            throw new RuntimeException("Failed to add area of interest due to click interception", e);
        } catch (StaleElementReferenceException e) {
            common.logPrint("Error: Stale element reference - " + e.getMessage());
            throw new RuntimeException("Failed to add area of interest due to stale element", e);
        } catch (Exception e) {
            common.logPrint("Unexpected error: " + e.getMessage());
            throw new RuntimeException("Failed to add area of interest due to unexpected error", e);
        }
    }

    public void addGuidelinesFollowed() {
        try {
            redirectToParticularAdditionalDetailPage(GUIDELINESFOLLOWED);

            common.logPrint("Step:: Select guideline followed from dropdown");
            common.waitUntilElementToBeVisible(By.xpath(GUIDELINEFOLLOWEDDRP));
            common.click(GUIDELINEFOLLOWEDDRP);
            common.downKeyAndEnter();

            String areaRemark = common.generateRandomChars(20);
            common.logPrint("Step:: Enter guideline followed remark");
            common.waitUntilElementToBeVisible(By.xpath(AREAREMARK));
            common.type(AREAREMARK, areaRemark);

            common.logPrint("Step:: Click on the save button");
            common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
            common.click(SAVEBUTTON);

        } catch (NoSuchElementException e) {
            common.logPrint("Error: Element not found - " + e.getMessage());
            throw new RuntimeException("Failed to add guidelines followed due to missing element", e);
        } catch (TimeoutException e) {
            common.logPrint("Error: Operation timed out - " + e.getMessage());
            throw new RuntimeException("Failed to add guidelines followed due to timeout", e);
        } catch (ElementClickInterceptedException e) {
            common.logPrint("Error: Element click intercepted - " + e.getMessage());
            throw new RuntimeException("Failed to add guidelines followed due to click interception", e);
        } catch (StaleElementReferenceException e) {
            common.logPrint("Error: Stale element reference - " + e.getMessage());
            throw new RuntimeException("Failed to add guidelines followed due to stale element", e);
        } catch (Exception e) {
            common.logPrint("Unexpected error: " + e.getMessage());
            throw new RuntimeException("Failed to add guidelines followed due to unexpected error", e);
        }
    }

    public void addConferenceAndSpeaker() {
        try {
            redirectToParticularAdditionalDetailPage(CONFERENCESPECKER);

            common.logPrint("Step:: Select Subject type from dropdown");
            common.waitUntilElementToBeVisible(By.xpath(SUBJECTTYPE));
            common.click(SUBJECTTYPE);
            common.downKeyAndEnter();

            String startDate = common.generateDate("current", null, null);
            common.logPrint("Step:: Enter start date");
            common.waitUntilElementToBeVisible(By.xpath(STARTDATEINP));
            common.type(STARTDATEINP, startDate);

            String endDate = common.generateDate("future", null, null);
            common.logPrint("Step:: Enter end date");
            common.waitUntilElementToBeVisible(By.xpath(ENDDATEINP));
            common.type(ENDDATEINP, endDate);

            String days = common.generateRandomNumberString(2);
            common.logPrint("Step:: Enter days");
            common.waitUntilElementToBeVisible(By.xpath(DAYSINP));
            common.type(DAYSINP, days);

            String subject = common.generateRandomChars(10);
            common.logPrint("Step:: Enter Subject and Topic");
            common.waitUntilElementToBeVisible(By.xpath(SUBJECTTOPICINP));
            common.type(SUBJECTTOPICINP, subject);

            common.logPrint("Step:: Select Attendee as from dropdown");
            common.waitUntilElementToBeVisible(By.xpath(ATTENDEDASDRP));
            common.click(ATTENDEDASDRP);
            common.downKeyAndEnter();

            String venue = common.generateRandomChars(10);
            common.logPrint("Step:: Enter venue name");
            common.waitUntilElementToBeVisible(By.xpath(VENUEINP));
            common.type(VENUEINP, venue);

            String numberOfAttendee = common.generateRandomNumberString(2);
            common.logPrint("Step:: Enter number of attendees");
            common.waitUntilElementToBeVisible(By.xpath(NOOFATTENDEE));
            common.type(NOOFATTENDEE, numberOfAttendee);

            String areaRemark = common.generateRandomChars(20);
            common.logPrint("Step:: Enter guideline followed remark");
            common.waitUntilElementToBeVisible(By.xpath(AREAREMARK));
            common.type(AREAREMARK, areaRemark);

            common.logPrint("Step:: Click on the save button");
            common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
            common.click(SAVEBUTTON);

        } catch (NoSuchElementException e) {
            common.logPrint("Error: Element not found - " + e.getMessage());
            throw new RuntimeException("Failed to add conference and speaker due to missing element", e);
        } catch (TimeoutException e) {
            common.logPrint("Error: Operation timed out - " + e.getMessage());
            throw new RuntimeException("Failed to add conference and speaker due to timeout", e);
        } catch (ElementClickInterceptedException e) {
            common.logPrint("Error: Element click intercepted - " + e.getMessage());
            throw new RuntimeException("Failed to add conference and speaker due to click interception", e);
        } catch (StaleElementReferenceException e) {
            common.logPrint("Error: Stale element reference - " + e.getMessage());
            throw new RuntimeException("Failed to add conference and speaker due to stale element", e);
        } catch (Exception e) {
            common.logPrint("Unexpected error: " + e.getMessage());
            throw new RuntimeException("Failed to add conference and speaker due to unexpected error", e);
        }
    }

    public void addWeekendsAndVacation() {
        try {
            redirectToParticularAdditionalDetailPage(WEEKENDVACTION);

            common.logPrint("Step:: Select Entertainment from dropdown");
            common.waitUntilElementToBeVisible(By.xpath(ENTERTAINMENTDRP));
            common.click(ENTERTAINMENTDRP);
            common.downKeyAndEnter();

            common.logPrint("Step:: Select Activity type from dropdown");
            common.waitUntilElementToBeVisible(By.xpath(ACTIVITYTYPE));
            common.click(ACTIVITYTYPE);
            common.downKeyAndEnter();

            String place = common.generateRandomChars(10);
            common.logPrint("Step:: Enter Place");
            common.waitUntilElementToBeVisible(By.xpath(PLACEINPADDITIONALDETAIL));
            common.type(PLACEINPADDITIONALDETAIL, place);

            String date = common.generateDate("current", null, null);
            common.logPrint("Step:: Enter start date");
            common.waitUntilElementToBeVisible(By.xpath(PREFFREDDATE));
            common.type(PREFFREDDATE, date);

            String areaRemark = common.generateRandomChars(20);
            common.logPrint("Step:: Enter guideline followed remark");
            common.waitUntilElementToBeVisible(By.xpath(AREAREMARK));
            common.type(AREAREMARK, areaRemark);

            common.logPrint("Step:: Click on the save button");
            common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
            common.click(SAVEBUTTON);

        } catch (NoSuchElementException e) {
            common.logPrint("Error: Element not found - " + e.getMessage());
            throw new RuntimeException("Failed to add weekends and vacation due to missing element", e);
        } catch (TimeoutException e) {
            common.logPrint("Error: Operation timed out - " + e.getMessage());
            throw new RuntimeException("Failed to add weekends and vacation due to timeout", e);
        } catch (ElementClickInterceptedException e) {
            common.logPrint("Error: Element click intercepted - " + e.getMessage());
            throw new RuntimeException("Failed to add weekends and vacation due to click interception", e);
        } catch (StaleElementReferenceException e) {
            common.logPrint("Error: Stale element reference - " + e.getMessage());
            throw new RuntimeException("Failed to add weekends and vacation due to stale element", e);
        } catch (Exception e) {
            common.logPrint("Unexpected error: " + e.getMessage());
            throw new RuntimeException("Failed to add weekends and vacation due to unexpected error", e);
        }
    }

    public void addFamilyFriendDetailInfo() {
        try {
            redirectToParticularAdditionalDetailPage(FAMILYFRIENDDETAIL);

            String name = common.generateRandomChars(8);
            common.logPrint("Step:: Enter Name");
            common.waitUntilElementToBeVisible(By.xpath(NAMEINPFamily));
            common.type(NAMEINPFamily, name);

            common.logPrint("Step:: Select Relation from dropdown");
            common.waitUntilElementToBeVisible(By.xpath(RELATIONDRP));
            common.click(RELATIONDRP);
            common.downKeyAndEnter();

            String dob = common.generateDate("past", null, null);
            common.logPrint("Step:: Enter DOB");
            common.waitUntilElementToBeVisible(By.xpath(DOBINPAdd));
            common.type(DOBINPAdd, dob);

            String doa = common.generateDate("past", null, null);
            common.logPrint("Step:: Enter DOA");
            common.waitUntilElementToBeVisible(By.xpath(DOAINPAdd));
            common.type(DOAINPAdd, doa);

            String specialDay = common.generateRandomNumberString(7);
            common.logPrint("Step:: Enter days");
            common.waitUntilElementToBeVisible(By.xpath(SPECIALDAYDOBINP));
            common.type(SPECIALDAYDOBINP, specialDay);

            String specialDayDOB = common.generateDate("past", null, null);
            common.logPrint("Step:: Enter Special Day DOB");
            common.waitUntilElementToBeVisible(By.xpath(SPECIALDAYDOBINPAdd));
            common.type(SPECIALDAYDOBINPAdd, specialDayDOB);

            String remarks = common.generateRandomChars(25);
            common.logPrint("Step:: Enter Remarks");
            common.waitUntilElementToBeVisible(By.xpath(REMARKINP));
            common.type(REMARKINP, remarks);

            common.logPrint("Step:: Click on Save button");
            common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
            common.click(SAVEBUTTON);

        } catch (NoSuchElementException e) {
            common.logPrint("Error: Element not found - " + e.getMessage());
            throw new RuntimeException("Failed to add family friend detail due to missing element", e);
        } catch (TimeoutException e) {
            common.logPrint("Error: Operation timed out - " + e.getMessage());
            throw new RuntimeException("Failed to add family friend detail due to timeout", e);
        } catch (ElementClickInterceptedException e) {
            common.logPrint("Error: Element click intercepted - " + e.getMessage());
            throw new RuntimeException("Failed to add family friend detail due to click interception", e);
        } catch (StaleElementReferenceException e) {
            common.logPrint("Error: Stale element reference - " + e.getMessage());
            throw new RuntimeException("Failed to add family friend detail due to stale element", e);
        } catch (Exception e) {
            common.logPrint("Unexpected error: " + e.getMessage());
            throw new RuntimeException("Failed to add family friend detail due to unexpected error", e);
        }
    }

    public void addCollegeMateAndAlumniDetails() {
        try {
            redirectToParticularAdditionalDetailPage(COLLEGEALUMNIDETAILS);

            String name = common.fakeName();
            common.logPrint("Step:: Enter Name");
            common.waitUntilElementToBeVisible(By.xpath(COLLEAGUENAME));
            common.type(COLLEAGUENAME, name);
            common.logPrint("Entered Name: " + name);

            common.logPrint("Step :: Enter Date of Birth");
            common.waitUntilElementToBeVisible(By.xpath(COLLEAGUEDATEOFBIRTH));
            common.type(COLLEAGUEDATEOFBIRTH, "26-06-2025");

            common.logPrint("Step :: Enter Speciality");
            common.click(COLLEAGUESPECIALITY);
            common.twoDownKeyAndEnter();

            common.logPrint("Step :: Enter Hospital Name");
            common.click(COLLEAGUEHOSPITAL);
            common.type(COLLEAGUEHOSPITAL, "Test Hospital");

            common.logPrint("Step :: Enter College Name");
            common.click(COLLEAGUECOLLEGE);
            common.type(COLLEAGUECOLLEGE, "College" + name);

            common.logPrint("Step :: Enter Passout Year");
            common.click(COLLEAGUEPASSOUTYEAR);
            common.type(COLLEAGUEPASSOUTYEAR, "2025");

            common.logPrint("Step :: Enter Remarks");
            common.click(REMARKS);
            common.type(REMARKS, "2025 Remarks");

            common.fillBothAddress();

            common.logPrint("Step:: Click on Save button");
            common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
            common.click(SAVEBUTTON);

        } catch (NoSuchElementException e) {
            common.logPrint("Error: Element not found - " + e.getMessage());
            throw new RuntimeException("Failed to add college mate and alumni details due to missing element", e);
        } catch (TimeoutException e) {
            common.logPrint("Error: Operation timed out - " + e.getMessage());
            throw new RuntimeException("Failed to add college mate and alumni details due to timeout", e);
        } catch (ElementClickInterceptedException e) {
            common.logPrint("Error: Element click intercepted - " + e.getMessage());
            throw new RuntimeException("Failed to add college mate and alumni details due to click interception", e);
        } catch (StaleElementReferenceException e) {
            common.logPrint("Error: Stale element reference - " + e.getMessage());
            throw new RuntimeException("Failed to add college mate and alumni details due to stale element", e);
        } catch (Exception e) {
            common.logPrint("Unexpected error: " + e.getMessage());
            throw new RuntimeException("Failed to add college mate and alumni details due to unexpected error", e);
        }
    }

    public void addSocialActivities() {
        try {
            redirectToParticularAdditionalDetailPage(CSR);

            common.logPrint("Step :: Enter CSR Activity");
            common.waitUntilElementToBeVisible(By.xpath(CSRACTIVITY));
            common.type(CSRACTIVITY, "Activity");

            common.logPrint("Step :: Select NGO");
            common.waitUntilElementToBeVisible(By.xpath(CSRNGO));
            common.click(CSRNGO);
            common.twoDownKeyAndEnter();

            common.logPrint("Step :: Entering No. of Participants");
            common.waitUntilElementToBeVisible(By.xpath(CSRPARTICIPANTS));
            common.type(CSRPARTICIPANTS, "10");

            common.logPrint("Step :: Entering CSR Venue");
            common.waitUntilElementToBeVisible(By.xpath(CSRVENUE));
            common.type(CSRVENUE, "Ahmedabad");

            common.logPrint("Step :: Entering Amount Spent");
            common.waitUntilElementToBeVisible(By.xpath(CSRAMOUNT));
            common.type(CSRAMOUNT, "10000");

            common.logPrint("Step :: Entering Sponsors");
            common.waitUntilElementToBeVisible(By.xpath(CSRSPONSORS));
            common.type(CSRSPONSORS, "Sponsors");

            common.logPrint("Step :: Entering Remarks");
            common.waitUntilElementToBeVisible(By.xpath(CSRREMARKS));
            common.type(CSRREMARKS, "Remarks");

            common.logPrint("Step :: Entering Desc");
            common.waitUntilElementToBeVisible(By.xpath(CSRDESC));
            common.type(CSRDESC, "Desc");

            common.logPrint("Step :: Entering Address line 1");
            common.waitUntilElementToBeVisible(By.xpath(CSRAD1));
            common.type(CSRAD1, "Ahmedabad");

            common.logPrint("Step :: Entering Address line 2");
            common.waitUntilElementToBeVisible(By.xpath(CSRAD2));
            common.type(CSRAD2, "Ahmedabad");

            common.logPrint("Step :: Entering City");
            common.waitUntilElementToBeVisible(By.xpath(CSRCITY));
            common.type(CSRCITY, "Ahmedabad");
            common.twoDownKeyAndEnter();

            common.logPrint("Step :: Entering Pincode");
            common.waitUntilElementToBeVisible(By.xpath(CSRPINCODE));
            common.type(CSRPINCODE, "");
            common.twoDownKeyAndEnter();

            common.logPrint("Step:: Click on Save button");
            common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
            common.click(SAVEBUTTON);

        } catch (NoSuchElementException e) {
            common.logPrint("Error: Element not found - " + e.getMessage());
            throw new RuntimeException("Failed to add social activities due to missing element", e);
        } catch (TimeoutException e) {
            common.logPrint("Error: Operation timed out - " + e.getMessage());
            throw new RuntimeException("Failed to add social activities due to timeout", e);
        } catch (ElementClickInterceptedException e) {
            common.logPrint("Error: Element click intercepted - " + e.getMessage());
            throw new RuntimeException("Failed to add social activities due to click interception", e);
        } catch (StaleElementReferenceException e) {
            common.logPrint("Error: Stale element reference - " + e.getMessage());
            throw new RuntimeException("Failed to add social activities due to stale element", e);
        } catch (Exception e) {
            common.logPrint("Unexpected error: " + e.getMessage());
            throw new RuntimeException("Failed to add social activities due to unexpected error", e);
        }
    }

    public void addAssociatedHospital() {
        try {
            redirectToParticularAdditionalDetailPage(AH);

            common.logPrint("Step :: Enter Associated Hospital");
            common.waitUntilElementToBeVisible(By.xpath(AHNAME));
            common.type(AHNAME, "Associated Hospital");

            common.logPrint("Step :: Enter Hospital City");
            common.waitUntilElementToBeVisible(By.xpath(AHCITY));
            common.type(AHCITY, "Ahmedabad");
            common.pause(1);
            common.downKeyAndEnter();

            common.logPrint("Step :: Enter Active Checkbox");
            common.selectCheckBox(AHACTIVE);

            common.logPrint("Step :: Select Is Recursive");
            common.waitUntilElementToBeVisible(By.xpath(AHRECURSIVE));
            common.type(AHRECURSIVE, "");
            common.twoDownKeyAndEnter();

            common.logPrint("Step :: Enter Daily Patient count");
            common.waitUntilElementToBeVisible(By.xpath(AHHOSPITAL));
            common.type(AHHOSPITAL, "10");

            common.logPrint("Step :: Enter Weekly Patient count");
            common.waitUntilElementToBeVisible(By.xpath(AHHOSPITALWEEKLY));
            common.type(AHHOSPITALWEEKLY, "100");

            common.logPrint("Step :: Enter Monthly Patient count");
            common.waitUntilElementToBeVisible(By.xpath(AHHOSPITAMONTHLY));
            common.type(AHHOSPITAMONTHLY, "1000");

            common.logPrint("Step :: Enter Address Line 1");
            common.waitUntilElementToBeVisible(By.xpath(AHADDRESS1));
            common.type(AHADDRESS1, "Ahmedabad");

            common.logPrint("Step :: Enter Address Line 2");
            common.waitUntilElementToBeVisible(By.xpath(AHADDRESS2));
            common.type(AHADDRESS2, "Ahmedabad");

            common.logPrint("Step :: Enter City");
            common.waitUntilElementToBeVisible(By.xpath(AHCITYD));
            common.type(AHCITYD, "Ahmedabad");
            common.downKeyAndEnter();

            common.logPrint("Step :: Enter Pincode");
            common.waitUntilElementToBeVisible(By.xpath(AHPINCODE));
            common.type(AHPINCODE, "");
            common.twoDownKeyAndEnter();

            common.logPrint("Step:: Click on Save button");
            common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
            common.click(SAVEBUTTON);

        } catch (NoSuchElementException e) {
            common.logPrint("Error: Element not found - " + e.getMessage());
            throw new RuntimeException("Failed to add associated hospital due to missing element", e);
        } catch (TimeoutException e) {
            common.logPrint("Error: Operation timed out - " + e.getMessage());
            throw new RuntimeException("Failed to add associated hospital due to timeout", e);
        } catch (ElementClickInterceptedException e) {
            common.logPrint("Error: Element click intercepted - " + e.getMessage());
            throw new RuntimeException("Failed to add associated hospital due to click interception", e);
        } catch (StaleElementReferenceException e) {
            common.logPrint("Error: Stale element reference - " + e.getMessage());
            throw new RuntimeException("Failed to add associated hospital due to stale element", e);
        } catch (Exception e) {
            common.logPrint("Unexpected error: " + e.getMessage());
            throw new RuntimeException("Failed to add associated hospital due to unexpected error", e);
        }
    }

    public void addPatientsReferTo() {
        try {
            redirectToParticularAdditionalDetailPage(PRT);

            String name = common.fakeName();
            common.logPrint("Step :: Enter Name");
            common.waitUntilElementToBeVisible(By.xpath(PRTDRNAME));
            common.type(PRTDRNAME, name);

            common.logPrint("Step :: PRT Speciality");
            common.waitUntilElementToBeVisible(By.xpath(PRTSPECIALITY));
            common.type(PRTSPECIALITY, "");
            common.twoDownKeyAndEnter();

            common.logPrint("Step :: Enter Hospital name");
            common.waitUntilElementToBeVisible(By.xpath(PRTHOSPITALNAME));
            common.type(PRTHOSPITALNAME, name);

            common.logPrint("Step :: PRT Priority");
            common.waitUntilElementToBeVisible(By.xpath(PRTPRIORITY));
            common.type(PRTPRIORITY, "");
            common.twoDownKeyAndEnter();

            common.logPrint("Step :: PRT Patient Name");
            common.waitUntilElementToBeVisible(By.xpath(PRTPATIENTNAME));
            common.type(PRTPATIENTNAME, name);

            common.logPrint("Step :: PRT Mobile");
            common.waitUntilElementToBeVisible(By.xpath(PRTMOBILE));
            common.type(PRTMOBILE, "9871727272");

            common.logPrint("Step :: PRT Date");
            common.waitUntilElementToBeVisible(By.xpath(PRTDATE));
            common.type(PRTDATE, "27-06-2025");

            common.logPrint("Step :: PRT Address 1");
            common.waitUntilElementToBeVisible(By.xpath(PRTAD1));
            common.type(PRTAD1, "Ahmedabad");

            common.logPrint("Step :: PRT Address 2");
            common.waitUntilElementToBeVisible(By.xpath(PRTAD2));
            common.type(PRTAD2, "Ahmedabad");

            common.logPrint("Step :: PRT City");
            common.waitUntilElementToBeVisible(By.xpath(PRTCITY));
            common.type(PRTCITY, "Ahmedabad");
            common.downKeyAndEnter();

            common.logPrint("Step :: PRT Pincode");
            common.waitUntilElementToBeVisible(By.xpath(PRTPINCODE));
            common.type(PRTPINCODE, "");
            common.twoDownKeyAndEnter();

            common.logPrint("Step:: Click on Save button");
            common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
            common.click(SAVEBUTTON);

        } catch (NoSuchElementException e) {
            common.logPrint("Error: Element not found - " + e.getMessage());
            throw new RuntimeException("Failed to add patients refer to due to missing element", e);
        } catch (TimeoutException e) {
            common.logPrint("Error: Operation timed out - " + e.getMessage());
            throw new RuntimeException("Failed to add patients refer to due to timeout", e);
        } catch (ElementClickInterceptedException e) {
            common.logPrint("Error: Element click intercepted - " + e.getMessage());
            throw new RuntimeException("Failed to add patients refer to due to click interception", e);
        } catch (StaleElementReferenceException e) {
            common.logPrint("Error: Stale element reference - " + e.getMessage());
            throw new RuntimeException("Failed to add patients refer to due to stale element", e);
        } catch (Exception e) {
            common.logPrint("Unexpected error: " + e.getMessage());
            throw new RuntimeException("Failed to add patients refer to due to unexpected error", e);
        }
    }

    public void addPatientRefSource() {
        try {
            redirectToParticularAdditionalDetailPage(PRS);

            String name = common.fakeName();
            common.logPrint("Step :: Enter Name");
            common.waitUntilElementToBeVisible(By.xpath(PRSNAME));
            common.type(PRSNAME, name);

            common.logPrint("Step :: PRS Speciality");
            common.waitUntilElementToBeVisible(By.xpath(PRSSPECIALITY));
            common.type(PRSSPECIALITY, "");
            common.twoDownKeyAndEnter();

            common.logPrint("Step :: PRS Hospital");
            common.waitUntilElementToBeVisible(By.xpath(PRSHOSPITAL));
            common.type(PRSHOSPITAL, "Name");

            common.logPrint("Step :: PRS Priority");
            common.waitUntilElementToBeVisible(By.xpath(PRSPRIORITY));
            common.type(PRSPRIORITY, "");
            common.twoDownKeyAndEnter();

            common.logPrint("Step :: Enter Patient Name");
            common.waitUntilElementToBeVisible(By.xpath(PRSPATIENTNAME));
            common.type(PRSPATIENTNAME, name);

            common.logPrint("Step :: Enter PRS Mobile");
            common.waitUntilElementToBeVisible(By.xpath(PRSMOBILE));
            common.type(PRSMOBILE, "1231231231");

            common.logPrint("Step :: Enter Date");
            common.waitUntilElementToBeVisible(By.xpath(PRSREFERDATE));
            common.type(PRSREFERDATE, common.generateCurDate());

            common.logPrint("Step :: Enter PRS Address");
            common.waitUntilElementToBeVisible(By.xpath(PRSAD1));
            common.type(PRSAD1, "Ahmedabad");

            common.logPrint("Step :: Enter PRS Address");
            common.waitUntilElementToBeVisible(By.xpath(PRSAD2));
            common.type(PRSAD2, "Ahmedabad");

            common.logPrint("Step :: PRS City");
            common.waitUntilElementToBeVisible(By.xpath(PRSCITY));
            common.type(PRSCITY, "Ahmedabad");
            common.downKeyAndEnter();

            common.logPrint("Step :: PRS Pincode");
            common.waitUntilElementToBeVisible(By.xpath(PRSPINCODE));
            common.type(PRSPINCODE, "");
            common.twoDownKeyAndEnter();

            common.logPrint("Step:: Click on Save button");
            common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
            common.click(SAVEBUTTON);

        } catch (NoSuchElementException e) {
            common.logPrint("Error: Element not found - " + e.getMessage());
            throw new RuntimeException("Failed to add patient reference source due to missing element", e);
        } catch (TimeoutException e) {
            common.logPrint("Error: Operation timed out - " + e.getMessage());
            throw new RuntimeException("Failed to add patient reference source due to timeout", e);
        } catch (ElementClickInterceptedException e) {
            common.logPrint("Error: Element click intercepted - " + e.getMessage());
            throw new RuntimeException("Failed to add patient reference source due to click interception", e);
        } catch (StaleElementReferenceException e) {
            common.logPrint("Error: Stale element reference - " + e.getMessage());
            throw new RuntimeException("Failed to add patient reference source due to stale element", e);
        } catch (Exception e) {
            common.logPrint("Unexpected error: " + e.getMessage());
            throw new RuntimeException("Failed to add patient reference source due to unexpected error", e);
        }
    }

    public void addConsultingFess() {
        try {
            redirectToParticularAdditionalDetailPage(CFC);

            common.logPrint("Step :: CFC Type");
            common.waitUntilElementToBeVisible(By.xpath(CFCTYPE));
            common.type(CFCTYPE, "");
            common.twoDownKeyAndEnter();

            common.logPrint("Step :: CFC Amount");
            common.waitUntilElementToBeVisible(By.xpath(CFCAMOUNT));
            common.type(CFCAMOUNT, "1000");

            common.logPrint("Step :: Enter Start Date");
            common.waitUntilElementToBeVisible(By.xpath(CFCSDATE));
            common.type(CFCSDATE, common.generateCurDate());

            common.logPrint("Step :: Enter End Date");
            common.waitUntilElementToBeVisible(By.xpath(CFCEDATE));
            common.type(CFCEDATE, common.generateCurDate());

            common.logPrint("Step :: Entering CFC Duration");
            common.waitUntilElementToBeVisible(By.xpath(CFCDURATION));
            common.type(CFCDURATION, "Name");

            common.logPrint("Step :: Entering CFC Current Amount");
            common.waitUntilElementToBeVisible(By.xpath(CFCAMOUNTS));
            common.type(CFCAMOUNTS, "Name");

            common.logPrint("Step:: Click on Save button");
            common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
            common.click(SAVEBUTTON);

        } catch (NoSuchElementException e) {
            common.logPrint("Error: Element not found - " + e.getMessage());
            throw new RuntimeException("Failed to add consulting fees due to missing element", e);
        } catch (TimeoutException e) {
            common.logPrint("Error: Operation timed out - " + e.getMessage());
            throw new RuntimeException("Failed to add consulting fees due to timeout", e);
        } catch (ElementClickInterceptedException e) {
            common.logPrint("Error: Element click intercepted - " + e.getMessage());
            throw new RuntimeException("Failed to add consulting fees due to click interception", e);
        } catch (StaleElementReferenceException e) {
            common.logPrint("Error: Stale element reference - " + e.getMessage());
            throw new RuntimeException("Failed to add consulting fees due to stale element", e);
        } catch (Exception e) {
            common.logPrint("Unexpected error: " + e.getMessage());
            throw new RuntimeException("Failed to add consulting fees due to unexpected error", e);
        }
    }

    public void addConsultingFessMR() {
        try {
            redirectToParticularAdditionalDetailPage(CFM);

            common.logPrint("Step :: CFM Type");
            common.waitUntilElementToBeVisible(By.xpath(CFMTYPE));
            common.type(CFMTYPE, "");
            common.twoDownKeyAndEnter();

            common.logPrint("Step :: Entering CFM Current Amount");
            common.waitUntilElementToBeVisible(By.xpath(CFMAMOUNT));
            common.type(CFMAMOUNT, "1000");

            common.logPrint("Step :: Entering CFM Valid Upto");
            common.waitUntilElementToBeVisible(By.xpath(CFMVALIDUPTO));
            common.type(CFMVALIDUPTO, "30");

            common.logPrint("Step:: Click on Save button");
            common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
            common.click(SAVEBUTTON);

        } catch (NoSuchElementException e) {
            common.logPrint("Error: Element not found - " + e.getMessage());
            throw new RuntimeException("Failed to add consulting fees MR due to missing element", e);
        } catch (TimeoutException e) {
            common.logPrint("Error: Operation timed out - " + e.getMessage());
            throw new RuntimeException("Failed to add consulting fees MR due to timeout", e);
        } catch (ElementClickInterceptedException e) {
            common.logPrint("Error: Element click intercepted - " + e.getMessage());
            throw new RuntimeException("Failed to add consulting fees MR due to click interception", e);
        } catch (StaleElementReferenceException e) {
            common.logPrint("Error: Stale element reference - " + e.getMessage());
            throw new RuntimeException("Failed to add consulting fees MR due to stale element", e);
        } catch (Exception e) {
            common.logPrint("Unexpected error: " + e.getMessage());
            throw new RuntimeException("Failed to add consulting fees MR due to unexpected error", e);
        }
    }

    public void addMedicalAdvisory() {
        try {
            redirectToParticularAdditionalDetailPage(MEDICALADVISORYSPEAKER);

            common.logPrint("Step :: Entering MPurpose");
            common.waitUntilElementToBeVisible(By.xpath(MPURPOSE));
            common.type(MPURPOSE, "ADVICE");

            common.logPrint("Step :: Entering MAmount");
            common.waitUntilElementToBeVisible(By.xpath(MAMOUNT));
            common.type(MAMOUNT, "100");

            common.logPrint("Step :: Entering MCompany");
            common.waitUntilElementToBeVisible(By.xpath(MCOMPANY));
            common.type(MCOMPANY, "Test");

            common.logPrint("Step :: Entering MStart Date");
            common.waitUntilElementToBeVisible(By.xpath(MSTARTDATE));
            common.type(MSTARTDATE, "04-07-2025");

            common.logPrint("Step :: Entering MEnd Date");
            common.waitUntilElementToBeVisible(By.xpath(MENDDATE));
            common.type(MENDDATE, "04-07-2025");

            common.logPrint("Step :: Entering MBusiness");
            common.waitUntilElementToBeVisible(By.xpath(MBUSINESS));
            common.type(MBUSINESS, "Test");

            common.logPrint("Step :: Entering MRemarks");
            common.waitUntilElementToBeVisible(By.xpath(MREMARKS));
            common.type(MREMARKS, "Remarks");

            common.logPrint("Step :: Entering MAddress");
            common.waitUntilElementToBeVisible(By.xpath(MADDRESS));
            common.type(MADDRESS, "Ahmedabad");

            common.logPrint("Step :: Entering MAddress");
            common.waitUntilElementToBeVisible(By.xpath(MADDRESS2));
            common.type(MADDRESS2, "Ahmedabad");

            common.logPrint("Step :: Entering MCity");
            common.waitUntilElementToBeVisible(By.xpath(MCITY));
            common.type(MCITY, "Ahmedabad");
            common.twoDownKeyAndEnter();

            common.logPrint("Step :: Entering MPincode");
            common.waitUntilElementToBeVisible(By.xpath(MPINCODE));
            common.type(MPINCODE, "");
            common.twoDownKeyAndEnter();

            common.logPrint("Step:: Click on Save button");
            common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
            common.click(SAVEBUTTON);

        } catch (NoSuchElementException e) {
            common.logPrint("Error: Element not found - " + e.getMessage());
            throw new RuntimeException("Failed to add medical advisory due to missing element", e);
        } catch (TimeoutException e) {
            common.logPrint("Error: Operation timed out - " + e.getMessage());
            throw new RuntimeException("Failed to add medical advisory due to timeout", e);
        } catch (ElementClickInterceptedException e) {
            common.logPrint("Error: Element click intercepted - " + e.getMessage());
            throw new RuntimeException("Failed to add medical advisory due to click interception", e);
        } catch (StaleElementReferenceException e) {
            common.logPrint("Error: Stale element reference - " + e.getMessage());
            throw new RuntimeException("Failed to add medical advisory due to stale element", e);
        } catch (Exception e) {
            common.logPrint("Unexpected error: " + e.getMessage());
            throw new RuntimeException("Failed to add medical advisory due to unexpected error", e);
        }
    }

    public void addAchievements() {
        try {
            redirectToParticularAdditionalDetailPage(ACHIEVEMENTS);

            common.logPrint("Step :: Selecting Achievements");
            common.waitUntilElementToBeVisible(By.xpath(ACHIEVEMENTSADD));
            common.type(ACHIEVEMENTSADD, "");
            common.twoDownKeyAndEnter();

            common.logPrint("Step :: Selecting Date");
            common.waitUntilElementToBeVisible(By.xpath(ACHIEVEMENTSDATE));
            common.type(ACHIEVEMENTSDATE, "04-07-2025");

            common.logPrint("Step :: Adding Remarks");
            common.waitUntilElementToBeVisible(By.xpath(ACHIEVEMENTSREMARKS));
            common.type(ACHIEVEMENTSREMARKS, " Remarks");

            common.logPrint("Step :: Adding image");
            String file = "\\1.JPG";
            String pathToSend = System.getProperty("user.dir")+file;
            common.logPrint(pathToSend);
            WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
            fileInput.sendKeys(pathToSend);

            common.logPrint("Step:: Click on Save button");
            common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
            common.click(SAVEBUTTON);

        } catch (NoSuchElementException e) {
            common.logPrint("Error: Element not found - " + e.getMessage());
            throw new RuntimeException("Failed to add achievements due to missing element", e);
        } catch (TimeoutException e) {
            common.logPrint("Error: Operation timed out - " + e.getMessage());
            throw new RuntimeException("Failed to add achievements due to timeout", e);
        } catch (ElementClickInterceptedException e) {
            common.logPrint("Error: Element click intercepted - " + e.getMessage());
            throw new RuntimeException("Failed to add achievements due to click interception", e);
        } catch (StaleElementReferenceException e) {
            common.logPrint("Error: Stale element reference - " + e.getMessage());
            throw new RuntimeException("Failed to add achievements due to stale element", e);
        } catch (Exception e) {
            common.logPrint("Unexpected error: " + e.getMessage());
            throw new RuntimeException("Failed to add achievements due to unexpected error", e);
        }
    }

    public void addProceduralEquipment() {
        try {
            redirectToParticularAdditionalDetailPage(PE);

            common.logPrint("Step :: Entering PE Name");
            common.waitUntilElementToBeVisible(By.xpath(PENAME));
            common.type(PENAME, "Test");

            common.logPrint("Step :: Entering Vendor Name");
            common.waitUntilElementToBeVisible(By.xpath(PEVENDOR));
            common.type(PEVENDOR, "Test Vendor");

            common.logPrint("Step :: Entering PE Date");
            common.waitUntilElementToBeVisible(By.xpath(PEDATE));
            common.type(PEDATE, "07-07-2025");

            common.logPrint("Step :: Entering PE Price");
            common.waitUntilElementToBeVisible(By.xpath(PEPRICE));
            common.type(PEPRICE, "100");

            common.logPrint("Step :: Entering Remarks");
            common.waitUntilElementToBeVisible(By.xpath(PEREMARKS));
            common.type(PEREMARKS, "Test Remarks");

            common.logPrint("Step :: Clicking the Save button");
            common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
            common.click(SAVEBUTTON);

        } catch (NoSuchElementException e) {
            common.logPrint("Error: Element not found - " + e.getMessage());
            throw new RuntimeException("Failed to add procedural equipment due to missing element", e);
        } catch (TimeoutException e) {
            common.logPrint("Error: Operation timed out - " + e.getMessage());
            throw new RuntimeException("Failed to add procedural equipment due to timeout", e);
        } catch (ElementClickInterceptedException e) {
            common.logPrint("Error: Element click intercepted - " + e.getMessage());
            throw new RuntimeException("Failed to add procedural equipment due to click interception", e);
        } catch (StaleElementReferenceException e) {
            common.logPrint("Error: Stale element reference - " + e.getMessage());
            throw new RuntimeException("Failed to add procedural equipment due to stale element", e);
        } catch (Exception e) {
            common.logPrint("Unexpected error: " + e.getMessage());
            throw new RuntimeException("Failed to add procedural equipment due to unexpected error", e);
        }
    }

    public void addDoctorBankDetails() {
        try {
            redirectToParticularAdditionalDetailPage(DBD);

            common.logPrint("Step :: Entering Bank Name");
            common.waitUntilElementToBeVisible(By.xpath(DBDBANKNAME));
            common.type(DBDBANKNAME, "BOB");

            common.logPrint("Step :: Entering Bank Account");
            common.waitUntilElementToBeVisible(By.xpath(DBDACCOUNT));
            common.type(DBDACCOUNT, "07072025321");

            common.logPrint("Step :: Entering Bank IFSC");
            common.waitUntilElementToBeVisible(By.xpath(DBDIFSC));
            common.type(DBDIFSC, "07072025321");

            common.logPrint("Step :: Entering Bank Account Holder");
            common.waitUntilElementToBeVisible(By.xpath(DBDACCOUNTHOLDER));
            common.type(DBDACCOUNTHOLDER, "NAME");

            common.logPrint("Step :: Clicking the Save button");
            common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
            common.click(SAVEBUTTON);

        } catch (NoSuchElementException e) {
            common.logPrint("Error: Element not found - " + e.getMessage());
            throw new RuntimeException("Failed to add doctor bank details due to missing element", e);
        } catch (TimeoutException e) {
            common.logPrint("Error: Operation timed out - " + e.getMessage());
            throw new RuntimeException("Failed to add doctor bank details due to timeout", e);
        } catch (ElementClickInterceptedException e) {
            common.logPrint("Error: Element click intercepted - " + e.getMessage());
            throw new RuntimeException("Failed to add doctor bank details due to click interception", e);
        } catch (StaleElementReferenceException e) {
            common.logPrint("Error: Stale element reference - " + e.getMessage());
            throw new RuntimeException("Failed to add doctor bank details due to stale element", e);
        } catch (Exception e) {
            common.logPrint("Unexpected error: " + e.getMessage());
            throw new RuntimeException("Failed to add doctor bank details due to unexpected error", e);
        }
    }

    public void addSpecialDay() {
        try {
            redirectToParticularAdditionalDetailPage(SD);

            common.logPrint("Step :: Entering Special Day Name");
            common.waitUntilElementToBeVisible(By.xpath(SDNAME));
            common.type(SDNAME, "Special Day");

            common.logPrint("Step :: Entering Special Date");
            common.waitUntilElementToBeVisible(By.xpath(SDDATE));
            common.type(SDDATE, "07-07-2025");

            common.logPrint("Step :: Clicking the Save button");
            common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
            common.click(SAVEBUTTON);

        } catch (NoSuchElementException e) {
            common.logPrint("Error: Element not found - " + e.getMessage());
            throw new RuntimeException("Failed to add special day due to missing element", e);
        } catch (TimeoutException e) {
            common.logPrint("Error: Operation timed out - " + e.getMessage());
            throw new RuntimeException("Failed to add special day due to timeout", e);
        } catch (ElementClickInterceptedException e) {
            common.logPrint("Error: Element click intercepted - " + e.getMessage());
            throw new RuntimeException("Failed to add special day due to click interception", e);
        } catch (StaleElementReferenceException e) {
            common.logPrint("Error: Stale element reference - " + e.getMessage());
            throw new RuntimeException("Failed to add special day due to stale element", e);
        } catch (Exception e) {
            common.logPrint("Unexpected error: " + e.getMessage());
            throw new RuntimeException("Failed to add special day due to unexpected error", e);
        }
    }

    public void addDoctorVendor() {
        try {
            redirectToParticularAdditionalDetailPage(DV);

            common.logPrint("Step :: Selecting Doctor Vendor");
            common.waitUntilElementToBeVisible(By.xpath(DVSERVICE));
            common.type(DVSERVICE, "");
            common.twoDownKeyAndEnter();

            common.logPrint("Step :: Entering Doctor Vendor Head");
            common.waitUntilElementToBeVisible(By.xpath(DVHEAD));
            common.type(DVHEAD, "Doctor Vendor");

            common.logPrint("Step :: Entering Doctor Vendor Phone");
            common.waitUntilElementToBeVisible(By.xpath(DVPHONE));
            common.type(DVPHONE, "1231231231");

            common.logPrint("Step :: Entering Doctor Vendor Date");
            common.waitUntilElementToBeVisible(By.xpath(DVDATE));
            common.type(DVDATE, "07-07-2025");

            common.logPrint("Step :: Entering Doctor Vendor Note");
            common.waitUntilElementToBeVisible(By.xpath(DVNOTE));
            common.type(DVNOTE, "Notes");

            common.logPrint("Step :: Clicking the Save button");
            common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
            common.click(SAVEBUTTON);

        } catch (NoSuchElementException e) {
            common.logPrint("Error: Element not found - " + e.getMessage());
            throw new RuntimeException("Failed to add doctor vendor due to missing element", e);
        } catch (TimeoutException e) {
            common.logPrint("Error: Operation timed out - " + e.getMessage());
            throw new RuntimeException("Failed to add doctor vendor due to timeout", e);
        } catch (ElementClickInterceptedException e) {
            common.logPrint("Error: Element click intercepted - " + e.getMessage());
            throw new RuntimeException("Failed to add doctor vendor due to click interception", e);
        } catch (StaleElementReferenceException e) {
            common.logPrint("Error: Stale element reference - " + e.getMessage());
            throw new RuntimeException("Failed to add doctor vendor due to stale element", e);
        } catch (RuntimeException e) {
            common.logPrint("Error:" + e.getMessage());
            throw new RuntimeException("Fail, e");
        } catch (Exception e) {
            common.logPrint("Unexpected error: " + e.getMessage());
            throw new RuntimeException("Failed to add doctor vendor due to unexpected error", e);
        }
    }
    public String addANewProduct() {

        try {

        common.logPrint("Step:: Click on the admin panel menu");
        common.assertElementDisplayed(ADMINPANELMENU);
        common.click(ADMINPANELMENU);

        common.logPrint("Step:: Click on the Product Menu");
        common.assertElementDisplayed(MASTERPRODUCT);
        common.click(MASTERPRODUCT);

        common.logPrint("Step:: Click on the Product add button");
        common.assertElementDisplayed(PRODUCTADD);
        common.click(PRODUCTADD);

        common.logPrint("Step:: Adding the Product Divison");
        common.assertElementDisplayed(PRODUCTDIV);
        common.click(PRODUCTDIV);
        common.type(PRODUCTDIV, "BIOS DERMA");
        common.twoDownKeyAndEnter();

        common.logPrint("Step:: Adding the Product Drug Head");
        common.assertElementDisplayed(PRODUCTDRUGHEAD);
        common.click(PRODUCTDRUGHEAD);
        common.type(PRODUCTDRUGHEAD, "");
        common.twoDownKeyAndEnter();

        common.logPrint("Step:: Adding the Product Line");
        common.assertElementDisplayed(PRODUCTLINE);
        common.click(PRODUCTLINE);
        common.type(PRODUCTLINE, "");
        common.twoDownKeyAndEnter();

        common.logPrint("Step:: Adding the Product Group");
        common.assertElementDisplayed(PRODUCTGROUP);
        common.click(PRODUCTGROUP);
        common.type(PRODUCTGROUP, "");
        common.twoDownKeyAndEnter();

        common.logPrint("Step:: Adding the Product Class");
        common.assertElementDisplayed(PRODUCTCLASS);
        common.click(PRODUCTCLASS);
        common.type(PRODUCTCLASS, "");
        common.twoDownKeyAndEnter();

        common.logPrint("Step:: Adding the Product Class");
        common.assertElementDisplayed(PRODUCTTYPE);
        common.click(PRODUCTTYPE);
        common.type(PRODUCTTYPE, "");
        common.twoDownKeyAndEnter();

        common.logPrint("Step :: Adding Short name");
        common.waitUntilElementToBeVisible(PRODUCTSHORTNAME);
        common.type(PRODUCTSHORTNAME, common.fakeName());

        common.logPrint("Step :: Adding Product name");
        common.waitUntilElementToBeVisible(PRODUCTNAME);
        common.type(PRODUCTNAME, common.fakeName());

        common.logPrint("Step:: Adding the Product Packing Type");
        common.assertElementDisplayed(PRODUCTPACKINGTYPE);
        common.click(PRODUCTPACKINGTYPE);
        common.type(PRODUCTPACKINGTYPE, "");
        common.twoDownKeyAndEnter();

        common.logPrint("Step :: Adding Product Ref Code");
        common.waitUntilElementToBeVisible(PRODUCTCODEREF);
        common.type(PRODUCTCODEREF, "1234");

        WebElement ProdType = driver.findElement(By.xpath(PRODUCTNEW));
        ProdType.click();

        common.logPrint("Step:: Adding the Product HSN");
        common.assertElementDisplayed(PRODUCTHSN);
        common.click(PRODUCTHSN);
        common.type(PRODUCTHSN, "");
        common.twoDownKeyAndEnter();

        common.logPrint("Step:: Adding the Product PTR");
        common.assertElementDisplayed(PRODUCTPTR);
        common.click(PRODUCTPTR);
        common.type(PRODUCTPTR, "");
        common.twoDownKeyAndEnter();

        common.logPrint("Step :: Adding Product GST");
        common.waitUntilElementToBeVisible(PRODUCTGST);
        common.type(PRODUCTGST, "12");

        common.logPrint("Step :: Adding Product MRP");
        common.waitUntilElementToBeVisible(PRODUCTMRP);
        common.type(PRODUCTMRP, "100");

        common.logPrint("Step :: Adding Product Content");
        common.waitUntilElementToBeVisible(PRODUCTCONTENT);
        common.type(PRODUCTCONTENT, "Adding Product Content");

        String returnedName = driver.findElement(By.xpath(PRODUCTNAME)).getAttribute("value");

        common.logPrint("Step :: Clicking the Save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.logPrint("Step :: Searching newly added product");
        common.searchAndValidate(returnedName);

        return returnedName;
        }

        catch (NoSuchElementException e) {
            common.logPrint("Error: Element not found - " + e.getMessage());
            throw new RuntimeException("Failed to add doctor vendor due to missing element", e);
        } catch (TimeoutException e) {
            common.logPrint("Error: Operation timed out - " + e.getMessage());
            throw new RuntimeException("Failed to add doctor vendor due to timeout", e);
        } catch (ElementClickInterceptedException e) {
            common.logPrint("Error: Element click intercepted - " + e.getMessage());
            throw new RuntimeException("Failed to add doctor vendor due to click interception", e);
        } catch (StaleElementReferenceException e) {
            common.logPrint("Error: Stale element reference - " + e.getMessage());
            throw new RuntimeException("Failed to add doctor vendor due to stale element", e);
        } catch (RuntimeException e) {
            common.logPrint("Error:" + e.getMessage());
            throw new RuntimeException("Fail, e");
        } catch (Exception e) {
            common.logPrint("Unexpected error: " + e.getMessage());
            throw new RuntimeException("Failed to add doctor vendor due to unexpected error", e);
        }
    }
    public void editAProduct(){

        String addedProduct = addANewProduct();

        common.searchAndValidate(addedProduct);

        common.selectCheckBox(PRODUCTCB);

        common.click(PRODUCTEDIT);

        common.pause(2);

        common.logPrint("Step :: Editing Short name");
        common.waitUntilElementToBeVisible(PRODUCTSHORTNAME);
        String productShortName = driver.findElement(By.xpath(PRODUCTSHORTNAME)).getAttribute("value");
        common.pause(1);
        common.type(PRODUCTSHORTNAME, common.generateRandomChars(5));

        common.logPrint("Step :: Clicking the Save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.searchAndValidate(addedProduct);

        common.pause(1);
        String productShortName1 = driver.findElement(By.xpath(PRODUCTSHORTNAMETEXT)).getText();

        if (productShortName1.equals(productShortName))
        {
            common.logPrint("Didn't Edit");
        } else if (!productShortName1.equals(productShortName))
        {
            common.logPrint("Product Short name Changed from "+productShortName+" To "+productShortName1+" Successfully");
            common.logPrint("Successfully Edited");
        }
    }
    public void deleteAProduct(){

        String addedProduct = addANewProduct();

        common.searchAndValidate(addedProduct);

        common.selectCheckBox(PRODUCTCB);

        common.click(PRODUCTDELETE);

        common.click(PRODUCTDELETEYES);
        common.pause(1);

        common.assertElementDisplayed(DeletedSuccessfully);

        common.logPrint("Product "+ addedProduct + " Deleted Successfully");
    }
    public String addANewCompProduct() {

        try {

            common.logPrint("Step:: Click on the admin panel menu");
            common.assertElementDisplayed(ADMINPANELMENU);
            common.click(ADMINPANELMENU);

            common.logPrint("Step:: Click on the Product Menu");
            common.assertElementDisplayed(MASTERPRODUCT);
            common.click(MASTERPRODUCT);

            common.logPrint("Step:: Click on the Competitor Product Menu");
            common.assertElementDisplayed(COMPPRODUCT);
            common.click(COMPPRODUCT);

            common.logPrint("Step:: Click on the Competitor Product add button");
            common.assertElementDisplayed(PRODUCTADD);
            common.click(PRODUCTADD);

            common.logPrint("Step:: Adding Competitor product");
            common.assertElementDisplayed(COMPPRODUCTNAME);
            common.click(COMPPRODUCTNAME);
            common.type(COMPPRODUCTNAME,"");
            common.twoDownKeyAndEnter();

            common.logPrint("Step:: Adding Our product");
            common.assertElementDisplayed(OUTRODUCTNAME);
            common.click(OUTRODUCTNAME);
            common.type(OUTRODUCTNAME,"");
            common.twoDownKeyAndEnter();

            common.logPrint("Step:: Adding the Product Divison");
            common.assertElementDisplayed(PRODUCTDIV);
            common.click(PRODUCTDIV);
            common.type(PRODUCTDIV, "BIOS DERMA");
            common.twoDownKeyAndEnter();

            common.logPrint("Step:: Adding the Product Drug Head");
            common.assertElementDisplayed(PRODUCTDRUGHEAD);
            common.click(PRODUCTDRUGHEAD);
            common.type(PRODUCTDRUGHEAD, "");
            common.twoDownKeyAndEnter();

            common.logPrint("Step:: Adding the Product Line");
            common.assertElementDisplayed(PRODUCTLINE);
            common.click(PRODUCTLINE);
            common.type(PRODUCTLINE, "");
            common.twoDownKeyAndEnter();

            common.logPrint("Step:: Adding the Product Group");
            common.assertElementDisplayed(PRODUCTGROUP);
            common.click(PRODUCTGROUP);
            common.type(PRODUCTGROUP, "");
            common.twoDownKeyAndEnter();

            common.logPrint("Step:: Adding the Product Class");
            common.assertElementDisplayed(PRODUCTCLASS);
            common.click(PRODUCTCLASS);
            common.type(PRODUCTCLASS, "");
            common.twoDownKeyAndEnter();

            common.logPrint("Step:: Adding the Product Class");
            common.assertElementDisplayed(PRODUCTTYPE);
            common.click(PRODUCTTYPE);
            common.type(PRODUCTTYPE, "");
            common.twoDownKeyAndEnter();

            common.logPrint("Step :: Adding Short name");
            common.waitUntilElementToBeVisible(PRODUCTSHORTNAME);
            common.type(PRODUCTSHORTNAME, common.fakeName());

            common.logPrint("Step :: Adding Product name");
            common.waitUntilElementToBeVisible(PRODUCTNAME);
            common.type(PRODUCTNAME, common.fakeName());

            common.logPrint("Step:: Adding the Product Packing Type");
            common.assertElementDisplayed(PRODUCTPACKINGTYPE);
            common.click(PRODUCTPACKINGTYPE);
            common.type(PRODUCTPACKINGTYPE, "");
            common.twoDownKeyAndEnter();

            common.logPrint("Step :: Adding Product Ref Code");
            common.waitUntilElementToBeVisible(PRODUCTCODEREF);
            common.type(PRODUCTCODEREF, "1234");

            WebElement ProdType = driver.findElement(By.xpath(PRODUCTNEW));
            ProdType.click();

            common.logPrint("Step:: Adding the Product HSN");
            common.assertElementDisplayed(PRODUCTHSN);
            common.click(PRODUCTHSN);
            common.type(PRODUCTHSN, "");
            common.twoDownKeyAndEnter();

            common.logPrint("Step:: Adding the Product PTR");
            common.assertElementDisplayed(PRODUCTPTR);
            common.click(PRODUCTPTR);
            common.type(PRODUCTPTR, "");
            common.twoDownKeyAndEnter();

            common.logPrint("Step :: Adding Product GST");
            common.waitUntilElementToBeVisible(PRODUCTGST);
            common.type(PRODUCTGST, "12");

            common.logPrint("Step :: Adding Product MRP");
            common.waitUntilElementToBeVisible(PRODUCTMRP);
            common.type(PRODUCTMRP, "100");

            common.logPrint("Step :: Adding Product Content");
            common.waitUntilElementToBeVisible(PRODUCTCONTENT);
            common.type(PRODUCTCONTENT, "Adding Product Content");

            String returnedName = driver.findElement(By.xpath(PRODUCTNAME)).getAttribute("value");

            common.logPrint("Step :: Clicking the Save button");
            common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
            common.click(SAVEBUTTON);

            common.logPrint("Step :: Searching newly added product");
            common.searchAndValidate(returnedName);

            return returnedName;
        }

        catch (NoSuchElementException e) {
            common.logPrint("Error: Element not found - " + e.getMessage());
            throw new RuntimeException("Failed to add doctor vendor due to missing element", e);
        } catch (TimeoutException e) {
            common.logPrint("Error: Operation timed out - " + e.getMessage());
            throw new RuntimeException("Failed to add doctor vendor due to timeout", e);
        } catch (ElementClickInterceptedException e) {
            common.logPrint("Error: Element click intercepted - " + e.getMessage());
            throw new RuntimeException("Failed to add doctor vendor due to click interception", e);
        } catch (StaleElementReferenceException e) {
            common.logPrint("Error: Stale element reference - " + e.getMessage());
            throw new RuntimeException("Failed to add doctor vendor due to stale element", e);
        } catch (RuntimeException e) {
            common.logPrint("Error:" + e.getMessage());
            throw new RuntimeException("Fail, e");
        } catch (Exception e) {
            common.logPrint("Unexpected error: " + e.getMessage());
            throw new RuntimeException("Failed to add doctor vendor due to unexpected error", e);
        }
    }
    public void editACompProduct(){

        String addedProduct = addANewCompProduct();

        common.searchAndValidate(addedProduct);

        common.selectCheckBox(PRODUCTCB);

        common.click(PRODUCTEDIT);

        common.pause(2);

        common.logPrint("Step :: Editing Short name");
        common.waitUntilElementToBeVisible(PRODUCTSHORTNAME);
        String productShortName = driver.findElement(By.xpath(PRODUCTSHORTNAME)).getAttribute("value");
        common.pause(1);
        common.type(PRODUCTSHORTNAME, common.generateRandomChars(5));

        common.logPrint("Step :: Clicking the Save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.searchAndValidate(addedProduct);

        common.pause(1);
        String productShortName1 = driver.findElement(By.xpath(PRODUCTSHORTNAMETEXT)).getText();

        if (productShortName1.equals(productShortName))
        {
            common.logPrint("Didn't Edit");
        } else if (!productShortName1.equals(productShortName))
        {
            common.logPrint("Product Short name Changed from "+productShortName+" To "+productShortName1+" Successfully");
            common.logPrint("Successfully Edited");
        }
    }
    public void deleteACompProduct(){

        String addedProduct = addANewCompProduct();

        common.searchAndValidate(addedProduct);

        common.selectCheckBox(PRODUCTCB);

        common.click(PRODUCTDELETE);

        common.click(PRODUCTDELETEYES);
        common.pause(1);

        common.assertElementDisplayed(DeletedSuccessfully);

        common.logPrint("Product "+ addedProduct + " Deleted Successfully");
    }


}


