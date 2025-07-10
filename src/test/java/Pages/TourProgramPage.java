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

    public void redirectsToDailyTourPlan(){

        common.logPrint("Step:: Click on the Tour plan menu");
        common.waitUntilElementToBeVisible(By.xpath(TOURPLANMENU));
        common.click(TOURPLANMENU);

        common.logPrint("Step:: Click on the Tour plan menu");
        common.waitUntilElementToBeVisible(By.xpath(DAILYTOURPLANMENU));
        common.click(DAILYTOURPLANMENU);
    }

    public void redirectsToLeavePage(){

        common.logPrint("Step:: Click on the Tour plan menu");
        common.waitUntilElementToBeVisible(By.xpath(TOURPLANMENU));
        common.click(TOURPLANMENU);

        common.logPrint("Step:: Click on the Leave menu");
        common.waitUntilElementToBeVisible(By.xpath(LEAVEMENU));
        common.click(LEAVEMENU);
    }

    public void redirectsToExpenseModule(){

        common.logPrint("Step:: Click on the Tour Program menu");
        common.waitUntilElementToBeVisible(By.xpath(TOURPROGRAMMENU));
        common.click(TOURPROGRAMMENU);

        common.logPrint("Step:: Click on the Expense module");
        common.waitUntilElementToBeVisible(By.xpath(EXPENSEMENU));
        common.click(EXPENSEMENU);

    }

    public void redirectsToDoctorAvailabilityPage(){

        common.logPrint("Step:: Click on the Approval menu");
        common.waitUntilElementToBeVisible(By.xpath(APPROVALMENU));
        common.click(APPROVALMENU);

        common.logPrint("Step:: Click on the Doctor tour plan");
        common.waitUntilElementToBeVisible(By.xpath(DOCTORAPPROVALAVAILABILITY));
        common.click(DOCTORAPPROVALAVAILABILITY);

    }


    public String[] createDoctorAvailability(){

        redirectsToDoctorAvailabilityPage();

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
        common.logPrint("Selected doctor name is: "+ drName);

        common.logPrint("Step:: Create date for the Doctor availability");
        String currentDate = common.generateDate("future", null, null);
        //String endDate = common.generateDate("future", null, null);

        common.logPrint("Entered date is: "+currentDate);

        common.logPrint("Step:: Enter current date");
        common.waitUntilElementToBeVisible(By.xpath(LEAVESTARTDATE));
        common.type(LEAVESTARTDATE, currentDate);

        common.logPrint("Step:: Enter End date");
        common.waitUntilElementToBeVisible(By.xpath(LEAVEENDDATE));
        common.type(LEAVEENDDATE, currentDate);

        common.logPrint("Step:: Click on the save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        return new String[] {drName, currentDate};
    }

    public void approvedDoctorAvailabilityRequestFromManager(String name, String date){

        redirectsToDoctorAvailabilityPage();

        common.pause(1);

        common.logPrint("Step:: Select first checkbox");
        common.pause(1);
        common.selectCheckBox(FIRSTCHECKBOXAPPROVE);

        common.waitUntilElementToBeVisible(By.xpath("(//tr//td[contains(.,'"+name.toLowerCase()+"')])[1]"));
        String xpath = "(//tr//td[contains(.,'"+name.toLowerCase()+"')])[1]";
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

    public void verifyDoctorAvailabilityInDailyTourPlan(String name, String date){

        redirectsToDailyTourPlan();

        common.logPrint("Step:: Click on the add button");
        common.waitUntilElementsToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Before date converted: "+ date);

        common.logPrint("Convert date format from DD/MM/YYYY to MM/DD/yyyy");
        String convertedDate = common.convertDateFormat(date);

        common.logPrint("After date is converted: "+convertedDate);

        common.logPrint("Step:: Enter date in the plan date.");
        common.waitUntilElementsToBeVisible(By.xpath(TOURPLANDATEINP));
        common.type(TOURPLANDATEINP, date);

        common.logPrint("Step:: Enter the doctor name in the doctor dropdown");
        common.waitUntilElementsToBeVisible(By.xpath(DOCTORINPDAILYPLAN));
        common.type(DOCTORINPDAILYPLAN, name);

    }

    public String[] createExpense(){

        redirectsToExpenseModule();

        common.logPrint("Step:: Click on the Add button");
        common.waitUntilElementsToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step:: Create date for the Doctor availability");
        String expenseDate = common.generateDate("past", null, null);

        common.logPrint("Entered date is: "+ expenseDate);

        common.logPrint("Step:: Enter Expense date");
        common.waitUntilElementToBeVisible(By.xpath(EXPENSEDATEINP));
        common.selectRandomValueFromDropdown(EXPENSEDATEINP, 5);

        common.logPrint("Step:: Click on the Expense type dropdown");
        common.waitUntilElementToBeVisible(By.xpath(EXPENSETYPEDRP));
        common.click(EXPENSETYPEDRP);
        common.downKeyAndEnter();

        String getExpenseName = common.findElement(EXPENSETYPEDRP).getAttribute("value");
        common.logPrint("Selected expense is: "+getExpenseName);

        String amount = common.generateRandomNumberString(4);
        common.logPrint("Step:: Enter amount of expense in the amount field");
        common.waitUntilElementToBeVisible(By.xpath(AMOUNTINP));
        common.type(AMOUNTINP, amount);

        String note = common.GenerateParagraph(6);
        common.logPrint("Step:: Enter note for the expense");
        common.waitUntilElementToBeVisible(By.xpath(NOTETEXTAREA));
        common.type(NOTETEXTAREA, note);

        String file = "\\1.JPG";
        String pathToSend = System.getProperty("user.dir")+file;
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

    public void verifyExpenseIsCreatedAndShowingAsPending(String date, String amount, String name ){

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
        common.logPrint("Get expense name is: "+getExpenseName);
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

    public String[] addHalfLeave(){

        redirectsToLeavePage();

        common.logPrint("Step:: Click on the add button");
        common.waitUntilElementsToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step:: Select half day checkbox");
        common.pause(1);
        common.selectCheckBox(HALFDAYCHECKBOX);

        common.logPrint("Step:: Select the Leave type from dropdown");
        common.waitUntilElementsToBeVisible(By.xpath(LEAVETYPEINP));

        common.click(LEAVETYPEINP);
        common.pause(1);
        common.downKeyAndEnter();

        String leaveDate = common.generateDate("future", null, null);
        common.logPrint("Step:: Enter leave date");
        common.waitUntilElementToBeVisible(By.xpath(FROMDATEINP));
        common.type(FROMDATEINP, leaveDate);

        String reason = common.GenerateParagraph(10);
        common.logPrint("Step:: Enter guideline followed remark");
        common.waitUntilElementToBeVisible(By.xpath(REASONINP));
        common.type(REASONINP, reason);

        common.logPrint("Step:: Click on the save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.logPrint("Step:: Check validation is displayed");
        common.assertElementDisplayed(AddedSuccessfully);

        return new String[] {leaveDate, reason};
    }

    public void verifyLeaveIsAddedSuccessfullyAndShowingAsPending(String name) {

        common.logPrint("Step:: Search name in the search field");
        common.waitUntilElementToBeVisible(By.xpath(SEARCHFIELD));
        common.type(SEARCHFIELD, name);

        common.pause(1);
        common.logPrint("Step:: Verify the status is showing as pending");
        common.waitUntilElementToBeVisible(By.xpath(PENDINGSTATUS));
        common.assertElementPresent(PENDINGSTATUS);}

    public void  createDailyTourPlan() {

            redirectsToDailyTourPlan();

            common.logPrint("Step :: Clicking the add Daily Tour Plan Button");
            common.waitUntilElementToBeVisible(By.xpath(PRODUCTADD));
            common.click(PRODUCTADD);

            common.logPrint("Step :: Adding the daily tour plan date");
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.TAB).perform();

            String date = "10-07";
            common.pause(1);

            common.type(DAILYTOURPLANDATE, date);

            actions.sendKeys(Keys.DOWN).perform();

            common.logPrint("Step:: Selecting Route");
            common.waitUntilElementsToBeVisible(By.xpath(DAILYTOURPLANROUTE));
            common.type(DAILYTOURPLANROUTE, "");
            common.twoDownKeyAndEnter();

            common.logPrint("Step:: Selecting Sub Route");
            common.waitUntilElementsToBeVisible(By.xpath(DAILYTOURPLANSUBROUTE));
            common.type(DAILYTOURPLANSUBROUTE, "");
            common.twoDownKeyAndEnter();

            common.logPrint("Step :: Selecting Selecting Doctor");
//        common.waitUntilElementsToBeVisible(By.xpath());

        }



    }

