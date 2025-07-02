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

    public void createDoctorAvailibility(){

        common.logPrint("Step:: Click on the Tour Program menu");
        common.waitUntilElementToBeVisible(By.xpath(TOURPROGRAMMENU));
        common.click(TOURPROGRAMMENU);

        common.logPrint("Step:: Click on the Doctor menu");
        common.waitUntilElementToBeVisible(By.xpath(DOCTORMENU));
        common.click(DOCTORMENU);

        common.logPrint("Step:: Click on the ADD button");
        common.waitUntilElementToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step:: Click on the Doctor list dropdown and select first doctor");
        common.waitUntilElementToBeVisible(By.xpath(DOCTORDROPDOWNICN));
        common.click(DOCTORDROPDOWNICN);
        common.pause(1);
        common.downKeyAndEnter();

        common.logPrint("Step:: Create date for the Doctor availability");
        String currentDate = common.generateDate("next", null, null);
        String endDate = common.generateDate("next", null, null);

        common.logPrint("Step:: Enter current date");
        common.waitUntilElementToBeVisible(By.xpath(LEAVESTARTDATE));
        common.type(LEAVESTARTDATE, currentDate);

        common.logPrint("Step:: Enter End date");
        common.waitUntilElementToBeVisible(By.xpath(LEAVEENDDATE));
        common.type(LEAVEENDDATE, endDate);

        common.logPrint("Step:: Click on the save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

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