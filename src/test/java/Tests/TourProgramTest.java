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
        //tourProgramPage.verifyDailyTourPlanFunctionality();
    }

    @Test
    public void verifyDoctorAvailabilityScenario(){
        common.logPrint("Verify doctor availability scenario");
        loginWithMRCredential();
        String drName[] = tourProgramPage.createDoctorAvailability();
        String Name = drName[0];
        String Date = drName[1];
        loginWithASMCredential();
        tourProgramPage.approvedDoctorAvailabilityRequestFromManager(Name, Date);
        loginWithMRCredential();
        tourProgramPage.verifyDoctorAvailabilityInDailyTourPlan(Name, Date);

    }
}