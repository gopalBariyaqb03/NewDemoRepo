package Tests;

import Config.ReadProperties;
import Utils.BasePage;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.util.Locale;

public class HolidaysTest extends BasePage {

    @Test
    public void verifyHolidaysIsCreatedAndShowingInTheAllUsers() throws ParseException {
        loginWithDirectorCredential();
        String holidayName = common.generateRandomChars(10);
        holidaysPage.createHolidayUsingAdminCredencials(holidayName);
        holidaysPage.verifyHolidayInTheMrUser(holidayName);
        holidaysPage.verifyHolidayInTheASMUser(holidayName);
        holidaysPage.verifyHolidayInTheRSMUser(holidayName);
        String holidayUpdatedName = holidayName+"autoupdate";
        holidaysPage.verifyUpdatedHolidayName(holidayName,holidayUpdatedName);
    }
}