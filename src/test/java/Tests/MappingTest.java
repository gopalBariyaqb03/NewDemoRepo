package Tests;

import Config.ReadProperties;
import Pages.MappingPage;
import Utils.BasePage;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.util.Locale;

public class MappingTest extends BasePage {

    @Test

    public void AddDoctorChemMaping()
    {
        loginWithDirectorCredential();
        String entereDoctor = mappingPage.VerifyAddDoctorChemistMapping();


        mappingPage.VerifyAddDoctorChemistMapping();
        mappingPage.VerifyViewDocChemMapping();
        mappingPage.VerifyEditDocChemMapping();
        mappingPage.VerifyCancelDeleteDocChemMappingAndSearch();
        mappingPage.VerifyDeleteDocChemMappingAndSearch(entereDoctor);
    }
    @Test

    public void AddDoctorProductMapping()
    {
        loginWithDirectorCredential();
        mappingPage.VerifyAddDoctorProductMapping();
        mappingPage.VerifyViewDoctorProductMapping();



    }

}