package Tests;

import Config.ReadProperties;
import Utils.BasePage;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.Locale;

public class AttributesTest extends BasePage {

    @Test
    public void createAttributesForDoctor(){
        loginWithDirectorCredential();
        attributesPage.createDoctorDegreeType();
        attributesPage.createDoctorGuidelinesType();
        attributesPage.createEntertainmentType();
        attributesPage.createEntertainmentActivityType();
        attributesPage.createHospitalRoleType();
        attributesPage.createDoctorAreaOfInterestType();
        attributesPage.createVendorType();
        attributesPage.createAchievementType();
        attributesPage.createFeesType();
        attributesPage.createConferenceAndWebinarAttendedType();
        attributesPage.createConferencesAndWebinarSubjectType();
        attributesPage.createRelationType();
    }

    @Test
    public void createAttributesForChemist(){
        loginWithDirectorCredential();
        //attributesPage.createChemistCategory();
        //attributesPage.createChemistContactPerson();
        attributesPage.createChemistCategoryType();
    }

    @Test
    public void createAttributesForHospital(){
        loginWithDirectorCredential();
        attributesPage.createHospitalContactPerson();
    }

    @Test
    public void resetAllAttributes(){
        attributesPage.createDoctorDegreeType();
    }

    @Test
    public void deleteAllAttributes(){
    }

    @Test
    public void verifyAllAttributesEmpacts(){
    }

}