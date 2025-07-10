package Tests;

import Config.ReadProperties;
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
       mappingPage.VerifyAddDoctorChemistMapping();
        mappingPage.VerifyViewDocChemMapping();
        mappingPage.VerifyEditDocChemMapping();
        mappingPage.VerifyCancelDeleteDocChemMappingAndSearch();
        mappingPage.VerifyDeleteDocChemMappingAndSearch();
    }

    public void AddDoctorProductMapping()
    {


    }

}