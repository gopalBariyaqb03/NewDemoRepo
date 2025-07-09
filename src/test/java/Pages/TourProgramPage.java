package Pages;

import Config.ReadProperties;
import Utils.Common;
import Utils.Locators;
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

    public void redirectsToDoctorAvailability(){

        common.logPrint("Step:: Click on the Tour Program menu");
        common.waitUntilElementToBeVisible(By.xpath(TOURPROGRAMMENU));
        common.click(TOURPROGRAMMENU);

        common.logPrint("Step:: Click on the Doctor availability menu");
        common.waitUntilElementToBeVisible(By.xpath(DOCTORMENU));
        common.click(DOCTORMENU);

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

        redirectsToDoctorAvailability();

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

        common.logPrint("Convert date format from DD/MM/YYYY to MM/DD/yyyy");
        String convertedDate = common.convertDateFormat(date);

        common.logPrint("Step:: Enter date in the plan date.");
        common.waitUntilElementsToBeVisible(By.xpath(TOURPLANDATEINP));
        common.type(TOURPLANDATEINP, convertedDate);

        common.logPrint("Step:: Enter the doctor name in the doctor dropdown");
        common.waitUntilElementsToBeVisible(By.xpath(DOCTORINPDAILYPLAN));
        common.type(DOCTORINPDAILYPLAN, name);

    }

}