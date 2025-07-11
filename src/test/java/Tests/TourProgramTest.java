package Tests;

import Config.ReadProperties;
import Utils.BasePage;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

    @Test
    public void verifyAddExpenseScenario(){
        loginWithMRCredential();
        String[] expenseValue = tourProgramPage.createExpense();
        String expenseDate = expenseValue[0];
        String amount = expenseValue[1];
        String expenseName = expenseValue[2];
        tourProgramPage.verifyExpenseIsCreatedAndShowingAsPending(expenseDate, amount, expenseName);
    }

    @Test
    public void addLeave(){
        loginWithMRCredential();
        String[] leaveInfo = tourProgramPage.addHalfLeave();
        String leaveDate = leaveInfo[0];
        String leaveReason = leaveInfo[1];
        tourProgramPage.verifyLeaveIsAddedSuccessfullyAndShowingAsPending(leaveDate);
    }

    @Test
    public void fileReader() throws IOException {

        FileReader reader = new FileReader("C:\\Main_Folder\\Diffrent files\\automation.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);

        String line;
        while((line = bufferedReader.readLine()) !=null){
            common.logPrint(line);
        }
    }

    @Test
    public void createDailyTourPlanTest(){
        loginWithMRCredential();
        tourProgramPage.createDailyTourPlan(2,2,2, 3);
    }



}