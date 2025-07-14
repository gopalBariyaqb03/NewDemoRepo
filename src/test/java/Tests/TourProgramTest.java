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
        String Reason = expenseValue[1];
        String expenseType = expenseValue[2];
        tourProgramPage.verifyExpenseIsCreatedAndShowingAsPending(expenseDate, Reason, expenseType);
    }

    @Test
    public void approveLeaveScenario(){
        loginWithMRCredential();
        String[] leaveInfo = tourProgramPage.addHalfLeave();
        String leaveDate = leaveInfo[0];
        String leaveReason = leaveInfo[1];
        String leaveType = leaveInfo[2];
        tourProgramPage.verifyLeaveIsAddedSuccessfullyAndShowingAsPending(leaveReason );
        loginWithASMCredential();
        tourProgramPage.approveLeaveByAsm(leaveDate, leaveReason,leaveType);
        loginWithMRCredential();
        tourProgramPage.verifyLeaveIsAddedSuccessfullyAndShowingAsApprove(leaveReason);
    }

    @Test
    public void rejectLeaveScenario(){
        loginWithMRCredential();
        String[] leaveInfo = tourProgramPage.addHalfLeave();
        String leaveDate = leaveInfo[0];
        String leaveReason = leaveInfo[1];
        String leaveType = leaveInfo[2];
        tourProgramPage.verifyLeaveIsAddedSuccessfullyAndShowingAsPending(leaveReason );
        loginWithASMCredential();
        tourProgramPage.RejectLeaveManager(leaveDate, leaveReason,leaveType);
        loginWithMRCredential();
        tourProgramPage.verifyLeaveIsAddedSuccessfullyAndShowingAsReject(leaveReason);
    }

    @Test
    public void deleteLeaveScenario(){
        loginWithMRCredential();
        String[] leaveInfo = tourProgramPage.addHalfLeave();
        String leaveDate = leaveInfo[0];
        String leaveReason = leaveInfo[1];
        String leaveType = leaveInfo[2];
        tourProgramPage.redirectsToLeavePage();
        tourProgramPage.verifyLeaveIsAddedSuccessfullyAndShowingAsPending(leaveReason );
        loginWithASMCredential();
        tourProgramPage.redirectsToLeavePage();
        tourProgramPage.verifyLeaveIsAddedSuccessfullyAndShowingAsPending(leaveReason);
        loginWithMRCredential();
        tourProgramPage.deleteLeaveAndCheckItsRemove(leaveReason);
        loginWithASMCredential();
        tourProgramPage.redirectsToLeavePage();
        tourProgramPage.verifyLeaveIsAddedSuccessfullyAndShowingAsPending(leaveReason);
    }

    @Test
    public void createDailyTourPlanTest(){
        loginWithMRCredential();
        tourProgramPage.createDailyTourPlan(2,2,2, 3);
    }


}