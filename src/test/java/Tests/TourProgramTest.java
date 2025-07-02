package Tests;

import Config.ReadProperties;
import Utils.BasePage;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.util.Locale;

public class TourProgramTest extends BasePage {

    @Test
    public void verifyDailyTourPlanFunctionality(){
        loginWithMRCredential();
        tourProgramPage.verifyDailyTourPlanFunctionality();
    }

    @Test
    public void verifyDoctorAvailabilityScenario(){
        loginWithDirectorCredential();
        //tourProgramPage.createDoctorAvailibility();

    }

}