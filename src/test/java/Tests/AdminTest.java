package Tests;

import Config.ReadProperties;
import Utils.BasePage;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.util.Locale;

public class AdminTest extends BasePage {

    @Test
    public void verifyCreateAndApprovedDoctorScenario(){
        loginWithMRCredential();
        String drName = adminPage.verifyCreateDoctorCreateFunctionality();
        adminPage.verifyEntityIsCreatedIsShowingInTheTableAndItStatusIsPending(drName);
        adminPage.verifyDrApprovalForTheAsmUser(drName);
        loginWithMRCredential();
        adminPage.redeirectToDoctorPage();
        adminPage.verifyDoctorIsCreatedIsShowingInTheTableAndItStatusIsApproval(drName);
    }

    @Test
    public void updateDoctorScenario(){
        loginWithMRCredential();
        long time = System.currentTimeMillis();
        common.logPrint(String.valueOf(time));
        String drName = adminPage.verifyCreateDoctorCreateFunctionality();
        adminPage.verifyEntityIsCreatedIsShowingInTheTableAndItStatusIsPending(drName);
        adminPage.verifyDrApprovalForTheAsmUser(drName);
        loginWithMRCredential();
        adminPage.redeirectToDoctorPage();
        adminPage.verifyDoctorIsCreatedIsShowingInTheTableAndItStatusIsApproval(drName);
        loginWithMRCredential();
        String[] doctorInfo = adminPage.updateTheDoctor(drName);
        String updatedName = doctorInfo[0];
        String updatedMobile = doctorInfo[1];
        adminPage.verifyEntityIsCreatedIsShowingInTheTableAndItStatusIsPending(updatedName);
        adminPage.loginWithASMCredential();
        adminPage.redeirectToDoctorPage();
        adminPage.verifyEntityIsCreatedIsShowingInTheTableAndItStatusIsPending(updatedName);
        adminPage.verifyDoctorIsUpdated(updatedName,updatedMobile);
    }

    @Test
    public void deleteDoctorScenario(){
        loginWithMRCredential();
        String drName = adminPage.verifyCreateDoctorCreateFunctionality();
        adminPage.verifyEntityIsCreatedIsShowingInTheTableAndItStatusIsPending(drName);
        adminPage.deleteDoctorFromTheList(drName);
        common.logPrint("Step:: Verify delete request is showing in the Directors account");
        adminPage.approvedDeleteRequestFromTheDirectorsUser(drName.toLowerCase());
        loginWithMRCredential();
        adminPage.verifyDoctorRemoveFromTheList(drName);
    }

    @Test
    public void verifyCreateAndApprovedChemistScenario(){
        loginWithMRCredential();
        String chemistName = adminPage.createChemistAndApprove();
        adminPage.verifyEntityIsCreatedIsShowingInTheTableAndItStatusIsPending(chemistName);
        adminPage.verifyChemistApprovedForTheAsmUser(chemistName);
        loginWithMRCredential();
        adminPage.redirectsToChemistPage();
        adminPage.verifyDoctorIsCreatedIsShowingInTheTableAndItStatusIsApproval(chemistName);
    }

    @Test
    public void verifyUpdateChemistScenario(){
        common.logPrint("Step:: Verify that chemist is updated successfully");
        loginWithMRCredential();
        String chemistName = adminPage.createChemistAndApprove();
        adminPage.verifyEntityIsCreatedIsShowingInTheTableAndItStatusIsPending(chemistName);
        adminPage.verifyChemistApprovedForTheAsmUser(chemistName);
        loginWithMRCredential();
        adminPage.redirectsToChemistPage();
        adminPage.verifyDoctorIsCreatedIsShowingInTheTableAndItStatusIsApproval(chemistName);
        loginWithMRCredential();
        String[] updateChemist = adminPage.updateTheChemist(chemistName);
        String updatedName = updateChemist[0];
        String updatedMobile = updateChemist[1];
        loginWithASMCredential();
        adminPage.redirectsToChemistPage();
        adminPage.verifyEntityIsCreatedIsShowingInTheTableAndItStatusIsPending(updatedName);
        adminPage.verifyDoctorIsUpdated(updatedName, updatedMobile);
    }

    @Test
    public void verifyCreateAndApprovedStockiestScenario(){
        loginWithMRCredential();
        String stockiestName = adminPage.createStockiestApproval();
        adminPage.verifyEntityIsCreatedIsShowingInTheTableAndItStatusIsPending(stockiestName);
        adminPage.verifyStockiestApprovedForTheAsmUser(stockiestName);
        loginWithMRCredential();
        adminPage.redirectsToStockiestPage();
        adminPage.verifyDoctorIsCreatedIsShowingInTheTableAndItStatusIsApproval(stockiestName);
    }

    @Test
    public void verifyValidationMessageForDoctorWithDirector(){
        //loginWithDirectorCredential();
        //loginWithRSMCredential();
        //loginWithASMCredential();
        //loginWithSuperAdminInHolyMade();
        loginWithDirectorCredential();
        adminPage.verifyValidationMessageForDoctorCreationWithDirector();
        adminPage.verifyValidationMessageForChemistCreationWithDirector();
        adminPage.verifyValidationMessageForStockistCreationWithDirector();
        adminPage.verifyValidationMessageForHospitalCreationWithDirector();
        adminPage.verifyValidationMessageForProductCreationWithDirector();
        adminPage.verifyValidationMessageForEmployeeCreationWithDirector();
        adminPage.verifyValidationMessageForAccountListModule();
        adminPage.verifyValidationMessageForRoleModule();
        adminPage.verifyValidationMessageForDesignationModule();
    }

    @Test
    public void verifyAdminPanelWithDirectors(){
        loginWithDirectorCredential();
        adminPage.verifyDoctorCreationFieldAndLabelsForLeadEntity();
        adminPage.verifyChemistCreationFieldAndLabelsForLeadEntity();
        adminPage.verifyStockistCreationFieldAndLabelsForLeadEntity();
        adminPage.verifyAccountCreationFieldsAndLabels();
        adminPage.verifyRoleCreationFieldsAndLabels();
        adminPage.verifyProductCreationFieldsAndLabels();
        adminPage.verifyEmployeeCreationFieldsAndLabels();
        adminPage.verifyLabelAndFieldsInTheDesignationPage();
    }

    @Test
    public void verifyAdminPanelWithRSM(){
        loginWithRSMCredential();
        adminPage.verifyDoctorCreationFieldAndLabelsForLeadEntity();
    }

    @Test
    public void verifyAdminPanelWithASM(){
        loginWithASMCredential();
        adminPage.verifyDoctorCreationFieldAndLabelsForLeadEntity();
    }

    @Test
    public void verifyAdminPanelWithMR(){
        loginWithMRCredential();
        adminPage.verifyDoctorCreationFieldAndLabels();
    }

    //Code for the new development
    @Test
    public void verifyAllTheAccountIsCreatingSuccessfully(){
        loginWithDirectorCredential();
        homePage.AddRoutForTheUsers("Mina Rsm","Mina Asm", "Mina MR", "https://v3qa.aisante.in/");
    }

    @Test
    public void createAllTheAddinationDetail(){
        loginWithDirectorCredential();
        //adminPage.addDegree();
        //adminPage.addAreaOfInterest();
        //adminPage.addGuidelinesFollowed();
        //adminPage.addConferenceAndSpeker();
        //adminPage.addWeekendsAndVacation();
        //adminPage.addFamilyFriendDetailInfo();
        //adminPage.addCollegeMateDetailInfo();
        adminPage.addSocialActivityDetailInfo();
    }

}