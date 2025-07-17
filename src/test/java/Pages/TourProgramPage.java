package Pages;

import Utils.Common;
import Utils.Locators;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class TourProgramPage extends Locators {
    Common common = new Common(driver);

    public TourProgramPage(WebDriver driver) {
        super(driver);
    }

    public void redirectsToApproval() {
        common.logPrint("Step:: Click on the Approval menu");
        common.waitUntilElementToBeVisible(By.xpath(APPROVALMENU));
        common.click(APPROVALMENU);
    }

    public void redirectsToDailyTourPlan() {

        common.logPrint("Step:: Click on the Tour plan menu");
        common.waitUntilElementToBeVisible(By.xpath(TOURPLANMENU));
        common.click(TOURPLANMENU);

        common.logPrint("Step:: Click on the Tour plan menu");
        common.waitUntilElementToBeVisible(By.xpath(DAILYTOURPLANMENU));
        common.click(DAILYTOURPLANMENU);
    }

    public void redirectsToLeavePage() {

        common.logPrint("Step:: Click on the Tour plan menu");
        common.waitUntilElementToBeVisible(By.xpath(TOURPLANMENU));
        common.click(TOURPLANMENU);

        common.logPrint("Step:: Click on the Leave menu");
        common.waitUntilElementToBeVisible(By.xpath(LEAVEMENU));
        common.click(LEAVEMENU);
    }

    public void redirectsToExpenseModule() {

        common.logPrint("Step:: Click on the Tour Program menu");
        common.waitUntilElementToBeVisible(By.xpath(TOURPROGRAMMENU));
        common.click(TOURPROGRAMMENU);

        common.logPrint("Step:: Click on the Expense module");
        common.waitUntilElementToBeVisible(By.xpath(EXPENSEMENU));
        common.click(EXPENSEMENU);

    }

    public void redirectsToDoctorAvailabilityPage() {

        common.logPrint("Step:: Click on the Approval menu");
        common.waitUntilElementToBeVisible(By.xpath(APPROVALMENU));
        common.click(APPROVALMENU);

        common.logPrint("Step:: Click on the Doctor tour plan");
        common.waitUntilElementToBeVisible(By.xpath(DOCTORAPPROVALAVAILABILITY));
        common.click(DOCTORAPPROVALAVAILABILITY);

    }

    public void redirectsToDoctorAvailabilityPageForMR() {

        common.logPrint("Step:: Click on the tour program menu");
        common.waitUntilElementToBeVisible(By.xpath(TOURPLANMENU));
        common.click(TOURPLANMENU);

        common.logPrint("Step:: Click on the Doctor tour plan");
        common.waitUntilElementToBeVisible(By.xpath(DOCTORAPPROVALAVAILABILITY));
        common.click(DOCTORAPPROVALAVAILABILITY);

    }

    public void redirectsToLeaveApprovePage() {

        common.logPrint("Step:: Click on the Approval menu");
        common.waitUntilElementToBeVisible(By.xpath(APPROVALMENU));
        common.click(APPROVALMENU);

        common.logPrint("Step:: Click on the leave approval menu");
        common.waitUntilElementToBeVisible(By.xpath(LEAVEMENU));
        common.click(LEAVEMENU);
    }

    public void addDate(String sentDate, String dateElement) {
        common.logPrint("Step :: Adding the daily tour plan date");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).perform();

        common.pause(1);

        common.waitUntilElementToBeVisible(dateElement);
        common.type(dateElement, sentDate);

        actions.sendKeys(Keys.DOWN).perform();
    }

    public String[] createDoctorAvailability() {

        redirectsToDoctorAvailabilityPageForMR();

        common.logPrint("Step:: Click on the ADD button");
        common.waitUntilElementToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step:: Click on the Doctor list dropdown and select first doctor");
        common.waitUntilElementToBeVisible(By.xpath(DOCTORDROPDOWNICN));
        common.selectRandomValueFromDropdown(DOCTORDROPDOWNICN, 10);

//        common.click(DOCTORDROPDOWNICN);
//        common.pause(1);
//        common.downKeyAndEnter();
//
//        common.pause(1);
        common.waitUntilElementToBeVisible(By.xpath(DOCTORVALUEINP));
        String drName = common.findElement(DOCTORVALUEINP).getAttribute("value");
        common.logPrint("Selected doctor name is: " + drName);

        common.logPrint("Step:: Create date for the Doctor availability");
        String currentDate = common.generateDate("future", null, null);
        //String endDate = common.generateDate("future", null, null);

        common.logPrint("Entered date is: " + currentDate);

        common.logPrint("Step:: Enter current date");
        common.waitUntilElementToBeVisible(By.xpath(LEAVESTARTDATE));
        common.type(LEAVESTARTDATE, currentDate);

        common.logPrint("Step:: Enter End date");
        common.waitUntilElementToBeVisible(By.xpath(LEAVEENDDATE));
        common.type(LEAVEENDDATE, currentDate);

        common.logPrint("Step:: Click on the save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        return new String[]{drName, currentDate};
    }

    public void approvedDoctorAvailabilityRequestFromManager(String name, String date) {

        redirectsToDoctorAvailabilityPage();

        common.pause(1);

        common.logPrint("Step:: Select first checkbox");
        common.pause(1);
        common.selectCheckBox(FIRSTCHECKBOXAPPROVE);

        common.waitUntilElementToBeVisible(By.xpath("(//tr//td[contains(.,'" + name.toLowerCase() + "')])[1]"));
        String xpath = "(//tr//td[contains(.,'" + name.toLowerCase() + "')])[1]";
        String getDrName = common.getText(xpath);
        common.logPrint(getDrName);
        common.assertTwoValuesAreEqual(getDrName.toLowerCase(), name.toLowerCase());

        common.logPrint("Verify both the name are equal");

        common.logPrint("Step:: Click on the Approval button");
        common.waitUntilElementToBeVisible(By.xpath(APPROVEBTN));
        common.click(APPROVEBTN);

        common.logPrint("Step:: Check validation is displayed");
        common.assertElementDisplayed(DoctorApprovedSuccess);


    }

    public void verifyDoctorAvailabilityInDailyTourPlan(String name, String date) {

        redirectsToDailyTourPlan();

        common.logPrint("Step:: Click on the add button");
        common.waitUntilElementsToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Before date converted: " + date);

        common.logPrint("Convert date format from DD/MM/YYYY to MM/DD/yyyy");
        String convertedDate = common.convertDateFormat(date);

        common.logPrint("After date is converted: " + convertedDate);

        common.logPrint("Step:: Enter date in the plan date.");
        common.waitUntilElementsToBeVisible(By.xpath(TOURPLANDATEINP));
        common.type(TOURPLANDATEINP, date);

        common.logPrint("Step:: Enter the doctor name in the doctor dropdown");
        common.waitUntilElementsToBeVisible(By.xpath(DOCTORINPDAILYPLAN));
        common.type(DOCTORINPDAILYPLAN, name);


    }

    public String[] createExpense() {

        redirectsToExpenseModule();

        common.logPrint("Step:: Click on the Add button");
        common.waitUntilElementsToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step:: Create date for the Doctor availability");
        String expenseDate = common.generateDate("past", null, null);

        common.logPrint("Entered date is: " + expenseDate);

        common.logPrint("Step:: Enter Expense date");
        common.waitUntilElementToBeVisible(By.xpath(EXPENSEDATEINP));
        common.selectRandomValueFromDropdown(EXPENSEDATEINP, 5);

        common.logPrint("Step:: Click on the Expense type dropdown");
        common.waitUntilElementToBeVisible(By.xpath(EXPENSETYPEDRP));
        common.click(EXPENSETYPEDRP);
        common.downKeyAndEnter();

        String getExpenseName = common.findElement(EXPENSETYPEDRP).getAttribute("value");
        common.logPrint("Selected expense is: " + getExpenseName);

        String amount = common.generateRandomNumberString(4);
        common.logPrint("Step:: Enter amount of expense in the amount field");
        common.waitUntilElementToBeVisible(By.xpath(AMOUNTINP));
        common.type(AMOUNTINP, amount);

        String note = common.GenerateParagraph(6);
        common.logPrint("Step:: Enter note for the expense");
        common.waitUntilElementToBeVisible(By.xpath(NOTETEXTAREA));
        common.type(NOTETEXTAREA, note);

        String file = "\\1.JPG";
        String pathToSend = System.getProperty("user.dir") + file;
        common.logPrint(pathToSend);
        common.logPrint("Step:: Upload invoice image for the expense");
        common.pause(3);
        //common.waitUntilElementToBeVisible(BILLIMAGEINP);
        WebElement imageUpload = common.findElement(BILLIMAGEINP);
        imageUpload.sendKeys(pathToSend);

        common.pause(2);

        common.logPrint("Step:: Click on the save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.logPrint("Step:: Check validation is displayed");
        common.assertElementDisplayed(AddedSuccessfully);

        return new String[]{expenseDate, amount, getExpenseName};

    }

    public void verifyExpenseIsCreatedAndShowingAsPending(String date, String amount, String name) {

        common.logPrint("Step:: Search name in the search field");
        common.waitUntilElementToBeVisible(By.xpath(SEARCHFIELD));
        common.type(SEARCHFIELD, amount);

        common.pause(1);
        common.logPrint("Step:: Verify the status is showing as pending");
        common.waitUntilElementToBeVisible(By.xpath(PENDINGSTATUS));
        common.assertElementPresent(PENDINGSTATUS);

        common.pause(1);

        common.logPrint("Step:: Verify expense type is showing properly");
        common.waitUntilElementToBeVisible(By.xpath(GETEXPENSETYPE));
        String getExpenseName = common.getText(GETEXPENSETYPE);
        common.logPrint("Get expense name is: " + getExpenseName);
        common.assertTwoValuesAreEqual(name.toLowerCase(), getExpenseName.toLowerCase());

        common.logPrint("Step:: Verify expense date is showing properly");
        common.waitUntilElementToBeVisible(By.xpath(PENDINGSTATUS));
        String getExpenseDate = common.getText(GETEXPENSEDATE);
        common.assertTwoValuesAreEqual(date, getExpenseDate);

        common.logPrint("Step:: Verify expense amount showing properly");
        common.waitUntilElementToBeVisible(By.xpath(GETEXPENSEAMOUNT));
        String getAmount = common.getText(GETEXPENSEAMOUNT);
        common.assertTwoValuesAreEqual(amount, getAmount);

    }

    public String[] addHalfLeave() {

        redirectsToLeavePage();

        common.logPrint("Step:: Click on the add button");
        common.waitUntilElementsToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step:: Select half day checkbox");
        common.pause(1);
        common.selectCheckBox(HALFDAYCHECKBOX);

        common.logPrint("Step:: Select the Leave type from dropdown");
        common.waitUntilElementsToBeVisible(By.xpath(LEAVETYPEINP));
        common.selectRandomValueFromDropdown(LEAVETYPEINP, 6);

        String leaveType = common.findElement(LEAVETYPEINP).getAttribute("value");
        common.logPrint("The selected leave type is: " + leaveType);

        String leaveDate = common.generateDate("future", null, null);
        common.logPrint("Step:: Enter leave date");
        common.waitUntilElementToBeVisible(By.xpath(FROMDATEINP));
        common.type(FROMDATEINP, leaveDate);

        String reason = common.GenerateParagraph(1);
        common.logPrint("Step:: Enter guideline followed remark");
        common.waitUntilElementToBeVisible(By.xpath(REASONINP));
        common.type(REASONINP, reason);

        common.logPrint("Step:: Click on the save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);
//
//        if(common.){
//            String updatedLeave = common.generateDate("future", null, null);
//            common.logPrint("Step:: Enter leave date");
//            common.waitUntilElementToBeVisible(By.xpath(FROMDATEINP)).clear();
//            common.type(FROMDATEINP, updatedLeave);
//        }

        common.logPrint("Step:: Check validation is displayed");
        common.assertElementDisplayed(AddedSuccessfully);

        return new String[]{leaveDate, reason, leaveType};
    }

    public void verifyLeaveIsAddedSuccessfullyAndShowingAsPending(String reason) {

        common.logPrint("Step :: Verify that leave is showing in the table");
        common.waitUntilElementToBeVisible(By.xpath(REASONINTABLE));
        String getReason = common.getText(REASONINTABLE);

        common.assertTwoValuesAreEqual(getReason, reason);

        common.pause(1);
        common.logPrint("Step:: Verify the status is showing as pending");
        common.waitUntilElementToBeVisible(By.xpath(PENDINGSTATUS));

        common.assertElementPresent(PENDINGSTATUS);
    }

    public void verifyLeaveIsAddedSuccessfullyAndShowingAsApprove(String reason) {

        redirectsToLeavePage();

        common.logPrint("Step :: Verify that leave is showing in the table");
        common.waitUntilElementToBeVisible(By.xpath(REASONINTABLE));
        String getReason = common.getText(REASONINTABLE);

        common.assertTwoValuesAreEqual(getReason, reason);

        common.pause(1);
        common.logPrint("Step:: Verify the status is showing as pending");
        common.waitUntilElementToBeVisible(By.xpath(APPROVESTATUS));
        common.assertElementPresent(APPROVESTATUS);
    }

    public void verifyLeaveIsAddedSuccessfullyAndShowingAsReject(String reason) {

        redirectsToLeavePage();

        common.logPrint("Step :: Verify that leave is showing in the table");
        common.waitUntilElementToBeVisible(By.xpath(REASONINTABLE));
        String getReason = common.getText(REASONINTABLE);

        common.assertTwoValuesAreEqual(getReason, reason);

        common.pause(1);
        common.logPrint("Step:: Verify the status is showing as Reject");
        common.waitUntilElementToBeVisible(By.xpath(REJECTSTATUS));
        common.assertElementPresent(REJECTSTATUS);
    }

    public void approveLeaveByAsm(String date, String leaveReason, String leaveType) {

        redirectsToLeaveApprovePage();

        common.refreshPage();

        common.pause(3);
        common.logPrint("Step:: Enter guideline followed remark");
        common.waitUntilElementToBeVisible(By.xpath(USERDROPDOWN));
        common.click(USERDROPDOWN);
        common.pause(1);
        common.downKeyAndEnter();

        String reasonXpath = "//td[contains(.,'" + leaveReason + "')]";

        if (common.isElementNotDisplayed(reasonXpath)) {
            common.refreshPage();
        }

        common.logPrint("Step :: Verify that leave is showing in the table");
        common.waitUntilElementToBeVisible(By.xpath(reasonXpath));
        String getReason = common.getText(reasonXpath);

        common.assertTwoValuesAreEqual(getReason, leaveReason);

        common.logPrint("Step:: Select first checkbox");
        common.pause(2);
        common.selectCheckBox(FIRSTCHECKBOXLEAVE);

        common.logPrint("Step:: Click on the approve button");
        common.waitUntilElementToBeVisible(By.xpath(APPROVEBTN));
        common.click(APPROVEBTN);

        common.logPrint("Step:: Check validation is displayed");
        common.assertElementDisplayed(ApproveSuccessfully);
    }

    public void RejectLeaveManager(String date, String leaveReason, String leaveType) {

        redirectsToLeaveApprovePage();

        common.refreshPage();

        common.pause(3);
        common.logPrint("Step:: Enter guideline followed remark");
        common.waitUntilElementToBeVisible(By.xpath(USERDROPDOWN));
        common.click(USERDROPDOWN);
        common.pause(1);
        common.downKeyAndEnter();

        String reasonXpath = "//td[contains(.,'" + leaveReason + "')]";

        if (common.isElementNotDisplayed(reasonXpath)) {
            common.refreshPage();
        }

        common.logPrint("Step :: Verify that leave is showing in the table");
        common.waitUntilElementToBeVisible(By.xpath(reasonXpath));
        String getReason = common.getText(reasonXpath);

        common.assertTwoValuesAreEqual(getReason, leaveReason);

        common.logPrint("Step:: Select first checkbox");
        common.pause(2);
        common.selectCheckBox(FIRSTCHECKBOXLEAVE);

        common.logPrint("Step:: Click on the reject button");
        common.waitUntilElementToBeVisible(By.xpath(REJECTBTN));
        common.click(REJECTBTN);

        String reason = common.GenerateParagraph(1);
        common.logPrint("Step:: Enter Reason for the rejection");
        common.waitUntilElementToBeVisible(By.xpath(REASONOFLEAVEREJECT));
        common.type(REASONOFLEAVEREJECT, reason);

        common.logPrint("Step:: Click on the Submit button");
        common.waitUntilElementToBeVisible(By.xpath(SUBMITBTN));
        common.click(SUBMITBTN);

        common.assertElementPresent(RejectSuccessfully);
    }

    public void createDailyTourPlan(int doctorCount, int chemistCount, int stockistCount, int hospitalCount) {

        redirectsToDailyTourPlan();

        common.logPrint("Step :: Clicking the add Daily Tour Plan Button");
        common.waitUntilElementToBeVisible(By.xpath(PRODUCTADD));
        common.click(PRODUCTADD);

        addDate("10-07", DAILYTOURPLANDATE);

        common.logPrint("Step:: Selecting Route");
        common.waitUntilElementsToBeVisible(By.xpath(DAILYTOURPLANROUTE));
        common.type(DAILYTOURPLANROUTE, "");
        common.twoDownKeyAndEnter();

        common.logPrint("Step:: Selecting Sub Route");
        common.waitUntilElementsToBeVisible(By.xpath(DAILYTOURPLANSUBROUTE));
        common.type(DAILYTOURPLANSUBROUTE, "");
        common.twoDownKeyAndEnter();

        for (int i = 0; i < doctorCount; i++) {
            common.logPrint("Step :: Selecting Doctor " + (i + 1));
            common.waitUntilElementsToBeVisible(By.xpath(DAILYSELECTDOCTOR));
            common.click(DAILYSELECTDOCTOR);
            common.pressDownKeysByArgument(i + 2);

            common.logPrint("Step :: Selecting Doctor visit time " + (i + 1));
            common.waitUntilElementsToBeVisible(By.xpath(DAILYSELECTDOCTORTIME));
            common.click(DAILYSELECTDOCTORTIME);
            common.type(DAILYSELECTDOCTORTIME, "10-10-AM");
            common.pressDownKeysByArgument(i + 2);

            common.logPrint("Step :: Adding Doctor " + (i + 1));
            common.waitUntilElementsToBeVisible(By.xpath(DAILYSELECTDOCTORADD));
            common.click(DAILYSELECTDOCTORADD);

            common.pause(1);
        }

        // Add Chemists
        for (int i = 0; i < chemistCount; i++) {
            common.logPrint("Step :: Selecting Chemist " + (i + 1));
            common.waitUntilElementsToBeVisible(By.xpath(DAILYSELECTCHEMIST));
            common.click(DAILYSELECTCHEMIST);
            common.pressDownKeysByArgument(i + 2);

            common.logPrint("Step :: Selecting Chemist visit time " + (i + 1));
            common.waitUntilElementsToBeVisible(By.xpath(DAILYSELECTCHEMISTTIME));
            common.click(DAILYSELECTCHEMISTTIME);
            common.type(DAILYSELECTCHEMISTTIME, "11-10-AM");
            common.pressDownKeysByArgument(i + 2);

            common.logPrint("Step :: Adding Chemist " + (i + 1));
            common.waitUntilElementsToBeVisible(By.xpath(DAILYSELECTCHEMISTADD));
            common.click(DAILYSELECTCHEMISTADD);
            common.pause(1);
        }

        // Add Stockists
        for (int i = 0; i < stockistCount; i++) {
            common.logPrint("Step :: Selecting Stockist " + (i + 1));
            common.waitUntilElementsToBeVisible(By.xpath(DAILYSELECTSTOCKIST));
            common.click(DAILYSELECTSTOCKIST);
            common.pressDownKeysByArgument(i + 2);

            common.logPrint("Step :: Selecting Stockist visit time " + (i + 1));
            common.waitUntilElementsToBeVisible(By.xpath(DAILYSELECTSTOCKISTTIME));
            common.click(DAILYSELECTSTOCKISTTIME);
            common.type(DAILYSELECTSTOCKISTTIME, "01-10-PM");
            common.pressDownKeysByArgument(i + 2);

            common.logPrint("Step :: Adding Stockist " + (i + 1));
            common.waitUntilElementsToBeVisible(By.xpath(DAILYSELECTSTOCKISTADD));
            common.click(DAILYSELECTSTOCKISTADD);
            common.pause(1);
        }
        for (int i = 0; i < hospitalCount; i++) {
            common.logPrint("Step :: Selecting Hospital " + (i + 1));
            common.waitUntilElementsToBeVisible(By.xpath(DAILYSELECTHOSPITAL));
            common.click(DAILYSELECTHOSPITAL);
            common.pressDownKeysByArgument(i + 2);

            common.logPrint("Step :: Selecting Hospital visit time " + (i + 1));
            common.waitUntilElementsToBeVisible(By.xpath(DAILYSELECTHOSPITALTIME));
            common.click(DAILYSELECTHOSPITALTIME);
            common.type(DAILYSELECTHOSPITALTIME, "01-10-PM");
            common.pressDownKeysByArgument(i + 2);

            common.logPrint("Step :: Adding Hospital " + (i + 1));
            common.waitUntilElementsToBeVisible(By.xpath(DAILYSELECTHOSPITALADD));
            common.click(DAILYSELECTHOSPITALADD);
            common.pause(1);
        }

        common.pause(2);

        common.waitUntilElementToBeVisible(DAILYSAVE);
        common.click(DAILYSAVE);

        common.pause(2);

        common.loginWithASMCredential();

        redirectsToApproval();

        common.logPrint("Step :: Clicking the Daily tour plan approval");
        common.waitUntilElementToBeVisible(DAILYAPPROVAL);
        common.click(DAILYAPPROVAL);

        common.selectCheckBox(DAILYAPPROVALCB);

        common.waitUntilElementToBeVisible(By.xpath(DAILYAPPROVALBUTTON));
        common.click(DAILYAPPROVALBUTTON);
    }

    public void deleteLeaveAndCheckItsRemove (String leaveReason){

        redirectsToLeaveApprovePage();

        common.refreshPage();

        common.pause(3);
        common.logPrint("Step:: Enter guideline followed remark");
        common.waitUntilElementToBeVisible(By.xpath(USERDROPDOWN));
        common.click(USERDROPDOWN);
        common.pause(1);
        common.downKeyAndEnter();

        String reasonXpath = "//td[contains(.,'" + leaveReason + "')]";

        if (common.isElementNotDisplayed(reasonXpath)) {
            common.refreshPage();
        }

        common.logPrint("Step :: Verify that leave is showing in the table");
        common.waitUntilElementToBeVisible(By.xpath(reasonXpath));
        String getReason = common.getText(reasonXpath);

        common.assertTwoValuesAreEqual(getReason, leaveReason);

        common.logPrint("Step:: Select first checkbox");
        common.pause(2);
        common.selectCheckBox(FIRSTCHECKBOXLEAVE);

        common.logPrint("Step:: Click on the Delete button");
        common.waitUntilElementToBeVisible(By.xpath(DELETEBTN));
        common.click(DELETEBTN);

        common.logPrint("Step:: Click on the Delete button on confirmation pop-up");
        common.waitUntilElementToBeVisible(By.xpath(DELETEBTN2));
        common.click(DELETEBTN2);

        common.logPrint("Step:: Check validation is displayed");
        common.assertElementDisplayed(DeletedSuccessfully);
    }
}