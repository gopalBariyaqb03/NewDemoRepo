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

    public void verifyDailyTourPlanFunctionality(){

        common.logPrint("Step:: Click on the Tour plan menu");
        common.waitUntilElementToBeVisible(By.xpath(TOURPLANMENU));
        common.click(TOURPLANMENU);

        common.logPrint("Step:: Click on the Tour plan menu");
        common.waitUntilElementToBeVisible(By.xpath(MONTHLYTOURPLAN));
        common.click(MONTHLYTOURPLAN);
    }

    public void redirectsToDoctorAvailability(){

        common.logPrint("Step:: Click on the Tour Program menu");
        common.waitUntilElementToBeVisible(By.xpath(TOURPROGRAMMENU));
        common.click(TOURPROGRAMMENU);

        common.logPrint("Step:: Click on the Doctor availability menu");
        common.waitUntilElementToBeVisible(By.xpath(DOCTORMENU));
        common.click(DOCTORMENU);

    }

    public void redirectsToTourPlan(){

        common.logPrint("Step:: Click on the Tour Program menu");
        common.waitUntilElementToBeVisible(By.xpath(TOURPROGRAMMENU));
        common.click(TOURPROGRAMMENU);

        common.logPrint("Step:: Click on the Doctor tour plan");
        common.waitUntilElementToBeVisible(By.xpath(DAILYTOURPLANMENU));
        common.click(DAILYTOURPLANMENU);

    }


    public String[] createDoctorAvailability(){

        redirectsToDoctorAvailability();

        common.logPrint("Step:: Click on the ADD button");
        common.waitUntilElementToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step:: Click on the Doctor list dropdown and select first doctor");
        common.waitUntilElementToBeVisible(By.xpath(DOCTORDROPDOWNICN));
        common.click(DOCTORDROPDOWNICN);
        common.pause(1);
        common.downKeyAndEnter();

        common.pause(1);
        common.waitUntilElementToBeVisible(By.xpath(DOCTORVALUEINP));

        String drName = common.findElement(DOCTORVALUEINP).getAttribute("value");

        common.logPrint("Step:: Create date for the Doctor availability");
        String currentDate = common.generateDate("future", null, null);
        //String endDate = common.generateDate("future", null, null);

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

        redirectsToDoctorAvailability();

        common.logPrint("Step:: Enter Start date");
        common.waitUntilElementToBeVisible(By.xpath(DOCTORSTARTDATE));
        common.type(DOCTORSTARTDATE, date);

        common.logPrint("Step:: Enter End date");
        common.waitUntilElementToBeVisible(By.xpath(DOCTORENDDATE));
        common.type(DOCTORENDDATE, date);
        common.pause(1);
        common.click(DOCTORENDDATE);

        // You may need to adjust this XPath depending on the calendar HTML structure
        List<WebElement> calendarDates = driver.findElements(By.xpath("//td[not(contains(@class, 'disabled'))]"));

        for (WebElement datea : calendarDates) {
            if (datea.getText().equals(datea)) {
                common.pause(2);
                datea.click();
                break;
            }
        }

    }

    public void createDailyTourPlan(){

        common.logPrint("Step:: Click on the Tour Program menu");
        common.waitUntilElementToBeVisible(By.xpath(TOURPROGRAMMENU));
        common.click(TOURPROGRAMMENU);

        common.logPrint("Step:: Click on the Tour Program menu");
        common.waitUntilElementToBeVisible(By.xpath(DAILYTOURPLANMENU));
        common.click(DAILYTOURPLANMENU);

    }

}